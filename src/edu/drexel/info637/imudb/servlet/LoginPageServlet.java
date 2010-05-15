package edu.drexel.info637.imudb.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class is responsible for processing a user login request and either redirecting them back to the main page
 * having been authenticated or sending them to an error page a letting them retry
 * @author Patrick Freestone
 */
public class LoginPageServlet extends HttpServlet {

    /**
     * Overrides the parent's method and forwards the request to the processRequest method. 
     * DLD PseudoCode:
     * {
     *      1. forward request and response objects to processRequest
     * }
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    /**
     * Overrides the parent's method and forwards the request to the processRequest method
     * DLD PseudoCode:
     * {
     *      1. forward request and response objects to processRequest
     * }
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    /**
     * This method is responsible for processing the user's login by looking up the username-password pair in the
     * database and returning the user to the main page with as a validated user or sending them to an error page and
     * allowing them to log in again. DLD PseudoCode: 
     * {
     *      1. set userName from request parameter
     *      2. set password from request parameter
     *      3. load User object from database using username
     *      4. if (password from request == password from database) {
     *          5. set session to have user object of the authenticated user
     *          6. forward the request back to the main page
     *      } 7. else {
     *          8. write out the login page again with an error message
     *      }
     *  }
     * @param request   request object that should have a "username" and "password" parameter set
     * @param response  returned page; either forwarded to the main page or reload the login page with an error
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {

    }

}
