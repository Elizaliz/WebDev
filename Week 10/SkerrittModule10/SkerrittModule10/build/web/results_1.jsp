<%-- 
    Document   : menu
    Created on : Dec 10, 2007, 8:48:11 PM
    Author     : evansrb1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Failed to reserve your trail :( </title>
    </head>
    <body>
        <h1>Something didn't work... </h1>
        <h2><jsp:getProperty name="trailz" property="details" /> </h2>
        <p>click <a href="SignUp.jsp">here</a> to go to try again.</p>
    </body>
</html>
