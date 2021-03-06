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
package org.netbeans.modules.javaee.resources.impl.model;

import java.util.List;
import javax.lang.model.element.AnnotationValue;
import org.netbeans.modules.j2ee.metadata.model.api.support.annotation.parser.ArrayValueHandler;

/**
 *
 * @author Martin Fousek <marfous@netbeans.org>
 */
public class JndiResourcesValueHandlers {

    public static final class PropertiesArrayValueHandler implements ArrayValueHandler {

        private final List<String> properties;

        public PropertiesArrayValueHandler(List<String> properties) {
            this.properties = properties;
        }

        @Override
        public Object handleArray(List<AnnotationValue> arrayMembers) {
            for (AnnotationValue arrayMember : arrayMembers) {
                String value = arrayMember.getValue().toString();
                properties.add(value);
            }
            return null;
        }
    
    }

}
