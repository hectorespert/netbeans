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

import java.io.*;
import java.util.*;
import org.w3c.dom.*;

import groupunbounded.*;

public class TestGroupUnbounded extends BaseTest {
    public static void main(String[] argv) {
        TestGroupUnbounded o = new TestGroupUnbounded();
        if (argv.length > 0)
            o.setDocumentDir(argv[0]);
        try {
            o.run();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.exit(0);
    }

    public void run() throws Exception {
        GroupUnbounded t;

        this.readDocument();

        out("creating the bean graph");
        t = GroupUnbounded.read(doc);
	
        //	Check that we can read the graph an it is complete
        out("bean graph created");
        t.write(out);

        t.validate();
    }
}
