<%--
  Created by IntelliJ IDEA.
  User: Vsion
  Date: 2019/7/15
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript">
    var getting = {
        type: "GET",
        url: "http://fundgz.1234567.com.cn/js/519983.js?rt=1463558676006",
        //data: {result:$(".left>h3").val()},
        dataType:"json",
        success: function (result) {
            res = eval(result);
            console.log(res);

        }
    };
    window.setInterval(function(){$.ajax(getting)},5000);
</script>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
