<%-- 
    Document   : index
    Created on : Mar 6, 2016, 9:36:02 PM
    Author     : lizsk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width">

        <title>Welcome</title>
               
        <script language="javascript" type="text/javascript" src="datetimepicker.js">

        //Date Time Picker script- by TengYong Ng of http://www.rainforestnet.com
        //Script featured on JavaScript Kit (http://www.javascriptkit.com)
        //For this script, visit http://www.javascriptkit.com 

        </script>
        
        <script type="text/javascript" src="myjavascript.js"></script>

    </head>
    <body>
      <h1>Plan your trip!</h1>
      
<br />

<img src="TrailGardiner.jpg" height='200px' name="trail" id="trail">
<form action="formServlet" method=GET>
  <input type="RADIO" name="trail" checked value="Gardiner" onClick="changeImage(1)">GARDINER
  <input type="RADIO" name="trail" value="Hellroaring" onClick="changeImage(2)">HELLROARING
  <input type="RADIO" name="trail" value="Beaten" onClick="changeImage(3)">BEATEN
  
  <br />
  <br />

  Date
  <input id="calendar1" name="myCalendar" type="text" size="25">
    <a href="javascript:NewCal('calendar1','mmddyyyy')">
    <img src="cal.gif" width="16" height="16" border="0" alt="Pick a date"></a>
  
  <br />
  <br />

  Duration <select name="myDuration" id="myDuration">
  <option value="3">3</option>
  <option value="5">5</option>
  </select>
  
  Hikers <select name="people">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
  <option value="6">6</option>
  <option value="7">7</option>
  <option value="5">8</option>
  <option value="6">9</option>
  <option value="7">10</option>
  </select>
  
  <br />
  <br />
    <input type="SUBMIT">
</form>
    </body>
</html>
