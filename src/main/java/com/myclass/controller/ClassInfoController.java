package com.myclass.controller;

import com.myclass.entity.ClassInfo;
import com.myclass.entity.DataDictionary;
import com.myclass.entity.TeacherInfo;
import com.myclass.service.ClassInfoService;
import com.myclass.service.DataDictionaryService;
import com.myclass.tools.PageData;
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

    @GetMapping("updateClassInfo.html/{id}")
    public ModelAndView updateClassInfo(@PathVariable Integer id, ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/teacher/insertClassInfo");
        DataDictionary dataDictionary = new DataDictionary();
        dataDictionary.setTypeCode("GRADE");
        dataDictionary.setIsenable(1);
        List<DataDictionary> listGrade = dataDictionaryService.listDataDictionaryByTypeCode(dataDictionary);
        ClassInfo classInfo = classInfoService.getClassInfo(id);
        modelAndView.addObject("classInfo", classInfo);
        modelAndView.addObject("listGrade", listGrade);
        modelAndView.addObject("isEdit", true);
        modelAndView.addObject("title", "修改");
        return modelAndView;
    }

    @GetMapping("listClassInfo.html")
    public ModelAndView listClassInfo(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/teacher/listClassInfo");
        return modelAndView;
    }

    @GetMapping("classInfo.json")
    public PageData<ClassInfo> getTeachers(Integer gradeID,String sort, String order, int offset, int limit) {
        // 每页条数
        int pageSize = limit;
        // 当前页码
        int pageIndex = offset / limit + 1;
        PageData<ClassInfo> classInfoPageData = classInfoService.pageDataClassInfo(gradeID,pageIndex, pageSize, sort, order);
        return classInfoPageData;
    }

    @GetMapping("listClassInfo.json")
    public List<ClassInfo> listClassInfo(Integer gradeId) {
        ClassInfo classInfo = new ClassInfo();
        classInfo.setGradeID(gradeId);
        List<ClassInfo> listClassInfo = classInfoService.listClassInfo(classInfo);
        return listClassInfo;
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

    @PostMapping("updateClassInfo.do")
    public ModelAndView updateClassInfo(ClassInfo classInfo, ModelAndView modelAndView) {
        boolean result = classInfoService.updateClassInfo(classInfo);
        if (result) {
            modelAndView.addObject("msg", "修改成功");
        } else {
            modelAndView.addObject("msg", "修改失败");
        }
        return updateClassInfo(classInfo.getId(), modelAndView);
    }

}