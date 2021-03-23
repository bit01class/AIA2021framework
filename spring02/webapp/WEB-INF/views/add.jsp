<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

</head>
<body>
<!-- 상단메뉴 -->
<nav class="navbar navbar-default navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">
        비트교육센터
      </a>
    </div>
    <ul class="nav navbar-nav">
    	<li><a href="index.do">HOME</a></li>
    	<li><a href="intro.do">INTRO</a></li>
    	<li><a href="list.do">DEPT</a></li>
    </ul>
  </div>
</nav>
<!-- content -->
<div class="container">
	<div class="row">
	  <div class="col-xs-12">
	  <!-- 본문시작 -->
<ol class="breadcrumb">
  <li><a href="index.do">Home</a></li>
  <li><a href="list.do">DEPT</a></li>
  <li class="active">ADD</li>
</ol>
<div class="page-header">
  <h1>입력 페이지<small>DEPT 테이블 추가</small></h1>
</div>	

<form class="form-horizontal" action="insert.do" method="post">
  <div class="form-group">
    <label for="deptno" class="col-sm-2 control-label">deptno</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="deptno" id="deptno" placeholder="deptno">
    </div>
  </div>
  <div class="form-group">
    <label for="dname" class="col-sm-2 control-label">dname</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="dname" id="dname" placeholder="dname">
    </div>
  </div>
  <div class="form-group">
    <label for="loc" class="col-sm-2 control-label">loc</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="loc" id="loc" placeholder="loc">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">입력</button>
      <button type="reset" class="btn btn-default">취소</button>
    </div>
  </div>
</form>
	  <!-- 본문끝 -->
	  </div>
	</div>
	<div class="row">
	  <div class="col-xs-12 text-center">
	  Copyright &copy; 비트캠프 All rights reserved.
	  </div>
	</div>
</div>
</body>
</html>









