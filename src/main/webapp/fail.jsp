<%--
  Created by IntelliJ IDEA.
  User: Ramon
  Date: 7/27/2021
  Time: 12:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="padding: 30px; margin: 50px; color: red">
    <h2>Welcome: <%=request.getAttribute("username")%> is incorrect.</h2>
    <a href="/">Click here to try again.</a>
</body>
</html>
