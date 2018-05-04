<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/5/3
  Time: 10:40
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
    <title>查看个人薪资</title>
</head>
<body>
<div>
    <p>职位工资：${jsal}</p>
</div>


<div>
    <p>迟到部分：</p>
    <table border="1px" cellpadding="0" cellspacing="0">
        <tr>
            <th>迟到</th>
            <th>迟到时间</th>
        </tr>
        <c:forEach items="${rewpub}" var="print">
            <tr>
                <td>
                   ${print.p_number}
                </td>
                <td>
                    <fmt:formatDate value="${print.p_date}" type="date" pattern="yyyy-MM-dd  HH:mm:ss"/>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p/>
        <table border="1" cellspacing="0" cellpadding="0">
            <p>早退部分</p>
            <tr>
                <th>早退</th>
                <th>早退时间</th>
            </tr>
            <c:forEach items="${rewpub2}" var="print2">
                <tr>
                    <td>
                        ${print2.p_number}
                    </td>

                    <td>
                        <fmt:formatDate value="${print2.p_date}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
</div>
</body>
</html>
