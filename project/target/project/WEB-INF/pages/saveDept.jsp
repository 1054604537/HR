<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/25
  Time: 13:48
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
    <title>增加部门</title>
    <script src="js/jquery-3.1.0.js"></script>
    <style>
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
    </style>
</head>
<body>

<div class="main">
    ${error}
        <p><span>*</span>现有部门不能重复添加</p>

    <form method="post" action="addDept" onsubmit="check(this);return false">
        <div class="name">
            新部门：<input type="text" name="dept" value="" required="required"/><br/>
            创建时间：<input type="date" name="date" required="required"/><br>
        </div>
        <input type="submit" value="添加"/>
    </form>

</div>

<script>
    function check(form) {
        if (form.name.value == ''){
            alert("不能为空，请填写");
            return;
        }
        form.submit();
    }
</script>
</body>
</html>
