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

}