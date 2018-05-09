<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/5/9
  Time: 13:41
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
</head>
<body>
    <div>
        <table>

            <tr>
                <th>复议人员工号</th>
                <th>复议原因</th>
                <th>操作</th>
            </tr>
          <c:forEach items="${seconsider}" var="print">
              <tr>
                  <td>${print.e_id}</td>
                  <td>${print.p_descrption}</td>

                  <td>

                      <form method="post" action="updateSal">
                          <select name="select">
                              <option>同意</option>
                              <option>不同意</option>
                          </select>
                          <input type="hidden" value="${print.e_id}" name="eid"/>
                          <input type="hidden" name="id" value="${print.p_id}"/>
                          <input type="hidden" name="descrption" value="${print.p_descrption}"/>
                          <input type="submit" value="提交"/>
                      </form>
                  </td>
              </tr>
          </c:forEach>

        </table>



    </div>
</body>
</html>
