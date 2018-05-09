<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/4/25
  Time: 11:39
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
    <title>全部招聘信息</title>
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
    <table border="1px" cellspacing="0" cellpadding="0">
        <tr>
            <th>ID</th>
            <th>招聘职位</th>
            <th>人数</th>
            <th>学历要求</th>
            <th>工资</th>
            <th>其他描述</th>
            <th>删除</th>
        </tr>
        <c:forEach items="${sessionScope.allRecruit}" var="print">
            <tr>
                <td>${print.re_id}</td>
                <td>${print.j_name}</td>
                <td>${print.re_number}</td>
                <td>${print.re_education}</td>
                <td>${print.re_sal}</td>
                <td>${print.re_descrption}</td>
                <td>
                    <form method="post" action="deleteRecruit">
                        <input type="hidden" name="delete" value="${print.re_id}"/>
                        <input type="submit" value="删除">
                    </form>

                </td>
            </tr>
        </c:forEach>
    </table>
    ${sessionScope.error}
</div>
</body>
</html>
