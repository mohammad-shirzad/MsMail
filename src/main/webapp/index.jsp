<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>
<body>

<div class="shadowbox">
    <form action="${pageContext.request.contextPath}/ds/logandreg/login" method="post">
        <%--<div class="form-group">--%>
        <label for="user">Email address</label>
        <input type="text" class="form-control" id="user" name="user" aria-describedby="emailHelp"
               placeholder="Enter email"/>
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        <%--</div>--%>
        <%--<div class="form-group">--%>
        <label for="pass">Password</label>
        <input type="password" class="form-control" id="pass" name="pass" placeholder="Password"/>
        <%--</div>--%>
        <div class="form-check">

        </div>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
</div>

<%--<div>--%>
<%--<form  action="${pageContext.request.contextPath}/ds/logandreg/login" method="post">--%>
<%--<label for="user">Username</label><br>--%>
<%--<input  type="text" name="user" id="user" ><br>--%>

<%--<label for="pass">Password</label><span class="question"><a>Forgot password?</a></span><br>--%>
<%--<input  type="password" name="pass" id="pass" ><br>--%>

<%--<button class="button-login" type="submit" >Sign In</button><br>--%>
<%--<span class="question">Not a member?<a href="${pageContext.request.contextPath}/register.jsp">Sign up</a></span>--%>

<%--</form>--%>
<%--</div>--%>

</body>
</html>