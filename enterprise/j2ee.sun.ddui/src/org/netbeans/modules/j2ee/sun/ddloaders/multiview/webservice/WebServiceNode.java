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
package org.netbeans.modules.j2ee.sun.ddloaders.multiview.webservice;

import org.netbeans.modules.j2ee.sun.ddloaders.multiview.common.*;
import org.netbeans.modules.j2ee.sun.dd.api.ASDDVersion;
import org.netbeans.modules.j2ee.sun.dd.api.common.WebserviceDescription;
import org.netbeans.modules.j2ee.sun.share.configbean.customizers.webservice.WebServicePanel;
import org.netbeans.modules.xml.multiview.ui.SectionNodeInnerPanel;
import org.netbeans.modules.xml.multiview.ui.SectionNodeView;


/**
 * @author Peter Williams
 */
public class WebServiceNode extends NamedBeanNode {

    public WebServiceNode(SectionNodeView sectionNodeView, final DDBinding binding, final ASDDVersion version) {
        super(sectionNodeView, binding, WebserviceDescription.WEBSERVICE_DESCRIPTION_NAME, 
                ICON_BASE_SERVICE_REF_NODE, version);
        
        enableRemoveAction();
// replace with webservice endpoint panels...
//        addChild(new PortInfoGroupNode(sectionNodeView, (ServiceRef) binding.getSunBean(), version));
    }

    protected SectionNodeInnerPanel createNodeInnerPanel() {
        return new WebServicePanel(getSectionNodeView(), this, version);
    }
    
}
