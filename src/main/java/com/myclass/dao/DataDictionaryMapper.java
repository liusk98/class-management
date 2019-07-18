package com.myclass.dao;

import com.myclass.entity.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据字典Mapper
 * @author joe
 */
public interface DataDictionaryMapper {
    
    /**
     * 功能描述:
     * 〈增加一条数据字典数据〉
     *
     * @param dataDictionary
     * @return : int
     * @author : 蜀山剑仙
     * @date : 19-7-17 下午8:57
     */
    int insertDataDictionary(DataDictionary dataDictionary);

    /**
     * 功能描述:
     * 〈查询数据字典数据〉
     * @param orderType
     * @param orderCol
     * @return : java.util.List<com.myclass.entity.DataDictionary>
     * @author : 蜀山剑仙
     * @date : 19-7-17 下午9:00
     */
    List<DataDictionary> listDataDictionary(@Param("orderCol") String orderCol, @Param("orderType") String orderType);
}
