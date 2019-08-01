package com.myclass.service.backstage;

import com.myclass.entity.backstage.StudentInfo;
import com.myclass.tools.PageData;

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

    /**
     * 功能描述:
     * 〈分页查询Student数据〉
     *
     * @param studentInfo
     * @param pageIndex
     * @param pageSize
     * @param orderCol
     * @param orderType
     * @return com.myclass.tools.PageData<com.myclass.entity.backstage.StudentInfo>
     * @author 蜀山剑仙
     * @date 2019/8/2 上午11:02
     */
    PageData<StudentInfo> pageDataStudentInfo(StudentInfo studentInfo, int pageIndex, int pageSize, String orderCol, String orderType);
}