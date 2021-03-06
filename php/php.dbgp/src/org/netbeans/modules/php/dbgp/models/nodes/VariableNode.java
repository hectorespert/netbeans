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
package org.netbeans.modules.php.dbgp.models.nodes;

import org.netbeans.modules.php.dbgp.ModelNode;
import org.openide.text.Line;

/**
 * @author ads
 *
 */
public interface VariableNode extends ModelNode {
    public static final String LOCAL_VARIABLE_ICON = "org/netbeans/modules/debugger/resources/localsView/LocalVariable"; // NOI18N

    /**
     * Differs from {@link #getName()}. Returns full name together with parent
     * mention. F. e. for variable $arr['key'] string "$arr['key']" will be
     * returned, for variable $var : "$var".
     *
     * @return full name of variable
     */
    String getFullName();

    /**
     * Returns only short name of variable. F.e. for $var : "var", for
     * $arr['key'] : "key".
     *
     * @return short name of variable or memeber.
     */
    @Override
    String getName();

    Line findDeclarationLine();

}
