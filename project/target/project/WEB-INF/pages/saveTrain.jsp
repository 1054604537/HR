<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/26
  Time: 13:57
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
    <title>添加培训消息</title>
    <style>
        body {
            width: 100%;
            height:100%;
            font-family: 'Open Sans', sans-serif;
            background: url("images/age.jpg");
            filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3E1D6D', endColorstr='#092756',GradientType=1 );
        }
        .main{
            text-align: center; /*让div内部文字居中*/
            border-radius: 20px;
            width: 300px;
            height: 350px;
            margin: auto;
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
        }
    </style>
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        function checkdate() {
            var date1=document.getElementById("box1").value.replace();
            var date2=document.getElementById("box2").value.replace();
            if (date1>date2){
                alert("结束时间不能小于开始时间");
                return false;
            }else{
                return true;
            }
        }
    </script>
</head>
<body>
<div class="main">
    <form action="addTrain" method="post">
        培训主题： <input type="text" name="theme" required="required"/><br/><br/>
        培训内容： <textarea name="content" required="required"></textarea><br/>
        培训开始时间：<input type="date" name="startdate" required="required" id="box1"><br/>
        培训结束时间：<input type="date" name="enddate" required="required" id="box2" onblur="checkdate()"/><br/>
        培训地点：<input type="text" name="site" required="required"/><br/>
        选择培训部门：
        <c:forEach items="${dept}" var="items">
            ${items.d_id}:${items.d_name}<input type="radio" value="${items.d_id}" name="did"/>
        </c:forEach><br/>
        <input type="submit" value="发布"/>
        <input type="submit" value="取消"/>
    </form>
</div>



</body>
</html>
