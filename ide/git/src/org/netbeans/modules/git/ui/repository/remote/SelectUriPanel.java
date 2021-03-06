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

/*
 * SelectUriPanel.java
 *
 * Created on Feb 8, 2011, 4:37:51 PM
 */

package org.netbeans.modules.git.ui.repository.remote;

import javax.swing.JPanel;
import org.openide.util.NbBundle;

/**
 *
 * @author ondra
 */
public class SelectUriPanel extends javax.swing.JPanel {

    /** Creates new form SelectUriPanel */
    SelectUriPanel(JPanel panel) {
        initComponents();
        repositoryPanel.add(panel);
        setName(NbBundle.getMessage(SelectUriPanel.class, "LBL_SelectUriPanel.name")); //NOI18N
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();

        buttonGroup1.add(rbConfiguredUri);
        org.openide.awt.Mnemonics.setLocalizedText(rbConfiguredUri, org.openide.util.NbBundle.getMessage(SelectUriPanel.class, "SelectUriPanel.rbConfiguredUri.text")); // NOI18N
        rbConfiguredUri.setToolTipText(org.openide.util.NbBundle.getMessage(SelectUriPanel.class, "SelectUriPanel.rbConfiguredUri.toolTipText")); // NOI18N

        buttonGroup1.add(rbCreateNew);
        org.openide.awt.Mnemonics.setLocalizedText(rbCreateNew, org.openide.util.NbBundle.getMessage(SelectUriPanel.class, "SelectUriPanel.rbCreateNew.text")); // NOI18N
        rbCreateNew.setToolTipText(org.openide.util.NbBundle.getMessage(SelectUriPanel.class, "SelectUriPanel.rbCreateNew.toolTipText")); // NOI18N

        cmbConfiguredRepositories.setToolTipText(org.openide.util.NbBundle.getMessage(SelectUriPanel.class, "SelectUriPanel.cmbConfiguredRepositories.TTtext")); // NOI18N

        repositoryPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout progressPanelLayout = new javax.swing.GroupLayout(progressPanel);
        progressPanel.setLayout(progressPanelLayout);
        progressPanelLayout.setHorizontalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        progressPanelLayout.setVerticalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        lblRemoteNames.setLabelFor(cmbRemoteNames);
        org.openide.awt.Mnemonics.setLocalizedText(lblRemoteNames, org.openide.util.NbBundle.getMessage(SelectUriPanel.class, "SelectUriPanel.lblRemoteNames.text")); // NOI18N
        lblRemoteNames.setToolTipText(org.openide.util.NbBundle.getMessage(SelectUriPanel.class, "SelectUriPanel.jLabel1.TTtext")); // NOI18N

        cmbRemoteNames.setEditable(true);

        cbPersistRemote.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(cbPersistRemote, org.openide.util.NbBundle.getMessage(SelectUriPanel.class, "SelectUriPanel.cbPersistRemote.text")); // NOI18N
        cbPersistRemote.setToolTipText(org.openide.util.NbBundle.getMessage(SelectUriPanel.class, "SelectUriPanel.cbPersistRemote.TTtext")); // NOI18N

        javax.swing.GroupLayout remotesPanelLayout = new javax.swing.GroupLayout(remotesPanel);
        remotesPanel.setLayout(remotesPanelLayout);
        remotesPanelLayout.setHorizontalGroup(
            remotesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(remotesPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblRemoteNames)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbRemoteNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPersistRemote)
                .addGap(0, 0, 0))
        );
        remotesPanelLayout.setVerticalGroup(
            remotesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(remotesPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(remotesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRemoteNames)
                    .addComponent(cmbRemoteNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPersistRemote))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(progressPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(cmbConfiguredRepositories, 0, 608, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(repositoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(remotesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rbConfiguredUri)
                            .addComponent(rbCreateNew))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbConfiguredUri)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbConfiguredRepositories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbCreateNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(remotesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(repositoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    final javax.swing.JCheckBox cbPersistRemote = new javax.swing.JCheckBox();
    final javax.swing.JComboBox cmbConfiguredRepositories = new javax.swing.JComboBox();
    final javax.swing.JComboBox cmbRemoteNames = new javax.swing.JComboBox();
    final javax.swing.JLabel lblRemoteNames = new javax.swing.JLabel();
    final javax.swing.JPanel progressPanel = new javax.swing.JPanel();
    final javax.swing.JRadioButton rbConfiguredUri = new javax.swing.JRadioButton();
    final javax.swing.JRadioButton rbCreateNew = new javax.swing.JRadioButton();
    final javax.swing.JPanel remotesPanel = new javax.swing.JPanel();
    final javax.swing.JPanel repositoryPanel = new javax.swing.JPanel();
    // End of variables declaration//GEN-END:variables

}
