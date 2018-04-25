<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/25
  Time: 10:51
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
    <title>添加招聘信息</title>
</head>
<body>
    <form action="addRecruit" method="post">
        招聘职位：<input type="text" name="job" placeholder="招聘职位" autofocus/><br/>
        招聘人数:<input type="number" name="number" placeholder="人数"/><br/>
        学历要求：<input type="text" name="education" placeholder="学历"/><br/>
        薪资：<input type="text" name="sal" placeholder="薪资"/><br/>
        其他描述:<input type="text" name="descrption" placeholder="其他描述"/><br/>
        <input type="submit" value="发布"/>
    </form>
</body>
</html>
