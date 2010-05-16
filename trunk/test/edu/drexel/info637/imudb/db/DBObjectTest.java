package edu.drexel.info637.imudb.db;

import junit.framework.TestCase;

public class DBObjectTest extends TestCase {

    public void testGetInstance() {
        IIMuDbDatabase database = DBObject.getInstance();
        assertNotNull(database);
    }

}
