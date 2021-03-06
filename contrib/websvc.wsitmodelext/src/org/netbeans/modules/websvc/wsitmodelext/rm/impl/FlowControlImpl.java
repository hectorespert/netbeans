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

package org.netbeans.modules.websvc.wsitmodelext.rm.impl;

import org.netbeans.modules.websvc.wsitmodelext.rm.FlowControl;
import org.netbeans.modules.websvc.wsitmodelext.rm.MaxReceiveBufferSize;
import org.netbeans.modules.websvc.wsitmodelext.rm.RMMSQName;
import org.netbeans.modules.xml.wsdl.model.WSDLComponent;
import org.netbeans.modules.xml.wsdl.model.WSDLModel;
import org.netbeans.modules.xml.wsdl.model.visitor.WSDLVisitor;
import org.w3c.dom.Element;

import java.util.Collections;

/**
 *
 * @author Martin Grebac
 */
public class FlowControlImpl extends RMMSComponentImpl implements FlowControl {
    
    /**
     * Creates a new instance of FlowControlImpl
     */
    public FlowControlImpl(WSDLModel model, Element e) {
        super(model, e);
    }
    
    public FlowControlImpl(WSDLModel model){
        this(model, createPrefixedElement(RMMSQName.RMFLOWCONTROL.getQName(), model));
    }

    @Override
    public void accept(WSDLVisitor visitor) {
        visitor.visit(this);
    }

    public void setMaxReceiveBufferSize(MaxReceiveBufferSize maxReceiveBufferSize) {
        java.util.List<Class<? extends WSDLComponent>> classes = Collections.emptyList();
        setChild(MaxReceiveBufferSize.class, MAX_RECEIVE_BUFFER_SIZE_PROPERTY, maxReceiveBufferSize, classes);
    }

    public MaxReceiveBufferSize getMaxReceiveBufferSize() {
        return getChild(MaxReceiveBufferSize.class);
    }

    public void removeMaxReceiveBufferSize(MaxReceiveBufferSize maxReceiveBufferSize) {
        removeChild(MAX_RECEIVE_BUFFER_SIZE_PROPERTY, maxReceiveBufferSize);
    }
    
}
