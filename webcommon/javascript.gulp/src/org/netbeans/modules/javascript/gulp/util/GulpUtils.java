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
package org.netbeans.modules.javascript.gulp.util;

import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.modules.web.common.api.UsageLogger;

public final class GulpUtils {

    private static final String USAGE_LOGGER_NAME = "org.netbeans.ui.metrics.javascript.gulp"; // NOI18N
    private static final UsageLogger GULP_BUILD_USAGE_LOGGER = new UsageLogger.Builder(USAGE_LOGGER_NAME)
            .message(GulpUtils.class, "USG_GULP_BUILD") // NOI18N
            .create();


    private GulpUtils() {
    }

    public static void logUsageGulpBuild() {
        GULP_BUILD_USAGE_LOGGER.log();
    }

    public static String getProjectDisplayName(Project project) {
        return ProjectUtils.getInformation(project).getDisplayName();
    }

}
