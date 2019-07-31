package com.myclass.controller;

import com.myclass.entity.ClassInfo;
import com.myclass.entity.DataDictionary;
import com.myclass.entity.TeacherInfo;
import com.myclass.service.ClassInfoService;
import com.myclass.service.DataDictionaryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 班级表(ClassInfo)(ClassInfo)表控制层
 *
 * @author makejava
 * @since 2019-07-29 16:23:08
 */
@RestController
@RequestMapping("backstage/classInfo")
public class ClassInfoController {
    /**
     * 服务对象
     */
    @Resource
    private ClassInfoService classInfoService;

    /**
     * 服务对象
     */
    @Resource
    private DataDictionaryService dataDictionaryService;

    @GetMapping("insertClassInfo.html")
    public ModelAndView insertClassInfo(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/teacher/insertClassInfo");
        DataDictionary dataDictionary = new DataDictionary();
        dataDictionary.setTypeCode("GRADE");
        dataDictionary.setIsenable(1);
        List<DataDictionary> listGrade = dataDictionaryService.listDataDictionaryByTypeCode(dataDictionary);
        modelAndView.addObject("listGrade", listGrade);
        modelAndView.addObject("isEdit", false);
        modelAndView.addObject("title", "新增");
        return modelAndView;
    }

    @GetMapping("listClassInfo.html")
    public ModelAndView listClassInfo(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/teacher/listClassInfo");
        return modelAndView;
    }

    @PostMapping("insertClassInfo.do")
    public ModelAndView insertClassInfo(ClassInfo classInfo, ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.setViewName("backstage/teacher/insertClassInfo");
        // 获取创建人信息
        TeacherInfo teacherInfo = (TeacherInfo) request.getSession().getAttribute("teacher");
        if (teacherInfo == null) {
            return insertClassInfo(modelAndView);
        }
        classInfo.setCreateTeacher(teacherInfo);
        boolean result = classInfoService.insertClassInfo(classInfo);
        if (result) {
            modelAndView.addObject("msg", "创建成功");
            modelAndView.addObject("classInfo", new ClassInfo());
        } else {
            modelAndView.addObject("msg", "创建失败");
        }
        return insertClassInfo(modelAndView);
    }

}