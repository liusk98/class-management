package com.myclass.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.myclass.dao.DataDictionaryMapper;
import com.myclass.entity.DataDictionary;
import com.myclass.service.DataDictionaryService;
import com.myclass.tools.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * DataDictionary
 * 数据字典SerivceImpl
 *
 * @author joe
 * @Date 19-7-18
 */
@Service("dataDictionaryService")
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Resource
    private DataDictionaryMapper dataDictionaryMapper;


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
    @Override
    public PageData<DataDictionary> listDataDictionary(int pageIndex, int pageSize, String orderCol, String orderType) {
        // 设置分页插件
        Page<DataDictionary> page = PageHelper.startPage(pageIndex, pageSize);
        // 开始调用mapper查询
        List<DataDictionary> dataDictionaries = dataDictionaryMapper.listDataDictionary(orderCol, orderType);
        PageData<DataDictionary> dataDictionaryPageData = new PageData<>();
        dataDictionaryPageData.setTotal(page.getTotal());
        dataDictionaryPageData.setRows(dataDictionaries);
        return dataDictionaryPageData;
    }

    /**
     * 功能描述:
     * 〈新增数据字典数据〉
     *
     * @param dataDictionary
     * @return : boolean
     * @author : 蜀山剑仙
     * @date : 19-7-18 下午3:34
     */
    @Override
    public boolean insertDataDictionary(DataDictionary dataDictionary) {
        return dataDictionaryMapper.insertDataDictionary(dataDictionary) > 0;
    }

    /**
     * 功能描述:
     * 〈修改数据字典启用状态〉
     *
     * @param id
     * @param enable
     * @return boolean
     * @author 蜀山剑仙
     * @date 19-7-19 上午10:44
     */
    @Override
    public boolean updateIsEnable(int id, boolean enable) {
        int oldStatus = (enable) ? 1 : 0;
        int statusValue = (enable) ? 0 : 1;
        return dataDictionaryMapper.updateIsEnable(id, oldStatus, statusValue) > 0;
    }

}
