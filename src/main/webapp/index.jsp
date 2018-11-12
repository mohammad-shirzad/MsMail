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
            method="post" modelAttribute="login">
        <f:label path="email">Username:</f:label>
        <f:input path="email" id="email" cssClass="form-control" aria-describedby="emailHelp"
                 placeholder="Enter email"/>
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>

        <f:label path="password">Password:</f:label>
        <f:input path="password" id="pass" cssClass="form-control" type="password"
                 placeholder="Enter email"/>
        <%--<f:button type="submit" class="btn btn-primary" cssClass="form-control">Login</f:button>--%>
        <div style="margin-top:10px">
            <button type="submit" class="btn btn-primary">Login</button>
                <%--<span class="question">Not a member?<a--%>
                <%--href="${pageContext.request.contextPath}/register.jsp">Sign up</a></span>--%>
            <span class="question">Not a member?<a
                    href="${pageContext.request.contextPath}/ds/logandreg/showReg">Sign up</a></span>

        </div>

    </f:form>
</div>

</body>
</html>