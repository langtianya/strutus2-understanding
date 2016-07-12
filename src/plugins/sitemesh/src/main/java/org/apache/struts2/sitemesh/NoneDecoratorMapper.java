/*
 * $Id: NoneDecoratorMapper.java 651946 2008-04-27 13:41:38Z apetrelli $
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

package org.apache.struts2.sitemesh;

import com.opensymphony.module.sitemesh.mapper.AbstractDecoratorMapper;
import com.opensymphony.module.sitemesh.Decorator;
import com.opensymphony.module.sitemesh.Page;

import javax.servlet.http.HttpServletRequest;

/**
 * Won't decorate the output if it finds a "decorator" flag in the request
 */
public class NoneDecoratorMapper extends AbstractDecoratorMapper {
    
    public Decorator getDecorator(HttpServletRequest req, Page page) {
        if ("none".equals(req.getAttribute("decorator"))) {
            return null;
        }

        return super.getDecorator(req, page);
    }
}