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

package org.netbeans.modules.subversion.client.cli.commands;

import java.io.File;
import java.io.IOException;
import org.netbeans.modules.subversion.client.cli.SvnCommand;
import org.tigris.subversion.svnclientadapter.ISVNNotifyListener;

/**
 *
 * @author Tomas Stupka
 */
public class RevertCommand extends SvnCommand {

    private final File[] files;
    private final boolean recursive;

    public RevertCommand(File[] files, boolean recursive) {
        this.files = files;
        this.recursive = recursive;
    }
       
    @Override
    protected int getCommand() {
        return ISVNNotifyListener.Command.REVERT;
    }
    
    @Override
    protected void config(File configDir, String username, String password, Arguments arguments) {
        arguments.addConfigDir(configDir);        
    }
    
    @Override
    public void prepareCommand(Arguments arguments) throws IOException {                     
        arguments.add("revert");
        if (recursive) {
            arguments.add("-R");
        }
        arguments.addFileArguments(files);
        setCommandWorkingDirectory(files);                
    }
    
}
