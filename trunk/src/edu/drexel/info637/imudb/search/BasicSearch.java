/**
 * 
 */
package edu.drexel.info637.imudb.search;

import java.util.List;

import edu.drexel.info637.imudb.db.DBObject;
import edu.drexel.info637.imudb.domain.Album;
import edu.drexel.info637.imudb.domain.Band;

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

        List<Album> albums = results.getAlbums();
        List<Band> bands = results.getBands();

        System.out.println(albums.toString());
        System.out.println(bands.toString());

        return null;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
