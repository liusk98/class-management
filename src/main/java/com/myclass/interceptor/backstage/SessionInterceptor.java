package com.myclass.interceptor.backstage;

import com.myclass.entity.backstage.TeacherInfo;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SessionInterceptor
 * 用于拦截session中的一些操作
 *
 * @author joe
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TeacherInfo teacherInfo = (TeacherInfo) request.getSession().getAttribute("teacher");
        if (teacherInfo == null) {
            String backUri = request.getServletPath();
            response.sendRedirect(String.valueOf(request.getContextPath()) + "/loginTeacherInfo.html?backUri="+backUri);
            return false;
        }
        return true;
    }
}
