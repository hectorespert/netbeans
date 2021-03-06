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
 *
 * @author Martin Fousek <marfous@netbeans.org>
 */
public interface FlowSwitch extends IdentifiableElement {

    /**
     * Property name of &lt;navigation-case&gt; element.
     */
    static final String NAVIGATION_CASE = JSFConfigQNames.NAVIGATION_CASE.getLocalName();

    /**
     * Property name of &lt;default-outcome&gt; element.
     */
    static final String DEFAULT_OUTCOME = JSFConfigQNames.DEFAULT_OUTCOME.getLocalName();

    public List<NavigationCase> getNavigationCases();
    public void addNavigationCase(NavigationCase navigationCase);
    public void removeNavigationCase(NavigationCase navigationCase);

    public List<FlowDefaultOutcome> getDefaultOutcomes();
    public void addDefaultOutcome(FlowDefaultOutcome defaultOutcome);
    public void removeDefaultOutcome(FlowDefaultOutcome defaultOutcome);

}
