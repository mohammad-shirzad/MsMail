<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<head>

    <link href="${pageContext.request.contextPath}/css/pageStyle.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container row">
    <div class="col-lg-6">
        <h4>welcome dear ${user.firstName} ${user.lastName}</h4>
    </div>
    <div class="col-lg-6">
        <p style="float: right;"><a href="/ds/logandreg/logout">Sign out</a></p>
    </div>
</div>
<div class="container row">
    <div class="col-lg-3">
        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item">
                <a class="nav-link active" data-toggle="tab" href="#inboxsec" role="tab" aria-controls="inboxsec"
                   onclick="getReceivedMessages()">Inbox</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#compose" role="tab" aria-controls="compose"
                   onclick="compose()">Compose new email</a>
            </li>
        </ul>
    </div>
    <div class="tab-content col-lg-9">
        <div class="tab-pane active" id="inboxsec" role="tabpanel">
            <table id="inbox" class="table table-sm">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">From</th>
                    <th scope="col">To</th>
                    <th scope="col">Title</th>
                    <th scope="col">Content</th>
                    <th scope="col">Status</th>
                </tr>
                </thead>
            </table>
        </div>
        <div class="tab-pane" id="compose" role="tabpanel">
            <f:form action="/ds/email/sendemail" method="post" modelAttribute="emailDto">
                <table>
                    <tr>
                        <td>From:</td>
                        <td><f:input path="from" value="${user.email}" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td>To:</td>
                        <td><f:select path="to">
                            <f:options items="${users}"/>
                        </f:select></td>
                    </tr>
                    <tr>
                        <td>Title:</td>
                        <td><f:input path="title"/></td>
                    </tr>
                    <tr>
                        <td>Content:</td>
                        <td><f:textarea path="content" rows="4" cols="50"/></td>
                    </tr>

                </table>
                <f:button type="submit">Send</f:button>
            </f:form>

        </div>

    </div>
</div>


</body>

<script>

    $(document).ready(function () {
        debugger;
        getReceivedMessages();
    });
    function checkSessionValidity() {
        $.ajax({
            url:'/ds/logandreg/checksession',
            success:function (res) {
                debugger;
                return res;
            }
        });
    }


    //This function is designed for populating dropdown list using ajax and jquery.
    // call it from within $(document).ready(function ()) mentioned above
     // function getAccounts() {
     //     debugger;
     //     $.ajax({
     //         url:'/ds/logandreg/getusers',
     //         type:'GET',
     //         success:function () {console.log("onsuccess");},
     //         complete:function (res) {
     //             debugger;
     //             var list = JSON.parse(res.responseText);
     //
     //
     //             $.each(list,function (index,el) {
     //                 debugger;
     //                 $("#dropdown").append($("<option></option>")
    //                     .attr("value",el.email).text(el.email)
     //                 )
     //             });
     //         }
     //     });
     // }

     function getReceivedMessages() {

         $("#inbox tbody").remove();
        $.ajax({
            url:'/ds/email/getinbox',
            type:"GET",
            data: {user: "${user.email}"},
            success:function () {
                console.log("success");
            },
            complete:function (res) {
                debugger;
                var table = JSON.parse(res.responseText);
                if (table.length>0){
                    $("#inbox").append("<tbody>");
                    for(var i=0;i<table.length;i++)
                    {

                        var id = table[i]["id"];
                        var tr="<tr class='makenormal'>";
                        var td1="<td>"+table[i]["from"]+"</td>";
                        var td2="<td>"+table[i]["to"]+"</td>";
                        var td3="<td>"+table[i]["title"]+"</td>";
                        var td4="<td>"+table[i]["content"]+"</td>";
                        var td5="<td><button type='button' onclick='markAsRead("+id+")'>"+"mark as read"+"</td></tr>";
                        if (table[i]["read"] === false){
                            $("table tr")[0].style.fontWeight='normal';
                        }else {$("table tr")[0].style.fontWeight='normal';}
                        $("#inbox").append(tr+td1+td2+td3+td4+td5);
                    }
                    $("#inbox").append("</tbody>");
                }
            }
        });
     }
</script>
</html>