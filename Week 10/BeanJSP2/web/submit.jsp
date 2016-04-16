<%-- 
    Document   : submit
    Created on : Dec 2, 2007, 12:09:58 PM
    Author     : evansrb1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="address" class="com.rbevans.Address" />
<jsp:setProperty name="address" property="*" />
     
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bean JSP2: Thanks!</title>
    </head>
    <body>
        <h2>Bean JSP2: Thanks, you entered...</h2>
        Address: <jsp:getProperty name="address" property="street" /> <br />
        City: <jsp:getProperty name="address" property="city" /> <br />
        State: <jsp:getProperty name="address" property="state" /> <br />
        Zip: <jsp:getProperty name="address" property="zip" /> <br />
    </body>
</html>
