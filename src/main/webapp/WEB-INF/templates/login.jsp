<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Security Example</title>
</head>
<body>
<c:if test="${param.error}">
    用户名或密码错
</c:if>
<c:if test="${param.logout}">
    您已注销成功
</c:if>
<form action="${basePath}/login" method="post">
    <div><label> 用户名 : <input type="text" name="username"/> </label></div>
    <div><label> 密 码 : <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="登录"/></div>
</form>
</body>
</html>