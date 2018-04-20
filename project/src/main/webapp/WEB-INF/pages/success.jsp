<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/20
  Time: 14:13
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
    <title>登录成功界面。。。</title>
</head>
<body>
    welcome ${user} 进入。。。
    <a>浏览本公司招聘信息</a>
    <a href="#">添加个人简历</a>


</body>
</html>
