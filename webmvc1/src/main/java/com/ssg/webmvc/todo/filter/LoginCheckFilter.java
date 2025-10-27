package com.ssg.webmvc.todo.filter;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/todo/*"})
@Log4j2
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("Login do filter **********************");


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();

        if(session.getAttribute("loginInfo") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}

// Filter 인테페이스 사용  servlet.Filter
// Filter 인터페이스는 doFilter() 추상 메서드 => 필터가 필터링이 필요한 로직 구현하는 부분이다.
//@WebFilter 특정 경로를 지정해서 해당 결로로 요청(request)에 대해서 doFilter() 를 실행하는 구조
// LoginCheckFilter는 /todo/* 브라우저에서 /todo로 시작하는 하위 url 경로에 대하여 필터링을 수행 하겠다는 의미








