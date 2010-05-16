package edu.drexel.info637.imudb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.drexel.info637.imudb.db.DBObject;
import edu.drexel.info637.imudb.domain.User;
import edu.drexel.info637.imudb.user.LoginResult;

/**
 * This class is responsible for processing a user login request and either redirecting them back to the main page
 * having been authenticated or sending them to an error page a letting them retry
 * @author Patrick Freestone
 */
public class LoginPageServlet extends HttpServlet {

    private static String FAILED_LOGIN_HTML_HEAD = "<html><p>";
    private static String FAILED_LOGIN_HTML_TAIL = "</p><p><a href=\"loginpage.jsp\">Retry Login</a></p><p><a href=\"index.htm\">Home Page</a></p></html>";

    PrintWriter           out                    = null;

    /**
     * Overrides the parent's method and forwards the request to the processRequest method. DLD PseudoCode: { 1. forward
     * request and response objects to processRequest }
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        processRequest(request, response);
    }

    /**
     * Overrides the parent's method and forwards the request to the processRequest method DLD PseudoCode: { 1. forward
     * request and response objects to processRequest }
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        processRequest(request, response);
    }

    /**
     * This method is responsible for processing the user's login by looking up the username-password pair in the
     * database and returning the user to the main page with as a validated user or sending them to an error page and
     * allowing them to log in again. DLD PseudoCode: { 1. set userName from request parameter 2. set password from
     * request parameter 3. if (LoginResult is success) { 4. load User object from LoginResult 5. set session to have
     * user object of the authenticated user 6. forward the request back to the main page } 7. else { 8. write out the
     * login page again with an error message } }
     * @param request request object that should have a "username" and "password" parameter set
     * @param response returned page; either forwarded to the main page or reload the login page with an error
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        LoginResult loginResult = DBObject.getInstance().authenticateUser(userName, password);

        if (loginResult.isSuccess()) {
            HttpSession session = request.getSession(true);
            User loggedInUser = loginResult.getUser();
            session.setAttribute("user", loggedInUser);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.htm");
            try {
                dispatcher.include(request, response);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (ServletException se) {
                se.printStackTrace();
            }
        } else {
            try {
                out = response.getWriter();
                out.print(FAILED_LOGIN_HTML_HEAD);
                out.print(loginResult.getErrorMsg());
                out.print(FAILED_LOGIN_HTML_TAIL);
                out.close();

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

    }

}
