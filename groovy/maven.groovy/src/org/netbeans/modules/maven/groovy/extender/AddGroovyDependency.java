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

package org.netbeans.modules.maven.groovy.extender;

import org.netbeans.modules.maven.api.ModelUtils;
import org.netbeans.modules.maven.model.ModelOperation;
import org.netbeans.modules.maven.model.pom.Dependency;
import org.netbeans.modules.maven.model.pom.POMModel;

/**
 *
 * @author Martin Janicek
 */
public class AddGroovyDependency implements ModelOperation<POMModel> {

    @Override
    public void performOperation(final POMModel model) {
        model.refresh();
        if (ModelUtils.hasModelDependency(model, MavenConstants.GROOVY_GROUP_ID, MavenConstants.GROOVY_ARTIFACT_ID)) {
            return;
        }

        Dependency dependency = model.getFactory().createDependency();
        dependency.setGroupId(MavenConstants.GROOVY_GROUP_ID);
        dependency.setArtifactId(MavenConstants.GROOVY_ARTIFACT_ID);
        dependency.setVersion(MavenConstants.GROOVY_VERSION);

        model.getProject().addDependency(dependency);
    }
}
