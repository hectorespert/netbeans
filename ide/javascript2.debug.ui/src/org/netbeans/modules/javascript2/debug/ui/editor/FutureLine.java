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

package org.netbeans.modules.javascript2.debug.ui.editor;

import java.net.URL;
import org.openide.text.Line;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Martin
 */
class FutureLine extends Line {
    
    private final URL url;
    private final int lineNumber;
    
    public FutureLine(URL url, int lineNumber) {
        super(Lookups.fixed());
        this.url = url;
        this.lineNumber = lineNumber;
    }

    @Override
    public int getLineNumber() {
        return lineNumber;
    }
    
    public URL getURL() {
        return url;
    }

    @Override
    public void show(int kind, int column) {
    }

    @Override
    public void setBreakpoint(boolean b) {
    }

    @Override
    public boolean isBreakpoint() {
        return false;
    }

    @Override
    public void markError() {}

    @Override
    public void unmarkError() {}

    @Override
    public void markCurrentLine() {}

    @Override
    public void unmarkCurrentLine() {}
    
}
