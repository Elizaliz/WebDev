<%-- 
    Document   : index
    Created on : Dec 1, 2007, 8:28:35 AM
    Author     : evansrb1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Included Page</title>
    </head>
    <body>
        <h2>Main content</h2>
        This is a test of the JSP include page directive.  The content below is 
        included from the ContactInfo.jsp file.
        <%@ include file="ContactInfo.jsp" %>
    </body>
</html>
