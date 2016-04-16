<%-- 
    Document   : newjsp
    Created on : Apr 13, 2016, 9:41:28 PM
    Author     : lizsk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script language="javascript" type="text/javascript" src="datetimepicker.js">


        //Date Time Picker script- by TengYong Ng of http://www.rainforestnet.com
        //Script featured on JavaScript Kit (http://www.javascriptkit.com)
        //For this script, visit http://www.javascriptkit.com 
        </script>    
        <%--<jsp:useBean id="startDateSubmitter" class="DatabaseInformation" scope="session" />--%>
        
    </head>
    <body>
        <h1>Hello World! Look at me please.</h1>    
        <!--http://localhost:8080/Module11WebJDBC/Controller-->
            <form action="http://localhost:8080/Module11WebJDBC/Action" method=GET>
                Start Date: (MM-DD-YYYY):  <input id="date" name="date" type="text" size="25">
                    <a href="javascript:NewCal('date','mmddyyyy')">
                    <img src="cal.gif" width="16" height="16" border="0" alt="Pick a date"></a>
                <br />
                <input type="SUBMIT">
            </form>
        
        <%--<jsp:setProperty name="startDateSubmitter" property="details" />--%>
        <%--<jsp:getProperty name="startDateSubmitter" property="details" />--%>
    </body>
</html>
