package com.example.schedulemanagement2.filter;

import com.example.schedulemanagement2.constant.SessionConst;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

public class LoginFilter implements Filter {

    private static final String[] WHITE_LIST = {"/", "/users", "/session-login"};

    private boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        System.out.println("요청 URI: " + requestURI);


        if(!isWhiteList(requestURI)) {
            HttpSession session = httpRequest.getSession(false);

            if(session == null || session.getAttribute(SessionConst.USER) == null) {
                throw new RuntimeException("로그인 해주세요.");
            }

        }

        filterChain.doFilter(request, response);

    }
}
