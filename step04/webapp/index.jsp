<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	location.href="index.bit";
</script>
</head>
<body>
	<c:set value="${'환영합니다'}" var="msg"></c:set>
	<h1><c:out value="${msg }"></c:out></h1>
</body>
</html>