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

import org.netbeans.modules.css.lib.api.Node;
import org.netbeans.modules.css.model.api.Expression;
import org.netbeans.modules.css.model.api.MediaFeatureValue;
import org.netbeans.modules.css.model.api.Model;

/**
 *
 * @author marekfukala
 */
public class MediaFeatureValueI extends ModelElement implements MediaFeatureValue {

    private Expression expression;
    
    private final ModelElementListener elementListener = new ModelElementListener.Adapter() {

        @Override
        public void elementAdded(Expression value) {
            expression = value;
        }      
        
    };
    
    public MediaFeatureValueI(Model model) {
        super(model);
        
        addTextElement(" "); //NOI18N
        addTextElement(":"); //NOI18N
        addTextElement(" "); //NOI18N
        addEmptyElement(Expression.class);
    }

    public MediaFeatureValueI(Model model, Node node) {
        super(model, node);
        initChildrenElements();
    }

    @Override
    protected Class getModelClass() {
        return MediaFeatureValue.class;
    }
    
    @Override
    protected ModelElementListener getElementListener() {
        return elementListener;
    }

    @Override
    public Expression getExpression() {
        return expression;
    }

    @Override
    public void setExpression(Expression expression) {
        setElement(expression);
    }

}
