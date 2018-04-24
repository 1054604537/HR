<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/24
  Time: 11:31
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
    <title>分配员工信息</title>
</head>
<body>

<form action="newAlloEmp" method="post">
  <c:forEach items="${sessionScope.users}" var="items">
      <input type="hidden" value="${items.u_id}" name="uid" />
      姓名：${items.u_name}<input type="submit" value="选择分配"/>
  </c:forEach>

</form>
</body>
</html>
