package com.myclass.service.impl;

import com.myclass.dao.ClassInfoMapper;
import com.myclass.dao.StudentInfoMapper;
import com.myclass.entity.ClassInfo;
import com.myclass.entity.StudentInfo;
import com.myclass.service.StudentInfoService;
import com.myclass.tools.SysConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;

/**
 * 学生信息表(StudentInfo)(Studentinfo)表服务实现类
 *
 * @author 蜀山剑仙
 * @since 2019-07-31 14:44:58
 */
@Service("studentInfoService")
public class StudentInfoServiceImpl implements StudentInfoService {
    @Resource
    private StudentInfoMapper studentInfoMapper;

    @Resource
    private ClassInfoMapper classInfoMapper;

    /**
     * 功能描述:
     * 〈新增一名学生〉
     *
     * @param studentInfo
     * @return boolean
     * @author 蜀山剑仙
     * @date 2019/7/31 下午4:41
     */
    @Override
    public boolean insertStudent(StudentInfo studentInfo) {
        //获取当前选择的班级信息
        ClassInfo classInfo = classInfoMapper.getClassInfo(studentInfo.getClassID());
        //前缀
        StringBuffer prefix = new StringBuffer();
        //年份
        prefix.append(Calendar.getInstance().get(Calendar.YEAR));
        //年级
        prefix.append(String.format("%02d", classInfo.getGradeID()));
        //班级
        prefix.append(String.format("%02d", classInfo.getId()));
        Integer maxStuNo = studentInfoMapper.getMaxStuNo(prefix.toString());
        String stuNo = prefix.append(String.format("%03d", ((maxStuNo == null) ? 1 : maxStuNo + 1))).toString();
        studentInfo.setStuNo(stuNo);
        studentInfo.setLoginName(stuNo);
        studentInfo.setPwd(SysConfig.getRestPwd());
        studentInfo.setStatus(1);
        return studentInfoMapper.insertStudentInfo(studentInfo) > 0;
    }

    /**
     * 功能描述:
     * 〈修改一名学生信息〉
     *
     * @param studentInfo
     * @return boolean
     * @author 蜀山剑仙
     * @date 2019/7/31 下午4:41
     */
    @Override
    public boolean updateStudent(StudentInfo studentInfo) {
        return studentInfoMapper.updateStudentInfo(studentInfo) > 0;
    }

    /**
     * 功能描述:
     * 〈获取一名学生信息〉
     *
     * @param studentInfo
     * @return com.myclass.entity.StudentInfo
     * @author 蜀山剑仙
     * @date 2019/7/31 下午4:42
     */
    @Override
    public StudentInfo getStudentInfo(StudentInfo studentInfo) {
        return studentInfoMapper.getStudentInfo(studentInfo);
    }

}