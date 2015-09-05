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
-- Table structure for table `j_product`
-- 

CREATE TABLE `j_product` (
  `product_id` bigint(20) NOT NULL auto_increment,
  `category_id` bigint(20) NOT NULL,
  `manufacturer_id` bigint(20) default NULL,
  `discount` double default NULL,
  `mediumImage` varchar(255) default NULL,
  `smallImage` varchar(255) default NULL,
  `largeImage` varchar(255) default NULL,
  `description` text,
  `height` double default NULL,
  `length` double default NULL,
  `name` varchar(64) NOT NULL,
  `sort_desc` varchar(255) default NULL,
  `unit` varchar(32) default NULL,
  `unitPrice` double default NULL,
  `weight` double default NULL,
  `width` double default NULL,
  `stock` bigint(20) default NULL,
  `sales` bigint(20) default NULL,
  `cdate` date default NULL,
  `mdate` date default NULL,
  `special` bit(1) default NULL,
  `active` bit(1) default NULL,
  `taxed` bit(1) default NULL,
  PRIMARY KEY  (`product_id`),
  KEY `FKDE736A1A22CA49D4` (`manufacturer_id`),
  KEY `FKDE736A1A9AD00BB4` (`category_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=23 ;

-- 
-- Dumping data for table `j_product`
-- 

INSERT INTO `j_product` VALUES (3, 3, 1, 0.05, 'fb798b699668f6deba3bdcd0d34e56be75e63a5e.jpg', '96aef16a7db5136e95d31f11aeca5440574f89ff.jpg', '', '<p>C&aacute;c sản phẩm m&aacute;y bay điều khiển từ xa với thiết kế độc đ&aacute;o, độ bay cao v&agrave; ổn định mang nhiều cảm hứng cho người chơi.C&aacute;c sản phẩm m&aacute;y bay điều khiển từ xa với thiết kế độc đ&aacute;o, độ bay cao v&agrave; ổn định mang nhiều cảm hứng cho người chơi.&nbsp;</p>\r\n<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-&nbsp;L&agrave; d&ograve;ng sản phẩm chủ lực được nhiều giải thưởng của Silverlit.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - Thiết kế bằng chất liệu xốp dẻo, chống va đập v&agrave; bắt mắt.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - Tầm điểu khiển khoản từ 15 - 20 m.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - C&oacute; 3 tần số A,B,C.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - Một điều khiển c&oacute; thể chơi c&ugrave;ng một l&uacute;c m&aacute;y bay c&ugrave;ng tần số.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - C&oacute; mẫu m&aacute;y bay c&oacute; thể bay trong nh&agrave; v&agrave; ngo&agrave;i trời.</p>', NULL, NULL, 'R/C Boeing 737', 'Các sản phẩm máy bay điều khiển từ xa với thiết kế độc đáo, độ bay cao và ổn định mang nhiều cảm hứng cho người chơi.\r\n', 'chiec', 990000, 1.5, NULL, 2, NULL, '2007-12-03', '2007-12-09', NULL, '', '');
INSERT INTO `j_product` VALUES (2, 2, 1, NULL, 'e32cca3c6fb1ea10596e4ea5f8267fb990cddb40.jpg', '1e1da027103919a792dfa611f189d707d9cd7c5b.jpg', '', '<p>Loại xe điều khiển cực "hot" được m&ocirc; phỏng theo bản quyền của xe thật. Đua cực nhanh với vận tốc 200km/h v&agrave; c&ograve;n được người chơi chờ đ&oacute;n từng mẫu để suy tập.Loại xe điều khiển cực "hot" được m&ocirc; phỏng theo bản quyền của xe thật. Đua cực nhanh với vận tốc 200km/h v&agrave; c&ograve;n được người chơi chờ đ&oacute;n từng mẫu để suy tập.</p>\r\n<p>&nbsp;&nbsp;&nbsp; - Thiết kế với chật liệu nhựa, m&aacute;u sắc đẹp, an to&agrave;n cho trẻ khi chơi.<br />&nbsp;&nbsp;&nbsp; - Với tốc độ điều khiển nhanh.<br />&nbsp;&nbsp;&nbsp; - Chế độ đ&egrave;n cực s&aacute;ng, c&oacute; đ&egrave;n pha, xin nhan.<br />&nbsp;&nbsp;&nbsp; - Chế độ pin: trong lần xạc đầu ti&ecirc;n xạc 5 tiếng, sau đ&oacute; xạc 4 tiếng l&agrave; đủ năng lượng pin khi chơi.<br />&nbsp;&nbsp;&nbsp; - Cần sử dụng pin đ&uacute;ng loại v&agrave; đ&uacute;ng quy c&aacute;ch theo hướng dẫn sử dụng in tr&ecirc;n vỏ hộp.</p>', NULL, NULL, 'Xe Chở Xăng Dầu Có Máy Phát', 'Loại xe điều khiển cực "hot" được mô phỏng theo bản quyền của xe thật', 'chiec', 310000, 0.2, NULL, 192, NULL, '2007-12-03', '2007-12-03', NULL, '', '');
INSERT INTO `j_product` VALUES (7, 3, 1, 0.01, 'ef2f7e7244cc5939def37b041af3d2d332c2c92f.jpg', '7fecc672b30ad56d93ecc2b63b4e81cd2db7c8ea.jpg', '', '<p>C&aacute;c sản phẩm m&aacute;y bay điều khiển từ xa với thiết kế độc đ&aacute;o, độ bay cao v&agrave; ổn định mang nhiều cảm hứng cho người chơi.C&aacute;c sản phẩm m&aacute;y bay điều khiển từ xa với thiết kế độc đ&aacute;o, độ bay cao v&agrave; ổn định mang nhiều cảm hứng cho người chơi.<br />L&agrave; d&ograve;ng sản phẩm chủ lực được nhiều giải thưởng của Silverlit.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - Thiết kế bằng chất liệu xốp dẻo, chống va đập v&agrave; bắt mắt.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - Tầm điểu khiển khoản từ 15 - 20 m.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - C&oacute; 3 tần số A,B,C.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - Một điều khiển c&oacute; thể chơi c&ugrave;ng một l&uacute;c m&aacute;y bay c&ugrave;ng tần số.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - C&oacute; mẫu m&aacute;y bay c&oacute; thể bay trong nh&agrave; v&agrave; ngo&agrave;i trời.</p>', NULL, NULL, 'Máy Bay (85622)', 'Các sản phẩm máy bay điều khiển từ xa với thiết kế độc đáo, độ bay cao và ổn định mang nhiều cảm hứng cho người chơi.Các sản phẩm máy bay điều khiển từ xa với thiết kế độc đáo, độ bay cao và ổn định mang nhiều cảm hứng cho người chơi.', 'chiec', 599000, 1, NULL, 2, NULL, '2007-12-04', '2007-12-04', NULL, '', '');
INSERT INTO `j_product` VALUES (4, 3, 1, NULL, '43836836b3352868c99b90956a2a1dcb56ce056c.jpg', 'a939d270e74be91dc00c7a2c7a838ec8c7878308.jpg', '', '<table border="0" cellspacing="0" cellpadding="0" width="100%">\r\n<tbody>\r\n<tr>\r\n<td>C&aacute;c sản phẩm m&aacute;y bay điều khiển từ xa với thiết kế độc đ&aacute;o, độ bay cao v&agrave; ổn định mang nhiều cảm hứng cho người chơi.<br />L&agrave; d&ograve;ng sản phẩm chủ lực được nhiều giải thưởng của Silverlit.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - Thiết kế bằng chất liệu xốp dẻo, chống va đập v&agrave; bắt mắt.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - Tầm điểu khiển khoản từ 15 - 20 m.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - C&oacute; 3 tần số A,B,C.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - Một điều khiển c&oacute; thể chơi c&ugrave;ng một l&uacute;c m&aacute;y bay c&ugrave;ng tần số.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - C&oacute; mẫu m&aacute;y bay c&oacute; thể bay trong nh&agrave; v&agrave; ngo&agrave;i trời.</td>\r\n</tr>\r\n</tbody>\r\n</table>', NULL, NULL, 'Máy Bay Thể Thao Điều Khiển', 'Các sản phẩm máy bay điều khiển từ xa với thiết kế độc đáo, độ bay cao và ổn định mang nhiều cảm hứng cho người chơi.Là dòng sản phẩm chủ lực được nhiều giải thưởng của Silverlit.', 'chiec', 475000, 1, NULL, 45, NULL, '2007-12-03', '2007-12-04', NULL, '', '');
INSERT INTO `j_product` VALUES (9, 8, 1, NULL, '97d7dd0ed9b35a77e65493e176ad498f7c7ac724.jpg', 'd4429de182f27b8f45a9c91140035f27de543842.jpg', '', '<p>L&agrave; d&ograve;ng xe chạy trớn mini ph&ugrave; hợp với b&eacute; dưới 5 tuổi. Với bộ đường đua gồm: c&aacute;c thanh đường đua, cổng xuất ph&aacute;t, chướng ngại vật, b&eacute; sẽ lắp r&aacute;p theo hướng dẫn hoặc lắp r&aacute;p theo t&iacute;nh s&aacute;ng của b&eacute;. Kết hợp chơi c&ugrave;ng với xe nano chạy trớn.L&agrave; d&ograve;ng xe chạy trớn mini ph&ugrave; hợp với b&eacute; dưới 5 tuổi. Với bộ đường đua gồm: c&aacute;c thanh đường đua, cổng xuất ph&aacute;t, chướng ngại vật, b&eacute; sẽ lắp r&aacute;p theo hướng dẫn hoặc lắp r&aacute;p theo t&iacute;nh s&aacute;ng của b&eacute;. Kết hợp chơi c&ugrave;ng với xe nano chạy trớn.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - L&agrave; loại xe chạy trớn tốc độ cao.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - Nhiều kiểu d&aacute;ng mẫu m&atilde; v&agrave; m&agrave;u sắc vui tươi.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Thiết kế độc đ&aacute;o: c&oacute; phần để nh&eacute;t đồng xu v&agrave;o, khi vận h&agrave;nh xe sẽ bốc đầu xoay v&ograve;ng tr&ograve;n v&agrave; chạy thẳng rất đẹp mắt.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - C&oacute; thể tổ chức thi đua với nhau: bố mẹ hay c&ugrave;ng với c&aacute;c bạn.</p>', NULL, NULL, 'Bộ Xe Đua Nano Có Đường Đua ', 'Là dòng xe chạy trớn mini phù hợp với bé dưới 5 tuổi. Với bộ đường đua gồm: các thanh đường đua, cổng xuất phát, chướng ngại vật, bé sẽ lắp ráp theo hướng dẫn hoặc lắp ráp theo tính sáng của bé. Kết hợp chơi cùng với xe nano chạy trớn.', '', 160000, 0.8, NULL, NULL, NULL, '2007-12-04', '2007-12-04', NULL, '', '');
INSERT INTO `j_product` VALUES (10, 2, NULL, NULL, '9ecdffff67c80436685aaf5915b878b41ce5eb67.jpg', 'cb975da916211a53e9545ab7d5055b75eb48ac01.jpg', '', '<p>Loại xe điều khiển cực "hot" được m&ocirc; phỏng theo bản quyền của xe thật. Đua cực nhanh với vận tốc 200km/h v&agrave; c&ograve;n được người chơi chờ đ&oacute;n từng mẫu để suy tập.Loại xe điều khiển cực "hot" được m&ocirc; phỏng theo bản quyền của xe thật. Đua cực nhanh với vận tốc 200km/h v&agrave; c&ograve;n được người chơi chờ đ&oacute;n từng mẫu để suy tập.</p>\r\n<p>&nbsp;&nbsp;&nbsp; - Thiết kế với chật liệu nhựa, m&aacute;u sắc đẹp, an to&agrave;n cho trẻ khi chơi.<br />&nbsp;&nbsp;&nbsp; - Với tốc độ điều khiển nhanh.<br />&nbsp;&nbsp;&nbsp; - Chế độ đ&egrave;n cực s&aacute;ng, c&oacute; đ&egrave;n pha, xin nhan.<br />&nbsp;&nbsp;&nbsp; - Chế độ pin: trong lần xạc đầu ti&ecirc;n xạc 5 tiếng, sau đ&oacute; xạc 4 tiếng l&agrave; đủ năng lượng pin khi chơi.<br />&nbsp;&nbsp;&nbsp; - Cần sử dụng pin đ&uacute;ng loại v&agrave; đ&uacute;ng quy c&aacute;ch theo hướng dẫn sử dụng in tr&ecirc;n vỏ hộp.</p>', NULL, NULL, 'Xe Điều Khiển S.O.S', 'Loại xe điều khiển cực "hot" được mô phỏng theo bản quyền của xe thật. Đua cực nhanh với vận tốc 200km/h và còn được người chơi chờ đón từng mẫu để suy tập', '', 239000, 0.6, NULL, NULL, NULL, '2007-12-04', '2007-12-04', NULL, '', '');
INSERT INTO `j_product` VALUES (11, 13, NULL, NULL, 'a1d1185f2cdaa300ecf6f541155b9410c6f46afb.jpg', '64ea9f2f81827b4e80641c91fa320144967c97eb.jpg', '', '<p>C&aacute;c sản phẩm đồ chơi mang t&iacute;nh gi&aacute;o dục cao gồm c&aacute;c bộ lắp r&aacute;p h&igrave;nh.C&aacute;c sản phẩm đồ chơi mang t&iacute;nh gi&aacute;o dục cao gồm c&aacute;c bộ lắp r&aacute;p h&igrave;nh.</p><br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - Ph&ugrave; hợp cho b&eacute; từ 3 tuổi trở l&ecirc;n.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - C&aacute;c sản phẩm được thiết kế với chất liệu v&agrave; h&igrave;nh ảnh đẹp, sinh động.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - Th&ocirc;ng qua c&aacute;c bộ đồ chơi với nhiều mẫu kh&aacute;c nhau gi&uacute;p b&eacute; ph&aacute;t triển c&aacute;c kỹ năng suy nghĩ, nhận x&eacute;t v&agrave; cảm nhận về mọi vật xung quanh.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - C&aacute;c tr&ograve; chơi mang t&iacute;nh tập thể, gắn kết t&igrave;nh cảm của b&eacute; với gia đ&igrave;nh hoặc bạn b&egrave; th&ocirc;ng qua việc mọi người c&ugrave;ng chơi với nhau.', NULL, NULL, 'Collection words games', 'Các sản phẩm đồ chơi mang tính giáo dục cao gồm các bộ lắp ráp hình.', '', 95000, 0.7, NULL, NULL, NULL, '2007-12-04', '2007-12-04', NULL, '', '');
INSERT INTO `j_product` VALUES (12, 10, NULL, NULL, 'a1b91de06db2b265f7bcd0d2faa92d8914258249.jpg', '7b9f90c05fff1c1b668cdb8e45ce8ed4f7f19a0c.jpg', '', '<p><span><strong>Th&ocirc;ng tin m&ocirc; tả: </strong>Bộ m&aacute;y PS2 căn bản gồm 1 m&aacute;y, 1 tay bấm, 1 adapter nguồn điện 220V v&agrave; 2 game. M&aacute;y PS2 với t&iacute;nh năng vượt trội gồm 2 khe cắm tay bấm v&agrave; 2 khe đọc thẻ nhớ &bull; 2 cổng USB hổ trợ: B&agrave;n ph&iacute;m, chuột, USB Stick, Tay L&aacute;i Xe, Webcam, S&uacute;ng Hồng Ngoại &bull; Khả năng hỗ trợ chơi l&ecirc;n đến 1 l&uacute;c 8 người c&ugrave;ng với thiết bị Multitap &bull; Sẽ rất th&uacute; vị khi chơi c&ugrave;ng c&aacute;c thiết bị như: Thảm Nhảy, Tay L&aacute;i Xe, Webcam, Trống Drum..</span></p>', NULL, NULL, 'Máy bộ PlayStation 2 - Model 77006 đen', '', '', 3198000, 4, NULL, NULL, NULL, '2007-12-04', '2007-12-04', NULL, '', '');
INSERT INTO `j_product` VALUES (13, 13, NULL, NULL, 'd9a528a2db15abce6d2ec38966440bb8535b949b.jpg', '540524782ad450078d37af3e4eaf862a9f3c2178.jpg', '', '<p>Tranh xếp h&igrave;nh nh&acirc;n vật tr&ograve; chơi trực tuyến V&otilde; L&acirc;m Truyền Kỳ.Tranh xếp h&igrave;nh nh&acirc;n vật tr&ograve; chơi trực tuyến V&otilde; L&acirc;m Truyền Kỳ.</p><br /><span><strong>Truyền thuyết - &Yacute; nghĩa: </strong>Phi&ecirc;u Di&ecirc;u Lưu Thủy, Kỳ nữ so t&agrave;i, V&otilde; c&ocirc;ng thi&ecirc;n hạ, Nga Mi v&agrave; Th&uacute;y Y&ecirc;n ai l&agrave; đệ nhất cao thủ? H&atilde;y c&ugrave;ng nhau kh&aacute;m ph&aacute; bạn nh&eacute;!<br /><span><strong>Khổ tranh xếp: </strong>30 x 38 cm được tạo th&agrave;nh từ 247 mảnh nhỏ gh&eacute;p lại.</span></span>', NULL, NULL, 'Tranh xếp-Hệ Thủy Song Hành Hiệp Nữ', 'Tranh xếp-Hệ Thủy Song Hành Hiệp Nữ', '', 35000, 0.3, NULL, 289, NULL, '2007-12-04', '2007-12-04', NULL, '', '');
INSERT INTO `j_product` VALUES (14, 13, 1, NULL, '36be98b3c35e086b062521220e660430f1a248d8.jpg', '47d07dfd292f0b2aa812bf70e2b1220c8df18bf1.jpg', '', '<table border="0" cellspacing="0" cellpadding="0" width="100%">\r\n<tbody>\r\n<tr>\r\n<td>C&aacute;c sản phẩm giải tr&iacute; đồ chơi th&uacute; vị.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - Với thiết kế độc đ&aacute;o v&agrave; sinh động, c&aacute;c sản phẩm kh&ocirc;ng những đặc trưng cho một tr&ograve; ti&ecirc;u khiển s&ocirc;i nổi m&agrave; c&ograve;n l&agrave; cuộc thi mang t&iacute;nh tr&iacute; tuệ, b&eacute; sẽ ph&aacute;t triển được t&iacute;nh tư duy v&agrave; cộng đồng rất nhiều khi tham gia v&agrave;o&nbsp;tr&ograve; chơi.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -&nbsp;C&aacute;c tr&ograve; chơi c&ograve;n vung&nbsp;đắp t&igrave;nh cảm gia&nbsp;đ&igrave;nh v&agrave; bạn b&egrave;&nbsp;với nhau th&ocirc;ng qua việc mọi người c&ugrave;ng chơi với nhau.&nbsp;</td>\r\n</tr>\r\n</tbody>\r\n</table>', NULL, NULL, 'Ghép Hình Từ Tính ', '', '', 88000, 0.7, NULL, 56, NULL, '2007-12-04', '2007-12-04', NULL, '', '');
INSERT INTO `j_product` VALUES (15, 19, NULL, NULL, 'dad73de0bf2781129d45237622c583513cb80f8a.jpg', '656ddf131b9bd07c637e49a24ad6ff81282202a1.jpg', '', '<html />', NULL, NULL, 'Phi tiêu Joerex JD28198 ', '', '', 107200, 0.8, NULL, 0, NULL, '2007-12-04', '2007-12-04', NULL, '', '');
INSERT INTO `j_product` VALUES (16, 19, NULL, NULL, '54bbf4ceb5b260a9c0ee7396a95c3f9b57644bed.jpg', 'f0a0609748078beb432a13bc28eefeba217ba452.jpg', '', '<table border="0" cellspacing="0" cellpadding="0" width="100%">\r\n<tbody>\r\n<tr>\r\n<td>\r\n<p>K&iacute;ch thước: Rộng 43 x D&agrave;i 43cm.</p></td>\r\n</tr>\r\n</tbody>\r\n</table>', NULL, NULL, 'Bảng Phi tiêu Joerex JD6080 ', '', '', 110000, 0.3, NULL, 5, NULL, '2007-12-04', '2007-12-04', NULL, '', '');
INSERT INTO `j_product` VALUES (17, 6, NULL, NULL, '1d981f6190bc9143db5218448a060c2bb4ecd29f.jpg', 'cbb938c37352c7d2890369242f88478404e00e48.jpg', '', '<table border="0" cellspacing="0" cellpadding="0" width="100%">\r\n<tbody>\r\n<tr>\r\n<td>C&aacute;c loại Robot giải tr&iacute; c&oacute; bộ phận l&acirc;p tr&igrave;nh ngay tr&ecirc;n con Robot.<br />Ngo&agrave;i chức năng lập tr&igrave;nh để Robot c&oacute; những động t&aacute;c thật đẹp như: đi tới, đi lui, quẹo tr&aacute;i, quẹo phải. C&ograve;n c&oacute; những con robot để ghi &acirc;m hoặc robot c&oacute; thể lắp r&aacute;p lại để chơi.<br />Tr&ograve; chơi ph&ugrave; phợp cho b&eacute; c&oacute; c&aacute; t&iacute;nh năng động, v&agrave; b&eacute; ham t&igrave;m t&ograve;i kh&aacute;m ph&aacute;.</td>\r\n</tr>\r\n</tbody>\r\n</table>', NULL, NULL, 'Robot Thu Âm (88308) ', '', '', 270000, 0.9, NULL, 60, NULL, '2007-12-04', '2007-12-04', NULL, '', '');
INSERT INTO `j_product` VALUES (18, 6, NULL, NULL, 'd48b716c93c2343be269abfd97acaa1ed63647c7.jpg', 'ab77ac1cd9ef3db564a8b115acd8dd7fbb6790dd.jpg', '', '<table border="0" cellspacing="0" cellpadding="0" width="100%">\r\n<tbody>\r\n<tr>\r\n<td>I -&nbsp;CYBIE l&agrave; sản phẩm k&igrave; diệu kết hợp giữa đồ chơi v&agrave; c&ocirc;ng nghệ vi mạch điện tử, hơn 1.400 linh kiện tinh xảo. Bộ vi mạch điều khiển v&agrave; nhiều bộ phện cảm ứng nhạy với sự&nbsp;tiếp x&uacute;c, &aacute;nh s&aacute;ng v&agrave; &acirc;m thanh.<br />I - CYBIE c&oacute; t&iacute;nh t&igrave;nh v&agrave; tập qu&aacute;n giống như một con ch&oacute; thật, n&oacute; l&agrave;m được nhiều động t&aacute;c tuyệt vời hơn cả ch&oacute; thật, canh g&aacute;c, nhảy m&uacute;a...n&oacute; c&oacute; thể cảm nhận được m&ocirc;i trường xung quanh v&agrave; cho ra những phản ứng kh&aacute;c nhau.<br />Lưu &yacute; : Lần đầu ti&ecirc;n sử dụng, xạc pin trong thời gian 6 tiếng, từ lần 2 trở đi chỉ cần 3 đến 4 tiếng.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Kh&ocirc;ng được xạc pin qu&aacute; 8 tiếng.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Kh&ocirc;ng n&ecirc;n để pin trong trạng th&aacute;i hết pin qu&aacute; 3 ng&agrave;y.<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Nếu thời gian d&agrave;i kh&ocirc;ng sử dụng, n&ecirc;n th&aacute;o pin ra ngo&agrave;i</td>\r\n</tr>\r\n</tbody>\r\n</table>', NULL, NULL, 'I-Cybie w/ Charger - 2 Colors Asst''d', '', '', 3250000, 1.5, NULL, 3, NULL, '2007-12-04', '2007-12-04', NULL, '', '');
INSERT INTO `j_product` VALUES (19, 6, NULL, NULL, '03cd4637b32aed71f75b1db74511e6716de87d1b.jpg', 'a794b239b376dd16128d6be47a02525565e84ca6.jpg', '', '<table border="0" cellspacing="0" cellpadding="0" width="100%">\r\n<tbody>\r\n<tr>\r\n<td>C&aacute;c loại Robot giải tr&iacute; c&oacute; bộ phận l&acirc;p tr&igrave;nh ngay tr&ecirc;n con Robot.<br />Ngo&agrave;i chức năng lập tr&igrave;nh để Robot c&oacute; những động t&aacute;c thật đẹp như: đi tới, đi lui, quẹo tr&aacute;i, quẹo phải. C&ograve;n c&oacute; những con robot để ghi &acirc;m hoặc robot c&oacute; thể lắp r&aacute;p lại để chơi.<br />Tr&ograve; chơi ph&ugrave; phợp cho b&eacute; c&oacute; c&aacute; t&iacute;nh năng động, v&agrave; b&eacute; ham t&igrave;m t&ograve;i kh&aacute;m ph&aacute;</td>\r\n</tr>\r\n</tbody>\r\n</table>', NULL, NULL, 'Robot Tự Lắp Ráp ', 'Các loại Robot giải trí có bộ phận lâp trình ngay trên con Robot.', '', 400000, 1, NULL, 27, NULL, '2007-12-04', '2007-12-04', NULL, '', '');
INSERT INTO `j_product` VALUES (20, 22, NULL, NULL, '6433bc18633e56a6ce0da5a07f647fc1de4ff58d.jpg', '35c3c7e6db943f7b2dac6d92e4a811b8d11dc5e1.jpg', '', '<html />', NULL, NULL, 'Cá Sấu Điều Khiển ', '', '', 250000, 0.7, NULL, 50, NULL, '2007-12-04', '2007-12-04', NULL, '', '');
INSERT INTO `j_product` VALUES (21, 17, NULL, NULL, 'a5ad235d63eb07440f521220954dc910f9317a3d.jpg', '08cb4996623989731cc310e868a8ab751b8d0445.jpg', '', '<table border="0" cellspacing="0" cellpadding="0" width="100%">\r\n<tbody>\r\n<tr>\r\n<td>\r\n<p>Đồ chơi được l&agrave;m từ chất liệu nhựa cao cấp v&agrave; được chứng nhận l&agrave; an to&agrave;n cho trẻ. Mỗi bộ đồ chơi sẽ gi&uacute;p cho b&eacute; kh&aacute;m ph&aacute; ra những điều th&uacute; vị về nghề nghiệp trong tương lai.<br />Đồ chơi nh&agrave; bếp với nhiều mẫu m&atilde; kh&aacute;c nhau, m&agrave;u sắc đẹp v&agrave; phong ph&uacute;. B&eacute; c&oacute; thể sưu tập mỗi bộ đồ chơi kh&aacute;c nhau để tạo một gian bếp.<br />Bộ đồ chơi gi&uacute;p b&eacute; &yacute; thức được những c&ocirc;ng việc xung quanh v&agrave; tập t&iacute;nh kh&eacute;o l&eacute;o cho b&eacute;.</p></td>\r\n</tr>\r\n</tbody>\r\n</table>', NULL, NULL, 'Bộ Bếp 2 Lò 16 Chi Tiết', 'Đồ chơi được làm từ chất liệu nhựa cao cấp và được chứng nhận là an toàn cho trẻ.', '', 213000, 1, NULL, 60, NULL, '2007-12-04', '2007-12-04', NULL, '', '');
INSERT INTO `j_product` VALUES (22, 17, NULL, NULL, '5ed35437b6c9725176626645a9069c960acaf60b.jpg', '008b28ec11ee4e0b7d6cd0810231e2a7d5f1289d.jpg', '', '<p>Đồ chơi được l&agrave;m từ chất liệu nhựa cao cấp v&agrave; được chứng nhận l&agrave; an to&agrave;n cho trẻ. Mỗi bộ đồ chơi sẽ gi&uacute;p cho b&eacute; kh&aacute;m ph&aacute; ra những điều th&uacute; vị về nghề nghiệp trong tương lai.<br />Đồ chơi nh&agrave; bếp với nhiều mẫu m&atilde; kh&aacute;c nhau, m&agrave;u sắc đẹp v&agrave; phong ph&uacute;. B&eacute; c&oacute; thể sưu tập mỗi bộ đồ chơi kh&aacute;c nhau để tạo một gian bếp.<br />Bộ đồ chơi gi&uacute;p b&eacute; &yacute; thức được những c&ocirc;ng việc xung quanh v&agrave; tập t&iacute;nh kh&eacute;o l&eacute;o cho b&eacute;.</p>', NULL, NULL, 'Máy Đanh Trộn Hỗn Hợp B/O', 'Đồ chơi được làm từ chất liệu nhựa cao cấp và được chứng nhận là an toàn cho trẻ.', '', 153000, 1, NULL, 8, NULL, '2007-12-04', '2007-12-04', NULL, '', '');