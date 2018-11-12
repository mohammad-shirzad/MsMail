<%--
  Created by IntelliJ IDEA.
  User: mohammad
  Date: 4/1/2018
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

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
    <f:form id="reg" method="post" action="/ds/logandreg/register" modelAttribute="user-reg">
        <label for="first">FirstName</label>
        <f:input type="text" path="firstName" id="first" class="form-control"/>
        <label for="last">LastName</label>
        <f:input type="text" path="lastName" id="last" class="form-control"/>
        <label for="email">Email</label>
        <f:input type="email" path="email" id="email" class="form-control"/>
        <label for="pass">Password</label>
        <f:input type="password" path="password" id="pass" class="form-control"/>


        <f:button type="submit" class="btn btn-primary" style="margin-top: 10px;">Sign up</f:button>
    </f:form>
    <%--<f:form id="reg" method="post" action="/ds/logandreg/register">--%>
    <%--<label for="first">FirstName</label>--%>
    <%--<f:input type="text" name="first" id="first" class="form-control"/>--%>
    <%--<label for="last">LastName</label>--%>
    <%--<f:input type="text" name="last" id="last" class="form-control"/>--%>
    <%--<label for="email">Email</label>--%>
    <%--<f:input type="email" name="email" id="email" class="form-control"/>--%>
    <%--<label for="pass">Password</label>--%>
    <%--<f:input type="password" name="pass" id="pass" class="form-control"/>--%>


    <%--<f:button type="submit" class="btn btn-primary" style="margin-top: 10px;">Sign up</f:button>--%>
    <%--</f:form>--%>
</div>

</body>
<script>

    // $("#reg").on('submit', function (e) {
    //     e.preventDefault();
    //     var data = $("#reg");
    //     var obj = {
    //         firstName: data[0].elements[0].value,
    //         lastName: data[0].elements[1].value,
    //         email: data[0].elements[2].value,
    //         password: data[0].elements[3].value
    //     };
    //     debugger;
    //     $.ajax({
    //         url: "http://localhost:8080/user/save_user",
    //         method: "post",
    //         data: {user: JSON.stringify(obj)},
    //         headers:{
    //             'Access-Control-Allow-Origin':'*',
    //             'Access-Control-Allow-Methods':'POST',
    //             'Access-Control-Allow-Headers':'X-Requested-With'
    //         },
    //         complete: function (e) {
    //             console.log(e);
    //             debugger;
    //         }
    //     });
    // })
</script>
</html>
