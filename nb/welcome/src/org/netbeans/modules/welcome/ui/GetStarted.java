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

package org.netbeans.modules.welcome.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.netbeans.modules.welcome.content.BundleSupport;
import org.netbeans.modules.welcome.content.ActionButton;
import org.netbeans.modules.welcome.content.Constants;
import org.netbeans.modules.welcome.content.Utils;
import org.openide.cookies.InstanceCookie;
import org.openide.cookies.OpenCookie;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObject;

/**
 *
 * @author S. Aubrecht
 */
class GetStarted extends JPanel implements Constants {

    private int row;
    private InstallConfig ic;

    /** Creates a new instance of RecentProjects */
    public GetStarted() {
        super( new GridBagLayout() );
        setOpaque(false);
        ic = InstallConfig.getDefault();
        buildContent();
    }
    
    private void buildContent() {
        String rootName = "WelcomePage/GettingStartedLinks"; // NOI18N
        FileObject root = FileUtil.getConfigFile( rootName );
        if( null == root ) {
            Logger.getLogger(GetStarted.class.getName()).log(Level.INFO,
                    "Start page content not found: " + "FileObject: " + rootName ); //NOI18N
            return;
        }
        DataFolder folder = DataFolder.findFolder( root );
        if( null == folder ) {
            Logger.getLogger(GetStarted.class.getName()).log(Level.INFO,
                    "Start page content not found: " + "DataFolder: " + rootName ); //NOI18N
            return;
        }
        DataObject[] children = folder.getChildren();
        if( null == children ) {
            Logger.getLogger(GetStarted.class.getName()).log(Level.INFO,
                    "Start page content not found: " + "DataObject: " + rootName ); //NOI18N
            return;
        }
        for( int i=0; i<children.length; i++ ) {
            if( children[i].getPrimaryFile().isFolder() ) {
                String headerText = children[i].getNodeDelegate().getDisplayName();
                JLabel lblTitle = new JLabel( headerText );
                lblTitle.setFont( BUTTON_FONT );
                lblTitle.setHorizontalAlignment( JLabel.LEFT );
                lblTitle.setOpaque( true );
                lblTitle.setBorder( HEADER_TEXT_BORDER );
                add( lblTitle, new GridBagConstraints( 0,row++,1,1,1.0,0.0,
                    GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL,
                    new Insets(0,0,0,0), 0, 0 ) );

                DataFolder subFolder = DataFolder.findFolder( children[i].getPrimaryFile() );
                DataObject[] subFolderChildren = subFolder.getChildren();
                for( int j=0; j<subFolderChildren.length; j++ ) {
                    row = addLink( row, subFolderChildren[j] );
                }
                    
            } else {
                row = addLink( row, children[i] );
            }
        }

        add( new JLabel(), new GridBagConstraints(0, row++, 1, 1, 0.0, 1.0,
                GridBagConstraints.NORTHWEST, GridBagConstraints.VERTICAL, new Insets(0,0,0,0), 0, 0 ) );
    }

    private int addLink( int row, DataObject dob ) {
        Action action = extractAction( dob );
        if( null != action ) {
            JPanel panel = new JPanel( new GridBagLayout() );
            panel.setOpaque(false);
            ActionButton lb = new ActionButton( action, Utils.getUrlString( dob ),
                    Utils.getColor( COLOR_BIG_BUTTON ), true, dob.getPrimaryFile().getPath() );
            panel.add( lb, new GridBagConstraints(1,0,1,3,1.0,0.0,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,new Insets(0,0,0,0),0,0) );
            lb.setFont( GET_STARTED_FONT );
            
            lb.getAccessibleContext().setAccessibleName( lb.getText() );
            lb.getAccessibleContext().setAccessibleDescription( 
                    BundleSupport.getAccessibilityDescription( "GettingStarted", lb.getText() ) ); //NOI18N
            add( panel, new GridBagConstraints( 0,row++,1,1,1.0,0.0,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL,
                new Insets(0,0,3,0), 0, 0 ) );
        }
        return row;
    }

    private Action extractAction( DataObject dob ) {
        OpenCookie oc = dob.getCookie( OpenCookie.class );
        if( null != oc )
            return new LinkAction( dob );

        InstanceCookie.Of instCookie = dob.getCookie(InstanceCookie.Of.class);
        if( null != instCookie && instCookie.instanceOf( Action.class ) ) {
            try {
                Action res = (Action) instCookie.instanceCreate();
                if( null != res ) {
                    res.putValue(Action.NAME, dob.getNodeDelegate().getDisplayName() );
                }
                return res;
            } catch( Exception e ) {
                Logger.getLogger(SampleProjectAction.class.getName()).log( Level.INFO, null, e );
            }
        }
        return null;
    }

    private static class LinkAction extends AbstractAction {
        private DataObject dob;
        public LinkAction( DataObject dob ) {
            super( dob.getNodeDelegate().getDisplayName() );
            this.dob = dob;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            OpenCookie oc = dob.getCookie( OpenCookie.class );
            if( null != oc )
                oc.open();
        }
    }
}
