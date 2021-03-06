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
 * CreateBranchPanel.java
 *
 * Created on Oct 18, 2010, 3:28:45 PM
 */

package org.netbeans.modules.git.ui.tag;

import org.netbeans.modules.git.ui.branch.*;
import javax.swing.JPanel;
import org.netbeans.modules.git.ui.repository.RevisionDialog;

/**
 *
 * @author ondra
 */
public class CreateTagPanel extends JPanel {
    private final RevisionDialog revisionPanel;

    /** Creates new form CreateBranchPanel */
    public CreateTagPanel (RevisionDialog revisionPanel) {
        this.revisionPanel = revisionPanel;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.netbeans.modules.git.ui.repository.RevisionDialog revisionPickerDialog1 = this.revisionPanel;
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();

        jLabel1.setLabelFor(tagNameField);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(CreateTagPanel.class, "CreateTagPanel.jLabel1.text")); // NOI18N

        tagNameField.setText(org.openide.util.NbBundle.getMessage(CreateTagPanel.class, "CreateTagPanel.tagNameField.text")); // NOI18N

        lblInfo.setIcon(org.openide.util.ImageUtilities.loadImageIcon("/org/netbeans/modules/git/resources/icons/info.png", false)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(lblInfo, org.openide.util.NbBundle.getMessage(CreateTagPanel.class, "MSG_CreateTag.errorTagExists")); // NOI18N

        jLabel2.setLabelFor(tagMessageField);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(CreateTagPanel.class, "CreateTagPanel.jLabel2.text")); // NOI18N

        tagMessageField.setColumns(20);
        tagMessageField.setRows(5);
        jScrollPane1.setViewportView(tagMessageField);

        org.openide.awt.Mnemonics.setLocalizedText(cbForceUpdate, org.openide.util.NbBundle.getMessage(CreateTagPanel.class, "CreateTagPanel.cbForceUpdate.text")); // NOI18N
        cbForceUpdate.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(revisionPickerDialog1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tagNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                    .addComponent(lblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(cbForceUpdate))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tagNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbForceUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(revisionPickerDialog1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(lblInfo)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    final javax.swing.JCheckBox cbForceUpdate = new javax.swing.JCheckBox();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    final javax.swing.JLabel lblInfo = new javax.swing.JLabel();
    final javax.swing.JTextArea tagMessageField = new javax.swing.JTextArea();
    final javax.swing.JTextField tagNameField = new javax.swing.JTextField();
    // End of variables declaration//GEN-END:variables

}
