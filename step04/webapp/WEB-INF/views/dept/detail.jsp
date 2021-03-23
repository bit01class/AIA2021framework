<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/header.jspf" %>
<script type="text/javascript">
	$(function(){
		$('form').one('submit',function(){
			$('form').find('input').each(function(idx,ele){
				if(idx!=0) $(ele).removeProp('readonly');
			});
			return false;
		});
		if('${param.alert}'){
			$('.alert').show();
			setTimeout(function(){
				$('.alert').hide();
			}, 3000);
		}else{
			$('.alert').hide();
		}
	});
</script>
</head>
<body>
<div class="alert alert-${param.alert} alert-dismissible" role="alert">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <strong>Warning!</strong> Better check yourself, you're not looking too good.
</div>
<div class="container">
	<ul class="nav nav-tabs">
	  <li role="presentation"><a href="../index.bit">Home</a></li>
	  <li role="presentation"><a href="../intro.bit">Intro</a></li>
	  <li role="presentation" class="active"><a href="list.bit">Dept</a></li>
	</ul>
	<form action="edit.bit" method="post">
	  <div class="form-group">
	    <label for="deptno">deptno</label>
	    <input type="text" class="form-control" id="deptno" name="deptno" placeholder="dentno" value="${bean.deptno }" readonly="readonly">
	  </div>
	  <div class="form-group">
	    <label for="dname">dname</label>
	    <input type="text" class="form-control" id="dname" name="dname" placeholder="dname" value="${bean.dname }" readonly="readonly">
	  </div>
	  <div class="form-group">
	    <label for="loc">loc</label>
	    <input type="text" class="form-control" id="loc" name="loc" placeholder="loc" value="${bean.loc }" readonly="readonly">
	  </div>
	  <button type="submit" class="btn btn-default">수정</button>
	  <a class="btn btn-danger" role="button" href="delete.bit?idx=${bean.deptno }">삭제</a>
	</form>
</div>
</body>
</html>





