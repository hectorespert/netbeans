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
package org.netbeans.modules.css.model.impl;

import java.util.ArrayList;
import java.util.List;
import org.netbeans.modules.css.lib.api.Node;
import org.netbeans.modules.css.model.api.Body;
import org.netbeans.modules.css.model.api.Model;
import org.netbeans.modules.css.model.api.MozDocument;
import org.netbeans.modules.css.model.api.MozDocumentFunction;

/**
 *
 * @author marekfukala
 */
public class MozDocumentI extends ModelElement implements MozDocument {

    private List<MozDocumentFunction> mozDocumentFunctions = new ArrayList<>();
    private Body body;
    
    private final ModelElementListener elementListener = new ModelElementListener.Adapter() {

        @Override
        public void elementAdded(MozDocumentFunction value) {
            mozDocumentFunctions.add(value);
        }

        @Override
        public void elementAdded(Body value) {
            body = value;
        }
    };

    public MozDocumentI(Model model) {
        super(model);
        
        //default elements
        addTextElement("\n"); //not acc. to the grammar!

        addEmptyElement(MozDocumentFunction.class);
        addTextElement(" {\n");
        addEmptyElement(Body.class);
        addTextElement("\n}\n");
    }

    public MozDocumentI(Model model, Node node) {
        super(model, node);
        initChildrenElements();
    }

    @Override
    protected ModelElementListener getElementListener() {
        return elementListener;
    }

    @Override
    protected Class getModelClass() {
        return MozDocument.class;
    }

    @Override
    public List<MozDocumentFunction> getRestrictions() {
        return mozDocumentFunctions;
    }

    @Override
    public Body getBody() {
        return body;
    }
}
