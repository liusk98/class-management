package com.myclass.controller;

import com.myclass.entity.ClassInfo;
import com.myclass.entity.DataDictionary;
import com.myclass.service.ClassInfoService;
import com.myclass.service.DataDictionaryService;
import com.myclass.service.StudentInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

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

    @GetMapping("insertStudentInfo.html")
    public ModelAndView insertStudentInfo(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/teacher/insertStudentInfo");
        DataDictionary dataDictionary = new DataDictionary();
        dataDictionary.setTypeCode("GRADE");
        dataDictionary.setIsenable(1);
        List<DataDictionary> listGrade = dataDictionaryService.listDataDictionaryByTypeCode(dataDictionary);
        modelAndView.addObject("listGrade", listGrade);
        modelAndView.addObject("isEdit", true);
        modelAndView.addObject("title", "修改");
        return modelAndView;
    }

    @GetMapping("listStudentInfo.html")
    public ModelAndView listStudentInfo(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/teacher/listStudentInfo");
        return modelAndView;
    }


}