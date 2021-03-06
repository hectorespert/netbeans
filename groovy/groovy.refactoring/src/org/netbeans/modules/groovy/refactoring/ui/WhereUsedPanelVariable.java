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
package org.netbeans.modules.groovy.refactoring.ui;

import java.awt.Dimension;
import javax.swing.SwingUtilities;
import org.netbeans.modules.csl.api.UiUtils;
import org.netbeans.modules.groovy.refactoring.findusages.model.RefactoringElement;

/**
 * Copied from Java Refactoring module and changed with respect to Groovy and
 * CSL specifics.
 *
 * @author Martin Janicek <mjanicek@netbeans.org>
 */
public class WhereUsedPanelVariable extends WhereUsedPanel.WhereUsedInnerPanel {

    public WhereUsedPanelVariable() {
        initComponents();
    }

    @Override
    void initialize(final RefactoringElement element) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Dimension preferredSize = label.getPreferredSize();
                label.setText(element.getShowcase());
                label.setIcon(UiUtils.getElementIcon(element.getKind(), element.getModifiers()));
                label.setPreferredSize(preferredSize);
                label.setMinimumSize(preferredSize);
            }
        });
    }

    @Override
    public boolean isSearchInComments() {
        return searchInComments.isSelected();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchInComments = new javax.swing.JCheckBox();
        label = new javax.swing.JLabel();
        lbl_usagesof = new javax.swing.JLabel();

        searchInComments.setSelected(((Boolean) RefactoringModule.getOption("searchInComments.whereUsed", Boolean.FALSE)).booleanValue());
        org.openide.awt.Mnemonics.setLocalizedText(searchInComments, org.openide.util.NbBundle.getBundle(WhereUsedPanelVariable.class).getString("LBL_SearchInComents")); // NOI18N

        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/netbeans/modules/groovy/refactoring/resources/warning_16.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(label, "<<Element>>"); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lbl_usagesof, org.openide.util.NbBundle.getMessage(WhereUsedPanelVariable.class, "LBL_UsagesOfElement")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbl_usagesof)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchInComments)
                    .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_usagesof)
                    .addComponent(label))
                .addGap(6, 6, 6)
                .addComponent(searchInComments))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label;
    private javax.swing.JLabel lbl_usagesof;
    private javax.swing.JCheckBox searchInComments;
    // End of variables declaration//GEN-END:variables
}
