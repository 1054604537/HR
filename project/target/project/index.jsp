<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/12 0012
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
</head>

<script src="js/jquery-3.1.0.js"></script>
<script type="text/javascript">
</script>
<script type="text/javascript">

</script>
<style>
    a{
        text-decoration: none;
    }
    div{
        text-align: center;
    }
</style>
  <body style="background-color: royalblue">
  <div>
      <a href="userSeeAllRecruit">查看本公司招聘信息</a>
  </div>
      <div style="border: 1px solid black;text-align: center">
          <form action="addUser" method="get" accept-charset="utf-8" onsubmit="check(this);return false;">
              <div class="name">
                  账号：
                  <input type="text" name="name" value='' autofocus  onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"/>
              </div>
              <div class="pass">
                  密码： <input type="password" name="pass"  value=''  onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"/>
              </div>
              <div class="pass2">
                  确认：
                  <input type="password" name="pass2"  value=''  onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"/>
              </div>
              <div>
                  邮箱：<input type="email" name="email" >
              </div>
              <input type="submit" value="注册">
          </form>
      </div>

  <div>
      <a href="login2">已是客户？直接登录</a>
  </div>
  <div>
      <a href="adminlogin">管理员登录</a>
  </div>
  <div>
      <a href="empLogin">员工登录</a>
  </div>
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
