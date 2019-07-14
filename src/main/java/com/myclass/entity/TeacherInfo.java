package com.myclass.entity;

import java.util.Date;

/**
 * 教师表(TeacherInfo)(TeacherInfo)实体类
 *
 * @author 蜀山剑仙
 * @since 2019-07-11 16:59:31
 */
public class TeacherInfo {
    /**
     * 教师id,流水号
     */    
    private Integer id;

    /**
     * 登录名
     */    
    private String loginName;

    /**
     * 姓名
     */    
    private String name;

    /**
     * 登陆密码
     */    
    private String pwd;

    /**
     * 创建时间
     */    
    private Date createTime;

    /**
     * 上次登录时间
     */    
    private Date lastLoginTime;

    /**
     * 备注
     */    
    private String remark;

    public TeacherInfo() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}