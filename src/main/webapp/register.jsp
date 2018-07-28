<%--
  Created by IntelliJ IDEA.
  User: mohammad
  Date: 4/1/2018
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/main.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<form action="${pageContext.request.contextPath}/ds/logandreg/register" method="post">
    <div style="transform: translateY(20%)">
            <label for="first">FirstName</label>
            <input type="text" name="first" id="first"/>
            <label for="last">LastName</label>
            <input type="text" name="last" id="last"/>
            <label for="user">UserName</label>
            <input type="text" name="user" id="user"/>
            <label for="pass">Password</label>
            <input type="password" name="pass" id="pass"/>
        <button type="submit" class="button-login">Sign up</button>
    </div>
</form>
</body>
</html>
