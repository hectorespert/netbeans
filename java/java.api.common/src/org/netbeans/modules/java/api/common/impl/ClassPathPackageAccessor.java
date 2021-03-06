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
package org.netbeans.modules.java.api.common.impl;

import org.netbeans.api.annotations.common.NonNull;
import org.netbeans.modules.java.api.common.ant.UpdateHelper;
import org.netbeans.modules.java.api.common.classpath.ClassPathModifierSupport;
import org.netbeans.modules.java.api.common.classpath.ClassPathSupport;
import org.netbeans.spi.project.support.ant.ReferenceHelper;
import org.openide.util.Parameters;

/**
 * Used by ActionFilterNode to call {@link ClassPathModifierSupport#removeUnusedReference}.
 * Todo: Rewrite ActionFilterNode to use ClassPathModifierSupport.
 * @author Tomas Zezula
 */
public abstract class ClassPathPackageAccessor {
    
    private static volatile ClassPathPackageAccessor instance;
    
    
    public static synchronized ClassPathPackageAccessor getInstance() {
        if (instance == null) {
            try {
                Class.forName(ClassPathModifierSupport.class.getName(),true,ClassPathPackageAccessor.class.getClassLoader());
                assert instance != null;
            } catch (ClassNotFoundException ex) {
                throw new IllegalStateException(ex);
            }
        }
        return instance;
    }
    
    public static void setInstance(@NonNull final ClassPathPackageAccessor _instance) {
        Parameters.notNull("_instance", _instance);     //NOI18N
        instance = _instance;
    }
    
    public abstract boolean removeUnusedReference(
        @NonNull ClassPathSupport.Item item,
        @NonNull String classPathProperty,
        @NonNull UpdateHelper updateHelper,
        @NonNull ReferenceHelper rh);
}
