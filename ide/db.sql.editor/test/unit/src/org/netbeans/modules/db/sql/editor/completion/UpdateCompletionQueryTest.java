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

package org.netbeans.modules.db.sql.editor.completion;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 *
 * @author Jiri Skrivanek
 */
public class UpdateCompletionQueryTest extends SelectCompletionQueryTest {

    public UpdateCompletionQueryTest(String testName) {
        this(testName, false);
    }

    /**
     * @param testName golden file name
     * @param stdout true to print completion results to stdout
     */
    public UpdateCompletionQueryTest(String testName, boolean stdout) {
        super(testName, stdout);
    }

    public static Test suite() throws Exception {
        TestSuite suite = new TestSuite();
        suite.addTest(new UpdateCompletionQueryTest("updateAll"));
        suite.addTest(new UpdateCompletionQueryTest("updateSubquery"));
        suite.addTest(new UpdateCompletionQueryTest("updateSimple"));
        suite.addTest(new UpdateCompletionQueryTest("updateSet"));
        suite.addTest(new UpdateCompletionQueryTest("updateSetValue"));
        suite.addTest(new UpdateCompletionQueryTest("updateWhere"));

        suite.addTest(new UpdateCompletionQueryTest("updateView"));
        return suite;
    }
}
