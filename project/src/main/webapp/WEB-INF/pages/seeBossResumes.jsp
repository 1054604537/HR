<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/23
  Time: 11:22
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
    <title>查看投递简历</title>
    <style>
        .box{
            width:80%; margin-top:10%; margin:auto; padding:28px;
            height:1000px; border:1px #111 solid;
            display:none;            /* 默认对话框隐藏 */
        }
        .box.show{display:block;}
        .box .x{ font-size:18px; text-align:right; display:block;}
        .box input{width:80%; font-size:18px; margin-top:18px;}
    </style>
    <script>
        function  msgbox(n) {
            document.getElementById('inputbox').style.display=n?'block':'none';
        }
    </script>
</head>
<body>
<div>
    <table border="1"style="color: black" cellpadding="0" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>投递时间</th>
            <th>职位</th>
            <th>投递人姓名</th>
            <th>投递人手机号码</th>
            <th>投递人邮箱</th>
            <th>查看投递人个人简历</th>
            <th>发出面试邀请</th>
        </tr>
        <c:forEach var="items" items="${bossresumes}">
            <tr>
                <td>${items.br_id}</td>
                <td>${items.br_date}</td>
                <td>${items.br_job}</td>
                <td>${items.br_uname}</td>
                <td>${items.br_uphone}</td>
                <td>${items.br_uemail}</td>
                <td>
                    <input type="button" value="查看简历详情" onclick="msgbox(1)"/>

                </td>
                <td>
                        <input type="button" value="发出邀请" onclick="msgbox(1)"/>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
        <div id="inputbox" class="box">
            <a class="x" href="" onclick="msgbox(0);return false">关闭</a>
            <p>详细简历</p>
            <table border="1" cellspacing="0" cellpadding="0">
                <tr>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>手机号码</td>
                    <td>出生日期</td>
                    <td>学历</td>
                    <td>自我描述</td>
                </tr>
                     <c:forEach items="${resume}" var="inems">
                <tr>
                    <td>${inems.r_name}</td>
                    <td>${inems.r_sex}</td>
                    <td>${inems.r_age}</td>
                    <td>${inems.r_phone}</td>
                    <td>${inems.r_birthdate}</td>
                    <td>${inems.r_education}</td>
                    <td>${inems.r_description}</td>
                       </c:forEach>
                    </tr>

            </table>
        </div>
</body>
</html>
