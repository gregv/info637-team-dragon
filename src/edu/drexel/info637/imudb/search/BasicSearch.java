/**
 * 
 */
package edu.drexel.info637.imudb.search;

import edu.drexel.info637.imudb.db.DBObject;

/**
 * @author Team Dragon
 * @class INFO 637 Purpose:
 * @version Notes:
 */
public class BasicSearch implements ISearch {

    private String keyword = null;

    public BasicSearch() {
    }

    /*
     * (non-Javadoc)
     * @see edu.drexel.info637.imudb.search.ISearch#getResults()
     */
    @ Override
    public SearchResults getResults() {
        SearchResults results = DBObject.getInstance().performBasicSearch(keyword);
        return results;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
