package com.myclass.dao.backstage;

import com.myclass.entity.backstage.StudentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学生信息表(StudentInfo)(Studentinfo)表数据库访问层
 *
 * @author 蜀山剑仙
 * @since 2019-07-31 14:44:58
 */
public interface StudentInfoMapper {

    /**
     * 功能描述:
     * 〈新增StudentInfo数据〉
     *
     * @param studentInfo
     * @return int
     * @author 蜀山剑仙
     * @date 2019/7/31 下午3:58
     */
    int insertStudentInfo(StudentInfo studentInfo);

    /**
     * 功能描述:
     * 〈修改StudentInfo数据〉
     *
     * @param studentInfo
     * @return int
     * @author 蜀山剑仙
     * @date 2019/7/31 下午3:58
     */
    int updateStudentInfo(StudentInfo studentInfo);

    /**
     * 功能描述:
     * 〈获取班级最大的学号〉
     *
     * @param prefix
     * @return java.lang.Integer
     * @author 蜀山剑仙
     * @date 2019/8/1 下午5:38
     */
    Integer getMaxStuNo(String prefix);

    /**
     * 功能描述:
     * 〈查找一个StudentInfo数据〉
     *
     * @param studentInfo
     * @return com.myclass.entity.backstage.StudentInfo
     * @author 蜀山剑仙
     * @date 2019/7/31 下午3:59
     */
    StudentInfo getStudentInfo(StudentInfo studentInfo);

    /**
     * 功能描述:
     * 〈查询StudentInfo列表〉
     *
     * @param studentInfo
     * @param orderCol
     * @param orderType
     * @return java.util.List<com.myclass.entity.backstage.StudentInfo>
     * @author 蜀山剑仙
     * @date 2019/7/31 下午4:01
     */
    List<StudentInfo> listStudentInfo(@Param("studentInfo") StudentInfo studentInfo, @Param("orderCol") String orderCol, @Param("orderType") String orderType);
}
