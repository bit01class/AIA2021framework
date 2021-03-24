<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='${pageContext.request.contextPath }/webjars/bootstrap/3.4.1/css/bootstrap.min.css'>
<script src="${pageContext.request.contextPath }/webjars/jquery/1.12.4/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath }/webjars/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
<script type="text/javascript">

$(function(){
	$('form:eq(0)').find(":button").click(function(){
		if($(this).text()=='수 정'&&$(this).next().text()=='삭 제'){
			$('form:eq(0)').find("input")
				.filter(":gt(1)").removeProp('readonly');
			$(this).next().attr('type','reset').text('취 소');
		}else if($(this).text()=='수 정'){
			$('form:eq(0)').submit();
		}else if($(this).text()=='삭 제'){
			$(':hidden').val('delete');
			$('form:eq(0)').submit();
		}
	});
});

</script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath }">
        비트교육센터
      </a>
    </div>
    <ul class="nav navbar-nav">
    	<li><a href="${pageContext.request.contextPath }/">HOME</a></li>
    	<li><a href="${pageContext.request.contextPath }/dept/">DEPT</a></li>
    	<li><a href="${pageContext.request.contextPath }/login/">LOGIN</a></li>
    </ul>
  </div>
</nav>
<div class="container">
	<div class="jumbotron">
	  <h1>${bean.deptno }번 page!</h1>
	  <p>...</p>
	</div>
	<form class="form-horizontal" method="post">
		<input type="hidden" name="_method" value="put">
	  <div class="form-group">
	    <input type="text" value="${bean.deptno }" name="deptno" placeholder="deptno" class="form-control" readonly="readonly" />
	  </div>
	  <div class="form-group">
	    <input type="text" value="${bean.dname }" name="dname" placeholder="dname" class="form-control" readonly="readonly"/>
	  </div>
	  <div class="form-group">
	    <input type="text" value="${bean.loc }" name="loc" placeholder="loc" class="form-control" readonly="readonly" />
	  </div>
	  <div class="form-group">
	    <button type="button">수 정</button>
	    <button type="button">삭 제</button>
	  </div>
	</form>
</div>
</body>
</html>




























