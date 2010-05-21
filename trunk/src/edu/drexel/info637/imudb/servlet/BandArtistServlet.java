package edu.drexel.info637.imudb.servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.drexel.info637.imudb.db.DBObject;
import edu.drexel.info637.imudb.domain.*;
import edu.drexel.info637.imudb.search.BasicSearch;
import edu.drexel.info637.imudb.search.SearchResults;
import edu.drexel.info637.imudb.user.AccessType;

public class BandArtistServlet extends HttpServlet {

    private static final long serialVersionUID = -2084800063362700673L;
    private String            template;
    private AccessType        accessLevel;
    private long              id;
    private String            username;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    /**
     * DLD Pseudo code
     * This class will be called from MainPageServlet and will show details about the Band or Artist selected
     * The name of the band/artist will be passed in the from of a servlet parameter
     * 1. get servlet parameter BandID
     * 2. Retrieve the record for BandID = xxxxx (int)
     * 3. display top part of the page (read template page Top
     * 4. read record from Band table
     * 5. Fill in "Biography", "External Links", "Genre" (by looking up in Genre Table).
     * 6. Lookup albums by the BandID
     * 7. Lookup songs by Band Name
     * 8. Lookup Trivia by BandID
     * 9. Display Infomation
     * if BandID=null or No Record
     * 10. print error message
     */
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        String sBandID = request.getParameter("BandID");
        int iBandID = Integer.parseInt(sBandID);
        System.out.println("bandID="+iBandID);

        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
                
        String sContextPath = request.getRealPath("");
        System.out.println("----"+sContextPath);
        // Read the top part of the page
        BufferedReader bFReader = new BufferedReader(new FileReader(sContextPath+"/PageTemplates/BandArtistTop.txt"));
        String sLine;
        while((sLine = bFReader.readLine()) != null){ // read lines
            //System.out.println(sLine.trim());
            out.println(sLine.trim()); // print lines
        }
        
        ArrayList<Band> result = DBObject.getInstance().searchBandID(iBandID);        
        if(result.size() > 0){
            for(Band b : result){
                StringTokenizer tok = new StringTokenizer(b.getName().toLowerCase()," ");
                String sTmp="";
                while(tok.hasMoreTokens()){
                    sTmp=sTmp+tok.nextToken().toLowerCase().trim();
                }
                out.println("<td width=\"25%\" valign=\"top\"><img src=\""+sContextPath+"/images/"+sTmp+".jpg\" alt=\""+b.getName()+"\" /></td>");
                out.println("<td width=\"75%\" align=\"center\"><h2><i>"+b.getName()+"</i></h2></td></tr><tr>");
                out.println("<td width=\"25%\" valign=\"top\"><strong>Biography</strong></td>");
                out.println("<td width=\"75%\">"+b.getDescription()+"</td></tr><tr>");
                out.println("<td width=\"25%\" valign=\"top\"><strong>Genre</strong></td>");
                ArrayList<Genre> gResults = DBObject.getInstance().getGenreName(b.getGenreID());
                for(Genre g : gResults){
                    out.println("<td width=\"75%\"><b><i>"+g.getGenreName()+"</i></b></td></tr><tr>");
                }
                //out.println("<td width=\"75%\">"+b.getGenreID()+"</td></tr><tr>");
                out.println("<td width=\"25%\" valign=\"top\"><strong>Discography</strong></td><td width=\"75%\">");
                ArrayList<Album> aResults = DBObject.getInstance().getBandAlbumContribution(b.getBandID());
                for(Album a : aResults){
                    out.println("<b><i>"+a.getAlbumName()+"</i></b>" +
                            " - Released on "+a.getReleaseDate().toString()+" by "+a.getRecordLabel()+"" +
                            ", produced by "+a.getProducer()+"</br>");
                }
                //out.println("<td width=\"75%\"><strong></strong></td></tr><tr>");
                out.println("</td></tr><tr><td width=\"25%\" valign=\"top\"><strong>Songs</strong></td><td width=\"75%\">");
                ArrayList<Song> songResults = DBObject.getInstance().getAlbumSongs(aResults);
                for(Song sng : songResults){
                    out.println("<b><i><u>"+sng.getSongName()+"</u></i></b> - Album: <b><i>"+sng.getAlbumName()+"</i></b> - Author: "+sng.getSongAuthor()+" - " +
                            " <b><i>"+sng.getBand()+"</i></b></br>");
                }
                //out.println("<td width=\"75%\"><strong></strong></td></tr><tr>");
                out.println("</td></tr><tr><td width=\"25%\" valign=\"top\"><strong>Charts and Awards</strong></td>");
                out.println("<td width=\"75%\"><strong></strong></td></tr><tr>");
                out.println("<td width=\"25%\" valign=\"top\"><strong>Credits</strong></td>");
                out.println("<td width=\"75%\"><strong></strong></td></tr><tr>");
                out.println("<td width=\"25%\" valign=\"top\"><strong>Trivia</strong></td>");
                out.println("<td width=\"75%\"><strong></strong></td></tr><tr>");
                out.println("<td width=\"25%\" valign=\"top\"><strong>External Links</strong></td>");
                out.println("<td width=\"75%\"><a href='"+b.getExternalWebsite()+"'>"+b.getExternalWebsite()+"</a></td></tr>");
                out.println("<tr><td colspan=\"2\" bgcolor=\"LIGHTGREY\" align=\"center\"><hr><a href=\"#TOC\" onClick=\"showUserComments();\">View Comments</a>       |     " +
                        "  <a href=\"#TOC\" onClick=\"showComment();\">Add your comment</a></br></td></tr>");
                out.println("<tr><td colspan=\"2\" bgcolor=\"LIGHTGREY\" align=\"left\" id=\"row1\"><hr><i>Your Comment:</i></br>" +
                        "<textarea name=\"txtarea\" cols=\"100%\" rows=\"3\" disabled/>This functionality is not available just yet...</textarea></td></tr>" +
                        "<tr><td colspan=\"2\" bgcolor=\"LIGHTGREY\" align=\"right\" id=\"row2\"><input type=\"button\" value=\"Comment\" disabled/></td></tr>");
                out.println("<tr><td colspan=\"2\" bgcolor=\"LIGHTGREY\" align=\"left\" id=\"row3\">");
                ArrayList<Comment> comments = DBObject.getInstance().getUserComments(iBandID);
                for(Comment cmm : comments){
                    out.println("<hr><i>"+cmm.getSComment()+"</i></br>"+cmm.getDAdded().toString()+"</br>");
                }
                out.println("</td></tr>");
                out.println("</tbody></table></ TD><td bordercolor=\"#515151\" width=\"20%\">We will have some more ads here</td></tr>");
            }            
        }
        //<td width="25%">picture here</td>
        //<td width="75%">Name of the Band here with maybe some album pictures</td></tr><tr>
       // <td width="25%"><strong>Biography</strong></td>
        //<td width="75%"><strong></strong></td></tr><tr>
       // <td width="25%"><strong>Genre</strong></td>
       // <td width="75%"><strong></strong></td></tr><tr>
       // <td width="25%"><strong>Discography</strong></td>
       // <td width="75%"><strong></strong></td></tr><tr>
       // <td width="25%"><strong>Songs</strong></td>
       // <td width="75%"><strong></strong></td></tr><tr>
       // <td width="25%"><strong>Charts and Awards</strong></td>
        //<td width="75%"><strong></strong></td></tr><tr>
        //<td width="25%"><strong>Credits</strong></td>
        //<td width="75%"><strong></strong></td></tr><tr>
       // <td width="25%"><strong>Trivia</strong></td>
        //<td width="75%"><strong></strong></td></tr><tr>
        //<td width="25%"><strong>External Links</strong></td>
        //<td width="75%">
         // <p>&nbsp;</p></td></tr></tbody></table></ TD>
  //<td bordercolor="#515151" width="20%">We will have some more ads here</td></tr>
        
        
        
        // print the bottom of the page
        out.println(" <tr><td bgcolor=\"#515151\"></td><td bgcolor=\"#515151\">" +
                "<p align=\"center\"><font style=\"BACKGROUND-COLOR: #515151\"" +
                " color=#ffffff>About Us | Our Contributors | Contact Us | Privacy Policy |  Terms of Use | Help</font></p></td>" +
                " <td bgcolor=\"#515151\"></td></tr></tbody></table></p></body></html>");
        }
        catch(Exception ee){
            ee.printStackTrace();
        }
    }
}
