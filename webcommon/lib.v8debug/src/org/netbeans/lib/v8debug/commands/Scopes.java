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
package org.netbeans.lib.v8debug.commands;

import org.netbeans.lib.v8debug.PropertyLong;
import org.netbeans.lib.v8debug.V8Arguments;
import org.netbeans.lib.v8debug.V8Body;
import org.netbeans.lib.v8debug.V8Command;
import org.netbeans.lib.v8debug.V8Request;
import org.netbeans.lib.v8debug.V8Scope;

/**
 *
 * @author Martin Entlicher
 */
public final class Scopes {

    private Scopes() {
    }

    public static V8Request createRequest(long sequence) {
        return new V8Request(sequence, V8Command.Scopes, null);
    }

    public static V8Request createRequest(long sequence, long frameNumber) {
        return new V8Request(sequence, V8Command.Scopes, new Arguments(frameNumber));
    }

    public static final class Arguments extends V8Arguments {

        private final PropertyLong frameNumber;

        public Arguments(Long frameNumber) {
            this.frameNumber = new PropertyLong(frameNumber);
        }

        public PropertyLong getFrameNumber() {
            return frameNumber;
        }
    }

    public static final class ResponseBody extends V8Body {

        private final long fromScope;
        private final long toScope;
        private final long totalScopes;
        private final V8Scope[] scopes;

        public ResponseBody(long fromScope, long toScope, long totalScopes,
                            V8Scope[] scopes) {
            this.fromScope = fromScope;
            this.toScope = toScope;
            this.totalScopes = totalScopes;
            this.scopes = scopes;
        }

        public long getFromScope() {
            return fromScope;
        }

        public long getToScope() {
            return toScope;
        }

        public long getTotalScopes() {
            return totalScopes;
        }

        public V8Scope[] getScopes() {
            return scopes;
        }
    }

}
