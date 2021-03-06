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
package org.netbeans.modules.javafx2.project;

import javax.swing.JPanel;
import org.openide.WizardDescriptor;
import org.openide.WizardValidationException;
import org.openide.util.NbBundle;

/** First panel in the NewProject wizard. Used for filling in
 * name, and directory of the project.
 *
 * @author Petr Hrebejk
 */
public class PanelConfigureProjectVisual extends JPanel {

//    private PanelConfigureProject panel;
//    private boolean ignoreProjectDirChanges;
//    private boolean ignoreAntProjectNameChanges;
//    private boolean noDir = true;
    private SettingsPanel projectLocationPanel;
    private PanelOptionsVisual optionsPanel;
    private JavaFXProjectWizardIterator.WizardType type;

    PanelConfigureProjectVisual(PanelConfigureProject panel, JavaFXProjectWizardIterator.WizardType type) {
//        this.panel = panel;
        this.type = type;
        initComponents();
        setName(NbBundle.getMessage(PanelConfigureProjectVisual.class, "TXT_NameAndLoc")); // NOI18N
        switch (type) {
            case APPLICATION:
            case FXML:
                projectLocationPanel = new PanelProjectLocationVisual(panel, type);
                putClientProperty("NewProjectWizard_Title", NbBundle.getMessage(PanelConfigureProjectVisual.class, "TXT_NewJavaFXApp")); // NOI18N
                jSeparator1.setVisible(true);
                getAccessibleContext().setAccessibleName(NbBundle.getMessage(PanelConfigureProjectVisual.class, "TXT_NewJavaFXApp")); // NOI18N
                getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(PanelConfigureProjectVisual.class, "ACSD_NewJavaFXApp")); // NOI18N
                break;
            case PRELOADER:
                projectLocationPanel = new PanelProjectLocationVisual(panel, type);
                putClientProperty("NewProjectWizard_Title", NbBundle.getMessage(PanelConfigureProjectVisual.class, "TXT_NewJavaFXPreloaderApp")); // NOI18N
                jSeparator1.setVisible(true);
                getAccessibleContext().setAccessibleName(NbBundle.getMessage(PanelConfigureProjectVisual.class, "TXT_NewJavaFXPreloaderApp")); // NOI18N
                getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(PanelConfigureProjectVisual.class, "ACSD_NewJavaFXPreloaderApp")); // NOI18N
                break;
            case SWING:
                projectLocationPanel = new PanelProjectLocationVisual(panel, type);
                putClientProperty("NewProjectWizard_Title", NbBundle.getMessage(PanelConfigureProjectVisual.class, "TXT_NewJavaFXSwingApp")); // NOI18N
                jSeparator1.setVisible(true);
                getAccessibleContext().setAccessibleName(NbBundle.getMessage(PanelConfigureProjectVisual.class, "TXT_NewJavaFXSwingApp")); // NOI18N
                getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(PanelConfigureProjectVisual.class, "ACSD_NewJavaFXSwingApp")); // NOI18N
                break;
            case LIBRARY:
                projectLocationPanel = new PanelProjectLocationVisual(panel, type);
                jSeparator1.setVisible(true);
                putClientProperty("NewProjectWizard_Title", NbBundle.getMessage(PanelConfigureProjectVisual.class, "TXT_NewJavaLib")); // NOI18N
                getAccessibleContext().setAccessibleName(NbBundle.getMessage(PanelConfigureProjectVisual.class, "TXT_NewJavaLib")); // NOI18N
                getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(PanelConfigureProjectVisual.class, "ACSD_NewJavaLib")); // NOI18N
                break;
            case EXTISTING:
                projectLocationPanel = new PanelProjectLocationExtSrc(panel);
                jSeparator1.setVisible(true);
                putClientProperty("NewProjectWizard_Title", NbBundle.getMessage(PanelConfigureProjectVisual.class, "TXT_JavaExtSourcesProjectLocation")); // NOI18N
                getAccessibleContext().setAccessibleName(NbBundle.getMessage(PanelConfigureProjectVisual.class, "TXT_JavaExtSourcesProjectLocation")); // NOI18N
                getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(PanelConfigureProjectVisual.class, "ACSD_JavaExtSourcesProjectLocation")); // NOI18N
        }
        locationContainer.add(projectLocationPanel, java.awt.BorderLayout.CENTER);
        optionsPanel = new PanelOptionsVisual(panel, type);
        projectLocationPanel.addPropertyChangeListener(optionsPanel);
        optionsContainer.add(optionsPanel, java.awt.BorderLayout.CENTER);
    }

    boolean valid(WizardDescriptor wizardDescriptor) {
        wizardDescriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, ""); // NOI18N
        return projectLocationPanel.valid(wizardDescriptor) && optionsPanel.valid(wizardDescriptor);
    }

    void read(WizardDescriptor d) {
        Object lastType = d.getProperty("wizard-type"); // NOI18N
        if (lastType == null || lastType != type) {
            //bugfix #46387 The type of project changed, reset values to defaults
            d.putProperty("name", null); // NOI18N
            d.putProperty("projdir", null); // NOI18N
        }
        projectLocationPanel.read(d);
        optionsPanel.read(d);
    }

    void store(WizardDescriptor d) {
        d.putProperty("wizard-type", type); // NOI18N
        projectLocationPanel.store(d);
        optionsPanel.store(d);
    }

    void validate(WizardDescriptor d) throws WizardValidationException {
        projectLocationPanel.validate(d);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        locationContainer = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        optionsContainer = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        locationContainer.setLayout(new java.awt.BorderLayout());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        add(locationContainer, gridBagConstraints);
        locationContainer.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getBundle(PanelConfigureProjectVisual.class).getString("ACSN_locationContainer"));
        locationContainer.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getBundle(PanelConfigureProjectVisual.class).getString("ACSD_locationContainer"));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 0);
        add(jSeparator1, gridBagConstraints);

        optionsContainer.setLayout(new java.awt.BorderLayout());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(optionsContainer, gridBagConstraints);
        optionsContainer.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getBundle(PanelConfigureProjectVisual.class).getString("ACSN_optionsContainer"));
        optionsContainer.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getBundle(PanelConfigureProjectVisual.class).getString("ACSD_optionsContainer"));

    }//GEN-END:initComponents
    /** Currently only handles the "Browse..." button
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel locationContainer;
    private javax.swing.JPanel optionsContainer;
    // End of variables declaration//GEN-END:variables
}
