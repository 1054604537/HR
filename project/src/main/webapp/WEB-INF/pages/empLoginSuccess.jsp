<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/26
  Time: 15:18
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
    <title>员工登录成功</title>
    <STYLE>
        a{
            text-decoration: none;
        }
    </STYLE>
    <script type="text/javascript" src="js/jquery-3.1.0.js"></script>
    <script>

    </script>
</head>
<body>
    <h3>欢迎您：${sessionScope.emp.e_name}</h3>
    <div>
        <ul>
            <li>
                <a href="empUpdatePass">修改初始密码</a>
            </li>
            <li>
                <a href="seeEmp">查看个人基本信息</a>
            </li>
            <li>
                <a href="seeSal">查看个人薪资</a>
            </li>
            <li>
                <a href="seeTrain">查看个人培训信息</a>
            </li>
            <li>
                <a href="seePerformance">查看绩效（奖惩）</a>
            </li>
            <li>
                <a href="seeDeptAndJob">查看部门职位</a>
            </li>
            <li>
                <a href="seeAttence">查看你个人考勤</a>
            </li>
            <li>
                <a href="detailList">查看公司通讯录</a>
            </li>
            <li>
                <a href="dimission" onclick="return confirm('确定离职？')">提出离职(点击后不可修改，慎用！！！)</a>
            </li>
        </ul>
    </div>
    <div class="box">
        <ul>
            <li>
              <a href="clockin" onclick="return confirm('上班打卡？')">上班打卡</a>
            </li>
            <li>
               <a href="endin" onclick="return confirm('下班打卡？')">下班打卡</a>
            </li>
        </ul>
    </div>
</body>
</html>
