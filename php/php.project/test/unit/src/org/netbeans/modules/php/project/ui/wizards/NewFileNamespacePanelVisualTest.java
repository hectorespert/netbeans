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
package org.netbeans.modules.php.project.ui.wizards;

import org.netbeans.junit.NbTestCase;

public class NewFileNamespacePanelVisualTest extends NbTestCase {

    public NewFileNamespacePanelVisualTest(String name) {
        super(name);
    }

    public void testValidNamespace() {
        assertNull(NewFileNamespacePanelVisual.validateNamespace(""));
        assertNull(NewFileNamespacePanelVisual.validateNamespace("a"));
        assertNull(NewFileNamespacePanelVisual.validateNamespace("ab"));
        assertNull(NewFileNamespacePanelVisual.validateNamespace("ab_cd"));
        assertNull(NewFileNamespacePanelVisual.validateNamespace("a\\b"));
        assertNull(NewFileNamespacePanelVisual.validateNamespace("a25"));
        assertNull(NewFileNamespacePanelVisual.validateNamespace("a\\a2"));
        assertNull(NewFileNamespacePanelVisual.validateNamespace("FrontModule\\Presenters\\Secured"));
    }

    public void testInvalidNamespace() {
        assertNotNull(NewFileNamespacePanelVisual.validateNamespace("a b"));
        assertNotNull(NewFileNamespacePanelVisual.validateNamespace("\\a"));
        assertNotNull(NewFileNamespacePanelVisual.validateNamespace("a\\"));
        assertNotNull(NewFileNamespacePanelVisual.validateNamespace("1"));
        assertNotNull(NewFileNamespacePanelVisual.validateNamespace("a\\2"));
    }

}
