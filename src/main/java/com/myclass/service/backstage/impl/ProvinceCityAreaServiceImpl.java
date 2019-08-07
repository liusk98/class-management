package com.myclass.service.backstage.impl;

import com.myclass.dao.backstage.AreaMapper;
import com.myclass.dao.backstage.CityMapper;
import com.myclass.dao.backstage.ProvinceMapper;
import com.myclass.entity.backstage.Area;
import com.myclass.entity.backstage.City;
import com.myclass.entity.backstage.Province;
import com.myclass.service.backstage.ProvinceCityAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author joe
 * @Date 2019/8/7
 */
@Service("provinceCityAreaService")
public class ProvinceCityAreaServiceImpl implements ProvinceCityAreaService {

    @Resource
    private ProvinceMapper provinceMapper;

    @Resource
    private CityMapper cityMapper;

    @Resource
    private AreaMapper areaMapper;

    /**
     * 功能描述:
     * 〈获取省份数据〉
     *
     * @return java.util.List<com.myclass.entity.backstage.Province>
     * @author 蜀山剑仙
     * @date 2019/8/7 下午5:16
     */
    @Override
    public List<Province> listProvince() {
        return provinceMapper.listProvince();
    }

    /**
     * 功能描述:
     * 〈根据省份编码获取城市数据〉
     *
     * @param provincecode
     * @return java.util.List<com.myclass.entity.backstage.City>
     * @author 蜀山剑仙
     * @date 2019/8/7 下午5:17
     */
    @Override
    public List<City> listCity(String provincecode) {
        return cityMapper.listCity(provincecode);
    }

    /**
     * 功能描述:
     * 〈根据城市编码获取区域数据〉
     *
     * @param citycode
     * @return java.util.List<com.myclass.entity.backstage.Area>
     * @author 蜀山剑仙
     * @date 2019/8/7 下午5:17
     */
    @Override
    public List<Area> listArea(String citycode) {
        return areaMapper.listArea(citycode);
    }
}
