package edu.drexel.info637.imudb.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import edu.drexel.info637.imudb.domain.Album;
import edu.drexel.info637.imudb.domain.Band;
import edu.drexel.info637.imudb.domain.Comment;
import edu.drexel.info637.imudb.domain.Genre;
import edu.drexel.info637.imudb.domain.Song;
import edu.drexel.info637.imudb.domain.User;
import edu.drexel.info637.imudb.search.SearchResults;
import edu.drexel.info637.imudb.user.LoginResult;

/**
 * Implementation of the IIMuDbDatabase interface for a MySQL database
 * @author Team Dragon
 */
public class MySQLIMuDbImpl implements IIMuDbDatabase {

    private static final String DB_URL                            = "jdbc:mysql://localhost/IMuDb";
    private static final String DB_USER                           = "root";
    private static final String DB_PASSWORD                       = "";

    private static final String SQL_SELECT_PASSWORD_WITH_USERNAME = "SELECT password FROM user WHERE username = ?";
    private static final String SQL_BASIC_SEARCH_TABLES_ALBUM     = "SELECT * FROM album WHERE name like ?";
    private static final String SQL_BASIC_SEARCH_TABLES_BAND      = "SELECT * FROM band WHERE name like ?";
    private static final String SQL_BASIC_SEARCH_TABLES_CONCERT   = "SELECT * FROM concert WHERE venue = ?";
    private static final String SQL_BASIC_SEARCH_TABLES_MUSICIAN  = "SELECT * FROM musician WHERE name like ?";
    private static final String SQL_BASIC_SEARCH_TABLES_SONG      = "SELECT * FROM song WHERE name like ?";
    private static final String SQL_BASIC_SEARCH_TABLES_TRACK     = "SELECT t.* FROM track t,song s WHERE s.name = ? AND t.song_id = s.song_id";
    private static final String SQL_BAND_DETAILS                  = "SELECT * FROM band WHERE Band_ID = ?";
    private static final String SQL_GENRE_NAME                    = "SELECT * FROM genre WHERE Genre_ID = ?";
    private static final String SQL_BAND_ALBUM_CONTRIBUTION       = "SELECT * FROM bandalbumcontribution WHERE Band_ID = ?";
    private static final String SQL_ALBUM_INFORMATION             = "SELECT * FROM album WHERE Album_ID = ?";
    private static final String SQL_ALBUM_SONGS                   = "SELECT * FROM song WHERE Album_ID = ?";
    private static final String SQL_USER_COMMENTS                 = "SELECT * FROM comments WHERE Band_ID = ?";

    Connection                  conn                              = null;

    /**
     * Constructor used by the DBObject class when handing out the chosen database interface. The constructor solely
     * loads the appropriate driver.
     */
    protected MySQLIMuDbImpl() {
        loadDriver();
    }

    /*
     * Allows a user to search album and band information with a single keyword
     */
    public SearchResults performBasicSearch(String keyword) {
        SearchResults searchResults = new SearchResults();

        searchResults.setAlbumList(searchAlbums(keyword));
        searchResults.setBand(searchBands(keyword));
        searchResults.setSongList(searchSongs(keyword));
        return searchResults;
    }

    /*
     * Searches song information in the database
     */
    public List<Song> searchSongs(String keyword) {
        getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Song> songs = new ArrayList<Song>();

        try {
            stmt = conn.prepareStatement(SQL_BASIC_SEARCH_TABLES_SONG);
            stmt.setString(1, keyword + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Song s = new Song();

                int i = 1;

                Integer key = rs.getInt(i++);
                Integer songId = rs.getInt(i++);
                Integer albumId = rs.getInt(i++);
                String name = rs.getString(i++);
                String author = rs.getString(i++);
                String band = rs.getString(i++);

                s.setAlbumID(key);
                s.setAlbumName(getAlbumById(albumId).getAlbumName());
                s.setBand(band);
                s.setSongAuthor(author);
                s.setSongID(songId);
                s.setSongName(name);

                songs.add(s);

            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return songs;
    }

    /*
     * Gets information about an album by album id
     */
    public Album getAlbumById(Integer id) {
        getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Album a = new Album();

        try {
            stmt = conn.prepareStatement(SQL_ALBUM_INFORMATION);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int i = 1;
                Integer key = rs.getInt(i++);
                Integer albumId = rs.getInt(i++);
                String name = rs.getString(i++);
                Date releaseDate = rs.getDate(i++);
                String recordLabel = rs.getString(i++);
                String producer = rs.getString(i++);

                a.setAlbumID(albumId);
                a.setAlbumName(name);
                a.setReleaseDate(releaseDate);
                a.setRecordLabel(recordLabel);
                a.setProducer(producer);

            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return a;
    }

    /*
     * Searches album information in the database
     */
    public List<Album> searchAlbums(String keyword) {
        getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Album> albums = new ArrayList<Album>();

        try {
            stmt = conn.prepareStatement(SQL_BASIC_SEARCH_TABLES_ALBUM);
            stmt.setString(1, keyword + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Album a = new Album();

                int i = 1;
                Integer key = rs.getInt(i++);
                Integer albumId = rs.getInt(i++);
                String name = rs.getString(i++);
                Date releaseDate = rs.getDate(i++);
                String recordLabel = rs.getString(i++);
                String producer = rs.getString(i++);

                a.setAlbumID(albumId);
                a.setAlbumName(name);
                a.setReleaseDate(releaseDate);
                a.setRecordLabel(recordLabel);
                a.setProducer(producer);

                albums.add(a);

            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return albums;
    }

    /*
     * Searches for band information in the database
     */
    public List<Band> searchBands(String keyword) {
        getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Band> bands = new ArrayList<Band>();

        try {
            stmt = conn.prepareStatement(SQL_BASIC_SEARCH_TABLES_BAND);
            stmt.setString(1, keyword + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Band b = new Band();

                int i = 1;
                Integer key = rs.getInt(i++);
                Integer bandId = rs.getInt(i++);
                String name = rs.getString(i++);
                String placeOfFormation = rs.getString(i++);
                Integer yearOfFormation = rs.getInt(i++);
                String websiteLink = rs.getString(i++);
                String description = rs.getString(i++);
                String influences = rs.getString(i++);
                String hobbies = rs.getString(i++);
                Integer genreId = rs.getInt(i++);

                b.setBandID(bandId);
                b.setDescription(description);
                b.setExternalWebsite(websiteLink);
                b.setGenreID(genreId);
                b.setHobbies(hobbies);
                b.setInfluences(influences);
                b.setName(name);
                b.setPlaceFormed(placeOfFormation);

                // Need to convert year to date
                Calendar c = new GregorianCalendar();
                c.set(yearOfFormation, 0, 1);
                Date yearFormed = new Date(c.getTimeInMillis());

                b.setYearFormed(yearFormed);

                bands.add(b);

            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return bands;
    }

    // use this method to get a band by its ID
    // this means that we already have selected the band (out of a list of a few possibles) and
    // we want to take the specific one, identified by its BandID number
    public ArrayList<Band> searchBandID(int bID) {
        getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Band> bands = new ArrayList<Band>();

        try {
            stmt = conn.prepareStatement(SQL_BAND_DETAILS);
            stmt.setString(1, "" + bID);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Band b = new Band();

                int i = 1;
                Integer key = rs.getInt(i++);
                Integer bandId = rs.getInt(i++);
                String name = rs.getString(i++);
                String placeOfFormation = rs.getString(i++);
                Integer yearOfFormation = rs.getInt(i++);
                String websiteLink = rs.getString(i++);
                String description = rs.getString(i++);
                String influences = rs.getString(i++);
                String hobbies = rs.getString(i++);
                Integer genreId = rs.getInt(i++);

                b.setBandID(bandId);
                b.setDescription(description);
                b.setExternalWebsite(websiteLink);
                b.setGenreID(genreId);
                b.setHobbies(hobbies);
                b.setInfluences(influences);
                b.setName(name);
                b.setPlaceFormed(placeOfFormation);

                // Need to convert year to date
                Calendar c = new GregorianCalendar();
                c.set(yearOfFormation, 0, 1);
                Date yearFormed = new Date(c.getTimeInMillis());

                b.setYearFormed(yearFormed);

                bands.add(b);

            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return bands;
    }

    /**
     * DLD 1. lookup genre ID 2. get the Genre name corresponding to the ID 3. form Genre object 4. add the object to
     * the ArrayList 5. return the ArrayList to the caller function/method
     */
    public ArrayList<Genre> getGenreName(int gID) {
        getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Genre> Genres = new ArrayList<Genre>();

        try {
            stmt = conn.prepareStatement(SQL_GENRE_NAME);
            stmt.setString(1, "" + gID);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Genre g = new Genre();

                int i = 1;
                Integer key = rs.getInt(i++);
                Integer genreID = rs.getInt(i++);
                String name = rs.getString(i++);

                g.setGenreID(genreID);
                g.setGenreName(name);

                Genres.add(g);

            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return Genres;
    }

    // lookup albums that the band has worked with, published, etc.
    public ArrayList<Album> getBandAlbumContribution(int bID) {
        getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        ArrayList<Album> Albums = new ArrayList<Album>();

        try {
            stmt = conn.prepareStatement(SQL_BAND_ALBUM_CONTRIBUTION);
            stmt.setString(1, "" + bID);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int i = 1;
                Integer key = rs.getInt(i++);
                Integer albumID = rs.getInt(i++);
                Integer bandID = rs.getInt(i++);

                stmt2 = conn.prepareStatement(SQL_ALBUM_INFORMATION);
                stmt2.setString(1, "" + albumID);
                rs2 = stmt2.executeQuery();
                while (rs2.next()) {
                    int m = 1;
                    Integer key2 = rs2.getInt(m++);
                    Integer albumID2 = rs2.getInt(m++);
                    String albumName = rs2.getString(m++);
                    Integer releaseDate = rs2.getInt(m++);
                    String recordLabel = rs2.getString(m++);
                    String producer = rs2.getString(m++);

                    // Need to convert year to date
                    Calendar c = new GregorianCalendar();
                    c.set(releaseDate, 0, 1);
                    Date dateReleased = new Date(c.getTimeInMillis());

                    Album a = new Album();
                    a.setAlbumID(albumID2);
                    a.setAlbumName(albumName);
                    a.setProducer(producer);
                    a.setRecordLabel(recordLabel);
                    a.setReleaseDate(dateReleased);

                    Albums.add(a);
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return Albums;
    }

    // Lookup all the albums that we know about for this Band and retrieve all the songs we know about
    public ArrayList<Song> getAlbumSongs(ArrayList<Album> albums) {
        getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Song> Songs = new ArrayList<Song>();

        for (Album a : albums) {
            try {
                stmt = conn.prepareStatement(SQL_ALBUM_SONGS);
                stmt.setString(1, "" + a.getAlbumID());
                rs = stmt.executeQuery();

                while (rs.next()) {
                    int i = 1;
                    Integer key = rs.getInt(i++);
                    Integer songID = rs.getInt(i++);
                    Integer albumID = rs.getInt(i++);
                    String songName = rs.getString(i++);
                    String author = rs.getString(i++);
                    String bandName = rs.getString(i++);

                    Song s = new Song();
                    s.setSongID(songID);
                    s.setSongAuthor(author);
                    s.setBand(bandName);
                    s.setSongName(songName);
                    s.setAlbumID(albumID);
                    s.setAlbumName(a.getAlbumName());

                    Songs.add(s);
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return Songs;
    }

    // Retrieve all user comments for the specified BandID
    public ArrayList<Comment> getUserComments(int bID) {
        getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        ArrayList<Comment> comments = new ArrayList<Comment>();

        try {
            stmt = conn.prepareStatement(SQL_USER_COMMENTS);
            stmt.setString(1, "" + bID);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int i = 1;
                Comment com = new Comment();
                Integer key = rs.getInt(i++);
                Integer bandID = rs.getInt(i++);
                Integer userID = rs.getInt(i++);
                String Comment = rs.getString(i++);
                int dAdded = rs.getInt(i++);

                Calendar c = new GregorianCalendar();
                c.set(dAdded, 0, 1);
                Date dateAdded = new Date(c.getTimeInMillis());

                com.setBandID(bandID);
                com.setUserID(userID);
                com.setSComment(Comment);
                com.setDAdded(dateAdded);

                comments.add(com);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return comments;
    }

    /**
     * {@inheritDoc} DLD PseudoCode: { 1. get connection object 2. create statement object 3. populate SQL string to
     * find password 4. execute statement and get result set 5. if no rows are return { 6. populate LoginResult with
     * failure status 7. add error message to LoginResult } 8. else if multiple rows are returned { 9. populate
     * LoginResult with failure status 10. add error message to LoginResult } 11. else if the password provided is
     * incorrect { 12. populate LoginResult with failure status 13. add error message to LoginResult } 14. else if
     * passwords match { 15. populate LoginResult with success status 16. populate User object on LoginResult } 17. else
     * { 18. populate LoginResult with failure status 19. add error message to LoginResult } }
     */
    public LoginResult authenticateUser(String userName, String password) {
        getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        LoginResult loginResult = new LoginResult();

        try {
            stmt = conn.prepareStatement(SQL_SELECT_PASSWORD_WITH_USERNAME);
            stmt.setString(1, userName);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String databasePassword = rs.getString(1);
                if (rs.next()) {
                    loginResult.setSuccess(false);
                    loginResult.setErrorMsg("More than one user by that name. Contact Sys Admin.");
                } else {
                    if (databasePassword.equals(password)) {
                        loginResult.setSuccess(true);
                        User user = new User();
                        user.setUserName(userName);
                        user.setPass(databasePassword);
                        loginResult.setUser(user);
                    } else {
                        loginResult.setSuccess(false);
                        loginResult.setErrorMsg("incorrect password");
                    }
                }
            } else {
                loginResult.setSuccess(false);
                loginResult.setErrorMsg("No user found by that name.");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return loginResult;
    }

    /**
     * Method responsible for loading the MySQL jdbc driver
     */
    private void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (IllegalAccessException iae) {
            iae.printStackTrace();
        } catch (InstantiationException ie) {
            ie.printStackTrace();
        }
    }

    /**
     * Method responsible for getting/refreshing the database connection
     */
    private void getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see edu.drexel.info637.imudb.db.IIMuDbDatabase#requestSQLExecution(java.lang.String)
     */
    public ArrayList<ArrayList<Object>> requestSQLExecution(String SQLQuery) {
        getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();

        try {

            System.out.println("Performing SQL = " + SQLQuery);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQLQuery);

            if (rs != null) {
                try {
                    ArrayList<Object> row = null;
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int colCount = rsmd.getColumnCount();

                    while (rs.next()) {
                        row = new ArrayList<Object>();

                        for (int i = 1; i <= colCount; i++) {
                            String columnName = rsmd.getColumnName(i);
                            Object value = rs.getObject(i);

                            row.add(value);
                        }

                        result.add(row);
                    } // end while

                    rs.close();
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    while (e != null) {
                        System.out.println("Message   : " + e.getMessage());
                        System.out.println("SQLState  : " + e.getSQLState());
                        System.out.println("ErrorCode : " + e.getErrorCode());
                        System.out.println("---");
                        e = e.getNextException();
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /*
     * (non-Javadoc)
     * @see edu.drexel.info637.imudb.db.IIMuDbDatabase#requestSQLUpdate(java.lang.String)
     */
    public int requestSQLUpdate(String SQLUpdateQuery) {
        getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        int numberRowsAffected = -1;

        try {

            System.out.println("Performing SQL = " + SQLUpdateQuery);
            stmt = conn.createStatement();
            numberRowsAffected = stmt.executeUpdate(SQLUpdateQuery);
        } catch (SQLException se) {
            while (se != null) {
                System.out.println("Message   : " + se.getMessage());
                System.out.println("SQLState  : " + se.getSQLState());
                System.out.println("ErrorCode : " + se.getErrorCode());
                System.out.println("---");
                se = se.getNextException();
            }

        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }

        return numberRowsAffected;
    }

    /**
     * Overriding the finalize method to ensure the database connection is closed when this object goes away.
     */
    public void finalize() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }

}
