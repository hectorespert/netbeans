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
package org.netbeans.modules.php.editor.lexer;

/**
 *
 * @author Ondrej Brejla <obrejla@netbeans.org>
 */
public class PHP54FeaturesTest extends PHPLexerTestBase {

    public PHP54FeaturesTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testTraits_01() throws Exception {
        performTest("lexer/traits_01");
    }

    public void testTraits_02() throws Exception {
        performTest("lexer/traits_02");
    }

    public void testTraits_03() throws Exception {
        performTest("lexer/traits_03");
    }

    public void testTraits_04() throws Exception {
        performTest("lexer/traits_04");
    }

    public void testTraits_05() throws Exception {
        performTest("lexer/traits_05");
    }

    public void testTraits_06() throws Exception {
        performTest("lexer/traits_06");
    }

    public void testShortArrays_01() throws Exception {
        performTest("lexer/shortArrays_01");
    }

    public void testShortArrays_02() throws Exception {
        performTest("lexer/shortArrays_02");
    }

    public void testShortArraysStaticScalar_01() throws Exception {
        performTest("lexer/shortArraysStaticScalar_01");
    }

    public void testShortArraysStaticScalar_02() throws Exception {
        performTest("lexer/shortArraysStaticScalar_02");
    }

    public void testBinaryNotation_01() throws Exception {
        performTest("lexer/binaryNotation_01");
    }

    public void testBinaryNotation_02() throws Exception {
        performTest("lexer/binaryNotation_02");
    }

    public void testBinaryNotation_03() throws Exception {
        performTest("lexer/binaryNotation_03");
    }

    public void testBinaryNotation_04() throws Exception {
        performTest("lexer/binaryNotation_04");
    }

    // #268496
    public void testCallableKeyword() throws Exception {
        performTest("lexer/callableKeyword");
    }

    public void testTraitConst() throws Exception {
        performTest("lexer/traitConst");
    }
}
