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

package org.netbeans.modules.php.project.ui.wizards;

import java.awt.BorderLayout;
import java.nio.charset.Charset;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.MutableComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import org.netbeans.modules.php.api.PhpVersion;
import org.netbeans.modules.php.project.ui.LastUsedFolders;
import org.netbeans.modules.php.project.ui.LocalServer;
import org.netbeans.modules.php.project.ui.LocalServerController;
import org.netbeans.modules.php.project.ui.Utils.PhpVersionComboBoxModel;
import org.netbeans.modules.php.project.ui.options.PhpOptions;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.awt.Mnemonics;
import org.openide.util.NbBundle;

class ConfigureNewProjectPanelVisual extends ConfigurableProjectPanel {

    private static final long serialVersionUID = 5558754132375479L;

    private final LocalServerController localServerComponent;

    ConfigureNewProjectPanelVisual(ConfigureProjectPanel wizardPanel) {
        super(wizardPanel);
        initComponents();
        localServerComponent = LocalServerController.create(localServerComboBox, localServerButton, new BrowseSources(),
                NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "LBL_SelectSourceFolderTitle"));
        projectFolderPanel.add(BorderLayout.CENTER, projectFolderComponent);
        init(wizardPanel.getWizardType());
    }

    // XXX remove
    @SuppressWarnings("unchecked")
    private void init(NewPhpProjectWizardIterator.WizardType wizardType) {
        projectNameTextField.getDocument().addDocumentListener(this);
        localServerComponent.addChangeListener(this);

        phpVersionComboBox.setModel(new PhpVersionComboBoxModel(
                wizardType.equals(NewPhpProjectWizardIterator.WizardType.NEW) ? PhpOptions.getInstance().getDefaultPhpVersion() : PhpVersion.getLegacy()));

        encodingComboBox.setModel(ProjectCustomizer.encodingModel(Charset.defaultCharset().name()));
        encodingComboBox.setRenderer(ProjectCustomizer.encodingRenderer());
    }

    @Override
    public void addNotify() {
        super.addNotify();
        // same problem as in 31086, initial focus on Cancel button
        projectNameTextField.requestFocus();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        projectNameLabel = new JLabel();
        projectNameTextField = new JTextField();
        sourcesLabel = new JLabel();
        localServerComboBox = new JComboBox<LocalServer>();
        localServerButton = new JButton();
        localServerInfoLabel = new JLabel();
        phpVersionLabel = new JLabel();
        phpVersionComboBox = new JComboBox<PhpVersion>();
        phpVersionInfoLabel = new JLabel();
        encodingLabel = new JLabel();
        encodingComboBox = new JComboBox<Charset>();
        separator = new JSeparator();
        projectFolderPanel = new JPanel();

        projectNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        projectNameLabel.setLabelFor(projectNameTextField);
        Mnemonics.setLocalizedText(projectNameLabel, NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "LBL_ProjectName")); // NOI18N
        projectNameLabel.setVerticalAlignment(SwingConstants.TOP);

        projectNameTextField.setColumns(20);

        sourcesLabel.setLabelFor(localServerComboBox);
        Mnemonics.setLocalizedText(sourcesLabel, NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "LBL_Sources")); // NOI18N
        sourcesLabel.setVerticalAlignment(SwingConstants.TOP);

        localServerComboBox.setEditable(true);

        Mnemonics.setLocalizedText(localServerButton, NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "LBL_LocalServerBrowse")); // NOI18N

        Mnemonics.setLocalizedText(localServerInfoLabel, "dummy"); // NOI18N

        Mnemonics.setLocalizedText(phpVersionLabel, NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.phpVersionLabel.text")); // NOI18N

        Mnemonics.setLocalizedText(phpVersionInfoLabel, NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.phpVersionInfoLabel.text")); // NOI18N

        encodingLabel.setLabelFor(encodingComboBox);
        Mnemonics.setLocalizedText(encodingLabel, NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "LBL_Encoding")); // NOI18N

        projectFolderPanel.setLayout(new BorderLayout());

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addComponent(separator)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(projectNameLabel)
                    .addComponent(sourcesLabel)
                    .addComponent(encodingLabel)
                    .addComponent(phpVersionLabel))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(phpVersionInfoLabel)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(phpVersionComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(projectNameTextField, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(localServerComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(localServerButton))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(localServerInfoLabel)
                            .addContainerGap())
                        .addComponent(encodingComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(projectFolderPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(projectNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectNameLabel))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(localServerComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(localServerButton)
                    .addComponent(sourcesLabel))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(localServerInfoLabel)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(phpVersionComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(phpVersionLabel))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(phpVersionInfoLabel)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(encodingComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(encodingLabel))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addComponent(projectFolderPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        projectNameLabel.getAccessibleContext().setAccessibleName(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.projectNameLabel.AccessibleContext.accessibleName")); // NOI18N
        projectNameLabel.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.projectNameLabel.AccessibleContext.accessibleDescription")); // NOI18N
        projectNameTextField.getAccessibleContext().setAccessibleName(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.projectNameTextField.AccessibleContext.accessibleName")); // NOI18N
        projectNameTextField.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.projectNameTextField.AccessibleContext.accessibleDescription")); // NOI18N
        sourcesLabel.getAccessibleContext().setAccessibleName(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.sourcesLabel.AccessibleContext.accessibleName")); // NOI18N
        sourcesLabel.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.sourcesLabel.AccessibleContext.accessibleDescription")); // NOI18N
        localServerComboBox.getAccessibleContext().setAccessibleName(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.localServerComboBox.AccessibleContext.accessibleName")); // NOI18N
        localServerComboBox.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.localServerComboBox.AccessibleContext.accessibleDescription")); // NOI18N
        localServerButton.getAccessibleContext().setAccessibleName(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.localServerButton.AccessibleContext.accessibleName")); // NOI18N
        localServerButton.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.localServerButton.AccessibleContext.accessibleDescription")); // NOI18N
        localServerInfoLabel.getAccessibleContext().setAccessibleName(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.localServerInfoLabel.AccessibleContext.accessibleName")); // NOI18N
        localServerInfoLabel.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.localServerInfoLabel.AccessibleContext.accessibleDescription")); // NOI18N
        phpVersionLabel.getAccessibleContext().setAccessibleName(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.phpVersionLabel.AccessibleContext.accessibleName")); // NOI18N
        phpVersionLabel.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.phpVersionLabel.AccessibleContext.accessibleDescription")); // NOI18N
        phpVersionComboBox.getAccessibleContext().setAccessibleName(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.phpVersionComboBox.AccessibleContext.accessibleName")); // NOI18N
        phpVersionComboBox.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.phpVersionComboBox.AccessibleContext.accessibleDescription")); // NOI18N
        phpVersionInfoLabel.getAccessibleContext().setAccessibleName(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.phpVersionInfoLabel.AccessibleContext.accessibleName")); // NOI18N
        phpVersionInfoLabel.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.phpVersionInfoLabel.AccessibleContext.accessibleDescription")); // NOI18N
        encodingLabel.getAccessibleContext().setAccessibleName(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.encodingLabel.AccessibleContext.accessibleName")); // NOI18N
        encodingLabel.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.encodingLabel.AccessibleContext.accessibleDescription")); // NOI18N
        encodingComboBox.getAccessibleContext().setAccessibleName(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.encodingComboBox.AccessibleContext.accessibleName")); // NOI18N
        encodingComboBox.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.encodingComboBox.AccessibleContext.accessibleDescription")); // NOI18N
        separator.getAccessibleContext().setAccessibleName(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.separator.AccessibleContext.accessibleName")); // NOI18N
        separator.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.separator.AccessibleContext.accessibleDescription")); // NOI18N
        projectFolderPanel.getAccessibleContext().setAccessibleName(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.projectFolderPanel.AccessibleContext.accessibleName")); // NOI18N
        projectFolderPanel.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.projectFolderPanel.AccessibleContext.accessibleDescription")); // NOI18N

        getAccessibleContext().setAccessibleName(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.AccessibleContext.accessibleName")); // NOI18N
        getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(ConfigureNewProjectPanelVisual.class, "ConfigureNewProjectPanelVisual.AccessibleContext.accessibleDescription")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox<Charset> encodingComboBox;
    private JLabel encodingLabel;
    private JButton localServerButton;
    private JComboBox<LocalServer> localServerComboBox;
    private JLabel localServerInfoLabel;
    private JComboBox<PhpVersion> phpVersionComboBox;
    private JLabel phpVersionInfoLabel;
    private JLabel phpVersionLabel;
    private JPanel projectFolderPanel;
    private JLabel projectNameLabel;
    protected JTextField projectNameTextField;
    private JSeparator separator;
    private JLabel sourcesLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getProjectName() {
        return projectNameTextField.getText().trim();
    }

    @Override
    public void setProjectName(String projectName) {
        projectNameTextField.setText(projectName);
        projectNameTextField.selectAll();
    }

    @Override
    public String getSourcesFolder() {
        return localServerComponent.getLocalServer().getSrcRoot();
    }

    @Override
    public LocalServer getSourcesLocation() {
        return localServerComponent.getLocalServer();
    }

    @Override
    public MutableComboBoxModel<LocalServer> getLocalServerModel() {
        return localServerComponent.getLocalServerModel();
    }

    @Override
    public void setLocalServerModel(MutableComboBoxModel<LocalServer> localServers) {
        localServerComponent.setLocalServerModel(localServers);
    }

    @Override
    public void selectSourcesLocation(LocalServer localServer) {
        localServerComponent.selectLocalServer(localServer);
    }

    @Override
    public PhpVersion getPhpVersion() {
        return (PhpVersion) phpVersionComboBox.getSelectedItem();
    }

    @Override
    public void setPhpVersion(PhpVersion phpVersion) {
        phpVersionComboBox.setSelectedItem(phpVersion);
    }

    @Override
    public Charset getEncoding() {
        return (Charset) encodingComboBox.getSelectedItem();
    }

    @Override
    public void setEncoding(Charset encoding) {
        encodingComboBox.setSelectedItem(encoding);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        String hint = localServerComponent.getLocalServer().getHint();
        localServerInfoLabel.setText(hint);
        super.stateChanged(e);
    }

    @Override
    public void setState(boolean enabled) {
        projectNameTextField.setEnabled(enabled);
        localServerComponent.setEnabled(enabled);
    }

    @Override
    public boolean getState() {
        return projectNameTextField.isEnabled();
    }

    private static class BrowseSources implements LocalServerController.BrowseHandler {
        @Override
        public String getDirKey() {
            return LastUsedFolders.DOCUMENT_ROOT;
        }
    }

}
