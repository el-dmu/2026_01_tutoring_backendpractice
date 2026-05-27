<%@ page import="java.lang.reflect.Member" %>
<%@ page import="com.dongyang.studyservlet.MemberDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%@ include file="header.jsp"%>
<h1>회원목록</h1>
    <%
        ArrayList<MemberDTO> mList = (ArrayList<MemberDTO>)request.getAttribute("vlist");
        if(mList == null || mList.isEmpty()){
            response.sendRedirect("index.jsp");
        } else {
    %>
        <table border = "1">
            <tr>
                <th>아이디</th>
                <th>비밀번호</th>
                <th>이름</th>
                <th>이메일</th>
            </tr>
    <%
        for(MemberDTO dto : mList){
    %>
            <tr>
                <td><%= dto.getMemberid()%></td>
                <td><%= dto.getPassword()%></td>
                <td><%= dto.getName()%></td>
                <td><%= dto.getEmail()%></td>

            </tr>
   <%
       }
   %>
        </table>
   <%
       }
   %>

</body>
</html>