package com.myclass.service;

import com.myclass.entity.DataDictionary;
import com.myclass.tools.PageData;

/**
 * DataDictionaryService
 *
 * @author joe
 * @Date 19-7-18
 */
public interface DataDictionaryService {


    /**
     * 功能描述:
     * 〈数据字典分页查询〉
     *
     * @param pageIndex
     * @param pageSize
     * @param orderCol
     * @param orderType
     * @return : com.myclass.tools.PageData<com.myclass.entity.DataDictionary>
     * @author : 蜀山剑仙
     * @date : 19-7-18 下午3:32
     */
    PageData<DataDictionary> listDataDictionary(int pageIndex, int pageSize, String orderCol, String orderType);

    /**
     * 功能描述:
     * 〈新增数据字典数据〉
     *
     * @param dataDictionary
     * @return : boolean
     * @author : 蜀山剑仙
     * @date : 19-7-18 下午3:34
     */
    boolean insertDataDictionary(DataDictionary dataDictionary);

    /**
     * 功能描述:
     * 〈修改数据字典启用状态〉
     *
     * @param typeCode
     * @param valueId
     * @param enable
     * @return boolean
     * @author 蜀山剑仙
     * @date 19-7-19 上午10:44
     */
    boolean updateIsEnable(String typeCode,Integer valueId, boolean enable);

    /**
     * 功能描述:
     * 〈根据ID查询数据字典〉
     *
     * @param typeCode
     * @param valueId
     * @return com.myclass.entity.DataDictionary
     * @author 蜀山剑仙
     * @date 19-7-19 上午11:29
     */
    DataDictionary getDataDictionaryByTypeCodeAndValueId(String typeCode,Integer valueId);

    /**
     * 功能描述:
     * 〈修改数据字典数据〉
     *
     * @param dataDictionary
     * @return boolean
     * @author 蜀山剑仙
     * @date 19-7-19 上午11:30
     */
    boolean updateDataDictionary(DataDictionary dataDictionary);

}
