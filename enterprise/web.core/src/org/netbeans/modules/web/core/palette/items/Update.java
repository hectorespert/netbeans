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

package org.netbeans.modules.web.core.palette.items;

import java.util.ResourceBundle;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.netbeans.modules.web.core.palette.JspPaletteUtilities;
import org.openide.text.ActiveEditorDrop;
import org.openide.util.NbBundle;


/**
 *
 * @author Libor Kotouc
 */
public class Update implements ActiveEditorDrop {

    public static String STMT_DEFAULT = "UPDATE table_name\nSET column_name = new_value\nWHERE column_name = some_value"; // NOI18N
    SQLStmt stmt = null;
    private String variable = "";  //NOI18N
    private int scopeIndex = SQLStmt.SCOPE_DEFAULT;
    private String dataSource = "";  //NOI18N
    private String update = STMT_DEFAULT;
    private String displayName;
    private String stmtLabel = "";  //NOI18N
    private String stmtACSN = "";  //NOI18N
    private String stmtACSD = "";  //NOI18N

    public Update() {
        try {
            displayName = NbBundle.getBundle("org.netbeans.modules.web.core.palette.items.resources.Bundle").getString("NAME_jsp-Update"); // NOI18N
        } catch (Exception e) {
        }

        ResourceBundle bundle = NbBundle.getBundle("org.netbeans.modules.web.core.palette.items.Bundle"); // NOI18N
        try {
            stmtLabel = bundle.getString("LBL_Update_Stmt"); // NOI18N
        } catch (Exception e) {
        }
        try {
            stmtACSN = bundle.getString("ACSN_Update_Stmt"); // NOI18N
        } catch (Exception e) {
        }
        try {
            stmtACSD = bundle.getString("ACSD_Update_Stmt"); // NOI18N
        } catch (Exception e) {
        }

        stmt = new SQLStmt(variable, scopeIndex, dataSource, update, "UpdateStmtCustomizer"); // NOI18N
    }

    public boolean handleTransfer(JTextComponent targetComponent) {
        boolean accept = stmt.customize(targetComponent, displayName, stmtLabel, stmtACSN, stmtACSD);
        if (accept) {
            String prefix = JspPaletteUtilities.findSqlPrefix(targetComponent);
            String body = createBody(prefix);
            try {
                JspPaletteUtilities.insert(body, targetComponent);
            } catch (BadLocationException ble) {
                accept = false;
            }
        }
        return accept;
    }

    private String createBody(String prefix) {
        variable = stmt.getVariable();
        dataSource = stmt.getDataSource();
        if (variable.equals("")) {// NOI18N
            variable = JspPaletteUtilities.CARET;
        } else if (dataSource.equals("")) {// NOI18N
            dataSource = JspPaletteUtilities.CARET;
        }
        String strVariable = " var=\"\""; // NOI18N
        if (variable.length() > 0) {
            strVariable = " var=\"" + variable + "\""; // NOI18N
        }
        scopeIndex = stmt.getScopeIndex();
        String strScope = "";  //NOI18N
        if (scopeIndex != SQLStmt.SCOPE_DEFAULT) {
            strScope = " scope=\"" + SQLStmt.scopes[scopeIndex] + "\""; // NOI18N
        }
        String strDS = " dataSource=\"\""; // NOI18N
        if (strDS.length() > 0) {
            strDS = " dataSource=\"" + dataSource + "\""; // NOI18N
        }
        update = stmt.getStmt();
        String strUpdate = update;
        if (update.length() > 0) {
            strUpdate += "\n"; // NOI18N
        }
        return "<"+prefix+":update" + strVariable + strScope + strDS + ">\n" + // NOI18N
                strUpdate + "</"+prefix+":update>"; // NOI18N
    }
}
