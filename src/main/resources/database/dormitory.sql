/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : dormitory

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 18/08/2020 21:22:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_b_class
-- ----------------------------
DROP TABLE IF EXISTS `t_b_class`;
CREATE TABLE `t_b_class`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级ID',
  `classname` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级名',
  `teachername` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '辅导员',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_b_class
-- ----------------------------
INSERT INTO `t_b_class` VALUES ('402881e44cbbfe2c014cbbfecf730001', '17级软件工程2班', '李彦宏', '2015-04-29 17:56:54');
INSERT INTO `t_b_class` VALUES ('402881e44cbc0292014cbd3aac1f0001', '17级计算机科学与技术1班', '马化腾', '2015-04-15 21:18:01');
INSERT INTO `t_b_class` VALUES ('402881e96c096af648f49a1946bfdcf2', '17级软件工程1班', '雷军', '2020-04-01 13:57:26');

-- ----------------------------
-- Table structure for t_b_damage
-- ----------------------------
DROP TABLE IF EXISTS `t_b_damage`;
CREATE TABLE `t_b_damage`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '损坏ID',
  `damagestation` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '损坏情况',
  `damagetime` date NULL DEFAULT NULL COMMENT '损坏时间',
  `fixtime` date NULL DEFAULT NULL COMMENT '修复时间',
  `remark` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `dormid` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否修复',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `isfixed` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '宿舍ID',
  PRIMARY KEY (`id`, `dormid`) USING BTREE,
  INDEX `fk_t_b_damage_t_b_dorm1`(`dormid`) USING BTREE,
  CONSTRAINT `fk_t_b_damage_t_b_dorm1` FOREIGN KEY (`dormid`) REFERENCES `t_b_dorm` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '宿舍损坏情况' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_b_damage
-- ----------------------------
INSERT INTO `t_b_damage` VALUES ('402881e64cf9f0fe014cf9f189ea0000', '888', '2015-04-01', '2015-04-30', '123666', '402881e54ce9ee7d014ce9f0b6450000', '2015-04-27 18:33:30', '1');

-- ----------------------------
-- Table structure for t_b_dorm
-- ----------------------------
DROP TABLE IF EXISTS `t_b_dorm`;
CREATE TABLE `t_b_dorm`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '宿舍ID',
  `dormname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '宿舍名称',
  `total` int(11) NULL DEFAULT NULL COMMENT '床位总数',
  `used` int(11) NULL DEFAULT NULL COMMENT '已用床位',
  `dormadmin` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '宿舍管理员',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '宿舍信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_b_dorm
-- ----------------------------
INSERT INTO `t_b_dorm` VALUES ('1', '已离校', 0, 0, '', '离校', '2015-04-24 16:27:10');
INSERT INTO `t_b_dorm` VALUES ('402881e54ce9ee7d014ce9f0b6450000', '一宿舍', 10, 2, '高圆圆', '男生宿舍', '2015-04-29 19:49:26');
INSERT INTO `t_b_dorm` VALUES ('402881e54cea6e2e014cea72c01e0000', '二宿舍', 10, 5, '罗玉凤', '男生宿舍', '2015-04-24 16:27:10');
INSERT INTO `t_b_dorm` VALUES ('402881e64d051ccf014d0520f3bf0000', '三宿舍', 5, 2, '古天乐', '女生宿舍', '2015-04-29 20:22:35');
INSERT INTO `t_b_dorm` VALUES ('402881e64d05267d014d0529d4050002', '四宿舍', 5, 0, '王勇', '女生宿舍', '2015-04-29 20:32:16');

-- ----------------------------
-- Table structure for t_b_score
-- ----------------------------
DROP TABLE IF EXISTS `t_b_score`;
CREATE TABLE `t_b_score`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评分ID',
  `score` int(11) NULL DEFAULT NULL COMMENT '评分',
  `scoredate` date NULL DEFAULT NULL COMMENT '评分时间',
  `dormid` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '宿舍ID',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`, `dormid`) USING BTREE,
  INDEX `fk_t_b_score_t_b_dorm1`(`dormid`) USING BTREE,
  CONSTRAINT `fk_t_b_score_t_b_dorm1` FOREIGN KEY (`dormid`) REFERENCES `t_b_dorm` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '宿舍评分' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_b_score
-- ----------------------------
INSERT INTO `t_b_score` VALUES ('402881e64d041299014d04135f070000', 4, '2020-04-02', '402881e54ce9ee7d014ce9f0b6450000', '2015-04-29 16:20:25');
INSERT INTO `t_b_score` VALUES ('402881e64d04422d014d0443092c0000', 4, '2020-04-02', '402881e54cea6e2e014cea72c01e0000', '2015-04-29 16:20:11');
INSERT INTO `t_b_score` VALUES ('402881e64d054958014d055417390003', 4, '2020-04-02', '402881e64d051ccf014d0520f3bf0000', '2015-04-29 21:18:26');
INSERT INTO `t_b_score` VALUES ('402881e64d054958014d055459c70004', 3, '2020-04-10', '402881e64d05267d014d0529d4050002', '2015-04-29 21:18:43');

-- ----------------------------
-- Table structure for t_b_student
-- ----------------------------
DROP TABLE IF EXISTS `t_b_student`;
CREATE TABLE `t_b_student`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `qq` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'qq',
  `mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `classid` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级ID',
  `dormid` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '宿舍ID',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`, `classid`, `dormid`) USING BTREE,
  INDEX `fk_t_b_student_t_b_class1`(`classid`) USING BTREE,
  INDEX `fk_t_b_student_t_b_dorm1`(`dormid`) USING BTREE,
  CONSTRAINT `fk_t_b_student_t_b_class1` FOREIGN KEY (`classid`) REFERENCES `t_b_class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_b_student_t_b_dorm1` FOREIGN KEY (`dormid`) REFERENCES `t_b_dorm` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_b_student
-- ----------------------------
INSERT INTO `t_b_student` VALUES ('402881e5a5194f4b29448f7a28935dbd', '迪丽热巴', '2', '1995-03-16', '87816597984', '13596874586', '402881e44cbbfe2c014cbbfecf730001', '402881e64d051ccf014d0520f3bf0000', '2020-03-31 14:24:11');
INSERT INTO `t_b_student` VALUES ('402881e64d05267d014d0527e3f80000', '范冰冰', '2', '2015-04-22', '6666', '13575798836', '402881e44cbbfe2c014cbbfecf730001', '402881e64d051ccf014d0520f3bf0000', '2015-04-29 20:30:09');
INSERT INTO `t_b_student` VALUES ('402881e64d05267d014d0528d8570001', '姚明', '1', '2015-04-15', '8888', '13566666666', '402881e44cbc0292014cbd3aac1f0001', '402881e54ce9ee7d014ce9f0b6450000', '2015-04-29 20:31:12');
INSERT INTO `t_b_student` VALUES ('402881e68924290d2424f7a8587fcf6c', '李白', '1', '2020-03-22', '66666666', '13545679772', '402881e44cbbfe2c014cbbfecf730001', '402881e54cea6e2e014cea72c01e0000', '2020-03-31 13:03:15');
INSERT INTO `t_b_student` VALUES ('402881e889f11b33be54ccfa5dd8c271', '吴亦凡', '1', '2020-03-15', '66666', '14566666666', '402881e44cbc0292014cbd3aac1f0001', '402881e54cea6e2e014cea72c01e0000', '2020-03-30 16:30:37');
INSERT INTO `t_b_student` VALUES ('402881ed68990348df44f0bbd269cbc9', '杜甫', '1', '2020-03-02', '8888888', '13655555555', '402881e96c096af648f49a1946bfdcf2', '402881e54cea6e2e014cea72c01e0000', '2020-04-01 13:58:20');

-- ----------------------------
-- Table structure for t_b_visitor
-- ----------------------------
DROP TABLE IF EXISTS `t_b_visitor`;
CREATE TABLE `t_b_visitor`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '访客ID',
  `visitorname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访客姓名',
  `studentid` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '受访人',
  `relationship` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '与受访人关系',
  `starttime` datetime(0) NULL DEFAULT NULL COMMENT '进入时间',
  `endtime` datetime(0) NULL DEFAULT NULL COMMENT '离开时间',
  `remark` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`, `studentid`) USING BTREE,
  INDEX `fk_t_b_visitor_t_b_student1`(`studentid`) USING BTREE,
  CONSTRAINT `fk_t_b_visitor_t_b_student1` FOREIGN KEY (`studentid`) REFERENCES `t_b_student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '访客信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_b_visitor
-- ----------------------------
INSERT INTO `t_b_visitor` VALUES ('402881e5abd69f04fad4109b72e30d91', '张三', '402881e64d05267d014d0527e3f80000', '1', '2020-04-02 12:42:24', '2020-04-03 12:42:27', '来了', NULL);
INSERT INTO `t_b_visitor` VALUES ('402881e64d094b2b014d095f25cc0000', '李刚', '402881e64d05267d014d0528d8570001', '2', '2020-04-02 12:42:24', '2020-04-03 12:42:27', '来了', NULL);
INSERT INTO `t_b_visitor` VALUES ('402881ee3372370bbb44b9b83669614e', '李四', '402881e68924290d2424f7a8587fcf6c', '1', '2020-04-02 12:42:24', '2020-04-03 12:42:27', '来了', NULL);

-- ----------------------------
-- Table structure for t_s_depart
-- ----------------------------
DROP TABLE IF EXISTS `t_s_depart`;
CREATE TABLE `t_s_depart`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门ID',
  `departname` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门描述',
  `parentid` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门ID',
  `createTime` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_t_s_depart_t_s_depart1`(`parentid`) USING BTREE,
  CONSTRAINT `fk_t_s_depart_t_s_depart1` FOREIGN KEY (`parentid`) REFERENCES `t_s_depart` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_s_depart
-- ----------------------------
INSERT INTO `t_s_depart` VALUES ('1', 'test', 'test', '1', NULL);

-- ----------------------------
-- Table structure for t_s_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_s_resource`;
CREATE TABLE `t_s_resource`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源ID',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源描述',
  `href` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属链接',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `order_no` int(11) NULL DEFAULT NULL COMMENT '资源排序列',
  `resourceType` int(11) NULL DEFAULT NULL COMMENT '资源等级',
  `parentid` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属资源ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_t_s_resource_t_s_resource1`(`parentid`) USING BTREE,
  CONSTRAINT `fk_t_s_resource_t_s_resource1` FOREIGN KEY (`parentid`) REFERENCES `t_s_resource` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_s_resource
-- ----------------------------
INSERT INTO `t_s_resource` VALUES ('1', '2014-08-27 16:05:40', '系统', '/', '系统', 1, 1, NULL);
INSERT INTO `t_s_resource` VALUES ('2', NULL, NULL, 'userController.do?goUser', '用户管理', 1, 1, '5');
INSERT INTO `t_s_resource` VALUES ('3', NULL, NULL, 'roleController.do?goRole', '角色管理', 2, 1, '5');
INSERT INTO `t_s_resource` VALUES ('4', NULL, NULL, 'resourceController.do?goResource', '菜单管理', 3, 1, '5');
INSERT INTO `t_s_resource` VALUES ('402881e44cb6a685014cb6a840aa0000', '2015-04-14 17:07:19', '基本信息管理', '/', '信息管理', 2, 1, '1');
INSERT INTO `t_s_resource` VALUES ('402881e44cb71ec1014cb723b7f40000', '2015-04-15 13:55:55', '学生基本信息管理', 'studentController.do?goStudent', '学生管理', 1, 1, '402881e44cb6a685014cb6a840aa0000');
INSERT INTO `t_s_resource` VALUES ('402881e44cbbe87e014cbbea99a80000', '2015-04-15 15:10:56', '班级信息管理', 'classController.do?goClass', '班级管理', 2, 1, '402881e44cb6a685014cb6a840aa0000');
INSERT INTO `t_s_resource` VALUES ('402881e54ce5b4be014ce5b838fa0000', '2015-04-23 17:59:57', '管理访客', 'visitorController.do?goVisitor', '访客管理', 3, 1, '402881e44cb6a685014cb6a840aa0000');
INSERT INTO `t_s_resource` VALUES ('402881e54ce5b4be014ce5b8def70001', '2015-04-27 10:00:44', '管理损坏情况', 'damageController.do?goDamage', '损耗管理', 4, 1, '402881e44cb6a685014cb6a840aa0000');
INSERT INTO `t_s_resource` VALUES ('402881e54ce5b4be014ce5b9a0bb0002', '2015-04-23 18:01:30', '管理宿舍信息', 'dormController.do?goDorm', '宿舍管理', 5, 1, '402881e44cb6a685014cb6a840aa0000');
INSERT INTO `t_s_resource` VALUES ('402881e64d0404df014d040685870000', '2015-04-29 15:14:05', '对宿舍进行评分', 'scoreController.do?goScore', '宿舍评分', 6, 1, '402881e44cb6a685014cb6a840aa0000');
INSERT INTO `t_s_resource` VALUES ('5', NULL, NULL, '/', '系统管理', 9, 1, '1');

-- ----------------------------
-- Table structure for t_s_role
-- ----------------------------
DROP TABLE IF EXISTS `t_s_role`;
CREATE TABLE `t_s_role`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '角色描述',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_s_role
-- ----------------------------
INSERT INTO `t_s_role` VALUES ('1', '2015-04-29 15:14:30', 'admin', 'admin');
INSERT INTO `t_s_role` VALUES ('402883f3715c9a7201715cb2ab9f0000', '2020-04-09 10:09:05', '学生', 'student');

-- ----------------------------
-- Table structure for t_s_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_s_role_resource`;
CREATE TABLE `t_s_role_resource`  (
  `role_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  `resource_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色资源ID',
  INDEX `FK17BAC656127E527`(`role_id`) USING BTREE,
  INDEX `FK17BAC653B9CBFA7`(`resource_id`) USING BTREE,
  CONSTRAINT `FK17BAC653B9CBFA7` FOREIGN KEY (`resource_id`) REFERENCES `t_s_resource` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK17BAC656127E527` FOREIGN KEY (`role_id`) REFERENCES `t_s_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色资源' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_s_role_resource
-- ----------------------------
INSERT INTO `t_s_role_resource` VALUES ('1', '1');
INSERT INTO `t_s_role_resource` VALUES ('1', '402881e44cb6a685014cb6a840aa0000');
INSERT INTO `t_s_role_resource` VALUES ('1', '402881e44cb71ec1014cb723b7f40000');
INSERT INTO `t_s_role_resource` VALUES ('1', '402881e44cbbe87e014cbbea99a80000');
INSERT INTO `t_s_role_resource` VALUES ('1', '402881e54ce5b4be014ce5b838fa0000');
INSERT INTO `t_s_role_resource` VALUES ('1', '402881e54ce5b4be014ce5b8def70001');
INSERT INTO `t_s_role_resource` VALUES ('1', '402881e54ce5b4be014ce5b9a0bb0002');
INSERT INTO `t_s_role_resource` VALUES ('1', '402881e64d0404df014d040685870000');
INSERT INTO `t_s_role_resource` VALUES ('1', '5');
INSERT INTO `t_s_role_resource` VALUES ('1', '2');
INSERT INTO `t_s_role_resource` VALUES ('1', '3');
INSERT INTO `t_s_role_resource` VALUES ('1', '4');
INSERT INTO `t_s_role_resource` VALUES ('402883f3715c9a7201715cb2ab9f0000', '402881e44cb71ec1014cb723b7f40000');
INSERT INTO `t_s_role_resource` VALUES ('402883f3715c9a7201715cb2ab9f0000', '402881e44cbbe87e014cbbea99a80000');
INSERT INTO `t_s_role_resource` VALUES ('402883f3715c9a7201715cb2ab9f0000', '402881e54ce5b4be014ce5b8def70001');
INSERT INTO `t_s_role_resource` VALUES ('402883f3715c9a7201715cb2ab9f0000', '402881e54ce5b4be014ce5b9a0bb0002');
INSERT INTO `t_s_role_resource` VALUES ('402883f3715c9a7201715cb2ab9f0000', '402881e64d0404df014d040685870000');
INSERT INTO `t_s_role_resource` VALUES ('402883f3715c9a7201715cb2ab9f0000', '1');
INSERT INTO `t_s_role_resource` VALUES ('402883f3715c9a7201715cb2ab9f0000', '402881e44cb6a685014cb6a840aa0000');

-- ----------------------------
-- Table structure for t_s_user
-- ----------------------------
DROP TABLE IF EXISTS `t_s_user`;
CREATE TABLE `t_s_user`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `position` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职务',
  `position_desc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职务说明',
  `real_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真是姓名',
  `status` int(11) NULL DEFAULT NULL COMMENT '1 : 正常  2 :禁用',
  `userName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `departid` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_t_s_user_t_s_depart1`(`departid`) USING BTREE,
  CONSTRAINT `fk_t_s_user_t_s_depart1` FOREIGN KEY (`departid`) REFERENCES `t_s_depart` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_s_user
-- ----------------------------
INSERT INTO `t_s_user` VALUES ('1', '2015-04-03 14:32:12', 'ser@bjpowernode.com', '21232f297a57a5a743894a0e4a801fc3', '13545678911', '宿舍管理员', '管理学生住宿', '管理员', 1, 'admin', NULL);
INSERT INTO `t_s_user` VALUES ('402883f3715c9a7201715cb3c6a40001', '2020-04-09 10:10:17', '120492@qq.com', 'a66abb5684c45962d887564f08346e8d', '13522222222', '学生', '学生', '学生', 1, 'stu', NULL);

-- ----------------------------
-- Table structure for t_s_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_s_user_role`;
CREATE TABLE `t_s_user_role`  (
  `user_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `role_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限ID',
  INDEX `FKD0596186127E527`(`role_id`) USING BTREE,
  INDEX `FKD059618652A907`(`user_id`) USING BTREE,
  CONSTRAINT `FKD0596186127E527` FOREIGN KEY (`role_id`) REFERENCES `t_s_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKD059618652A907` FOREIGN KEY (`user_id`) REFERENCES `t_s_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_s_user_role
-- ----------------------------
INSERT INTO `t_s_user_role` VALUES ('1', '1');
INSERT INTO `t_s_user_role` VALUES ('402883f3715c9a7201715cb3c6a40001', '402883f3715c9a7201715cb2ab9f0000');

SET FOREIGN_KEY_CHECKS = 1;
