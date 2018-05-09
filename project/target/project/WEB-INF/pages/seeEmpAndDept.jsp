<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/5/3
  Time: 20:19
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
    <title>人员</title>
    <style>
        body {
            width: 100%;
            height:100%;
            font-family: 'Open Sans', sans-serif;
            background: url("images/age.jpg");
            filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3E1D6D', endColorstr='#092756',GradientType=1 );
        }4
    </style>
</head>
<body>
    <table border="1px" cellpadding="0" cellspacing="0">
        <tr>
            <th>人员</th>
            <th>手机号码</th>
        </tr>
            <c:forEach items="${empanddept}" var="print">
               <tr>
                   <td>${print.e_name}</td>
                   <td>${print.e_phone}</td>
               </tr>

            </c:forEach>

    </table>
</body>
</html>
