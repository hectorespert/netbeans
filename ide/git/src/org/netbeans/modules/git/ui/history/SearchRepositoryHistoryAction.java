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

package org.netbeans.modules.git.ui.history;

import java.io.File;
import org.netbeans.modules.git.ui.actions.MultipleRepositoryAction;
import org.netbeans.modules.git.utils.GitUtils;
import org.netbeans.modules.versioning.spi.VCSContext;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle;
import org.openide.util.RequestProcessor.Task;
import org.openide.util.actions.SystemAction;

/**
 *
 * @author ondra
 */
@ActionID(id = "org.netbeans.modules.git.ui.history.SearchRepositoryHistoryAction", category = "Git")
@ActionRegistration(displayName = "#LBL_SearchRepositoryHistoryAction_Name")
@NbBundle.Messages({
    "LBL_SearchRepositoryHistoryAction_Name=Show Repository History"
})
public class SearchRepositoryHistoryAction extends MultipleRepositoryAction {
    private static final String ICON_RESOURCE = "org/netbeans/modules/git/resources/icons/search_history.png"; //NOI18N

    public SearchRepositoryHistoryAction () {
        super(ICON_RESOURCE);
    }

    @Override
    protected String iconResource () {
        return ICON_RESOURCE;
    }
    
    @Override
    protected Task performAction (final File repository, final File[] roots, final VCSContext context) {
        return SystemAction.get(SearchHistoryAction.class).performAction(repository, new File[] { repository }, GitUtils.getContextForFile(repository));
    }

}
