<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index page</h1>
	<c:forEach items="${list }" var="bean">
	<p>${bean }</p>
	</c:forEach>
	<a href="add.bit">입력</a>
</body>
</html>







