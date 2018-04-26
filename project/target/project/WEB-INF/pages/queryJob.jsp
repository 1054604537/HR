<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/25
  Time: 19:30
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
</head>
<body>


<table border="1" cellspacing="0" cellpadding="0">
    <tr>
        <th>部门编号</th>
        <th>部门名称</th>
        <th>职位</th>
    </tr>
    <c:forEach var="print" items="${sessionScope.deptTojob}">
        <tr>
            <td>${print.d_id}</td>
            <td>${print.d_name}</td>
            <td>${print.jobs}</td>
        </tr>
    </c:forEach>
</table>

<p>*:职位下有任职员工不能删除</p>
<table border="1px" cellpadding="0" cellspacing="0">

    <tr>
        <th>职位ID</th>
        <th>职位名称</th>
        <th>职位创建时间</th>
        <th>职位薪资</th>
        <th>删除职位</th>
    </tr>
    <c:forEach items="${jobs}" var="print2">
        <tr>
            <td>${print2.j_id}</td>
            <td>${print2.j_name}</td>
            <td>${print2.j_date}</td>
            <td>${print2.j_jsal}</td>
            <td>
                <form action="deleteJob" method="post">
                    <input type="hidden" value="${print2.j_id}" name="jid"/>
                    <input type="submit" value="删除"/>
                </form>

            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
