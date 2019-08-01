package com.myclass.entity;

import java.util.Date;

/**
 * 学生信息
 *
 * @author joe
 * @Date 19-7-23
 */
public class StudentInfo {

    /**
     * 学号
     */
    private String stuNo;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 姓名
     */
    private String name;

    /**
     * 登录密码
     */
    private String pwd;

    /**
     * 班级ID
     */
    private Integer classID;

    /**
     * 性别(男,女)
     */
    private char sex;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 审核通过的头像地址
     */
    private String headImg;

    /**
     * 待审核的头像地址
     */
    private String headTemp;

    /**
     * 头像是否通过审核(0未审核,1已审核)
     */
    private Integer isHeadPass;

    /**
     * 省代码
     */
    private String provinceCode;

    /**
     * 城市代码
     */
    private String cityCode;

    /**
     * 区域代码
     */
    private String areaCode;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 注册时间
     */
    private Date createTime;

    /**
     * 创建教师
     */
    private TeacherInfo createTeacher;

    /**
     * 上次登录时间
     */
    private Date lastLoginTime;

    /**
     * 状态，默认1
     * (0禁用,1启用)
     */
    private Integer status;

    /**
     * 注册ip地址
     */
    private String idAddress;

    /**
     * 上次修改资料时间
     */
    private Date modifyTime;

    /**
     * 备注
     */
    private String remark;

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
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

    public Integer getClassID() {
        return classID;
    }

    public void setClassID(Integer classID) {
        this.classID = classID;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getHeadTemp() {
        return headTemp;
    }

    public void setHeadTemp(String headTemp) {
        this.headTemp = headTemp;
    }

    public Integer getIsHeadPass() {
        return isHeadPass;
    }

    public void setIsHeadPass(Integer isHeadPass) {
        this.isHeadPass = isHeadPass;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public TeacherInfo getCreateTeacher() {
        return createTeacher;
    }

    public void setCreateTeacher(TeacherInfo createTeacher) {
        this.createTeacher = createTeacher;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(String idAddress) {
        this.idAddress = idAddress;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
