package com.myclass.controller.backstage;

import com.myclass.entity.backstage.DataDictionary;
import com.myclass.service.backstage.DataDictionaryService;
import com.myclass.tools.PageData;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据字典Controller
 *
 * @author joe
 * @Date 19-7-23
 */
@RestController
@RequestMapping("backstage/dataDictionary")
public class DataDictionaryController {

    private Logger logger = Logger.getLogger(DataDictionaryController.class);

    /**
     * 服务对象
     */
    @Resource
    private DataDictionaryService dataDictionaryService;

    @GetMapping("insertDataDictionary.html")
    public ModelAndView dataDictionaryInsert(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/super/insertDataDictionary");
        modelAndView.addObject("isEdit", false);
        modelAndView.addObject("title", "添加");
        return modelAndView;
    }

    @GetMapping("updateDataDictionary/{typeCode}/{valueId}")
    public ModelAndView dataDictionaryUpdate(@PathVariable String typeCode, @PathVariable Integer valueId, ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/super/insertDataDictionary");
        DataDictionary dataDictionary = dataDictionaryService.getDataDictionaryByTypeCodeAndValueId(typeCode, valueId);
        modelAndView.addObject("dataDictionary", dataDictionary);
        modelAndView.addObject("isEdit", true);
        modelAndView.addObject("title", "修改");
        return modelAndView;
    }

    @GetMapping("listDataDictionary.html")
    public ModelAndView dataDictionaryList(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/super/listDataDictionary");
        return modelAndView;
    }

    @GetMapping("listDataDictionary.json")
    public List<DataDictionary> listDataDictionary(String typeCode) {
        DataDictionary dataDictionary = new DataDictionary();
        dataDictionary.setTypeCode(typeCode);
        dataDictionary.setIsenable(1);
        List<DataDictionary> listDataDictionaryByTypeCode = dataDictionaryService.listDataDictionaryByTypeCode(dataDictionary);
        return listDataDictionaryByTypeCode;
    }

    @GetMapping("dataDictionaryList.json")
    public PageData<DataDictionary> getDataDictionary(String sort, String order, int offset, int limit) {
        // 每页条数
        int pageSize = limit;
        // 当前页码
        int pageIndex = offset / limit + 1;
        PageData<DataDictionary> dataDictionaryPageData = dataDictionaryService.listDataDictionary(pageIndex, pageSize, sort, order);
        return dataDictionaryPageData;
    }

    @PostMapping("insertDataDictionary.do")
    public ModelAndView dataDictionaryInsert(DataDictionary dataDictionary, ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/super/insertDataDictionary");
        boolean insertDataDictionary = dataDictionaryService.insertDataDictionary(dataDictionary);
        if (insertDataDictionary) {
            modelAndView.addObject("msg", "添加成功!");
        } else {
            modelAndView.addObject("msg", "添加失败!");
        }
        modelAndView.addObject("isEdit", false);
        modelAndView.addObject("title", "添加");
        return modelAndView;
    }

    @PostMapping("changeEnableDataDictionary")
    public String changeEnable(String typeCode, Integer valueId, boolean enable) {
        String msg = (dataDictionaryService.updateIsEnable(typeCode, valueId, enable)) ? "true" : "false";
        return msg;
    }

    @PostMapping("updateDataDictionary")
    public ModelAndView updateDataDictionary(DataDictionary dataDictionary, ModelAndView modelAndView) {
        boolean updateDataDictionary = dataDictionaryService.updateDataDictionary(dataDictionary);
        if (updateDataDictionary) {
            modelAndView.addObject("msg", "修改成功!");
        } else {
            modelAndView.addObject("msg", "修改失败!");
        }
        modelAndView = dataDictionaryUpdate(dataDictionary.getTypeCode(), dataDictionary.getValueId(), modelAndView);
        return modelAndView;
    }

}
