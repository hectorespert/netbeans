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
package org.netbeans.spi.project.ant;

import org.netbeans.api.annotations.common.NonNull;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.support.ant.GeneratedFilesHelper;
import org.openide.util.Lookup;

/**
 * Notifies the Project extension about build script update.
 * The {@link GeneratedFilesHelper} calls all the instances of the @link GeneratedFilesInterceptor}
 * registered in the project {@link Lookup} when a a build script file has been
 * updated or created.
 * @author Tomas Zezula
 * @since 1.58
 */
public interface GeneratedFilesInterceptor {

    /**
     * Called when the build script file has been updated or created.
     * @param project the project for which the build script was updated.
     * @param path the relative path to generated file from project directory.
     */
    void fileGenerated(@NonNull Project project, @NonNull String path);
}
