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

package org.netbeans.modules.j2ee.dd.impl.client.annotation;

import org.netbeans.modules.j2ee.dd.api.client.AppClient;
import org.netbeans.modules.j2ee.dd.api.client.AppClientMetadata;

/**
 * Default implementation of {@link AppClientMetadata}.
 * @author Tomas Mysik
 */
public class AppClientMetadataImpl implements AppClientMetadata {
    
    private final AppClient appClient;
    
    /**
     * Constructor with all properties.
     * @param appClient model of application client.
     */
    public AppClientMetadataImpl(AppClient appClient) {
        this.appClient = appClient;
    }

    public AppClient getRoot() {
        return appClient;
    }
}
