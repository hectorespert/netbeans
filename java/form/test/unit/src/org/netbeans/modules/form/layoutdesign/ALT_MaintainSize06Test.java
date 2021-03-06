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

package org.netbeans.modules.form.layoutdesign;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.*;
import org.openide.filesystems.FileUtil;

public class ALT_MaintainSize06Test extends LayoutTestCase {

    public ALT_MaintainSize06Test(String name) {
        super(name);
        try {
	    className = this.getClass().getName();
	    className = className.substring(className.lastIndexOf('.') + 1, className.length());
            startingFormFile = FileUtil.toFileObject(new File(url.getFile() + goldenFilesPath + className + "-StartingForm.form").getCanonicalFile());
        } catch (IOException ioe) {
            fail(ioe.toString());
        }
    }

    /**
     * Delete the list. The vertical gap between the textfields and buttons that
     * had default size defined so far should be set to explicit size.
     */
    public void doChanges0() {
        ld.externalSizeChangeHappened();
        // > UPDATE CURRENT STATE
        contInterior.put("Form", new Rectangle(0, 0, 436, 300));
        compBounds.put("jTextField1", new Rectangle(10, 11, 216, 20));
        baselinePosition.put("jTextField1-216-20", new Integer(14));
        compBounds.put("jToggleButton2", new Rectangle(10, 118, 105, 23));
        baselinePosition.put("jToggleButton2-105-23", new Integer(15));
        compBounds.put("jToggleButton3", new Rectangle(121, 118, 105, 23));
        baselinePosition.put("jToggleButton3-105-23", new Integer(15));
        compBounds.put("jTextField2", new Rectangle(10, 37, 216, 20));
        baselinePosition.put("jTextField2-216-20", new Integer(14));
        compBounds.put("jScrollPane1", new Rectangle(232, 11, 35, 130));
        baselinePosition.put("jScrollPane1-35-130", new Integer(0));
        compPrefSize.put("jTextField1", new Dimension(59, 20));
        compPrefSize.put("jTextField2", new Dimension(59, 20));
        prefPadding.put("jTextField2-jToggleButton2-1-0-0", new Integer(6)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton2-1-0-1", new Integer(11)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton2-1-0-2", new Integer(6)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton2-1-0-3", new Integer(18)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton3-1-0-0", new Integer(6)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton3-1-0-1", new Integer(11)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton3-1-0-2", new Integer(6)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton3-1-0-3", new Integer(18)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPaddingInParent.put("Form-jScrollPane1-1-1", new Integer(11)); // parentId-compId-dimension-compAlignment
        prefPaddingInParent.put("Form-jToggleButton2-1-1", new Integer(11)); // parentId-compId-dimension-compAlignment
        prefPaddingInParent.put("Form-jToggleButton3-1-1", new Integer(11)); // parentId-compId-dimension-compAlignment
        contInterior.put("Form", new Rectangle(0, 0, 436, 300));
        compBounds.put("jTextField1", new Rectangle(10, 11, 216, 20));
        baselinePosition.put("jTextField1-216-20", new Integer(14));
        compBounds.put("jToggleButton2", new Rectangle(10, 118, 105, 23));
        baselinePosition.put("jToggleButton2-105-23", new Integer(15));
        compBounds.put("jToggleButton3", new Rectangle(121, 118, 105, 23));
        baselinePosition.put("jToggleButton3-105-23", new Integer(15));
        compBounds.put("jTextField2", new Rectangle(10, 37, 216, 20));
        baselinePosition.put("jTextField2-216-20", new Integer(14));
        compBounds.put("jScrollPane1", new Rectangle(232, 11, 35, 130));
        baselinePosition.put("jScrollPane1-35-130", new Integer(0));
        ld.updateCurrentState();
        // < UPDATE CURRENT STATE
        compPrefSize.put("jTextField1", new Dimension(59, 20));
        compPrefSize.put("jTextField2", new Dimension(59, 20));
        prefPadding.put("jTextField2-jToggleButton2-1-0-0", new Integer(6)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton2-1-0-1", new Integer(11)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton2-1-0-2", new Integer(6)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton2-1-0-3", new Integer(18)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton3-1-0-0", new Integer(6)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton3-1-0-1", new Integer(11)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton3-1-0-2", new Integer(6)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton3-1-0-3", new Integer(18)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPaddingInParent.put("Form-jToggleButton2-1-1", new Integer(11)); // parentId-compId-dimension-compAlignment
        prefPaddingInParent.put("Form-jToggleButton3-1-1", new Integer(11)); // parentId-compId-dimension-compAlignment
        // parentId-compId-dimension-compAlignment
        lm.removeComponent("jScrollPane1", true);
        ld.externalSizeChangeHappened();
        // > UPDATE CURRENT STATE
        contInterior.put("Form", new Rectangle(0, 0, 436, 300));
        compBounds.put("jTextField1", new Rectangle(10, 11, 216, 20));
        baselinePosition.put("jTextField1-216-20", new Integer(14));
        compBounds.put("jToggleButton2", new Rectangle(10, 118, 105, 23));
        baselinePosition.put("jToggleButton2-105-23", new Integer(15));
        compBounds.put("jToggleButton3", new Rectangle(121, 118, 105, 23));
        baselinePosition.put("jToggleButton3-105-23", new Integer(15));
        compBounds.put("jTextField2", new Rectangle(10, 37, 216, 20));
        baselinePosition.put("jTextField2-216-20", new Integer(14));
        compPrefSize.put("jTextField1", new Dimension(59, 20));
        compPrefSize.put("jTextField2", new Dimension(59, 20));
        prefPadding.put("jTextField2-jToggleButton2-1-0-0", new Integer(6)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton2-1-0-1", new Integer(11)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton2-1-0-2", new Integer(6)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton2-1-0-3", new Integer(18)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton3-1-0-0", new Integer(6)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton3-1-0-1", new Integer(11)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton3-1-0-2", new Integer(6)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPadding.put("jTextField2-jToggleButton3-1-0-3", new Integer(18)); // comp1Id-comp2Id-dimension-comp2Alignment-paddingType
        prefPaddingInParent.put("Form-jToggleButton2-1-1", new Integer(11)); // parentId-compId-dimension-compAlignment
        prefPaddingInParent.put("Form-jToggleButton3-1-1", new Integer(11)); // parentId-compId-dimension-compAlignment
        contInterior.put("Form", new Rectangle(0, 0, 436, 300));
        compBounds.put("jTextField1", new Rectangle(10, 11, 216, 20));
        baselinePosition.put("jTextField1-216-20", new Integer(14));
        compBounds.put("jToggleButton2", new Rectangle(10, 118, 105, 23));
        baselinePosition.put("jToggleButton2-105-23", new Integer(15));
        compBounds.put("jToggleButton3", new Rectangle(121, 118, 105, 23));
        baselinePosition.put("jToggleButton3-105-23", new Integer(15));
        compBounds.put("jTextField2", new Rectangle(10, 37, 216, 20));
        baselinePosition.put("jTextField2-216-20", new Integer(14));
        ld.updateCurrentState();
        // < UPDATE CURRENT STATE
    }

}
