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
package org.netbeans.modules.websvc.design.view.widget;

import java.awt.Color;
import java.util.List;

import org.netbeans.api.visual.model.ObjectScene;
import org.netbeans.api.visual.widget.Widget;
import org.netbeans.modules.websvc.design.view.Flushable;


/**
 * @author ads
 *
 */
abstract class FlushableWidget extends AbstractTitledWidget implements Flushable {

    public FlushableWidget(ObjectScene scene, int radius, Color color) {
        super(scene,radius,color);
    }
    public FlushableWidget(ObjectScene scene, int radius, int hgap, int cgap, Color color) {
        super(scene,radius,hgap, cgap , color);
    }
    
    /* (non-Javadoc)
     * @see org.netbeans.modules.websvc.design.view.widget.FlushableWidget#flushContent()
     */
    @Override
    public void flushContent() {
        List<Widget> children = getContentWidget().getChildren();
        for (Widget widget : children) {
            if ( widget instanceof  Flushable ){
                ((Flushable)widget).flushContent();
            }
        }
    }

    
}
