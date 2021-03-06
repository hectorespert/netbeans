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
package org.netbeans.modules.php.project.ui.actions;

import org.netbeans.modules.php.project.PhpProject;
import org.netbeans.modules.php.project.ui.actions.support.CommandUtils;
import org.netbeans.modules.php.project.ui.actions.support.ConfigAction;
import org.netbeans.modules.php.project.ui.actions.support.Displayable;
import org.netbeans.spi.project.ActionProvider;
import org.openide.filesystems.FileObject;
import org.openide.util.Lookup;

/**
 * @author Radek Matous, Tomas Mysik
 */
public class RunFileCommand extends Command implements Displayable {
    public static final String ID = ActionProvider.COMMAND_RUN_SINGLE;
    public static final String DISPLAY_NAME = RunProjectCommand.DISPLAY_NAME;

    public RunFileCommand(PhpProject project) {
        super(project);
    }

    @Override
    public void invokeActionInternal(Lookup context) {
        FileObject fileObj = CommandUtils.fileForContextOrSelectedNodes(context);
        if (isSeleniumFile(fileObj)) {
            // selenium
            ConfigAction.get(ConfigAction.Type.SELENIUM, getProject()).runFile(context);
        } else if (isTestFile(fileObj)) {
            // test
            ConfigAction.get(ConfigAction.Type.TEST, getProject()).runFile(context);
        } else {
            // source
            ConfigAction configAction = getConfigAction();
            if (!configAction.isFileValid()) {
                // property not set yet
                return;
            }
            configAction.runFile(context);
        }
    }

    @Override
    public boolean isActionEnabledInternal(Lookup context) {
        FileObject fileObj = CommandUtils.fileForContextOrSelectedNodes(context);
        if (isSeleniumFile(fileObj)) {
            // selenium
            return ConfigAction.get(ConfigAction.Type.SELENIUM, getProject()).isRunFileEnabled(context);
        }
        if (isTestFile(fileObj)) {
            // test
            return ConfigAction.get(ConfigAction.Type.TEST, getProject()).isRunFileEnabled(context);
        }
        // source
        return getConfigAction().isRunFileEnabled(context);
    }

    @Override
    public String getCommandId() {
        return ID;
    }

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }
}
