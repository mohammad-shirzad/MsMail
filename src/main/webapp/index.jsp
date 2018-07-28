<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">

</head>
<body>

<div>
    <form  action="${pageContext.request.contextPath}/ds/logandreg/login" method="post">
        <label for="user">Username</label><br>
        <input  type="text" name="user" id="user" ><br>

        <label for="pass">Password</label><span class="question"><a>Forgot password?</a></span><br>
        <input  type="password" name="pass" id="pass" ><br>

        <button class="button-login" type="submit" >Sign In</button><br>
            <span class="question">Not a member?<a href="${pageContext.request.contextPath}/register.jsp">Sign up</a></span>

    </form>
</div>

</body>
</html>