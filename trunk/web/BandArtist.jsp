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
      <p align="center"><font color="#ffffff">Search &nbsp; <select size="1" 
      name=SearchOption><option selected value=Basic>Basic</option> <option 
        value=Advanced>Advanced</option> &lt;\SELECT&gt;</select>&nbsp;&nbsp; 
      <input size="60" name="SearchText">&nbsp; <input value="Search" type="submit" name="startSearch"></font></p></td>
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
      <p align="right"><font color="#ffffff"></font>&nbsp;</p></td></tr></tbody></table></ 
P>
<p>
<table border="2" cellspacing="0" cellpadding="3" width="100%" align="center">
  <tbody>
  <tr>
    <td bordercolor="#515151" width="20%">We will have some ads here</td>
    <td width="60%">
      <table border="0" cellspacing="0" cellpadding="3" width="100%" align="center" 
      height="100%">
        <tbody>
        <tr>
          <td width="25%">picture here</td>
          <td width="75%">Name of the Band here with maybe some album 
          pictures</td></tr>
        <tr>
          <td width="25%"><strong>Biography</strong></td>
          <td width="75%"><strong></strong></td></tr>
        <tr>
          <td width="25%"><strong>Genre</strong></td>
          <td width="75%"><strong></strong></td></tr>
        <tr>
          <td width="25%"><strong>Discography</strong></td>
          <td width="75%"><strong></strong></td></tr>
        <tr>
          <td width="25%"><strong>Songs</strong></td>
          <td width="75%"><strong></strong></td></tr>
        <tr>
          <td width="25%"><strong>Charts and Awards</strong></td>
          <td width="75%"><strong></strong></td></tr>
        <tr>
          <td width="25%"><strong>Credits</strong></td>
          <td width="75%"><strong></strong></td></tr>
        <tr>
          <td width="25%"><strong>Trivia</strong></td>
          <td width="75%"><strong></strong></td></tr>
        <tr>
          <td width="25%"><strong>External Links</strong></td>
          <td width="75%">
            <p>&nbsp;</p></td></tr></tbody></table></ TD>
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
