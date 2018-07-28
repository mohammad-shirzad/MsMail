<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ include file="nav-bar.html" %>
<head>
    <title>Dashboard</title>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <link href="${pageContext.request.contextPath}/css/table" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/pageStyle.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="tab col-lg-4" style="padding-left:0px;padding-right: 0px">
        <button type="button" class="tablink" onclick="compose()">Compose new email</button>
        <button type="button" class="tablink" onclick="getReceivedMessages()">Inbox</button>
        <%--<button type="button" class="tablink" onclick="">Setting</button>--%>
</div>
<div class="col-lg-8">
    <div id="composediv" class="tabcontent">
        <f:form action="/ds/email/sendemail" method="post" modelAttribute="emailDto">
            <table>
                <tr>
                    <td>From:</td>
                    <td><f:input path="from" value="${user.userName}"  readonly="true"/></td>
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
    <div id="inboxdiv" class="tabcontent">
        <table id="inbox" class="table">
        </table><br>
    </div>
</div>

</body>

<script>
    function compose() {
        $("#inboxdiv")[0].style.display = 'none';
        $("#composediv")[0].style.display = 'block';
    }
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
     //                     .attr("value",el.userName).text(el.userName)
     //                 )
     //             });
     //         }
     //     });
     // }

     function getReceivedMessages() {
        $("#composediv")[0].style.display='none';
         // $("#settingdiv")[0].style.display='none';


         $("#inbox tr").remove();
        $.ajax({
            url:'/ds/email/getinbox',
            type:"GET",
            data:{user: "${user.userName}" },
            success:function () {
                console.log("success");
            },
            complete:function (res) {
                debugger;
                var table = JSON.parse(res.responseText);
                if (table.length>0){
                    $("#inbox").append("<tr>" +
                        "<th>From</th>" +
                        "<th>To</th>" +
                        "<th>Title</th>" +
                        "<th>Content</th>" +
                        "<th>Status</th>" +"</tr>");
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

                    // $("#inbox")[0].style.display = 'block';
                    $("#inboxdiv")[0].style.display = 'block';
                }
            }
        });
     }
     // function markAsRead(i) {
     //     debugger;
     //     $.ajax({
     //         url: '/ds/email/changestat',
     //         type: "POST",
     //         data: {id: i},
     //         complete: function (e) {
     //             debugger;
     //             if (e.status === 200) {
     //                 $("table tr i")[0].style.fontWeight = 'normal';
     //             }
     //         }
     //     });
     // }
</script>
</html>