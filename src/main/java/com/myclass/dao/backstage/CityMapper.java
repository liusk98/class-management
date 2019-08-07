package com.myclass.dao.backstage;

import com.myclass.entity.backstage.City;

import java.util.List;

/**
 * @author joe
 * @Date 2019/8/7
 */
public interface CityMapper {

    /**
     * 功能描述:
     * 〈根据provincecode参数获取city数据〉
     *
     * @param provincecode
     * @return java.util.List<com.myclass.entity.backstage.City>
     * @author 蜀山剑仙
     * @date 2019/8/7 下午5:04
     */
    List<City> listCity(String provincecode);
}
