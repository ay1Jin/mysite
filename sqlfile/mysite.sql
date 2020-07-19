/*
 Navicat Premium Data Transfer

 Source Server         : ayjin
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : mysite

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 19/07/2020 01:17:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `msgId` int NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` enum('1','0') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES (1, 1, '评论测试1', 'ayjin', '2020-07-18 23:32:59', 'ayjinwk@163.com', '1');
INSERT INTO `comments` VALUES (2, 1, '评论测试1', 'ayjin', '2020-07-18 23:32:51', 'ayjin@163.com', '1');
INSERT INTO `comments` VALUES (3, 2, '评论测试2', 'ayjin', '2020-07-18 23:33:01', 'ayjin@163.com', '1');
INSERT INTO `comments` VALUES (4, 2, '评论测试2', 'ayjin', '2020-07-18 14:54:28', 'ayjin@163.com', '1');
INSERT INTO `comments` VALUES (5, 2, '评论测试2', 'ayjin', '2020-07-18 14:54:29', 'ayjin@163.com', '1');
INSERT INTO `comments` VALUES (6, 3, '评论测试3', 'ayjin', '2020-07-18 14:54:30', 'ayjin@163.com', '1');
INSERT INTO `comments` VALUES (7, 3, '评论测试3', 'ayjin', '2020-07-18 14:54:31', 'ayjin@163.com', '1');
INSERT INTO `comments` VALUES (8, 3, '评论测试3', 'ayjin', '2020-07-18 14:54:32', 'ayjin@163.com', '1');
INSERT INTO `comments` VALUES (9, 3, '评论测试3', 'ayjin', '2020-07-18 14:54:32', 'ayjin@163.com', '0');
INSERT INTO `comments` VALUES (10, 1, 'test', 'ayjin', '2020-07-19 00:14:16', '502466787@qq.com', '0');
INSERT INTO `comments` VALUES (11, 18, '测试', 'ayjin', '2020-07-19 01:10:51', '502466787@qq.com', '1');

-- ----------------------------
-- Table structure for links
-- ----------------------------
DROP TABLE IF EXISTS `links`;
CREATE TABLE `links`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` enum('1','0') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of links
-- ----------------------------
INSERT INTO `links` VALUES (1, 'ayjin', 'ayjinwk@163.com', 'https://github.com/ay1Jin', '1');
INSERT INTO `links` VALUES (2, '一命宿星', '502466787@qq.com', '#', '1');
INSERT INTO `links` VALUES (3, '一梦江湖', 'ayjinwk@163.com', '#', '0');
INSERT INTO `links` VALUES (4, 'test', '502466787@qq.com', '11111', '0');

-- ----------------------------
-- Table structure for messages
-- ----------------------------
DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `likeCount` int NULL DEFAULT NULL,
  `comCount` int NULL DEFAULT NULL,
  `status` enum('1','0') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of messages
-- ----------------------------
INSERT INTO `messages` VALUES (1, '测试1', '岁月难得沉默秋风厌倦漂泊 夕阳赖着不走挂在墙头舍不得我 昔日伊人耳边话已和潮声向东流 再回首往事也随枫叶一片片落 爱已走到尽头恨也放弃承诺 命运自认幽默想法态多由不得我 壮志凌云几分愁知己难逢几人留 再回首却闻笑传醉梦中 笑谈词穷古痴今狂终成空 刀钝刃乏恩断义绝梦方破 路荒已叹饱览足迹没人懂 多年望眼欲穿过红尘滚滚我没看透 词嘲墨尽千情万怨英杰愁 曲终人散发花鬓白红颜莫 烛残未觉与日争辉图消瘦 当泪干血隐狂涌白雪纷飞都成空', 'ayjin', 'ayjinwk@163.com', '192.168.1.1', '2020-07-18 23:49:28', 1, 1, '1');
INSERT INTO `messages` VALUES (2, '测试2', '那么多的过客，或孤单的一人浪迹天涯，或携眷双双归隐，这首江湖的歌，如今还有谁在唱。', 'ayjin', 'ayjin@163.com', '192.168.1.2', '2020-07-18 23:49:27', 1, 1, '1');
INSERT INTO `messages` VALUES (3, '测试3', '那么多的过客，或孤单的一人浪迹天涯，或携眷双双归隐，这首江湖的歌，如今还有谁在唱。', 'ayjin', 'ayjin@163.com', '192.168.1.2', '2020-07-18 23:49:26', 1, 1, '1');
INSERT INTO `messages` VALUES (4, '测试4', '那么多的过客，或孤单的一人浪迹天涯，或携眷双双归隐，这首江湖的歌，如今还有谁在唱。', 'ayjin', 'ayjin@163.com', '192.168.1.2', '2020-07-16 13:55:23', 1, 1, '1');
INSERT INTO `messages` VALUES (5, '测试5', '那么多的过客，或孤单的一人浪迹天涯，或携眷双双归隐，这首江湖的歌，如今还有谁在唱。', 'ayjin', 'ayjin@163.com', '192.168.1.2', '2020-07-18 16:31:10', 1, 1, '1');
INSERT INTO `messages` VALUES (6, '测试6', '那么多的过客，或孤单的一人浪迹天涯，或携眷双双归隐，这首江湖的歌，如今还有谁在唱。', 'ayjin', 'ayjin@163.com', '192.168.1.2', '2020-07-18 16:31:15', 1, 1, '1');
INSERT INTO `messages` VALUES (7, '测试7', '那么多的过客，或孤单的一人浪迹天涯，或携眷双双归隐，这首江湖的歌，如今还有谁在唱。', 'ayjin', 'ayjin@163.com', '192.168.1.2', '2020-07-18 16:31:17', 1, 1, '1');
INSERT INTO `messages` VALUES (8, '测试8', '那么多的过客，或孤单的一人浪迹天涯，或携眷双双归隐，这首江湖的歌，如今还有谁在唱。', 'ayjin', 'ayjin@163.com', '192.168.1.2', '2020-07-18 16:31:19', 1, 1, '1');
INSERT INTO `messages` VALUES (9, '测试9', '那么多的过客，或孤单的一人浪迹天涯，或携眷双双归隐，这首江湖的歌，如今还有谁在唱。', 'ayjin', 'ayjin@163.com', '192.168.1.2', '2020-07-18 16:31:22', 1, 1, '1');
INSERT INTO `messages` VALUES (10, '测试10', '那么多的过客，或孤单的一人浪迹天涯，或携眷双双归隐，这首江湖的歌，如今还有谁在唱。', 'ayjin', 'ayjin@163.com', '192.168.1.2', '2020-07-18 16:31:23', 1, 1, '1');
INSERT INTO `messages` VALUES (11, '测试11', '那么多的过客，或孤单的一人浪迹天涯，或携眷双双归隐，这首江湖的歌，如今还有谁在唱。', 'ayjin', 'ayjin@163.com', '192.168.1.2', '2020-07-18 16:31:23', 1, 1, '1');
INSERT INTO `messages` VALUES (14, 'Manjaro install selenium port occupation problem?', 'saddddddddddddd', 'admin', '502466787@qq.com', '0:0:0:0:0:0:0:1', '2020-07-18 17:04:44', NULL, NULL, '1');
INSERT INTO `messages` VALUES (15, '阿尔', '测试？', '欧阳谨', '502466787@qq.com', '192.168.123.66', '2020-07-18 17:06:37', NULL, NULL, '1');
INSERT INTO `messages` VALUES (16, '基于Gephi的足球比赛传球关系网络可视化分析', '测试', 'ayjin', '502466787@qq.com', '0:0:0:0:0:0:0:1', '2020-07-18 17:24:42', NULL, NULL, '1');
INSERT INTO `messages` VALUES (17, '测试', '测试', '一梦江湖', '502466787@qq.com', '192.168.123.66', '2020-07-18 17:30:43', NULL, NULL, '1');
INSERT INTO `messages` VALUES (18, '测试', '你好？', 'unknow', '502466787@qq.com', '0:0:0:0:0:0:0:1', '2020-07-19 01:10:37', NULL, NULL, '1');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` enum('1','0') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'ayjin', 'ouyang4283658', '1');

-- ----------------------------
-- Table structure for viewers
-- ----------------------------
DROP TABLE IF EXISTS `viewers`;
CREATE TABLE `viewers`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of viewers
-- ----------------------------
INSERT INTO `viewers` VALUES (1, '192.168.1.1', '2020-07-16 14:00:30');
INSERT INTO `viewers` VALUES (2, '192.168.1.2', '2020-07-16 14:03:34');
INSERT INTO `viewers` VALUES (3, '192.168.1.3', '2020-07-16 14:03:40');
INSERT INTO `viewers` VALUES (4, '192.168.1.4', '2020-07-16 17:41:09');
INSERT INTO `viewers` VALUES (5, '192.168.1.5', '2020-07-16 17:41:14');
INSERT INTO `viewers` VALUES (6, '192.168.1.3', '2020-07-16 17:41:20');
INSERT INTO `viewers` VALUES (7, '192.168.1.8', '2020-07-16 17:41:28');
INSERT INTO `viewers` VALUES (8, '192.168.1.1', '2020-07-16 17:49:49');
INSERT INTO `viewers` VALUES (9, '0:0:0:0:0:0:0:1', '2020-07-16 17:58:04');
INSERT INTO `viewers` VALUES (10, '192.168.123.66', '2020-07-16 17:58:24');
INSERT INTO `viewers` VALUES (11, '0:0:0:0:0:0:0:1', '2020-07-16 18:02:51');
INSERT INTO `viewers` VALUES (12, '192.168.248.1', '2020-07-16 18:06:07');
INSERT INTO `viewers` VALUES (13, '192.168.123.66', '2020-07-16 18:08:03');
INSERT INTO `viewers` VALUES (14, '192.168.123.66', '2020-07-16 18:08:16');
INSERT INTO `viewers` VALUES (15, '0:0:0:0:0:0:0:1', '2020-07-17 00:07:20');
INSERT INTO `viewers` VALUES (16, '0:0:0:0:0:0:0:1', '2020-07-17 00:12:28');
INSERT INTO `viewers` VALUES (17, '192.168.123.66', '2020-07-17 02:28:07');
INSERT INTO `viewers` VALUES (18, '0:0:0:0:0:0:0:1', '2020-07-17 02:58:32');
INSERT INTO `viewers` VALUES (19, '0:0:0:0:0:0:0:1', '2020-07-18 13:15:05');
INSERT INTO `viewers` VALUES (20, '0:0:0:0:0:0:0:1', '2020-07-18 15:23:11');
INSERT INTO `viewers` VALUES (21, '0:0:0:0:0:0:0:1', '2020-07-18 16:02:31');
INSERT INTO `viewers` VALUES (22, '0:0:0:0:0:0:0:1', '2020-07-18 16:16:25');
INSERT INTO `viewers` VALUES (23, '0:0:0:0:0:0:0:1', '2020-07-18 17:02:48');
INSERT INTO `viewers` VALUES (24, '0:0:0:0:0:0:0:1', '2020-07-18 17:04:34');
INSERT INTO `viewers` VALUES (25, '192.168.123.66', '2020-07-18 17:05:54');
INSERT INTO `viewers` VALUES (26, '0:0:0:0:0:0:0:1', '2020-07-18 17:20:11');
INSERT INTO `viewers` VALUES (27, '0:0:0:0:0:0:0:1', '2020-07-18 17:23:12');
INSERT INTO `viewers` VALUES (28, '192.168.123.66', '2020-07-18 17:30:01');
INSERT INTO `viewers` VALUES (29, '0:0:0:0:0:0:0:1', '2020-07-18 23:48:31');
INSERT INTO `viewers` VALUES (30, '0:0:0:0:0:0:0:1', '2020-07-19 00:09:44');
INSERT INTO `viewers` VALUES (31, '0:0:0:0:0:0:0:1', '2020-07-19 00:28:13');

SET FOREIGN_KEY_CHECKS = 1;
