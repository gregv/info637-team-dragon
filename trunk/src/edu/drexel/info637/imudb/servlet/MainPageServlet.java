package edu.drexel.info637.imudb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.drexel.info637.imudb.db.DBObject;
import edu.drexel.info637.imudb.domain.Album;
import edu.drexel.info637.imudb.domain.Band;
import edu.drexel.info637.imudb.domain.Song;
import edu.drexel.info637.imudb.search.BasicSearch;
import edu.drexel.info637.imudb.search.SearchResults;
import edu.drexel.info637.imudb.user.AccessType;

public class MainPageServlet extends HttpServlet {

    private static final long serialVersionUID = -2084800063362700673L;
    private String            template;
    private AccessType        accessLevel;
    private long              id;
    private String            username;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Does not do anything in this release
        PrintWriter out = response.getWriter();
        out.println("Welcome to the MainPageServlet");
    }

    /*
     * (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse) Handles user searching functions
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String searchOption = request.getParameter("SearchOption");
        String searchKeyword = request.getParameter("SearchText");

        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (out == null)
            return;

        out.println("<html>");

        out.println("<p>&nbsp;</p>" + "<table border='0' cellspacing='0' cellpadding='3' width='100%' bgcolor='#515151' align=center>" + "<tbody>" + "<tr>" + "<td>"
                + "<p align='left'><a href='../index.jsp'><img border='0' hspace='0' src='../images/iMuDbLogo.jpg' width='184' height=90></a></p>" + "</td>" + "<td>" + "<p align='center'>"
                + "<form name='searchForm' method='POST'>" + "<font color='#ffffff'>Search &nbsp; " + "<select size='1' name=SearchOption>" + "<option selected value=Basic>Basic</option> "
                + "<option value=Advanced>Advanced</option></select>&nbsp;&nbsp; " + "<input size='60' name='SearchText'>&nbsp; " + "<input value='Search' type='submit' name='startSearch'>" + "</font>"
                + "</form>" + "</p>" + "</td>" + "<td valign='center'>" + "<p align='right'><font color='#ffffff'><font color='#ffffff'></font>"
                + "<font color=#ffffff></font><font color='#ffffff'></font><font color=#ffffff></font>" + "Register | <a href='../loginpage.jsp'>Login</a> | Help</font></p>"
                + "<p align='right'><font color='#ffffff'></font>&nbsp;</p></td></tr></tbody></table>" + "</P>" + "<p>");

        out.println("You searched for: \"" + searchKeyword + "\"");

        if (searchOption.equals("Advanced")) {
            out.println("<br><br>You selected the advanced option which <b>does not work at this time.</b>");
            out.println("</html>");
            return;
        }

        BasicSearch basicSearch = new BasicSearch();
        basicSearch.setKeyword(searchKeyword);
        SearchResults searchResults = basicSearch.getResults();
        List<Album> albums = searchResults.getAlbums();
        List<Band> bands = searchResults.getBands();
        List<Song> songs = searchResults.getSongs();

        if (searchResults.size() == 0) {
            out.println("<h1>There are no results to display for your query</h1>");
            out.println("<h4>Hint: Search for \"Ten\" or \"Pearl Jam\"</h4>");
        }
        if (albums.size() > 0) {
            out.println("<h1>Album Search Results</h1>");
            out.println("<table align='center' width='80%'>");
            out.printf("<tr bgcolor='#C0C0C0'> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> </tr>", "ID", "Name", "Producer", "Record Label");

            for (Album a : albums) {
                out.printf("<tr> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> </tr>", a.getAlbumID(), a.getAlbumName(), a.getProducer(), a.getRecordLabel());
            }
            out.println("</table>");
        }
        if (songs.size() > 0) {
            out.println("<h1>Song Search Results</h1>");
            out.println("<table align='center' width='80%'>");
            out.printf("<tr bgcolor='#C0C0C0'> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> </tr>", "Title", "Author", "Band", "Album");

            for (Song s : songs) {
                Band b = DBObject.getInstance().getBandFromAlbumId(s.getAlbumID());

                out.printf("<tr> <td>%s</td> <td>%s</td> <td><a href='../servlet/BandArtistServlet?BandID=%d'>%s</a></td> <td>%s</td> </tr>", s.getSongName(), s.getSongAuthor(), b.getBandID(), s.getBand(), s
                        .getAlbumName());
            }
            out.println("</table>");
        }
        if (bands.size() > 0) {
            out.println("<h1>Band Search Results</h1>");
            out.println("<table align='center' width='95%'>");
            out.printf("<tr bgcolor='#C0C0C0'> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td></tr>", "Name", "Place Of Formation", "Year of Formation", "Link", "Description",
                    "Influences");

            for (Band b : bands) {
                Calendar c = new GregorianCalendar();
                c.setTimeInMillis(b.getYearFormed().getTime());

                int yearFormed = c.get(GregorianCalendar.YEAR);
                out
                        .printf(
                                "<tr> <td><a href='../servlet/BandArtistServlet?BandID=%d'><b>%s</b></a></td> <td>%s</td> <td>%s</td> <td>%s</td> <td><font size='2'>%s</font></td> <td><font size='2'>%s</font></td> </tr>",
                                b.getBandID(), b.getName(), b.getPlaceFormed(), yearFormed, b.getExternalWebsite(), b.getDescription(), b.getInfluences());
            }
            out.println("</table>");
        }

        out.println("</html>");
    }

    public void readTemplateHead(String template) {

    }

    public void readTemplateEnd(String template) {

    }

    public void displaySearch() {

    }

    public void displayInfoAlbum(String album) {

    }

    public void displayInfoBand(String band) {

    }

    public String checkAuthLevel(AccessType authLevel) {
        return null;
    }

    protected void trackUserActions() {

    }

}
