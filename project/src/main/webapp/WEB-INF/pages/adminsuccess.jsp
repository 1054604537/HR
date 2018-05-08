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
        body {
            width: 100%;
            height:100%;
            font-family: 'Open Sans', sans-serif;
            background: #092756;
            /*background: -moz-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%),-moz-linear-gradient(top,  rgba(57,173,219,.25) 0%, rgba(42,60,87,.4) 100%), -moz-linear-gradient(-45deg,  #670d10 0%, #092756 100%);*/
            /*background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -webkit-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -webkit-linear-gradient(-45deg,  #670d10 0%,#092756 100%);*/
            /*background: -o-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -o-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -o-linear-gradient(-45deg,  #670d10 0%,#092756 100%);*/
            /*background: -ms-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -ms-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -ms-linear-gradient(-45deg,  #670d10 0%,#092756 100%);*/
            /*background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), linear-gradient(to bottom,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), linear-gradient(135deg,  #670d10 0%,#092756 100%);*/
            filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3E1D6D', endColorstr='#092756',GradientType=1 );
        }
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
                <a href="relieve">员工的换岗</a>
            </li>
            <li>
                <a href="saveDept">增加公司部门</a>
            </li>
            <li>
                <a href="allDept">查看所有部门</a>
            </li>
            <li>
                <a href="seeEmpByDept">查看公司所有部门下的人员</a>
            </li>
            <li>
                <a href="allotToEmp">管理员员工的录用</a>
            </li>
        </ul>
    </div>

<div style="float: inherit;width: 750px;background:darkred">
    <h3>职位的操作</h3>
    <ul>
        <li>
            <a href="saveJob">增加职位</a>
        </li>
        <li>
            <a href="queryJob">查询全部职位及对应的部门</a>
        </li>
    </ul>
</div>

<div style="float: inherit;width: 750px;background:royalblue">
    <h3>培训中心</h3>
    <ul>
        <li>
            <a href="allTrain">查看所有培训信息（查）</a>
        </li>
        <li>
            <a href="saveTrain">管理员发布培训信息（增）</a>
        </li>
    </ul>
</div>

    <div style="float: inherit;width: 750px;background:chartreuse">
        <h3>奖惩中心</h3>
        <ul>
            <li>
                <a href="addRewAndPub">对员工的奖惩管理（奖励 受罚）</a>
            </li>
            <li>
                <a href="seeAllEmpRewAndPub">查看所有员工的奖惩记录（删除记录）</a>
            </li>
        </ul>
    </div>

</div>
</body>
</html>
