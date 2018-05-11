/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ubiquitouslearning

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-05-11 23:03:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `indexPic` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` char(30) COLLATE utf8_bin NOT NULL,
  `t_id` int(11) NOT NULL,
  `type` char(10) COLLATE utf8_bin DEFAULT NULL,
  `handle_type` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `state` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT 'common',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '2018-04-12 08:00:00', 'string', 'string', '0', '1', '1', 'common');
INSERT INTO `course` VALUES ('2', '2018-04-13 08:00:00', 'string', 'string', '0', '1', '2', 'recommend');
INSERT INTO `course` VALUES ('3', '2018-04-13 08:00:00', 'string', 'string', '0', '1', '1', 'recommend');
INSERT INTO `course` VALUES ('4', '2018-04-13 08:00:00', 'string', 'string', '0', '1', '2', 'recommend');
INSERT INTO `course` VALUES ('5', '2018-04-13 08:00:00', 'string', 'string', '0', '1', '0', 'common');
INSERT INTO `course` VALUES ('6', '2018-04-13 08:00:00', 'string', 'string', '0', '1', '0', 'common');
