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
    </head>
    <body>
      <h1>Plan your trip!</h1>
      
      <br />

<form action="formServlet" method=GET>
  <input type="RADIO" name="trail" checked value="Gardiner">GARDINER
  <input type="RADIO" name="trail" value="Hellroaring">HELLROARING
  <input type="RADIO" name="trail" value="Beaten">BEATEN
  
  <br />
  <br />
  
  Month <select name="month">
  <option value="1">January</option>
  <option value="2">February</option>
  <option value="3">March</option>
  <option value="4">April</option>
  <option value="5">May</option>
  <option value="6">June</option>
  <option value="7">July</option>
  <option value="8">August</option>
  <option value="9">September</option>
  <option value="10">October</option>
  <option value="11">November</option>
  <option value="12">December</option>
  </select>
  
  Day <select name="day">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
  <option value="6">6</option>
  <option value="7">7</option>
  <option value="8">8</option>
  <option value="9">9</option>
  <option value="10">10</option>
  <option value="11">11</option>
  <option value="12">12</option>
  <option value="13">13</option>
  <option value="14">14</option>
  <option value="15">15</option>
  <option value="16">16</option>
  <option value="17">17</option>
  <option value="18">18</option>
  <option value="19">19</option>
  <option value="20">20</option>
  <option value="21">21</option>
  <option value="22">22</option>
  <option value="23">23</option>
  <option value="24">24</option>
  <option value="25">25</option>
  <option value="26">26</option>
  <option value="27">27</option>
  <option value="28">28</option>
  <option value="29">29</option>
  <option value="30">30</option>
  <option value="31">31</option>
  </select>
  
  Year <select name="year">
  <option value="2015">2015</option>
  <option value="2016">2016</option>
  <option value="2017">2017</option>
  <option value="2018">2018</option>
  <option value="2019">2019</option>
  <option value="2020">2020</option>
  </select>
    
  <br />
  <br />
  
  <%--Month<input type="text" name="month" size="2" maxlength="2" value="03" />
  Day<input type="text" name="day" size="2" maxlength="2" value="07" />
  Year<input type="text" name="year" size="4" maxlength="4" value="2016" />--%>
  
  Duration <select name="duration">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
  <option value="6">6</option>
  <option value="7">7</option>
  </select>
  
  <%--Duration<input type="text" name="duration" size="1" maxlength="1" value="" />--%>
  
  <br />
  <br />
    <input type="SUBMIT">
</form>
    </body>
</html>
