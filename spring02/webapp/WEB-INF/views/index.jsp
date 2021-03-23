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
	  <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
	  <!-- Indicators -->
	  <ol class="carousel-indicators">
	    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
	  </ol>
	
	  <!-- Wrapper for slides -->
	  <div class="carousel-inner" role="listbox">
	    <div class="item active">
	    	<img alt="" src="imgs/visual1.jpg">
	    </div>
	    <div class="item">
	    	<img alt="" src="imgs/visual2.jpg">
	    </div>
	    <div class="item">
	    	<img alt="" src="imgs/visual3.jpg">
	    </div>
	  </div>
	
	  <!-- Controls -->
	  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
	    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
	    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>
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









