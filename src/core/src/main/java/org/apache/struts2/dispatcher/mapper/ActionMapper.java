/*
 * $Id: ActionMapper.java 1367870 2012-08-01 07:11:09Z lukaszlenart $
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

package org.apache.struts2.dispatcher.mapper;

import com.opensymphony.xwork2.config.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * <!-- START SNIPPET: javadoc -->
 *
 * The ActionMapper interface provides a mapping between HTTP requests and action invocation requests and vice-versa.
 * ActionMapper�ӿ��ṩ��һ��HTTP������action��������֮����ӳ�䣬��֮��Ȼ
 * <p/>
 * When given an HttpServletRequest, the ActionMapper may return null if no action invocation request matches,
 * or it may return an {@link ActionMapping} that describes an action invocation for the framework to try.
 * ������һ��HttpServletRequest�����û��action����������֮ƥ�䣬ActionMapper���᷵��null��
    ���������ܻ�Ϊ��ܳ��Է���һ������action invocation��ActionMapping��
 * <p/>
 * The ActionMapper is not required to guarantee that the {@link ActionMapping} returned be a real action or otherwise
 * ensure a valid request.
 * Accordingly, most ActionMappers do not need to consult the Struts configuration
 * just to determine if a request should be mapped.
 * <p/>
 * Just as requests can be mapped from HTTP to an action invocation, the opposite is true as well.
 * However, because HTTP requests (when shown in HTTP responses) must be in String form,
 * a String is returned rather than an actual request object.
 *
 * <!-- END SNIPPET: javadoc -->
 */
public interface ActionMapper {

    /**��������HttpServletRequest�����ù�������ȡActionӳ��
     * <p>
     * Expose the ActionMapping for the current request<br/>
     * Ϊ��ǰ������¶ActionMapping
     * @param request The servlet request
     * @param configManager The current configuration manager
     * @return The appropriate action mapping or null if mapping cannot be determined
     * �����ʵ�action mapping�����û��ȷ�е�mapping�򷵻�null
     */
    ActionMapping getMapping(HttpServletRequest request, ConfigurationManager configManager);

    /**����action����ȡActionӳ��
     * Expose the ActionMapping for the specified action name
     *
     * @param actionName The name of the action that may have other information embedded in it
     * @return The appropriate action mapping
     * @since 2.1.1
     */
    ActionMapping getMappingFromActionName(String actionName);

    /**
     * Convert an ActionMapping into a URI string
     *
     * @param mapping The action mapping
     * @return The URI string that represents this mapping
     */
    String getUriFromActionMapping(ActionMapping mapping);
}
