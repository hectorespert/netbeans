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

package org.netbeans.modules.xml.schema.model.impl;

import org.netbeans.modules.xml.schema.model.All;
import org.netbeans.modules.xml.schema.model.LocalElement;
import org.netbeans.modules.xml.schema.model.SchemaComponent;
import org.netbeans.modules.xml.schema.model.visitor.SchemaVisitor;
import org.w3c.dom.Element;

/**
 *
 * @author Vidhya Narayanan
 */
public class LocalElementImpl extends LocalElementBaseImpl
    implements LocalElement {

    public LocalElementImpl(SchemaModelImpl model) {
	this(model,createNewComponent(SchemaElements.ELEMENT,model));
    }
    
    /**
     * Creates a new instance of LocalElementImpl
     */
    public LocalElementImpl(SchemaModelImpl model, Element el) {
	super(model, el);
    }
    
    /**
     *
     *
     */
    public Class<? extends SchemaComponent> getComponentType() {
	return LocalElement.class;
    }
    
    public void accept(SchemaVisitor v) {
	v.visit(this);
    }
    
    /**
     * true if #getMaxOccurs() and #getMinOccurs() allow multiciplity outside
     * [0,1], false otherwise. This method is only accurate after the element
     * has been inserted into the model.
     */
    public boolean allowsFullMultiplicity() {
	return !(getParent() instanceof All);
    }
    
}
