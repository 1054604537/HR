<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/26
  Time: 15:54
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
    <title>个人基本信息</title>
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
<h2>个人信息</h2>
<div class="main">
    <table border="1px" cellpadding="0" cellspacing="0">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>联系电话</th>
            <th>邮箱</th>
            <th>入职日期</th>
        </tr>

            <tr>
                <td>${detail.e_id}</td>
                <td>${detail.e_name}</td>
                <td>${detail.e_sex}</td>
                <td>${detail.e_phone}</td>
                <td>${detail.e_email}</td>
                <td>
                    <fmt:formatDate value="${detail.e_joindate}" type="date" dateStyle="long"/>
                </td>
            </tr>

    </table>
</div>
</body>
</html>
