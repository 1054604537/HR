<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/5/7
  Time: 11:09
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
    <title>员工换岗</title>
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
    <div>
        <table border="1px" cellpadding="0" cellspacing="0">
            <tr>
                <th>员工姓名</th>
                <th>员工编号</th>
                <th>选择</th>
            </tr>

            <c:forEach items="${sessionScope.allEmp}" var="print">

                <tr>
                    <td>${print.e_name}</td>
                    <td>${print.e_id}</td>
                    <td>
                       <a href="empRelieve?e_eid=${print.e_eid}">换岗</a>
                    </td>
                </tr>

            </c:forEach>

        </table>
    </div>
</body>
</html>
