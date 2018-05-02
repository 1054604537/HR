<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/5/2
  Time: 9:44
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
    <title>游客查看公司招聘信息</title>
</head>
<style>
    div{
        text-align: center;
    }
</style>
<body>
<div>
    <table border="1px" cellspacing="0" cellpadding="0">
        <tr>
            <th>ID</th>
            <th>招聘职位</th>
            <th>人数</th>
            <th>学历要求</th>
            <th>工资</th>
            <th>其他描述</th>
            <th>投递</th>
        </tr>
        <c:forEach items="${sessionScope.seeAllRecruit}" var="print">
            <tr>
                <td>${print.re_id}</td>
                <td>${print.j_name}</td>
                <td>${print.re_number}</td>
                <td>${print.re_education}</td>
                <td>${print.re_sal}</td>
                <td>${print.re_descrption}</td>
                <td>
                    <input type="button" value="投递" onclick="alert('暂无简历，请至首页注册后投递，谢谢！')"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

${sessionScope.error}
</body>
</html>
