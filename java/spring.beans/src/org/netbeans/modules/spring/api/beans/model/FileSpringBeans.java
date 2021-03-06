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

package org.netbeans.modules.spring.api.beans.model;

import java.util.List;
import java.util.Set;

/**
 * Encapsulates the Spring beans in a file. All beans obtained through
 * this interface are guaranteed to return a non-null value from
 * {@link SpringBean#getLocation}, and the location is guaranteed to
 * provide a valid start offset.
 *
 * @author Andrei Badea
 */
public interface FileSpringBeans {

    /**
     * Finds a bean by its id or name.
     *
     * @param  idOrName the bean id or name; never null.
     * @return the bean with the specified id or name; {@code null} if no such
     *         bean was found.
     */
    SpringBean findBean(String idOrName);

    /**
     * Finds a bean by its id.
     *
     * @param  name the bean id or name; never null.
     * @return the bean with the specified id or name; {@code null} if no such
     *         bean was found.
     */
    SpringBean findBeanByID(String id);

    /**
     * Returns the list of beans in this beans config file.
     *
     * @param  file the beans config file.
     * @return the list of beans; never null.
     */
    List<SpringBean> getBeans();
    
    /**
     * Returns the name of the bean (or another alias) that the specied alias
     * aliases
     * 
     * @param name alias name
     * @return name of bean or alias; {@code null} if no such alias was found
     */
    String findAliasName(String alias);
    
    /**
     * Returns all registered aliases in this beans config file
     * 
     * @return aliases; never null
     */
    Set<String> getAliases();
}
