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

package org.netbeans.modules.project.ant.ui;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.netbeans.modules.project.ant.ui.VariablesModel.Variable;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.explorer.ExplorerManager;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataFolder;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.NbBundle;
import org.openide.util.lookup.Lookups;

/**
 *
 */
public class VariablesPanel extends javax.swing.JPanel implements ExplorerManager.Provider {

    private final ExplorerManager explorer;
    private VariablesModel model;
    
    /** Creates new form VariablesPanel */
    public VariablesPanel() {
        model = new VariablesModel();
        initComponents();
        tree.setRootVisible(false);
        explorer = new ExplorerManager();
    }

    public static Variable showVariablesCustomizer() {
        return new VariablesPanel().showDialog();
    }
    
    private Variable showDialog() {
        JPanel inset = new JPanel(new BorderLayout());
        inset.setBorder(new EmptyBorder(12,12,0,12));
        inset.add(this);
        inset.getAccessibleContext().setAccessibleName(NbBundle.getMessage(VariablesPanel.class, "AN_Manage_Variables"));
        inset.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(VariablesPanel.class, "AD_Manage_Variables"));
        DialogDescriptor dd = new DialogDescriptor(inset, NbBundle.getMessage(VariablesPanel.class, "TITLE_Manage_Variables")); // NOI18N
        dd.setModal(true);
        final JButton ok = new JButton(NbBundle.getMessage(VariablesPanel.class, "BUTTON_OK")); // NOI18N
        ok.setDefaultCapable(true);
        explorer.addPropertyChangeListener(new PropertyChangeListener() {
           public void propertyChange(PropertyChangeEvent evt) {
               removeButton.setEnabled(explorer.getSelectedNodes().length > 0);
               editButton.setEnabled(explorer.getSelectedNodes().length == 1);
           }
        });
        dd.setOptions(new Object[] {ok, NotifyDescriptor.CANCEL_OPTION});
        dd.setClosingOptions(new Object[] {ok, NotifyDescriptor.CANCEL_OPTION});
        if (DialogDisplayer.getDefault().notify(dd) == ok) {
            model.save();
            if (explorer.getSelectedNodes().length == 1) {
                return explorer.getSelectedNodes()[0].getLookup().lookup(Variable.class);
            }
        }
        return null;
    }

    private void setRootNode() {
        explorer.setRootContext(new AbstractNode(new VariableChildren(model.getVariables())));
        tree.requestFocus();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        setRootNode();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tree = new org.openide.explorer.view.BeanTreeView();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        tree.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        org.openide.awt.Mnemonics.setLocalizedText(addButton, org.openide.util.NbBundle.getMessage(VariablesPanel.class, "VariablesPanel.addButton.text")); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(removeButton, org.openide.util.NbBundle.getMessage(VariablesPanel.class, "VariablesPanel.removeButton.text")); // NOI18N
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(editButton, org.openide.util.NbBundle.getMessage(VariablesPanel.class, "VariablesPanel.editButton.text")); // NOI18N
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        jLabel1.setLabelFor(tree);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(VariablesPanel.class, "VariablesPanel.jLabel1.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tree, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addContainerGap())
                    .addComponent(tree, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)))
        );

        tree.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(VariablesPanel.class, "ACSD_VariablesPanel_NA")); // NOI18N
        addButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(VariablesPanel.class, "ACSD_VariablesPanel_NA")); // NOI18N
        removeButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(VariablesPanel.class, "ACSD_VariablesPanel_NA")); // NOI18N
        editButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(VariablesPanel.class, "ACSD_VariablesPanel_NA")); // NOI18N
        jLabel1.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(VariablesPanel.class, "ACSD_VariablesPanel_NA")); // NOI18N

        getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(VariablesPanel.class, "ACSD_VariablesPanel_NA")); // NOI18N
        getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(VariablesPanel.class, "ACSD_VariablesPanel_NA")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    VariablePanel p = new VariablePanel(model, null);
    DialogDescriptor dd = new DialogDescriptor (p, NbBundle.getMessage(VariablesPanel.class, "DIALOG_Add_New_Variable"), // NOI18N
        true, DialogDescriptor.OK_CANCEL_OPTION, null, null);
    p.setDialogDescriptor(dd);
    Dialog dlg = DialogDisplayer.getDefault().createDialog (dd);
    dlg.setVisible(true);
    if (dd.getValue() == DialogDescriptor.OK_OPTION) {
        model.add(p.getVariableName(), p.getVariableLocation());
        setRootNode();
    }
}//GEN-LAST:event_addButtonActionPerformed

private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
    Node nodes[] = explorer.getSelectedNodes();
    for (Node n : nodes) {
        model.remove(n.getLookup().lookup(Variable.class));
    }
    setRootNode();
}//GEN-LAST:event_removeButtonActionPerformed

private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
    Variable var = explorer.getSelectedNodes()[0].getLookup().lookup(Variable.class);
    VariablePanel p = new VariablePanel(model, var);
    DialogDescriptor dd = new DialogDescriptor (p, NbBundle.getMessage(VariablesPanel.class, "DIALOG_Edit_Variable"), // NOI18N
        true, DialogDescriptor.OK_CANCEL_OPTION, null, null);
    p.setDialogDescriptor(dd);
    Dialog dlg = DialogDisplayer.getDefault().createDialog (dd);
    dlg.setVisible(true);
    if (dd.getValue() == DialogDescriptor.OK_OPTION) {
        var.setValue(p.getVariableLocation());
        setRootNode();
    }
}//GEN-LAST:event_editButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton removeButton;
    private org.openide.explorer.view.BeanTreeView tree;
    // End of variables declaration//GEN-END:variables

    public ExplorerManager getExplorerManager() {
        return explorer;
    }

    private class VariableChildren extends Children.Keys<Variable> {

        private Node iconDelegate;
        
        private VariableChildren(List<Variable> vars) {
            setKeys(vars);
            this.iconDelegate = DataFolder.findFolder (FileUtil.getConfigRoot()).getNodeDelegate();
        }

        protected Node[] createNodes(Variable var) {
            Children ch = Children.LEAF;
            AbstractNode n = new AbstractNode(ch, Lookups.singleton(var)) {
                @Override
                public Image getIcon(int type) {
                    return iconDelegate.getIcon(type);
                }
            };
            n.setName(var.getName());
            n.setDisplayName(var.getName() + "("+var.getValue().getPath()+")"); // NOI18N
            n.setShortDescription(var.getName() + "("+var.getValue().getPath()+")"); // NOI18N
            return new Node[] {n};
        }

    }
    
}
