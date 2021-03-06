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
package org.netbeans.modules.php.symfony.ui.actions;

import java.util.List;
import org.netbeans.modules.csl.api.UiUtils;
import org.netbeans.modules.php.api.editor.EditorSupport;
import org.netbeans.modules.php.api.editor.PhpBaseElement;
import org.netbeans.modules.php.spi.framework.actions.GoToViewAction;
import org.netbeans.modules.php.symfony.util.SymfonyUtils;
import org.openide.filesystems.FileObject;
import org.openide.util.Lookup;

public final class SymfonyGoToViewAction extends GoToViewAction {
    private static final long serialVersionUID = 89745632134654L;

    private final FileObject fo;
    private final int offset;

    public SymfonyGoToViewAction(FileObject fo, int offset) {
        assert SymfonyUtils.isAction(fo);
        this.fo = fo;
        this.offset = offset;
    }

    @Override
    public boolean goToView() {
        EditorSupport editorSupport = Lookup.getDefault().lookup(EditorSupport.class);
        PhpBaseElement phpElement = editorSupport.getElement(fo, offset);
        if (phpElement == null) {
            return false;
        }
        final List<FileObject> views = SymfonyUtils.getViews(fo, phpElement);
        if (views.size() == 1) {
            UiUtils.open(views.get(0), DEFAULT_OFFSET);
            return true;
        } else if (views.size() > 1) {
            SymfonyGoToViewActionPopup popup = new SymfonyGoToViewActionPopup(views, offset);
            popup.show();
            return true;
        }
        return false;
    }
}
