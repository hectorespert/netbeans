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

package org.netbeans.modules.java.navigation.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import org.netbeans.modules.java.navigation.JavadocTopComponent;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;
import org.openide.windows.TopComponent;

/**
 * Action which shows Javadoc component.
 * 
 * @author Sandip V. Chitale (Sandip.Chitale@Sun.Com)
 */
public class JavadocAction extends AbstractAction {
    
    public JavadocAction() {
        super(NbBundle.getMessage(JavadocAction.class, "CTL_JavadocAction"));
        putValue(SMALL_ICON, ImageUtilities.loadImageIcon(JavadocTopComponent.ICON_PATH, true));
    }
    
    public void actionPerformed(ActionEvent evt) {
        TopComponent win = JavadocTopComponent.findInstance();
        win.open();
        win.requestActive();
    }
    
}
