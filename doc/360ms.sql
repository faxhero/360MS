-- phpMyAdmin SQL Dump
-- version 2.11.9.5
-- http://www.phpmyadmin.net
--
-- 主机: 192.168.0.235:3306
-- 生成日期: 2013 年 03 月 17 日 21:28
-- 服务器版本: 5.1.31
-- PHP 版本: 5.2.11

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `lazyboy_360ms`
--

-- --------------------------------------------------------

--
-- 表的结构 `360ms_company`
--

DROP TABLE IF EXISTS `360ms_company`;
CREATE TABLE IF NOT EXISTS `360ms_company` (
  `company_id` varchar(50) NOT NULL COMMENT '公司编号',
  `name` varchar(150) NOT NULL COMMENT '公司名称',
  `parent` varchar(150) DEFAULT NULL COMMENT '上级公司',
  `established` datetime DEFAULT NULL COMMENT '公司成立时间',
  `founder` varchar(50) NOT NULL COMMENT '创建人',
  `logo` varchar(150) DEFAULT NULL COMMENT '公司logo',
  `remark` text COMMENT '公司备注',
  `created` datetime NOT NULL COMMENT '创建时间',
  `modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`company_id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司信息表';

-- --------------------------------------------------------

--
-- 表的结构 `360ms_department`
--

DROP TABLE IF EXISTS `360ms_department`;
CREATE TABLE IF NOT EXISTS `360ms_department` (
  `department_id` varchar(50) NOT NULL COMMENT '部门编号',
  `name` varchar(150) NOT NULL COMMENT '部门名称',
  `parent` varchar(50) NOT NULL DEFAULT '0' COMMENT '上级部门',
  `remark` varchar(255) DEFAULT NULL COMMENT '部门备注',
  `created` datetime NOT NULL COMMENT '创建时间',
  `modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`department_id`),
  UNIQUE KEY `name` (`name`),
  KEY `parent` (`parent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门信息表';

-- --------------------------------------------------------

--
-- 表的结构 `360ms_employee`
--

DROP TABLE IF EXISTS `360ms_employee`;
CREATE TABLE IF NOT EXISTS `360ms_employee` (
  `employee_id` varchar(20) NOT NULL COMMENT '员工工号',
  `name` varchar(20) NOT NULL COMMENT '员工姓名',
  `ename` varchar(50) DEFAULT NULL COMMENT '英文名',
  `sex` enum('1','0') NOT NULL DEFAULT '1' COMMENT '性别 男性:1 女性:0',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `remark` varchar(255) DEFAULT NULL COMMENT '员工备注',
  `created` datetime NOT NULL COMMENT '创建时间',
  `modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`employee_id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工信息表';

-- --------------------------------------------------------

--
-- 表的结构 `360ms_employee_relation`
--

DROP TABLE IF EXISTS `360ms_employee_relation`;
CREATE TABLE IF NOT EXISTS `360ms_employee_relation` (
  `employee_id` varchar(20) NOT NULL COMMENT '员工工号',
  `postion_id` varchar(50) NOT NULL COMMENT '岗位编号',
  `section_id` varchar(50) NOT NULL COMMENT '科室编号',
  `created` datetime NOT NULL COMMENT '创建时间',
  `modified` datetime NOT NULL COMMENT '修改时间',
  KEY `employee_id` (`employee_id`),
  KEY `postion_id` (`postion_id`),
  KEY `section_id` (`section_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工关联信息表';

-- --------------------------------------------------------

--
-- 表的结构 `360ms_postion`
--

DROP TABLE IF EXISTS `360ms_postion`;
CREATE TABLE IF NOT EXISTS `360ms_postion` (
  `postion_id` varchar(50) NOT NULL COMMENT '岗位编号',
  `name` varchar(150) NOT NULL COMMENT '岗位名称',
  `grade` varchar(150) DEFAULT NULL COMMENT '岗位级别',
  `remark` varchar(255) DEFAULT NULL COMMENT '岗位备注',
  `created` datetime NOT NULL COMMENT '创建时间',
  `modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`postion_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位信息表';

-- --------------------------------------------------------

--
-- 表的结构 `360ms_section`
--

DROP TABLE IF EXISTS `360ms_section`;
CREATE TABLE IF NOT EXISTS `360ms_section` (
  `section_id` varchar(50) NOT NULL COMMENT '科室编号',
  `name` varchar(150) NOT NULL COMMENT '科室名称',
  `parent` varchar(50) NOT NULL DEFAULT '0' COMMENT '上级科室',
  `department` varchar(50) NOT NULL COMMENT '所属部门',
  `remark` varchar(255) DEFAULT NULL COMMENT '科室备注',
  `created` datetime NOT NULL COMMENT '创建时间',
  `modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`section_id`),
  UNIQUE KEY `name` (`name`),
  KEY `parent` (`parent`),
  KEY `department` (`department`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='科室信息表';
