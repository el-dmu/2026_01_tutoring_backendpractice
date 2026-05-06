package com.dongyang.studyservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login.do")
public class loginServet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init hi");

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // step 1. 파라미터 받음
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        MemberDTO mdto = new MemberDTO();
        mdto.setMemberid(id);
        mdto.setPassword(pw);

        MemberDAO mdao = new MemberDAO();
        boolean result = mdao.loginCheck(mdto);

        // step 2. JDBC
        if(result) {
            // 성공
            HttpSession session = request.getSession();
            session.setAttribute("userName", "김동양");
        }
        response.sendRedirect("loginForm.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
