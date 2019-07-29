package com.myclass.entity;

import java.io.Serializable;

/**
 * 班级表(ClassInfo)(ClassInfo)实体类
 *
 * @author makejava
 * @since 2019-07-29 16:23:08
 */
public class ClassInfo implements Serializable {
    private static final long serialVersionUID = -12208389613994455L;

    /**
     * 教师id,流水号
     */
    private Integer id;
    /**
     * 班级名称
     */
    private String name;
    /**
     * 所属年级编号
     */
    private Integer gradeID;

    /**
     * 备注
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGradeID() {
        return gradeID;
    }

    public void setGradeID(Integer gradeID) {
        this.gradeID = gradeID;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}