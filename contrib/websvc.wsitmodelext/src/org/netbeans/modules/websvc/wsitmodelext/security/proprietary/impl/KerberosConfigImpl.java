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

import org.netbeans.modules.websvc.wsitmodelext.security.proprietary.KerberosConfig;
import org.netbeans.modules.websvc.wsitmodelext.security.proprietary.ProprietaryPolicyQName;
import org.netbeans.modules.websvc.wsitmodelext.security.proprietary.ProprietarySecurityPolicyAttribute;
import org.netbeans.modules.xml.wsdl.model.WSDLModel;
import org.w3c.dom.Element;

/**
 *
 * @author Martin Grebac
 */
public class KerberosConfigImpl extends ProprietarySecurityPolicyComponentImpl implements KerberosConfig {
    
    /**
     * Creates a new instance of KerberosConfigImpl
     */
    public KerberosConfigImpl(WSDLModel model, Element e) {
        super(model, e);
    }
    
    public void setVisibility(String vis) {
        setAnyAttribute(ProprietaryPolicyQName.VISIBILITY.getQName(), vis);
    }

    public String getVisibility() {
        return getAnyAttribute(ProprietaryPolicyQName.VISIBILITY.getQName());
    }
    
    public void setLoginModule(String loginModule) {
        setAttribute(LOGINMODULE, ProprietarySecurityPolicyAttribute.LOGINMODULE, loginModule);
    }

    public String getLoginModule() {
        return getAttribute(ProprietarySecurityPolicyAttribute.LOGINMODULE);
    }

    public void setServicePrincipal(String principal) {
        setAttribute(SERVICEPRINCIPAL, ProprietarySecurityPolicyAttribute.SERVICEPRINCIPAL, principal);
    }

    public String getServicePrincipal() {
        return getAttribute(ProprietarySecurityPolicyAttribute.SERVICEPRINCIPAL);
    }

    public void setCredentialDelegation(boolean credDelegation) {
        setAttribute(CREDENTIALDELEGATION, ProprietarySecurityPolicyAttribute.CREDENTIALDELEGATION, Boolean.toString(credDelegation));
    }

    public boolean isCredentialDelegation() {
        return Boolean.parseBoolean(getAttribute(ProprietarySecurityPolicyAttribute.CREDENTIALDELEGATION));
    }
}
