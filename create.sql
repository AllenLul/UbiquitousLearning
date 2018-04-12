/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ubiquitouslearning

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-04-12 17:19:30
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
  `t_id` int(11) NOT NULL,
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
  `indexPic` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` char(30) COLLATE utf8_bin NOT NULL,
  `t_id` int(11) NOT NULL,
  `type` char(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of course
-- ----------------------------

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of courseware
-- ----------------------------

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `t_id` int(11) NOT NULL,
  `name` char(20) COLLATE utf8_bin NOT NULL,
  `type` char(10) COLLATE utf8_bin NOT NULL,
  `end_time` datetime NOT NULL,
  `detail` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of homework
-- ----------------------------

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of post
-- ----------------------------

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
  `stu_num` char(20) COLLATE utf8_bin DEFAULT NULL,
  `tea_num` char(20) COLLATE utf8_bin DEFAULT NULL,
  `gender` char(2) COLLATE utf8_bin NOT NULL,
  `note` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `role` char(5) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '浦希成', 'Ethanp', '计算机学院', '18852897377', null, '152210702119', null, '0', 'test', '1', '935377012');

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of video
-- ----------------------------
