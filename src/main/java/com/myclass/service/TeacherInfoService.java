package com.myclass.service;


import com.myclass.entity.TeacherInfo;

import java.util.List;

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
     * @param teacherInfo
     * @return
     */
    boolean insertTeacherInfo(TeacherInfo teacherInfo) throws Exception;

    /**
     * 获取全部教师信息
     * @return 查询到的数据
     * @throws Exception
     */
    List<TeacherInfo> getAllTeacherInfo() throws Exception;

    /**
     * 根据id删除teacherInfo数据
     * @param id
     * @return 是否成功
     * @throws Exception
     */
    boolean deleteTeacherInfoById(Integer id) throws Exception;

}