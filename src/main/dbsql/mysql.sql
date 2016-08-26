/*
Navicat MySQL Data Transfer

Source Server         : local-linux
Source Server Version : 50550
Source Host           : 192.168.44.133:3306
Source Database       : hang

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2016-08-26 18:10:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email_address` varchar(64) DEFAULT '',
  `password` varchar(64) DEFAULT '',
  `first_name` varchar(32) DEFAULT '',
  `last_name` varchar(32) DEFAULT '',
  `birthday` date DEFAULT NULL,
  `gender` tinyint(4) DEFAULT '0',
  `user_type` int(11) DEFAULT '3' COMMENT '1-Super Admin 2-Car Dealer 3-End User',
  `phone` varchar(32) DEFAULT '',
  `mobile` varchar(32) DEFAULT '',
  `dln` varchar(32) DEFAULT '' COMMENT 'Driving License Number',
  `country_id` int(11) DEFAULT '0',
  `province_id` int(11) DEFAULT '0',
  `city_id` int(11) DEFAULT '0',
  `address` varchar(128) DEFAULT '',
  `ip` varchar(32) DEFAULT '',
  `token` varchar(64) DEFAULT '',
  `imei` varchar(64) DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `parent_id` int(11) DEFAULT '2' COMMENT '父ID',
  `kinship` varchar(255) DEFAULT NULL COMMENT '亲属关系(逗号分隔)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=734 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin@smartautotech.com', 'c3284d0f94606de1fd2af172aba15bf3', 'admin', 'smartauto', '2015-06-27', '0', '1', '', '18511657806', '', '1', '18', '1', '朝阳区新海淀村民王强有力的是可悲地杨万里老师的夺柘城要鼎飞丹砂硒鼓课啦', '0:0:0:0:0:0:0:1', '645cf1056a8c3fd202a2bde7301e9815', '', null, '2016-08-25 09:42:00', '0', '0,1,');
INSERT INTO `user` VALUES ('2', 'dealer@smartautotech.com', 'c84258e9c39059a89ab77d846ddab909', 'Andrew', 'Dixon', '2015-08-30', '0', '2', '18201010101', '18511657805', null, '1', '20', '214', '宝安区', '192.168.88.102', '239558a05e1c5875e5078179c980ba04', '12345', '2015-09-12 20:07:21', '2016-07-14 16:31:11', '1', '0,1,2,');
INSERT INTO `user` VALUES ('3', 'test13@qq.com', '14e1b600b1fd579f47433b88e8d85291', 'test13', 'test13', null, '0', '2', '1555555', '1555555', null, '0', '0', '0', null, '0:0:0:0:0:0:0:1', 'de8859a2b56a39ae8e51783c74bb713e', '', '2016-07-11 11:44:10', '2016-08-25 09:41:56', '1', '0,1,44,');
INSERT INTO `user` VALUES ('4', 'test13user@qq.com', 'e10adc3949ba59abbe56e057f20f883e', 'yy', 'yy', null, '0', '3', null, '15501233770', 'u', '1', '1', '1', 'uu', '192.168.88.177', 'abca26570541bb6229f42b81343ccfd1', '', '2016-07-05 15:48:19', '2016-07-15 18:04:17', '0', null);
INSERT INTO `user` VALUES ('5', 'test13new@qq.com', '14e1b600b1fd579f47433b88e8d85291', 'ha', 'ha', null, '0', '2', '1555432', '1555432', null, '0', '0', '0', null, '0:0:0:0:0:0:0:1', '28c624e78077fe43f330ce8e9a3b05ba', '', '2016-07-22 11:10:53', '2016-08-25 09:43:01', '1', '0,1,732,');
INSERT INTO `user` VALUES ('6', 'test14@qq.com', '14e1b600b1fd579f47433b88e8d85291', 'test', 'test', null, '0', '2', '123456', '123456', null, '0', '0', '0', null, '', '', '', '2016-08-25 09:44:30', '2016-08-25 09:44:30', '732', '0,1,732,733,');
