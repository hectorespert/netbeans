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
package org.netbeans.spi.extexecution.base;

import java.util.Map;
import org.netbeans.api.annotations.common.CheckForNull;
import org.netbeans.api.annotations.common.NonNull;
import org.netbeans.api.extexecution.base.Environment;

/**
 * The interface representing the implementation
 * of {@link Environment}.
 *
 * @see Environment
 * @author Petr Hejl
 */
public interface EnvironmentImplementation {

    /**
     * Returns the value of the variable or <code>null</code>.
     *
     * @param name the name of the variable
     * @return the value of the variable or <code>null</code>
     */
    @CheckForNull
    String getVariable(@NonNull String name);

    /**
     * Appends a path to a path-like variable. The proper path separator should
     * be used to separate the new value.
     *
     * @param name the name of the variable such as for example
     *             <code>PATH</code> or <code>LD_LIBRARY_PATH</code>
     * @param value the value (path to append)
     */
    void appendPath(@NonNull String name, @NonNull String value);

    /**
     * Prepends a path to a path-like variable. The proper path separator should
     * be used to separate the new value.
     *
     * @param name the name of the variable such as for example
     *             <code>PATH</code> or <code>LD_LIBRARY_PATH</code>
     * @param value the value (path to prepend)
     */
    void prependPath(@NonNull String name, @NonNull String value);

    /**
     * Sets a value for a variable with the given name.
     *
     * @param name the name of the variable
     * @param value the value
     */
    void setVariable(@NonNull String name, @NonNull String value);

    /**
     * Removes a variable with the given name. The subsequent call to
     * {@link #getVariable(java.lang.String)} with the same argument should
     * return <code>null</code>.
     *
     * @param name the name of the variable
     */
    void removeVariable(@NonNull String name);

    /**
     * Returns all variable names and associated values as a {@link Map}.
     * Changes to the map <i>must not</i> be propagated back to the
     * {@link Environment}.
     *
     * @return all variable names and associated values
     */
    @NonNull
    Map<String, String> values();

}
