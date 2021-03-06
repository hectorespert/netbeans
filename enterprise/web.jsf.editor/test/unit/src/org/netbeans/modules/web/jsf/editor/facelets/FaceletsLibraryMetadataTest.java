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
package org.netbeans.modules.web.jsf.editor.facelets;

import org.netbeans.junit.NbTestCase;
import org.netbeans.modules.web.common.taginfo.LibraryMetadata;

/**
 *
 * @author Martin Fousek <marfous@netbeans.org>
 */
public class FaceletsLibraryMetadataTest extends NbTestCase {

    public FaceletsLibraryMetadataTest(String name) {
        super(name);
    }

    public void testObtainingLibraryMetadata() {
        // JSF2.2 namespace
        LibraryMetadata metadata = FaceletsLibraryMetadata.get("http://xmlns.jcp.org/jsf/html");
        assertNotNull(metadata);

        // legacy namespace
        metadata = FaceletsLibraryMetadata.get("http://java.sun.com/jsf/html");
        assertNotNull(metadata);

        // third party library
        metadata = FaceletsLibraryMetadata.get("http://primefaces.org/ui");
        assertNull(metadata);
    }

}
