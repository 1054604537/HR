<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/26
  Time: 15:18
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
    <title>员工登录成功</title>
</head>
<body>
    <h3>欢迎您：${sessionScope.emp.e_name}</h3>
    <div>
        <ul>
            <li>
                <a href="seeEmp">查看个人基本信息</a>
            </li>
        </ul>
    </div>

</body>
</html>
