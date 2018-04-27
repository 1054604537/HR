<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/27
  Time: 15:34
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
    <title></title>
</head>
<body>
    <p>请填写表单信息</p>
    <form method="post" action="addRewAndPub1">
        选择：<select name="name">
        <option>奖励</option>
        <option>惩罚</option>
    </select>
        <br/>
        金额：<input type="number" name="number"  required="required"/><br/>
        创建时间：<input type="date" name="date"  required="required"/><br/>
        奖罚原因：<input type="text" name="descption"  required="required"/><br/>
        操作员工编号：<input type="number" name="eid"  required="required"/><br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
