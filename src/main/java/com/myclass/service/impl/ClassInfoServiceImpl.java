package com.myclass.service.impl;

import com.myclass.entity.ClassInfo;
import com.myclass.dao.ClassInfoMapper;
import com.myclass.service.ClassInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 班级表(ClassInfo)(ClassInfo)表服务实现类
 *
 * @author makejava
 * @since 2019-07-29 16:23:08
 */
@Service("classInfoService")
public class ClassInfoServiceImpl implements ClassInfoService {
    @Resource
    private ClassInfoMapper classInfoMapper;

    /**
     * 功能描述:
     * 〈新增班级信息〉
     *
     * @param classInfo
     * @return boolean
     * @author 蜀山剑仙
     * @date 2019/7/30 上午11:26
     */
    @Override
    public boolean insertClassInfo(ClassInfo classInfo) {
        return classInfoMapper.insertClassInfo(classInfo) > 0;
    }
}