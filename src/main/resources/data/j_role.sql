-- phpMyAdmin SQL Dump
-- version 2.10.2
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Generation Time: Dec 10, 2007 at 02:13 AM
-- Server version: 5.0.45
-- PHP Version: 5.2.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Database: `goodstore`
-- 

-- --------------------------------------------------------

-- 
-- Table structure for table `j_role`
-- 

CREATE TABLE `j_role` (
  `role_id` bigint(20) NOT NULL auto_increment,
  `name` varchar(48) NOT NULL,
  `description` varchar(255) default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

-- 
-- Dumping data for table `j_role`
-- 

INSERT INTO `j_role` VALUES (1, 'ROLE_ADMIN', 'Quản trị');
INSERT INTO `j_role` VALUES (2, 'ROLE_USER', 'Thành viên');
INSERT INTO `j_role` VALUES (3, 'ROLE_EMP', 'Nhân viên');
INSERT INTO `j_role` VALUES (4, 'ROLE_MANAGER', 'Giám đốc');
