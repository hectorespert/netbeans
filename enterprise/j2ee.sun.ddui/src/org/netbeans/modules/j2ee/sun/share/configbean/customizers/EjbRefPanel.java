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

import org.netbeans.modules.j2ee.sun.dd.api.ASDDVersion;
import org.netbeans.modules.j2ee.sun.dd.api.CommonDDBean;
import org.netbeans.modules.j2ee.sun.dd.api.common.EjbRef;
import org.netbeans.modules.j2ee.sun.ddloaders.SunDescriptorDataObject;
import org.netbeans.modules.j2ee.sun.ddloaders.multiview.BaseSectionNodeInnerPanel;
import org.netbeans.modules.j2ee.sun.ddloaders.multiview.DDTextFieldEditorModel;
import org.netbeans.modules.j2ee.sun.ddloaders.multiview.common.EjbRefNode;
import org.netbeans.modules.xml.multiview.ItemEditorHelper;
import org.netbeans.modules.xml.multiview.XmlMultiViewDataSynchronizer;
import org.netbeans.modules.xml.multiview.ui.SectionNodeView;


/**
 *
 * @author Peter Williams
 */
public class EjbRefPanel extends BaseSectionNodeInnerPanel {
	
    // data model & version
    private EjbRefNode ejbRefNode;
    
    public EjbRefPanel(SectionNodeView sectionNodeView, final EjbRefNode ejbRefNode, 
            final ASDDVersion version) {
        super(sectionNodeView, version);
        this.ejbRefNode = ejbRefNode;

        initComponents();
        initUserComponents(sectionNodeView);
    }

    private void initUserComponents(SectionNodeView sectionNodeView) {
        SunDescriptorDataObject dataObject = (SunDescriptorDataObject) sectionNodeView.getDataObject();
        XmlMultiViewDataSynchronizer synchronizer = dataObject.getModelSynchronizer();
        addRefreshable(new ItemEditorHelper(jTxtName, new EjbRefTextFieldEditorModel(synchronizer, EjbRef.EJB_REF_NAME)));
        addRefreshable(new ItemEditorHelper(jTxtJndiName, new EjbRefTextFieldEditorModel(synchronizer, EjbRef.JNDI_NAME)));
        
        jTxtName.setEditable(!ejbRefNode.getBinding().isBound());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLblName = new javax.swing.JLabel();
        jTxtName = new javax.swing.JTextField();
        jLblJndiName = new javax.swing.JLabel();
        jTxtJndiName = new javax.swing.JTextField();

        setAlignmentX(LEFT_ALIGNMENT);
        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLblName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLblName.setLabelFor(jTxtName);
        jLblName.setText(customizerBundle.getString("LBL_EJBReferenceName_1")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jLblName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        jPanel1.add(jTxtName, gridBagConstraints);
        jTxtName.getAccessibleContext().setAccessibleName(customizerBundle.getString("ACSN_EJBReferenceName")); // NOI18N
        jTxtName.getAccessibleContext().setAccessibleDescription(customizerBundle.getString("ACSD_EJBReferenceName")); // NOI18N

        jLblJndiName.setLabelFor(jTxtJndiName);
        jLblJndiName.setText(customizerBundle.getString("LBL_JNDIName_1")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        jPanel1.add(jLblJndiName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        jPanel1.add(jTxtJndiName, gridBagConstraints);
        jTxtJndiName.getAccessibleContext().setAccessibleName(customizerBundle.getString("ACSN_JNDIName")); // NOI18N
        jTxtJndiName.getAccessibleContext().setAccessibleDescription(customizerBundle.getString("ACSD_JNDIName")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 5, 5);
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblJndiName;
    private javax.swing.JLabel jLblName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTxtJndiName;
    private javax.swing.JTextField jTxtName;
    // End of variables declaration//GEN-END:variables

    public String getHelpId() {
        return "AS_CFG_EjbRef";	// NOI18N
    }
    
    // Model class for handling updates to the text fields
    private class EjbRefTextFieldEditorModel extends DDTextFieldEditorModel {

        public EjbRefTextFieldEditorModel(XmlMultiViewDataSynchronizer synchronizer, String propertyName) {
            super(synchronizer, propertyName);
        }
        
        protected CommonDDBean getBean() {
            return ejbRefNode.getBinding().getSunBean();
        }
        
        @Override
        protected void setValue(String value) {
            super.setValue(value);

            // If this was a virtual bean, commit it to the graph.
            if(ejbRefNode.addVirtualBean()) {
                // update if necessary
            }
        }
    }
}
