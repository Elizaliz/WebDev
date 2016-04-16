<%-- 
    Document   : index
    Created on : Dec 9, 2007, 8:37:14 AM
    Author     : evansrb1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
   

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:useBean id="contextCounter" class="com.rbevans.Counter" scope="application" />
        <jsp:useBean id="sessionCounter" class="com.rbevans.Counter" scope="session" />
        <jsp:useBean id="requestCounter" class="com.rbevans.Counter" scope="request" />
        <jsp:setProperty name="contextCounter" property="incrementNumTimesVisited" value="1" />
        <jsp:scriptlet>sessionCounter.setNumTimesVisited(sessionCounter.getNumTimesVisited() + 1);</jsp:scriptlet>
        <jsp:setProperty name="requestCounter" property="incrementNumTimesVisited" value="1" />        
    </head>
    <body>
        <h2>JSP's and Bean scope</h2>
        Number of times a page has been visited in this webapp since reboot; <jsp:getProperty name="contextCounter" property="numTimesVisited" /><br />
        Number of times a page has been visited in this session: <jsp:getProperty name="sessionCounter" property="numTimesVisited" /><br />        
        Number of times a page has been visited in this request: <jsp:getProperty name="requestCounter" property="numTimesVisited" /><br />        
        <p>click <a href="page2.jsp">here</a> to go to the next page.</p>
    </body>
</html>
