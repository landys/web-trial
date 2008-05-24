/**
 * SqlPropertiesTest.java
 * 
 * Copyright (c) 2006 Tony
 * All rights free.
 *
 * 
 * Revision History
 *
 * Date				Programmer			Notes
 * -------------	-----------------	---------------------------
 * Feb 03, 2007		Developer Name		initial
 */

package com.hozom.server.util;

import junit.framework.TestCase;

/**
 * @author tony
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class SqlUtilTest extends TestCase {

    /**
     * @throws java.lang.Exception
     */
    protected void setUp() throws Exception {
    }

    /**
     * Test method for
     * {@link com.hozom.server.util.SqlProperties#getProp(java.lang.String)}.
     */
    public void testGetProp() throws Exception {
        assertEquals("org.postgresql.Driver", SqlUtil.getInstance().getProp(
                "jdbc.driver"));
        assertEquals("jdbc:postgresql://localhost", SqlUtil.getInstance()
                .getProp("jdbc.url"));
        assertNull(SqlUtil.getInstance().getProp("abcdefg"));
    }

}
