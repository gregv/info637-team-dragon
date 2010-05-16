package edu.drexel.info637.imudb.db;

import junit.framework.TestCase;
import edu.drexel.info637.imudb.user.LoginResult;

public class MySQLIMuDbImplTest extends TestCase {

    private IIMuDbDatabase imudbDatabase;

    protected void setUp() throws Exception {
        imudbDatabase = DBObject.getInstance();
    }

    protected void tearDown() throws Exception {
        imudbDatabase = null;
    }

    public void testAuthenticateUser() {
        LoginResult loginResult = imudbDatabase.authenticateUser("pfreestone", "999999");
        assertTrue(loginResult.isSuccess());

        loginResult = imudbDatabase.authenticateUser("notauser", "123456");
        assertTrue(!loginResult.isSuccess());
        assertEquals(loginResult.getErrorMsg(), "No user found by that name.");

        loginResult = imudbDatabase.authenticateUser("pfreestone", "123456");
        assertTrue(!loginResult.isSuccess());
        assertEquals(loginResult.getErrorMsg(), "incorrect password");
    }

}
