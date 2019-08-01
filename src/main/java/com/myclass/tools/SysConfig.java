package com.myclass.tools;

import com.myclass.entity.DataDictionary;
import com.myclass.service.DataDictionaryService;

import javax.annotation.Resource;

/**
 * 配置
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
     * 功能描述:
     * 〈获取初始密码〉
     *
     * @param
     * @return java.lang.String
     * @author 蜀山剑仙
     * @date 2019/8/1 下午6:08
     */
    public static String getRestPwd() {
        //DataDictionary dataDictionary = dataDictionaryService.getDataDictionaryByTypeCodeAndValueId("REPWD", 1);
        return "e10adc3949ba59abbe56e057f20f883e";
    }
}
