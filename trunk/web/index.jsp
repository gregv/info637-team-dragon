<html>

<h1>HELLO WORLD</h1>
<%
		String url = "/servlet/MainPageServlet";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url); 
        dispatcher.include(request,response); 
%> 

</html>