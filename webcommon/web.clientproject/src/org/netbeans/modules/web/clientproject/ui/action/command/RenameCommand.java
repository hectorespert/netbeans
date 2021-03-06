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
package org.netbeans.modules.web.clientproject.ui.action.command;

import org.netbeans.modules.web.clientproject.ClientSideProject;
import org.netbeans.spi.project.ActionProvider;
import org.netbeans.spi.project.ui.support.DefaultProjectOperations;
import org.openide.util.Lookup;

public class RenameCommand extends Command {

    public RenameCommand(ClientSideProject project) {
        super(project);
    }

    @Override
    public String getCommandId() {
        return ActionProvider.COMMAND_RENAME;
    }

    @Override
    boolean isActionEnabledInternal(Lookup context) {
        return true;
    }

    @Override
    void invokeActionInternal(Lookup context) {
        DefaultProjectOperations.performDefaultRenameOperation(project, null);
    }

}
