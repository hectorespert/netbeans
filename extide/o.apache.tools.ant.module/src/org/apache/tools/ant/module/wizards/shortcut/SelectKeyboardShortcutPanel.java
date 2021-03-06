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

package org.apache.tools.ant.module.wizards.shortcut;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.ChangeSupport;
import org.openide.util.Exceptions;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;

final class SelectKeyboardShortcutPanel extends javax.swing.JPanel implements KeyListener {

    private KeyStroke stroke = null;
    
    private SelectKeyboardShortcutWizardPanel wiz;
    
    /** Create the wizard panel component and set up some basic properties. */
    public SelectKeyboardShortcutPanel (SelectKeyboardShortcutWizardPanel wiz) {
        this.wiz = wiz;
        initComponents ();
	initAccessibility ();
        // Provide a name in the title bar.
        setName (NbBundle.getMessage (SelectKeyboardShortcutPanel.class, "SKSP_LBL_select_shortcut_to_add"));
        testField.addKeyListener (this);
    }

    
    private void initAccessibility () {        
        testField.getAccessibleContext().setAccessibleName(NbBundle.getMessage (SelectKeyboardShortcutPanel.class, "ACSN_LBL_type_here")); 
        testField.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage (SelectKeyboardShortcutPanel.class, "ACSD_LBL_type_here")); 
        this.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(SelectKeyboardShortcutPanel.class, "SKSP_TEXT_press_any_key_seq"));
    }
    
    // --- VISUAL DESIGN OF PANEL ---

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        hintsArea = new javax.swing.JTextArea();
        mainPanel = new javax.swing.JPanel();
        testField = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        hintsArea.setBackground(new java.awt.Color(204, 204, 204));
        hintsArea.setEditable(false);
        hintsArea.setFont(javax.swing.UIManager.getFont ("Label.font"));
        hintsArea.setForeground(new java.awt.Color(102, 102, 153));
        hintsArea.setLineWrap(true);
        hintsArea.setText(NbBundle.getMessage(SelectKeyboardShortcutPanel.class, "SKSP_TEXT_press_any_key_seq"));
        hintsArea.setWrapStyleWord(true);
        hintsArea.setDisabledTextColor(javax.swing.UIManager.getColor ("Label.foreground"));
        hintsArea.setEnabled(false);
        hintsArea.setOpaque(false);
        add(hintsArea, java.awt.BorderLayout.NORTH);

        testField.setColumns(15);
        testField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        testField.setText(NbBundle.getMessage(SelectKeyboardShortcutPanel.class, "SKSP_LBL_type_here"));
        mainPanel.add(testField);

        add(mainPanel, java.awt.BorderLayout.CENTER);

    }//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea hintsArea;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField testField;
    // End of variables declaration//GEN-END:variables
    
    // KeyListener:

    // --- see defect #217279
    // JDK-specific translation of KeyEvent to KeyStroke, method is only available
    // in JDK 1.7+
    private static final Method keyEvent_getExtendedKeyCode;
    
    static {
        Class eventClass = KeyEvent.class;
        Method m = null;
        try {
            m = eventClass.getMethod("getExtendedKeyCode"); // NOI18N
        } catch (NoSuchMethodException ex) {
            // expected, JDK < 1.7
        } catch (SecurityException ex) {
            Exceptions.printStackTrace(ex);
        }
        keyEvent_getExtendedKeyCode = m;
    }
    
    static KeyStroke createKeyStroke(KeyEvent e) {
        int code = e.getKeyCode();
        if (keyEvent_getExtendedKeyCode != null) {
            try {
                int ecode = (int)(Integer)keyEvent_getExtendedKeyCode.invoke(e);
                if (ecode != KeyEvent.VK_UNDEFINED) {
                    code = ecode;
                }
            } catch (IllegalAccessException ex) {
                Exceptions.printStackTrace(ex);
            } catch (IllegalArgumentException ex) {
                Exceptions.printStackTrace(ex);
            } catch (InvocationTargetException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        return KeyStroke.getKeyStroke(code, e.getModifiers());
    }
    // --- end defect #217279
    
    public void keyPressed (KeyEvent e) {
        // XXX ideally make TAB switch focus, rather than be handled...
        stroke = createKeyStroke(e);
        testField.setText (Utilities.keyToString (stroke));
        wiz.fireChangeEvent ();
        e.consume ();
    }
    public void keyReleased (KeyEvent e) {
        e.consume ();
    }
    public void keyTyped (KeyEvent e) {
        e.consume ();
    }
    
    public static class SelectKeyboardShortcutWizardPanel implements WizardDescriptor.Panel<ShortcutWizard> {

        private SelectKeyboardShortcutPanel panel = null;
        private FileObject shortcutsFolder = null;
        
        public Component getComponent () {
            return getPanel(); 
        }
        
        private SelectKeyboardShortcutPanel getPanel() {
            if (panel == null) {
                panel = new SelectKeyboardShortcutPanel(this);
            }
            return panel;
        }

        public HelpCtx getHelp () {
            return HelpCtx.DEFAULT_HELP;
        }

        public boolean isValid () {
            if (shortcutsFolder == null)
                shortcutsFolder = FileUtil.getConfigFile ("Shortcuts"); // NOI18N
            return (getPanel().stroke != null) &&
                   (shortcutsFolder.getFileObject(Utilities.keyToString(getPanel().stroke), "instance") == null) && // NOI18N
                   (shortcutsFolder.getFileObject(Utilities.keyToString(getPanel().stroke), "xml") == null); // NOI18N
        }

        private final ChangeSupport cs = new ChangeSupport(this);
        public final void addChangeListener (ChangeListener l) {
            cs.addChangeListener(l);
        }
        public final void removeChangeListener (ChangeListener l) {
            cs.removeChangeListener(l);
        }
        protected final void fireChangeEvent () {
            cs.fireChange();
        }

        public void readSettings(ShortcutWizard wiz) {
            // XXX later...
        }
        public void storeSettings(ShortcutWizard wiz) {
            wiz.putProperty(ShortcutWizard.PROP_STROKE, getPanel().stroke);
        }
    }
    
}
