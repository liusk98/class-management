package com.myclass.tools;

import com.myclass.entity.backstage.DataDictionary;
import com.myclass.service.backstage.DataDictionaryService;

import javax.annotation.Resource;

/**
 * 配置
 *
 * @author joe
 * @Date 2019/8/1
 */
public class SysConfig {

    /**
     * 服务对象
     */
    @Resource
    private static DataDictionaryService dataDictionaryService;

    /**
     * 初始密码
     */
    private final static String RESET_PWD;

    private static String rootPath;

    public static String getRootPath() {
        return rootPath;
    }

    public static void setRootPath(String rootPath) {
        SysConfig.rootPath = rootPath;
    }

    static {
        //DataDictionary dataDictionary = dataDictionaryService.getDataDictionaryByTypeCodeAndValueId("REPWD", 1);
        RESET_PWD = "e10adc3949ba59abbe56e057f20f883e";
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
    public static String getRestPwd() {
       return RESET_PWD;
    }
}
