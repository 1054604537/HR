<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/5/2
  Time: 19:39
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
    <title>员工修改密码</title>
</head>
<body>
<form method="post" action="empUpdaPass">
    新密码：<input type="password" required="required" placeholder="新密码" name="pass" autofocus/>
    <input type="submit" value="修改"/>
</form>
</body>
</html>
