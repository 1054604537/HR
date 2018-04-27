<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/27
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
    <style>
        #d1{
            background-color: pink;
            border: 1px solid black;
            width: 200px;
            height: 200px;
            position: absolute;
            left: 200px;
        }
        #d2{
            width: 150px;
            height: 50px;
            display: inline;
        }
        #d3{
            width: 50px;
            height: 50px;
            display: inline;
        }
        #d4{
            width: 143px;
            height: 150px;
            background-color: palegoldenrod;
            display: none;
        }
    </style>
    <script type="text/javascript" src="js/jquery-3.1.0.js"></script>
    <script>
        <%--var deparmentId=$("#department").attr("value");--%>
        <%--$.ajax({--%>
            <%--url:"${pageContext.request.contextPath}/student/findClass",--%>
            <%--type:"get",--%>
            <%--timeout:"1000",--%>
            <%--data:{departmentId:deparmentId},--%>
            <%--success:function (date) {--%>
                <%--$("classId option").remove();--%>
                <%--$("classId").append("<option value='0'>请选择</option>");--%>
                <%--if (date!=0){--%>
                    <%--for (var i=0;i<date.length;i++){--%>
                        <%--var classId=deta[i].classId;--%>
                        <%--var calssName=data[i].className;--%>
                        <%--$("#classId").append("<option value="+classId+">"+calssName+"</option>")--%>
                    <%--}--%>
                <%--}--%>
            <%--},--%>
            <%--error:function (XMLResponse) {--%>
                <%--alert(XMLResponse.responseText);--%>
            <%--}--%>


        <%--});--%>
        $(function () {
           $("#info").focus(function () {
               $("#d4").css("display","block");
           }) ;
           $("#info").blur(function () {
               $("#d4").css("display","block");
           });
           $("#info").keyup(function () {
               $.ajax({
                   type:"post",
                   url:"search",
                   date:{"info":$("#info").val()},
                   success:function (obj) {
                       $("#d4").empty();
                       for(var i=0;i<obj.length;i++){
                           var a=$("<a href='#'></a><br/>");
                           a.html(obj[i].info);
                           $("#d4").append(a);
                       }
                   },
                   error:function () {
                       alert("error")
                   }
               })
           })
        });

    </script>
</head>
<body>



<select id="department" name="departmentId" onchange="findClass()">
    <option value="0">请选择</option>
    <c:forEach items="${sessionScope.deptlist}" var="d">
        <option value="${d.departmentId}">${d.departmentName}</option>
    </c:forEach>
    <<select name="classId" id="classId">
    <option value="0">亲选择</option>
</select>
</select>


<div id="d1">
    <div id="d2">
        <input name="info" id="info">
    </div>
    <div id="d3">
        <input type="button" value="搜索">
    </div>
    <div id="d4"></div>
</div>
</body>
</html>
