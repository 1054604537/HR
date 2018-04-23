<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/23
  Time: 10:20
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
    <title></title>
</head>
<body>
<fieldset>
    <legend>管理员登录</legend>
    <div style="padding: 40px 100px 200px 100px">
        <form action="adminlogin1" method="post" accept-charset="utf-8" onsubmit="check(this);return false;">
            <div class="name">
                账号：
                <input type="text" name="name" value='' autofocus id="username" onblur="hadoop()"/><span id="message"></span>
            </div>
            <div class="pass">
                密码： <input type="password" name="pass"  value=''/>
            </div>
            <div class="pass2">
                确认：
                <input type="password" name="pass2"  value=''/>
            </div>
            <input type="submit" value="登录">
        </form>
    </div>
</fieldset>
<script type="text/javascript">
    function check(form) {
        if (form.name.value =='') {
            alert('用户名不能为空');
            return;
        }
        if (form.pass.value == '') {
            alert('密码不能为空');
            return;
        }
        if (form.pass.value != form.pass2.value) {
            alert('两次输入密码不一致');
            return;
        }
        form.submit();
    }
</script>
</body>
</html>
