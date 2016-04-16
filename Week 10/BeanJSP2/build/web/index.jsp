<%-- 
    Document   : index
    Created on : Dec 1, 2007, 8:29:17 PM
    Author     : evansrb1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beans example page</title>
<style type="text/css"> 
<!-- body  {
	font: 100% Verdana, Arial, Helvetica, sans-serif;
	background: #666666;
	margin: 0; /* it's good practice to zero the margin and padding of the body element to account for differing browser defaults */
	padding: 0;
	text-align: center; /* this centers the container in IE 5* browsers. The text is then set to the left aligned default in the #container selector */
	color: #000000;
}
.beanJSP #label {
	text-align: right; /* this centers the container in IE 5* browsers. The text is then set to the left aligned default in the #container selector */
        line-height: 140%;
}
.beanJSP #container { 
	width: 500px;  /* using 20px less than a full 800px width allows for browser chrome and avoids a horizontal scroll bar */
	background: #FFFFFF;
	margin: 0 auto; /* the auto margins (in conjunction with a width) center the page */
	border: 1px solid #000000;
	text-align: center; /* this overrides the text-align: center on the body element. */
        padding: 10px 10px 10px 10px;        
}
.beanJSP #sidebar1 {
	float: left; /* since this element is floated, a width must be given */
	width: 200px; /* the actual width of this div, in standards-compliant browsers, or standards mode in Internet Explorer will include the padding and border in addition to the width */
	background: #FFFFFF; /* the background color will be displayed for the length of the content in the column, but no further */
	text-align: right; /* this centers the container in IE 5* browsers. The text is then set to the left aligned default in the #container selector */
        padding: 10px 5px 10px 10px;
}
.beanJSP #mainContent { 
	margin: 0 0 0 150px; /* the left margin on this div element creates the column down the left side of the page - no matter how much content the sidebar1 div contains, the column space will remain. You can remove this margin if you want the #mainContent div's text to fill the #sidebar1 space when the content in #sidebar1 ends. */
	padding: 10px 10px 10px 10px; /* remember that padding is the space inside the div box and margin is the space outside the div box */
	text-align: left; /* this centers the container in IE 5* browsers. The text is then set to the left aligned default in the #container selector */
        background: #FFFFFF; /* the background color will be displayed for the length of the content in the column, but no further */
} 
.clearfloat { /* this class should be placed on a div or break element and should be the final element before the close of a container that should fully contain a float */
	clear:both;
    height:0;
    font-size: 1px;
    line-height: 0px;
}
--> 
</style>        
    </head>
    <body class="beanJSP">
        <h2>Loading beans from form values</h2>

        <form action="submit.jsp" method=GET>
            <div id="container">
        Pleast enter your address:             
                <div id="sidebar1">
            <span id="label"> Street:</span><br />
            <span id="label"> City:</span><br />
            <span id="label"> State:</span><br />
            <span id="label"> Zip:</span><br />            
        </div>
        <div id="mainContent">
            <input type="TEXT" name="street"> <br />
            <input type="TEXT" name="city"> <br />
            <input type="TEXT" name="state"> <br />            
            <input type="TEXT" name="zip"> <br />     
        </div>
        </div>
        <br />
            <input type="SUBMIT">            
        </form>
    </body>
</html>
