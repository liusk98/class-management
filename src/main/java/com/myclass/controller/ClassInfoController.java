package com.myclass.controller;

import com.myclass.entity.ClassInfo;
import com.myclass.service.ClassInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 班级表(ClassInfo)(ClassInfo)表控制层
 *
 * @author makejava
 * @since 2019-07-29 16:23:08
 */
@RestController
@RequestMapping("classInfo")
public class ClassInfoController {
    /**
     * 服务对象
     */
    @Resource
    private ClassInfoService classInfoService;

}