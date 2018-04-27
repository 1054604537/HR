<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/26
  Time: 17:48
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
    <title>个人的职位和部门</title>
</head>
<body>
<div>
    员工姓名: ${sessionScope.seePerformance.e_name}<br/>
    所在部门：${sessionScope.dept.d_name}<br/>
    所属职位：${sessionScope.job.j_name}<br/>
    职位基本薪资：${sessionScope.job.j_jsal}<br/>
</div>

</body>
</html>
