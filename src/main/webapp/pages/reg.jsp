<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register</title>
</head>
<body>
<body><h1>Register</h1>
<form action="addUser">
    <input type="text" name="username"><br>
    <input type="text" name="password"><br>
    <input type="submit"><br>
</form>
<h3>${errorMsg}</h3>
</body>
</html>