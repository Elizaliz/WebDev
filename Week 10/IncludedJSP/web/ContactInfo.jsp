<%-- 
    Document   : ContactSelection
    Created on : Dec 1, 2007, 8:29:01 AM
    Author     : evansrb1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
   <%!
   private int accessCount = 0;
   private Date accessDate = new Date();
   private String accessHost = "<i>No previous access</i>";
   %>

<p>
<hr />
<img src="smallduke.gif">
This page &copy;2007 by Robert Evans. 
This page has been accessed <%= ++accessCount %>
times since the last server reboot.  It was last accessed from 
<%= accessHost %> at <%= accessDate %>.

<% accessHost = request.getRemoteHost(); %>
<% accessDate = new Date(); %>

