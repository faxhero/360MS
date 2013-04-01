-- phpMyAdmin SQL Dump
-- version 2.11.9.5
-- http://www.phpmyadmin.net
--
-- 主机: 192.168.0.235:3306
-- 生成日期: 2`360ms_employee_relation`013 年 03 月 18 日 10:39
-- 服务器版本: 5.1.31
-- PHP 版本: 5.2.11

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;

--
-- 数据库: `lazyboy_360ms`
--

-- --------------------------------------------------------

--
-- 表的结构 `360ms_company`
--

DROP TABLE IF EXISTS `360ms_company`;
CREATE TABLE IF NOT EXISTS `360ms_company` (
  `company_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '公司自增id',  
  `name` varchar(150) NOT NULL COMMENT '公司名称',
  `number` varchar(50) NOT NULL COMMENT '公司编号',
  `parent` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '上级公司',
  `established` int(10) unsigned DEFAULT NULL COMMENT '公司成立时间',
  `founder` varchar(50) NOT NULL COMMENT '创建人',
  `logo` varchar(150) DEFAULT NULL COMMENT '公司logo',
  `enable_flag` smallint(5) unsigned DEFAULT 1 COMMENT '启用标识',
  `order_by` smallint(5) unsigned DEFAULT 0 COMMENT '排序字段',
  `remark` text COMMENT '公司备注',
  `created` timestamp  NOT NULL COMMENT '创建时间',
  `modified` timestamp NOT NULL  COMMENT '修改时间',
  `creator` smallint(5) unsigned NOT NULL COMMENT '创建人',
  `modifier` smallint(5) unsigned NOT NULL COMMENT '修改人',
  PRIMARY KEY (`company_id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `number` (`number`),
  KEY `created` (`created`),
  KEY `modified` (`modified`),
  KEY `creator` (`creator`),
  KEY `modifier` (`modifier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司信息表' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `360ms_department`
--

DROP TABLE IF EXISTS `360ms_department`;
CREATE TABLE IF NOT EXISTS `360ms_department` (
  `department_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` varchar(150) NOT NULL COMMENT '部门名称',
  `number` varchar(50) NOT NULL COMMENT '部门编号',
  `parent` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '上级部门',
  `remark` varchar(255) DEFAULT NULL COMMENT '部门备注',
  `enable_flag` smallint(5) unsigned DEFAULT 1 COMMENT '启用标识',
  `order_by` smallint(5) unsigned DEFAULT 0 COMMENT '排序字段',
  `created` timestamp NOT NULL  COMMENT '创建时间',
  `modified` timestamp NOT NULL  COMMENT '修改时间',
  `creator` smallint(5) unsigned NOT NULL COMMENT '创建人',
  `modifier` smallint(5) unsigned NOT NULL COMMENT '修改人',
  PRIMARY KEY (`department_id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `number` (`number`),
  KEY `parent` (`parent`),
  KEY `created` (`created`),
  KEY `modified` (`modified`),
  KEY `creator` (`creator`),
  KEY `modifier` (`modifier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门信息表' AUTO_INCREMENT=1 ;


-- --------------------------------------------------------

--
-- 表的结构 `360ms_section`
--

DROP TABLE IF EXISTS `360ms_section`;
CREATE TABLE IF NOT EXISTS `360ms_section` (
  `section_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` varchar(150) NOT NULL COMMENT '科室名称',
  `number` varchar(50) NOT NULL COMMENT '科室编号',
  `parent` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '上级科室',
  `department` smallint(5) unsigned NOT NULL COMMENT '所属部门',
  `remark` varchar(255) DEFAULT NULL COMMENT '科室备注',
  `enable_flag` smallint(5) unsigned DEFAULT 1 COMMENT '启用标识',
  `order_by` smallint(5) unsigned DEFAULT 0 COMMENT '排序字段',
  `created` timestamp NOT NULL  COMMENT '创建时间',
  `modified` timestamp NOT NULL  COMMENT '修改时间',
  `creator` smallint(5) unsigned NOT NULL COMMENT '创建人',
  `modifier` smallint(5) unsigned NOT NULL COMMENT '修改人',
  PRIMARY KEY (`section_id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `number` (`number`),
  KEY `parent` (`parent`),
  KEY `department` (`department`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='科室信息表' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `360ms_postion`
--

DROP TABLE IF EXISTS `360ms_postion`;
CREATE TABLE IF NOT EXISTS `360ms_postion` (
  `postion_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` varchar(150) NOT NULL COMMENT '岗位名称',
  `number` varchar(50) NOT NULL COMMENT '岗位编号',
  `grade` varchar(150) DEFAULT NULL COMMENT '岗位级别',
  `remark` varchar(255) DEFAULT NULL COMMENT '岗位备注',
  `enable_flag` smallint(5) unsigned DEFAULT 1 COMMENT '启用标识',
  `order_by` smallint(5) unsigned DEFAULT 0 COMMENT '排序字段',
  `created` timestamp NOT NULL  COMMENT '创建时间',
  `modified` timestamp NOT NULL  COMMENT '修改时间',
  `creator` smallint(5) unsigned NOT NULL COMMENT '创建人',
  `modifier` smallint(5) unsigned NOT NULL COMMENT '修改人',
  PRIMARY KEY (`postion_id`),
  UNIQUE KEY `number` (`number`),
  KEY `created` (`created`),
  KEY `modified` (`modified`),
  KEY `creator` (`creator`),
  KEY `modifier` (`modifier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位信息表' AUTO_INCREMENT=1 ;
-- --------------------------------------------------------

--
-- 表的结构 `360ms_employee`
--

DROP TABLE IF EXISTS `360ms_employee`;
CREATE TABLE IF NOT EXISTS `360ms_employee` (
  `employee_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` varchar(20) NOT NULL COMMENT '员工姓名',
  `number` varchar(50) NOT NULL COMMENT '员工工号',
  `password` varchar(50) NOT NULL COMMENT '员工工号',
  `ename` varchar(20) DEFAULT NULL COMMENT '英文名',
  `sex` enum('1','0') NOT NULL DEFAULT '1' COMMENT '性别 男性:1 女性:0',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `phone_number` varchar(20) NOT NULL COMMENT '手机号',
  `telephone` varchar(20) NOT NULL COMMENT '座机号',
  `company_adress` varchar(255) NOT NULL COMMENT '公司地址',
  `personal_adress` varchar(255) NOT NULL COMMENT '私人地址',  
  `personal_photo` varchar(100) NOT NULL COMMENT '私人地址',
  `remark` varchar(255) DEFAULT NULL COMMENT '员工备注',
  `enable_flag` smallint(5) unsigned DEFAULT 1 COMMENT '启用标识',
  `order_by` smallint(5) unsigned DEFAULT 0 COMMENT '排序字段',
  `created` timestamp NOT NULL  COMMENT '创建时间',
  `modified` timestamp NOT NULL  COMMENT '修改时间',
  `creator` smallint(5) unsigned NOT NULL COMMENT '创建人',
  `modifier` smallint(5) unsigned NOT NULL COMMENT '修改人',
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `number` (`number`),
  KEY `name` (`name`),
  KEY `created` (`created`),
  KEY `modified` (`modified`),
  KEY `creator` (`creator`),
  KEY `modifier` (`modifier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工信息表' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `360ms_employee_relation`
--

DROP TABLE IF EXISTS `360ms_employee_relation`;
CREATE TABLE IF NOT EXISTS `360ms_employee_relation` (
  `employee_id` smallint(5) unsigned NOT NULL COMMENT '员工主键id',
  `postion_id` smallint(5) unsigned NOT NULL COMMENT '岗位主键id',
  `section_id` smallint(5) unsigned NOT NULL COMMENT '科室主键id',  
  KEY `employee_id` (`employee_id`),
  KEY `postion_id` (`postion_id`),
  KEY `section_id` (`section_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工关联信息表';