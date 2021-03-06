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
package org.netbeans.modules.xml.catalog.impl;

import java.beans.*;
import java.awt.Image;
import org.netbeans.modules.xml.catalog.impl.XCatalog;
import static org.netbeans.modules.xml.catalog.impl.res.Bundle.*;

import org.openide.util.ImageUtilities;
import org.netbeans.modules.xml.catalog.spi.CatalogDescriptorBase;

public class XCatalogBeanInfo extends SimpleBeanInfo {

    /**
     * Gets the bean's <code>BeanDescriptor</code>s.
     * 
     * @return BeanDescriptor describing the editable
     * properties of this bean.  May return null if the
     * information should be obtained by automatic analysis.
     */
    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor beanDescriptor = new BeanDescriptor  ( XCatalog.class , XCatalogCustomizer.class );
        beanDescriptor.setDisplayName (NAME_x_catalog());
        beanDescriptor.setShortDescription (TEXT_x_catalog_desc());
	return beanDescriptor;
    }

    /**
     * Gets the bean's <code>PropertyDescriptor</code>s.
     * 
     * @return An array of PropertyDescriptors describing the editable
     * properties supported by this bean.  May return null if the
     * information should be obtained by automatic analysis.
     * <p>
     * If a property is indexed, then its entry in the result array will
     * belong to the IndexedPropertyDescriptor subclass of PropertyDescriptor.
     * A client of getPropertyDescriptors can use "instanceof" to check
     * if a given PropertyDescriptor is an IndexedPropertyDescriptor.
     */
    public PropertyDescriptor[] getPropertyDescriptors() {
        PropertyDescriptor[] properties = new PropertyDescriptor[4];
        int PROPERTY_source = 0;
        int PROPERTY_displayName = 1;
        int PROPERTY_shortDescription = 2;
        int PROPERTY_icon = 3;
        try {
            properties[PROPERTY_source] = new PropertyDescriptor ( "source", XCatalog.class, "getSource", "setSource" );
            properties[PROPERTY_source].setExpert ( true );
            properties[PROPERTY_source].setDisplayName (PROP_xcatalog_location());
            properties[PROPERTY_source].setShortDescription (PROP_xcatalog_location_desc());
            properties[PROPERTY_displayName] = new PropertyDescriptor ( "displayName", XCatalog.class, "getDisplayName", null );
            properties[PROPERTY_displayName].setDisplayName (PROP_xcatalog_name());
            properties[PROPERTY_displayName].setShortDescription (PROP_xcatalog_name_desc());
            properties[PROPERTY_shortDescription] = new PropertyDescriptor ( "shortDescription", XCatalog.class, "getShortDescription", null );
            properties[PROPERTY_shortDescription].setDisplayName (PROP_xcatalog_info());
            properties[PROPERTY_shortDescription].setShortDescription (PROP_xcatalog_info_desc());
            properties[PROPERTY_icon] = new IndexedPropertyDescriptor ( "iconResource", XCatalog.class, null, null, "getIconResource", null );
            properties[PROPERTY_icon].setHidden ( true );
        }
        catch( IntrospectionException e) {}                          
        
        // Here you can add code for customizing the properties array.
        
        properties[PROPERTY_shortDescription].setName(CatalogDescriptorBase.PROP_CATALOG_DESC);
        properties[PROPERTY_displayName].setName(CatalogDescriptorBase.PROP_CATALOG_NAME);
        properties[PROPERTY_icon].setName(CatalogDescriptorBase.PROP_CATALOG_ICON);
	return properties;
    }

    public Image getIcon (int type) {
        if ((type == java.beans.BeanInfo.ICON_COLOR_16x16) ||
            (type == java.beans.BeanInfo.ICON_MONO_16x16)) {

            return ImageUtilities.loadImage ("org/netbeans/modules/xml/catalog/impl/xmlCatalog.gif"); // NOI18N
        } else {
            return null;
        }
    }

}
