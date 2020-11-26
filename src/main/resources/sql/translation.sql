/*
 Navicat Premium Data Transfer

 Source Server         : andon0
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : translation

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 26/11/2020 16:30:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `chinese` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '中文',
  `english` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '英文',
  `update_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES ('0937d814ab594daeacf31180c03996d1', '你好', 'Hello', '2020-11-26 15:52:15');
INSERT INTO `dictionary` VALUES ('1803166b00024bcc822d7ab1ab3d8e20', 'Hello World', '你好 世界', '2020-11-26 15:55:29');
INSERT INTO `dictionary` VALUES ('48fad45201064ea8a012fb1bfd8c6748', '世界', 'Wolrd', '2020-11-26 15:55:04');
INSERT INTO `dictionary` VALUES ('asd', 'zxc', 'zxc', '2020-11-26 16:04:14');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `e_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮件',
  `qq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'qq',
  `we_chat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信',
  `update_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2b58e3ea440f44d2ac2a3dee893335bc', 'anqila', '安琪拉', 'anqila', '1666666666', '1666666666@wangzhe.com', '666666', 'anqila666', '2020-11-26 16:16:09');
INSERT INTO `user` VALUES ('asd', 'asd', '阿萨德', 'asd', '123456', '123456@456com', '123456', 'asd456', '2020-11-26 16:23:56');
INSERT INTO `user` VALUES ('c286b24360514ac788efeeb30338c581', 'xiaoqiao', '小乔', 'xiaoqiao', '1999999999', '1999999999@wangzhe.com', '999999', 'xiaoqiao999', '2020-11-26 16:16:45');
INSERT INTO `user` VALUES ('d02becd4f36c4145a42053216e59ac69', 'daji', '妲己', 'daji', '1888888888', '1888888888@wangzhe.com', '888888', 'daji888', '2020-11-26 16:15:11');

SET FOREIGN_KEY_CHECKS = 1;
