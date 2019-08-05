package com.myclass.service.backstage.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.myclass.dao.backstage.ClassInfoMapper;
import com.myclass.dao.backstage.StudentInfoMapper;
import com.myclass.entity.backstage.ClassInfo;
import com.myclass.entity.backstage.StudentInfo;
import com.myclass.service.backstage.StudentInfoService;
import com.myclass.tools.PageData;
import com.myclass.tools.SysConfig;
import com.young.encrypt.EncryptTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

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

    @Resource
    private ClassInfoMapper classInfoMapper;

    /**
     * 功能描述:
     * 〈新增一名学生〉
     *
     * @param studentInfo
     * @return boolean
     * @author 蜀山剑仙
     * @date 2019/7/31 下午4:41
     */
    @Override
    public boolean insertStudent(StudentInfo studentInfo) {
        //获取当前选择的班级信息
        ClassInfo classInfo = classInfoMapper.getClassInfo(studentInfo.getClassID());
        //前缀
        StringBuffer prefix = new StringBuffer();
        //年份
        prefix.append(Calendar.getInstance().get(Calendar.YEAR));
        //年级
        prefix.append(String.format("%02d", classInfo.getGradeID()));
        //班级
        prefix.append(String.format("%02d", classInfo.getId()));
        Integer maxStuNo = studentInfoMapper.getMaxStuNo(prefix.toString());
        String stuNo = prefix.append(String.format("%03d", ((maxStuNo == null) ? 1 : maxStuNo + 1))).toString();
        studentInfo.setStuNo(stuNo);
        studentInfo.setLoginName(stuNo);
        studentInfo.setPwd(SysConfig.getRestPwd());
        studentInfo.setStatus(1);
        return studentInfoMapper.insertStudentInfo(studentInfo) > 0;
    }

    /**
     * 功能描述:
     * 〈学生登录〉
     *
     * @param loginName
     * @param pwd
     * @return com.myclass.entity.backstage.StudentInfo
     * @author 蜀山剑仙
     * @date 2019/8/5 下午6:35
     */
    @Override
    public StudentInfo login(String loginName, String pwd) throws Exception {
        StudentInfo login = new StudentInfo();
        login.setLoginName(loginName);
        login.setPwd(EncryptTool.md5(pwd));
        StudentInfo studentInfo = studentInfoMapper.getStudentInfo(login);
        if (studentInfo == null) {
            throw new Exception("用户名或密码错误!");
        }
        if (studentInfo.getStatus() == 0) {
            throw new Exception("该用户已被封禁,请联系管理员");
        } else if (studentInfo != null) {
            studentInfoMapper.updateLastLoginTimeByStuNo(studentInfo.getStuNo());
        }
        return studentInfo;
    }

    /**
     * 功能描述:
     * 〈修改一名学生信息〉
     *
     * @param studentInfo
     * @return boolean
     * @author 蜀山剑仙
     * @date 2019/7/31 下午4:41
     */
    @Override
    public boolean updateStudent(StudentInfo studentInfo) {
        return studentInfoMapper.updateStudentInfo(studentInfo) > 0;
    }

    /**
     * 功能描述:
     * 〈获取一名学生信息〉
     *
     * @param studentInfo
     * @return com.myclass.entity.backstage.StudentInfo
     * @author 蜀山剑仙
     * @date 2019/7/31 下午4:42
     */
    @Override
    public StudentInfo getStudentInfo(StudentInfo studentInfo) {
        return studentInfoMapper.getStudentInfo(studentInfo);
    }

    /**
     * 功能描述:
     * 〈分页查询Student数据〉
     *
     * @param studentInfo
     * @param pageIndex
     * @param pageSize
     * @param orderCol
     * @param orderType
     * @return com.myclass.tools.PageData<com.myclass.entity.backstage.StudentInfo>
     * @author 蜀山剑仙
     * @date 2019/8/2 上午11:02
     */
    @Override
    public PageData<StudentInfo> pageDataStudentInfo(StudentInfo studentInfo, int pageIndex, int pageSize, String orderCol, String orderType) {
        // 设置分页插件
        Page<StudentInfo> page = PageHelper.startPage(pageIndex, pageSize);
        //开始调用mapper查询
        List<StudentInfo> listStudentInfo = studentInfoMapper.listStudentInfo(studentInfo, orderCol, orderType);

        PageData<StudentInfo> studentInfoPageData = new PageData<>();
        //获取查询的总条数
        studentInfoPageData.setTotal(page.getTotal());
        //获取当前页数据
        studentInfoPageData.setRows(listStudentInfo);
        return studentInfoPageData;
    }

}