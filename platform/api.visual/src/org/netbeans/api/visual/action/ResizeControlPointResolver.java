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
package org.netbeans.api.visual.action;

import org.netbeans.api.visual.widget.Widget;

import java.awt.*;

/**
 * This interface is used by ResizeAction to resolve if and which control point is being dragged for particular resizing.
 *
 * @author David Kaspar
 */
public interface ResizeControlPointResolver {

    /**
     * Resolves which control point is being dragged by user.
     * @param widget the widget where the user is invoking the resizing
     * @param point the mouse cursor location in local coordination system of the widget
     * @return the control point; if null, then resizing action is denied
     */
    ResizeProvider.ControlPoint resolveControlPoint (Widget widget, Point point);

}
