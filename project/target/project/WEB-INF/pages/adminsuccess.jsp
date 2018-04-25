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
    <style>
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>

<div style="width: 1500px;height: auto">

    <div class="left_box" style="float: left;width: 750px;background:darkgrey">
        <h3>招聘信息的操作</h3>
        <ul>
            <li>
                <a href="recruit">发布招聘信息</a>
            </li>
            <li>
                <a href="allRecruit">查看全部发布</a>
            </li>
            <li>
                <a href="seeallresumes">查看简历库投递情况</a>
            </li>

        </ul>
    </div>


    <div style="float: inherit;width: 750px;background: rosybrown">
        <h3>部门的操作</h3>
        <ul>
            <li>
                <a href="saveDept">增加公司部门（同名不能添加）</a>
            </li>
            <li>
                <a href="allDept">查看所有部门（删除，部门有员工不能删除）</a>
            </li>

            <li>
                <a href="allotToEmp">查看未分配工作人员--及入职人员分配操作（部门 职位 薪资 其他）</a>
            </li>
        </ul>
    </div>

<div style="float: inherit;width: 750px;background:darkred">
    <h3>职位的操作</h3>
    <ul>
        <li>
            <a href="#">增加职位</a>
        </li>
    </ul>
</div>


</div>


</body>
</html>
