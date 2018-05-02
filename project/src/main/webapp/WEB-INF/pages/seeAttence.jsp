
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/5/2
  Time: 14:56
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
    <title>查看个人考勤</title>
</head>
<body>

    <div>
        <table border="1px" cellspacing="0" cellpadding="0">
            <tr>
                <th>上班打卡时间</th>
                <th>下班打卡时间</th>
                <th>考勤类型</th>
                <th>员工编号</th>
            </tr>
            <c:forEach items="${seeAttence}" var="print">
                <tr>
                    <td>
                        <fmt:formatDate value="${print.a_clock_in}" pattern="yyyy-MM-dd　HH：mm"/>
                            </td>
                    <td> <fmt:formatDate value="${print.a_end_in}" pattern="yyyy-MM-dd　HH：mm"/></td>
                    <td>${print.a_type}</td>
                    <td>${emp.e_id}</td>
                </tr>

            </c:forEach>
        </table>
    </div>
</body>
</html>
