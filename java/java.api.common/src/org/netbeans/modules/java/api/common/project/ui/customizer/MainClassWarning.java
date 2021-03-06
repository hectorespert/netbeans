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

package org.netbeans.modules.java.api.common.project.ui.customizer;

import java.util.Collection;
import javax.lang.model.element.TypeElement;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;

import org.netbeans.api.java.source.ElementHandle;
import org.openide.filesystems.FileObject;

/** Shows a warning that no main class is set and allows choose a main class.
 *
 * @author  Jiri Rechtacek
 */
public class MainClassWarning extends JPanel {

    private final String message;
    private final FileObject[] sourcesRoots;
    private final Collection<ElementHandle<TypeElement>> mainClasses;

    /** Creates new form LibrariesChooser */
    public MainClassWarning (final String message, final FileObject[] sourcesRoots) {
        this (message,sourcesRoots,null);
    }
    
    public MainClassWarning (String message, final Collection<ElementHandle<TypeElement>> mainClasses) {
        this (message,null,mainClasses);
    }
    
    private MainClassWarning (final String message, final FileObject[] sourcesRoots, final Collection<ElementHandle<TypeElement>> mainClasses) {
        assert (sourcesRoots != null && mainClasses == null) || (sourcesRoots == null && mainClasses != null);
        this.sourcesRoots = sourcesRoots;
        this.message = message;
        this.mainClasses = mainClasses;
        initComponents();
    }
        
    /** Returns the selected main class.
     *
     * @return name of class or null if no class with the main method is selected
     */ 
    public String getSelectedMainClass () {
        return ((MainClassChooser)jPanel1).getSelectedMainClass ();
    }

    public void addChangeListener (ChangeListener l) {
        ((MainClassChooser)jPanel1).addChangeListener (l);
    }
    
    public void removeChangeListener (ChangeListener l) {
        ((MainClassChooser)jPanel1).removeChangeListener (l);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = createMainClassChooser();

        setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, this.message);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 6, 12);
        add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 12, 12);
        add(jPanel1, gridBagConstraints);

        getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getBundle(MainClassWarning.class).getString("AD_MainClassWarning")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    
    private MainClassChooser createMainClassChooser () {
        if (sourcesRoots != null) {
            return createMainClassChooser(sourcesRoots);
        }
        else {
            return createMainClassChooser(mainClasses);
        }
    }
    
    private static MainClassChooser createMainClassChooser (final FileObject[] sourceRoots) {
        return new MainClassChooser(sourceRoots, org.openide.util.NbBundle.getBundle(MainClassWarning.class).getString("CTL_SelectAvaialableMainClasses"));
    }
    
    private static MainClassChooser createMainClassChooser (final Collection<ElementHandle<TypeElement>> mainClasses) {
        return new MainClassChooser (mainClasses,org.openide.util.NbBundle.getBundle(MainClassWarning.class).getString("CTL_SelectAvaialableMainClasses"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables


}
