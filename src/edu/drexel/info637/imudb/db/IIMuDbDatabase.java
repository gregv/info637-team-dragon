/**
 * 
 */
package edu.drexel.info637.imudb.db;

import java.util.ArrayList;

import edu.drexel.info637.imudb.domain.User;
import edu.drexel.info637.imudb.user.AccessType;

/**
 * @author Team Dragon
 * @class INFO 637 Purpose:
 * @version Notes:
 */
public interface IIMuDbDatabase {

    public AccessType loadUserAccessLevel(User user);

    public String loadUserPassword(String username);

    public User saveUser(User user);

    public ArrayList<ArrayList<Object>> requestSQLExecution(String SQLQuery);

    public int requestSQLUpdate(String SQLUpdateQuery);
}
