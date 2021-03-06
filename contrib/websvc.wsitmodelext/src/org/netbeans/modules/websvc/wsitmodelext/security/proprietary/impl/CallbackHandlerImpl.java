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

package org.netbeans.modules.websvc.wsitmodelext.security.proprietary.impl;

import org.netbeans.modules.websvc.wsitmodelext.security.proprietary.CallbackHandler;
import org.netbeans.modules.websvc.wsitmodelext.security.proprietary.ProprietarySecurityPolicyAttribute;
import org.netbeans.modules.xml.wsdl.model.WSDLModel;
import org.w3c.dom.Element;

/**
 *
 * @author Martin Grebac
 */
public class CallbackHandlerImpl extends ProprietarySecurityPolicyComponentImpl implements CallbackHandler {
    
    /**
     * Creates a new instance of CallbackHandlerImpl
     */
    public CallbackHandlerImpl(WSDLModel model, Element e) {
        super(model, e);
    }
    
    public void setDefault(String def) {
        setAttribute(DEFAULT, ProprietarySecurityPolicyAttribute.DEFAULT, def);        
    }

    public String getDefault() {
        return getAttribute(ProprietarySecurityPolicyAttribute.DEFAULT);
    }

    public void setName(String name) {
        setAttribute(NAME, ProprietarySecurityPolicyAttribute.NAME, name);        
    }

    public String getName() {
        return getAttribute(ProprietarySecurityPolicyAttribute.NAME);
    }

    public void setClassname(String classname) {
        setAttribute(CLASSNAME, ProprietarySecurityPolicyAttribute.CLASSNAME, classname);        
    }

    public String getClassname() {
        return getAttribute(ProprietarySecurityPolicyAttribute.CLASSNAME);
    }
}
