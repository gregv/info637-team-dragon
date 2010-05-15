package edu.drexel.info637.imudb.db;

/**
 * This class is used to obtain the correct implementation of IIMuDbDatabase interface. The class manages the
 * database object as a singleton.
 * @author Team Dragon
 *
 */
public class DBObject {

    private static IIMuDbDatabase instance = null;

    /**
     * Returns the database interface
     * DLD PseudoCode:
     *{
     *      1. if current instance of database is null {
     *          2. create a new instance of the database interface
     *      } 3. else {
     *          4. return the existing instance
     *      }    
     *}
     * 
     * @return database interface
     */
    public static IIMuDbDatabase getInstance() {
        if (instance == null) {
            instance = new MySQLIMuDbImpl();
        }
        return instance;
    }

}
