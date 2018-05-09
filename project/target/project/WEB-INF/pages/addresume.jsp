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
    <script src="js/jquery-3.1.0.js"></script>
    <STYLE>
        body {
            width: 100%;
            height:100%;
            font-family: 'Open Sans', sans-serif;
            background: url("images/age.jpg");
            filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3E1D6D', endColorstr='#092756',GradientType=1 );
        }
        .main{
            text-align: center; /*让div内部文字居中*/
            border-radius: 20px;
            width: 300px;
            height: 350px;
            margin: auto;
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
        }
        a{
            text-decoration: none;
        }
    </STYLE>
</head>
<body>
<div class="main">
    <form method="post"  action="addre">
        姓名：<input type="text" name="r_name" placeholder="请输入姓名" autofocus  required="required"/><p/>
        性别：<input type="text" name="r_sex" autofocus required="required"/><p/>
        年龄：<input type="text" name="r_age"  required="required" class="text1" id="userId"/><span id="spanId"></span><p/>

        手机号码：<input type="text" name="r_phone"  required="required"/>
        <p/>



        邮箱:<input type="email" name="r_email"  required="required"/><p/>
        出生日期：<input type="date" name="r_birthdate" id="id1" required="required"/><p/>
        学历：<input type="text" name="r_education"  required="required"/><p/>
        个人描述：<input type="text" name="r_description"  required="required"/><p/>
        <input type="hidden" value="${uid}" name="uid">
        <input type="submit" value="提交">
        <input type="reset" value="取消">
    </form>
    <a href="indexUserHome">返回</a>
</div>

</body>
</html>
