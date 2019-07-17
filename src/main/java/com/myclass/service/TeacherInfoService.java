package com.myclass.service;


import com.myclass.entity.TeacherInfo;
import com.myclass.tools.PageData;

/**
 * 教师表(TeacherInfo)(TeacherInfo)表服务接口
 *
 * @author 蜀山剑仙
 * @since 2019-07-11 16:59:33
 */
public interface TeacherInfoService {

    /**
     * 通过md5加密登录
     *
     * @param loginName
     * @param pwd
     * @return com.com.myclass.entity.TeacherInfo
     * @author Joe
     * @date 2019/7/11 17:10
     */
    TeacherInfo login(String loginName, String pwd) throws Exception;

    /**
     * 新增一名教师数据
     *
     * @param teacherInfo
     * @return
     */
    boolean insertTeacherInfo(TeacherInfo teacherInfo) throws Exception;

    /**
     * 根据id删除teacherInfo数据
     *
     * @param id
     * @return 是否成功
     * @throws Exception
     */
    boolean deleteTeacherInfoById(Integer id) throws Exception;

    /**
     * 分页查询教师数据
     *
     * @param pageIndex
     * @param pageSize
     * @param orderCol
     * @param orderType
     * @return
     */
    PageData<TeacherInfo> getTeachers(int pageIndex, int pageSize, String orderCol, String orderType);

    /**
     * 根据id修改密码
     * @param id
     * @param oldPwd
     * @param newPwd
     * @return
     */
    boolean updateTeacherInfoPwdById(Integer id, String oldPwd, String newPwd) throws Exception;
}