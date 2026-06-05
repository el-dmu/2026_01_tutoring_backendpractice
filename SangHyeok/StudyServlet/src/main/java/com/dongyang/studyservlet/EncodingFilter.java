package com.dongyang.studyservlet;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*") //모든 파일들이 필터를 거치는 상황 (와일드 카드) -> ( ) 수정에따라 어느 경로에따라 필터를 적용할지 결정 가능
public class EncodingFilter extends HttpFilter {
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.err.println("필터 시작");
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.err.println("doFilter 호출");
        request.setCharacterEncoding("UTF-8"); // 인코딩 설정
        long begin = System.currentTimeMillis();
        chain.doFilter(request,response); // 해당 코드 기준으로 이전의 코드들은 request 요청떄 실행이지만 다음 코드들은 response 요청떄 실행
        long end = System.currentTimeMillis();
        System.out.println("작업시간 : " + (end - begin) + "ms 소요되었습니다.");
    }

    @Override
    public void destroy() {
       System.err.println("필터 끝");
    }


}
