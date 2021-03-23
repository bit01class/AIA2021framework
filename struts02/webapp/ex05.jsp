<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>입력페이지</h1>
	<form action="ex06.action">
		<div>
			<label for="id">id</label>
			<input type="text" name="id">
		</div>
		<div>
			<label for="age">age</label>
			<input type="text" name="age" min="1" max="80" value="20">
		</div>
		<div>
			<button>입력</button>
		</div>
	</form>
</body>
</html>




