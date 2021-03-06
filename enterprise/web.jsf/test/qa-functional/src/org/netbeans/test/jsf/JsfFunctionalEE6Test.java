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
package org.netbeans.test.jsf;

import junit.framework.Test;

/**
 * Test JSF support in Java EE 6 project.
 *
 * @author Lukasz Grela
 * @author Jiri Skrivanek
 * @author Jindrich Sedek
 */
public class JsfFunctionalEE6Test extends JsfFunctionalTest {

    public static final String[] TESTS = {
        "testNewJSFWebProject",
        "testCleanAndBuildProject",
        "testCompileAllJSP",
        "testRedeployProject",
        "testManagedBeanWizard",
        "testManagedBeanDelete",
        "testAddJSFToProject",
        "testShutdownDb",
        "testFinish"
    };

    public JsfFunctionalEE6Test(String name) {
        super(name);
        PROJECT_NAME = "WebJSFProjectEE6";
    }

    public static Test suite() {
        return createAllModulesServerSuite(Server.GLASSFISH, JsfFunctionalEE6Test.class, TESTS);
    }

    @Override
    protected String getEEVersion() {
        return JAVA_EE_6;
    }
}
