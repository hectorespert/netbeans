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

package org.netbeans.modules.web.wizards.dd;

import java.io.IOException;
import org.netbeans.api.java.project.JavaProjectConstants;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.api.project.SourceGroup;
import org.netbeans.api.project.Sources;
import org.openide.filesystems.FileObject;

/**
 * @author Petr Slechta
 */
public class Utils {

    private Utils() {
    }

    static FileObject createDirs(FileObject where, String[] dirs) throws IOException {
        FileObject base = where;
        for (String dir : dirs) {
            FileObject newDir = base.getFileObject(dir);
            if (newDir == null) {
                newDir = base.createFolder(dir);
            }
            base = newDir;
        }
        return base;
    }

    /**
     * Convenience method to obtain the source root folder.
     * @param project the Project object
     * @return the FileObject of the source root folder
     */
    static FileObject getSourceRoot(Project project) {
        if (project == null) {
            return null;
        }

        // Search the ${src.dir} Source Package Folder first, use the first source group if failed.
        Sources src = ProjectUtils.getSources(project);
        SourceGroup[] grp = src.getSourceGroups(JavaProjectConstants.SOURCES_TYPE_JAVA);
        for (int i = 0; i < grp.length; i++) {
            if ("${src.dir}".equals(grp[i].getName())) { // NOI18N
                return grp[i].getRootFolder();
            }
        }
//        if (grp.length != 0) {
//            return grp[0].getRootFolder();
//        }

        return null;
    }

}
