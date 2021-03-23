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
<form action="ex05.bit" method="post">
	<div>
		<label for="deptno">deptno</label>
		<input type="text" id="deptno" name="deptno" value="${deptno }" />
	</div>
	<div>
		<label for="dname">dname</label>
		<input type="text" id="dname" name="dname" value="${dname }" />
		${fieldErrors.dname }
	</div>
	<div>
		<label for="loc">loc</label>
		<input type="text" id="loc" name="loc" value="${loc }" />
		${fieldErrors.loc }
	</div>
	<div>
		<button>전달</button>
	</div>
</form>
</body>
</html>







