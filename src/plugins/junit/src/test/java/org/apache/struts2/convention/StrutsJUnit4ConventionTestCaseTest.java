/*
 * $Id$
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
package org.apache.struts2.convention;

import actions.ViewAction;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Uses the convention plugin to execute actions
 */
public class StrutsJUnit4ConventionTestCaseTest extends StrutsJUnit4TestCase<ViewAction>{
    @Test
    public void testConventionUrl() throws Exception {
        // TODO: Currently output is empty
        String output = executeAction("/view.action");

        ViewAction action = this.getAction();
        Assert.assertEquals("Hello World", action.getMessage());
    }

    @Override
    protected String getConfigPath() {
        return "struts-convention-configuration.xml";
    }
}

