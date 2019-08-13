package com.myclass.controller.student;

import com.myclass.entity.backstage.StudentInfo;
import com.myclass.service.backstage.StudentInfoService;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author joe
 * @Date 2019/8/13
 */
@RestController("student/StudentInfoController")
@RequestMapping("student/studentInfo")
public class StudentInfoController {

    private Logger logger = Logger.getLogger(StudentInfoController.class);

    @Resource
    private StudentInfoService studentInfoService;

    @GetMapping("edit.html")
    public ModelAndView edit(ModelAndView modelAndView) {
        modelAndView.setViewName("student/edit");
        return modelAndView;
    }

    @PostMapping("uploadHead")
    public String upload(MultipartFile fileHead, HttpServletRequest request) {
        StudentInfo studentInfo = (StudentInfo) request.getSession().getAttribute("student");
        File saveFile = new File(request.getSession().getServletContext().getRealPath("WEB-INF/statics/images/head"),
                studentInfo.getStuNo() + "temp." + FilenameUtils.getExtension(fileHead.getOriginalFilename()));
        try {
            StudentInfo uploadHeadTemp = new StudentInfo();
            uploadHeadTemp.setStuNo(studentInfo.getStuNo());
            uploadHeadTemp.setHeadTemp(saveFile.getName());
            boolean flag = studentInfoService.updateStudent(uploadHeadTemp);
            fileHead.transferTo(saveFile);
        } catch (IOException e) {
            logger.error("上传头像失败:" + e);
        } catch (Exception e) {
            logger.error("error:" + e);
        }
        return "success";
    }
}
