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
package org.netbeans.modules.websvc.rest.codegen.model;



/**
 * @author ads
 *
 */
public class RestEntity {
    
    // CTOR for primitive types . Their value will be represented by String
    RestEntity( boolean isVoid ){
        if ( isVoid ){
            this.kind = EntityKind.VOID;
        }
        else {
            this.kind = EntityKind.PRIMITIVE;
        }
    }
    
    RestEntity( String typeFqn , boolean isCollection ){
        if ( isCollection ){
            this.kind = EntityKind.COLLECTION;
        }
        else {
            this.kind = EntityKind.ENTITY;
        }
        fqn = typeFqn;
    }
    
    
    /**
     * Designate type of entity ( return type or parameter type method ).  
     */
    public enum EntityKind {
        VOID,       // no type
        PRIMITIVE,  // all primitive Java types along with their boxed types and String
        COLLECTION, // collection or array of objects
        ENTITY;     // any other type 
    }
    
    public EntityKind getKind(){
        return kind;
    }
    
    public String getFqn(){
        return fqn;
    }

    private EntityKind kind;
    private String fqn;
}
