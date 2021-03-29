<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
<html>
<head>
	<title>Home</title>
	<meta charset="utf-8">
</head>
<body>
<h1>
	Hello world!  
</h1>

<form action="upload" method="post" enctype="multipart/form-data">
	<div>msg:<input type="text" name="msg"> </div>
	<div>file:<input type="file" name="file"> </div>
	<button>업로드</button>
</form>
</body>
</html>
