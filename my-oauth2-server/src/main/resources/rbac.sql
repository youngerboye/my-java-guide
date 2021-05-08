/*
 Navicat Premium Data Transfer

 Source Server         : hadoop101
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : 192.168.198.101:3306
 Source Schema         : oauth

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 08/05/2021 19:21:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token`  (
                                       `token_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                       `token` mediumblob NULL,
                                       `authentication_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
                                       `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                       `client_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                       `authentication` mediumblob NULL,
                                       `refresh_token` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                       PRIMARY KEY (`authentication_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_access_token
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_approvals
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals`  (
                                    `userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                    `clientId` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                    `scope` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                    `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                    `expiresAt` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
                                    `lastModifiedAt` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_approvals
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`  (
                                         `client_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
                                         `resource_ids` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                         `client_secret` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                         `scope` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                         `authorized_grant_types` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                         `web_server_redirect_uri` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                         `authorities` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                         `access_token_validity` int(11) NULL DEFAULT NULL,
                                         `refresh_token_validity` int(11) NULL DEFAULT NULL,
                                         `additional_information` varchar(4096) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                         `autoapprove` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                         PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('admin', NULL, '$2a$10$cvdaLbFOOhcH9ATggBCI6OUDa3HmiLaFciXVHBYrzSxXdZxn7g82O', 'read_userinfo,read_contacts', 'password,authorization_code,refresh_token', 'http://localhost:9501/login', NULL, 3600, 864000, NULL, '1');

-- ----------------------------
-- Table structure for oauth_client_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token`  (
                                       `token_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                       `token` mediumblob NULL,
                                       `authentication_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
                                       `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                       `client_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                       PRIMARY KEY (`authentication_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_client_token
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_code
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code`  (
                               `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                               `authentication` mediumblob NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_code
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token`  (
                                        `token_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                        `token` mediumblob NULL,
                                        `authentication` mediumblob NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_refresh_token
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
                               `id` bigint(20) NOT NULL COMMENT '主键',
                               `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源名称',
                               `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源类型：menu,button,',
                               `url` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问url地址',
                               `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父结点id',
                               `parent_ids` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父结点id列表串',
                               `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否可用,1：可用，0不可用',
                               `permission_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限字符',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '权限', ' ', NULL, 0, '0', 1, NULL);
INSERT INTO `permission` VALUES (2, '商品管理', 'menu', '/product', 1, '0/1', 1, NULL);
INSERT INTO `permission` VALUES (3, '商品新增', 'permission', '/product/add', 2, '0/1/2', 1, 'product::add');
INSERT INTO `permission` VALUES (4, '商品修改', 'permission', '/product/update', 2, '0/1/2', 1, 'product::update');
INSERT INTO `permission` VALUES (5, '商品删除', 'permission', '/product/delete', 2, '0/1/2', 1, 'product::delete');
INSERT INTO `permission` VALUES (6, '商品查询', 'permission', '/product/List', 2, '0/1/2', 1, 'product::List');
INSERT INTO `permission` VALUES (7, '用户管理', 'menu', '/user', 1, '0', 1, NULL);
INSERT INTO `permission` VALUES (8, '用户新增', 'permission', '/user/add', 7, '0/1/7', 1, 'user::add');
INSERT INTO `permission` VALUES (9, '用户列表', 'permission', '/user/list', 7, '0/1/7', 1, 'user::list');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
                         `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                         `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                         `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否可用,1：可用，0不可用',
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '用户管理员', 1);
INSERT INTO `role` VALUES ('2', '商品管理员', 1);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
                                    `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                    `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
                                    `permission_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限id',
                                    PRIMARY KEY (`id`) USING BTREE,
                                    UNIQUE INDEX `role_permission_u1`(`role_id`, `permission_id`) USING BTREE COMMENT '角色和权限唯一索引'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('6', '1', '2');
INSERT INTO `role_permission` VALUES ('7', '1', '9');
INSERT INTO `role_permission` VALUES ('1', '2', '2');
INSERT INTO `role_permission` VALUES ('2', '2', '3');
INSERT INTO `role_permission` VALUES ('3', '2', '4');
INSERT INTO `role_permission` VALUES ('4', '2', '5');
INSERT INTO `role_permission` VALUES ('5', '2', '6');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
                              `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                              `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                              `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                              PRIMARY KEY (`id`) USING BTREE,
                              UNIQUE INDEX `user_role_uk1`(`user_id`, `role_id`) USING BTREE COMMENT '用户和角色联合索引'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '1', '2');
INSERT INTO `user_role` VALUES ('3', '2', '1');
INSERT INTO `user_role` VALUES ('4', '2', '2');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
                          `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                          `password` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                          `enabled` tinyint(1) NOT NULL COMMENT '1-可用 0-不可用',
                          `id` bigint(100) NOT NULL,
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('admin', '$2a$10$vdJPpzPy7QPysn7XiPtUZufRTr0iFxTvqU0nbFsBBBWThyMFgJ9Jm', 1, 1);
INSERT INTO `users` VALUES ('young', '$2a$10$vdJPpzPy7QPysn7XiPtUZufRTr0iFxTvqU0nbFsBBBWThyMFgJ9Jm', 1, 2);

SET FOREIGN_KEY_CHECKS = 1;
