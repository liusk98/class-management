package com.myclass.service.impl;

import com.myclass.dao.StudentInfoMapper;
import com.myclass.entity.StudentInfo;
import com.myclass.service.StudentInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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