<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/25
  Time: 10:51
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
    <title>添加招聘信息</title>
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
    <form action="addRecruit" method="post">
        <h4>选择发布的职位</h4>
        <c:forEach items="${job}" var="print">

            ${print.j_name}:<input type="radio" value="${print.j_name}" name="job" placeholder="招聘职位"/><br/>
        </c:forEach>
        <%--招聘职位：<input type="text" name="job" placeholder="招聘职位" autofocus/><br/>--%>


        招聘人数:<input type="number" name="number" placeholder="人数"  required="required"/><br/>
        学历要求：<input type="text" name="education" placeholder="学历"  required="required"/><br/>
        薪资：<input type="text" name="sal" placeholder="薪资"  required="required"/><br/>
        其他描述:<input type="text" name="descrption" placeholder="其他描述"  required="required"/><br/>
        <input type="submit" value="发布"/>
    </form>
</body>
</html>
