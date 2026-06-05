package com.dongyang.studyservlet;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//경로에 따라 호출 지정 가능
@WebFilter("/*")
public class EncodingFilter extends HttpFilter {
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.err.println("필터 시작");
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.err.println("---- doFilter 호출");
        request.setCharacterEncoding("UTF-8"); //얘로 인코딩 설정
        long begin = System.currentTimeMillis();

        chain.doFilter(request, response); //얘를 기점으로 요청과 응답 나눠짐

        long end = System.currentTimeMillis();
        System.out.println("작업시간" + (end - begin) + "ms");
    }

    @Override
    public void destroy() {
        System.err.println("---- 필터 끝");
    }
}
