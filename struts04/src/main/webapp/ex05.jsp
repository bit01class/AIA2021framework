<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>struts jstl</h1>
	<s:form action="ex05" method="post">
		<s:textfield name="deptno" label="deptno"></s:textfield>
		<s:textfield name="dname" label="dname"></s:textfield>
		<s:textfield name="loc" label="loc"></s:textfield>
		<s:submit></s:submit>
	</s:form>
</body>
</html>







