<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/26
  Time: 15:10
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
    <title>员工登录</title>
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        function check(form) {
            if (form.box.value ==' '){
                alert("不能为空");
                return;
            }
            form.submit();
        }
    </script>
</head>
<body>
<fieldset>
    <form action="empLogin1" method="post" onsubmit="check(this);return false">
        <div class="box">
            请输入您的账号：<input type="text" placeholder="账号" autofocus name="name"  required="required"/><br/>
        </div>
        <div>
            请输入密码：<input type="password" placeholder="密码" name="pass" required="required"/><br/>
        </div>
        <input type="submit" value="登录">
        <input type="submit" value="取消">
    </form>
</fieldset>

</body>
</html>
