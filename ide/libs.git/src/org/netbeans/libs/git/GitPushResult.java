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
package org.netbeans.libs.git;

import java.util.Map;

/**
 * Usually returned by a git push command, represents its result.
 * 
 * @author Ondra Vrabec
 */
public final class GitPushResult {

    private final Map<String, GitTransportUpdate> remoteRepositoryUpdates;
    private final Map<String, GitTransportUpdate> localRepositoryUpdates;

    GitPushResult (Map<String, GitTransportUpdate> remoteRepositoryUpdates, Map<String, GitTransportUpdate> localRepositoryUpdates) {
        this.remoteRepositoryUpdates = remoteRepositoryUpdates;
        this.localRepositoryUpdates = localRepositoryUpdates;
    }

    /**
     * @return collection of reference updates in a local repository
     */
    public Map<String, GitTransportUpdate> getLocalRepositoryUpdates () {
        return localRepositoryUpdates;
    }

    /**
     * @return collection of reference updates in a remote repository
     */
    public Map<String, GitTransportUpdate> getRemoteRepositoryUpdates () {
        return remoteRepositoryUpdates;
    }
}
