/*
 Navicat Premium Data Transfer

 Source Server         : localhost@test2
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : test2

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 08/06/2021 18:01:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `num` int(11) NOT NULL DEFAULT 0,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`name`, `pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '小米手机', 22, '1', 1);
INSERT INTO `goods` VALUES (2, '苹果手机', 15, '1', 1);
INSERT INTO `goods` VALUES (3, '华为手机', 4, '1', 0);

SET FOREIGN_KEY_CHECKS = 1;
