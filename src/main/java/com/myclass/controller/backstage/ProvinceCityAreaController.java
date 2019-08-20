package com.myclass.controller.backstage;

import com.myclass.entity.backstage.Area;
import com.myclass.entity.backstage.City;
import com.myclass.entity.backstage.Province;
import com.myclass.service.backstage.ProvinceCityAreaService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author joe
 * @Date 2019/8/7
 */
@RestController
@RequestMapping()
public class ProvinceCityAreaController {

    private Logger logger = Logger.getLogger(ProvinceCityAreaController.class);

    @Resource
    private ProvinceCityAreaService provinceCityAreaService;

    @GetMapping("province/province.json")
    public List<Province> listProvince() {
        return provinceCityAreaService.listProvince();
    }

    @GetMapping("city/city.json")
    public List<City> listCity(String provincecode) {
        return provinceCityAreaService.listCity(provincecode);
    }

    @GetMapping("area/area.json")
    public List<Area> listArea(String citycode) {
        return provinceCityAreaService.listArea(citycode);
    }
}
