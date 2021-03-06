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
package org.netbeans.modules.web.jsf.api.facesmodel;

import java.util.List;

import org.netbeans.modules.web.jsf.impl.facesmodel.JSFConfigQNames;



/**
 * @author ads
 *
 */
public interface AbsoluteOrdering extends FacesConfigElement {
    
    /**
     * Property name of &lt;name&gt; element.
     */ 
    String NAME = JSFConfigQNames.NAME.getLocalName();
    
    /**
     * Property name of &lt;others&gt; element.
     */ 
    String OTHERS = JSFConfigQNames.OTHERS.getLocalName();  
    
    List<Name> getNames();
    void addName( Name name );
    void removeName(Name name );
    
    List<Others> getOthers();
    void addOther( Others others );
    void removeOthers( Others others );
    
    List<AbsoluteOrderingElement> getElements();
    void addElement( int index , AbsoluteOrderingElement element );

}
