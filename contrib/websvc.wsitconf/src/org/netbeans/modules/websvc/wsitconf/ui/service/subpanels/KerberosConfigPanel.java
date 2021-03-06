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

package org.netbeans.modules.websvc.wsitconf.ui.service.subpanels;

import org.netbeans.modules.websvc.wsitconf.wsdlmodelext.ProprietarySecurityPolicyModelHelper;
import org.netbeans.modules.xml.wsdl.model.WSDLComponent;
import javax.swing.*;
import org.netbeans.api.project.Project;
import org.netbeans.modules.websvc.wsitmodelext.versioning.ConfigVersion;

/**
 *
 * @author Martin Grebac
 */
public class KerberosConfigPanel extends JPanel {

    private WSDLComponent comp;
    private Project project = null;
    private boolean inSync = false;
    private ConfigVersion cfgVersion = null;
    
    public KerberosConfigPanel(WSDLComponent comp, Project p, ConfigVersion cfgVersion) {
        super();
        this.comp = comp;
        this.project = p;
        this.cfgVersion = cfgVersion;
        
        initComponents();

        /* issue 232988: the background color issues with dark metal L&F
        loginModuleCombo.setBackground(SectionVisualTheme.getDocumentBackgroundColor());
        loginModuleLabel.setBackground(SectionVisualTheme.getDocumentBackgroundColor());
        */

        sync();
    }

    private String getLoginModule() {
        return (String) this.loginModuleCombo.getSelectedItem();
    }

    private void setLoginModule(String module) {
        this.loginModuleCombo.setSelectedItem(module);
    }

    String loginModule = null;
   
    public void sync() {
        inSync = true;

        loginModule = ProprietarySecurityPolicyModelHelper.getLoginModule(comp);
        setLoginModule(loginModule);

//        enableDisable();

        inSync = false;
    }

//    private void enableDisable() {
//        boolean gf = Util.isGlassfish(project);
//        keyPasswordField.setEnabled(!gf);
//        keyPasswordLabel.setEnabled(!gf);
//    }
        
    public void storeState() {
        loginModule = getLoginModule();
        if ((loginModule == null) || (loginModule.length() == 0)) {
            ProprietarySecurityPolicyModelHelper.setLoginModule(comp, null, false);
        } else {
            ProprietarySecurityPolicyModelHelper.setLoginModule(comp, loginModule, false);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginModuleLabel = new javax.swing.JLabel();
        loginModuleCombo = new javax.swing.JComboBox();

        org.openide.awt.Mnemonics.setLocalizedText(loginModuleLabel, org.openide.util.NbBundle.getMessage(KerberosConfigPanel.class, "LBL_KerberosCfgPanel_LoginModule")); // NOI18N

        loginModuleCombo.setEditable(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginModuleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginModuleCombo, 0, 122, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginModuleLabel)
                    .addComponent(loginModuleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox loginModuleCombo;
    private javax.swing.JLabel loginModuleLabel;
    // End of variables declaration//GEN-END:variables
    
}
