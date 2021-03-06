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

package org.netbeans.modules.websvc.manager.test;

import java.awt.Dialog;
import java.util.LinkedList;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;

/**
 *
 * @author quynguyen
 */
public class DialogDisplayerNotifier extends DialogDisplayer {
    private LinkedList<WebServiceManagerListener> listeners = new LinkedList<WebServiceManagerListener>();
    
    public void addListener(WebServiceManagerListener listener) {
        listeners.add(listener);
    }
    
    public void removeListener(WebServiceManagerListener listener) {
        listeners.remove(listener);
    }
    
    public void removeAllListeners() {
        listeners.clear();
    }
    
    @Override
    public Object notify(NotifyDescriptor descriptor) {
        for (WebServiceManagerListener listener : listeners) {
            listener.eventFired(new WebServiceManagerEvent((String)descriptor.getMessage()));
        }
        return NotifyDescriptor.OK_OPTION;
    }

    @Override
    public Dialog createDialog(DialogDescriptor descriptor) {
        return null;
    }

}
