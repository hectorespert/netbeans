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
package org.netbeans.modules.css.editor.module.main;

import java.util.Arrays;
import java.util.Collection;
import org.netbeans.modules.css.editor.module.spi.CssEditorModule;
import org.netbeans.modules.css.editor.module.spi.EditorFeatureContext;
import org.netbeans.modules.css.lib.api.CssModule;
import org.openide.util.NbBundle;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author mfukala@netbeans.org
 */
@ServiceProvider(service = CssEditorModule.class)
public class ListsAndCountersModule extends ExtCssEditorModule implements CssModule {

    private static final String PROPERTIES_DEFINITION_PATH = "org/netbeans/modules/css/editor/module/main/properties/lists_and_counters"; //NOI18N
    private static final Collection<String> PSEUDO_ELEMENTS = Arrays.asList(new String[]{"marker"}); //NOI18N

    @Override
    public Collection<String> getPseudoElements(EditorFeatureContext context) {
        return PSEUDO_ELEMENTS;
    }

    @Override
    public String getName() {
        return "lists_and_counters"; //NOI18N
    }

    @Override
    public String getDisplayName() {
        return NbBundle.getMessage(this.getClass(), Constants.CSS_MODULE_DISPLAYNAME_BUNDLE_KEY_PREFIX + getName());
    }

    @Override
    public String getSpecificationURL() {
        return "http://www.w3.org/TR/css3-lists"; //NOI18N
    }

    @Override
    protected String getPropertyDefinitionsResourcePath() {
        return PROPERTIES_DEFINITION_PATH;
    }

    @Override
    protected CssModule getCssModule() {
        return this;
    }
}
