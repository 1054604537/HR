<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>
<h2>个人信息</h2>
<div>
    <table border="1px" cellpadding="0" cellspacing="0">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>联系电话</th>
            <th>邮箱</th>
        </tr>

            <tr>
                <td>${detail.e_id}</td>
                <td>${detail.e_name}</td>
                <td>${detail.e_sex}</td>
                <td>${detail.e_phone}</td>
                <td>${detail.e_email}</td>
            </tr>

    </table>
</div>
</body>
</html>
