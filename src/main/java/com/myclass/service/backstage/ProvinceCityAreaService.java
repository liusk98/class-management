package com.myclass.service.backstage;

import com.myclass.entity.backstage.Area;
import com.myclass.entity.backstage.City;
import com.myclass.entity.backstage.Province;

import java.util.List;

/**
 * @author joe
 * @Date 2019/8/7
 */
public interface ProvinceCityAreaService {

    /**
     * 功能描述:
     * 〈获取省份数据〉
     *
     * @param
     * @return java.util.List<com.myclass.entity.backstage.Province>
     * @author 蜀山剑仙
     * @date 2019/8/7 下午5:16
     */
    List<Province> listProvince();

    /**
     * 功能描述:
     * 〈根据省份编码获取城市数据〉
     *
     * @param provincecode
     * @return java.util.List<com.myclass.entity.backstage.City>
     * @author 蜀山剑仙
     * @date 2019/8/7 下午5:17
     */
    List<City> listCity(String provincecode);

    /**
     * 功能描述:
     * 〈根据城市编码获取区域数据〉
     *
     * @param citycode
     * @return java.util.List<com.myclass.entity.backstage.Area>
     * @author 蜀山剑仙
     * @date 2019/8/7 下午5:17
     */
    List<Area> listArea(String citycode);
}
