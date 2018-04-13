/*
SQLyog Trial v11.01 (32 bit)
MySQL - 5.5.28 : Database - ubiquitouslearning
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ubiquitouslearning` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `ubiquitouslearning`;

/*Table structure for table `appended_document` */

DROP TABLE IF EXISTS `appended_document`;

CREATE TABLE `appended_document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_bin NOT NULL,
  `type` char(10) COLLATE utf8_bin DEFAULT NULL,
  `t_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `appended_document` */

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `indexPic` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` char(30) COLLATE utf8_bin NOT NULL,
  `t_id` int(11) NOT NULL,
  `type` char(10) COLLATE utf8_bin DEFAULT NULL,
  `handle_type` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `course` */

insert  into `course`(`id`,`create_time`,`indexPic`,`name`,`t_id`,`type`,`handle_type`) values (1,'2018-04-12 08:00:00','string','string',0,'1','1'),(2,'2018-04-13 08:00:00','string','string',0,'1','2'),(3,'2018-04-13 08:00:00','string','string',0,'1','1'),(4,'2018-04-13 08:00:00','string','string',0,'1','2'),(5,'2018-04-13 08:00:00','string','string',0,'1','0'),(6,'2018-04-13 08:00:00','string','string',0,'1','0');

/*Table structure for table `courseware` */

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

/*Data for the table `courseware` */

insert  into `courseware`(`id`,`course_id`,`downlaod_times`,`type`,`url`,`is_pass`,`course_cap`,`handle_type`) values (1,0,0,'string','string','1','string','1'),(2,0,0,'string','string','1','string','2'),(3,0,0,'string','string','1','string','1'),(4,0,0,'string','string','1','string','2'),(5,0,0,'string','string','1','string','0');

/*Table structure for table `homework` */

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

/*Data for the table `homework` */

/*Table structure for table `post` */

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `post` */

insert  into `post`(`id`,`name`,`detail`,`create_time`,`can_reply`,`is_top`,`reply_id`) values (2,'string','string','2018-04-12 08:00:00','1','1',0),(3,'string','string','2018-04-12 08:00:00','1','1',0),(4,'string','string','2018-04-12 08:00:00','1','1',0),(5,'string','string','2018-04-12 08:00:00','1','1',0),(6,'string','string','2018-04-12 08:00:00','1','1',0);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(15) COLLATE utf8_bin NOT NULL,
  `nickname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department` char(15) COLLATE utf8_bin DEFAULT NULL,
  `phone` char(15) COLLATE utf8_bin DEFAULT NULL,
  `headPic` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `number` int(35) unsigned NOT NULL,
  `gender` char(2) COLLATE utf8_bin NOT NULL,
  `note` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `role` varchar(30) COLLATE utf8_bin DEFAULT '无',
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`nickname`,`department`,`phone`,`headPic`,`number`,`gender`,`note`,`role`,`password`) values (8,'asd','asd','asd','12312.0','asd',1,'女','asd','student','asd'),(9,'asda','asdasdas','rfwe','3546354.0','asd',1,'男','asds','teacher','dafgsd'),(10,'asd','asd','asd','12312.0','asd',123141,'女','asd','student','asd'),(11,'asda','asdasdas','rfwe','3546354.0','asd',1,'男','asds','teacher','dafgsd'),(12,'asd','asd','asd','12312.0','asd',123141,'女','asd','student','asd'),(13,'asda','asdasdas','rfwe','3546354.0','asd',1,'男','asds','teacher','dafgsd'),(14,'asd','asd','asd','1','asd',123141,'女','asd','student','asd'),(15,'asda','asdasdas','rfwe','1','asd',1,'男','asds','teacher','dafgsd'),(16,'asd','asd','asd','1','asd',123141,'女','asd','student','asd'),(17,'asda','asdasdas','rfwe','1','asd',1,'男','asds','teacher','dafgsd'),(18,'asd','asd','asd','1','asd',123141,'女','asd','student','asd'),(19,'asda','asdasdas','rfwe','1','asd',1,'男','asds','teacher','dafgsd'),(20,'asd','asd','asd','1','asd',123141,'女','asd','student','asd'),(21,'asda','asdasdas','rfwe','1','asd',12411434,'男','asds','teacher','dafgsd'),(22,'asd','asd','asd','1','asd',123141,'女','asd','student','asd'),(23,'asda','asdasdas','rfwe','1','asd',12411434,'男','asds','teacher','dafgsd'),(24,'asd','asd','asd','18852861545','asd',123141,'女','asd','student','asd'),(25,'asda','asdasdas','rfwe','18852897377','asd',12411434,'男','asds','teacher','dafgsd'),(26,'asd','asd','asd','18852861545',NULL,123141,'女','asd','student','asd'),(27,'asda','asdasdas','rfwe','18852897377',NULL,12411434,'男','asds','teacher','dafgsd');

/*Table structure for table `video` */

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

/*Data for the table `video` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
