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

package org.netbeans.modules.terminal.api.ui;

import org.openide.windows.IOContainer;
import org.openide.windows.TopComponent;

/**
 * A mixin interface for specific TopComponents which provide an IOContainer.
 * SHOULD go into org.openide.windows?
 * @author ivan
 */
public interface IOTopComponent {
    /**
     * Return the IOContainer contained in this object.
     * @return The IOContainer contained in this object.
     */
    public IOContainer ioContainer();

    /**
     * Return itself as a TopComponent.
     * @return itself as a TopComponent.
     */
    public TopComponent topComponent();
}
