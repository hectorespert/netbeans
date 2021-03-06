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

package org.netbeans.modules.groovy.antproject.ejb;

import java.net.URL;
import org.netbeans.api.project.Project;
import org.netbeans.modules.groovy.antproject.base.AbstractGroovyExtender;
import org.netbeans.modules.groovy.antproject.common.BuildScriptType;
import org.netbeans.modules.groovy.support.spi.GroovyExtenderImplementation;
import org.netbeans.spi.project.ProjectServiceProvider;

/**
 * Implementation of the GroovyExtender for Java EE Ant based projects.
 *
 * @author Martin Janicek
 */
@ProjectServiceProvider(
    service =
        GroovyExtenderImplementation.class,
    projectType = {
        "org-netbeans-modules-j2ee-ejbjarproject"
    }
)
public class EjbGroovyExtender extends AbstractGroovyExtender {

    public EjbGroovyExtender(Project project) {
        super(project);
    }

    @Override
    protected URL getGroovyBuildXls() {
        return BuildScriptType.EJB.getStylesheet();
    }
}
