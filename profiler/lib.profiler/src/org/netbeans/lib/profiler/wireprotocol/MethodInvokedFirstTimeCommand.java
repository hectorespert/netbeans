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

package org.netbeans.lib.profiler.wireprotocol;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Command issued by the back end when the lazy transitive CPU profiling instrumentation scheme is used,
 * and the given method is invoked for the first time.
 *
 * @author Misha Dmitriev
 * @author Ian Formanek
 */
public class MethodInvokedFirstTimeCommand extends Command {
    //~ Instance fields ----------------------------------------------------------------------------------------------------------

    private char methodId;

    //~ Constructors -------------------------------------------------------------------------------------------------------------

    public MethodInvokedFirstTimeCommand(char methodId) {
        super(METHOD_INVOKED_FIRST_TIME);
        this.methodId = methodId;
    }

    // Custom serialization support
    MethodInvokedFirstTimeCommand() {
        super(METHOD_INVOKED_FIRST_TIME);
    }

    //~ Methods ------------------------------------------------------------------------------------------------------------------

    public int getMethodId() {
        return methodId;
    }

    // for debugging
    public String toString() {
        return super.toString() + ", methodId: " + ((int) methodId); // NOI18N
    }

    void readObject(ObjectInputStream in) throws IOException {
        methodId = in.readChar();
    }

    void writeObject(ObjectOutputStream out) throws IOException {
        out.writeChar(methodId);
    }
}
