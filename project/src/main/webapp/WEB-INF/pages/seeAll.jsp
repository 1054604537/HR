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
    <title>三级联动</title>

</head>
<body>
<div>
    <select id="riDept" >

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
    $(document).ready(function () {
        $("#riDept").bind( "Change",function (n) {
            alert("11111111");
            $.ajax({
                type:'post',
                dataType:'json',
                data:{"d_id":n},
                async:false,
                url:'ajaxFindJobByDept',
                success:function (data) {
                    var job=data.result.jobs;
                    console.log(job);
                    $("#id2").bind({
                        data:job,
                        valueField:'j_id',
                        textField:'j_name'
                    })
                }
            })

        })

    })



</script>
</body>
</html>
