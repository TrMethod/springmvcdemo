<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 肖晖
  Date: 2019/6/28
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加员工</title>
</head>
<body>
  <from:form action="/addUser" method="post" modelAttribute="user">
      <%--path 等于name属性--%>
      姓名：<form:input path="username" /><br>
      <%
          Map<String,Integer> sexs=new HashMap<>();
          sexs.put("1",1);
          sexs.put("0",0);
          request.setAttribute("sexs",sexs);

      %>
      性别：<from:radiobuttons path="sex" items="${sexs}"/><br>
      生日：<from:input path="birthday"/><br>
      <input type="submit" value="提交">
  </from:form>
  <br><br>

  <form action="/addUser" method="post">
      名字：<input type="text" name="username"><br>
      生日：<input type="text" name="birthday"> <br>
      <input type="submit" value="提交">
  </form>
  <br><<br>


</body>
</html>
