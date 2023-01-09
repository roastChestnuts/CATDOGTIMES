package com.catdog.times.common.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.catdog.times.member.model.dto.Member;


public final class LoginCheckInterceptor extends HandlerInterceptorAdapter {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 컨트롤러 실행 전 작업
        // 반환값이 false일 경우 컨트롤러 실행 X
        Member loginMember = (Member) request.getSession().getAttribute("loginMember");
        
        if(loginMember == null) {
            request.setAttribute("msg", "로그인 후 이용이 가능합니다.");
            request.setAttribute("location", "/");
            request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
            
            return false;
        }

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // 컨트롤러가 실행된 후에 필요한 작업을 할 수 있는 메소드
        
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // 컨트롤러의 처리가 끝나고 화면 처리까지 모두 끝나면 실행
        
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 비동기 요청 시 postHandle(), afterCompletion() 수행 X afterConcurrentHandlingStarted() 메소드 호출
        
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
    
}