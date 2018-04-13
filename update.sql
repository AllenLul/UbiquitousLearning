/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ubiquitouslearning

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-04-13 18:09:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for appended_document
-- ----------------------------
DROP TABLE IF EXISTS `appended_document`;
CREATE TABLE `appended_document` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`url`  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
`type`  char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`t_id`  int(11) NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of appended_document
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`create_time`  datetime NOT NULL ,
`indexPic`  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
`name`  char(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
`t_id`  int(11) NOT NULL ,
`type`  char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`handle_type`  char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '0' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=7

;

-- ----------------------------
-- Records of course
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES ('1', '2018-04-12 08:00:00', 'string', 'string', '0', '1', '0'), ('2', '2018-04-13 08:00:00', 'string', 'string', '0', '1', '0'), ('3', '2018-04-13 08:00:00', 'string', 'string', '0', '1', '0'), ('4', '2018-04-13 08:00:00', 'string', 'string', '0', '1', '0'), ('5', '2018-04-13 08:00:00', 'string', 'string', '0', '1', '0'), ('6', '2018-04-13 08:00:00', 'string', 'string', '0', '1', '0');
COMMIT;

-- ----------------------------
-- Table structure for courseware
-- ----------------------------
DROP TABLE IF EXISTS `courseware`;
CREATE TABLE `courseware` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`course_id`  int(11) NOT NULL ,
`downlaod_times`  int(11) NULL DEFAULT 0 ,
`type`  char(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
`url`  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
`is_pass`  char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '1' ,
`course_cap`  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '0' ,
`handle_type`  char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '0' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of courseware
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`t_id`  int(11) NOT NULL ,
`name`  char(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
`type`  char(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
`end_time`  datetime NOT NULL ,
`detail`  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of homework
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
`detail`  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
`create_time`  datetime NOT NULL ,
`can_reply`  char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '0' ,
`is_top`  char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '1' ,
`reply_id`  int(11) NULL DEFAULT NULL ,
`is_pass`  char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '1' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=7

;

-- ----------------------------
-- Records of post
-- ----------------------------
BEGIN;
INSERT INTO `post` VALUES ('2', 'string', 'string', '2018-04-12 08:00:00', '1', '1', '0', '1'), ('3', 'string', 'string', '2018-04-12 08:00:00', '1', '1', '0', '1'), ('4', 'string', 'string', '2018-04-12 08:00:00', '1', '1', '0', '1'), ('5', 'string', 'string', '2018-04-12 08:00:00', '1', '1', '0', '1'), ('6', 'string', 'string', '2018-04-12 08:00:00', '1', '1', '0', '1');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`name`  char(15) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
`nickname`  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`department`  char(15) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`phone`  char(15) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`headPic`  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`number`  char(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`gender`  char(2) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
`note`  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`role`  char(5) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`password`  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=8

;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', '浦希成', 'Ethanp', '计算机学院', '18852897377', null, '152210702119', '0', 'test', '1', '935377012'), ('2', 'test1', 'test1', null, 'test1', 'test1', 'test1', '1', 'test1', '1', 'test1'), ('3', 'test2', 'test2', null, 'test2', 'test2', null, '2', 'test2', '2', 'test2'), ('4', 'test1', 'test1', 'test1', 'test1', 'test1', 'test1', '1', 'test1', '1', 'test1'), ('5', 'test2', 'test2', 'test2', 'test2', 'test2', null, '2', 'test2', '2', 'test2'), ('6', 'test1', 'test1', null, null, 'test1', 'test1', '1', 'test1', '1', 'test1'), ('7', 'test2', 'test2', null, null, 'test2', null, '2', 'test2', '2', 'test2');
COMMIT;

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`course_id`  int(11) NOT NULL ,
`name`  char(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`url`  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
`is_pass`  char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '1' ,
`length`  double NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of video
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Auto increment value for appended_document
-- ----------------------------
ALTER TABLE `appended_document` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for course
-- ----------------------------
ALTER TABLE `course` AUTO_INCREMENT=7;

-- ----------------------------
-- Auto increment value for courseware
-- ----------------------------
ALTER TABLE `courseware` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for homework
-- ----------------------------
ALTER TABLE `homework` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for post
-- ----------------------------
ALTER TABLE `post` AUTO_INCREMENT=7;

-- ----------------------------
-- Auto increment value for user
-- ----------------------------
ALTER TABLE `user` AUTO_INCREMENT=8;

-- ----------------------------
-- Auto increment value for video
-- ----------------------------
ALTER TABLE `video` AUTO_INCREMENT=1;
