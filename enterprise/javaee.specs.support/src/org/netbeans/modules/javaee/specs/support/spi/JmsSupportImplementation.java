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
package org.netbeans.modules.javaee.specs.support.spi;

import org.netbeans.api.annotations.common.CheckForNull;
import org.netbeans.api.annotations.common.NonNull;

/**
 * Defines server specific JMS support.
 *
 * @author Martin Fousek <marfous@netbeans.org>
 * @since 1.13
 */
public interface JmsSupportImplementation {

    /**
     * Whether should be used 'mappedName' attribute of the @MessageDriven in projects targeting Java EE6
     * and lower to specify the destination. In another words, whether server supports mappedName attribute.
     *
     * @return {@code true} if the mappedName can be used and generated in EE6- projects, {@code false} otherwise
     */
    boolean useMappedName();

    /**
     * Whether can be used EE7 specific 'destinationLookup' Activation Config Property. Tells that the
     * server is Java EE7 platform complied.
     *
     * @return {@code true} if the 'destinationLookup' ACP can be used in destination specification, {@code false}
     * otherwise
     */
    boolean useDestinationLookup();

    /**
     * Activation config property to generate into the 'activationConfig' attribute of the @MessageDriven
     * annotation. Can be {@code null} in case that no @ActivationConfigProperty is supported.
     * <p>
     * This property will be used for projects targeting JavaEE6 or lower EE platform.
     *
     * @return property name if any, {@code null} otherwise
     */
    @CheckForNull
    String activationConfigProperty();



}
