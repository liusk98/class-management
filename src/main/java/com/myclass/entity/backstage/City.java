package com.myclass.entity.backstage;

/**
 * 城市表
 *
 * @author joe
 * @Date 19-7-23
 */
public class City {

    /**
     * 城市id
     */
    private int id;

    /**
     * 城市编码
     */
    private String code;

    /**
     * 城市名称
     */
    private String name;

    /**
     * 省份编码
     */
    private String provincecode;

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

    public String getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode;
    }
}
