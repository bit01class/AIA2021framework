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
<script type="text/javascript">
var del=function(){
	var options={show:true};
	$('#myModal').modal(options);
};
$(function(){
	$('form:eq(0)').one('submit',function(){
		$('.page-header>h1')
					.html($('.page-header>h1')
					.html()
					.replace('상세','수정'));
		$('form:eq(0) button[type="button"]')
					.off('click',del)
					.attr('type','reset')
					.text("취소")
					.removeClass('btn-danger')
					.addClass('btn-default');
		$('form:eq(0) input').filter(':gt(0)').removeProp('readonly');
		return false;
	});
	$('form:eq(0) button[type="button"]').on('click',del);
	
});
</script>
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
  <li class="active">${bean.deptno }번</li>
</ol>
<div class="page-header">
  <h1>상세 페이지<small>${bean.deptno }번의 결과</small></h1>
</div>	

<form class="form-horizontal" action="update.do" method="post">
  <div class="form-group">
    <label for="deptno" class="col-sm-2 control-label">deptno</label>
    <div class="col-sm-10">
      <input type="text" value="${bean.deptno }" class="form-control" name="deptno" id="deptno" placeholder="deptno" readonly="readonly">
    </div>
  </div>
  <div class="form-group">
    <label for="dname" class="col-sm-2 control-label">dname</label>
    <div class="col-sm-10">
      <input type="text" value="${bean.dname }" class="form-control" name="dname" id="dname" placeholder="dname" readonly="readonly">
    </div>
  </div>
  <div class="form-group">
    <label for="loc" class="col-sm-2 control-label">loc</label>
    <div class="col-sm-10">
      <input type="text" value="${bean.loc }" class="form-control" name="loc" id="loc" placeholder="loc" readonly="readonly">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">수정</button>
      <button type="button" class="btn btn-danger">삭제</button>
    </div>
  </div>
</form>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <form class="modal-content" action="delete.do" method="post">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">${bean.deptno }번을 삭제하시겠습니까?</h4>
        <input type="hidden" name="idx" value="${bean.deptno }">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">아니오</button>
        <button type="submit" class="btn btn-danger">예</button>
      </div>
    </form>
  </div>
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









