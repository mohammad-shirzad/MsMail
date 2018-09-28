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
    <form id="reg">
        <label for="first">FirstName</label>
        <input type="text" name="first" id="first" class="form-control"/>
        <label for="last">LastName</label>
        <input type="text" name="last" id="last" class="form-control"/>
        <label for="email">Email</label>
        <input type="email" name="email" id="email" class="form-control"/>
        <label for="pass">Password</label>
        <input type="password" name="pass" id="pass" class="form-control"/>


        <button type="submit" class="btn btn-primary" style="margin-top: 10px;">Sign up</button>
    </form>
</div>

</body>
<script>

    $("#reg").on('submit', function (e) {
        var user = {};
        e.preventDefault();
        var data = $("#reg");
        var user = {
            firstname: data[0].elements[0].value,
            lastname: data[0].elements[1].value,
            email: data[0].elements[2].value,
            password: data[0].elements[3].value
        };
        user = user.stringify();
        debugger;
        $.ajax({
            url: "http://localhost:8080/mailws/user/save_user",
            headers: {"access.control.allow.origin": "*"},
            method: "post",
            data: user,
            complete: function (e) {
                console.log(e);
                debugger;
            }
        });
    })
</script>
</html>
