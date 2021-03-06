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

package org.netbeans.modules.php.editor.model.impl;

/**
 * This interface says that the scope is not build directly, but lazy, when
 * it's needed. One example are bodies of methods. The model for the bodies
 * doesn't have to be build for all method at once, if it's necessary.
 * Through this interface a feature can find out, whether the model contains
 * information from the ASTNode and also can invoke to build model for the ASTNode.
 *
 * @author PetrPisl
 */
public interface LazyBuild {

    /**
     *
     * @return true, if the model already contains information, false when
     * the model doesn't contain the information.
     */
    boolean isScanned();

    /**
     * Create the model for the scope.
     */
    void scan();

}
