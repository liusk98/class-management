package com.myclass.controller.backstage;

import com.myclass.entity.backstage.TeacherInfo;
import com.myclass.service.backstage.TeacherInfoService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * mainController
 *
 * @author joe
 * @Date 19-7-23
 */
@RestController
public class BackstageMainController {

    private Logger logger = Logger.getLogger(BackstageMainController.class);

    /**
     * 服务对象
     */
    @Resource
    private TeacherInfoService teacherInfoService;

    /**
     * 打开登录页面
     *
     * @return 登录页面
     */
    @GetMapping("loginTeacherInfo.html")
    public ModelAndView login(String backUri, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("backstage/login");
        request.getSession().invalidate();
        request.getSession().setAttribute("backUri", backUri);
        return modelAndView;
    }

    @PostMapping("loginTeacherInfo.do")
    public ModelAndView login(String loginName, String pwd, HttpServletRequest request, ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:indexTeacherInfo.html");
        TeacherInfo teacherInfo = null;
        try {
            teacherInfo = teacherInfoService.login(loginName, pwd);
            if (teacherInfo == null) {
                modelAndView.setViewName("backstage/login");
                modelAndView.addObject("error", "用户名或密码错误!");
                return modelAndView;
            }
            String backUri = (String) request.getSession().getAttribute("backUri");
            if (backUri != null) {
                modelAndView.setViewName("redirect:" + backUri);
            }
        } catch (Exception e) {
            logger.error("login.do error:", e);
            modelAndView.setViewName("backstage/login");
            modelAndView.addObject("error", e.getMessage());
        }
        request.getSession().setAttribute("teacher", teacherInfo);
        return modelAndView;
    }


    @RequestMapping("indexTeacherInfo.html")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/index");
        return modelAndView;
    }
}
