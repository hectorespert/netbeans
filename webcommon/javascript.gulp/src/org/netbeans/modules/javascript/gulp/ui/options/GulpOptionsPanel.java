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
package org.netbeans.modules.javascript.gulp.ui.options;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.netbeans.modules.javascript.gulp.exec.GulpExecutable;
import org.netbeans.modules.javascript.gulp.util.FileUtils;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.awt.HtmlBrowser;
import org.openide.awt.Mnemonics;
import org.openide.awt.StatusDisplayer;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.util.ChangeSupport;
import org.openide.util.NbBundle;

@OptionsPanelController.Keywords(keywords={"#KW.GulpOptionsPanel"}, location="Html5", tabTitle= "Gulp")
public class GulpOptionsPanel extends JPanel {

    private static final Logger LOGGER = Logger.getLogger(GulpOptionsPanel.class.getName());

    private final ChangeSupport changeSupport = new ChangeSupport(this);


    public GulpOptionsPanel() {
        assert EventQueue.isDispatchThread();
        initComponents();

        init();
    }

    @NbBundle.Messages({
        "# {0} - gulp file name",
        "GulpOptionsPanel.gulp.hint=Full path of Gulp file (typically {0}).",
    })
    private void init() {
        errorLabel.setText(" "); // NOI18N
        hintLabel.setText(Bundle.GulpOptionsPanel_gulp_hint(GulpExecutable.GULP_NAME));
        gulpTextField.getDocument().addDocumentListener(new DefaultDocumentListener());
    }

    public void addChangeListener(ChangeListener listener) {
        changeSupport.addChangeListener(listener);
    }

    public void removeChangeListener(ChangeListener listener) {
        changeSupport.removeChangeListener(listener);
    }

    public void setError(String message) {
        errorLabel.setText(" "); // NOI18N
        errorLabel.setForeground(UIManager.getColor("nb.errorForeground")); // NOI18N
        errorLabel.setText(message);
    }

    public void setWarning(String message) {
        errorLabel.setText(" "); // NOI18N
        errorLabel.setForeground(UIManager.getColor("nb.warningForeground")); // NOI18N
        errorLabel.setText(message);
    }

    public String getGulp() {
        return gulpTextField.getText();
    }

    public void setGulp(String gulp) {
        gulpTextField.setText(gulp);
    }

    void fireChange() {
        changeSupport.fireChange();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gulpLabel = new JLabel();
        gulpTextField = new JTextField();
        gulpBrowseButton = new JButton();
        gulpSearchButton = new JButton();
        hintLabel = new JLabel();
        installLabel = new JLabel();
        errorLabel = new JLabel();

        gulpLabel.setLabelFor(gulpTextField);
        Mnemonics.setLocalizedText(gulpLabel, NbBundle.getMessage(GulpOptionsPanel.class, "GulpOptionsPanel.gulpLabel.text")); // NOI18N

        Mnemonics.setLocalizedText(gulpBrowseButton, NbBundle.getMessage(GulpOptionsPanel.class, "GulpOptionsPanel.gulpBrowseButton.text")); // NOI18N
        gulpBrowseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                gulpBrowseButtonActionPerformed(evt);
            }
        });

        Mnemonics.setLocalizedText(gulpSearchButton, NbBundle.getMessage(GulpOptionsPanel.class, "GulpOptionsPanel.gulpSearchButton.text")); // NOI18N
        gulpSearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                gulpSearchButtonActionPerformed(evt);
            }
        });

        Mnemonics.setLocalizedText(hintLabel, "HINT"); // NOI18N

        Mnemonics.setLocalizedText(installLabel, NbBundle.getMessage(GulpOptionsPanel.class, "GulpOptionsPanel.installLabel.text")); // NOI18N
        installLabel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                installLabelMousePressed(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                installLabelMouseEntered(evt);
            }
        });

        Mnemonics.setLocalizedText(errorLabel, "ERROR"); // NOI18N

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(gulpLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hintLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(installLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gulpTextField)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gulpBrowseButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gulpSearchButton))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(errorLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(gulpLabel)
                    .addComponent(gulpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(gulpBrowseButton)
                    .addComponent(gulpSearchButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(hintLabel)
                    .addComponent(installLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(errorLabel))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void installLabelMouseEntered(MouseEvent evt) {//GEN-FIRST:event_installLabelMouseEntered
        evt.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_installLabelMouseEntered

    private void installLabelMousePressed(MouseEvent evt) {//GEN-FIRST:event_installLabelMousePressed
        try {
            HtmlBrowser.URLDisplayer.getDefault().showURL(new URL("https://github.com/gulpjs/gulp/blob/master/docs/getting-started.md")); // NOI18N
        } catch (MalformedURLException ex) {
            LOGGER.log(Level.WARNING, null, ex);
        }
    }//GEN-LAST:event_installLabelMousePressed

    @NbBundle.Messages("GulpOptionsPanel.gulp.browse.title=Select Gulp")
    private void gulpBrowseButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_gulpBrowseButtonActionPerformed
        assert EventQueue.isDispatchThread();
        File file = new FileChooserBuilder(GulpOptionsPanel.class)
                .setFilesOnly(true)
                .setTitle(Bundle.GulpOptionsPanel_gulp_browse_title())
                .showOpenDialog();
        if (file != null) {
            gulpTextField.setText(file.getAbsolutePath());
        }
    }//GEN-LAST:event_gulpBrowseButtonActionPerformed

    @NbBundle.Messages("GulpOptionsPanel.gulp.none=No Gulp executable was found.")
    private void gulpSearchButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_gulpSearchButtonActionPerformed
        assert EventQueue.isDispatchThread();
        for (String gulp : FileUtils.findFileOnUsersPath(GulpExecutable.GULP_NAME)) {
            gulpTextField.setText(new File(gulp).getAbsolutePath());
            return;
        }
        // no gulp found
        StatusDisplayer.getDefault().setStatusText(Bundle.GulpOptionsPanel_gulp_none());
    }//GEN-LAST:event_gulpSearchButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel errorLabel;
    private JButton gulpBrowseButton;
    private JLabel gulpLabel;
    private JButton gulpSearchButton;
    private JTextField gulpTextField;
    private JLabel hintLabel;
    private JLabel installLabel;
    // End of variables declaration//GEN-END:variables

    //~ Inner classes

    private final class DefaultDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            processUpdate();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            processUpdate();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            processUpdate();
        }

        private void processUpdate() {
            fireChange();
        }

    }

}
