<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<h3>메뉴:
    <%
        String userName = (String)session.getAttribute("userName");
        String menu = null;
        //로그인 됐을때
        if (userName != null){
            menu = "<a href = edit.jsp>마이 페이지</a>" +  "<a href = list.do>회원목록</a>";
        } else {
            menu = "<a href = LoginForm.jsp>로그인</a>";
        }
    %>

    <%=menu%>

</h3>
</html>

