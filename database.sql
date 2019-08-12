create schema if not exists myClass collate utf8_general_ci;

create table if not exists area
(
	id int auto_increment
		primary key,
	code varchar(6) not null,
	name varchar(20) not null,
	citycode varchar(6) not null
)
comment '区县表(Area)' engine=MyISAM;

create table if not exists city
(
	id int auto_increment
		primary key,
	code varchar(6) not null,
	name varchar(20) not null,
	provincecode varchar(6) not null
)
comment '城市表' engine=MyISAM;

create table if not exists classInfo
(
	id int auto_increment comment '教师id,流水号'
		primary key,
	name varchar(20) not null comment '班级名称',
	gradeID int not null comment '所属年级编号',
	createTeacher int not null,
	createTime datetime null,
	remark varchar(200) null comment '备注'
)
comment '班级表(ClassInfo)';

create table if not exists dataDictionary
(
	typeCode varchar(20) not null comment '类型编码',
	typeName varchar(10) not null comment '类型名称',
	valueId int not null comment '类型的值',
	valueName varchar(40) not null comment '数据值名称',
	createUser int null comment '创建人id(教师编号)',
	createTime datetime null comment '创建时间',
	isenable int default 1 not null comment '是否启用(0禁用,1启用)',
	remark varchar(100) null comment '备注',
	primary key (typeCode, valueId)
)
comment '数据字典表(DataDictionary)' engine=MyISAM;

create table if not exists grade
(
	id int auto_increment comment '年级编号,流水号'
		primary key,
	name varchar(20) not null comment '年级名称',
	remark varchar(200) null comment '备注'
)
comment '年级表(Grade)';

create table if not exists province
(
	id int auto_increment
		primary key,
	code varchar(6) not null,
	name varchar(20) not null
)
comment '省份表' engine=MyISAM;

create table if not exists studentInfo
(
	stuNo char(14) not null comment '学号'
		primary key,
	loginName varchar(20) not null comment '登录名',
	name varchar(10) not null comment '姓名',
	pwd varchar(40) not null comment '登录密码',
	classID int not null comment '班级ID',
	sex char null comment '性别(男,女)',
	idcard char(18) not null comment '身份证号',
	birthday date null comment '生日',
	phone char(11) null comment '手机号',
	headImg varchar(50) null comment '审核通过的头像地址',
	headTemp varchar(50) null comment '待审核的头像地址',
	isHeadPass int null comment '头像是否通过审核(0未审核,1已审核,2未通过)',
	provinceCode char(6) null comment '省代码',
	cityCode char(6) null comment '城市代码',
	areaCode char(6) null comment '区域代码',
	address varchar(200) null comment '详细地址',
	signature varchar(200) null comment '个性签名',
	createTime datetime not null comment '注册时间',
	createTeacher int not null comment '创建人',
	lastLoginTime datetime null comment '上次登录时间',
	status int default 1 not null comment '状态,默认1(0被禁用,1正常)',
	ipAddress varchar(40) null comment '注册ip地址',
	modifyTime datetime null comment '上次修改资料时间',
	remark varchar(200) null comment '备注',
	constraint studentInfo_idcard_uindex
		unique (idcard)
)
comment '学生信息表(StudentInfo)';

create table if not exists teacherInfo
(
	id int auto_increment comment '教师id,流水号'
		primary key,
	loginName varchar(20) not null comment '登录名',
	name varchar(10) not null comment '姓名',
	pwd varchar(40) not null comment '登陆密码',
	level int default 0 not null comment '权限0普通用户,1超级管理员',
	status int default 1 not null,
	createTime datetime not null comment '创建时间',
	lastLoginTime datetime null comment '上次登录时间',
	remark varchar(200) null comment '备注',
	constraint teacherInfo_loginName_uindex
		unique (loginName)
)
comment '教师表(TeacherInfo)';
