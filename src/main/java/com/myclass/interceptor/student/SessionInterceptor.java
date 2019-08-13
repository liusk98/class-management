package com.myclass.interceptor.student;

import com.myclass.entity.backstage.StudentInfo;
import com.myclass.entity.backstage.TeacherInfo;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author joe
 * @Date 2019/8/13
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StudentInfo studentInfo = (StudentInfo) request.getSession().getAttribute("student");
        if (studentInfo == null) {
            String backUri = request.getServletPath();
            response.sendRedirect(String.valueOf(request.getContextPath()) + "/loginStudentInfo.html?backUri="+backUri);
            return false;
        }
        return true;

    }
}
