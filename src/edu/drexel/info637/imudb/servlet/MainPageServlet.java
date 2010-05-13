package edu.drexel.info637.imudb.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MainPageServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
  PrintWriter out = response.getWriter();
  out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
              "Transitional//EN\">\n" +
              "<html>\n" +
              "<head><title>This is from MainPageServlet - Hello WWW</title></head>\n" +
              "<body>\n" +
              "<h1>This is from MainPageServlet - Hello WWW</h1>\n" +
              "<img src=\"http://www.mushon.com/spr09/nmrs/wp-content/uploads/2009/04/imdb-logo.jpg\" />" +
              "</body></html>");
}
	
}
