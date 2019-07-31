package com.myclass.service;

import com.myclass.entity.ClassInfo;
import com.myclass.tools.PageData;

import java.util.List;

/**
 * 班级表(ClassInfo)(ClassInfo)表服务接口
 *
 * @author makejava
 * @since 2019-07-29 16:23:08
 */
public interface ClassInfoService {

    /**
     * 功能描述:
     * 〈新增班级信息〉
     *
     * @param classInfo
     * @return boolean
     * @author 蜀山剑仙
     * @date 2019/7/30 上午11:26
     */
    boolean insertClassInfo(ClassInfo classInfo);

    /**
     * 功能描述:
     * 〈分页查询班级信息〉
     *
     * @param pageIndex
     * @param pageSize
     * @param orderCol
     * @param orderType
     * @param gradeID
     * @return com.myclass.tools.PageData<com.myclass.entity.ClassInfo>
     * @author 蜀山剑仙
     * @date 2019/7/31 上午10:38
     */
    PageData<ClassInfo> pageDataClassInfo(Integer gradeID,int pageIndex, int pageSize, String orderCol, String orderType);
}