/**
 * 
 */
package edu.drexel.info637.imudb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.drexel.info637.imudb.domain.User;
import edu.drexel.info637.imudb.user.AccessType;

/**
 * @author Team Dragon
 * @class INFO 637 Purpose:
 * @version Notes:
 */
public class MySQLIMuDbImpl implements IIMuDbDatabase {

    /*
     * (non-Javadoc)
     * @see edu.drexel.info637.imudb.db.IIMuDbDatabase#loadUserAccessLevel(edu.drexel.info637.imudb.domain.User)
     */
    @ Override
    public AccessType loadUserAccessLevel(User user) {
        return null;
    }

    /*
     * (non-Javadoc)
     * @see edu.drexel.info637.imudb.db.IIMuDbDatabase#loadUserPassword(java.lang.String)
     */
    @ Override
    public String loadUserPassword(String username) {
        return null;
    }

    /*
     * (non-Javadoc)
     * @see edu.drexel.info637.imudb.db.IIMuDbDatabase#requestSQLExecution(java.lang.String)
     */
    @ Override
    public void requestSQLExecution(String SQLQuery) {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql:///IMuDb", "root", "");

            if (!con.isClosed())
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");

        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
            }
        }

    }

    /*
     * (non-Javadoc)
     * @see edu.drexel.info637.imudb.db.IIMuDbDatabase#requestSQLUpdate(java.lang.String)
     */
    @ Override
    public void requestSQLUpdate(String SQLUpdateQuery) {
    }

    /*
     * (non-Javadoc)
     * @see edu.drexel.info637.imudb.db.IIMuDbDatabase#saveUser(edu.drexel.info637.imudb.domain.User)
     */
    @ Override
    public User saveUser(User user) {
        return null;
    }

    public void logAction(String action) {

    }

}
