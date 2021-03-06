<?xml version="1.0" encoding="UTF-8"?>
<!--

    Licensed to the Apache Software Foundation (ASF) under one
    or more contributor license agreements.  See the NOTICE file
    distributed with this work for additional information
    regarding copyright ownership.  The ASF licenses this file
    to you under the Apache License, Version 2.0 (the
    "License"); you may not use this file except in compliance
    with the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.

-->

<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:p="http://www.netbeans.org/ns/project/1"
                xmlns:xalan="http://xml.apache.org/xslt"
                xmlns:sproject="http://www.netbeans.org/ns/nb-module-suite-project/1"
                exclude-result-prefixes="xalan p">
    <xsl:output method="xml" indent="yes" encoding="UTF-8" xalan:indent-amount="4"/>
    <xsl:template match="/">
        <xsl:comment><![CDATA[
*** GENERATED FROM project.xml - DO NOT EDIT  ***
***         EDIT ../build.xml INSTEAD         ***
]]></xsl:comment>
        <xsl:variable name="name" select="/p:project/p:configuration/sproject:data/sproject:name"/>
        <project name="{$name}-impl">
            <xsl:attribute name="basedir">..</xsl:attribute>
            <fail message="Please build using Ant 1.7.1 or higher.">
                <condition>
                    <not>
                        <antversion atleast="1.7.1"/>
                    </not>
                </condition>
            </fail>
            <property file="nbproject/private/platform-private.properties"/>
            <property file="nbproject/platform.properties"/>
            <macrodef name="property" uri="http://www.netbeans.org/ns/nb-module-suite-project/1">
                <attribute name="name"/>
                <attribute name="value"/>
                <sequential>
                    <property name="@{{name}}" value="${{@{{value}}}}"/>
                </sequential>
            </macrodef>
            <macrodef name="evalprops" uri="http://www.netbeans.org/ns/nb-module-suite-project/1">
                <attribute name="property"/>
                <attribute name="value"/>
                <sequential>
                    <property name="@{{property}}" value="@{{value}}"/>
                </sequential>
            </macrodef>
            <property file="${{user.properties.file}}"/>
            <sproject:property name="harness.dir" value="nbplatform.${{nbplatform.active}}.harness.dir"/>
            <sproject:property name="nbplatform.active.dir" value="nbplatform.${{nbplatform.active}}.netbeans.dest.dir"/>
            <sproject:evalprops property="cluster.path.evaluated" value="${{cluster.path}}"/>
            <fail message="Path to 'platform' cluster missing in $${{cluster.path}} property or using corrupt Netbeans Platform (missing harness).">
                <condition>
                    <not>
                        <contains string="${{cluster.path.evaluated}}" substring="platform"/>
                    </not>
                </condition>
            </fail>
            <ant antfile="nbproject/platform.xml"/>
            <fail message="Cannot find NetBeans build harness.
${{line.separator}}Check that nbplatform.${{nbplatform.active}}.netbeans.dest.dir and nbplatform.${{nbplatform.active}}.harness.dir are defined.
${{line.separator}}On a developer machine these are normally defined in ${{user.properties.file}}=${{netbeans.user}}/build.properties
${{line.separator}}but for automated builds you should pass these properties to Ant explicitly.
${{line.separator}}You may instead download the harness and platform: -Dbootstrap.url=.../tasks.jar -Dautoupdate.catalog.url=.../updates.xml">
                <condition>
                    <not>
                        <available file="${{harness.dir}}/suite.xml"/>
                    </not>
                </condition>
            </fail>
            <import file="${{harness.dir}}/suite.xml"/>
        </project>
    </xsl:template>
</xsl:stylesheet>
