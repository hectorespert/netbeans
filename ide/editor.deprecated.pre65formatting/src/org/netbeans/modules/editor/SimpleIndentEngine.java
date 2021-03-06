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

package org.netbeans.modules.editor;

import org.netbeans.editor.BaseKit;
import org.netbeans.editor.ext.ExtFormatter;

/**
* Java indentation engine that delegates to java formatter
*
* @author Miloslav Metelka
*/

public class SimpleIndentEngine extends FormatterIndentEngine {

    static final long serialVersionUID = -6445463074939516878L;

    public SimpleIndentEngine() {
    }

    protected ExtFormatter createFormatter() {
        return new ExtFormatter.Simple(BaseKit.class);
    }

    protected boolean acceptMimeType(String mimeType) {
        return true;
    }

}

