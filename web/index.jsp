<%@ page import="edu.drexel.info637.imudb.domain.User"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html><head><title>iMuDb - The Internet Music Database</title>
<meta name="GENERATOR" content="MSHTML 8.00.6001.18904">
<meta content="text/html; charset=ISO-8859-1" http-equiv="Content-Type">

</head>
<body bgcolor="#ffffff">
<p>&nbsp;</p>
<p>
<table border="0" cellspacing="0" cellpadding="3" width="100%" bgcolor="#515151" 
align=center>
  <tbody>
  <tr>
    <td>
      <p align="left"><img border="0" hspace="0" src="images/iMuDbLogo.jpg" width="184" 
      height=90></p></td>
    <td>
      <p align="center">
      <form name="searchForm" method="POST" action="MainPageServlet">
      <font color="#ffffff">Search &nbsp; 
	      <select size="1" name=SearchOption>
		      <option selected value=Basic>Basic</option> 
		      <option value=Advanced>Advanced</option> 
		      &lt;\SELECT&gt;
	      </select>
	      &nbsp;&nbsp; 
	      <input size="60" name="SearchText">&nbsp; 
	      <input value="Search" type="submit" name="startSearch">
      </font>
      </form>
      </p>
  	</td>
    <td valign="center" v>
      <p align="right"><font color="#ffffff"><font color="#ffffff"></font><font 
      color=#ffffff></font><font color="#ffffff"></font><font 
      color=#ffffff></font>Register | 
<% 
	session = request.getSession();
    User currentUser = (User)session.getAttribute("user");
    if (currentUser == null) {  
%>            
      <a href="loginpage.jsp">Login</a> 
<% 	} else {
		String userName = currentUser.getUserName();	
%>
	<%= userName %> logged in
<% } %>

      | Help</font></p>
      <p align="right"><font color="#ffffff"></font>&nbsp;</p></td></tr></tbody></table></P>
<p>
<table border="2" cellspacing="0" cellpadding="3" width="100%" align="center">
  <tbody>
  <tr>
    <td bordercolor="#515151" width="20%">We will have some ads here</td>
    <td width="60%">
      <table border="0" cellspacing="0" cellpadding="3" width="100%" align="center">
        <tbody>
        <tr>
          <td valign="top" width="50%">
            <p align="center"><strong><em><font color="#0000ff">Internet Music 
            Database is now operational!</font></em></strong></p>
            <hr>

            <p align="left">iMuDb has been officially launched and we are looking 
            for your help! We need you to tell us what you think about the site 
            and the services it provides. We would also appreciate you sharing 
            your musical passion with us and the site visitors by becomming a 
            member or better yet, a contributor! The more members we get, the 
            faster we can expand our knowledge base!</p></td>
          <td valign="top">
            <p><font color="#0000ff"><strong><em>What is coming up 
            next?</em></strong></font></p>
            <p>
            <hr>

            <p></p>
            <p>What can you expect to see on this site in the future?</p>
            <ul>
              <li>More information about your favourite musicians 
              <li>Event updates 
              <li>Ability to rate your favourite artists 
              <li>Ability to share your thoughts/comments with other site 
              members 
              <li>Personalized Event Notifications</li></ul></td></tr></tbody></table>
    <td bordercolor="#515151" width="20%">We will have some more ads here</td></tr>
  <tr>
    <td bgcolor="#515151"></td>
    <td bgcolor="#515151">
      <p align="center"><font style="BACKGROUND-COLOR: #515151" 
      color=#ffffff>About Us | Our Contributors | Contact Us | Privacy Policy | 
      Terms of Use | Help</font></p></td>
    <td bgcolor="#515151"></td></tr></tbody></table></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p align="center"><font size="1">This Web Page Created with PageBreeze </font><a 
href="http://www.pagebreeze.com" target=_blank><font size="1">Free HTML 
Editor</font></a></p></body></html>