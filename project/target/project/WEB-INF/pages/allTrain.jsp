<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/26
  Time: 13:17
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
    <title>查看所有的培训消息</title>
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
        <h3>*所有培训消息</h3>
<table border="1px" cellspacing="0" cellpadding="0">
    <tr>
        <td>培训ID</td>
        <td>培训主题</td>
        <td>培训内容</td>
        <td>培训开始时间</td>
        <td>培训结束时间</td>
        <td>培训的地点</td>
        <td>培训的部门</td>
        <td>删除已发布培训</td>
    </tr>



    <c:forEach items="${train}" var="print">
        <tr>
            <td>${print.t_id}</td>
            <td>${print.t_theme}</td>
            <td>${print.t_content}</td>
            <td>${print.t_startdate}</td>
            <td>${print.t_enddate}</td>
            <td>${print.t_site}</td>
            <td>${print.d_id}</td>
            <td>
                <form method="post" action="deleteTrain">
                    <input type="hidden" value="${print.t_id}" name="did">
                    <input type="submit" value="删除"/>
                </form>

            </td>
        </tr>
    </c:forEach>



</table>
        <h3>详情：</h3>
        <c:forEach items="${dept}" var="items">
            <span>${items.d_id}:${items.d_name}</span>
        </c:forEach>
</body>
</html>
