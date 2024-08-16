/*
Navicat MySQL Data Transfer

Source Server         : nodes_info
Source Server Version : 80029
Source Host           : localhost:3306
Source Database       : nodes_info

Target Server Type    : MYSQL
Target Server Version : 80029
File Encoding         : 65001

Date: 2022-06-15 20:23:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `nodes_information`
-- ----------------------------
DROP TABLE IF EXISTS `nodes_information`;
CREATE TABLE `nodes_information` (
  `node_id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `node_name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `node_region` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `node_os` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `node_mem_total` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `node_disk_total` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `node_bandwidth` char(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`node_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of nodes_information
-- ----------------------------
INSERT INTO `nodes_information` VALUES ('000001', 'apache_01', '大连', 'CentOS7', '53595', '5432168', '18443');
INSERT INTO `nodes_information` VALUES ('000002', 'java_01', '郑州', 'Linux', '66236', '5432100', '17513');
INSERT INTO `nodes_information` VALUES ('000003', 'java_02', '郑州', 'Ubuntu', '66236', '5432101', '19542');
INSERT INTO `nodes_information` VALUES ('000004', 'apache_02', '北京', 'CentOS8', '53595', '5432168', '15496');
INSERT INTO `nodes_information` VALUES ('100000', 'upload_01', '沈阳', 'RHEL6', '65535', '10000000', '40000');
INSERT INTO `nodes_information` VALUES ('165489', 'nginx_01', '天津', 'CentOS7', '53595', '5432168', '98211547');
INSERT INTO `nodes_information` VALUES ('200000', 'upload_02', '北京', 'RHEL6', '65535', '10000000', '40000');
INSERT INTO `nodes_information` VALUES ('300000', 'upload_03', '杭州', 'RHEL6', '65535', '10000000', '40000');
INSERT INTO `nodes_information` VALUES ('348456', 'repo_S_02', '广州', 'Arch', '46845', '40000000', '400000');
INSERT INTO `nodes_information` VALUES ('359455', 'repo_N_06', '北京', 'Arch', '59687', '40000000', '400000');
INSERT INTO `nodes_information` VALUES ('400000', 'upload_04', '深圳', 'RHEL6', '65535', '10000000', '40000');
INSERT INTO `nodes_information` VALUES ('485964', 'openresty_01', '上海', 'Arch', '59555', '4556548', '15641');
INSERT INTO `nodes_information` VALUES ('486415', 'nginx_03', '大连', 'CentOS7', '654123', '498116451', '20202020');
INSERT INTO `nodes_information` VALUES ('500000', 'upload_05', '重庆', 'RHEL6', '65535', '20000000', '80000');
INSERT INTO `nodes_information` VALUES ('564891', 'repo_S_03', '广州', 'Arch', '45164', '40000000', '400000');
INSERT INTO `nodes_information` VALUES ('815617', 'repo_N_05', '北京', 'Arch', '54984', '40000000', '400000');
INSERT INTO `nodes_information` VALUES ('954615', 'repo_S_01', '广州', 'Arch', '53669', '40000000', '400000');
INSERT INTO `nodes_information` VALUES ('989898', 'repo_N_04', '北京', 'Arch', '84561', '40000000', '400000');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_name` char(20) COLLATE utf8mb4_general_ci NOT NULL,
  `pass_word` char(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', 'admin');
