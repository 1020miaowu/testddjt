/*
        Navicat MySQL Data Transfer

        Source Server         : localhost
        Source Server Version : 80031
        Source Host           : localhost:3306
        Source Database       : banhui

        Target Server Type    : MYSQL
        Target Server Version : 80031
        File Encoding         : 65001

        Date: 2022-12-09 17:42:55
        */

SET FOREIGN_KEY_CHECKS=0;

        -- ----------------------------
        -- Table structure for t_hdxt_hdcy
        -- ----------------------------
DROP TABLE IF EXISTS `t_hdxt_hdcy`;
CREATE TABLE `t_hdxt_hdcy` (
                               `id` int NOT NULL AUTO_INCREMENT COMMENT '活动成员主键',
                               `hdsq_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '活动申请id（外键）',
                               `userid` varchar(255) DEFAULT NULL COMMENT '参与人员id',
                               `qdsj` date DEFAULT NULL COMMENT '签到时间',
                               `qtsj` date DEFAULT NULL COMMENT '签退时间',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='活动成员';
-- ----------------------------
-- Table structure for t_hdxt_hdfl
-- ----------------------------
DROP TABLE IF EXISTS `t_hdxt_hdfl`;
CREATE TABLE `t_hdxt_hdfl` (
                               `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                               `fldm` varchar(255) DEFAULT NULL COMMENT '分类代码',
                               `user_id` int DEFAULT NULL COMMENT '管理人员id',
                               `px` varchar(255) DEFAULT NULL COMMENT '排序',
                               `zt` varchar(255) DEFAULT NULL COMMENT '状态，数据字典（启用/禁用）',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='活动分类';

-- ----------------------------
-- Table structure for t_hdxt_hdsq
-- ----------------------------
DROP TABLE IF EXISTS `t_hdxt_hdsq`;
CREATE TABLE `t_hdxt_hdsq` (
                               `id` int NOT NULL COMMENT '活动申请id',
                               `processde` varchar(255) DEFAULT NULL COMMENT '流程定义名称',
                               `lcid` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '流程id',
                               `dqhjbz` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '当前环节步骤',
                               `dqhjmc` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '当前环节名称',
                               `bm_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '部门/学院id',
                               `bm_mc` varchar(255) DEFAULT NULL COMMENT '部门名称',
                               `bm_dm` varchar(255) DEFAULT NULL COMMENT '部门代码',
                               `bjdm` varchar(255) DEFAULT NULL COMMENT '班级代码',
                               `zydm` varchar(255) DEFAULT NULL COMMENT '专业代码',
                               `sqrid` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '申请人id',
                               `sqrmc` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '申请人名称',
                               `sqrgh` varchar(255) DEFAULT NULL COMMENT '申请人工号',
                               `sqsj` date DEFAULT NULL COMMENT '申请时间',
                               `lxdh` varchar(255) DEFAULT NULL COMMENT '联系电话（手机号）',
                               `lczt` varchar(255) DEFAULT NULL COMMENT '流程状态：-1草稿，0未处理，1办理中，2已办结（审核通过），3已终止（审核不通过）',
                               `xn` varchar(255) DEFAULT NULL COMMENT '学年',
                               `hdfl_id` varchar(255) DEFAULT NULL COMMENT '活动分类id',
                               `hdzt` varchar(255) DEFAULT NULL COMMENT '活动专题，数据字典',
                               `hdbt` varchar(255) DEFAULT NULL COMMENT '活动主题/标题',
                               `hddd` varchar(255) DEFAULT NULL COMMENT '活动地点',
                               `fzrmc` varchar(255) DEFAULT NULL COMMENT '负责人名称',
                               `fzrlxdh` varchar(255) DEFAULT NULL COMMENT '负责人联系电话',
                               `zjrmc` varchar(255) DEFAULT NULL COMMENT '主讲人名称',
                               `zjrlxdh` varchar(255) DEFAULT NULL COMMENT '主讲人联系电话',
                               `hdkssj` date DEFAULT NULL COMMENT '活动开始时间',
                               `hdjssj` date DEFAULT NULL COMMENT '活动结束时间',
                               `hdxct` varchar(255) DEFAULT NULL COMMENT '活动宣传图，附件',
                               `hdgs` varchar(255) DEFAULT NULL COMMENT '活动概述',
                               `fj` varchar(255) DEFAULT NULL COMMENT '附件',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='活动申请';
