<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/21
  Time: 12:02
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
    <title>查看简历</title>
</head>
<body>
    <table border="1" cellpadding="0" cellspacing="0">
        <tr>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>手机号码</th>
            <th>邮箱</th>
            <th>出生日期</th>
            <th>学历</th>
            <th>个人描述</th>
            <th>操作</th>
        </tr>
            <c:forEach items="${resume}" var="item">
        <tr>

              <td>${item.r_name}</td>
              <td>${item.r_sex}</td>
              <td>${item.r_age}</td>
              <td>${item.r_phone}</td>
              <td>${item.r_email}</td>
              <td>${item.r_birthdate}</td>
              <td>${item.r_education}</td>
              <td>${item.r_description}</td>
              <td>
                <form method="post" action="deleteres">
                    <input type="hidden" name="rid" value="${item.r_id}"/>
                    <input type="submit" value="删除">
                </form>
              </td>
        </tr>
            </c:forEach>
    </table>
</body>
</html>
