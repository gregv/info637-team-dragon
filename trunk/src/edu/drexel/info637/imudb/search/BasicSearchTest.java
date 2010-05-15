/**
 * 
 */
package edu.drexel.info637.imudb.search;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Greg Vannoni
 * @class INFO 636 Purpose:
 * @version Notes:
 */
public class BasicSearchTest {

    private BasicSearch basicSearch;

    /**
     * Method: setUp<br/>
     * @throws java.lang.Exception
     */
    @ Before
    public void setUp() throws Exception {
        basicSearch = new BasicSearch();
        basicSearch.setKeyword("Pearl Jam");

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
        basicSearch.getResults();
        fail("Not yet implemented");
    }

}
