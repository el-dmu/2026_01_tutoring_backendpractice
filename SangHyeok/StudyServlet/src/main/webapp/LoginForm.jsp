<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>로그인</h1>
<%
    String userName = (String)session.getAttribute("userName");

    if (userName != null) {


%>

<form action = "logout.do" method = "post">
    <input type = "submit" value="로그아웃">
</form>

<%
    } else {

%>

<form action = "login.do" method = "post">
    아이디: <input type="text" name="id" /><br />
    비밀번호: <input type="text" name="pw" /><br />
    <input type ="submit"><input type = "reset">
</form>

<%
    }
%>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>