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

package org.netbeans.modules.j2ee.sun.share.configbean.customizers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import javax.swing.JPanel;
import org.netbeans.modules.j2ee.sun.dd.api.ASDDVersion;
import org.netbeans.modules.j2ee.sun.share.Constants;
import org.netbeans.modules.j2ee.sun.share.PrincipalNameMapping;
import org.netbeans.modules.j2ee.sun.share.configbean.Utils;
import org.netbeans.modules.j2ee.sun.share.configbean.customizers.common.HelpContext;
import org.netbeans.modules.j2ee.sun.share.configbean.customizers.common.InputDialog;

/**
 *
 * @author Peter Williams
 */
public class SecurityEditPrincipalPanel extends JPanel {
    
	private static final ResourceBundle customizerBundle = ResourceBundle.getBundle(
		"org.netbeans.modules.j2ee.sun.share.configbean.customizers.Bundle"); // NOI18N
    
	private final PrincipalTableModel principalModel;

    private final String originalPrincipalName;
	private String principalName;

    private final String originalClassName;
    private String className;

    // true if AS 9.0+ fields are visible.
    private final boolean as90FeaturesVisible;

    /**
     * Creates new form SecurityEditPrincipalPanel
     */
    public SecurityEditPrincipalPanel(PrincipalNameMapping entry, PrincipalTableModel pml, ASDDVersion asVersion) {
        principalModel = pml;
        originalPrincipalName = principalName = entry.getPrincipalName();
        originalClassName = className = entry.getClassName();
        
        as90FeaturesVisible = ASDDVersion.SUN_APPSERVER_9_0.compareTo(asVersion) <= 0;
        
        initComponents();
        initUserComponents();
        initFields();
    }

	protected String getPrincipalName() {
		return principalName;
	}
    
    protected String getOriginalPrincipalName() {
        return originalPrincipalName;
    }

	protected String getClassName() {
		return className;
	}
    
    protected String getOriginalClassName() {
        return originalClassName;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLblPrincipalEntryDesc = new javax.swing.JLabel();
        jLblPrincipalName = new javax.swing.JLabel();
        jTxtPrincipalName = new javax.swing.JTextField();
        jLblClassName = new javax.swing.JLabel();
        jTxtClassName = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        jLblPrincipalEntryDesc.setText(customizerBundle.getString("LBL_PrincipalEntryDesc90")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 0, 5);
        add(jLblPrincipalEntryDesc, gridBagConstraints);

        jLblPrincipalName.setLabelFor(jTxtPrincipalName);
        jLblPrincipalName.setText(customizerBundle.getString("LBL_PrincipalName_1")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 0, 0);
        add(jLblPrincipalName, gridBagConstraints);

        jTxtPrincipalName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtPrincipalNameKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 11);
        add(jTxtPrincipalName, gridBagConstraints);
        jTxtPrincipalName.getAccessibleContext().setAccessibleName(customizerBundle.getString("ACSN_PrincipalName")); // NOI18N
        jTxtPrincipalName.getAccessibleContext().setAccessibleDescription(customizerBundle.getString("ACSD_PrincipalName")); // NOI18N

        jLblClassName.setLabelFor(jTxtClassName);
        jLblClassName.setText(customizerBundle.getString("LBL_ClassName_1")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 0, 0);
        add(jLblClassName, gridBagConstraints);

        jTxtClassName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtClassNameKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 11);
        add(jTxtClassName, gridBagConstraints);
        jTxtClassName.getAccessibleContext().setAccessibleName(customizerBundle.getString("ACSN_ClassName")); // NOI18N
        jTxtClassName.getAccessibleContext().setAccessibleDescription(customizerBundle.getString("ACSD_ClassName")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtClassNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtClassNameKeyReleased
        className = jTxtClassName.getText();
		firePropertyChange(Constants.USER_DATA_CHANGED, null, null);
    }//GEN-LAST:event_jTxtClassNameKeyReleased

    private void jTxtPrincipalNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtPrincipalNameKeyReleased
        principalName = jTxtPrincipalName.getText();
		firePropertyChange(Constants.USER_DATA_CHANGED, null, null);
    }//GEN-LAST:event_jTxtPrincipalNameKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblClassName;
    private javax.swing.JLabel jLblPrincipalEntryDesc;
    private javax.swing.JLabel jLblPrincipalName;
    private javax.swing.JTextField jTxtClassName;
    private javax.swing.JTextField jTxtPrincipalName;
    // End of variables declaration//GEN-END:variables

    private void initUserComponents() {
        /** Adjust panel for 8.1 vs. 9.0 features:
         */
        if(!as90FeaturesVisible) {
            jLblPrincipalEntryDesc.setText(customizerBundle.getString("LBL_PrincipalEntryDesc81")); // NOI18N
            jLblClassName.setVisible(false);
            jTxtClassName.setVisible(false);
        }
        
        getAccessibleContext().setAccessibleName(customizerBundle.getString("ACSN_EditPrincipalName")); // NOI18N
        getAccessibleContext().setAccessibleDescription(customizerBundle.getString("ACSD_EditPrincipalName")); // NOI18N
    }
    
    private void initFields() {
        jTxtPrincipalName.setText(principalName);
        jTxtClassName.setText(className);
    }
    
    Collection getErrors() {
        // Validate what the user typed in as a valid principal name
        ArrayList errors = new ArrayList();
        String newPrincipalName = getPrincipalName();

        /** New name must not be blank (for add or edit version)
         */
        if(!Utils.notEmpty(newPrincipalName)) {
            errors.add(customizerBundle.getString("ERR_BlankPrincipalName"));	// NOI18N
        }

        /** Duplicate checking:				 
         *    Add operations always need to check for duplicates against
         *    the entire list.
         */
        if(newPrincipalName != null && !newPrincipalName.equals(getOriginalPrincipalName()) && 
                principalModel.contains(new PrincipalNameMapping(newPrincipalName))) {
            errors.add(MessageFormat.format(customizerBundle.getString("ERR_PrincipalExists"), new Object [] { newPrincipalName })); // NOI18N
        }

        /** Class name:
         *    If specified, the classname field must contain a semantically valid
         *    java classname.  We do not verify if the class exists or is accessible.
         */
        String newClassName = getClassName();
        if(Utils.notEmpty(newClassName) && !Utils.isJavaClass(newClassName)) {
            errors.add(customizerBundle.getString("ERR_InvalidJavaClassName")); // NOI18N
        }

        return errors;
    }
    
	/** Puts up an 'Edit...' dialog, doing validation against the supplied model,
	 *  and ultimately updating the data model if the user hits <OK> and clears
	 *  any errors.
	 *
	 * @param parent JPanel that is the parent of this popup - used for centering and sizing.
	 * @param entry The existing entry.  This will be prefilled into the edit field.
	 * @param theModel The particular Security model instance we're updating.
	 */
    static void editPrincipalName(JPanel parent, PrincipalNameMapping entry, PrincipalTableModel model, ASDDVersion asVersion) {
        SecurityEditPrincipalPanel editPrincipalPanel = new SecurityEditPrincipalPanel(entry, model, asVersion);
        editPrincipalPanel.displayDialog(parent, customizerBundle.getString("TITLE_EditPrincipal"),	// NOI18N
            HelpContext.HELP_SECURITY_EDIT_PRINCIPAL);
    }
    
    private void displayDialog(JPanel parent, String title, String helpId) {
        BetterInputDialog dialog = new BetterInputDialog(parent, title, helpId, this);

        do {
            int dialogChoice = dialog.display();

            if(dialogChoice == dialog.CANCEL_OPTION) {
                break;
            }

            if(dialogChoice == dialog.OK_OPTION) {
                Collection errors = getErrors();

                String newPrincipalName = getPrincipalName();
                String oldPrincipalName = getOriginalPrincipalName();
                String newClassName = getClassName();
                String oldClassName = getOriginalClassName();

                if(dialog.hasErrors()) {
                    // !PW is this even necessary w/ new validation model?
                    dialog.showErrors();
                } else {
                    // Add to security model of this descriptor
                    if(!Utils.strEquals(newPrincipalName, oldPrincipalName) || !Utils.strEquals(newClassName, oldClassName)) {
                        PrincipalNameMapping oldEntry = new PrincipalNameMapping(oldPrincipalName, oldClassName);
                        PrincipalNameMapping newEntry = new PrincipalNameMapping(newPrincipalName, newClassName);
                        principalModel.replaceElement(oldEntry, newEntry);
                    }                    
                    
                    // Also add to global mapping list if not already present.
//                    PrincipalNameMapping tmpMapping = new PrincipalNameMapping(newPrincipalName, newClassName);
//                    if(!existingPrincipalsModel.contains(tmpMapping)) {
//                        existingPrincipalsModel.addElement(tmpMapping);
//                    }
                }
            }
        } while(dialog.hasErrors());
    }    

    private static class BetterInputDialog extends InputDialog {
        private final SecurityEditPrincipalPanel dialogPanel;
        private final String panelHelpId;

        public BetterInputDialog(JPanel parent, String title, String helpId, SecurityEditPrincipalPanel childPanel) {
            super(parent, title);

            dialogPanel = childPanel;
            panelHelpId = helpId;

            dialogPanel.setPreferredSize(new Dimension(parent.getWidth()*3/4, 
                dialogPanel.getPreferredSize().height));

            this.getAccessibleContext().setAccessibleName(dialogPanel.getAccessibleContext().getAccessibleName());
            this.getAccessibleContext().setAccessibleDescription(dialogPanel.getAccessibleContext().getAccessibleDescription());

            getContentPane().add(childPanel, BorderLayout.CENTER);
            addListeners();
            pack();
            setLocationInside(parent);
            handleErrorDisplay();
        }

        private void addListeners() {
            dialogPanel.addPropertyChangeListener(Constants.USER_DATA_CHANGED, new PropertyChangeListener() {
                public void propertyChange(PropertyChangeEvent evt) {
                    handleErrorDisplay();
                }
            });
        }

        private void handleErrorDisplay() {
            ArrayList errors = new ArrayList();
            errors.addAll(dialogPanel.getErrors());
            setErrors(errors);
        }

        protected String getHelpId() {
            return panelHelpId;
        }
    }
}
