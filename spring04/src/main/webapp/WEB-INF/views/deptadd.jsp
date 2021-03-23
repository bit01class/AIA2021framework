<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
</head>
<body>


<div class="container">
	<div class="row">
		<div class="col-sm-12">
			비트교육센터
		</div>
	</div>	
	<div class="row">
		<div class="col-sm-3">&nbsp;</div>
		<div class="col-sm-2">
			<a href="../index.do">HOME</a>
		</div>
		<div class="col-sm-2">
			<a href="list.do">DEPT</a>
		</div>
		<div class="col-sm-2">
			<a href="../list.do">EMP</a>
		</div>
		<div class="col-sm-3">&nbsp;</div>
	</div>	
	<div class="row">
		<div class="col-sm-12">
			<h2>dept add</h2>
			<form action="insert.do" method="post">
				<div class="form-group">
					<label for="deptno">deptno</label>${deptno }
					<input type="text" name="deptno" id="deptno"  class="form-control" />
				</div>
				<div class="form-group">
					<label for="dname">dname</label>${dname }
					<input type="text" name="dname" id="dname"  class="form-control" />
				</div>
				<div class="form-group">
					<label for="loc">loc</label>${loc }
					<input type="text" name="loc" id="loc"  class="form-control"/>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-default">입력</button>
					<button type="reset" class="btn btn-default">취소</button>
				</div>
			</form>
		</div>
	</div>	
</div>
</body>
</html>