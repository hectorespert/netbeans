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

import org.netbeans.modules.css.model.api.Element;
import org.netbeans.modules.css.model.api.MediaBody;
import org.netbeans.modules.css.model.api.Page;
import org.netbeans.modules.css.model.api.Rule;

/**
 * Doesn't need to be public right now as getting/setting Pages/Rules is 
 * done via {@link MediaBody}.
 * 
 * @author marekfukala
 */
public interface MediaBodyItem extends Element {

    public Rule getRule();
    
    public void setRule(Rule rule);
    
    public Page getPage();
    
    public void setPage(Page page);
    
}
