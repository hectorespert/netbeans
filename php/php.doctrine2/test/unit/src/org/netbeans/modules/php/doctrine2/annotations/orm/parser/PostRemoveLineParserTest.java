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
package org.netbeans.modules.php.doctrine2.annotations.orm.parser;

import java.util.Map;
import org.netbeans.junit.NbTestCase;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.php.spi.annotation.AnnotationLineParser;
import org.netbeans.modules.php.spi.annotation.AnnotationParsedLine;

/**
 *
 * @author Ondrej Brejla <obrejla@netbeans.org>
 */
public class PostRemoveLineParserTest extends NbTestCase {
    private SimpleAnnotationLineParser parser;

    public PostRemoveLineParserTest(String name) {
        super(name);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.parser = new SimpleAnnotationLineParser();
    }

    public void testIsAnnotationParser() throws Exception {
        assertTrue(parser instanceof AnnotationLineParser);
    }

    public void testReturnValueIsPostRemoveParsedLine_01() throws Exception {
        assertTrue(parser.parse("PostRemove") instanceof AnnotationParsedLine.ParsedLine);
    }

    public void testReturnValueIsPostRemoveParsedLine_02() throws Exception {
        assertTrue(parser.parse("Annotations\\PostRemove") instanceof AnnotationParsedLine.ParsedLine);
    }

    public void testReturnValueIsPostRemoveParsedLine_03() throws Exception {
        assertTrue(parser.parse("\\Foo\\Bar\\PostRemove") instanceof AnnotationParsedLine.ParsedLine);
    }

    public void testReturnValueIsNull() throws Exception {
        assertNull(parser.parse("PostRemoves"));
    }

    public void testValidUseCase_01() throws Exception {
        AnnotationParsedLine parsedLine = parser.parse("PostRemove");
        assertEquals("PostRemove", parsedLine.getName());
        assertEquals("", parsedLine.getDescription());
        Map<OffsetRange, String> types = parsedLine.getTypes();
        assertNotNull(types);
        assertEquals(1, types.size());
        String type1 = types.get(new OffsetRange(0, 10));
        assertEquals("PostRemove", type1);
    }

    public void testValidUseCase_02() throws Exception {
        AnnotationParsedLine parsedLine = parser.parse("PostRemove   ");
        assertEquals("PostRemove", parsedLine.getName());
        assertEquals("", parsedLine.getDescription());
        Map<OffsetRange, String> types = parsedLine.getTypes();
        assertNotNull(types);
        assertEquals(1, types.size());
        String type1 = types.get(new OffsetRange(0, 10));
        assertEquals("PostRemove", type1);
    }

    public void testValidUseCase_03() throws Exception {
        AnnotationParsedLine parsedLine = parser.parse("PostRemove\t\t  ");
        assertEquals("PostRemove", parsedLine.getName());
        assertEquals("", parsedLine.getDescription());
        Map<OffsetRange, String> types = parsedLine.getTypes();
        assertNotNull(types);
        assertEquals(1, types.size());
        String type1 = types.get(new OffsetRange(0, 10));
        assertEquals("PostRemove", type1);
    }

    public void testValidUseCase_05() throws Exception {
        AnnotationParsedLine parsedLine = parser.parse("Annotations\\PostRemove  \t");
        assertEquals("PostRemove", parsedLine.getName());
        assertEquals("", parsedLine.getDescription());
        Map<OffsetRange, String> types = parsedLine.getTypes();
        assertNotNull(types);
        assertEquals(1, types.size());
        String type1 = types.get(new OffsetRange(0, 22));
        assertEquals("Annotations\\PostRemove", type1);

    }

    public void testValidUseCase_06() throws Exception {
        AnnotationParsedLine parsedLine = parser.parse("\\Foo\\Bar\\PostRemove  \t");
        assertEquals("PostRemove", parsedLine.getName());
        assertEquals("", parsedLine.getDescription());
        Map<OffsetRange, String> types = parsedLine.getTypes();
        assertNotNull(types);
        assertEquals(1, types.size());
        String type1 = types.get(new OffsetRange(0, 19));
        assertEquals("\\Foo\\Bar\\PostRemove", type1);
    }

    public void testValidUseCase_07() throws Exception {
        AnnotationParsedLine parsedLine = parser.parse("postremove");
        assertEquals("PostRemove", parsedLine.getName());
        assertEquals("", parsedLine.getDescription());
        Map<OffsetRange, String> types = parsedLine.getTypes();
        assertNotNull(types);
        assertEquals(1, types.size());
        String type1 = types.get(new OffsetRange(0, 10));
        assertEquals("postremove", type1);
    }

    public void testValidUseCase_08() throws Exception {
        AnnotationParsedLine parsedLine = parser.parse("\\Foo\\Bar\\postremove  \t");
        assertEquals("PostRemove", parsedLine.getName());
        assertEquals("", parsedLine.getDescription());
        Map<OffsetRange, String> types = parsedLine.getTypes();
        assertNotNull(types);
        assertEquals(1, types.size());
        String type1 = types.get(new OffsetRange(0, 19));
        assertEquals("\\Foo\\Bar\\postremove", type1);
    }

}
