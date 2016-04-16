<%-- 
    Document   : login
    Created on : Dec 10, 2007, 8:47:37 PM
    Author     : evansrb1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login JSP Page</title>
        <jsp:useBean id="login" class="com.rbevans.Login" scope="session" />
    </head>
    <body>
        <h2>Welcome to MVC Model 2 demo</h2>
        <% 
        if (login.getName() != null) {
        %>
        Incorrect password, please try again <br />
        <%    
        }
        %>
        <form action="http://localhost:8080/MVC2/Controller" method=GET>
            userid: <input type="TEXT" name="login"> <br />
            password:  <input type="password" name="password"> <br />
            <input type="SUBMIT">
        </form>
    </body>
</html>
