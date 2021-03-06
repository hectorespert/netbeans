/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.web.jsf.api.metamodel;

import org.netbeans.modules.web.jsf.impl.facesmodel.JSFConfigQNames;



/**
 * This interface represent basic information about component.
 * His nature could be either Annotation declaration or XML "component" element. 
 * @author ads
 *
 */
public interface Component extends JsfModelElement {
    
    /**
     * Property of &lt;component-type&gt; element. 
     */
    String COMPONENT_TYPE = JSFConfigQNames.COMPONENT_TYPE.getLocalName();
    
    /**
     * Property of &lt;component-class&gt; element. 
     */
    String COMPONENT_CLASS = JSFConfigQNames.COMPONENT_CLASS.getLocalName();

    String getComponentType();
    
    String getComponentClass();
}
