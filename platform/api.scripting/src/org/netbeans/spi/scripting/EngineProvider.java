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
package org.netbeans.spi.scripting;

import java.util.List;
import java.util.ServiceLoader;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

/** Provider of additional {@link ScriptEngineFactory} implementations.
 * Register into {@link ServiceLoader} pool of services.
 *
 * @since 1.0
 */
public interface EngineProvider {
    /** Provide additional factories. Searches the system in a custom way
     * to find and instantiate additional (to those registered via
     * {@code META-INF/services/javax.script.ScriptEngineFactory} way)
     * factories.
     *
     * @return list of additional factories
     */
    public List<ScriptEngineFactory> factories();

    /** Provide additional factories. Searches the system in a custom way
     * to find and instantiate additional (to those registered via
     * {@code META-INF/services/javax.script.ScriptEngineFactory} way)
     * factories.
     *
     * @param m the manager to associate the factories with
     * @return list of additional factories
     * @since 1.2
     */
    public default List<? extends ScriptEngineFactory> factories(ScriptEngineManager m) {
        return factories();
    }
}
