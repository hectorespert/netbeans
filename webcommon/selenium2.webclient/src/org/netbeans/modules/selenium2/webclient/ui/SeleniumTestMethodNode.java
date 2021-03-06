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
package org.netbeans.modules.selenium2.webclient.ui;

import javax.swing.Action;
import org.netbeans.api.project.Project;
import org.netbeans.modules.gsf.testrunner.api.Testcase;
import org.netbeans.modules.gsf.testrunner.api.Trouble;
import org.netbeans.modules.gsf.testrunner.ui.api.TestMethodNode;
import org.netbeans.modules.selenium2.webclient.spi.JumpToCallStackCallback;

/**
 *
 * @author Theofanis Oikonomou
 */
public class SeleniumTestMethodNode extends TestMethodNode {

    private final JumpToCallStackCallback callback;

    public SeleniumTestMethodNode(Testcase testcase, Project project, JumpToCallStackCallback callback) {
        super(testcase, project);
        this.callback = callback;
    }

    @Override
    public Action[] getActions(boolean context) {
        Action[] defaultActions = super.getActions(context);
        Action preferredAction = getPreferredAction();
        if(preferredAction == null) {
            return defaultActions;
        }
        Action[] actions = new Action[defaultActions.length + 1];
        actions[0] = preferredAction;
        System.arraycopy(defaultActions, 0, actions, 1, defaultActions.length);
        return actions;
    }

    @Override
    public Action getPreferredAction() {
        Trouble trouble = testcase.getTrouble();
        if(trouble != null) {
            String[] stackTraces = trouble.getStackTrace();
            if(stackTraces != null && stackTraces.length > 0) {
                return new JumpToCallStackAction(stackTraces, callback);
            }
        }
        return super.getPreferredAction();
    }
    
}
