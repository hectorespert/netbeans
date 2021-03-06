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
package org.openide.util.lookup.implspi;

import java.lang.ref.ReferenceQueue;
import java.security.Permission;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActiveQueueWithSecurityManagerTest {

    public ActiveQueueWithSecurityManagerTest() {
    }

    @Test
    public void testQueue() {
        final Thread[] raised = { null };
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkAccess(Thread t) {
                if (t.getName().startsWith("Active")) {
                    raised[0] = t;
                    throw new SecurityException();
                }
            }

            @Override
            public void checkPermission(Permission perm) {
            }
        });
        ReferenceQueue<Object> result = ActiveQueue.queue();
        System.setSecurityManager(null);
        assertNotNull("The thread has been prevented from being started", raised[0]);
        assertEquals("Active Reference Queue Daemon", raised[0].getName());
        assertNotNull("ActiveQueue can be created in spite of that", result);
    }

}
