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
        <title>Successful booking!</title>
    </head>
    <body>
        <h1>You have successfully booked your trip!</h1>
        <h1>Here are your details:</h1>
        <img src="footprint-trail.jpg" height='100px' name="trail" id="trail">
        <h2><jsp:getProperty name="trailz" property="trail" /> Trail </h2>
        <h2>Begin Date: <jsp:getProperty name="trailz" property="month" />/<jsp:getProperty name="trailz" property="day" />/<jsp:getProperty name="trailz" property="year" />  </h2>                   
        <h2>Total Duration: <jsp:getProperty name="trailz" property="duration" /> night(s) </h2>        
        <p>Normal Nights: <jsp:getProperty name="trailz" property="normalDays" /> night(s), 
        Premium Nights: <jsp:getProperty name="trailz" property="premiumDays" /> night(s) </p>               
        <p>Normal Daily Rate: $<jsp:getProperty name="trailz" property="normalDayRate" /> per night, 
        Premium Daily Rate: $<jsp:getProperty name="trailz" property="premiumDayRate" /> per night </p>               
        <h1>Total Price: $<jsp:getProperty name="trailz" property="cost" /> </h1>

        <p>click <a href="SignUp.jsp">here</a> if you want to book another trip.</p>
    </body>
</html>
