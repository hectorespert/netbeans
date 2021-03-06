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

package org.netbeans.modules.debugger.jpda.truffle.options;

import org.netbeans.modules.debugger.jpda.ui.options.StorablePanel;
import org.netbeans.spi.options.OptionsPanelController;

@OptionsPanelController.Keywords(keywords={"#LBL_TruffleDebugging",
                                           "#CategoryPanelTruffle.kw1",
                                           "#CategoryPanelTruffle.kw2"},
                                 location="Java", tabTitle="#LBL_JavaDebuggerTruffle")
public class CategoryPanelTruffle extends StorablePanel {

    /** Creates new form CategoryPanelTruffle */
    public CategoryPanelTruffle() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        langDevModeCheckBox = new javax.swing.JCheckBox();
        langDevModeDescriptionLabel = new javax.swing.JLabel();

        langDevModeCheckBox.setText(org.openide.util.NbBundle.getMessage(CategoryPanelTruffle.class, "CategoryPanelTruffle.langDevModeCheckBox.text")); // NOI18N

        langDevModeDescriptionLabel.setText(org.openide.util.NbBundle.getMessage(CategoryPanelTruffle.class, "CategoryPanelTruffle.langDevModeDescription.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(langDevModeCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(langDevModeDescriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(langDevModeCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(langDevModeDescriptionLabel)
                .addContainerGap(260, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox langDevModeCheckBox;
    private javax.swing.JLabel langDevModeDescriptionLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void load() {
        langDevModeCheckBox.setSelected(TruffleOptions.isLanguageDeveloperMode());
    }

    @Override
    public void store() {
        TruffleOptions.setLanguageDeveloperMode(langDevModeCheckBox.isSelected());
    }

    @Override
    public boolean isChanged() {
        return langDevModeCheckBox.isSelected() != TruffleOptions.isLanguageDeveloperMode();
    }
}
