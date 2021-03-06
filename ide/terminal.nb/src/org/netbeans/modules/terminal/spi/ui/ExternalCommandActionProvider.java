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
package org.netbeans.modules.terminal.spi.ui;

import java.util.Collection;
import org.netbeans.modules.terminal.ioprovider.Terminal;
import org.openide.util.Lookup;

/**
 *
 * @author igromov
 */
public abstract class ExternalCommandActionProvider {

    protected abstract boolean canHandle(String command);
    public abstract void handle(String command, Lookup lookup);

    // helpers //

    private static final Collection<? extends ExternalCommandActionProvider> PROVIDERS
            = Lookup.getDefault().lookupAll(ExternalCommandActionProvider.class);

    public static ExternalCommandActionProvider getProvider(String command) {
        for (ExternalCommandActionProvider provider : PROVIDERS) {
            if (provider.canHandle(command)) {
                return provider;
            }
        }
        return new ExternalCommandActionProvider() {

            @Override
            public boolean canHandle(String command) {
                return true;
            }

            @Override
            public void handle(String command, Lookup lookup) {}
        };
    }
}

//enum Result {
//    FAILED,
//    PARTIAL_SUCCESS,
//    SUCCEED;
//}
