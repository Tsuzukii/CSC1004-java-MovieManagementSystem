/*
 Navicat Premium Data Transfer

 Source Server         : MovieManagementSystem
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : MovieManagementSystem

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 20/04/2023 19:54:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for addedmovie1
-- ----------------------------
DROP TABLE IF EXISTS `addedmovie1`;
CREATE TABLE `addedmovie1` (
  `username` varchar(255) NOT NULL,
  `comments` varchar(255) NOT NULL,
  `age` int NOT NULL,
  `rating` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of addedmovie1
-- ----------------------------
BEGIN;
INSERT INTO `addedmovie1` (`username`, `comments`, `age`, `rating`) VALUES ('user1', '1111', 20, '10');
INSERT INTO `addedmovie1` (`username`, `comments`, `age`, `rating`) VALUES ('user1', '12333', 20, '10');
INSERT INTO `addedmovie1` (`username`, `comments`, `age`, `rating`) VALUES ('user1', '1111', 20, '10');
COMMIT;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` (`id`, `username`, `password`) VALUES (1, 'Tsuzukii', '123456');
INSERT INTO `admin` (`id`, `username`, `password`) VALUES (2, 'Tsuzuki', '112233');
INSERT INTO `admin` (`id`, `username`, `password`) VALUES (3, '1', '1');
COMMIT;

-- ----------------------------
-- Table structure for Brokeback Mountain
-- ----------------------------
DROP TABLE IF EXISTS `Brokeback Mountain`;
CREATE TABLE `Brokeback Mountain` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int NOT NULL,
  `rating` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Brokeback Mountain
-- ----------------------------
BEGIN;
INSERT INTO `Brokeback Mountain` (`id`, `username`, `comments`, `age`, `rating`) VALUES (1, 'user1', '111', 20, '7');
INSERT INTO `Brokeback Mountain` (`id`, `username`, `comments`, `age`, `rating`) VALUES (2, 'user1', '111', 20, '10');
COMMIT;

-- ----------------------------
-- Table structure for Forrest Gump
-- ----------------------------
DROP TABLE IF EXISTS `Forrest Gump`;
CREATE TABLE `Forrest Gump` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `comments` varchar(255) NOT NULL,
  `age` int NOT NULL,
  `rating` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Forrest Gump
-- ----------------------------
BEGIN;
INSERT INTO `Forrest Gump` (`id`, `username`, `comments`, `age`, `rating`) VALUES (1, 'Han', '1111', 56, '8');
COMMIT;

-- ----------------------------
-- Table structure for Leon
-- ----------------------------
DROP TABLE IF EXISTS `Leon`;
CREATE TABLE `Leon` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `comments` varchar(255) NOT NULL,
  `age` int NOT NULL,
  `rating` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Leon
-- ----------------------------
BEGIN;
INSERT INTO `Leon` (`id`, `username`, `comments`, `age`, `rating`) VALUES (1, 'user1', '111', 20, '7');
INSERT INTO `Leon` (`id`, `username`, `comments`, `age`, `rating`) VALUES (2, 'user1', '111', 20, '10');
INSERT INTO `Leon` (`id`, `username`, `comments`, `age`, `rating`) VALUES (3, 'user1', '123333', 20, '9');
INSERT INTO `Leon` (`id`, `username`, `comments`, `age`, `rating`) VALUES (4, 'user1', '1111', 20, '10');
INSERT INTO `Leon` (`id`, `username`, `comments`, `age`, `rating`) VALUES (5, 'user1', '12333', 20, '10');
COMMIT;

-- ----------------------------
-- Table structure for movieName
-- ----------------------------
DROP TABLE IF EXISTS `movieName`;
CREATE TABLE `movieName` (
  `movieName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of movieName
-- ----------------------------
BEGIN;
INSERT INTO `movieName` (`movieName`) VALUES ('The Shawshank Redemption');
INSERT INTO `movieName` (`movieName`) VALUES ('Forrest Gump');
INSERT INTO `movieName` (`movieName`) VALUES ('Leon');
INSERT INTO `movieName` (`movieName`) VALUES ('Brokeback Mountain');
INSERT INTO `movieName` (`movieName`) VALUES ('addedmovie2');
INSERT INTO `movieName` (`movieName`) VALUES ('addedmovie3');
COMMIT;

-- ----------------------------
-- Table structure for The Shawshank Redemption
-- ----------------------------
DROP TABLE IF EXISTS `The Shawshank Redemption`;
CREATE TABLE `The Shawshank Redemption` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `comments` varchar(255) NOT NULL,
  `age` int NOT NULL,
  `rating` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of The Shawshank Redemption
-- ----------------------------
BEGIN;
INSERT INTO `The Shawshank Redemption` (`id`, `username`, `comments`, `age`, `rating`) VALUES (1, 'user1', '1', 38, '10');
INSERT INTO `The Shawshank Redemption` (`id`, `username`, `comments`, `age`, `rating`) VALUES (2, 'user1', '111', 15, '10');
INSERT INTO `The Shawshank Redemption` (`id`, `username`, `comments`, `age`, `rating`) VALUES (3, 'user1', '111', 60, '10');
INSERT INTO `The Shawshank Redemption` (`id`, `username`, `comments`, `age`, `rating`) VALUES (4, '1', '很好', 1, '10');
INSERT INTO `The Shawshank Redemption` (`id`, `username`, `comments`, `age`, `rating`) VALUES (5, 'user1', 'haohao', 34, '10');
INSERT INTO `The Shawshank Redemption` (`id`, `username`, `comments`, `age`, `rating`) VALUES (6, 'yangjifan', '111', 66, '10');
INSERT INTO `The Shawshank Redemption` (`id`, `username`, `comments`, `age`, `rating`) VALUES (7, 'user1', '1234567890', 18, '10');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int NOT NULL,
  `gender` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (1, 'user1', '567890', 'Yan', 20, '');
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (2, 'user2', '123456', 'aa', 20, '');
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (31, '1234534', '123', '111q', 12, 'Male');
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (32, '13454', '22', '11', 11, 'Male');
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (33, 'asd', 'asd', 'asd', 38, 'Male');
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (34, '1234', '2222', '1234', 23, 'Female');
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (35, '1111', '2222', '333', 44, 'Male');
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (36, '222', '22333', '223323', 22, 'Female');
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (37, 'YAN', '123456', 'andnd', 38, 'Male');
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (38, 'Han', '1234', 'asd', 56, 'Male');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
