package edu.drexel.info637.imudb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.drexel.info637.imudb.db.DBObject;
import edu.drexel.info637.imudb.user.AccessType;

public class MainPageServlet extends HttpServlet {

    private String     template;
    private AccessType accessLevel; // TODO Change String to AccessType
    private long       id;
    private String     username;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n" + "<html>\n" + "<head><title>This is from MainPageServlet - Hello WWW</title></head>\n" + "<body>\n"
                + "<h1>This is from MainPageServlet - Hello WWW</h1>\n" + "<img src=\"http://www.mushon.com/spr09/nmrs/wp-content/uploads/2009/04/imdb-logo.jpg\" />" + "</body></html>");

        DBObject dbo = new DBObject();

        ArrayList<ArrayList<Object>> data = dbo.getInstance().requestSQLExecution("SELECT * from User");

        System.out.println(data.toString());

        for (ArrayList<Object> o : data) {
            Integer userId = (Integer)o.get(1);
            String username = (String)o.get(2);
            System.out.println(userId + " " + username);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

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
