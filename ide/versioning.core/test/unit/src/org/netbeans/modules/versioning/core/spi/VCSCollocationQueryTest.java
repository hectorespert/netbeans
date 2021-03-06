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
package org.netbeans.modules.versioning.core.spi;

import java.io.IOException;
import org.openide.filesystems.FileStateInvalidException;

import java.io.File;
import org.netbeans.api.queries.CollocationQuery;
import org.netbeans.junit.NbTestCase;
import org.netbeans.modules.versioning.core.spi.testvcs.TestVCS;
import org.netbeans.modules.versioning.core.spi.testvcs.TestVCSCollocationQuery;
import org.openide.util.test.MockLookup;

/**
 * Versioning SPI unit tests of VcsCollocationQueryImplementation.
 * 
 * @author Tomas Stupka
 */
public class VCSCollocationQueryTest extends NbTestCase {
    

    public VCSCollocationQueryTest(String testName) {
        super(testName);
        MockLookup.setLayersAndInstances();
    }

    protected void setUp() throws Exception {
        MockLookup.setLayersAndInstances();
        File userdir = new File(getWorkDir() + "userdir");
        userdir.mkdirs();
        System.setProperty("netbeans.user", userdir.getAbsolutePath());
        super.setUp();
    }

    public void testFindRootExisting() throws FileStateInvalidException, IOException, Exception {
        File folder = createVersionedFolder();
        folder.mkdirs();
        File file = new File(folder, "somefile");
        file.createNewFile();
        
        assertRoot(folder, file);
    }
    
    public void testBlankInPath() throws FileStateInvalidException, IOException, Exception {
        File folder = createVersionedFolder();
        File folder2 = new File(folder, "some folder");
        folder2.mkdirs();
        File file = new File(folder2, "somefile");
        
        assertRoot(folder, file);
    }

    public void testFindRootNotExisting() throws FileStateInvalidException, IOException, Exception {
        File folder = createVersionedFolder();
        File file = new File(folder, "dontexist");
        assertRoot(folder, file);
    }
    
    public void testFindRootBogusFile() throws FileStateInvalidException, IOException, Exception {
        assertNull(CollocationQuery.findRoot(new File("/a/b/c").toURI()));
    }
    
    private void assertRoot(File root, File file) {
        assertEquals(root.toURI(), CollocationQuery.findRoot(file.toURI()));
    }
    
    public void testAreCollocatedExisting() throws FileStateInvalidException, IOException, Exception {
        File folder = createVersionedFolder();

        File file1 = new File(folder, "file2" + TestVCSCollocationQuery.COLLOCATED_FILENAME_SUFFIX);
        file1.createNewFile();
        File file2 = new File(folder, "file1" + TestVCSCollocationQuery.COLLOCATED_FILENAME_SUFFIX);
        file2.createNewFile();
        
        assertCollocated(true, file1, file2);
    }
    
    public void testAreCollocatedNotExisting() throws FileStateInvalidException, IOException, Exception {
        File folder = createVersionedFolder();

        File file1 = new File(folder, "file2" + TestVCSCollocationQuery.COLLOCATED_FILENAME_SUFFIX);
        file1.createNewFile();
        File file2 = new File(folder, "file1" + TestVCSCollocationQuery.COLLOCATED_FILENAME_SUFFIX);
        file2.createNewFile();
        
        assertCollocated(true, file1, file2);
    }
    
    
    public void testNotCollocatedExisting() throws FileStateInvalidException, IOException, Exception {
        File folder = createVersionedFolder();

        File file1 = new File(folder, "file1");
        file1.createNewFile();
        File file2 = new File(folder, "file2");
        file2.createNewFile();
        
        assertCollocated(false, file1, file2);
    }
    
    public void testNotCollocatedNotExisting() throws FileStateInvalidException, IOException, Exception {
        File folder = createVersionedFolder();

        File file1 = new File(folder, "file1");
        file1.createNewFile();
        File file2 = new File(folder, "file2");
        file2.createNewFile();
        
        assertCollocated(false, file1, file2);
    }
    
    void assertCollocated(boolean expected, File file1, File file2) {
        if(expected) {
            assertTrue(CollocationQuery.areCollocated(file1.toURI(), file2.toURI()));
        } else {
            assertFalse(CollocationQuery.areCollocated(file1.toURI(), file2.toURI()));
        }
    }

    private File createVersionedFolder() throws IOException {
        File folder = new File(getWorkDir(), TestVCS.VERSIONED_FOLDER_SUFFIX);
        new File(folder, TestVCS.TEST_VCS_METADATA).mkdirs();
        return folder;
    }
    
}
