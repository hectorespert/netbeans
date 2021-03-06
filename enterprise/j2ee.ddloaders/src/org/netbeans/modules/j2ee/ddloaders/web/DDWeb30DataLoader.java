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
package org.netbeans.modules.j2ee.ddloaders.web;

import java.io.IOException;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;

/**
 * A data loader for web.xml version 3.0. Required for providing
 * a different action context than for older versions - see #85570.
 *
 * @author Erno Mononen
 */
public class DDWeb30DataLoader extends DDDataLoader {

    private static final long serialVersionUID = 1L;

    public static final String REQUIRED_MIME = "text/x-dd-servlet3.0"; // NOI18N
    public static final String REQUIRED_MIME_31 = "text/x-dd-servlet3.1"; // NOI18N

    public DDWeb30DataLoader() {
        super("org.netbeans.modules.j2ee.ddloaders.web.DDDataObject");  // NOI18N
    }

    @Override
    protected String actionsContext() {
        return "Loaders/text/x-dd-web3.0/Actions/"; // NOI18N
    }

    @Override
    protected String[] getSupportedMimeTypes() {
        return new String[]{REQUIRED_MIME, REQUIRED_MIME_31};
    }

    @Override
    protected MultiDataObject createMultiObject(FileObject primaryFile) throws DataObjectExistsException, IOException {
        return createMultiObject(primaryFile, REQUIRED_MIME);
    }

}
