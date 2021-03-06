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
package org.netbeans.modules.php.dbgp.packets;

import java.util.Locale;

/**
 * @author ads
 *
 */
public enum Status {
    STARTING,
    STOPPING,
    STOPPED,
    RUNNING,
    BREAK;

    public boolean isStarting() {
        return STARTING.equals(this);
    }

    public boolean isStopping() {
        return STOPPING.equals(this);
    }

    public boolean isStopped() {
        return STOPPED.equals(this);
    }

    public boolean isRunning() {
        return RUNNING.equals(this);
    }

    public boolean isBreak() {
        return BREAK.equals(this);
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase(Locale.US);
    }

    public static Status forString(String str) {
        Status[] statuses = Status.values();
        for (Status status : statuses) {
            if (status.toString().equals(str)) {
                return status;
            }
        }
        return null;
    }

}
