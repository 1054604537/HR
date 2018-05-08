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
    <style>
        div{
            float: left;
        }
        .div1{
            display: inline;
        }
    </style>
</head>
<body>
<h3 style="color: red">*同一天的不论是迟到·早退算一次惩罚，如果有同一天能出现旷工情况，以矿工计算</h3>

    <div class="div1">
        <table border="1px" cellspacing="0" cellpadding="0">
            <tr>
                <th>基本工资</th>
            </tr>
            <tr>
                <td>${jsal}</td>
            </tr>
        </table>

    </div>

    <div class="div1" style="padding-left: 20px">
        <p>2.迟到部分：</p>
        <table border="1px" cellpadding="0" cellspacing="0">
            <tr>
                <th>迟到</th>
                <th>迟到时间</th>
            </tr>
            <c:forEach items="${late1}" var="print">
                <tr>
                    <td>
                            ${print.p_number}
                    </td>
                    <td>
                        <fmt:formatDate value="${print.p_date}" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
                <%--<span style="color: red">${notlate1}</span>--%>
            </c:forEach>
        </table>

    </div>

    <div class="div1"style="padding-left: 20px">
        <table border="1" cellspacing="0" cellpadding="0">
            <p>3.早退部分</p>
            <tr>
                <th>早退</th>
                <th>早退时间</th>
            </tr>
            <c:forEach items="${late2}" var="print2">
                <tr>
                    <td>
                            ${print2.p_number}
                    </td>

                    <td>
                        <fmt:formatDate value="${print2.p_date}" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
            </c:forEach>
            <%--<span style="color: red">${notlate2}</span>--%>
        </table>
    </div>

    <div class="div1" style="padding-left: 20px">
        <table border="1px" cellspacing="0" cellpadding="0">
            <p>4.旷工部分</p>
            <tr>
                <th>矿工</th>
                <th>矿工时间</th>
            </tr>
            <c:forEach items="${late3}" var="print3">
                <tr>
                    <td>${print3.p_number}</td>
                    <td>
                        <fmt:formatDate value="${print3.p_date}" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
            </c:forEach>
            <%--<span style="color: red">${notLate3}</span>--%>
        </table>
    </div>

    <div class="div1" style="padding-left: 20px">
        <p>5.其他奖励</p>
        <table border="1px" cellspacing="0" cellpadding="0">
            <tr>
                <th>奖励</th>
                <th>奖励时间</th>
                <TH>奖励类型</TH>
            </tr>
            <c:forEach items="${late4}" var="print4">
                <tr>
                    <td>${print4.p_number}</td>
                    <td>
                        <fmt:formatDate value="${print4.p_date}" pattern="yyyy-MM-dd"/>
                    </td>
                    <td>${print4.p_type}</td>
                </tr>
            </c:forEach>
            <%--<span style="color: red">${}</span>--%>
        </table>
    </div>

    <div class="div1" style="padding-left: 20px">
        <TABLE  border="1px" cellspacing="0" cellpadding="0">
        <p>6.其他惩罚部分</p>
        <tr>
            <th>惩罚</th>
            <th>惩罚时间</th>
            <TH>惩罚类型</TH>
        </tr>
        <c:forEach items="${late5}" var="print5">
            <tr>
                <td>${print5.p_number}</td>
                <td>
                    <fmt:formatDate value="${print5.p_date}" pattern="yyyy-MM-dd"/>
                </td>
                <td>${print5.p_type}</td>
            </tr>
        </c:forEach>
        <%--<span style="color: red">${notLate5}</span>--%>
        </table>
    </div>
</body>
</html>
