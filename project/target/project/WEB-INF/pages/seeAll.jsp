<%--
  Created by IntelliJ IDEA.
  User: 10546
  Date: 2018/5/2
  Time: 15:57
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
    <script src="js/jquery-3.1.0.js"></script>
    <title>二级联动</title>

</head>
<body>
<div>
    <select id="riDept" onchange="change()" >
    </select>
    <select id="id2">
    </select>
</div>


<script>
    loadDept();
    function loadDept() {
        $.ajax({
            type:'post',
            dateType:'json',
            async:false,
            url:'ajaxListAllDept',
            success:function (data) {
                var dept=data.resultList;
                console.log(dept);
                for(var i=0;i<dept.length;i++){
                    $("#riDept").append(
                        $("<option value='"+dept[i].d_id+"'>"+dept[i].d_name+"</option>")

                    )
                }
            }
        });
    }
   function change() {
       var deptId=$("#riDept").val();//获取以以及菜单的id
      // var tbody=window.document.getElementById("id2");//job选项框
       $("#id2").empty();
       $.ajax({
           type:'post',
           dataType:'json',
           url:'ajaxFindJobByDept',
           data:{
               d_id:deptId
           },
           success:function (data) {
               var job=data.resultJob;
               console.log(job);
               for(var i=0;i<job.length;i++){
                  $("#id2").append(
                      $("<option value='"+job[i].j_id+"'>"+job[i].j_name+"</option>")
                  )
               }
           }
       })
   }


</script>
</body>
</html>
