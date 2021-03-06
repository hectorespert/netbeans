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

package org.netbeans.modules.gradle.customizer;

import org.netbeans.modules.gradle.TemplateAttrProvider;
import org.netbeans.modules.gradle.api.GradleBaseProject;
import org.netbeans.modules.gradle.api.NbGradleProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.AuxiliaryProperties;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;

/**
 *
 * @author Laszlo Kishalmi
 */
public class LicenseHeadersPanel extends javax.swing.JPanel {

    private static final String PROP_LICENSE = "license";
    private boolean hasLicenseProperty = false;
    private FileObject projectLicense;
    private Project project;
    private final ActionListener storeListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            store();
        }
    };

    /**
     * Creates new form LicenseHeadersPanel
     */
    public LicenseHeadersPanel() {
        initComponents();
        loadGlobalLicenses();
    }

    public LicenseHeadersPanel(Project project) {
        this();

        this.project = project;
        initProject();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgLicense = new javax.swing.ButtonGroup();
        rbGlobalLicense = new javax.swing.JRadioButton();
        cbGlobalLicense = new javax.swing.JComboBox<>();
        rbCustomFile = new javax.swing.JRadioButton();
        tfCustomFile = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taLicense = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        bgLicense.add(rbGlobalLicense);
        org.openide.awt.Mnemonics.setLocalizedText(rbGlobalLicense, org.openide.util.NbBundle.getMessage(LicenseHeadersPanel.class, "LicenseHeadersPanel.rbGlobalLicense.text")); // NOI18N
        rbGlobalLicense.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbGlobalLicenseStateChanged(evt);
            }
        });

        cbGlobalLicense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGlobalLicenseActionPerformed(evt);
            }
        });

        bgLicense.add(rbCustomFile);
        rbCustomFile.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(rbCustomFile, org.openide.util.NbBundle.getMessage(LicenseHeadersPanel.class, "LicenseHeadersPanel.rbCustomFile.text")); // NOI18N
        rbCustomFile.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbCustomFileStateChanged(evt);
            }
        });

        tfCustomFile.setEditable(false);
        tfCustomFile.setEnabled(false);

        jLabel1.setLabelFor(taLicense);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(LicenseHeadersPanel.class, "LicenseHeadersPanel.jLabel1.text")); // NOI18N

        taLicense.setEditable(false);
        taLicense.setColumns(20);
        taLicense.setRows(5);
        taLicense.setTabSize(4);
        jScrollPane1.setViewportView(taLicense);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(LicenseHeadersPanel.class, "LicenseHeadersPanel.jLabel2.text")); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setVerifyInputWhenFocusTarget(false);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(rbCustomFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCustomFile))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbGlobalLicense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbGlobalLicense, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {rbCustomFile, rbGlobalLicense});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbGlobalLicense)
                    .addComponent(cbGlobalLicense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbCustomFile)
                    .addComponent(tfCustomFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbGlobalLicenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGlobalLicenseActionPerformed
        GlobalItem sel = (GlobalItem) cbGlobalLicense.getSelectedItem();
        try {
            taLicense.setText(sel.fileObject.asText());
            taLicense.setCaretPosition(0);
        } catch (IOException ex) {
            taLicense.setText(null);
        }
    }//GEN-LAST:event_cbGlobalLicenseActionPerformed

    private void rbCustomFileStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbCustomFileStateChanged
        if (rbCustomFile.isSelected()) {
            String text;
            try {
                text = projectLicense != null ? projectLicense.asText() : null;
                taLicense.setText(hasLicenseProperty ? null : text);
                taLicense.setCaretPosition(0);
            } catch (IOException ex) {
            }
        }
    }//GEN-LAST:event_rbCustomFileStateChanged

    private void rbGlobalLicenseStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbGlobalLicenseStateChanged
        boolean globalLicense = rbGlobalLicense.isSelected();
        cbGlobalLicense.setEnabled(globalLicense);
        if (globalLicense) {
            cbGlobalLicenseActionPerformed(null);
        }
    }//GEN-LAST:event_rbGlobalLicenseStateChanged

    private void loadGlobalLicenses() {
        Set<GlobalItem> licenses = new TreeSet<>();
        FileObject root = FileUtil.getConfigFile("Templates/Licenses");
        for (FileObject fo : root.getChildren()) {
            if (fo.getAttribute("template") == null) {
                continue;
            }
            String displayName = (String) fo.getAttribute("displayName");
            if (displayName == null) {
                displayName = fo.getName();
                if (displayName.startsWith("license-")) {
                    displayName = displayName.substring("license-".length());
                }
            }
            licenses.add(new GlobalItem(displayName, fo));
        }
        
        DefaultComboBoxModel<GlobalItem> model = new DefaultComboBoxModel<>();
        for (GlobalItem license : licenses) {
            model.addElement(license);
        }
        cbGlobalLicense.setModel(model);
        setGlobalLicense(null);
    }

    private void initProject() {
        AuxiliaryProperties aux = project.getLookup().lookup(AuxiliaryProperties.class);

        GradleBaseProject gbp = GradleBaseProject.get(project);
        projectLicense = resolveLicense(gbp.getLicense());
        String license = aux.get(PROP_LICENSE, true);
        
        if (license != null) {
            String licensePath = TemplateAttrProvider.findLicensePathInTemplates(license);
            if (licensePath != null) {
                rbGlobalLicense.setSelected(true);
                hasLicenseProperty = true;
                setGlobalLicense(license);
            } else {
                rbCustomFile.setSelected(true);
            }
        }
        
        if (projectLicense != null) {
            String name = (String) projectLicense.getAttribute("displayName");
            name = name != null ? name : FileUtil.getFileDisplayName(projectLicense);
            tfCustomFile.setText(name);
            try {
                taLicense.setText(projectLicense.asText());
                taLicense.setCaretPosition(0);
            } catch (IOException ex) {}
        }
    }

    private void setGlobalLicense(String lic) {
        lic = lic != null ? lic : "default"; //NOI18N
        ComboBoxModel<GlobalItem> model = cbGlobalLicense.getModel();
        for (int i = 0; i < model.getSize(); i++) {
            GlobalItem item = model.getElementAt(i);
            if (lic.equals(item.getName())) {
                model.setSelectedItem(item);
                break;
            }
        }
    }

    private FileObject resolveLicense(String license) {
        String lic = TemplateAttrProvider.findLicenseByMavenProjectContent(license);
        lic = TemplateAttrProvider.findLicensePathInTemplates(lic == null ? license : lic);
        if (lic != null) {
            return FileUtil.getConfigFile(lic);
        }
        File f = FileUtil.normalizeFile(new File(license));
        return f.isAbsolute() ? FileUtil.toFileObject(f) : project.getProjectDirectory().getFileObject(license);
    }
    
    private void store() {
        if (project == null) {
            return;
        }
        AuxiliaryProperties aux = project.getLookup().lookup(AuxiliaryProperties.class);
        if (rbGlobalLicense.isSelected()) {
            aux.put(PROP_LICENSE, ((GlobalItem)cbGlobalLicense.getSelectedItem()).getName(), true);
        } else if (hasLicenseProperty) {
            aux.put(PROP_LICENSE, null, true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgLicense;
    private javax.swing.JComboBox<GlobalItem> cbGlobalLicense;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbCustomFile;
    private javax.swing.JRadioButton rbGlobalLicense;
    private javax.swing.JTextArea taLicense;
    private javax.swing.JTextField tfCustomFile;
    // End of variables declaration//GEN-END:variables

    private static class GlobalItem implements Comparable<GlobalItem> {

        final String displayName;
        final FileObject fileObject;

        public GlobalItem(String name, FileObject fileObject) {
            this.displayName = name;
            this.fileObject = fileObject;
        }

        public String getName() {
            if (fileObject == null) {
                return displayName;
            }
            String name = fileObject.getName();
            if (name.startsWith("license-")) {
                name = name.substring("license-".length());
            }
            return name;
        }

        @Override
        public String toString() {
            return displayName;
        }

        @Override
        public int compareTo(GlobalItem o) {
            return displayName.compareToIgnoreCase(o.displayName);
        }
    }

    @NbBundle.Messages("category.LicenseHeaders=License Headers")
    @ProjectCustomizer.CompositeCategoryProvider.Registration(
            projectType = NbGradleProject.GRADLE_PROJECT_TYPE,
            category = "license",
            categoryLabel = "#category.LicenseHeaders",
            position = 620)
    public static ProjectCustomizer.CompositeCategoryProvider licenseHeaderCustomizerProvider() {
        return new ProjectCustomizer.CompositeCategoryProvider() {
            @Override
            public ProjectCustomizer.Category createCategory(Lookup context) {
                return null;
            }

            @Override
            public JComponent createComponent(ProjectCustomizer.Category category, Lookup context) {
                Project project = context.lookup(Project.class);
                LicenseHeadersPanel panel = new LicenseHeadersPanel(project);
                category.setStoreListener(panel.storeListener);
                return panel;
            }
        };

    }
}
