package com.myclass.service.backstage;

import com.myclass.entity.backstage.StudentInfo;

/**
 * 学生信息表(StudentInfo)(Studentinfo)表服务接口
 *
 * @author 蜀山剑仙
 * @since 2019-07-31 14:44:58
 */
public interface StudentInfoService {

    /**
     * 功能描述:
     * 〈新增一名学生〉
     *
     * @param studentInfo
     * @return boolean
     * @author 蜀山剑仙
     * @date 2019/7/31 下午4:41
     */
    boolean insertStudent(StudentInfo studentInfo);

    /**
     * 功能描述:
     * 〈修改一名学生信息〉
     *
     * @param studentInfo
     * @return boolean
     * @author 蜀山剑仙
     * @date 2019/7/31 下午4:41
     */
    boolean updateStudent(StudentInfo studentInfo);

    /**
     * 功能描述:
     * 〈获取一名学生信息〉
     *
     * @param studentInfo
     * @return com.myclass.entity.backstage.StudentInfo
     * @author 蜀山剑仙
     * @date 2019/7/31 下午4:42
     */
    StudentInfo getStudentInfo(StudentInfo studentInfo);
}