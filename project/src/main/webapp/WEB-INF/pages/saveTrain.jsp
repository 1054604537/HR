<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/26
  Time: 13:57
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
    <title>添加培训消息</title>
</head>
<body>
<fieldset>
    <form action="addTrain" method="post">
        培训主题： <input type="text" name="theme" required="required"/><br/><br/>
        培训内容： <textarea name="content" required="required"></textarea><br/>
        培训开始时间：<input type="date" name="startdate" required="required"><br/>
        培训结束时间：<input type="date" name="enddate" required="required"/><br/>
        培训地点：<input type="text" name="site" required="required"/><br/>
        选择培训部门：
        <c:forEach items="${dept}" var="items">
            ${items.d_id}:${items.d_name}<input type="radio" value="${items.d_id}" name="did"/>
        </c:forEach><br/>
        <input type="submit" value="发布"/>
        <input type="submit" value="取消"/>
    </form>
</fieldset>

</body>
</html>
