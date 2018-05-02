<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/30
  Time: 12:03
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
    <title>打卡页面</title>
</head>
<body>
<div>
    <p>上班打卡</p>
    <form method="post" action="#">

    </form>
</div>



</body>
</html>
