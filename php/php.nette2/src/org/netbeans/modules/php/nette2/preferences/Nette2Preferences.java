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
package org.netbeans.modules.php.nette2.preferences;

import java.util.prefs.Preferences;
import org.netbeans.modules.php.api.phpmodule.PhpModule;
import org.netbeans.modules.php.nette2.Nette2FrameworkProvider;

/**
 *
 * @author Ondrej Brejla <obrejla@netbeans.org>
 */
public final class Nette2Preferences {
    private static final String MANUALLY_ENABLED = "manually-enabled"; //NOI18N

    private Nette2Preferences() {
    }

    public static boolean isManuallyEnabled(PhpModule module) {
        return getPreferences(module).getBoolean(MANUALLY_ENABLED, false);
    }

    public static void setManuallyEnabled(PhpModule module, boolean enabled) {
        getPreferences(module).putBoolean(MANUALLY_ENABLED, enabled);
    }

    private static Preferences getPreferences(PhpModule module) {
        return module.getPreferences(Nette2FrameworkProvider.class, true);
    }

}
