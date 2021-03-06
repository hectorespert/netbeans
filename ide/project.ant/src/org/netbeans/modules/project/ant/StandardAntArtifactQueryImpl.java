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

package org.netbeans.modules.project.ant;

import java.io.File;
import java.net.URI;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ant.AntArtifact;
import org.netbeans.spi.project.ant.AntArtifactProvider;
import org.netbeans.spi.project.ant.AntArtifactQueryImplementation;
import org.openide.util.BaseUtilities;

/**
 * Standard implementation of {@link AntArtifactQueryImplementation} which uses
 * {@link AntArtifactProvider}.
 * @author Jesse Glick
 */
@org.openide.util.lookup.ServiceProvider(service=org.netbeans.spi.project.ant.AntArtifactQueryImplementation.class)
public class StandardAntArtifactQueryImpl implements AntArtifactQueryImplementation {
    
    /** Default constructor for lookup. */
    public StandardAntArtifactQueryImpl() {}
    
    public AntArtifact findArtifact(File file) {
        Project p = FileOwnerQuery.getOwner(BaseUtilities.toURI(file));
        if (p == null) {
            return null;
        }
        AntArtifactProvider prov = p.getLookup().lookup(AntArtifactProvider.class);
        if (prov == null) {
            return null;
        }
        AntArtifact[] artifacts = prov.getBuildArtifacts();
        for (int i = 0; i < artifacts.length; i++) {
            URI uris[] = artifacts[i].getArtifactLocations();
            for (int y = 0; y < uris.length; y++) {
                File testFile = BaseUtilities.toFile(BaseUtilities.toURI(artifacts[i].getScriptLocation()).resolve(uris[y]));
                if (file.equals(testFile)) {
                    return artifacts[i];
                }
            }
        }
        return null;
    }
    
}
