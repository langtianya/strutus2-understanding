/*
 * Copyright 2002-2007,2009 The Apache Software Foundation.
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

import com.opensymphony.xwork2.interceptor.PreResultListener;
import com.opensymphony.xwork2.util.ValueStack;

import java.io.Serializable;


/**
 * An {@link ActionInvocation} represents the execution state of an {@link Action}. It holds the Interceptors and the Action instance.
 * By repeated re-entrant execution of the <code>invoke()</code> method, initially by the {@link ActionProxy}, then by the Interceptors, the
 * Interceptors are all executed, and then the {@link Action} and the {@link Result}.
 *
 * @author Jason Carreira
 * @see com.opensymphony.xwork2.ActionProxy
 */
public interface ActionInvocation extends Serializable {

    /**获取本ActionInvocation相关的Action
     * Get the Action associated with this ActionInvocation.
     *
     * @return the Action
     */
    Object getAction();

    /**获取是否该ActionInvocation在之前是否被执行过，当action和result已经执行后被设置为true
     * Gets whether this ActionInvocation has executed before.
     * This will be set after the Action and the Result have executed.
     *
     * @return <tt>true</tt> if this ActionInvocation has executed before.
     */
    boolean isExecuted();

    /**
     * 获取ActionInvocation相关的ActionContext。
     * Gets the ActionContext associated with this ActionInvocation. The ActionProxy is
     * responsible for setting this ActionContext onto the ThreadLocal before invoking
     * the ActionInvocation and resetting the old ActionContext afterwards.
     *
     * @return the ActionContext.
     */
    ActionContext getInvocationContext();

    /**获取持有本对象的ActionProxy
     * Get the ActionProxy holding this ActionInvocation.
     *
     * @return the ActionProxy.
     */
    ActionProxy getProxy();

    /**
     * 如果之前本ActionInvocation已经被执行，并且Result是ActionChainResult的一个实例
     * 该方法将走actionchainresults链，直到找到一个非链的结果，它将返回 .
     * 如果actioninvocation结果尚未执行前，结果实例将被创建和填充的结果参数
     * If the ActionInvocation has been executed before and the Result is an instance of {@link ActionChainResult}, this method
     * will walk down the chain of <code>ActionChainResult</code>s until it finds a non-chain result, which will be returned. If the
     * ActionInvocation's result has not been executed before, the Result instance will be created and populated with
     * the result params.
     *
     * @return the result.
     * @throws Exception can be thrown.
     */
    Result getResult() throws Exception;

    /**获取从ActionInvocation返回的结果代码
     * Gets the result code returned from this ActionInvocation.
     *
     * @return the result code
     */
    String getResultCode();

    /**
     * Sets the result code, possibly overriding the one returned by the
     * action.
     * <p/>
     * The "intended" purpose of this method is to allow PreResultListeners to
     * override the result code returned by the Action.
     * <p/>
     * If this method is used before the Action executes, the Action's returned
     * result code will override what was set. However the Action could (if
     * specifically coded to do so) inspect the ActionInvocation to see that
     * someone "upstream" (e.g. an Interceptor) had suggested a value as the
     * result, and it could therefore return the same value itself.
     * <p/>
     * If this method is called between the Action execution and the Result
     * execution, then the value set here will override the result code the
     * action had returned.  Creating an Interceptor that implements
     * {@link PreResultListener} will give you this oportunity.
     * <p/>
     * If this method is called after the Result has been executed, it will
     * have the effect of raising an IllegalStateException.
     *
     * @param resultCode  the result code.
     * @throws IllegalStateException if called after the Result has been executed.
     * @see #isExecuted()
     */
    void setResultCode(String resultCode);

    /**
     * 获取ActionInvocation相关的值栈
     * Gets the ValueStack associated with this ActionInvocation.
     *
     * @return the ValueStack
     */
    ValueStack getStack();

    /**注册PreResultListener。为了在action执行后和结果返回前被通知。属于一个监听者模式
     * Register a {@link PreResultListener} to be notified after the Action is executed and
     * before the Result is executed.
     * <p/>
     * The ActionInvocation implementation must guarantee that listeners will be called in
     * the order in which they are registered.
     * <p/>
     * Listener registration and execution does not need to be thread-safe.
     *
     * @param listener the listener to add.
     */
    void addPreResultListener(PreResultListener listener);

    /**
     * 
               调用在处理本ActionInvocation的下一步。
          <p/>
          如果这里存在多个拦截器，本对象将调用下一个拦截器。
          
		如果拦截选择不短路，ActionInvocation处理并返回自己的返回代码，他们会调用invoke()允许下拦截
		继续执行。如果没有更多的拦截被应用，Action将被执行。
		如果getExecuteResult()方法返回true，结果也执行      
     * Invokes the next step in processing this ActionInvocation.
     * <p/>
     * If there are more Interceptors, this will call the next one. If Interceptors choose not to short-circuit
     * ActionInvocation processing and return their own return code, they will call invoke() to allow the next Interceptor
     * to execute. If there are no more Interceptors to be applied, the Action is executed.
     * If the {@link ActionProxy#getExecuteResult()} method returns <tt>true</tt>, the Result is also executed.
     *
     * @throws Exception can be thrown.
     * @return the return code.
     */
    String invoke() throws Exception;

    /**
	 * 仅仅调用Action（不调用拦截器或结果）。 在罕见的情况下，这是有用的，即拦截/行动/结果的工作流程被确切操纵某些功能的高级用法
	 * <p/>
	 * Invokes only the Action (not Interceptors or Results).
	 * <p/>
	 * This is useful in rare situations where advanced usage with the
	 * interceptor/action/result workflow is being manipulated for certain
	 * functionality.
	 *
	 * @return the return code.
	 * @throws Exception
	 *             can be thrown.
	 */
    String invokeActionOnly() throws Exception;

    /**
     * Sets the action event listener to respond to key action events.
     *
     * @param listener the listener.
     */
    void setActionEventListener(ActionEventListener listener);

    void init(ActionProxy proxy) ;

}
