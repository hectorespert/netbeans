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

package org.netbeans.modules.j2ee.persistence.api.metadata.orm;

public interface Id {

    public void setName(String value);

    public String getName();
    
    public void setColumn(Column value);
    
    public Column getColumn();
    
    public Column newColumn();
    
    public void setGeneratedValue(GeneratedValue value);
    
    public GeneratedValue getGeneratedValue();
    
    public GeneratedValue newGeneratedValue();
    
    public void setTemporal(String value);
    
    public String getTemporal();
    
    public void setTableGenerator(TableGenerator value);
    
    public TableGenerator getTableGenerator();
    
    public TableGenerator newTableGenerator();
    
    public void setSequenceGenerator(SequenceGenerator value);
    
    public SequenceGenerator getSequenceGenerator();
    
    public SequenceGenerator newSequenceGenerator();
    
}
