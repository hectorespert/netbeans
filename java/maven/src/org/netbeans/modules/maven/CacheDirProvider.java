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

package org.netbeans.modules.maven;

import java.io.IOException;
import org.netbeans.api.annotations.common.SuppressWarnings;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.CacheDirectoryProvider;
import org.netbeans.spi.project.ProjectServiceProvider;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.modules.Places;

/**
 * implementation of CacheDirectoryProvider that places the cache directory in the user
 * directory space of the currently running IDE.
 * @author mkleint
 */
@ProjectServiceProvider(service=CacheDirectoryProvider.class, projectType="org-netbeans-modules-maven")
public class CacheDirProvider implements CacheDirectoryProvider {
    
    private final Project project;

    public CacheDirProvider(Project prj) {
        project = prj;
    }

    @SuppressWarnings("RV_ABSOLUTE_VALUE_OF_HASHCODE") // for compatibility, use this decimal scheme
    public @Override FileObject getCacheDirectory() throws IOException {
        int code = Math.abs(project.getProjectDirectory().getPath().hashCode());
        return FileUtil.createFolder(Places.getCacheSubdirectory("mavencachedirs/" + code)); // NOI18N
    }

}
