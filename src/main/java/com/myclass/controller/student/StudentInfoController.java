package com.myclass.controller.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author joe
 * @Date 2019/8/13
 */
@RestController("student/StudentInfoController")
@RequestMapping("student/studentInfo")
public class StudentInfoController {

    @GetMapping("edit.html")
    public ModelAndView edit(ModelAndView modelAndView) {
        modelAndView.setViewName("student/edit");
        return modelAndView;
    }
}
