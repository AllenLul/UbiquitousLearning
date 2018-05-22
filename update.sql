/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ubiquitouslearning

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-05-22 14:32:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for appended_document
-- ----------------------------
DROP TABLE IF EXISTS `appended_document`;
CREATE TABLE `appended_document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_bin NOT NULL,
  `type` char(10) COLLATE utf8_bin DEFAULT NULL,
  `homework_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of appended_document
-- ----------------------------

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `indexPic` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` char(30) COLLATE utf8_bin NOT NULL,
  `t_id` int(11) NOT NULL,
  `type` char(10) COLLATE utf8_bin DEFAULT NULL,
  `handle_type` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `state` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT 'common',
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '2018-04-12 08:00:00', 'e:\\img\\course\\6b695b58a8c141161d5b9d9c39259579_r.jpg', 'string1', '0', '1', '1', 'common', null);
INSERT INTO `course` VALUES ('2', '2018-04-13 08:00:00', 'string', 'string1', '0', '1', '2', 'recommend', null);
INSERT INTO `course` VALUES ('3', '2018-04-13 08:00:00', 'string', 'string1', '0', '1', '1', 'recommend', null);
INSERT INTO `course` VALUES ('4', '2018-04-13 08:00:00', 'string', 'string2', '0', '1', '2', 'recommend', null);
INSERT INTO `course` VALUES ('5', '2018-04-13 08:00:00', 'string', 'string2', '0', '1', '0', 'common', null);
INSERT INTO `course` VALUES ('6', '2018-04-13 08:00:00', 'string', 'string3', '0', '1', '0', 'common', null);

-- ----------------------------
-- Table structure for courseware
-- ----------------------------
DROP TABLE IF EXISTS `courseware`;
CREATE TABLE `courseware` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL,
  `downlaod_times` int(11) DEFAULT '0',
  `type` char(10) COLLATE utf8_bin NOT NULL,
  `url` varchar(255) COLLATE utf8_bin NOT NULL,
  `is_pass` char(1) COLLATE utf8_bin NOT NULL DEFAULT '1',
  `course_cap` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `handle_type` char(1) COLLATE utf8_bin DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of courseware
-- ----------------------------
INSERT INTO `courseware` VALUES ('1', '0', '0', 'string', 'string', '1', 'string', '1');
INSERT INTO `courseware` VALUES ('2', '0', '0', 'string', 'string', '1', 'string', '2');
INSERT INTO `courseware` VALUES ('3', '0', '0', 'string', 'string', '1', 'string', '1');
INSERT INTO `courseware` VALUES ('4', '0', '0', 'string', 'string', '1', 'string', '2');
INSERT INTO `courseware` VALUES ('5', '0', '0', 'string', 'string', '1', 'string', '0');

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL,
  `name` char(20) COLLATE utf8_bin NOT NULL,
  `type` char(10) COLLATE utf8_bin NOT NULL,
  `end_time` datetime NOT NULL,
  `detail` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of homework
-- ----------------------------
INSERT INTO `homework` VALUES ('1', '1', 'test', 'docx', '2018-05-27 15:16:31', 'asdas', '58');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `detail` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_time` datetime NOT NULL,
  `can_reply` char(1) COLLATE utf8_bin DEFAULT '0',
  `is_top` char(1) COLLATE utf8_bin DEFAULT '1',
  `reply_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('2', 'string', 'string', '2018-04-12 08:00:00', '1', '1', '0', '0');
INSERT INTO `post` VALUES ('3', 'string', 'string', '2018-04-12 08:00:00', '1', '1', '0', '0');
INSERT INTO `post` VALUES ('4', 'string', 'string', '2018-04-12 08:00:00', '1', '1', '0', '0');
INSERT INTO `post` VALUES ('5', 'string', 'string', '2018-04-12 08:00:00', '1', '1', '0', '0');
INSERT INTO `post` VALUES ('6', 'string', 'string', '2018-04-12 08:00:00', '1', '1', '0', '0');

-- ----------------------------
-- Table structure for submit_homework
-- ----------------------------
DROP TABLE IF EXISTS `submit_homework`;
CREATE TABLE `submit_homework` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `homework_id` int(11) NOT NULL,
  `url` varchar(255) COLLATE utf8_bin NOT NULL,
  `score` varchar(255) COLLATE utf8_bin DEFAULT '',
  `gmt_create` datetime NOT NULL,
  `gmt_update` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of submit_homework
-- ----------------------------
INSERT INTO `submit_homework` VALUES ('1', '54', '1', 'E:\\50条SQL.docx', '99', '2018-05-15 15:18:58', '2018-05-15 15:18:58');
INSERT INTO `submit_homework` VALUES ('3', '55', '1', 'E:\\50条SQL.docx', '', '2018-05-15 15:45:18', '2018-05-21 19:47:36');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(15) COLLATE utf8_bin NOT NULL,
  `nickname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department` char(15) COLLATE utf8_bin DEFAULT NULL,
  `phone` char(15) COLLATE utf8_bin DEFAULT NULL,
  `headPic` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `number` varchar(35) COLLATE utf8_bin NOT NULL,
  `gender` char(2) COLLATE utf8_bin NOT NULL,
  `note` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `role` varchar(30) COLLATE utf8_bin DEFAULT '无',
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('54', 'a', null, 'a', 'a', 'a', 'pxc', 'a', 'a', 'student', '$2a$10$I6nxfcHKAlW1bjovj5c2guE.vaydshW4xQI2NU6iifSPdQaN5NIIu');
INSERT INTO `user` VALUES ('55', 'a', null, 'a', 'a', 'a', 'test', 'a', 'a', 'manager', 'test');
INSERT INTO `user` VALUES ('58', 'a', null, 'a', 'b', 'a', 'testMd5', 'a', 'a', 'teacher', '098f6bcd4621d373cade4e832627b4f6');

-- ----------------------------
-- Table structure for user_course
-- ----------------------------
DROP TABLE IF EXISTS `user_course`;
CREATE TABLE `user_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `course_id` int(11) DEFAULT NULL,
  `gmt_create` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user_course
-- ----------------------------
INSERT INTO `user_course` VALUES ('2', '58', '1', '2018-04-15 11:50:48');
INSERT INTO `user_course` VALUES ('3', '54', '2', '2018-04-15 11:55:05');
INSERT INTO `user_course` VALUES ('4', '9', '2', '2018-04-15 13:26:46');

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL,
  `name` char(30) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_bin NOT NULL,
  `is_pass` char(1) COLLATE utf8_bin NOT NULL DEFAULT '1',
  `length` double NOT NULL,
  `times` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('1', '1', '1', '1', '1', '1', '0');
INSERT INTO `video` VALUES ('2', '1', 'junit测试数据', 'test', '1', '3600', '3600');
