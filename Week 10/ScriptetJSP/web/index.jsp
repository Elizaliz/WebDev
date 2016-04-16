<%-- 
    Document   : index
    Created on : Nov 21, 2007, 9:18:21 PM
    Author     : evansrb1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scriptlet JSP</title>
    </head>
    <%
    String bgColor = request.getParameter("bgColor");
    boolean hasExplicitColor;
    if (bgColor != null) {
        hasExplicitColor = true;
    } else {
        hasExplicitColor = false;
        bgColor = "WHITE";
    }
    %>
    <body bgcolor="<%= bgColor %>">
    <h2>Color Testing</h2>
    <%
     if (hasExplicitColor)   {
        out.write("You requested an explicit color of " + bgColor);
     } else {
        out.write("You did not request an explicit color, so WHITE was used");
     }
     %>
    </body>
</html>
