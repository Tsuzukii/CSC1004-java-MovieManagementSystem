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

 Date: 21/04/2023 15:38:28
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
INSERT INTO `addedmovie1` (`username`, `comments`, `age`, `rating`) VALUES ('user2', '1111', 26, '9');
INSERT INTO `addedmovie1` (`username`, `comments`, `age`, `rating`) VALUES ('user2', '1111', 26, '9');
INSERT INTO `addedmovie1` (`username`, `comments`, `age`, `rating`) VALUES ('user2', '1111', 26, '9');
INSERT INTO `addedmovie1` (`username`, `comments`, `age`, `rating`) VALUES ('user2', '2222', 26, '9');
INSERT INTO `addedmovie1` (`username`, `comments`, `age`, `rating`) VALUES ('user2', '2222', 26, '9');
INSERT INTO `addedmovie1` (`username`, `comments`, `age`, `rating`) VALUES ('user2', '2222', 26, '9');
COMMIT;

-- ----------------------------
-- Table structure for addedmovie2
-- ----------------------------
DROP TABLE IF EXISTS `addedmovie2`;
CREATE TABLE `addedmovie2` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int NOT NULL,
  `rating` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of addedmovie2
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for addedmovie3
-- ----------------------------
DROP TABLE IF EXISTS `addedmovie3`;
CREATE TABLE `addedmovie3` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int NOT NULL,
  `rating` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of addedmovie3
-- ----------------------------
BEGIN;
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Brokeback Mountain
-- ----------------------------
BEGIN;
INSERT INTO `Brokeback Mountain` (`id`, `username`, `comments`, `age`, `rating`) VALUES (1, 'Han', '1111', 56, '6');
INSERT INTO `Brokeback Mountain` (`id`, `username`, `comments`, `age`, `rating`) VALUES (2, 'user1', '11111', 20, '9');
INSERT INTO `Brokeback Mountain` (`id`, `username`, `comments`, `age`, `rating`) VALUES (3, 'user2', '2222', 28, '10');
INSERT INTO `Brokeback Mountain` (`id`, `username`, `comments`, `age`, `rating`) VALUES (4, 'user3', '333333', 12, '9');
INSERT INTO `Brokeback Mountain` (`id`, `username`, `comments`, `age`, `rating`) VALUES (5, 'user4', '444444', 11, '7');
INSERT INTO `Brokeback Mountain` (`id`, `username`, `comments`, `age`, `rating`) VALUES (7, 'user6', '66666', 23, '9');
INSERT INTO `Brokeback Mountain` (`id`, `username`, `comments`, `age`, `rating`) VALUES (8, 'user7', '77777', 44, '7');
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Forrest Gump
-- ----------------------------
BEGIN;
INSERT INTO `Forrest Gump` (`id`, `username`, `comments`, `age`, `rating`) VALUES (2, 'user1', '11111', 20, '9');
INSERT INTO `Forrest Gump` (`id`, `username`, `comments`, `age`, `rating`) VALUES (3, 'user2', '2222', 28, '10');
INSERT INTO `Forrest Gump` (`id`, `username`, `comments`, `age`, `rating`) VALUES (4, 'user3', '333333', 12, '9');
INSERT INTO `Forrest Gump` (`id`, `username`, `comments`, `age`, `rating`) VALUES (5, 'user4', '444444', 11, '6');
INSERT INTO `Forrest Gump` (`id`, `username`, `comments`, `age`, `rating`) VALUES (6, 'user5', '555555', 38, '8');
INSERT INTO `Forrest Gump` (`id`, `username`, `comments`, `age`, `rating`) VALUES (7, 'user6', '66666', 23, '8');
INSERT INTO `Forrest Gump` (`id`, `username`, `comments`, `age`, `rating`) VALUES (8, 'user7', '77777', 44, '10');
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Leon
-- ----------------------------
BEGIN;
INSERT INTO `Leon` (`id`, `username`, `comments`, `age`, `rating`) VALUES (1, 'Han', '1111', 56, '8');
INSERT INTO `Leon` (`id`, `username`, `comments`, `age`, `rating`) VALUES (2, 'user1', '11111', 20, '9');
INSERT INTO `Leon` (`id`, `username`, `comments`, `age`, `rating`) VALUES (3, 'user2', '2222', 28, '10');
INSERT INTO `Leon` (`id`, `username`, `comments`, `age`, `rating`) VALUES (4, 'user3', '333333', 12, '9');
INSERT INTO `Leon` (`id`, `username`, `comments`, `age`, `rating`) VALUES (5, 'user4', '444444', 11, '7');
INSERT INTO `Leon` (`id`, `username`, `comments`, `age`, `rating`) VALUES (6, 'user5', '555555', 38, '8');
INSERT INTO `Leon` (`id`, `username`, `comments`, `age`, `rating`) VALUES (7, 'user6', '66666', 23, '8');
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of The Shawshank Redemption
-- ----------------------------
BEGIN;
INSERT INTO `The Shawshank Redemption` (`id`, `username`, `comments`, `age`, `rating`) VALUES (1, 'Han', '1111', 56, '10');
INSERT INTO `The Shawshank Redemption` (`id`, `username`, `comments`, `age`, `rating`) VALUES (2, 'user1', '11111', 20, '9');
INSERT INTO `The Shawshank Redemption` (`id`, `username`, `comments`, `age`, `rating`) VALUES (3, 'user2', '2222', 28, '10');
INSERT INTO `The Shawshank Redemption` (`id`, `username`, `comments`, `age`, `rating`) VALUES (4, 'user3', '333333', 12, '9');
INSERT INTO `The Shawshank Redemption` (`id`, `username`, `comments`, `age`, `rating`) VALUES (5, 'user4', '444444', 11, '10');
INSERT INTO `The Shawshank Redemption` (`id`, `username`, `comments`, `age`, `rating`) VALUES (7, 'user6', '66666', 23, '8');
INSERT INTO `The Shawshank Redemption` (`id`, `username`, `comments`, `age`, `rating`) VALUES (8, 'user7', '77777', 44, '8');
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
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (1, 'user1', '567890', 'Yan', 20, 'Male');
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (2, 'user2', '123456', 'aa', 26, 'Female');
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (31, 'user3', '333333', '111q', 12, 'Male');
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (32, 'user4', '444444', '11', 11, 'Male');
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (33, 'user5', '555555', 'asd', 38, 'Male');
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (34, 'user6', '666666', '1234', 23, 'Female');
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (35, 'user7', '777777', '333', 44, 'Male');
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (36, 'user8', '888888', '223323', 22, 'Female');
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (37, 'YAN', '999999', 'andnd', 38, 'Male');
INSERT INTO `user` (`id`, `username`, `password`, `address`, `age`, `gender`) VALUES (38, 'Han', '101010', 'asd', 56, 'Male');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
