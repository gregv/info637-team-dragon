/**
 * 
 */
package edu.drexel.info637.imudb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    public ArrayList<ArrayList<Object>> requestSQLExecution(String SQLQuery) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql:///IMuDb", "root", "");

            if (!con.isClosed())
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");

            System.out.println("Performing SQL = " + SQLQuery);
            stmt = con.createStatement();
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
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
            }
        }
        return result;
    }

    /*
     * (non-Javadoc)
     * @see edu.drexel.info637.imudb.db.IIMuDbDatabase#requestSQLUpdate(java.lang.String)
     */
    @ Override
    public int requestSQLUpdate(String SQLUpdateQuery) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int numberRowsAffected = -1;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql:///IMuDb", "root", "");

            if (!con.isClosed())
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");

            System.out.println("Performing SQL = " + SQLUpdateQuery);
            stmt = con.createStatement();
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
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
            }
        }

        return numberRowsAffected;
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
