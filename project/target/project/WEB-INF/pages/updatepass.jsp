<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/23
  Time: 9:25
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
    <title>修改密码区域</title>
    <style>
        body {
            width: 100%;
            height:100%;
            font-family: 'Open Sans', sans-serif;
            background: url("images/age.jpg");
            filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3E1D6D', endColorstr='#092756',GradientType=1 );
        }
    </style>
    <script src="js/jquery-3.1.1.js"></script>
    <script>
    function check(form) {
        if (form.name1.value == ''){
            alert('旧密码不能为空');
            return;
        }
        if (form.name2.value ==''){
            alert("新密码不能为空");
            return;
        }
        if (form.name2.value != form.name3){
            alert("两次密码不一致");
            return;
        }
    }
    </script>
</head>
<body>
<div>
    <form method="post" action="updatepass2">
        <input type="hidden" value="${uid}" name="uid">
        <div class="name1">
            旧密码：<input type="password" name="oldpass" id="id1" value=""/><br/>
        </div>
        <div class="name2" >
            新密码：<input type="password" name="newpass" id="id2" value=""/><br/>
        </div>
       <div class="name3">
           确认密码：<input type="password" name="newpass1" id="id3" value=""><br/>
       </div>

        <input type="submit" value="提交"/>
        <input type="reset" value="重置">
    </form>
</div>
</body>
</html>
