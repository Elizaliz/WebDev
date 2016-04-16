<%-- 
    Document   : index
    Created on : Nov 21, 2007, 9:18:21 PM
    Author     : evansrb1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%! String bgColor="WHITE"; %>
<%! boolean hasExplicitColor = false; %>
<%! int accessCount = 0; %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Declaration JSP</title>
    </head>
    <%
    accessCount++;

    bgColor = request.getParameter("bgColor");
    if (bgColor != null) {
        hasExplicitColor = true;
    }
    %>
    <body bgcolor="<%= bgColor %>">
    <h2>Color Testing</h2>
    <%
     if (hasExplicitColor)   {
        out.write("You requested an explicit color of " + bgColor);
     } else {
        out.write("You did not request an explicit color, so WHITE was used\n");
     }
     out.write("<br>");
     out.write("You have visited this page " + 
             accessCount + 
             " times since the last server reboot");
     %>
    </body>
</html>
