/*
 * $Id: ActionContextCleanUp.java 1414400 2012-11-27 21:06:08Z lukaszlenart $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.struts2.dispatcher;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.opensymphony.xwork2.util.profiling.UtilTimerStack;

/**
 * struts2源码分析文章：
 * http://www.cnblogs.com/heartstage/archive/2013/11/22/3437803.html
 * http://blog.knowsky.com/197800.htm
 * 
 * 请求首先通过Filter chain，Filter主要包括ActionContextCleanUp，它主要清理当前线程的ActionContext和Dispatcher
 * <p>
 * 特殊的过滤器设计用来与FilterDispatcher工作、允许方便集成Sitemesh（网站的网）。通常，调整你的过滤器让SiteMesh先走，然后
 * FilterDispatcher排第二是很好的。然而，有时你可能希望访问Struts的功能，包括值栈，从您的Sitemesh装饰。
 * 因为FilterDispatcher清理ActionContext，你的装饰不会获得你想要的数据
 * 通过添加此过滤器，FilterDispatcher就将知道不清理而推迟清理这个过滤器。然后，过滤器的顺序应该是：
 * this filter
 * SiteMesh filter
 * FilterDispatcher
 * 这些过滤器就职责链，一层层处理相应的职责
 * </p>
 *
 * 
 * <!-- SNIPPET（片段;） START: description -->
 * Special filter designed to work with the {@link FilterDispatcher} and allow
 * for easier integration with SiteMesh. Normally, ordering your filters to have
 * SiteMesh go first, and then {@link FilterDispatcher} go second is perfectly fine.
 * However, sometimes you may wish to access Struts features, including the
 * value stack, from within your SiteMesh decorators. Because {@link FilterDispatcher}
 * cleans up the {@link ActionContext}, your decorator won't have access to the
 * data you want.
 * <p/>
 * <p/>
 * By adding this filter, the {@link FilterDispatcher} will know to not clean up and
 * instead defer cleanup to this filter. The ordering of the filters should then be:
 * <p/>
 * <ul>
 * <li>this filter</li>
 * <li>SiteMesh filter</li>
 * <li>{@link FilterDispatcher}</li>
 * </ul>
 * <!-- SNIPPET END: description -->
 *
 *
 * @deprecated Since Struts 2.1.3, use {@link org.apache.struts2.dispatcher.ng.filter.StrutsPrepareFilter} and
 * {@link org.apache.struts2.dispatcher.ng.filter.StrutsExecuteFilter} to use other Servlet filters that need access to
 * the ActionContext
 * @see FilterDispatcher
 * @see Dispatcher
 * @see org.apache.struts2.dispatcher.ng.filter.StrutsPrepareFilter
 * @see org.apache.struts2.dispatcher.ng.filter.StrutsExecuteFilter
 *
 * @version $Date: 2012-11-27 22:06:08 +0100 (Tue, 27 Nov 2012) $ $Id: ActionContextCleanUp.java 1414400 2012-11-27 21:06:08Z lukaszlenart $
 */
public class ActionContextCleanUp implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(ActionContextCleanUp.class);

    /**
     * 递归清理计数器
     */
    private static final String COUNTER = "__cleanup_recursion_counter";

    /**
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

//    	显示过期信息
        showDeprecatedWarning();

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String timerKey = "ActionContextCleanUp_doFilter: ";
        try {
            UtilTimerStack.push(timerKey);

            try {
                Integer count = (Integer)request.getAttribute(COUNTER);
                if (count == null) {
                    count = Integer.valueOf(1);
                }
                else {
                    count = Integer.valueOf(count.intValue()+1);
                }
                request.setAttribute(COUNTER, count);

                //LOG.debug("filtering counter="+count);

                chain.doFilter(request, response);
            } finally {
                int counterVal = ((Integer)request.getAttribute(COUNTER)).intValue();
                counterVal -= 1;
                request.setAttribute(COUNTER, Integer.valueOf(counterVal));
                cleanUp(request);
            }
        }
        finally {
            UtilTimerStack.pop(timerKey);
        }
    }

    /**如果这是最后的执行,清理ThreadLocal的请求
     * Clean up the request of threadlocals if this is the last execution
     *
     * @param req The servlet request
     */
    protected static void cleanUp(ServletRequest req) {
        // should we clean up yet?
        Integer count = (Integer) req.getAttribute(COUNTER);
        if (count != null && count > 0 ) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("skipping cleanup counter="+count);
            }
            return;
        }

        // always dontClean up the thread request, even if an action hasn't been executed
//        总是不清理线程请求，即使一个动作没有被执行
		// 清理当前线程的ActionContext和Dispatcher
		ActionContext.setContext(null);
		Dispatcher.setInstance(null);
    }

    public void destroy() {
    }

    public void init(FilterConfig arg0) throws ServletException {
    }

    /**
     * 显示过期信息
     */
    private void showDeprecatedWarning() {
        String msg =
                "\n\n" +
                "***************************************************************************\n" +
                "*                                 WARNING!!!                              *\n" +
                "*                                                                         *\n" +
                "* >>> ActionContextCleanUp <<< is deprecated! Please use the new filters! *\n" +
                "*                                                                         *\n" +
                "*             This can be a source of unpredictable problems!             *\n" +
                "*                                                                         *\n" +
                "*                Please refer to the docs for more details!               *\n" +
                "*              http://struts.apache.org/2.x/docs/webxml.html              *\n" +
                "*                                                                         *\n" +
                "***************************************************************************\n\n";
        System.out.println(msg);
    }

}
