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

package org.netbeans.test.java.editor.jelly;

import org.netbeans.jemmy.operators.*;
import org.netbeans.jemmy.util.NameComponentChooser;

/**
 *
 * @author Jiri Prox
 * @version 1.0
 */
public class ImplementMethodsOperator extends JDialogOperator {

    /** Creates new GenerateImplementMethods that can handle it.
     */
    public ImplementMethodsOperator() {
        super("Generate Implement Methods");
    }

    private JLabelOperator _lblSelectMethodsToImplement;
    private JTreeOperator _treeTreeView$ExplorerTree;
    private JButtonOperator _btGenerate;
    private JButtonOperator _btCancel;


    //******************************
    // Subcomponents definition part
    //******************************

    /** Tries to find "Select methods to implement:" JLabel in this dialog.
     * @return JLabelOperator
     */
    public JLabelOperator lblSelectMethodsToImplement() {
        if (_lblSelectMethodsToImplement==null) {
            _lblSelectMethodsToImplement = new JLabelOperator(this, "Select methods to implement:");
        }
        return _lblSelectMethodsToImplement;
    }

    /** Tries to find null TreeView$ExplorerTree in this dialog.
     * @return JTreeOperator
     */
    public JTreeOperator treeTreeView$ExplorerTree() {
        if (_treeTreeView$ExplorerTree==null) {
            _treeTreeView$ExplorerTree = new JTreeOperator(this);
        }
        return _treeTreeView$ExplorerTree;
    }

    /** Tries to find "Generate" JButton in this dialog.
     * @return JButtonOperator
     */
    public JButtonOperator btGenerate() {
        if (_btGenerate==null) {
            _btGenerate = new JButtonOperator(this, "Generate");
        }
        return _btGenerate;
    }

    /** Tries to find "Cancel" JButton in this dialog.
     * @return JButtonOperator
     */
    public JButtonOperator btCancel() {
        if (_btCancel==null) {
            _btCancel = new JButtonOperator(this, "Cancel");
        }
        return _btCancel;
    }


    //****************************************
    // Low-level functionality definition part
    //****************************************

    /** clicks on "Generate" JButton
     */
    public void generate() {
        btGenerate().push();
    }

    /** clicks on "Cancel" JButton
     */
    public void cancel() {
        btCancel().push();
    }


    //*****************************************
    // High-level functionality definition part
    //*****************************************

    /** Performs verification of GenerateImplementMethods by accessing all its components.
     */
    public void verify() {
        lblSelectMethodsToImplement();
        treeTreeView$ExplorerTree();
        btGenerate();
        btCancel();
    }

    /** Performs simple test of GenerateImplementMethods
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        new ImplementMethodsOperator().verify();
        System.out.println("GenerateImplementMethods verification finished.");
    }
}

