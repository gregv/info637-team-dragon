/**
 * 
 */
package edu.drexel.info637.imudb.db;

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

    public void requestSQLExecution(String SQLQuery);

    public void requestSQLUpdate(String SQLUpdateQuery);
}
