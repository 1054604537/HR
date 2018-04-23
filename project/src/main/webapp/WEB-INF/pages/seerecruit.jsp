<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/22
  Time: 10:10
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
    <title>公司简历</title>
    <script src="js/jquery-3.1.0.js"></script>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="0" >
    <tr>
        <th>招聘职位</th>
        <th>招聘人数</th>
        <th>学历要求</th>
        <th>薪资</th>
        <th>其他描述</th>
        <th>投递简历</th>
    </tr>
  <c:forEach items="${recruit}" var="item">
      <tr>
          <td>${item.j_name}</td>
          <td>${item.re_number}</td>
          <td>${item.re_education}</td>
          <td>${item.re_sal}</td>
          <td>${item.re_descrption}</td>

          <td>
                <form action="mailing" method="post">
                  <input type="hidden" name="job" value="${item.j_name}"/>
                  <input type="hidden" value="${sessionScope.uid}" name="uid"/>
                    <input type="submit" value="投递" id="box1"/>
              </form>
          </td>
      </tr>
  </c:forEach>
</table>

<script>
    $(function () {
        $(function chenk() {
            $("#box1").onclick(function () {
                alert('投递成功！')
            });
        })
    });
</script>
</body>
</html>
