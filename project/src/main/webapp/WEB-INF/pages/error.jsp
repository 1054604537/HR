<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/23
  Time: 19:52
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
    <title>没有数据界面</title>
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
${error}
${deleteJob}
${sessionScope.error2}
${sessionScope.resumeIsnull}
${null11}

${empanddept1}
${notphone}

${sessionScope.saveClock}
${notSeconsider}
${noTo}
</body>
</html>
