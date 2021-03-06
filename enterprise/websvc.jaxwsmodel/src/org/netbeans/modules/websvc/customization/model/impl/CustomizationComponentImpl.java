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
/*
 * CustomizationComponentImpl.java
 *
 * Created on February 23, 2006, 9:51 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.netbeans.modules.websvc.customization.model.impl;

import org.netbeans.modules.websvc.api.customization.model.JAXWSQName;
import org.netbeans.modules.xml.wsdl.model.WSDLModel;
import org.netbeans.modules.xml.wsdl.model.spi.GenericExtensibilityElement;
import org.netbeans.modules.xml.wsdl.model.visitor.WSDLVisitor;
import org.w3c.dom.Element;

/**
 *
 * @author Roderico Cruz
 */
public abstract class CustomizationComponentImpl extends GenericExtensibilityElement {
    
    /** Creates a new instance of CustomizationComponentImpl */
    public CustomizationComponentImpl(WSDLModel model, Element e) {
        super(model, e);
    }

    public abstract void accept(WSDLVisitor visitor);
    
     protected String getNamespaceURI() {
        return JAXWSQName.JAXWS_NS_URI;
    }

    public String getAttribute(String attribute) {
        throw new UnsupportedOperationException();
    }

    public void setAttribute(String attribute, String value) {
        throw new UnsupportedOperationException();
    }
}
