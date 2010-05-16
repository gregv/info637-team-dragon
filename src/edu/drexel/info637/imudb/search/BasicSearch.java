package edu.drexel.info637.imudb.search;

import edu.drexel.info637.imudb.db.DBObject;

/**
 * @author Team Dragon Allows a user to perform a basic search only with a keyword
 */
public class BasicSearch implements ISearch {

    private String keyword = null;

    public BasicSearch() {
    }

    /*
     * (non-Javadoc)
     * @see edu.drexel.info637.imudb.search.ISearch#getResults()
     */
    public SearchResults getResults() {
        SearchResults results = DBObject.getInstance().performBasicSearch(keyword);
        return results;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
