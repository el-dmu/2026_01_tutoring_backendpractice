<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대학소개</title>
</head>
<body>
<%@ include file="header.jsp" %>

<form action="filter.do" method="post">
	이름 : <input type="text" name="name"><br>
	주소 : <input type="text" name="add"><br>
	<input type="submit">
</form>

</body>
</html>