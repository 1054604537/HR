<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/5/3
  Time: 15:59
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
    <title>部门对应的人员</title>
</head>
<body>
   <table border="1px" cellspacing="0" cellpadding="0">
       <tr>
           <th>部门名称</th>
            <th>查看</th>
       </tr>
       <c:forEach items="${deptlist}" var="print">
           <tr>
               <td>${print.d_name}</td>
               <td>
                   <form action="seeEmpAndDept" method="post">
                       <input type="hidden" value="${print.d_id}" name="did"/>
                       <input type="submit" value="查看"/>
                   </form>

               </td>
           </tr>
       </c:forEach>
   </table>
</body>
</html>
