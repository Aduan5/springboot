<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello World!</title>
</head>
<body>
<h1>Hello ${httpServletRequest.remoteUser}</h1>
<form action="${BasePath}/logout" method="post">
    <input type="submit" value="注销"/>
</form>
</body>
</html>