/*
 * Copyright 2002-2006,2009 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.opensymphony.xwork2;

import com.opensymphony.xwork2.config.ConfigurationException;
import com.opensymphony.xwork2.config.entities.ActionConfig;
import com.opensymphony.xwork2.config.entities.InterceptorMapping;
import com.opensymphony.xwork2.config.entities.ResultConfig;
import com.opensymphony.xwork2.inject.Container;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.interceptor.PreResultListener;
import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.ValueStackFactory;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.opensymphony.xwork2.util.profiling.UtilTimerStack;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * 默认的ActionInvocation实现
 * The Default ActionInvocation implementation
 *
 * @author Rainer Hermanns
 * @author tmjee
 * @version $Date: 2013-01-15 21:58:08 +0100 (Tue, 15 Jan 2013) $ $Id: DefaultActionInvocation.java 1433644 2013-01-15 20:58:08Z lukaszlenart $
 * @see com.opensymphony.xwork2.DefaultActionProxy
 */
public class DefaultActionInvocation implements ActionInvocation {

    private static final long serialVersionUID = -585293628862447329L;

    //static {
    //    if (ObjectFactory.getContinuationPackage() != null) {
    //        continuationHandler = new ContinuationHandler();
    //    }
    //}
    private static final Logger LOG = LoggerFactory.getLogger(DefaultActionInvocation.class);

    /**
     * 空数组常量
     */
    private static final Class[] EMPTY_CLASS_ARRAY   = new Class[0];
    /**
     * 空对象常量
     */
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

    protected Object action;
    
//    action代理
    protected ActionProxy proxy;
//    准备返回Result前会监听到事件
    protected List<PreResultListener> preResultListeners;
    protected Map<String, Object> extraContext;
//    Action上下文
    protected ActionContext invocationContext;
//    拦截器列表
    protected Iterator<InterceptorMapping> interceptors;
//    值栈
    protected ValueStack stack;
//    执行结果
    protected Result result;
    /**
     * 明确的执行结果
     */
    protected Result explicitResult;
//    结果代码
    protected String resultCode;
//    是否在执行
    protected boolean executed = false;
    protected boolean pushAction = true;
    /**
     * 工厂模式，对象工厂。see:代理的工厂，也是工厂模式
     */
    protected ObjectFactory objectFactory;
    /**
     * Action事件监听器，监听者模式
     */
    protected ActionEventListener actionEventListener;
    /**
     * 值栈工厂
     */
    protected ValueStackFactory valueStackFactory;
    /**
     * bean容器
     */
    protected Container container;
    protected UnknownHandlerManager unknownHandlerManager;

    public DefaultActionInvocation(final Map<String, Object> extraContext, final boolean pushAction) {
        DefaultActionInvocation.this.extraContext = extraContext;
        DefaultActionInvocation.this.pushAction = pushAction;
    }

    @Inject
    public void setUnknownHandlerManager(UnknownHandlerManager unknownHandlerManager) {
        this.unknownHandlerManager = unknownHandlerManager;
    }

    @Inject
    public void setValueStackFactory(ValueStackFactory fac) {
        this.valueStackFactory = fac;
    }

    @Inject
    public void setObjectFactory(ObjectFactory fac) {
        this.objectFactory = fac;
    }

    @Inject
    public void setContainer(Container cont) {
        this.container = cont;
    }

    @Inject(required=false)
    public void setActionEventListener(ActionEventListener listener) {
        this.actionEventListener = listener;
    }

    public Object getAction() {
        return action;
    }

    public boolean isExecuted() {
        return executed;
    }

    public ActionContext getInvocationContext() {
        return invocationContext;
    }

    public ActionProxy getProxy() {
        return proxy;
    }

    /**
     * If the DefaultActionInvocation has been executed before and the Result is an instance of ActionChainResult, this method
     * will walk down the chain of ActionChainResults until it finds a non-chain result, which will be returned. If the
     * DefaultActionInvocation's result has not been executed before, the Result instance will be created and populated with
     * the result params.
     *
     * @return a Result instance
     * @throws Exception
     */
    public Result getResult() throws Exception {
        Result returnResult = result;

        // If we've chained to other Actions, we need to find the last result
        while (returnResult instanceof ActionChainResult) {
            ActionProxy aProxy = ((ActionChainResult) returnResult).getProxy();

            if (aProxy != null) {
                Result proxyResult = aProxy.getInvocation().getResult();

                if ((proxyResult != null) && (aProxy.getExecuteResult())) {
                    returnResult = proxyResult;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        return returnResult;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        if (isExecuted())
            throw new IllegalStateException("Result has already been executed.");

        this.resultCode = resultCode;
    }


    public ValueStack getStack() {
        return stack;
    }

    /**
     * Register a com.opensymphony.xwork2.interceptor.PreResultListener to be notified after the Action is executed and before the
     * Result is executed. The ActionInvocation implementation must guarantee that listeners will be called in the order
     * in which they are registered. Listener registration and execution does not need to be thread-safe.
     *
     * @param listener to register
     */
    public void addPreResultListener(PreResultListener listener) {
        if (preResultListeners == null) {
            preResultListeners = new ArrayList<PreResultListener>(1);
        }

        preResultListeners.add(listener);
    }

    public Result createResult() throws Exception {

        if (explicitResult != null) {
            Result ret = explicitResult;
            explicitResult = null;

            return ret;
        }
        ActionConfig config = proxy.getConfig();
        Map<String, ResultConfig> results = config.getResults();

        ResultConfig resultConfig = null;

        try {
            resultConfig = results.get(resultCode);
        } catch (NullPointerException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Got NPE trying to read result configuration for resultCode [#0]", resultCode);
            }
        }
        
        if (resultConfig == null) {
            // If no result is found for the given resultCode, try to get a wildcard '*' match.
            resultConfig = results.get("*");
        }

        if (resultConfig != null) {
            try {
                return objectFactory.buildResult(resultConfig, invocationContext.getContextMap());
            } catch (Exception e) {
                if (LOG.isErrorEnabled()) {
                    LOG.error("There was an exception while instantiating the result of type #0", e, resultConfig.getClassName());
                }
                throw new XWorkException(e, resultConfig);
            }
        } else if (resultCode != null && !Action.NONE.equals(resultCode) && unknownHandlerManager.hasUnknownHandlers()) {
            return unknownHandlerManager.handleUnknownResult(invocationContext, proxy.getActionName(), proxy.getConfig(), resultCode);
        }
        return null;
    }

    /**
     * 调用下一个，类似职责链。返回action的执行结果
     * @throws ConfigurationException If no result can be found with the returned code
     * 如果没有结果可以找到对应返回的代码
     */
    public String invoke() throws Exception {
        String profileKey = "invoke: ";
        try {
            UtilTimerStack.push(profileKey);

            if (executed) {
                throw new IllegalStateException("Action has already executed");
            }
			// 如果还有拦截器，继续调用拦截器，直到调用完拦截器，才调用action.拦截器调用完本身，还会继续调用该invoke方法
			// 类似职责链模式
			if (interceptors.hasNext()) {
//				拦截器映射
				final InterceptorMapping interceptor = interceptors.next();
//				创建每一个拦截器的时间栈名并压入时间栈
				String interceptorMsg = "interceptor: " + interceptor.getName();
                UtilTimerStack.push(interceptorMsg);
                try {
					// 把自己传给拦截器，拦截器执行完后，调自己的invoke方法，如此递归，其实就是比递归多了一层
					resultCode = interceptor.getInterceptor().intercept(DefaultActionInvocation.this);
				}
                finally {
                    UtilTimerStack.pop(interceptorMsg);
                }
                
//                执行action
            } else {
                resultCode = invokeActionOnly();
            }

            // this is needed because the result will be executed, then control will return to the Interceptor, which will
            // return above and flow through again
            if (!executed) {
                if (preResultListeners != null) {
                    for (Object preResultListener : preResultListeners) {
                        PreResultListener listener = (PreResultListener) preResultListener;

                        String _profileKey = "preResultListener: ";
                        try {
                            UtilTimerStack.push(_profileKey);
                            listener.beforeResult(this, resultCode);
                        }
                        finally {
                            UtilTimerStack.pop(_profileKey);
                        }
                    }
                }

                // now execute the result, if we're supposed to
                if (proxy.getExecuteResult()) {
                    executeResult();
                }

                executed = true;
            }

            return resultCode;
        }
        finally {
            UtilTimerStack.pop(profileKey);
        }
    }

    /**
     * @see com.opensymphony.xwork2.ActionInvocation#invokeActionOnly()
     */
    public String invokeActionOnly() throws Exception {
//    	传入action参数调用action
        return invokeAction(getAction(), proxy.getConfig());
    }

    /**根据环境创建action
     * @param contextMap
     */
    protected void createAction(Map<String, Object> contextMap) {
        // load action
        String timerKey = "actionCreate: " + proxy.getActionName();
        try {
            UtilTimerStack.push(timerKey);
            action = objectFactory.buildAction(proxy.getActionName(), proxy.getNamespace(), proxy.getConfig(), contextMap);
        } catch (InstantiationException e) {
            throw new XWorkException("Unable to intantiate Action!", e, proxy.getConfig());
        } catch (IllegalAccessException e) {
            throw new XWorkException("Illegal access to constructor, is it public?", e, proxy.getConfig());
        } catch (Exception e) {
            String gripe;

            if (proxy == null) {
                gripe = "Whoa!  No ActionProxy instance found in current ActionInvocation.  This is bad ... very bad";
            } else if (proxy.getConfig() == null) {
                gripe = "Sheesh.  Where'd that ActionProxy get to?  I can't find it in the current ActionInvocation!?";
            } else if (proxy.getConfig().getClassName() == null) {
                gripe = "No Action defined for '" + proxy.getActionName() + "' in namespace '" + proxy.getNamespace() + "'";
            } else {
                gripe = "Unable to instantiate Action, " + proxy.getConfig().getClassName() + ",  defined for '" + proxy.getActionName() + "' in namespace '" + proxy.getNamespace() + "'";
            }

            gripe += (((" -- " + e.getMessage()) != null) ? e.getMessage() : " [no message in exception]");
            throw new XWorkException(gripe, e, proxy.getConfig());
        } finally {
            UtilTimerStack.pop(timerKey);
        }
     //给监听器激活时间
        if (actionEventListener != null) {
            action = actionEventListener.prepare(action, stack);
        }
    }

    protected Map<String, Object> createContextMap() {
        Map<String, Object> contextMap;

        if ((extraContext != null) && (extraContext.containsKey(ActionContext.VALUE_STACK))) {
            // In case the ValueStack was passed in
            stack = (ValueStack) extraContext.get(ActionContext.VALUE_STACK);

            if (stack == null) {
                throw new IllegalStateException("There was a null Stack set into the extra params.");
            }

            contextMap = stack.getContext();
        } else {
            // create the value stack
            // this also adds the ValueStack to its context
            stack = valueStackFactory.createValueStack();

            // create the action context
            contextMap = stack.getContext();
        }

        // put extraContext in
        if (extraContext != null) {
            contextMap.putAll(extraContext);
        }

        //put this DefaultActionInvocation into the context map
        contextMap.put(ActionContext.ACTION_INVOCATION, this);
        contextMap.put(ActionContext.CONTAINER, container);

        return contextMap;
    }

    /**
     * Uses getResult to get the final Result and executes it
     *
     * @throws ConfigurationException If not result can be found with the returned code
     */
    private void executeResult() throws Exception {
        result = createResult();

        String timerKey = "executeResult: " + getResultCode();
        try {
            UtilTimerStack.push(timerKey);
            if (result != null) {
                result.execute(this);
            } else if (resultCode != null && !Action.NONE.equals(resultCode)) {
                throw new ConfigurationException("No result defined for action " + getAction().getClass().getName()
                        + " and result " + getResultCode(), proxy.getConfig());
            } else {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("No result returned for action " + getAction().getClass().getName() + " at " + proxy.getConfig().getLocation());
                }
            }
        } finally {
            UtilTimerStack.pop(timerKey);
        }
    }

    public void init(ActionProxy proxy) {
        this.proxy = proxy;
        Map<String, Object> contextMap = createContextMap();

        // Setting this so that other classes, like object factories, can use the ActionProxy and other
        // contextual information to operate
        ActionContext actionContext = ActionContext.getContext();

        if (actionContext != null) {
            actionContext.setActionInvocation(this);
        }

        createAction(contextMap);

        if (pushAction) {
            stack.push(action);
            contextMap.put("action", action);
        }

        invocationContext = new ActionContext(contextMap);
        invocationContext.setName(proxy.getActionName());

        // get a new List so we don't get problems with the iterator if someone changes the list
        List<InterceptorMapping> interceptorList = new ArrayList<InterceptorMapping>(proxy.getConfig().getInterceptors());
        interceptors = interceptorList.iterator();
    }

    /**根据action配置调用Action
     * @param action
     * @param actionConfig
     * @return
     * @throws Exception
     */
    protected String invokeAction(Object action, ActionConfig actionConfig) throws Exception {
        String methodName = proxy.getMethod();

        if (LOG.isDebugEnabled()) {
            LOG.debug("Executing action method = " + actionConfig.getMethodName());
        }

        String timerKey = "invokeAction: " + proxy.getActionName();
        try {
			UtilTimerStack.push(timerKey);
			// 方法是否被调用
			boolean methodCalled = false;
			Object methodResult = null;
			// 要执行的方法签名
			Method method = null;
			try {
				// 反射获取调用的方法
				method = getAction().getClass().getMethod(methodName, EMPTY_CLASS_ARRAY);
			} catch (NoSuchMethodException e) {
				// hmm -- OK, try doXxx instead
				try {
					// 拼接doXxx形式方法，进行再次尝试
					String altMethodName = "do" + methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
					method = getAction().getClass().getMethod(altMethodName, EMPTY_CLASS_ARRAY);
				} catch (NoSuchMethodException e1) {
					// well, give the unknown handler a shot
					if (unknownHandlerManager.hasUnknownHandlers()) {
						try {
							methodResult = unknownHandlerManager.handleUnknownMethod(action, methodName);
						    methodCalled = true;
                        } catch (NoSuchMethodException e2) {
                            // throw the original one
                            throw e;
                        }
                    } else {
                        throw e;
                    }
                }
            }

            if (!methodCalled) {
//            	反射调用action方法
                methodResult = method.invoke(action, EMPTY_OBJECT_ARRAY);
            }

            return saveResult(actionConfig, methodResult);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("The " + methodName + "() is not defined in action " + getAction().getClass() + "");
        } catch (InvocationTargetException e) {
            // We try to return the source exception.
            Throwable t = e.getTargetException();

            if (actionEventListener != null) {
                String result = actionEventListener.handleException(t, getStack());
                if (result != null) {
                    return result;
                }
            }
            if (t instanceof Exception) {
                throw (Exception) t;
            } else {
                throw e;
            }
        } finally {
            UtilTimerStack.pop(timerKey);
        }
    }

    /**
	 * 保存结果将被使用 Save the result to be used later.
	 * 
	 * @param actionConfig
	 *            current ActionConfig
	 * @param methodResult
	 *            the result of the action.
	 * @return the result code to process.
	 */
	protected String saveResult(ActionConfig actionConfig, Object methodResult) {
		if (methodResult instanceof Result) {
			this.explicitResult = (Result) methodResult;

			// Wire the result automatically
			// 自动把结果写入到需要注入的地方
			container.inject(explicitResult);
			return null;
		} else {
			return (String) methodResult;
		}
    }

}
