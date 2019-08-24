package com.myclass.advice;

import com.myclass.dao.backstage.OperateLogMapper;
import com.myclass.entity.backstage.OperateLog;
import com.myclass.entity.backstage.StudentInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author joe
 * @Date 2019/8/23
 */
@Aspect
@Component
public class LogAdvice {

    @Resource
    OperateLogMapper operateLogMapper;

    @Around(value = "execution(* com.myclass.service.backstage.StudentInfoService.login(..))")
    public Object loginLog(ProceedingJoinPoint proceedingJoinPoint) {
        StudentInfo studentInfo = null;
        try {
            studentInfo = (StudentInfo) proceedingJoinPoint.proceed();
            if (studentInfo != null) {
                OperateLog operateLog = new OperateLog();
                operateLog.setStudentInfo(studentInfo);
                operateLog.setLogType(2);
                operateLog.setContentType(1);
                operateLog.setLogDesc(studentInfo.getName() + "进行了登录");
                operateLogMapper.insertOperateLog(operateLog);
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return studentInfo;
    }
}
