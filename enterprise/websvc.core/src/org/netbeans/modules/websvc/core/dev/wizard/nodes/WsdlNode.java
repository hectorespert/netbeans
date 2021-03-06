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

package org.netbeans.modules.websvc.core.dev.wizard.nodes;

import java.awt.Image;
import org.netbeans.modules.websvc.api.jaxws.wsdlmodel.WsdlModel;
import org.openide.nodes.AbstractNode;
import org.openide.util.HelpCtx;
import org.openide.util.ImageUtilities;
import org.openide.util.Utilities;

/** Node representing WS Service
 *
 * @author mkuchtiak
 */
public class WsdlNode extends AbstractNode {
    
    public WsdlNode(WsdlModel model) {
        super(new WsdlNodeChildren(model));
        setName("WSDL model");
        setDisplayName("WSDL model");
    }
    
    @Override
    public Image getIcon(int type){
        return ImageUtilities.loadImage("org/netbeans/modules/websvc/core/webservices/ui/resources/webservice.png"); //NOI18N
    }
    
    @Override
    public Image getOpenedIcon(int type){
        return getIcon( type);
    }
    
    @Override
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }
    
    // Handle deleting:
    @Override
    public boolean canDestroy() {
        return false;
    }
    
}
