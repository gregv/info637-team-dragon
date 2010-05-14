/**
 * 
 */
package edu.drexel.info637.imudb.db;

/**
 * @author Team Dragon
 * @class INFO 637 Purpose:
 * @version Notes:
 */
public class DBObject {
    private IIMuDbDatabase instance;

    public DBObject() {
        instance = null;
    }

    public IIMuDbDatabase getInstance() {
        if (instance != null)
            return instance;
        else {
            instance = new MySQLIMuDbImpl();
            return instance;
        }

    }
}
