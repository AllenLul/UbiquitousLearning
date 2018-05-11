/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ubiquitouslearning

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-05-11 09:23:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for upload_files
-- ----------------------------
DROP TABLE IF EXISTS `upload_files`;
CREATE TABLE `upload_files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `urls` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of upload_files
-- ----------------------------
INSERT INTO `upload_files` VALUES ('1', 'test', 'http://p4a0xyee4.bkt.clouddn.com/FvXBnrvR39T5PALmk2YrlNPOKH4r,http://p4a0xyee4.bkt.clouddn.com/Fqus5Mqw7fpYKiTtb1yGLNVU1Tj9,');
