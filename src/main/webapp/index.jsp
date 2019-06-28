<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h2>Hello World!</h2>

<a href="/exception">测试异常处理</a><br>

文件上传
<form action="/submitFile" method="post" enctype="multipart/form-data">
    file:<input type="file" name="file"><<br>
    描述<input type="text" name="desc"><br>
    <input type="submit" value="提交">
</form>

<a href="/testJSONDownLoad">testJSONDownLoad文件下载</a><br>

<a href="/testJson">/testJson</a><br>
<a href="/toAdd">添加页面</a><br>
<a href="/forward">forward</a><br>

<a href="/testRedirect">/testRedirect</a><br>

<a  href="/abc" >不经过controller</a><br>

<a href="/viewTest">分析视图时什么鬼</a>

<form action="/testModelAttribute" method="post">
    <input type="hidden" name="id" value="1">
    <input type="text" name="username">
    <input type="submit" value="testModelAttribute">
</form>

<a href="/testSessionAttributes">testSessionAttributes</a>
<a href="/testModelAndView">testModelAndView</a>

<a href="/hello" >hello</a><br><br>
<a href="/page" >a</a><br><br>
<h1>RequestMappingDemoController</h1>
<a href="/paramTest?name=tom">@RequestMapping(value = "/paramTest?name=tom",params = {"name=tom"})</a><br>
<a href="/requestParam?name=王二">@requestParam注解绑定请求参数</a><br>
<a href="/cookie">@CookieValue注解</a><br>
<h3>put请求测试</h3>
<form action="/put/1" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="submit">
</form>
<h3>delete请求测试</h3>
<form action="/delete" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="submit">
</form>
<h3>post请求测试</h3>
<form action="/post" method="post">
    姓名：<input name="username"><br>
    性别：<input name="sex"><br>
    <%--生日：<input name="birthday"><br>--%>
    地址：<input name="address"><br>
    部门编号：<input name="pId"><br>
    <input type="submit" value="post请求测试">
</form>


</body>
</html>
