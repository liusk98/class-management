package com.myclass.entity.backstage;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 操作记录表（OperateLog）
 * @author joe
 * @Date 2019/8/23
 */
public class OperateLog {

    /**
     * 日志记录号
     */
    private Integer id;

    /**
     * 操作者（学生）
     */
    private StudentInfo studentInfo;

    /**
     * 操作者（教师）
     */
    private TeacherInfo teacherInfo;

    /**
     * 操作时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 日志类型
     */
    private Integer logType;

    /**
     * 日志内容类型
     */
    private Integer contentType;

    /**
     * 日志描述
     */
    private String logDesc;

    /**
     * 操作者 IP 地址
     */
    private String logIP;

    /**
     * 操作结果
     */
    private String result;

    /**
     * 操作的学生对象
     */
    private StudentInfo objStudentInfo;

    /**
     * 操作的班级
     */
    private ClassInfo objClassInfo;

    /**
     * 备注
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public TeacherInfo getTeacherInfo() {
        return teacherInfo;
    }

    public void setTeacherInfo(TeacherInfo teacherInfo) {
        this.teacherInfo = teacherInfo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public String getLogDesc() {
        return logDesc;
    }

    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc;
    }

    public String getLogIP() {
        return logIP;
    }

    public void setLogIP(String logIP) {
        this.logIP = logIP;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public StudentInfo getObjStudentInfo() {
        return objStudentInfo;
    }

    public void setObjStudentInfo(StudentInfo objStudentInfo) {
        this.objStudentInfo = objStudentInfo;
    }

    public ClassInfo getObjClassInfo() {
        return objClassInfo;
    }

    public void setObjClassInfo(ClassInfo objClassInfo) {
        this.objClassInfo = objClassInfo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
