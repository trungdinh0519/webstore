-- phpMyAdmin SQL Dump
-- version 2.10.2
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Generation Time: Nov 13, 2007 at 09:55 PM
-- Server version: 5.0.45
-- PHP Version: 5.2.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Database: 'goodstore'
-- 

-- 
-- Dumping data for table 'j_category'
-- 

INSERT DELAYED IGNORE INTO j_category (categoryId, name, description, parent_id) VALUES 
(2, 'category1', NULL, NULL),
(3, 'category2', NULL, NULL),
(4, 'category3', NULL, NULL),
(5, 'category4', NULL, NULL),
(6, 'categoryroot', NULL, NULL),
(7, 'Danh mục chính', NULL, 6),
(8, 'thép đen', NULL, 6);
