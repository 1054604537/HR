<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/25
  Time: 15:31
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
    <title>全部门</title>
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
<h3><span>说明：*</span>部门存在员工不能删除</h3>
    <table border="1px" cellpadding="0" cellspacing="0">
        <tr>
            <th>部门ID</th>
            <th>部门名称</th>
            <th>创建时间</th>
            <th>删除部门</th>
        </tr>
        <c:forEach items="${sessionScope.dept}" var="print">
            <tr>
                <td>${print.d_id}</td>
                <td>${print.d_name}</td>
                <td>${print.d_date}</td>
                <td>
                    <form method="post" action="deDept">
                        <input type="hidden" value="${print.d_id}" name="did"/>
                        <input type="submit" value="删除"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>
