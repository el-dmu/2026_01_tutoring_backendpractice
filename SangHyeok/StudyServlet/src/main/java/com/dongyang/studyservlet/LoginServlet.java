package com.dongyang.studyservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init hi");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 파라미터 받음
        String id = request.getParameter(  "id");
        String pw = request.getParameter(  "pw");

        // 2. JDBC
        if(id.equals("dong") && pw.equals("123")) {
            // 조건 충족시 (성공)
            request.setAttribute("userName", "김동양");
            RequestDispatcher dispatcher = request.getRequestDispatcher("loginOK.jsp");
            dispatcher.forward(request, response);
        }else{
            //실패
            response.sendRedirect("loginFail.jsp");
        }



    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
