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

import org.netbeans.lib.v8debug.V8Arguments;
import org.netbeans.lib.v8debug.V8Body;
import org.netbeans.lib.v8debug.V8Command;
import org.netbeans.lib.v8debug.V8ExceptionBreakType;
import org.netbeans.lib.v8debug.V8Request;

/**
 *
 * @author Martin Entlicher
 */
public final class SetExceptionBreak {
    
    private SetExceptionBreak() {}
    
    public static V8Request createRequest(long sequence, V8ExceptionBreakType type, boolean enabled) {
        return new V8Request(sequence, V8Command.Setexceptionbreak, new Arguments(type, enabled));
    }
    
    public static final class Arguments extends V8Arguments {
        
        private final V8ExceptionBreakType type;
        private final boolean enabled;
        
        public Arguments(V8ExceptionBreakType type, boolean enabled) {
            this.type = type;
            this.enabled = enabled;
        }

        public V8ExceptionBreakType getType() {
            return type;
        }

        public boolean isEnabled() {
            return enabled;
        }
    }
    
    public static final class ResponseBody extends V8Body {
        
        private final V8ExceptionBreakType type;
        private final boolean enabled;
        
        public ResponseBody(V8ExceptionBreakType type, boolean enabled) {
            this.type = type;
            this.enabled = enabled;
        }
        
        public V8ExceptionBreakType getType() {
            return type;
        }

        public boolean isEnabled() {
            return enabled;
        }
    }
}
