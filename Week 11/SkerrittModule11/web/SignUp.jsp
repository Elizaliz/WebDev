<%-- 
    Document   : SignUp
    Created on : 4/5/16
    Author     : eskerri1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up JSP Page</title>
        
        <script language="javascript" type="text/javascript" src="datetimepicker.js">

        //Date Time Picker script- by TengYong Ng of http://www.rainforestnet.com
        //Script featured on JavaScript Kit (http://www.javascriptkit.com)
        //For this script, visit http://www.javascriptkit.com 

        </script

        <script type="text/javascript" src="myjavascript.js"></script>
        
        <jsp:useBean id="trailz" class="com.rbevans.SignUp" scope="session" />
    </head>
    <body>
        <h1>Display all reservations After the following date:</h1>

        <br />

        <form action="http://localhost:8080/SkerrittModule11/Controller" method=GET>

            <img src="TrailGardiner.jpg" height='200px' name="trail" id="trail">
<!--            <input type="RADIO" name="trail" checked value="Gardiner" onClick="changeImage(1)">GARDINER
            <br />          
            <img src="hellroaringTrail.jpg" height='200px' name="trail" id="trail">               
            <input type="RADIO" name="trail" value="Hellroaring" onClick="changeImage(2)">HELLROARING
            <br />           
            <img src="beautiful-stone-creek-in-the-forest.jpg" height='200px' name="trail" id="trail">
            <input type="RADIO" name="trail" value="Beaten" onClick="changeImage(3)">BEATEN-->
<!--            <br />
            Duration (days):  <input type="number" name="duration"> -->
            <br />
            Start Date: (MM-DD-YYYY):  <input id="date" name="date" type="text" size="25">
                <a href="javascript:NewCal('date','mmddyyyy')">
                <img src="cal.gif" width="16" height="16" border="0" alt="Pick a date"></a>
            <br />
            <input type="SUBMIT">
        </form>
    </body>
</html>
