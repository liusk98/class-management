package com.myclass.controller;

import com.myclass.entity.TeacherInfo;
import com.myclass.service.TeacherInfoService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 教师表(TeacherInfo)(TeacherInfo)表控制层
 *
 * @author 蜀山剑仙
 * @since 2019-07-11 16:59:34
 */
@RestController
@RequestMapping("teacherinfo")
public class TeacherInfoController {

    private Logger logger = Logger.getLogger(TeacherInfoController.class);

    /**
     * 服务对象
     */
    @Resource
    private TeacherInfoService teacherInfoService;

    /**
     * 打开登录页面
     * @return 登录页面
     */
    @GetMapping("login.html")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("backstage/login");
        return modelAndView;
    }

    @PostMapping("login.do")
    public ModelAndView login(String loginName, String pwd, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("redirect:index.html");
        TeacherInfo teacherinfo = null;
        try {
            teacherinfo = teacherInfoService.login(loginName, pwd);
            if (teacherinfo == null) {
                modelAndView.setViewName("backstage/login");
                modelAndView.addObject("error", "用户名或密码错误!");
                return modelAndView;
            }
        } catch (Exception e) {
            logger.error("login.do error:", e);
        }
        request.getSession().setAttribute("teacher", teacherinfo);
        return modelAndView;
    }


    @RequestMapping("index.html")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/index");
        return modelAndView;
    }
}