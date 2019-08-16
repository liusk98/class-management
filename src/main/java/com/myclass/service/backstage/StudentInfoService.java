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
     * 〈学生登录〉
     *
     * @param loginName
     * @param pwd
     * @return com.myclass.entity.backstage.StudentInfo
     * @author 蜀山剑仙
     * @date 2019/8/5 下午6:35
     */
    StudentInfo login(String loginName, String pwd) throws Exception;

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
     * 〈修改学生待审核头像〉
     *
     * @param stuNo
     * @param headPath
     * @return boolean
     * @author 蜀山剑仙
     * @date 2019/8/14 下午1:38
     */
    boolean updateHeadTemp(String stuNo, String headPath);

    /**
     * 功能描述:
     * 〈批量修改〉
     *
     * @param status
     * @param arrStuNo
     * @return boolean
     * @author 蜀山剑仙
     * @date 2019/8/7 下午3:00
     */
    boolean updateStatusBatch(int status, String[] arrStuNo);

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

    /**
     * 功能描述:
     * 〈头像通过审核〉
     *
     * @param stuNo
     * @return boolean
     * @author 蜀山剑仙
     * @date 2019/8/14 下午3:50
     */
    boolean passHead(String stuNo);

    /**
     * 功能描述:
     * 〈头像未通过审核〉
     *
     * @param stuNo
     * @return boolean
     * @author 蜀山剑仙
     * @date 2019/8/16 上午9:07
     */
    boolean refuseHead(String stuNo);
}