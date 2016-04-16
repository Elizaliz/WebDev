<%-- 
    Document   : index
    Created on : Nov 27, 2007, 8:36:15 PM
    Author     : evansrb1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.Date" %>
<%@ page import="com.rbevans.SuperMath" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Import Page</title>
    </head>
    <body>
        <h2>Todays date is <%= new Date() %></h2>
        <h2>5 * 4 = <%= SuperMath.multiply(5.0, 4.0) %></h2>
    </body>
</html>
