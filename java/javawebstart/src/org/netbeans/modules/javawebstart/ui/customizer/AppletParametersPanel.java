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
 * AppletParametersPanel.java
 *
 */

package org.netbeans.modules.javawebstart.ui.customizer;

import javax.swing.text.Document;
import org.netbeans.modules.javawebstart.ui.customizer.JWSProjectProperties.PropertiesTableModel;

/**
 *
 * @author Milan Kubec
 */
public class AppletParametersPanel extends javax.swing.JPanel {
    
    private PropertiesTableModel tableModel;
    private Document appletWidthDoc;
    private Document appletHeightDoc;
    
    /** Creates new form AppletParametersPanel */
    public AppletParametersPanel(PropertiesTableModel mdl, Document widthDoc, Document heightDoc) {
        this.tableModel = mdl;
        this.appletWidthDoc = widthDoc;
        this.appletHeightDoc = heightDoc;
        initComponents();
        if (widthTextField.getText().equals("")) {
            widthTextField.setText(JWSProjectProperties.DEFAULT_APPLET_WIDTH);
        }
        if (heightTextField.getText().equals("")) {
            heightTextField.setText(JWSProjectProperties.DEFAULT_APPLET_HEIGHT);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        appletParamsTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        appletParamsLabel = new javax.swing.JLabel();
        appletDimsLabel = new javax.swing.JLabel();
        widthLabel = new javax.swing.JLabel();
        widthTextField = new javax.swing.JTextField();
        heightLabel = new javax.swing.JLabel();
        heightTextField = new javax.swing.JTextField();

        appletParamsTable.setModel(tableModel);
        jScrollPane1.setViewportView(appletParamsTable);
        appletParamsTable.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.appletParamsTable.AccessibleContext.accessibleName")); // NOI18N
        appletParamsTable.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.appletParamsTable.AccessibleContext.accessibleDescription")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(addButton, org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.addButton.text")); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(removeButton, org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.removeButton.text")); // NOI18N
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        appletParamsLabel.setLabelFor(appletParamsTable);
        org.openide.awt.Mnemonics.setLocalizedText(appletParamsLabel, org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.appletParamsLabel.text")); // NOI18N

        appletDimsLabel.setText(org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.appletDimsLabel.text")); // NOI18N

        widthLabel.setLabelFor(widthTextField);
        org.openide.awt.Mnemonics.setLocalizedText(widthLabel, org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.widthLabel.text")); // NOI18N

        widthTextField.setDocument(appletWidthDoc);

        heightLabel.setLabelFor(heightTextField);
        org.openide.awt.Mnemonics.setLocalizedText(heightLabel, org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.heightLabel.text")); // NOI18N

        heightTextField.setDocument(appletHeightDoc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeButton)
                            .addComponent(addButton)))
                    .addComponent(appletDimsLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(widthLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(widthTextField))
                            .addComponent(appletParamsLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addComponent(heightLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(heightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addButton, removeButton});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {heightTextField, widthTextField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appletDimsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(widthLabel)
                    .addComponent(widthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heightLabel)
                    .addComponent(heightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appletParamsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addContainerGap())
        );

        addButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.addButton.AccessibleContext.accessibleDescription")); // NOI18N
        removeButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.removeButton.AccessibleContext.accessibleDescription")); // NOI18N
        appletParamsLabel.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.appletParamsLabel.AccessibleContext.accessibleDescription")); // NOI18N
        appletDimsLabel.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.appletDimsLabel.AccessibleContext.accessibleDescription")); // NOI18N
        widthLabel.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.widthLabel.AccessibleContext.accessibleDescription")); // NOI18N
        widthTextField.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.widthTextField.AccessibleContext.accessibleName")); // NOI18N
        widthTextField.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.widthTextField.AccessibleContext.accessibleDescription")); // NOI18N
        heightLabel.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.heightLabel.AccessibleContext.accessibleDescription")); // NOI18N
        heightTextField.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.heightTextField.AccessibleContext.accessibleName")); // NOI18N
        heightTextField.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.heightTextField.AccessibleContext.accessibleDescription")); // NOI18N

        getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.AccessibleContext.accessibleName")); // NOI18N
        getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(AppletParametersPanel.class, "AppletParametersPanel.AccessibleContext.accessibleDescription")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    tableModel.addRow();
    tableModel.fireTableDataChanged();
}//GEN-LAST:event_addButtonActionPerformed

private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
    int selIndex = appletParamsTable.getSelectedRow();
    if (selIndex != -1) {
        tableModel.removeRow(selIndex);
        tableModel.fireTableDataChanged();
    }
}//GEN-LAST:event_removeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel appletDimsLabel;
    private javax.swing.JLabel appletParamsLabel;
    private javax.swing.JTable appletParamsTable;
    private javax.swing.JLabel heightLabel;
    private javax.swing.JTextField heightTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeButton;
    private javax.swing.JLabel widthLabel;
    private javax.swing.JTextField widthTextField;
    // End of variables declaration//GEN-END:variables

}
