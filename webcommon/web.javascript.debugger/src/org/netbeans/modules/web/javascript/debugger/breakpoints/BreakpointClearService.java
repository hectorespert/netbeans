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
package org.netbeans.modules.web.javascript.debugger.breakpoints;

import org.netbeans.api.debugger.Breakpoint;
import org.netbeans.api.debugger.DebuggerManagerAdapter;
import org.netbeans.api.debugger.LazyDebuggerManagerListener;
import org.netbeans.spi.debugger.DebuggerServiceRegistration;


/**
 * @author ads
 *
 */
@DebuggerServiceRegistration(types=LazyDebuggerManagerListener.class)
public class BreakpointClearService extends DebuggerManagerAdapter {
    
    /* (non-Javadoc)
     * @see org.netbeans.api.debugger.DebuggerManagerAdapter#breakpointRemoved(org.netbeans.api.debugger.Breakpoint)
     */
    @Override
    public void breakpointRemoved( Breakpoint breakpoint ) {
        if ( breakpoint instanceof AbstractBreakpoint ){
            ((AbstractBreakpoint)breakpoint).removed();
        }
    }
}
