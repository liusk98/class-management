package com.myclass.dao.backstage;

import com.myclass.entity.backstage.Province;

import java.util.List;

/**
 * 省份Mapper
 * @author joe
 * @Date 2019/8/7
 */
public interface ProvinceMapper {

    /**
     * 功能描述:
     * 〈获取Province数据〉
     *
     * @param
     * @return java.util.List<com.myclass.entity.backstage.Province>
     * @author 蜀山剑仙
     * @date 2019/8/7 下午5:02
     */
    List<Province> listProvince();
}
