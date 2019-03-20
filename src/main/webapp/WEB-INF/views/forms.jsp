<%--
  Created by IntelliJ IDEA.
  User: nitin
  Date: 20/3/19
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>${heading}</h2>

<h2> Forms </h2>
<form action="/register" method="post">
    <h1>Form 1</h1>
    First Name: <input type="text" name="firstname">
    Last Name: <input type="text" name="lastname">
    <input type="submit">
</form>
<form action="/employee/register" method="post">
    <h1>Form 2</h1>
    First Name: <input type="text" name="firstname">
    Last Name: <input type="text" name="lastname">
    <input type="submit">
</form>

</body>
</html>
