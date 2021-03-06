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

package org.netbeans.modules.j2ee.dd.impl.ejb.annotation;

import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.OutputStream;
import org.netbeans.modules.j2ee.dd.api.ejb.ActivationConfigProperty;

public class ActivationConfigPropertyImpl implements ActivationConfigProperty {

    private String name;
    private String value;

    public ActivationConfigPropertyImpl(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getActivationConfigPropertyName() {
        return name;
    }

    public String getActivationConfigPropertyValue() {
        return value;
    }

    public Object clone() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void setActivationConfigPropertyName(String value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setActivationConfigPropertyValue(String value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setActivationConfigPropertyNameId(String value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getActivationConfigPropertyNameId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setActivationConfigPropertyValueId(String value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getActivationConfigPropertyValueId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setId(String value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object getValue(String propertyName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void write(OutputStream os) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}

