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
package org.netbeans.modules.hibernateweb.framework;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.netbeans.api.db.explorer.ConnectionManager;
import org.netbeans.api.db.explorer.DatabaseConnection;
import org.netbeans.api.db.explorer.support.DatabaseExplorerUIs;
import org.netbeans.modules.hibernate.wizards.Util;
import org.netbeans.modules.web.api.webmodule.ExtenderController;
import org.openide.util.NbBundle;

/**
 * Panel UI for Framework support for Hibernate. 
 * 
 * @author  Vadiraj Deshpande (Vadiraj.Deshpande@Sun.COM)
 */
public class HibernateConfigurationPanel extends javax.swing.JPanel implements DocumentListener, ItemListener {

    private HibernateWebModuleExtender webModuleExtender;
    private ExtenderController controller;
    private boolean forNewProjectWizard = false;

    /** Creates new form HibernateConfigurationPanel */
    public HibernateConfigurationPanel(HibernateWebModuleExtender webModuleExtender,
            ExtenderController controller, boolean forNewProjectWizard) {
        this.webModuleExtender = webModuleExtender;
        this.controller = controller;
        this.forNewProjectWizard = forNewProjectWizard;
        initComponents();
        setDefaults();
        fillPanel();
        cmbDbConnection.addItemListener(this);
    }

    public void setDefaults() {
        cmbDbConnection.setModel(new javax.swing.DefaultComboBoxModel(new String[0]));
        DatabaseExplorerUIs.connect(cmbDbConnection, ConnectionManager.getDefault());
    }

    public void fillPanel() {
        if (forNewProjectWizard) {
            // #155965. Select a db connection only if one exists already.
            if (cmbDbConnection.getItemCount() > 1) {
                cmbDbConnection.setSelectedIndex(0);
            }
        }
    }

    @Override
    public String getName() {
        return NbBundle.getMessage(HibernateConfigurationPanel.class, "LBL_HibernateConfigurationPanel_Name");
    }

    private void fillComponents() {
        DatabaseConnection dbConn = getDatabaseConnection();
        if (dbConn != null && cmbDbConnection.getItemCount() != 0) {
            txtDialect.setText(Util.getDialectName(dbConn.getDriverClass()));
        }
    }

    public boolean isPanelValid() {
        if (forNewProjectWizard) { // Validate only in case of New Project Wizard.
            if(cmbDbConnection.getModel().getSize() <= 1) {
                // #155965. There are no registered db connection exists with the IDE...
                // For Hibernate framework, developer should establish one db connection.
                return false;
            }
        }
        return true;
    }

    @Override
    public void disable() {
        super.disable();
        for (Component component : this.getComponents()) {
            component.setEnabled(false);
        }
    }

    public DatabaseConnection getDatabaseConnection() {
        return (DatabaseConnection) cmbDbConnection.getSelectedItem();

    }

    public void setDatabaseConnection(String dbConnURL) {
        for (int i = 0; i < cmbDbConnection.getItemCount(); i++) {
            if (cmbDbConnection.getItemAt(i) instanceof DatabaseConnection) {
                DatabaseConnection conn = (DatabaseConnection) cmbDbConnection.getItemAt(i);
                if (conn.getDatabaseURL().equals(dbConnURL)) {
                    cmbDbConnection.setSelectedItem(conn);
                    break;
                }
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        cmbDbConnection = new javax.swing.JComboBox();
        txtDialect = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        jLabel3.setText(org.openide.util.NbBundle.getMessage(HibernateConfigurationPanel.class, "HibernateConfigurationPanel.jLabel3.text")); // NOI18N

        cmbDbConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDbConnectionActionPerformed(evt);
            }
        });

        txtDialect.setEditable(false);
        txtDialect.setText(org.openide.util.NbBundle.getMessage(HibernateConfigurationPanel.class, "HibernateConfigurationPanel.txtDialect.text")); // NOI18N

        jLabel4.setText(org.openide.util.NbBundle.getMessage(HibernateConfigurationPanel.class, "HibernateConfigurationPanel.jLabel4.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDialect, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                    .addComponent(cmbDbConnection, 0, 329, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDialect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cmbDbConnection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void cmbDbConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDbConnectionActionPerformed
// TODO add your handling code here:
    fillComponents();
}//GEN-LAST:event_cmbDbConnectionActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbDbConnection;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtDialect;
    // End of variables declaration//GEN-END:variables
    public void insertUpdate(DocumentEvent e) {
        webModuleExtender.fireChangeEvent();
    }

    public void removeUpdate(DocumentEvent e) {
        webModuleExtender.fireChangeEvent();
    }

    public void changedUpdate(DocumentEvent e) {
        webModuleExtender.fireChangeEvent();
    }

    public void itemStateChanged(ItemEvent e) {
        webModuleExtender.fireChangeEvent();
    }

    public String getSelectedDialect() {
        if (txtDialect.getText() != null) {
            return txtDialect.getText().trim();
        }
        return null;
    }

    public void setDialect(String dialectName) {
        txtDialect.setText(dialectName);
    }

    public String getSelectedDriver() {
        if (getDatabaseConnection() != null && getDatabaseConnection().getDriverClass() != null) {
            return getDatabaseConnection().getDriverClass().trim();
        }
        return null;
    }

    public String getSelectedURL() {
        if (getDatabaseConnection() != null && getDatabaseConnection().getDatabaseURL() != null) {
            return getDatabaseConnection().getDatabaseURL().trim();
        }
        return null;
    }

    public String getUserName() {
        if (getDatabaseConnection() != null && getDatabaseConnection().getUser() != null) {
            return getDatabaseConnection().getUser().trim();
        }
        return null;
    }

    public String getPassword() {
        if (getDatabaseConnection() != null && getDatabaseConnection().getPassword() != null) {
            return getDatabaseConnection().getPassword().trim();
        }
        return null;
    }
}
