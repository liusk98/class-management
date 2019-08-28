package com.myclass.controller.backstage;

import com.myclass.entity.backstage.OperateLog;
import com.myclass.entity.backstage.StudentInfo;
import com.myclass.service.backstage.OperateLogService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author joe
 * @Date 2019/8/28
 */
@RestController
@RequestMapping("operate")
public class OperateLogController {

    private Logger logger = Logger.getLogger(OperateLogController.class);

    @Resource
    private OperateLogService operateLogService;

    @RequestMapping("query")
    public List<OperateLog> query(OperateLog operateLog, String stuNo, HttpServletRequest request) {
        StudentInfo studentInfo = null;
        if (stuNo == null || stuNo == "") {
            studentInfo = (StudentInfo) request.getSession().getAttribute("student");
        } else {
            studentInfo = new StudentInfo();
            studentInfo.setStuNo(stuNo);
        }
        operateLog.setStudentInfo(studentInfo);
        operateLog.setObjStudentInfo(studentInfo);
        return operateLogService.queryOperateLog(operateLog);
    }
}
