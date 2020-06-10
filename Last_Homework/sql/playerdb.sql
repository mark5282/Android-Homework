/*
 Navicat MySQL Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : playerdb

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 07/06/2020 13:38:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for provinceBean
-- ----------------------------
DROP TABLE IF EXISTS `provinceBean`;
CREATE TABLE `provinceBean` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `beizhu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of provinceBean
-- ----------------------------
BEGIN;
INSERT INTO `provinceBean` VALUES (3, '1591376934198', NULL, NULL, NULL);
INSERT INTO `provinceBean` VALUES (4, '1591377732020', NULL, NULL, NULL);
INSERT INTO `provinceBean` VALUES (5, '1591378155283', NULL, NULL, NULL);
INSERT INTO `provinceBean` VALUES (7, '1591380249327', NULL, NULL, NULL);
INSERT INTO `provinceBean` VALUES (8, '1591438355553', NULL, NULL, NULL);
INSERT INTO `provinceBean` VALUES (9, '1591503725955', NULL, NULL, NULL);
INSERT INTO `provinceBean` VALUES (10, '1591504041252', NULL, NULL, NULL);
INSERT INTO `provinceBean` VALUES (11, '1591505787475', NULL, NULL, NULL);
INSERT INTO `provinceBean` VALUES (12, '1591506050675', NULL, NULL, NULL);
INSERT INTO `provinceBean` VALUES (13, '1591506215314', NULL, NULL, NULL);
INSERT INTO `provinceBean` VALUES (14, '1591506641695', NULL, NULL, NULL);
INSERT INTO `provinceBean` VALUES (15, '1591508054804', NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
