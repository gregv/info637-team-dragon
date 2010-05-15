package edu.drexel.info637.imudb.db;

import java.util.ArrayList;

import edu.drexel.info637.imudb.user.LoginResult;

/**
 * This interface is used to define methods that need to be implemented by the database class. This interface allows for a
 * change in the underlying storage implementation without affecting any classes outside of the package.
 * @author Patrick Freestone
 *
 */
public interface IIMuDbDatabase {

    /**
     * This method will take a username and password and authenticate the user against the user list
     * in the persistent data store
     * @param userName  username to validate password for
     * @param password  password for the given user
     * @return          a LoginResult object with status set and error message populated if necessary
     */
    public LoginResult authenticateUser(String userName, String password);

    public ArrayList<ArrayList<Object>> requestSQLExecution(String SQLQuery);

    public int requestSQLUpdate(String SQLUpdateQuery);
}
