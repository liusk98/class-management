package com.myclass.tools;

import com.myclass.entity.backstage.DataDictionary;
import com.myclass.service.backstage.DataDictionaryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 配置
 * 利用反射机制获取当前项目的绝对路径
 * @author joe
 * @Date 2019/8/1
 */
@Component
public class SysConfig {

    /**
     * 服务对象
     */
    @Resource
    private DataDictionaryService dataDictionaryService;

    private static DataDictionary dataDictionaryRePwd ;
    /**
     * 静态化工具类变量
     */
    public static SysConfig sysConfig;

    /**
     * 初始密码
     */
    private static String resetPwd;
    /**
     * 教师session会话存储值
     */
    public final static String SESSION_TEACHER;

    /**
     * 学生session会话存储值
     */
    public final static String SESSION_STUDENT;

    private static String rootPath;

    /**
     * 功能描述:
     * 〈注解用于告诉此代码在 Spring 加载之前就运行〉
     *
     * @param
     * @return void
     * @author 蜀山剑仙
     * @date 2019/8/31 下午9:27
     */
    @PostConstruct
    public void init() {
        // 工具类的实例赋值给 sysConfig
        sysConfig = this;
        // 会激活 Spring 对 service 的管理并赋值
        sysConfig.dataDictionaryService = this.dataDictionaryService;
        System.out.println("工具类已经初始化，被纳入 Spring 管理");
        // 我们在初始化之后调用一下静态方法
        sysConfig.setResetPwd();
    }

    static {
        // 利用反射机制获取当前项目的绝对路径
        setRootPath(SysConfig.class.getResource("/").getPath().replace("/WEB-INF/classes",""));
        SESSION_TEACHER = "teacher";
        SESSION_STUDENT = "student";
    }

    public static String getRootPath() {
        return rootPath;
    }

    public static void setRootPath(String rootPath) {
        SysConfig.rootPath = rootPath;
    }

    /**
     * 功能描述:
     * 〈获取初始密码〉
     *
     * @param
     * @return java.lang.String
     * @author 蜀山剑仙
     * @date 2019/8/1 下午6:08
     */
    public String getRestPwd() {
        setResetPwd();
        return resetPwd;
    }

    /**
     * 功能描述:
     * 〈调用SET方法为 resetPwd 赋值〉
     *
     * @param
     * @return void
     * @author 蜀山剑仙
     * @date 2019/8/31 下午9:10
     */
    private void setResetPwd() {
        this.setDataDictionaryRePwd();
        resetPwd = dataDictionaryRePwd.getValueName();
    }

    private void setDataDictionaryRePwd() {
        SysConfig.dataDictionaryRePwd = dataDictionaryService.getDataDictionaryByTypeCodeAndValueId("REPWD", 1);
    }
}
