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
package org.netbeans.modules.javascript.nodejs.file;

import java.util.Collection;
import javax.swing.event.ChangeListener;
import org.netbeans.api.project.Project;
import org.netbeans.modules.web.common.spi.ImportantFilesImplementation;
import org.netbeans.modules.web.common.spi.ImportantFilesSupport;
import org.netbeans.spi.project.LookupProvider;
import org.netbeans.spi.project.ProjectServiceProvider;

@ProjectServiceProvider(service = ImportantFilesImplementation.class, projectTypes = {
    @LookupProvider.Registration.ProjectType(id = "org-netbeans-modules-web-clientproject"), // NOI18N
    @LookupProvider.Registration.ProjectType(id = "org-netbeans-modules-php-project"), // NOI18N
})
public final class ImportantFilesImpl implements ImportantFilesImplementation {

    private final ImportantFilesSupport support;


    public ImportantFilesImpl(Project project) {
        assert project != null;
        support = ImportantFilesSupport.create(project.getProjectDirectory(), "package.json"); // NOI18N
    }

    @Override
    public Collection<ImportantFilesImplementation.FileInfo> getFiles() {
        return support.getFiles(null);
    }

    @Override
    public void addChangeListener(ChangeListener listener) {
        support.addChangeListener(listener);
    }

    @Override
    public void removeChangeListener(ChangeListener listener) {
        support.removeChangeListener(listener);
    }

}
