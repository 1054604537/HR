<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/27
  Time: 10:10
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
    <title>员工查看培训消息</title>
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
</head>
<body>
<div class="main">
    <table border="1px" cellspacing="0" cellpadding="0">
        <tr>
            <th>主题</th>
            <th>内容</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>培训地点</th>
        </tr>
        <c:forEach items="${sessionScope.train}" var="print">
            <tr>
                <td>${print.t_theme}</td>
                <td>${print.t_content}</td>
                <td>${print.t_startdate}</td>
                <td>${print.t_enddate}</td>
                <td>${print.t_site}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
