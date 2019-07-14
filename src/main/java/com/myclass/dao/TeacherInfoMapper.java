package com.myclass.dao;

import com.myclass.entity.TeacherInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 教师表(TeacherInfo)(TeacherInfo)表数据库访问层
 *
 * @author 蜀山剑仙
 * @since 2019-07-11 16:59:33
 */
public interface TeacherInfoMapper {

    /**
     * 根据name和pwd获取Teacherinfo数据
     *
     * @param loginName
     * @param pwd
     * @return com.com.myclass.entity.TeacherInfo
     * @author Joe
     * @date 2019/7/11 17:05
     */
    TeacherInfo getTeacherInfoByLoginNameAndPwd(@Param("loginName") String loginName, @Param("pwd") String pwd);

}