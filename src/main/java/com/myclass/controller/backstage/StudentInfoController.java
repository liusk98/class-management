package com.myclass.controller.backstage;

import com.myclass.entity.backstage.DataDictionary;
import com.myclass.entity.backstage.StudentInfo;
import com.myclass.entity.backstage.TeacherInfo;
import com.myclass.service.backstage.ClassInfoService;
import com.myclass.service.backstage.DataDictionaryService;
import com.myclass.service.backstage.StudentInfoService;
import com.myclass.tools.PageData;
import com.myclass.tools.TableParams;
import org.apache.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 学生信息表(StudentInfo)(Studentinfo)表控制层
 *
 * @author 蜀山剑仙
 * @since 2019-07-31 14:44:58
 */
@RestController("backstage/StudentInfoController")
@RequestMapping("backstage/studentInfo")
public class StudentInfoController {

    /**
     * 日志操作
     */
    private static Logger logger = Logger.getLogger(StudentInfoController.class);

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
        modelAndView.addObject("isEdit", false);
        modelAndView.addObject("title", "添加");
        return modelAndView;
    }

    @GetMapping("listStudentInfo.html")
    public ModelAndView listStudentInfo(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/teacher/listStudentInfo");
        DataDictionary dataDictionary = new DataDictionary();
        dataDictionary.setTypeCode("GRADE");
        dataDictionary.setIsenable(1);
        List<DataDictionary> listGrade = dataDictionaryService.listDataDictionaryByTypeCode(dataDictionary);
        modelAndView.addObject("listGrade", listGrade);
        return modelAndView;
    }

    /**
     * 功能描述:
     * 〈分页查询返回json数据〉
     *
     * @param tableParams
     * @return com.myclass.tools.PageData<com.myclass.entity.backstage.StudentInfo>
     * @author 蜀山剑仙
     * @date 2019/8/7 下午3:09
     */
    @PostMapping("studentInfo.json")
    public PageData<StudentInfo> jsonStudentInfo(@RequestBody TableParams<StudentInfo> tableParams) {
        PageData<StudentInfo> studentInfoPageData = studentInfoService.pageDataStudentInfo(tableParams.getData(),tableParams.getPageNumber(),tableParams.getPageSize(),tableParams.getSortName(),tableParams.getSortOrder());
        return studentInfoPageData;
    }

    /**
     * 功能描述:
     * 〈批量禁用多个学生〉
     *
     * @param arrStuNo
     * @return java.lang.String
     * @author 蜀山剑仙
     * @date 2019/8/7 下午3:08
     */
    @PostMapping("disable")
    public String batchDisable(@RequestParam(value = "arrStuNo[]") String[] arrStuNo) {
        return (studentInfoService.updateStatusBatch(0, arrStuNo)) ? "true" : "false";
    }

    /**
     * 功能描述:
     * 〈批量启用多个学生〉
     *
     * @param arrStuNo
     * @return java.lang.String
     * @author 蜀山剑仙
     * @date 2019/8/7 下午3:56
     */
    @PostMapping("enable")
    public String batchEnable(@RequestParam(value = "arrStuNo[]") String[] arrStuNo) {
        return (studentInfoService.updateStatusBatch(1, arrStuNo)) ? "true" : "false";
    }

    @PostMapping("insertStudentInfo.do")
    public ModelAndView insertStudentInfo(StudentInfo studentInfo, ModelAndView modelAndView, HttpServletRequest request) {
        TeacherInfo teacherInfo = (TeacherInfo) request.getSession().getAttribute("teacher");
        studentInfo.setCreateTeacher(teacherInfo);
        try {
            boolean insertStudent = studentInfoService.insertStudent(studentInfo);
            if (insertStudent) {
                modelAndView.addObject("msg", "创建成功!");
            } else {
                modelAndView.addObject("msg", "创建失败!");
            }
        } catch (DuplicateKeyException e) {
            logger.error("dup error:", e);
            modelAndView.addObject("msg", "创建失败,身份证号码不能重复!");
        } catch (Exception e) {
            logger.error("新增学生时 error:", e);
        }
        return insertStudentInfo(modelAndView);
    }

}