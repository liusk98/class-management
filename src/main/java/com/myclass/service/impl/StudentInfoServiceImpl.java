package com.myclass.service.impl;

import com.myclass.dao.StudentInfoMapper;
import com.myclass.service.StudentInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 学生信息表(StudentInfo)(Studentinfo)表服务实现类
 *
 * @author 蜀山剑仙
 * @since 2019-07-31 14:44:58
 */
@Service("studentInfoService")
public class StudentInfoServiceImpl implements StudentInfoService {
    @Resource
    private StudentInfoMapper studentInfoMapper;
}