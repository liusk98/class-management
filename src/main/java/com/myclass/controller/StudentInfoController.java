package com.myclass.controller;

import com.myclass.service.StudentInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 学生信息表(StudentInfo)(Studentinfo)表控制层
 *
 * @author 蜀山剑仙
 * @since 2019-07-31 14:44:58
 */
@RestController
@RequestMapping("backstage/studentInfo")
public class StudentInfoController {
    /**
     * 服务对象
     */
    @Resource
    private StudentInfoService studentInfoService;

    @GetMapping("insertStudentInfo.html")
    public ModelAndView insertStudentInfo(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/teacher/insertStudentInfo");
        return modelAndView;
    }

    @GetMapping("listStudentInfo.html")
    public ModelAndView listStudentInfo(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/teacher/listStudentInfo");
        return modelAndView;
    }
}