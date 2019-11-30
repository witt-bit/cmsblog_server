/*
Navicat MySQL Data Transfer

Source Server         : mysql-aliyun
Source Server Version : 50728
Source Host           : 47.103.215.243:3306
Source Database       : cms_leleBlog

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2019-11-30 15:50:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cms_article
-- ----------------------------
DROP TABLE IF EXISTS `cms_article`;
CREATE TABLE `cms_article` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` text,
  `source` text,
  `publish_time` bigint(20) DEFAULT NULL,
  `read_times` bigint(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `thumb_up` bigint(255) DEFAULT NULL,
  `thumb_down` bigint(255) DEFAULT NULL,
  `author_id` bigint(255) DEFAULT NULL,
  `category_id` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `author_id` (`author_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `cms_article_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `cms_user` (`id`),
  CONSTRAINT `cms_article_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `cms_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_article
-- ----------------------------
INSERT INTO `cms_article` VALUES ('1', 'Oracle从删库到跑路', 'Oracle的分页实现是由rownum完成的', '', null, null, null, null, null, '1', '1');
INSERT INTO `cms_article` VALUES ('2', '岳阳楼记', '予观夫巴陵胜状，在洞庭一湖。衔远山，吞长江，浩浩汤汤，横无际涯；朝晖夕阴，气象万千。此则岳阳楼之大观也，前人之述备矣。然则北通巫峡，南极潇湘，迁客骚人，多会于此，览物之情，得无异乎？ ', '<span>予观夫巴陵胜状，在洞庭一湖。衔远山，吞长江，浩浩汤汤，横无际涯；朝晖夕阴，气象万千。此则岳阳楼之大观也，前人之述备矣。然则北通巫峡，南极潇湘，迁客骚人，多会于此，览物之情，得无异乎？ </span>', '1573645121029', '0', '待审核', '0', '0', '2', '2');
INSERT INTO `cms_article` VALUES ('4', '出师表', '先帝创业未半，而中道崩猝', null, '1573722823462', '0', '待审核', '0', '0', null, '2');
INSERT INTO `cms_article` VALUES ('5', '琵琶行', '浔阳江头夜送客，枫叶荻花秋瑟瑟', null, '1573820232101', '0', '待审核', '0', '0', null, '2');
INSERT INTO `cms_article` VALUES ('8', '阿里云项目部署', '阿里云从入门到放弃', null, null, null, '待审核', null, null, '1', '1');

-- ----------------------------
-- Table structure for cms_category
-- ----------------------------
DROP TABLE IF EXISTS `cms_category`;
CREATE TABLE `cms_category` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `no` int(255) DEFAULT NULL,
  `parent_id` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `cms_category_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `cms_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_category
-- ----------------------------
INSERT INTO `cms_category` VALUES ('1', '数据库', null, '1', null);
INSERT INTO `cms_category` VALUES ('2', '其他', null, '2', null);
INSERT INTO `cms_category` VALUES ('20', 'Android开发', 'Android开发相关内容', null, '2');
INSERT INTO `cms_category` VALUES ('22', '文学', '诗词文学信息', null, null);
INSERT INTO `cms_category` VALUES ('23', 'Java基础', 'core Java相关内容', null, null);

-- ----------------------------
-- Table structure for cms_comment
-- ----------------------------
DROP TABLE IF EXISTS `cms_comment`;
CREATE TABLE `cms_comment` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `content` text,
  `comment_time` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_id` bigint(255) DEFAULT NULL,
  `article_id` bigint(255) DEFAULT NULL,
  `parent_id` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `article_id` (`article_id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `cms_comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `cms_user` (`id`),
  CONSTRAINT `cms_comment_ibfk_2` FOREIGN KEY (`article_id`) REFERENCES `cms_article` (`id`),
  CONSTRAINT `cms_comment_ibfk_3` FOREIGN KEY (`parent_id`) REFERENCES `cms_comment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_comment
-- ----------------------------
INSERT INTO `cms_comment` VALUES ('1', '好极了', '465416416461', null, '1', '1', null);
INSERT INTO `cms_comment` VALUES ('3', '真好', '16416316', null, '2', '1', null);
INSERT INTO `cms_comment` VALUES ('5', '评论2', '16163', '审核未通过', '1', '1', null);
INSERT INTO `cms_comment` VALUES ('9', '写的真好', '1574493734076', '待审核', null, '1', null);
INSERT INTO `cms_comment` VALUES ('11', '范仲淹来了', '1574493998218', '待审核', null, '2', null);
INSERT INTO `cms_comment` VALUES ('12', '刘备哭了', '1574561264700', '待审核', null, '4', null);
INSERT INTO `cms_comment` VALUES ('13', '部署完成', '1575100052577', '待审核', null, '8', null);

-- ----------------------------
-- Table structure for cms_logs
-- ----------------------------
DROP TABLE IF EXISTS `cms_logs`;
CREATE TABLE `cms_logs` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `content` text,
  `action_time` bigint(20) DEFAULT NULL,
  `type` varchar(20) NOT NULL,
  `user_id` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `cms_logs_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `cms_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=826 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_logs
-- ----------------------------
INSERT INTO `cms_logs` VALUES ('712', '用户ip:{49.94.29.194},类名:{com.lele.apps.cms.service.impl.LogServiceImpl},方法名:{findAll}上,通过参数名:{[]}执行时间:{10 ms}', '1574678240413', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('713', '用户ip:{49.94.29.194},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[3]}执行时间:{4 ms}', '1574678262706', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('714', '用户ip:{49.94.29.194},类名:{com.lele.apps.cms.service.impl.LogServiceImpl},方法名:{batchDeleteLogs}上,通过参数名:{[[Ljava.lang.Long;@6b9cb488]}执行时间:{1133 ms}', '1574678263846', '[info, delete]', '3');
INSERT INTO `cms_logs` VALUES ('715', '用户ip:{49.94.29.194},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[3]}执行时间:{2 ms}', '1574678264117', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('716', '用户ip:{49.94.29.194},类名:{com.lele.apps.cms.service.impl.LogServiceImpl},方法名:{findAll}上,通过参数名:{[]}执行时间:{1 ms}', '1574678264123', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('717', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.UserServiceImpl},方法名:{findById}上,通过参数名:{[10]}执行时间:{2 ms}', '1574693676590', '[info, query]', '10');
INSERT INTO `cms_logs` VALUES ('718', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[10]}执行时间:{3 ms}', '1574693693242', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('719', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.ArticleServiceImpl},方法名:{cascadeFindAll}上,通过参数名:{[]}执行时间:{9 ms}', '1574693693259', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('720', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[10]}执行时间:{3 ms}', '1574693701306', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('721', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.CategoryServiceImpl},方法名:{findAll}上,通过参数名:{[]}执行时间:{1 ms}', '1574693701313', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('722', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.web.controller.CategoryController},方法名:{findAll}上,通过参数名:{[]}执行时间:{6 ms}', '1574693701317', '[info, error]', '10');
INSERT INTO `cms_logs` VALUES ('723', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[10]}执行时间:{4 ms}', '1574693703868', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('724', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.ArticleServiceImpl},方法名:{findById}上,通过参数名:{[null]}执行时间:{1 ms}', '1574693703873', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('725', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.web.controller.ArticleController},方法名:{findById}上,通过参数名:{[null]}执行时间:{4 ms}', '1574693703879', '[info, error]', '10');
INSERT INTO `cms_logs` VALUES ('726', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[10]}执行时间:{5 ms}', '1574693706714', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('727', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.CategoryServiceImpl},方法名:{findAllIncludeParent}上,通过参数名:{[]}执行时间:{1 ms}', '1574693706722', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('728', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.web.controller.CategoryController},方法名:{findAllIncludeParent}上,通过参数名:{[]}执行时间:{8 ms}', '1574693706727', '[info, error]', '10');
INSERT INTO `cms_logs` VALUES ('729', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[10]}执行时间:{2 ms}', '1574693711249', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('730', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{findAllIncludeChrild}上,通过参数名:{[]}执行时间:{10 ms}', '1574693711266', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('731', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[10]}执行时间:{4 ms}', '1574693711465', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('732', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{findAll}上,通过参数名:{[]}执行时间:{3 ms}', '1574693711474', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('733', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[10]}执行时间:{1 ms}', '1574693712885', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('734', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.CategoryServiceImpl},方法名:{findAllIncludeParent}上,通过参数名:{[]}执行时间:{1 ms}', '1574693712891', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('735', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.web.controller.CategoryController},方法名:{findAllIncludeParent}上,通过参数名:{[]}执行时间:{5 ms}', '1574693712894', '[info, error]', '10');
INSERT INTO `cms_logs` VALUES ('736', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[10]}执行时间:{2 ms}', '1574693713793', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('737', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.ArticleServiceImpl},方法名:{findById}上,通过参数名:{[null]}执行时间:{0 ms}', '1574693713798', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('738', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.web.controller.ArticleController},方法名:{findById}上,通过参数名:{[null]}执行时间:{4 ms}', '1574693713806', '[info, error]', '10');
INSERT INTO `cms_logs` VALUES ('739', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[10]}执行时间:{2 ms}', '1574693714992', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('740', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.CategoryServiceImpl},方法名:{findAll}上,通过参数名:{[]}执行时间:{1 ms}', '1574693714997', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('741', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.web.controller.CategoryController},方法名:{findAll}上,通过参数名:{[]}执行时间:{5 ms}', '1574693715000', '[info, error]', '10');
INSERT INTO `cms_logs` VALUES ('742', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[10]}执行时间:{4 ms}', '1574693715417', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('743', '用户ip:{27.224.49.203},类名:{com.lele.apps.cms.service.impl.ArticleServiceImpl},方法名:{cascadeFindAll}上,通过参数名:{[]}执行时间:{4 ms}', '1574693715424', '[query, info]', '10');
INSERT INTO `cms_logs` VALUES ('744', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.UserServiceImpl},方法名:{findById}上,通过参数名:{[3]}执行时间:{2 ms}', '1575098552013', '[info, query]', '3');
INSERT INTO `cms_logs` VALUES ('745', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.UserServiceImpl},方法名:{findById}上,通过参数名:{[3]}执行时间:{2 ms}', '1575098563247', '[info, query]', '3');
INSERT INTO `cms_logs` VALUES ('746', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.UserServiceImpl},方法名:{findById}上,通过参数名:{[3]}执行时间:{2 ms}', '1575099824847', '[info, query]', '3');
INSERT INTO `cms_logs` VALUES ('747', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[3]}执行时间:{3 ms}', '1575099843014', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('748', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.ArticleServiceImpl},方法名:{cascadeFindAll}上,通过参数名:{[]}执行时间:{5 ms}', '1575099843024', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('749', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[3]}执行时间:{2 ms}', '1575099857467', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('750', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.CategoryServiceImpl},方法名:{findAllIncludeParent}上,通过参数名:{[]}执行时间:{1 ms}', '1575099857475', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('751', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.web.controller.CategoryController},方法名:{findAllIncludeParent}上,通过参数名:{[]}执行时间:{5 ms}', '1575099857478', '[info, error]', '3');
INSERT INTO `cms_logs` VALUES ('752', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[3]}执行时间:{3 ms}', '1575099875059', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('753', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.CommentServiceImpl},方法名:{findByStatus}上,通过参数名:{[null]}执行时间:{2 ms}', '1575099875064', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('754', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[3]}执行时间:{2 ms}', '1575099902646', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('755', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.UserServiceImpl},方法名:{screening}上,通过参数名:{[null]}执行时间:{4 ms}', '1575099902658', '[info, query]', '3');
INSERT INTO `cms_logs` VALUES ('756', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[3]}执行时间:{2 ms}', '1575099902828', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('757', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.RoleServiceImpl},方法名:{findAll}上,通过参数名:{[]}执行时间:{1 ms}', '1575099902834', '[info, delete]', '3');
INSERT INTO `cms_logs` VALUES ('758', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[3]}执行时间:{2 ms}', '1575099922343', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('759', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[3]}执行时间:{5 ms}', '1575099922354', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('760', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.RoleServiceImpl},方法名:{findAllIncludePrivilege}上,通过参数名:{[]}执行时间:{11 ms}', '1575099922363', '[save, info]', '3');
INSERT INTO `cms_logs` VALUES ('761', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{findAllIncludeChrild}上,通过参数名:{[]}执行时间:{12 ms}', '1575099922395', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('762', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[3]}执行时间:{4 ms}', '1575099938435', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('763', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{findAllIncludeChrild}上,通过参数名:{[]}执行时间:{6 ms}', '1575099938445', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('764', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[3]}执行时间:{2 ms}', '1575099938475', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('765', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{findAll}上,通过参数名:{[]}执行时间:{2 ms}', '1575099938481', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('766', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[3]}执行时间:{2 ms}', '1575099958901', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('767', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.LogServiceImpl},方法名:{findAll}上,通过参数名:{[]}执行时间:{9 ms}', '1575099958916', '[query, info]', '3');
INSERT INTO `cms_logs` VALUES ('768', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.UserServiceImpl},方法名:{findById}上,通过参数名:{[9]}执行时间:{1 ms}', '1575099993493', '[info, query]', '9');
INSERT INTO `cms_logs` VALUES ('769', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{1 ms}', '1575099993695', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('770', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{3 ms}', '1575099998346', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('771', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.ArticleServiceImpl},方法名:{cascadeFindAll}上,通过参数名:{[]}执行时间:{3 ms}', '1575099998355', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('772', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{2 ms}', '1575100003197', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('773', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.CommentServiceImpl},方法名:{findByStatus}上,通过参数名:{[null]}执行时间:{2 ms}', '1575100003202', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('774', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{2 ms}', '1575100005822', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('775', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.CategoryServiceImpl},方法名:{findAllIncludeParent}上,通过参数名:{[]}执行时间:{2 ms}', '1575100005829', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('776', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.web.controller.CategoryController},方法名:{findAllIncludeParent}上,通过参数名:{[]}执行时间:{6 ms}', '1575100005838', '[info, error]', '9');
INSERT INTO `cms_logs` VALUES ('777', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{3 ms}', '1575100008434', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('778', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.ArticleServiceImpl},方法名:{cascadeFindAll}上,通过参数名:{[]}执行时间:{3 ms}', '1575100008440', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('779', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{1 ms}', '1575100009876', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('780', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{2 ms}', '1575100009889', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('781', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{2 ms}', '1575100025705', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('782', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.CategoryServiceImpl},方法名:{findAllIncludeParent}上,通过参数名:{[]}执行时间:{2 ms}', '1575100025713', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('783', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.web.controller.CategoryController},方法名:{findAllIncludeParent}上,通过参数名:{[]}执行时间:{7 ms}', '1575100025717', '[info, error]', '9');
INSERT INTO `cms_logs` VALUES ('784', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{1 ms}', '1575100028199', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('785', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.ArticleServiceImpl},方法名:{cascadeFindAll}上,通过参数名:{[]}执行时间:{6 ms}', '1575100028209', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('786', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{2 ms}', '1575100029722', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('787', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.CommentServiceImpl},方法名:{findByStatus}上,通过参数名:{[null]}执行时间:{4 ms}', '1575100029730', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('788', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{2 ms}', '1575100032337', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('789', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.CommentServiceImpl},方法名:{findByStatus}上,通过参数名:{[审核未通过]}执行时间:{1 ms}', '1575100032342', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('790', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{4 ms}', '1575100034936', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('791', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.CategoryServiceImpl},方法名:{findAllIncludeParent}上,通过参数名:{[]}执行时间:{2 ms}', '1575100034942', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('792', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.web.controller.CategoryController},方法名:{findAllIncludeParent}上,通过参数名:{[]}执行时间:{8 ms}', '1575100034949', '[info, error]', '9');
INSERT INTO `cms_logs` VALUES ('793', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{2 ms}', '1575100035955', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('794', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.CommentServiceImpl},方法名:{findByStatus}上,通过参数名:{[null]}执行时间:{2 ms}', '1575100035961', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('795', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{1 ms}', '1575100036969', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('796', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.ArticleServiceImpl},方法名:{cascadeFindAll}上,通过参数名:{[]}执行时间:{3 ms}', '1575100036975', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('797', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{1 ms}', '1575100041550', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('798', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.ArticleServiceImpl},方法名:{findById}上,通过参数名:{[8]}执行时间:{2 ms}', '1575100041557', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('799', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.web.controller.ArticleController},方法名:{findById}上,通过参数名:{[8]}执行时间:{6 ms}', '1575100041560', '[info, error]', '9');
INSERT INTO `cms_logs` VALUES ('800', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{1 ms}', '1575100052570', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('801', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.CommentServiceImpl},方法名:{saveOrUpdate}上,通过参数名:{[com.lele.apps.cms.bean.Comment@6c1cea1f]}执行时间:{3 ms}', '1575100052581', '[save, modify, info]', '9');
INSERT INTO `cms_logs` VALUES ('802', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{3 ms}', '1575100052623', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('803', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.ArticleServiceImpl},方法名:{findById}上,通过参数名:{[8]}执行时间:{5 ms}', '1575100052632', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('804', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.web.controller.ArticleController},方法名:{findById}上,通过参数名:{[8]}执行时间:{8 ms}', '1575100052636', '[info, error]', '9');
INSERT INTO `cms_logs` VALUES ('805', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{2 ms}', '1575100071880', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('806', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.CategoryServiceImpl},方法名:{findAllIncludeParent}上,通过参数名:{[]}执行时间:{2 ms}', '1575100071886', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('807', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.web.controller.CategoryController},方法名:{findAllIncludeParent}上,通过参数名:{[]}执行时间:{5 ms}', '1575100071890', '[info, error]', '9');
INSERT INTO `cms_logs` VALUES ('808', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{1 ms}', '1575100074627', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('809', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.CommentServiceImpl},方法名:{findByStatus}上,通过参数名:{[null]}执行时间:{2 ms}', '1575100074634', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('810', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{2 ms}', '1575100076880', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('811', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{1 ms}', '1575100076891', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('812', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{5 ms}', '1575100079300', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('813', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{6 ms}', '1575100079301', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('814', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{2 ms}', '1575100081850', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('815', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{4 ms}', '1575100085547', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('816', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{1 ms}', '1575100087547', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('817', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{1 ms}', '1575100087557', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('818', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{4 ms}', '1575100088064', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('819', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{7 ms}', '1575100088065', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('820', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{4 ms}', '1575100091307', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('821', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{6 ms}', '1575100095283', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('822', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{2 ms}', '1575100095283', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('823', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.PrivilegeServiceImpl},方法名:{selectByUserId}上,通过参数名:{[9]}执行时间:{1 ms}', '1575100097576', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('824', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.service.impl.CategoryServiceImpl},方法名:{findAllIncludeParent}上,通过参数名:{[]}执行时间:{1 ms}', '1575100097585', '[query, info]', '9');
INSERT INTO `cms_logs` VALUES ('825', '用户ip:{221.225.207.196},类名:{com.lele.apps.cms.web.controller.CategoryController},方法名:{findAllIncludeParent}上,通过参数名:{[]}执行时间:{4 ms}', '1575100097588', '[info, error]', '9');

-- ----------------------------
-- Table structure for cms_privilege
-- ----------------------------
DROP TABLE IF EXISTS `cms_privilege`;
CREATE TABLE `cms_privilege` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `route` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `parent_id` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `cms_privilege_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `cms_privilege` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_privilege
-- ----------------------------
INSERT INTO `cms_privilege` VALUES ('1', '文章管理', '文章管理的一级路由', '/article/*', 'menu', null, null);
INSERT INTO `cms_privilege` VALUES ('2', '栏目管理', '栏目管理的一级路由', '/category/*', 'menu', null, null);
INSERT INTO `cms_privilege` VALUES ('3', '评论管理', '评论管理的一级路由', '/comment/*', 'menu', null, null);
INSERT INTO `cms_privilege` VALUES ('4', '权限管理', '权限管理的一级路由', '/privilege/*', 'menu', null, null);
INSERT INTO `cms_privilege` VALUES ('5', '角色管理', '角色管理的一级路由', '/role/*', 'menu', null, null);
INSERT INTO `cms_privilege` VALUES ('6', '用户管理', '用户管理的一级路由', '/user/*', 'menu', null, null);
INSERT INTO `cms_privilege` VALUES ('7', '日志管理', '日志管理的一级路由', '/logs/*', 'menu', null, null);
INSERT INTO `cms_privilege` VALUES ('8', '文章查询(级联)', '文章级联查询', '/article/cascadeFindAll', 'function', null, '1');
INSERT INTO `cms_privilege` VALUES ('9', '删除文章(id)', '通过id删除文章', '/article/deleteById', 'function', null, '1');
INSERT INTO `cms_privilege` VALUES ('10', '文章查询', '文章查询', '/article/findAll', 'function', null, '1');
INSERT INTO `cms_privilege` VALUES ('11', '文章查询(id)', '通过id查询文章', '/article/findById', 'function', null, '1');
INSERT INTO `cms_privilege` VALUES ('12', '保存或更新文章', '对文章的添加和修改', '/article/saveOrUpdate', 'function', null, '1');
INSERT INTO `cms_privilege` VALUES ('13', '删除栏目(批量)', '栏目批量删除', '/category/batchDelete', 'function', null, '2');
INSERT INTO `cms_privilege` VALUES ('14', '删除栏目(id)', '通过id批量删除栏目', '/category/deleteById', 'function', null, '2');
INSERT INTO `cms_privilege` VALUES ('15', '查询栏目', '查询所有的栏目', '/category/findAll', 'function', null, '2');
INSERT INTO `cms_privilege` VALUES ('16', '查询栏目(级联)', '查询所有的栏目,包括父栏目', '/category/findAllIncludeParent', 'function', null, '2');
INSERT INTO `cms_privilege` VALUES ('17', '保存或更新栏目', '栏目的添加和修改', '/category/saveOrUpdate', 'function', null, '2');
INSERT INTO `cms_privilege` VALUES ('18', '删除评论(批量)', '批量删除评论', '/comment/batchDelete', 'function', null, '3');
INSERT INTO `cms_privilege` VALUES ('19', '删除评论(id)', '删除评论,通过id', '/comment/deleteById', 'function', null, '3');
INSERT INTO `cms_privilege` VALUES ('20', '查询评论(id)', '通过id查询评论', '/comment/findById', 'function', null, '3');
INSERT INTO `cms_privilege` VALUES ('21', '查询评论(status)', '通过状态查询评论', '/comment/findByStatus', 'function', null, '3');
INSERT INTO `cms_privilege` VALUES ('22', '保存或更新评论', '评论的添加和修改', '/comment/saveOrUpdate', 'function', null, '3');
INSERT INTO `cms_privilege` VALUES ('23', '保存或更新权限', '添加和修改权限', '/privilege/addNewPrivilegeAndUpdatePrivilege', 'function', null, '4');
INSERT INTO `cms_privilege` VALUES ('24', '删除权限(id)', '通过id删除权限', '/privilege/deleteById', 'function', null, '4');
INSERT INTO `cms_privilege` VALUES ('25', '查询权限(同级)', '查询所有的权限', '/privilege/findAll', 'function', null, '4');
INSERT INTO `cms_privilege` VALUES ('26', '查询权限(层级)', '查询权限树', '/privilege/findAllIncludeChild', 'function', null, '4');
INSERT INTO `cms_privilege` VALUES ('27', '添加角色', '添加角色', '/role/add', 'function', null, '5');
INSERT INTO `cms_privilege` VALUES ('28', '删除角色', '删除单个角色', '/role/delete', 'function', null, '5');
INSERT INTO `cms_privilege` VALUES ('29', '查询角色(级联)', '查询角色级联查询出权限', '/role/findAllIncludePrivilege', 'function', null, '5');
INSERT INTO `cms_privilege` VALUES ('30', '添加或更新角色', '角色的添加和修改', '/role/saveOrUpdate', 'function', null, '5');
INSERT INTO `cms_privilege` VALUES ('31', '设置角色', '给用户设置角色', '/role/setUserRole', 'function', null, '5');
INSERT INTO `cms_privilege` VALUES ('32', '更新角色', '更新角色信息', '/role/update', 'function', null, '5');
INSERT INTO `cms_privilege` VALUES ('33', '角色授权', '给角色设置权限', '/roleprivilege/setPrivilege', 'function', null, '5');
INSERT INTO `cms_privilege` VALUES ('34', '删除用户(id)', '通过id删除用户', '/user/deleteById', 'function', null, '6');
INSERT INTO `cms_privilege` VALUES ('35', '查询用户(id)', '通过id查询用户', '/user/findById', 'function', null, '6');
INSERT INTO `cms_privilege` VALUES ('36', '查询用户(tel)', '通过tel查询用户', '/user/findByTel', 'function', null, '6');
INSERT INTO `cms_privilege` VALUES ('37', '查询用户(username)', '通过username查询用户', '/user/findByUsername', 'function', null, '6');
INSERT INTO `cms_privilege` VALUES ('38', '获取用户信息', '获得用户token', '/user/info', 'function', null, '6');
INSERT INTO `cms_privilege` VALUES ('39', '登录', '用户登录', '/user/login', 'function', null, '6');
INSERT INTO `cms_privilege` VALUES ('40', '退出', '用户退出', '/user/logout', 'function', null, '6');
INSERT INTO `cms_privilege` VALUES ('41', '保存或更新用户', '添加或修改用户信息', '/user/saveOrUpdate', 'function', null, '6');
INSERT INTO `cms_privilege` VALUES ('42', '查找用户', '查找用户信息，通过角色，账户状态等', '/user/screeningUserData', 'function', null, '6');
INSERT INTO `cms_privilege` VALUES ('43', '日志查询', '查询所有的日志', '/logs/findAll', 'function', null, '7');
INSERT INTO `cms_privilege` VALUES ('44', '日志查询(筛选)', '查询所有的日志，筛选的方式', '/logs/screening', 'function', null, '7');
INSERT INTO `cms_privilege` VALUES ('45', '角色查询', '查询所有的角色', '/role/findAll', 'function', null, '5');
INSERT INTO `cms_privilege` VALUES ('46', '导出日志数据', '将操作日志导出到Excel表中', '/logs/exportExcel', 'function', null, '7');
INSERT INTO `cms_privilege` VALUES ('47', '删除日志(单条记录)', '删除单条日志记录的权限', '/logs/deleteById', 'function', '', '7');
INSERT INTO `cms_privilege` VALUES ('48', '删除日志(批量)', '批量删除日志的权限', '/logs/batchDeleteByIds', 'function', null, '7');

-- ----------------------------
-- Table structure for cms_role
-- ----------------------------
DROP TABLE IF EXISTS `cms_role`;
CREATE TABLE `cms_role` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_role
-- ----------------------------
INSERT INTO `cms_role` VALUES ('1', 'admin', '超级管理员角色');
INSERT INTO `cms_role` VALUES ('2', 'editor', '博客运营者角色');
INSERT INTO `cms_role` VALUES ('3', 'reader', '普通读者用户的角色');

-- ----------------------------
-- Table structure for cms_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `cms_role_privilege`;
CREATE TABLE `cms_role_privilege` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(255) DEFAULT NULL,
  `privilege_id` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `privilege_id` (`privilege_id`),
  CONSTRAINT `cms_role_privilege_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `cms_role` (`id`),
  CONSTRAINT `cms_role_privilege_ibfk_2` FOREIGN KEY (`privilege_id`) REFERENCES `cms_privilege` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=168 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_role_privilege
-- ----------------------------
INSERT INTO `cms_role_privilege` VALUES ('65', '2', '8');
INSERT INTO `cms_role_privilege` VALUES ('66', '2', '9');
INSERT INTO `cms_role_privilege` VALUES ('67', '2', '10');
INSERT INTO `cms_role_privilege` VALUES ('68', '2', '11');
INSERT INTO `cms_role_privilege` VALUES ('69', '2', '12');
INSERT INTO `cms_role_privilege` VALUES ('70', '2', '13');
INSERT INTO `cms_role_privilege` VALUES ('71', '2', '14');
INSERT INTO `cms_role_privilege` VALUES ('72', '2', '15');
INSERT INTO `cms_role_privilege` VALUES ('73', '2', '16');
INSERT INTO `cms_role_privilege` VALUES ('74', '2', '17');
INSERT INTO `cms_role_privilege` VALUES ('75', '2', '18');
INSERT INTO `cms_role_privilege` VALUES ('76', '2', '19');
INSERT INTO `cms_role_privilege` VALUES ('77', '2', '20');
INSERT INTO `cms_role_privilege` VALUES ('78', '2', '21');
INSERT INTO `cms_role_privilege` VALUES ('79', '2', '22');
INSERT INTO `cms_role_privilege` VALUES ('80', '3', '8');
INSERT INTO `cms_role_privilege` VALUES ('81', '3', '10');
INSERT INTO `cms_role_privilege` VALUES ('82', '3', '11');
INSERT INTO `cms_role_privilege` VALUES ('83', '3', '15');
INSERT INTO `cms_role_privilege` VALUES ('84', '3', '16');
INSERT INTO `cms_role_privilege` VALUES ('85', '3', '19');
INSERT INTO `cms_role_privilege` VALUES ('86', '3', '20');
INSERT INTO `cms_role_privilege` VALUES ('87', '3', '21');
INSERT INTO `cms_role_privilege` VALUES ('88', '3', '22');
INSERT INTO `cms_role_privilege` VALUES ('127', '1', '8');
INSERT INTO `cms_role_privilege` VALUES ('128', '1', '9');
INSERT INTO `cms_role_privilege` VALUES ('129', '1', '10');
INSERT INTO `cms_role_privilege` VALUES ('130', '1', '11');
INSERT INTO `cms_role_privilege` VALUES ('131', '1', '12');
INSERT INTO `cms_role_privilege` VALUES ('132', '1', '13');
INSERT INTO `cms_role_privilege` VALUES ('133', '1', '14');
INSERT INTO `cms_role_privilege` VALUES ('134', '1', '15');
INSERT INTO `cms_role_privilege` VALUES ('135', '1', '16');
INSERT INTO `cms_role_privilege` VALUES ('136', '1', '17');
INSERT INTO `cms_role_privilege` VALUES ('137', '1', '18');
INSERT INTO `cms_role_privilege` VALUES ('138', '1', '19');
INSERT INTO `cms_role_privilege` VALUES ('139', '1', '20');
INSERT INTO `cms_role_privilege` VALUES ('140', '1', '21');
INSERT INTO `cms_role_privilege` VALUES ('141', '1', '22');
INSERT INTO `cms_role_privilege` VALUES ('142', '1', '23');
INSERT INTO `cms_role_privilege` VALUES ('143', '1', '24');
INSERT INTO `cms_role_privilege` VALUES ('144', '1', '25');
INSERT INTO `cms_role_privilege` VALUES ('145', '1', '26');
INSERT INTO `cms_role_privilege` VALUES ('146', '1', '27');
INSERT INTO `cms_role_privilege` VALUES ('147', '1', '28');
INSERT INTO `cms_role_privilege` VALUES ('148', '1', '29');
INSERT INTO `cms_role_privilege` VALUES ('149', '1', '30');
INSERT INTO `cms_role_privilege` VALUES ('150', '1', '31');
INSERT INTO `cms_role_privilege` VALUES ('151', '1', '32');
INSERT INTO `cms_role_privilege` VALUES ('152', '1', '33');
INSERT INTO `cms_role_privilege` VALUES ('153', '1', '45');
INSERT INTO `cms_role_privilege` VALUES ('154', '1', '34');
INSERT INTO `cms_role_privilege` VALUES ('155', '1', '35');
INSERT INTO `cms_role_privilege` VALUES ('156', '1', '36');
INSERT INTO `cms_role_privilege` VALUES ('157', '1', '37');
INSERT INTO `cms_role_privilege` VALUES ('158', '1', '38');
INSERT INTO `cms_role_privilege` VALUES ('159', '1', '39');
INSERT INTO `cms_role_privilege` VALUES ('160', '1', '40');
INSERT INTO `cms_role_privilege` VALUES ('161', '1', '41');
INSERT INTO `cms_role_privilege` VALUES ('162', '1', '42');
INSERT INTO `cms_role_privilege` VALUES ('163', '1', '43');
INSERT INTO `cms_role_privilege` VALUES ('164', '1', '44');
INSERT INTO `cms_role_privilege` VALUES ('165', '1', '46');
INSERT INTO `cms_role_privilege` VALUES ('166', '1', '47');
INSERT INTO `cms_role_privilege` VALUES ('167', '1', '48');

-- ----------------------------
-- Table structure for cms_user
-- ----------------------------
DROP TABLE IF EXISTS `cms_user`;
CREATE TABLE `cms_user` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `birth` bigint(255) DEFAULT NULL,
  `register_time` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_face` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_user
-- ----------------------------
INSERT INTO `cms_user` VALUES ('1', '倩倩', '19970808', '110', '马倩', '女', '19970808', '1214163163', '正常', 'http://134.175.154.93:8888/group1/M00/00/20/rBAACV3SlpqAJ6ltAAD5BxLjss434.jpeg');
INSERT INTO `cms_user` VALUES ('2', 'tom', '', null, null, '男', null, '15416116', '禁用', 'https://c-ssl.duitang.com/uploads/item/201508/05/20150805000549_iWQZ8.thumb.700_0.jpeg');
INSERT INTO `cms_user` VALUES ('3', 'admin', '123456', null, '管理员', '男', null, null, '正常', 'http://134.175.154.93:8888/group1/M00/00/20/rBAACV3SlpqAJ6ltAAD5BxLjss434.jpeg');
INSERT INTO `cms_user` VALUES ('8', 'editor', '123456', null, '运营者', '女', null, null, '正常', 'http://134.175.154.93:8888/group1/M00/00/20/rBAACV3SlpqAJ6ltAAD5BxLjss434.jpeg');
INSERT INTO `cms_user` VALUES ('9', 'reader', '123456', null, '读者', '男', null, null, '正常', 'http://134.175.154.93:8888/group1/M00/00/20/rBAACV3SlpqAJ6ltAAD5BxLjss434.jpeg');
INSERT INTO `cms_user` VALUES ('10', '小黄', '123456', null, '黄黄', '女', null, null, '正常', 'http://134.175.154.93:8888/group1/M00/00/20/rBAACV3SlpqAJ6ltAAD5BxLjss434.jpeg');

-- ----------------------------
-- Table structure for cms_user_role
-- ----------------------------
DROP TABLE IF EXISTS `cms_user_role`;
CREATE TABLE `cms_user_role` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(255) DEFAULT NULL,
  `role_id` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `cms_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `cms_user` (`id`),
  CONSTRAINT `cms_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `cms_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_user_role
-- ----------------------------
INSERT INTO `cms_user_role` VALUES ('26', '2', '2');
INSERT INTO `cms_user_role` VALUES ('27', '2', '3');
INSERT INTO `cms_user_role` VALUES ('29', '1', '1');
INSERT INTO `cms_user_role` VALUES ('30', '3', '1');
INSERT INTO `cms_user_role` VALUES ('31', '3', '2');
INSERT INTO `cms_user_role` VALUES ('32', '3', '3');
INSERT INTO `cms_user_role` VALUES ('33', '9', '3');
INSERT INTO `cms_user_role` VALUES ('34', '8', '2');
INSERT INTO `cms_user_role` VALUES ('35', '10', '1');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', 'Jack', null);
INSERT INTO `test` VALUES ('2', 'tom', null);
INSERT INTO `test` VALUES ('3', 'jerry', null);
INSERT INTO `test` VALUES ('4', '李四', '33');
INSERT INTO `test` VALUES ('5', '张三', '33');
INSERT INTO `test` VALUES ('6', null, null);
