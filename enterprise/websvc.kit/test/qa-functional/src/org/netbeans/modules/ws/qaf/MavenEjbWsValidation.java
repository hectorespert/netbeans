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
package org.netbeans.modules.ws.qaf;

import java.io.IOException;
import junit.framework.Test;
import org.netbeans.junit.NbModuleSuite;

/**
 *
 * @author lukas
 */
public class MavenEjbWsValidation extends EjbWsValidation {

    public MavenEjbWsValidation(String name) {
        super(name);
    }

    @Override
    public String getProjectName() {
        return "Mvn" + super.getProjectName();
    }

    @Override
    protected ProjectType getProjectType() {
        return ProjectType.MAVEN_EJB;
    }

    public static Test suite() {
        return NbModuleSuite.create(addServerTests(Server.GLASSFISH,
                NbModuleSuite.createConfiguration(MavenEjbWsValidation.class),
                "testCreateNewWs",
                "testAddOperation",
                "testSetSOAP",
// IZ# 175974                "testGenerateWSDL",
                "testStartServer",
                "testWsHandlers",
                "testRunWsProject",
                "testTestWS",
                "testCreateWsClient",
                "testRefreshClientAndReplaceWSDL",
                "testCallWsOperationInSessionEJB",
                "testCallWsOperationInJavaClass",
                "testWsFromEJBinClientProject",
                "testWsClientHandlers",
                "testRunWsClientProject",
                "testUndeployProjects",
                "testStopServer").enableModules(".*").clusters(".*"));
    }

    public void testRunWsProject() throws IOException {
        runProject(getWsProjectName());
    }

    public void testRunWsClientProject() throws IOException {
        runProject(getWsClientProjectName());
    }
}
