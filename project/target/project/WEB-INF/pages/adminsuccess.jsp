<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/23
  Time: 10:19
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
    <title>管理员界面</title>
</head>
<body>
    ${admin}进入
<div>
    <div class="left_box">
        <ul>
            <li>
                <a href="seeallresumes">查看简历库投递情况</a>
            </li>
            <li>
                <a href="#">增加公司职位信息及人员部署</a>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
