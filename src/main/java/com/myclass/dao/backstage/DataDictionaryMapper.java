package com.myclass.dao.backstage;

import com.myclass.entity.backstage.DataDictionary;
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
     *
     * @param orderType
     * @param orderCol
     * @param dataDictionary
     * @return : java.util.List<com.myclass.entity.backstage.DataDictionary>
     * @author : 蜀山剑仙
     * @date : 19-7-17 下午9:00
     */
    List<DataDictionary> listDataDictionary(@Param("dataDictionary") DataDictionary dataDictionary, @Param("orderCol") String orderCol, @Param("orderType") String orderType);

    /**
     * 功能描述:
     * 〈更改数据字典启用状态〉
     * @param valueId
     * @param typeCode
     * @param oldStatus
     * @param statusValue
     * @return int
     * @author 蜀山剑仙
     * @date 19-7-19 上午10:40
     */
    int updateIsEnable(@Param("typeCode") String typeCode, @Param("valueId") Integer valueId, @Param("oldStatus") Integer oldStatus, @Param("statusValue") Integer statusValue);

    /**
     * 功能描述:
     * 〈根据ID查询数据字典数据〉
     *
     * @param typeCode
     * @param valueId
     * @return com.myclass.entity.backstage.DataDictionary
     * @author 蜀山剑仙
     * @date 19-7-19 上午11:21
     */
    DataDictionary getDataDictionaryById(@Param("typeCode") String typeCode, @Param("valueId") Integer valueId);

    /**
     * 功能描述:
     * 〈修改数据字典数据〉
     *
     * @param dataDictionary
     * @return int
     * @author 蜀山剑仙
     * @date 19-7-19 上午11:25
     */
    int updateDataDictionary(DataDictionary dataDictionary);
}
