package com.dongyang.studyservlet;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*")
public class EncodingFilter extends HttpFilter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.err.println("필터 시작");
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.err.println("-------doFilter 호출------");
        request.setCharacterEncoding("UTF-8");
        long begin = System.currentTimeMillis();

        chain.doFilter(request, response);

        long end = System.currentTimeMillis();
        System.out.println("작업 시간:" + (end - begin) + "ms");
    }

    @Override
    public void destroy() {
        System.err.println("-----필터 끝");
    }
}
