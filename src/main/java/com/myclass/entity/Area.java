package com.myclass.entity;

/**
 * 区县
 *
 * @author joe
 * @Date 19-7-23
 */
public class Area {

    /**
     * 区县id
     */
    private int id;

    /**
     * 区县编码
     */
    private String code;

    /**
     * 区县名称
     */
    private String name;

    /**
     * 城市编码
     */
    private String citycode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }
}
