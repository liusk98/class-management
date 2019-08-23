-- MySQL dump 10.13  Distrib 8.0.17, for Linux (x86_64)
--
-- Host: localhost    Database: myClass
-- ------------------------------------------------------
-- Server version	5.7.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `OperateLog`
--

DROP TABLE IF EXISTS `OperateLog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `OperateLog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志记录号',
  `stuNo` char(11) DEFAULT NULL COMMENT '操作者（学生）',
  `teacherId` int(11) DEFAULT NULL COMMENT '操作者（教师）',
  `createTime` datetime NOT NULL COMMENT '操作时间',
  `logType` int(11) NOT NULL COMMENT '日志类型\n                                    1 教师记录自己\n                                    2 学生记录自己\n                                    3 教师记录学生\n                                    4 教师记录班级',
  `contentType` int(11) NOT NULL COMMENT '日志内容类型\n                                        1 登录\n                                        2 上传头像\n                                        3 修改密码\n                                        4 审核头像\n                                        5 编辑资料',
  `logDesc` varchar(200) DEFAULT NULL COMMENT '日志描述',
  `logIP` varchar(20) DEFAULT NULL COMMENT '操作者 IP 地址',
  `result` varchar(100) DEFAULT NULL COMMENT '操作结果',
  `objStu` char(11) DEFAULT NULL COMMENT '操作的学生对象编号',
  `objClassId` int(11) DEFAULT NULL COMMENT '操作的班级 Id',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作记录表（OperateLog）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(6) NOT NULL,
  `name` varchar(20) NOT NULL,
  `citycode` varchar(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3145 DEFAULT CHARSET=utf8 COMMENT='区县表(Area)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(6) NOT NULL,
  `name` varchar(20) NOT NULL,
  `provincecode` varchar(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=343 DEFAULT CHARSET=utf8 COMMENT='城市表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `classInfo`
--

DROP TABLE IF EXISTS `classInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师id,流水号',
  `name` varchar(20) NOT NULL COMMENT '班级名称',
  `gradeID` int(11) NOT NULL COMMENT '所属年级编号',
  `createTeacher` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='班级表(ClassInfo)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dataDictionary`
--

DROP TABLE IF EXISTS `dataDictionary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dataDictionary` (
  `typeCode` varchar(20) NOT NULL COMMENT '类型编码',
  `typeName` varchar(10) NOT NULL COMMENT '类型名称',
  `valueId` int(11) NOT NULL COMMENT '类型的值',
  `valueName` varchar(40) NOT NULL COMMENT '数据值名称',
  `createUser` int(11) DEFAULT NULL COMMENT '创建人id(教师编号)',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `isenable` int(11) NOT NULL DEFAULT '1' COMMENT '是否启用(0禁用,1启用)',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`typeCode`,`valueId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='数据字典表(DataDictionary)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '年级编号,流水号',
  `name` varchar(20) NOT NULL COMMENT '年级名称',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='年级表(Grade)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `province`
--

DROP TABLE IF EXISTS `province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(6) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='省份表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `studentInfo`
--

DROP TABLE IF EXISTS `studentInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentInfo` (
  `stuNo` char(14) NOT NULL COMMENT '学号',
  `loginName` varchar(20) NOT NULL COMMENT '登录名',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `pwd` varchar(40) NOT NULL COMMENT '登录密码',
  `classID` int(11) NOT NULL COMMENT '班级ID',
  `sex` char(1) DEFAULT NULL COMMENT '性别(男,女)',
  `idcard` char(18) NOT NULL COMMENT '身份证号',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `phone` char(11) DEFAULT NULL COMMENT '手机号',
  `headImg` varchar(50) DEFAULT NULL COMMENT '审核通过的头像地址',
  `headTemp` varchar(50) DEFAULT NULL COMMENT '待审核的头像地址',
  `isHeadPass` int(11) DEFAULT NULL COMMENT '头像是否通过审核(0未审核,1已审核,2未通过)',
  `provinceCode` char(6) DEFAULT NULL COMMENT '省代码',
  `cityCode` char(6) DEFAULT NULL COMMENT '城市代码',
  `areaCode` char(6) DEFAULT NULL COMMENT '区域代码',
  `address` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `signature` varchar(200) DEFAULT NULL COMMENT '个性签名',
  `createTime` datetime NOT NULL COMMENT '注册时间',
  `createTeacher` int(11) NOT NULL COMMENT '创建人',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '上次登录时间',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态,默认1(0被禁用,1正常)',
  `ipAddress` varchar(40) DEFAULT NULL COMMENT '注册ip地址',
  `modifyTime` datetime DEFAULT NULL COMMENT '上次修改资料时间',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`stuNo`),
  UNIQUE KEY `studentInfo_idcard_uindex` (`idcard`),
  UNIQUE KEY `studentInfo_loginName_uindex` (`loginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生信息表(StudentInfo)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `teacherInfo`
--

DROP TABLE IF EXISTS `teacherInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacherInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师id,流水号',
  `loginName` varchar(20) NOT NULL COMMENT '登录名',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `pwd` varchar(40) NOT NULL COMMENT '登陆密码',
  `level` int(11) NOT NULL DEFAULT '0' COMMENT '权限0普通用户,1超级管理员',
  `status` int(11) NOT NULL DEFAULT '1',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '上次登录时间',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `teacherInfo_loginName_uindex` (`loginName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='教师表(TeacherInfo)';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-23  9:48:48
