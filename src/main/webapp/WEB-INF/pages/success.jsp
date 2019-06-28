<%--
  Created by IntelliJ IDEA.
  User: 肖晖
  Date: 2019/6/28
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>成功</h1>
${name}<br>
request.user:${requestScope.user }<br>
request.company:${requestScope.company }<br>
session.user:${sessionScope.user }<br>
session.company:${sessionScope.company }<br>
</body>
</html>
