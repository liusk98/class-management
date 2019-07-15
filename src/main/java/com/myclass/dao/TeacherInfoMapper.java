package com.myclass.dao;

import com.myclass.entity.TeacherInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 教师表(TeacherInfo)(TeacherInfo)表数据库访问层
 *
 * @author 蜀山剑仙
 * @since 2019-07-11 16:59:33
 */
public interface TeacherInfoMapper {

    /**
     * 根据name和pwd获取TeacherInfo数据
     *
     * @param loginName
     * @param pwd
     * @return com.com.myclass.entity.TeacherInfo
     * @author Joe
     * @date 2019/7/11 17:05
     */
    TeacherInfo getTeacherInfoByLoginNameAndPwd(@Param("loginName") String loginName, @Param("pwd") String pwd);

    /**
     * 新增TeacherInfo数据
     * @param teacherInfo
     * @return
     * @date 2019/7/15 09:51
     */
    int insertTeacherInfo(TeacherInfo teacherInfo);

    /**
     * 修改TeacherInfo中lastLoginTime字段
     * @param id
     * @return
     */
    int updateLastLoginTimeById(Integer id);

    /**
     * 获取TeacherInfo数据
     * @return 查到的全部数据
     */
    List<TeacherInfo> listTeacherInfo();

    /**
     * 根据id删除TeacherInfo数据
     * @param id
     * @return
     */
    int deleteTeacherInfoById(Integer id);
}