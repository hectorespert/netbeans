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
package org.netbeans.modules.maven.indexer.spi;

import java.util.List;
import org.netbeans.modules.maven.indexer.api.NBGroupInfo;
import org.netbeans.modules.maven.indexer.api.NBVersionInfo;
import org.netbeans.modules.maven.indexer.api.RepositoryInfo;

/**
 * Query to find dependency information of artifacts.Non mandatory for repository managers.
 * @author Milos Kleint
 */
public interface DependencyInfoQueries {

    ResultImplementation<NBVersionInfo> findDependencyUsage(String groupId, String artifactId, String version, List<RepositoryInfo> repoIds);
    
    ResultImplementation<NBGroupInfo> findDependencyUsageGroups(String groupId, String artifactId, String version, List<RepositoryInfo> repoIds);

}
