package com.myclass.entity;

/**
 * 省份表
 *
 * @author joe
 * @Date 19-7-23
 */
public class Province {

    /**
     * 省份id
     */
    private int id;

    /**
     * 省份编码
     */
    private String code;

    /**
     * 省份名称
     */
    private String name;

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
}
