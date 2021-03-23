<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/header.jspf" %>
</head>
<body>
<%@ include file="../template/menu.jspf" %>
<table class="table">
	<thead>
		<tr>
			<th>deptno</th>
			<th>dname</th>
			<th>loc</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="bean">
		<tr>
			<td><a href="dept.do?deptno=${bean.deptno }">${bean.deptno }</a></td>
			<td><a href="dept.do?deptno=${bean.deptno }">${bean.dname }</a></td>
			<td><a href="dept.do?deptno=${bean.deptno }">${bean.loc }</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<a href="#" class="btn btn-primary btn-block" role="button" data-toggle="modal" data-target="#myModal">입력</a>
<%@ include file="../template/footer.jspf" %>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">입력페이지</h4>
      </div>
      <form action="adddept.do" method="post">
      <div class="modal-body">
        <div class="form-group">
        	<label for="deptno">deptno</label>
        	<input type="text" class="form-control" name="deptno" id="deptno"/>
        </div>
        <div class="form-group">
        	<label for="dname">dname</label>
        	<input type="text" class="form-control" name="dname" id="dname"/>
        </div>
        <div class="form-group">
        	<label for="loc">loc</label>
        	<input type="text" class="form-control" name="loc" id="loc"/>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">입력</button>
      </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>






