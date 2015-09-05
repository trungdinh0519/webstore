-- phpMyAdmin SQL Dump
-- version 2.10.2
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Generation Time: Dec 10, 2007 at 02:17 AM
-- Server version: 5.0.45
-- PHP Version: 5.2.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Database: `goodstore`
-- 

-- --------------------------------------------------------

-- 
-- Table structure for table `j_order_status`
-- 

CREATE TABLE `j_order_status` (
  `os_id` bigint(20) NOT NULL auto_increment,
  `code` varchar(32) default NULL,
  `name` varchar(32) default NULL,
  PRIMARY KEY  (`os_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

-- 
-- Dumping data for table `j_order_status`
-- 

INSERT INTO `j_order_status` VALUES (1, 'S', 'Đã chuyển hàng');
INSERT INTO `j_order_status` VALUES (2, 'R', 'Hoàn trả');
INSERT INTO `j_order_status` VALUES (3, 'X', 'Chờ hủy bỏ');
INSERT INTO `j_order_status` VALUES (4, 'NP', 'Chưa Thanh toán');
INSERT INTO `j_order_status` VALUES (5, 'YP', 'Đã thanh toán');
