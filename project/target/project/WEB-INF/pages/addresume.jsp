<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/20
  Time: 19:30
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
    <title>添加个人简历</title>

</head>
<body>
<form method="post"  action="addre">
    姓名：<input type="text" name="r_name" placeholder="请输入姓名" autofocus/><p/>
    性别：<input type="text" name="r_sex" autofocus/><p/>
    年龄：<input type="text" name="r_age"/><p/>
    手机号码：<input type="text" name="r_phone"/><p/>
    邮箱:<input type="email" name="r_email"/><p/>
    出生日期：<input type="date" name="r_birthdate" id="id1"/><p/>
    学历：<input type="text" name="r_education"/><p/>
    个人描述：<input type="text" name="r_description"/><p/>
    <input type="hidden" value="${uid}" name="uid">
    <input type="submit" value="提交">
    <input type="reset" value="取消">
</form>
</body>
</html>
