package edu.drexel.info637.imudb.search;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.drexel.info637.imudb.search.BasicSearch;
import edu.drexel.info637.imudb.search.SearchResults;

/**
 * @author Greg Vannoni
 * @class INFO 637 Purpose: Ensure Basic Search functionality works
 * @version Notes:
 */
public class BasicSearchTest {

    private BasicSearch basicSearchByBand;
    private BasicSearch basicSearchByAlbum;
    private BasicSearch basicSearchBySong;
    private BasicSearch basicSearchForNothing;

    /**
     * Method: setUp<br/>
     * @throws java.lang.Exception
     */
    @ Before
    public void setUp() throws Exception {
        basicSearchByBand = new BasicSearch();
        basicSearchByBand.setKeyword("Pearl Jam");

        basicSearchByAlbum = new BasicSearch();
        basicSearchByAlbum.setKeyword("Ten");
        
        basicSearchBySong = new BasicSearch();
        basicSearchBySong.setKeyword("Once");
        
        
        basicSearchForNothing = new BasicSearch();
        basicSearchForNothing.setKeyword("nothing");
    }

    /**
     * Method: tearDown<br/>
     * @throws java.lang.Exception
     */
    @ After
    public void tearDown() throws Exception {
    }

    /**
     * Test method for {@link edu.drexel.info637.imudb.search.BasicSearch#getResults()}.
     */
    @ Test
    public void testGetResults() {
        SearchResults sr = basicSearchByBand.getResults();
        assertTrue("Result size", sr.size() == 1);
        assertTrue("Data integrity", sr.getBands().get(0).getName().equals("Pearl Jam"));
        assertTrue("Data integrity", sr.getBands().get(0).getBandID() == 101);

        sr = basicSearchByAlbum.getResults();
        assertTrue("Result size", sr.size() == 1);
        assertTrue("Data integrity", sr.getAlbums().get(0).getAlbumName().equals("Ten"));
        assertTrue("Data integrity", sr.getAlbums().get(0).getAlbumID() == 101);
        
        sr = basicSearchBySong.getResults();
        assertTrue("Result size", sr.size() == 1);
        assertTrue("Data integrity", sr.getSongs().get(0).getSongName().equals("Once") );
        assertTrue("Data integrity", sr.getSongs().get(0).getSongID() == 10001);

        sr = basicSearchForNothing.getResults();
        assertTrue("Result size", sr.size() == 0);
    }
}
