<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/23
  Time: 23:16
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
    <title>我的面试邀请消息</title>
    <style>
        body {
            width: 100%;
            height:100%;
            font-family: 'Open Sans', sans-serif;
            background: url("images/age.jpg");
            filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3E1D6D', endColorstr='#092756',GradientType=1 );
        }
    </style>
</head>
<body>
<table border="1" cellpadding="0" cellspacing="0">

    <tr>
        <th>公司名称</th>
        <th>面试职位</th>
        <th>面试时间</th>
        <th>面试地点</th>
        <th>其他描述</th>
        <th>接收面试</th>
        <th>状态</th>
    </tr>
    <c:forEach items="${invite1}" var="items">
        <tr>
            <td>上海海同科技</td>
            <td>${items.i_job}</td>
            <td>${items.i_date}</td>
            <td>${items.i_site}</td>
            <td>${items.i_description}</td>

            <td>
                <form method="post" action="accept" name="form1">
                    <input type="submit" value="接受" onclick="javascript:{this.disabled=true;document.form1.submit();}"/>
                </form>
            </td>
            <td>${items.i_isno_accept}</td>

        </tr>
    </c:forEach>

</table>


</body>
</html>
