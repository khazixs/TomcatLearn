<%--
  Created by IntelliJ IDEA.
  User: ZQ
  Date: 2019/11/20
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="demo" method="post">
    <input type="text" name="name"/>
    <input type="text" name="age"/>
    <input type="checkbox" name="hover" value="学习">
    <input type="checkbox" name="hover" value="写代码">
    <input type="checkbox" name="hover" value="练习">
    <input type="submit" value="提交"/>
</form>
<br/>
<form action="demo2" method="post">
    <input type="text" name="people[0].name"/>
    <input type="text" name="people[0].age"/>
    <br/>
    <input type="text" name="people[1].name"/>
    <input type="text" name="people[1].age"/>
    <input type="submit" value="提交"/>
</form>
<br/>
<a href="demo3/李哥/23">跳转啊</a>

<hr/>
<a href="download">下载</a>

<form action="upload" enctype="multipart/form-data" method="post">
    name:<input type="text" name="name"/>
    file:<input type="file" name="file"/>
    <input type="submit" value="submit">
</form>
</body>
</html>
