package com.dongyang.studyservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/list.do")
public class MemberListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDAO mdao = new MemberDAO();
        ArrayList<MemberDTO> mList = mdao.selectAll();
        request.setAttribute("vlist", mList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("memberList.jsp");
        dispatcher.forward(request,response);
    }
}
