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
    <div>
        <ul>
            <li>
                <a href="seerecruit?uid=${user.u_id}">浏览本公司招聘信息</a><br/>
            </li>
            <li>
                <a href="addresume?uid=${user.u_id}">添加个人简历</a><br/>
            </li>
            <li>
                <a href="seeresumne?uid=${user.u_id}">查看简历</a><br/>
            </li>
            <li>
                <a href="message">我的消息</a>
            </li>
            <li>
                <a href="updatepass?uid=${user.u_id}">修改密码</a>
            </li>
        </ul>




    </div>


</body>
</html>
