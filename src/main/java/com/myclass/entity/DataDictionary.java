package com.myclass.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 数据字典表
 * @author joe
 */
public class DataDictionary {

    /**
     * 数据编码类型
     */
    private String typeCode;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 类型的值
     */
    private Integer valueId;

    /**
     * 数据值名称
     */
    private String valueName;

    /**
     * 创建人ID
     */
    private Integer createUser;

    /**
     * 创建人时间
     */
    @DateTimeFormat(pattern = "yyyy:MM:dd HH:mm:ss")
    private Date createTime;

    /**
     * 是否启用
     * (0禁用,1启用)
     */
    private Integer isenable;

    /**
     * 备注
     */
    private String remark;

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsenable() {
        return isenable;
    }

    public void setIsenable(Integer isenable) {
        this.isenable = isenable;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
