<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/27
  Time: 16:59
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
    <style>
        body {
            width: 100%;
            height:100%;
            font-family: 'Open Sans', sans-serif;
            background: url("images/age.jpg");
            filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3E1D6D', endColorstr='#092756',GradientType=1 );
        }
    </style>
</head>
<body>
    <table border="1px" cellpadding="0" cellspacing="0">
        <tr>
            <th>类型</th>
            <th>金额</th>
            <th>操作时间</th>
            <th>原因</th>
            <th>员工编号</th>
            <th>删除此记录</th>
        </tr>

       <c:forEach items="${seeAllEmpRewAndPub}" var="print">
           <tr>
               <td>${print.p_type}</td>
               <td>${print.p_number}</td>
               <td><fmt:formatDate value="${print.p_date}" type="date" dateStyle="long"/>
                       </td>

               <td>${print.p_descrption}</td>
               <td>${print.e_id}</td>

               <td>
                   <form method="post" action="deleteRew">
                       <input type="hidden" value="${print.p_id}" name="pid"/>
                       <input type="submit" value="删除"/>
                   </form>
               </td>


           </tr>
       </c:forEach>
    </table>
</body>
</html>
