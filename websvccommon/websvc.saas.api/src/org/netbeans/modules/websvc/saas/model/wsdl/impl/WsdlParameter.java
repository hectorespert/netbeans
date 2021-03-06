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

package org.netbeans.modules.websvc.saas.model.wsdl.impl;

import org.netbeans.modules.websvc.jaxwsmodelapi.WSParameter;
import org.netbeans.modules.xml.schema.model.LocalElement;

/**
 *
 * @author Roderico Cruz
 */
public class WsdlParameter implements WSParameter{
    private LocalElement element;

    public WsdlParameter(LocalElement element){
        this.element = element;
    }
    public Object getInternalJAXWSParameter() {
        return element;
    }

    public String getName() {
        return element.getName();
    }

    public String getTypeName() {
        return element.getType().get().getName();
      
    }

    public boolean isHolder() {
        return false;
    }

    public String getHolderName() {
        return null;
    }

}
