package com.myclass.service;

import com.myclass.entity.ClassInfo;
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
}