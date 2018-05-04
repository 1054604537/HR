<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/24
  Time: 14:36
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
    <title>确定录用并入职</title>
</head>
<body>


<form method="post" action="addEmp">
    <c:forEach items="${resume}" var="items">
        员工编号：<input type="text" value="${items.r_phone}" name="id" readonly="readonly"><br/>
        员工姓名：<input type="text" value="${items.r_name}" name="name" readonly="readonly"><br/>
        员工性别：<input type="text" value="${items.r_sex}" name="sex" readonly="readonly"/><br/>
        员工电话：<input type="text" value="${items.r_phone}" name="phone" readonly="readonly"/><br/>
        员工邮箱：<input type="text" value="${items.r_email}" name="email" readonly="readonly"><br/>
        <input type="hidden" value="${items.u_id}" name="uid">
    </c:forEach>
    部门编号：

    <c:forEach items="#{dept}" var="dept">
        ${dept.d_id}:${dept.d_name} <input type="radio" name="did" value="${dept.d_id}"/>

    </c:forEach><br/>
    职位编号：
    <c:forEach items="${jobs}" var="print">
        ${print.j_id}:${print.j_name}<input type="radio" name="jid" value="${print.j_id}"/>
    </c:forEach><br/>

    <input type="submit" value="提交"/>
</form>

</body>
</html>
