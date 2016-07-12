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
package com.opensymphony.xwork2.config;

/**Struts2中配置文件的解析器。<br/>
 * Struts2中的配置文件主要是有其实现类XmlConfigurationProvider及其子类StrutsXmlConfigurationProvider来解析，<br/>
 * 被各种形式的xwork配置类实现的接口
 * Interface to be implemented by all forms of XWork configuration classes.
 */
public interface ConfigurationProvider extends ContainerProvider, PackageProvider {
}
