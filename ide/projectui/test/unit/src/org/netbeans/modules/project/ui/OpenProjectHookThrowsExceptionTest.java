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

package org.netbeans.modules.project.ui;

import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectManager;
import org.netbeans.api.project.ui.OpenProjects;
import org.netbeans.junit.MockServices;
import org.netbeans.junit.NbTestCase;
import org.netbeans.modules.project.ui.actions.TestSupport;
import org.netbeans.spi.project.ui.ProjectOpenedHook;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.filesystems.URLMapper;
import org.openide.nodes.Node;
import org.openide.nodes.NodeEvent;
import org.openide.nodes.NodeListener;
import org.openide.nodes.NodeMemberEvent;
import org.openide.nodes.NodeReorderEvent;
import org.openide.util.RequestProcessor;
import org.openide.util.lookup.Lookups;

/** 
 *
 * @author Milos Kleint
 */
public class OpenProjectHookThrowsExceptionTest extends NbTestCase {
    CountDownLatch down;
    
    public OpenProjectHookThrowsExceptionTest(String testName) {
        super(testName);
    }            

    @Override
    protected void setUp() throws Exception {
        clearWorkDir();
        
        MockServices.setServices(TestSupport.TestProjectFactory.class);
        
        FileObject workDir = FileUtil.toFileObject(getWorkDir());
        assertNotNull(workDir);
        
        down = new CountDownLatch(1);
        
        List<URL> list = new ArrayList<URL>();
        List<ExtIcon> icons = new ArrayList<ExtIcon>();
        List<String> names = new ArrayList<String>();
        for (int i = 0; i < 2; i++) {
            FileObject prj = TestSupport.createTestProject(workDir, "prj" + i);
            URL url = URLMapper.findURL(prj, URLMapper.EXTERNAL);
            list.add(url);
            names.add(url.toExternalForm());
            icons.add(new ExtIcon());
            TestSupport.TestProject tmp = (TestSupport.TestProject)ProjectManager.getDefault ().findProject (prj);
            assertNotNull("Project found", tmp);
            tmp.setLookup(Lookups.singleton(new TestProjectOpenedHookImpl(down)));
        }
        
        OpenProjectListSettings.getInstance().setOpenProjectsURLs(list);
        OpenProjectListSettings.getInstance().setOpenProjectsDisplayNames(names);
        OpenProjectListSettings.getInstance().setOpenProjectsIcons(icons);
        
        //compute project root node children in sync mode
        System.setProperty("test.projectnode.sync", "true");
    }

    public void testBehaviourOfProjectsLogicNode() throws Exception {
        
        Node logicalView = new ProjectsRootNode(ProjectsRootNode.LOGICAL_VIEW);
        L listener = new L();
        logicalView.addNodeListener(listener);
        
        assertEquals("2 children", 2, logicalView.getChildren().getNodesCount());
        listener.assertEvents("None", 0);
        assertEquals("No project opened yet", 0, TestProjectOpenedHookImpl.opened);
        
        for (Node n : logicalView.getChildren().getNodes()) {
            TestSupport.TestProject p = n.getLookup().lookup(TestSupport.TestProject.class);
            assertNull("No project of this type, yet", p);
        }
        
        // let project open code run
        down.countDown();
        TestProjectOpenedHookImpl.toOpen.await();
        
        assertEquals("All projects opened", 2, TestProjectOpenedHookImpl.opened);
        
        OpenProjectList.waitProjectsFullyOpen();

        Node[] nodes = logicalView.getChildren().getNodes();
        assertEquals("No projects open", 0, nodes.length);
        
        listener.assertEvents("Goal is to receive no events at all", 1);
        assertTrue("Finished", OpenProjects.getDefault().openProjects().isDone());
        assertFalse("Not cancelled, Finished", OpenProjects.getDefault().openProjects().isCancelled());
        Project[] arr = OpenProjects.getDefault().openProjects().get();
        assertEquals("zero projects to be opened", 0, arr.length);
    }
    
    private static class L implements NodeListener {
        public List<EventObject> events = new ArrayList<EventObject>();
        
        public void childrenAdded(NodeMemberEvent ev) {
            assertFalse("No event in AWT thread", EventQueue.isDispatchThread());
            events.add(ev);
        }

        public void childrenRemoved(NodeMemberEvent ev) {
            assertFalse("No event in AWT thread", EventQueue.isDispatchThread());
            events.add(ev);
        }

        public void childrenReordered(NodeReorderEvent ev) {
            assertFalse("No event in AWT thread", EventQueue.isDispatchThread());
            events.add(ev);
        }

        public void nodeDestroyed(NodeEvent ev) {
            assertFalse("No event in AWT thread", EventQueue.isDispatchThread());
            events.add(ev);
        }

        public void propertyChange(PropertyChangeEvent evt) {
            assertFalse("No event in AWT thread", EventQueue.isDispatchThread());
            events.add(evt);
        }

        final void assertEvents(String string, int i) {
            assertEquals(string + events, i, events.size());
            events.clear();
        }
        
    }
    
    private static class TestProjectOpenedHookImpl extends ProjectOpenedHook 
    implements Runnable {
        
        public static CountDownLatch toOpen = new CountDownLatch(2);
        public static int opened = 0;
        
        
        private CountDownLatch toWaitOn;
        
        public TestProjectOpenedHookImpl(CountDownLatch toWaitOn) {
            this.toWaitOn = toWaitOn;
        }
        
        protected void projectClosed() {
            
        }
        
        Project[] arr;
        public void run() {
            try {
                arr = OpenProjects.getDefault().openProjects().get(50, TimeUnit.MILLISECONDS);
            } catch (InterruptedException ex) {
                fail("Wrong exception");
            } catch (ExecutionException ex) {
                fail("Wrong exception");
            } catch (TimeoutException ex) {
                // OK
            }
        }
        
        protected void projectOpened() {
            assertFalse("Running", OpenProjects.getDefault().openProjects().isDone());
            // now verify that other threads do not see results from the Future
            RequestProcessor.getDefault().post(this).waitFinished();
            assertNull("TimeoutException thrown", arr);
            if (toWaitOn != null) {
                try {
                    toWaitOn.await();
                } catch (InterruptedException ex) {
                    throw new IllegalStateException(ex);
                }
            }
            opened++;
            toOpen.countDown();
            throw new NullPointerException("Throwing Null pointer from projectOpened()");
        }
        
    }
}
