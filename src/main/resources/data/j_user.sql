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
-- Table structure for table `j_user`
-- 

CREATE TABLE `j_user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `confirmPassword` varchar(255) NOT NULL,
  `firstName` varchar(32) NOT NULL,
  `lastName` varchar(32) NOT NULL,
  `phone` varchar(32) NOT NULL,
  `email` varchar(255) NOT NULL,
  `website` varchar(255) default NULL,
  `version` bigint(20) default NULL,
  `address` varchar(255) default NULL,
  `address2` varchar(255) default NULL,
  `city` varchar(40) default NULL,
  `country` varchar(40) default NULL,
  `province` varchar(40) default NULL,
  `postalCode` varchar(10) default NULL,
  `enabled` char(1) default NULL,
  `accountExpired` char(1) NOT NULL,
  `accountLocked` char(1) NOT NULL,
  `credentialsExpired` char(1) NOT NULL,
  PRIMARY KEY  (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table `j_user`
-- 

INSERT INTO `j_user` VALUES ('admin', 'dd94709528bb1c83d08f3088d4043f4742891f4f', 'dd94709528bb1c83d08f3088d4043f4742891f4f', 'Trung', 'Dinh', '01689300178', 'trungnd07@gmail.com', 'sssssxxxxxxxx', 0, 'nhà không số phố không tên', NULL, 'Sông công', 'VN', 'TNN', '12345', 'Y', 'N', 'N', 'N');
INSERT INTO `j_user` VALUES ('trung', '7c4a8d09ca3762af61e59520943dc26494f8941b', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'đasa', 'sdsds', '1234567890', 'sai@yahoo.com', NULL, NULL, 'adsadsa', NULL, 'sdasdsa', 'VN', 'DB', '12345', 'Y', 'N', 'N', 'N');
INSERT INTO `j_user` VALUES ('aa', 'aa', 'aaa', 'aaa', 'aa', 'aa', 'aa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Y', 'N', 'N', 'N');
INSERT INTO `j_user` VALUES ('saix', '69c5fcebaa65b560eaf06c3fbeb481ae44b8d618', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'ss', 'ss', '1234567890', 'sai1@yahoo.com', '', 0, '12121', NULL, '12121', 'AZ', '121', '12345', 'Y', 'N', 'N', 'N');
INSERT INTO `j_user` VALUES ('saixz', '69c5fcebaa65b560eaf06c3fbeb481ae44b8d618', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'ss', 'ss', '1234567890', 'sai12@yahoo.com', '', 0, '12121', NULL, '12121', 'AZ', '121', '12345', 'Y', 'N', 'N', 'N');
INSERT INTO `j_user` VALUES ('dddd', '69c5fcebaa65b560eaf06c3fbeb481ae44b8d618', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'adsadsa', 'sd', '1234567890', 'ww@ggm.com', 'qwqwq', 0, 'qwqwq', NULL, 'd', 'US', 'WA', '12345', 'Y', 'N', 'N', 'N');
