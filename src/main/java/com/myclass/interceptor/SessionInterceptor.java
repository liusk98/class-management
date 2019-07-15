package com.myclass.interceptor;

import com.myclass.entity.TeacherInfo;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SessionInterceptor
 * 用于拦截session中的一些操作
 * @author joe
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TeacherInfo teacherInfo = (TeacherInfo)request.getSession().getAttribute("teacher");
        if (teacherInfo == null) {
            response.sendRedirect(String.valueOf(request.getContextPath()) + "/teacherinfo/login.html");
            return false;
        }
        return true;
    }
}
