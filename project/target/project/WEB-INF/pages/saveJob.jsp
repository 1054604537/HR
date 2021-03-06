<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/25
  Time: 18:45
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
    <title>添加职位</title>
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
        <form method="post" action="addJob">
            职位名称：<input type="text" name="jname" required="required"/><br/>
            本职位薪资：<input type="number" name="jsal" required="required"/><br/>
            创建时间：<input type="date" name="date" required="required"/><br/>
            选择创建部门:
            <select name="dname">
                <c:forEach items="${dept}" var="print">
                    <option value="${print.d_name}">${print.d_name}</option>
                </c:forEach>
            </select>
            <input type="submit" value="创建"/>
        </form>
    </div>
</body>
</html>
