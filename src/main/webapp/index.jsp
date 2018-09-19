<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

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
    <f:form action="${pageContext.request.contextPath}/ds/logandreg/login"
            method="post" modelAttribute="loginform">
        <f:label path="userName">Username:</f:label>
        <f:input path="userName" id="user" cssClass="form-control" aria-describedby="emailHelp"
                 placeholder="Enter email"/>
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>

        <f:label path="password">Password:</f:label>
        <f:input path="password" id="pass" cssClass="form-control" type="password"
                 placeholder="Enter email"/>
        <%--<f:button type="submit" class="btn btn-primary" cssClass="form-control">Login</f:button>--%>
        <div style="margin-top:10px">
            <button type="submit" class="btn btn-primary">Login</button>
            <span class="question">Not a member?<a
                    href="${pageContext.request.contextPath}/register.jsp">Sign up</a></span>

        </div>

    </f:form>
    <%--<form action="${pageContext.request.contextPath}/ds/logandreg/login" method="post">--%>
    <%--&lt;%&ndash;<div class="form-group">&ndash;%&gt;--%>
    <%--<label for="user">Email address</label>--%>
    <%--<input type="text" class="form-control" id="user" name="user" aria-describedby="emailHelp"--%>
    <%--placeholder="Enter email"/>--%>
    <%--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div class="form-group">&ndash;%&gt;--%>
    <%--<label for="pass">Password</label>--%>
    <%--<input type="password" class="form-control" id="pass" name="pass" placeholder="Password"/>--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--<div class="form-check">--%>

        <%--</div>--%>
    <%--<button type="submit" class="btn btn-primary">Login</button>--%>
    <%--</form>--%>
</div>

<%--<div>--%>
<%--<form  action="${pageContext.request.contextPath}/ds/logandreg/login" method="post">--%>
<%--<label for="user">Username</label><br>--%>
<%--<input  type="text" name="user" id="user" ><br>--%>

<%--<label for="pass">Password</label><span class="question"><a>Forgot password?</a></span><br>--%>
<%--<input  type="password" name="pass" id="pass" ><br>--%>

<%--<button class="button-login" type="submit" >Sign In</button><br>--%>

<%--</form>--%>
<%--</div>--%>

</body>
</html>