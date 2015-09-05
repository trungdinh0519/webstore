-- phpMyAdmin SQL Dump
-- version 2.10.2
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Generation Time: Dec 10, 2007 at 02:14 AM
-- Server version: 5.0.45
-- PHP Version: 5.2.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Database: `goodstore`
-- 

-- --------------------------------------------------------

-- 
-- Table structure for table `j_user_role`
-- 

CREATE TABLE `j_user_role` (
  `username` varchar(255) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`username`,`role_id`),
  KEY `FK622EF2D5C4E25B4` (`role_id`),
  KEY `FK622EF2D5AA67845B` (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table `j_user_role`
-- 

INSERT INTO `j_user_role` VALUES ('admin', 1);
INSERT INTO `j_user_role` VALUES ('admin', 2);
INSERT INTO `j_user_role` VALUES ('admin', 3);
INSERT INTO `j_user_role` VALUES ('admin', 4);
INSERT INTO `j_user_role` VALUES ('dddd', 2);
INSERT INTO `j_user_role` VALUES ('saix', 2);
INSERT INTO `j_user_role` VALUES ('saixz', 2);
