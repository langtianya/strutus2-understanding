/*
 * $Id: RequestUtils.java 651946 2008-04-27 13:41:38Z apetrelli $
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

package org.apache.struts2;

import javax.servlet.http.HttpServletRequest;


/**������ʹ����
 * Request handling utility class.
 */
public class RequestUtils {

    /**
	 * ������ǰ�����servlet path��������servlet�淶(2.2 vs 2.3+)�еĲ���
	 * 
	 * <pre>
	 * �ٶ���Ĺ�������Ϊprojects,�������������������·����
	 * http://127.0.0.1:8080/projects/pages/newForm.jsp
	 * ��ִ���������д�����ӡ�����½���� 1�� System.out.println(request.getContextPath());
	 * ��ӡ�����/projects 2��System.out.println(request.getServletPath());
	 * ��ӡ�����/pages/newForm.jsp 3�� System.out.println(request.getRequestURI());
	 * ��ӡ�����/projects/pages/newForm.jsp 4��
	 * System.out.println(request.getRealPath("/")); JSP servlet
	 * API�ṩ��getRealPath(path)���������ظ�������·������ʵ·�������ת�������򷵻�null��
	 * 
	 * ��ӡ�����C:\Tomcat5.0\webapps\projects\test <> Retrieves the current request
	 * </pre>
	 * servlet path. Deals with differences between servlet specs (2.2 vs 2.3+)
	 *
	 * @param request
	 *            the request
	 * @return the servlet path
	 */
    public static String getServletPath(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        
        String requestUri = request.getRequestURI();
        // Detecting other characters that the servlet container cut off (like anything after ';')
        if (requestUri != null && servletPath != null && !requestUri.endsWith(servletPath)) {
            int pos = requestUri.indexOf(servletPath);
            if (pos > -1) {
                servletPath = requestUri.substring(requestUri.indexOf(servletPath));
            }
        }
        
        if (null != servletPath && !"".equals(servletPath)) {
            return servletPath;
        }
        
        int startIndex = request.getContextPath().equals("") ? 0 : request.getContextPath().length();
        int endIndex = request.getPathInfo() == null ? requestUri.length() : requestUri.lastIndexOf(request.getPathInfo());

        if (startIndex > endIndex) { // this should not happen
            endIndex = startIndex;
        }

        return requestUri.substring(startIndex, endIndex);
    }

}
