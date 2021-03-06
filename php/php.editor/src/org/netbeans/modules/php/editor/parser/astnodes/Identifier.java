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
package org.netbeans.modules.php.editor.parser.astnodes;

/**
 * Holds an identifier.<br>
 * uses for variable name, function name and class name.
 *
 * <pre>e.g.  $variableName - variableName is the identifier,
 * foo() - foo is the identifier,
 * $myClass->fun() - myClass and fun are identifiers
 * class MyClass {
 *     const CONST = "const"; // CONST is the identifier (PHP7.0)
 *     public function new(){} // new is the identifier(PHP7.0)
 * }
 * </pre>
 */
public class Identifier extends Expression {

    private final String name;
    private final boolean isKeyword; // for PHP7.0 Context Sensitive Lexer

    public Identifier(int start, int end, String value) {
        this(start, end, value, false);
    }

    public Identifier(int start, int end, String value, boolean isKeyword) {
        super(start, end);
        this.name = value;
        this.isKeyword = isKeyword;
    }

    public String getName() {
        return name;
    }

    public boolean isKeyword() {
        return isKeyword;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return getName();
    }
}
