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
package org.netbeans.modules.jshell.env;

import java.io.IOException;
import org.netbeans.modules.jshell.launch.ShellOptions;
import org.netbeans.modules.jshell.support.FileHistory;
import org.netbeans.modules.jshell.support.ShellHistory;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author sdedic
 */
@ServiceProvider(service = ShellHistory.class)
public class GlobalShellHistory extends FileHistory {
    private static final String HISTORY_FILENAME = "jshell.history"; // NOI18N

    public GlobalShellHistory() {
        super(FileUtil.getConfigRoot().getFileObject(HISTORY_FILENAME));
        setMaxHistoryItems(ShellOptions.get().getHistoryLines());
    }

    @Override
    protected FileObject createFile() throws IOException {
        FileObject f = FileUtil.getConfigRoot().getFileObject(HISTORY_FILENAME);
        if (f != null) {
            return f;
        }
        try {
            return FileUtil.getConfigRoot().createData(HISTORY_FILENAME);
        } catch (IOException ex) {
            f = FileUtil.getConfigRoot().getFileObject(HISTORY_FILENAME);
            if (f != null) {
                return f;
            }
            throw ex;
        }
    }
}
