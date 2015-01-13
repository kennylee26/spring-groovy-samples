/*
 Source Server Type    : MySQL
 Source Server Version : 50615
 Source Host           : localhost
 Source Database       : springbootdb

 Target Server Type    : MySQL
 Target Server Version : 50615
 File Encoding         : utf-8

 Date: 01/13/2015 22:57:04 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '姓名',
  `mobile` varchar(24) DEFAULT NULL COMMENT '手机号码',
  `mail` varchar(128) DEFAULT NULL COMMENT '邮件地址',
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', '张三', '13800138000', '1234@qq.com', '2015-01-13 22:56:11'), ('2', '李四', '13800138000', '54321@qq.com', '2015-01-13 22:56:33');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
