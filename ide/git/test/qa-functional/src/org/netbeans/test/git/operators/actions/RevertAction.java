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
package org.netbeans.test.git.operators.actions;

import org.netbeans.jellytools.actions.ActionNoBlock;

/**
 *
 * @author kanakmar
 */
public class RevertAction extends ActionNoBlock {

    /**
     * "Git" menu item.
     */
    public static final String GIT_ITEM = "Git";

    /**
     * "Revert" menu item.
     */
    public static final String REVERT_ITEM = "Revert Modifications...";

    /**
     * Creates a new instance of RevertAction
     */
    public RevertAction() {
        super(GIT_ITEM + "|" + REVERT_ITEM, GIT_ITEM + "|" + REVERT_ITEM);
    }

}
