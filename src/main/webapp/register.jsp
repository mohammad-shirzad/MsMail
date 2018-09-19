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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>
<body>
<div class="shadowbox" style="transform: translateY(20%)">
    <form action="${pageContext.request.contextPath}/ds/logandreg/register" method="post">
        <label for="first">FirstName</label>
        <input type="text" name="first" id="first" class="form-control"/>
        <label for="last">LastName</label>
        <input type="text" name="last" id="last" class="form-control"/>
        <label for="user">UserName</label>
        <input type="text" name="user" id="user" class="form-control"/>
        <label for="pass">Password</label>
        <input type="password" name="pass" id="pass" class="form-control"/>
        <button type="submit" class="btn btn-primary" style="margin-top: 10px;">Sign up</button>
    </form>
</div>

</body>
</html>
