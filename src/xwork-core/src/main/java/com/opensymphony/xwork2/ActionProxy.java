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

import com.opensymphony.xwork2.config.entities.ActionConfig;


/**代理模式，代理Action。
 * ActionProxy是XWork和action之间的一个额外的层，因此，不同的代理是可能的。
*这样的一个例子是一个远程代理，其中XWork和action之间的层可能是RMI或SOAP。
 * ActionProxy is an extra layer between XWork and the action so that different proxies are possible.
 * <p/>
 * An example of this would be a remote proxy, where the layer between XWork and the action might be RMI or SOAP.
 *
 * @author Jason Carreira
 */
public interface ActionProxy {

    /**通过ActionInvocation获取此代理Action实例
     * Gets the Action instance for this Proxy.
     *
     * @return the Action instance
     */
    Object getAction();

    /**获取本对象映射的action名
     * Gets the alias name this ActionProxy is mapped to.
     *
     * @return the alias name
     */
    String getActionName();

    /**
     * 获取构建ActionProxy的ActionConfig<br/>
     * Gets the ActionConfig this ActionProxy is built from.
     *
     * @return the ActionConfig
     */
    ActionConfig getConfig();

    /**
     * Sets whether this ActionProxy should also execute the Result after executing the Action.
     *
     * @param executeResult <tt>true</tt> to also execute the Result.
     */
    void setExecuteResult(boolean executeResult);

    /**取在Action执行后，ActionProxy是否被设置去执行Result
     * Gets the status of whether the ActionProxy is set to execute the Result after the Action is executed.
     *
     * @return the status
     */
    boolean getExecuteResult();

    /**ActionProxy相关的ActionInvocation
     * <p>
     * Gets the ActionInvocation associated with this ActionProxy.
     *
     * @return the ActionInvocation
     */
    ActionInvocation getInvocation();

    /**获取本ActionProxy映射的ActionConfig的命名空间
     * Gets the namespace the ActionConfig for this ActionProxy is mapped to.
     *
     * @return the namespace
     */
    String getNamespace();

    /**执行代理,即执行代理代表的action的某方法。<br>
     * 在调用ActionInvocation之前,将设置ActionContext从ActionInvocation到ActionContext的
     ThreadLocal，然后设置旧的ActionContext到ThreadLocal
     * <p>
     * Execute this ActionProxy. This will set the ActionContext from the ActionInvocation into the ActionContext
     * ThreadLocal before invoking the ActionInvocation, then set the old ActionContext back into the ThreadLocal.
     *
     * @return the result code returned from executing the ActionInvocation
     * @throws Exception can be thrown.
     * @see ActionInvocation
     */
    String execute() throws Exception;

    /**获取将要被执行的action方法，如果没有指定方法，返回null，代表执行默认的execute方法
     * Gets the method name to execute, or <tt>null</tt> if no method has been specified (meaning <code>execute</code> will be invoked).
     *
     * @return the method to execute
     */
    String getMethod();

    /**获取方法的值被初始化的状态，如果是 getMethod()返回的方法不是默认值，将返回true
     * Gets status of the method value's initialization.
     *
     * @return true if the method returned by getMethod() is not a default initializer value.
     */
    boolean isMethodSpecified();
    
}
