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
package org.netbeans.modules.php.project.runconfigs.validation;

public class RunConfigScriptValidatorTest extends TestBase {

    public RunConfigScriptValidatorTest(String name) {
        super(name);
    }

    public void testValidateWorkDir() {
        assertNull(RunConfigScriptValidator.validateWorkDir(getWorkDirPath(), false));
        assertNull(RunConfigScriptValidator.validateWorkDir(getWorkDirPath(), true));
        assertNull(RunConfigScriptValidator.validateWorkDir(null, true));
        assertNull(RunConfigScriptValidator.validateWorkDir("", true));
        // errors
        assertNotNull(RunConfigScriptValidator.validateWorkDir(null, false));
        assertNotNull(RunConfigScriptValidator.validateWorkDir("", false));
        assertNotNull(RunConfigScriptValidator.validateWorkDir("/non-existing-dir/", false));
        assertNotNull(RunConfigScriptValidator.validateWorkDir(indexFile.getAbsolutePath(), false));
        assertNotNull(RunConfigScriptValidator.validateWorkDir(indexFile.getName(), false));
    }

}
