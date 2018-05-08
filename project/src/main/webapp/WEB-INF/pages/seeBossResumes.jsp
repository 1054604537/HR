<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        body {
            width: 100%;
            height:100%;
            font-family: 'Open Sans', sans-serif;
            background: url("images/age.jpg");
            filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3E1D6D', endColorstr='#092756',GradientType=1 );
        }
        .box{
            width:50%; margin-top:10%; margin:auto; padding:28px;
            height:400px; border:1px #111 solid;
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
            <th>删除</th>
        </tr>
        <c:forEach var="items" items="${bossresumes}">
            <tr>
                <td>
                    ${items.br_id}
                        </td>
                <td>${items.br_date}</td>
                <td>${items.br_job}</td>
                <td>${items.br_uname}</td>
                <td>${items.br_uphone}</td>
                <td>${items.br_uemail}</td>
                <td>
                    <input type="button" value="查看简历详情" onclick="msgbox(1)"/>

                </td>
                <td>
                    <form action="inviteToUser" method="post">
                        <input type="date" name="date" placeholder="面试时间"/>
                        <input type="hidden" value="${items.br_job}" name="job"/>
                        <input type="text" name="site" placeholder="面试地点">
                        <input type="text" name="descrption" placeholder="其他描述">
                        <input type="hidden" value="${uid}" name="uid">
                        <input type="submit" value="发出邀请"/>
                    </form>

                </td>
                <td>
                        <form method="post" action="deleteboss">
                            <input type="hidden" value="${items.br_id}" name="brid"/>
                            <input type="submit" value="删除"/>
                        </form>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
        <div id="inputbox" class="box">
            <a class="x" href="" onclick="msgbox(0);return false">关闭</a>
            <p>详细简历</p>
                    <c:forEach items="${resume}" var="inems">
            <table border="1" cellspacing="0" cellpadding="0">

                    <tr>
                        <th>姓名</th>
                        <td>${inems.r_name}</td>
                    </tr>
                    <tr>
                        <th>性别</th>
                        <td>${inems.r_sex}</td>
                    </tr>
                    <tr>
                        <th>年龄</th>
                        <td>${inems.r_age}</td>
                    </tr>
                    <tr>
                        <th>手机号码</th>
                        <td>${inems.r_phone}</td>
                    </tr>
                    <tr>
                        <th>出生日期</th>
                        <td>${inems.r_birthdate}</td>
                    </tr>
                    <tr>
                        <th>学历</th>
                        <td>${inems.r_education}</td>
                    </tr>
                    <tr>
                        <th>个人描述</th>
                        <td>${inems.r_description}</td>
                    </tr>

            </table>
            </c:forEach>
        </div>
</body>
</html>
