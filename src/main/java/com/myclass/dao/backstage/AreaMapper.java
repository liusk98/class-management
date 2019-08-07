package com.myclass.dao.backstage;

import com.myclass.entity.backstage.Area;

import java.util.List;

/**
 * @author joe
 * @Date 2019/8/7
 */
public interface AreaMapper {

    /**
     * 功能描述:
     * 〈根据citycode获取area数据〉
     *
     * @param citycode
     * @return java.util.List<com.myclass.entity.backstage.Area>
     * @author 蜀山剑仙
     * @date 2019/8/7 下午5:05
     */
    List<Area> listArea(String citycode);
}
