package edu.drexel.info637.imudb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.drexel.info637.imudb.user.LoginResult;

/**
 * Implementation of the IIMuDbDatabase interface for a MySQL database
 * @author Team Dragon
 *
 */
public class MySQLIMuDbImpl implements IIMuDbDatabase {

    private static final String DB_URL                            = "jdbc:mysql://localhost/IMuDb";
    private static final String DB_USER                           = "root";
    private static final String DB_PASSWORD                       = "";

    private static final String SQL_SELECT_PASSWORD_WITH_USERNAME = "SELECT password FROM user WHERE username = ?";

    Connection                  conn                              = null;

    /**
     * Constructor used by the DBObject class when handing out the chosen database interface. The constructor solely
     * loads the appropriate driver.
     */
    protected MySQLIMuDbImpl() {
        loadDriver();
    }

    /**
     * {@inheritDoc}
     * DLD PseudoCode:
     * {
     *      1. get connection object
     *      2. create statement object
     *      3. populate SQL string to find password
     *      4. execute statement and get result set
     *      5. if no rows are return {
     *          6. populate LoginResult with failure status
     *          7. add error message to LoginResult
     *      } 8. else if multiple rows are returned {
     *          9. populate LoginResult with failure status
     *          10. add error message to LoginResult
     *      } 11. else if the password provided is incorrect {
     *          12. populate LoginResult with failure status
     *          13. add error message to LoginResult
     *      } 14. else if passwords match {
     *          15. populate LoginResult with success status
     *          16. populate User object on LoginResult
     *      } 17. else {
     *          18. populate LoginResult with failure status
     *          19. add error message to LoginResult
     *      }
     * }
     */
    public LoginResult authenticateUser(String userName, String password) {
        getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        LoginResult loginResult = new LoginResult();

        try {
            stmt = conn.prepareStatement(SQL_SELECT_PASSWORD_WITH_USERNAME);
            stmt.setString(1, userName);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String databasePassword = rs.getString(1);
                if (rs.next()) {
                    loginResult.setSuccess(false);
                    loginResult.setErrorMsg("More than one user by that name. Contact Sys Admin.");
                } else {
                    if (databasePassword.equals(password)) {
                        loginResult.setSuccess(true);
                    } else {
                        loginResult.setSuccess(false);
                        loginResult.setErrorMsg("incorrect password");
                    }
                }
            } else {
                loginResult.setSuccess(false);
                loginResult.setErrorMsg("No user found by that name.");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return loginResult;
    }

    /**
     * Method responsible for loading the MySQL jdbc driver
     */
    private void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (IllegalAccessException iae) {
            iae.printStackTrace();
        } catch (InstantiationException ie) {
            ie.printStackTrace();
        }
    }

    /**
     * Method responsible for getting/refreshing the database connection
     */
    private void getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see edu.drexel.info637.imudb.db.IIMuDbDatabase#requestSQLExecution(java.lang.String)
     */
    public ArrayList<ArrayList<Object>> requestSQLExecution(String SQLQuery) {
        getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();

        try {

            System.out.println("Performing SQL = " + SQLQuery);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQLQuery);

            if (rs != null) {
                try {
                    ArrayList<Object> row = null;
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int colCount = rsmd.getColumnCount();

                    while (rs.next()) {
                        row = new ArrayList<Object>();

                        for (int i = 1; i <= colCount; i++) {
                            String columnName = rsmd.getColumnName(i);
                            Object value = rs.getObject(i);

                            row.add(value);
                        }

                        result.add(row);
                    } // end while

                    rs.close();
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    while (e != null) {
                        System.out.println("Message   : " + e.getMessage());
                        System.out.println("SQLState  : " + e.getSQLState());
                        System.out.println("ErrorCode : " + e.getErrorCode());
                        System.out.println("---");
                        e = e.getNextException();
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /*
     * (non-Javadoc)
     * @see edu.drexel.info637.imudb.db.IIMuDbDatabase#requestSQLUpdate(java.lang.String)
     */
    public int requestSQLUpdate(String SQLUpdateQuery) {
        getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        int numberRowsAffected = -1;

        try {

            System.out.println("Performing SQL = " + SQLUpdateQuery);
            stmt = conn.createStatement();
            numberRowsAffected = stmt.executeUpdate(SQLUpdateQuery);
        } catch (SQLException se) {
            while (se != null) {
                System.out.println("Message   : " + se.getMessage());
                System.out.println("SQLState  : " + se.getSQLState());
                System.out.println("ErrorCode : " + se.getErrorCode());
                System.out.println("---");
                se = se.getNextException();
            }

        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }

        return numberRowsAffected;
    }

    /**
     * Overriding the finalize method to ensure the database connection is closed when this object goes away.
     */
    public void finalize() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }

}
