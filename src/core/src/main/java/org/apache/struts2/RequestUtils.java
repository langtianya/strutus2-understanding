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


/**请求处理使用类
 * Request handling utility class.
 */
public class RequestUtils {

    /**
	 * 检索当前请求的servlet path。处理在servlet规范(2.2 vs 2.3+)中的差异
	 * 
	 * <pre>
	 * 假定你的工程名称为projects,你在浏览器中输入请求路径：
	 * http://127.0.0.1:8080/projects/pages/newForm.jsp
	 * 则执行下面向行代码后打印出如下结果： 1、 System.out.println(request.getContextPath());
	 * 打印结果：/projects 2、System.out.println(request.getServletPath());
	 * 打印结果：/pages/newForm.jsp 3、 System.out.println(request.getRequestURI());
	 * 打印结果：/projects/pages/newForm.jsp 4、
	 * System.out.println(request.getRealPath("/")); JSP servlet
	 * API提供了getRealPath(path)方法，返回给定虚拟路径的真实路径，如果转换错误，则返回null。
	 * 
	 * 打印结果：C:\Tomcat5.0\webapps\projects\test <> Retrieves the current request
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
