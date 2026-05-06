<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%
    String userName = (String)request.getAttribute("userName");

%>
<h1><%= userName %> 로그인 성공.</h1>
</body>
</html>