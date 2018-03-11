/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : icehockey_dbv3

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-03-11 12:28:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT COMMENT '类别编号',
  `categoryName` varchar(255) DEFAULT 'aaa' COMMENT '类别名称',
  `remark` varchar(255) DEFAULT 'bbb' COMMENT '备注',
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=903 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('-1', '没有修改过类别', 'bbb');
INSERT INTO `category` VALUES ('901', '球员', 'QY');
INSERT INTO `category` VALUES ('902', '守门员', 'SM');

-- ----------------------------
-- Table structure for `categorylog`
-- ----------------------------
DROP TABLE IF EXISTS `categorylog`;
CREATE TABLE `categorylog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志编号',
  `roleId` int(11) DEFAULT '-1' COMMENT '角色编号',
  `coachId` int(11) DEFAULT '-1' COMMENT '教练员编号',
  `judgerId` int(11) DEFAULT '-1' COMMENT '裁判员编号',
  `playerId` int(11) DEFAULT '-1' COMMENT '运动员编号',
  `categoryId` int(11) DEFAULT '-1' COMMENT '类别编号',
  `changeDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '修改时间',
  `isUsing` bit(1) DEFAULT NULL COMMENT '是否有效',
  `remark` varchar(255) DEFAULT 'aaa' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categorylog
-- ----------------------------

-- ----------------------------
-- Table structure for `check`
-- ----------------------------
DROP TABLE IF EXISTS `check`;
CREATE TABLE `check` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `flag` int(11) DEFAULT NULL COMMENT '标志位，区分是审核的哪个实体1表示冰场，2表示俱乐部，3表示校队，4表示赛事',
  `checkReslut` bit(1) DEFAULT b'0' COMMENT '审核结果1表示通过，0表示驳回',
  `reason` varchar(255) DEFAULT '资料不够齐全' COMMENT '驳回原因',
  `checkDate` datetime DEFAULT '1900-01-01 00:00:00' COMMENT '审核时间',
  `userId` int(11) DEFAULT NULL COMMENT '审核人编号',
  `remark` varchar(255) DEFAULT '审核' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of check
-- ----------------------------

-- ----------------------------
-- Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `cityId` int(11) NOT NULL AUTO_INCREMENT,
  `cityName` varchar(50) DEFAULT NULL,
  `pId` int(11) DEFAULT NULL COMMENT '所属省份',
  `cId` int(11) NOT NULL,
  `countryId` int(11) DEFAULT '8' COMMENT '所属国家ID',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cityId`)
) ENGINE=InnoDB AUTO_INCREMENT=392 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '北京市', '1', '1', '8', null);
INSERT INTO `city` VALUES ('2', '天津市', '2', '1', '8', null);
INSERT INTO `city` VALUES ('3', '上海市', '3', '1', '8', null);
INSERT INTO `city` VALUES ('4', '重庆市', '4', '1', '8', null);
INSERT INTO `city` VALUES ('5', '石家庄市', '5', '1', '8', null);
INSERT INTO `city` VALUES ('6', '唐山市', '5', '2', '8', null);
INSERT INTO `city` VALUES ('7', '秦皇岛市', '5', '3', '8', null);
INSERT INTO `city` VALUES ('8', '邯郸市', '5', '4', '8', null);
INSERT INTO `city` VALUES ('9', '邢台市', '5', '5', '8', null);
INSERT INTO `city` VALUES ('10', '保定市', '5', '6', '8', null);
INSERT INTO `city` VALUES ('11', '张家口市', '5', '7', '8', null);
INSERT INTO `city` VALUES ('12', '承德市', '5', '8', '8', null);
INSERT INTO `city` VALUES ('13', '沧州市', '5', '9', '8', null);
INSERT INTO `city` VALUES ('14', '廊坊市', '5', '10', '8', null);
INSERT INTO `city` VALUES ('15', '衡水市', '5', '11', '8', null);
INSERT INTO `city` VALUES ('16', '太原市', '6', '1', '8', null);
INSERT INTO `city` VALUES ('17', '大同市', '6', '2', '8', null);
INSERT INTO `city` VALUES ('18', '阳泉市', '6', '3', '8', null);
INSERT INTO `city` VALUES ('19', '长治市', '6', '4', '8', null);
INSERT INTO `city` VALUES ('20', '晋城市', '6', '5', '8', null);
INSERT INTO `city` VALUES ('21', '朔州市', '6', '6', '8', null);
INSERT INTO `city` VALUES ('22', '晋中市', '6', '7', '8', null);
INSERT INTO `city` VALUES ('23', '运城市', '6', '8', '8', null);
INSERT INTO `city` VALUES ('24', '忻州市', '6', '9', '8', null);
INSERT INTO `city` VALUES ('25', '临汾市', '6', '10', '8', null);
INSERT INTO `city` VALUES ('26', '吕梁市', '6', '11', '8', null);
INSERT INTO `city` VALUES ('27', '台北市', '7', '1', '8', null);
INSERT INTO `city` VALUES ('28', '高雄市', '7', '2', '8', null);
INSERT INTO `city` VALUES ('29', '基隆市', '7', '3', '8', null);
INSERT INTO `city` VALUES ('30', '台中市', '7', '4', '8', null);
INSERT INTO `city` VALUES ('31', '台南市', '7', '5', '8', null);
INSERT INTO `city` VALUES ('32', '新竹市', '7', '6', '8', null);
INSERT INTO `city` VALUES ('33', '嘉义市', '7', '7', '8', null);
INSERT INTO `city` VALUES ('34', '台北县', '7', '8', '8', null);
INSERT INTO `city` VALUES ('35', '宜兰县', '7', '9', '8', null);
INSERT INTO `city` VALUES ('36', '桃园县', '7', '10', '8', null);
INSERT INTO `city` VALUES ('37', '新竹县', '7', '11', '8', null);
INSERT INTO `city` VALUES ('38', '苗栗县', '7', '12', '8', null);
INSERT INTO `city` VALUES ('39', '台中县', '7', '13', '8', null);
INSERT INTO `city` VALUES ('40', '彰化县', '7', '14', '8', null);
INSERT INTO `city` VALUES ('41', '南投县', '7', '15', '8', null);
INSERT INTO `city` VALUES ('42', '云林县', '7', '16', '8', null);
INSERT INTO `city` VALUES ('43', '嘉义县', '7', '17', '8', null);
INSERT INTO `city` VALUES ('44', '台南县', '7', '18', '8', null);
INSERT INTO `city` VALUES ('45', '高雄县', '7', '19', '8', null);
INSERT INTO `city` VALUES ('46', '屏东县', '7', '20', '8', null);
INSERT INTO `city` VALUES ('47', '澎湖县', '7', '21', '8', null);
INSERT INTO `city` VALUES ('48', '台东县', '7', '22', '8', null);
INSERT INTO `city` VALUES ('49', '花莲县', '7', '23', '8', null);
INSERT INTO `city` VALUES ('50', '沈阳市', '8', '1', '8', null);
INSERT INTO `city` VALUES ('51', '大连市', '8', '2', '8', null);
INSERT INTO `city` VALUES ('52', '鞍山市', '8', '3', '8', null);
INSERT INTO `city` VALUES ('53', '抚顺市', '8', '4', '8', null);
INSERT INTO `city` VALUES ('54', '本溪市', '8', '5', '8', null);
INSERT INTO `city` VALUES ('55', '丹东市', '8', '6', '8', null);
INSERT INTO `city` VALUES ('56', '锦州市', '8', '7', '8', null);
INSERT INTO `city` VALUES ('57', '营口市', '8', '8', '8', null);
INSERT INTO `city` VALUES ('58', '阜新市', '8', '9', '8', null);
INSERT INTO `city` VALUES ('59', '辽阳市', '8', '10', '8', null);
INSERT INTO `city` VALUES ('60', '盘锦市', '8', '11', '8', null);
INSERT INTO `city` VALUES ('61', '铁岭市', '8', '12', '8', null);
INSERT INTO `city` VALUES ('62', '朝阳市', '8', '13', '8', null);
INSERT INTO `city` VALUES ('63', '葫芦岛市', '8', '14', '8', null);
INSERT INTO `city` VALUES ('64', '长春市', '9', '1', '8', null);
INSERT INTO `city` VALUES ('65', '吉林市', '9', '2', '8', null);
INSERT INTO `city` VALUES ('66', '四平市', '9', '3', '8', null);
INSERT INTO `city` VALUES ('67', '辽源市', '9', '4', '8', null);
INSERT INTO `city` VALUES ('68', '通化市', '9', '5', '8', null);
INSERT INTO `city` VALUES ('69', '白山市', '9', '6', '8', null);
INSERT INTO `city` VALUES ('70', '松原市', '9', '7', '8', null);
INSERT INTO `city` VALUES ('71', '白城市', '9', '8', '8', null);
INSERT INTO `city` VALUES ('72', '延边朝鲜族自治州', '9', '9', '8', null);
INSERT INTO `city` VALUES ('73', '哈尔滨市', '10', '1', '8', null);
INSERT INTO `city` VALUES ('74', '齐齐哈尔市', '10', '2', '8', null);
INSERT INTO `city` VALUES ('75', '鹤 岗 市', '10', '3', '8', null);
INSERT INTO `city` VALUES ('76', '双鸭山市', '10', '4', '8', null);
INSERT INTO `city` VALUES ('77', '鸡 西 市', '10', '5', '8', null);
INSERT INTO `city` VALUES ('78', '大 庆 市', '10', '6', '8', null);
INSERT INTO `city` VALUES ('79', '伊 春 市', '10', '7', '8', null);
INSERT INTO `city` VALUES ('80', '牡丹江市', '10', '8', '8', null);
INSERT INTO `city` VALUES ('81', '佳木斯市', '10', '9', '8', null);
INSERT INTO `city` VALUES ('82', '七台河市', '10', '10', '8', null);
INSERT INTO `city` VALUES ('83', '黑 河 市', '10', '11', '8', null);
INSERT INTO `city` VALUES ('84', '绥 化 市', '10', '12', '8', null);
INSERT INTO `city` VALUES ('85', '大兴安岭地区', '10', '13', '8', null);
INSERT INTO `city` VALUES ('86', '南京市', '11', '1', '8', null);
INSERT INTO `city` VALUES ('87', '无锡市', '11', '2', '8', null);
INSERT INTO `city` VALUES ('88', '徐州市', '11', '3', '8', null);
INSERT INTO `city` VALUES ('89', '常州市', '11', '4', '8', null);
INSERT INTO `city` VALUES ('90', '苏州市', '11', '5', '8', null);
INSERT INTO `city` VALUES ('91', '南通市', '11', '6', '8', null);
INSERT INTO `city` VALUES ('92', '连云港市', '11', '7', '8', null);
INSERT INTO `city` VALUES ('93', '淮安市', '11', '8', '8', null);
INSERT INTO `city` VALUES ('94', '盐城市', '11', '9', '8', null);
INSERT INTO `city` VALUES ('95', '扬州市', '11', '10', '8', null);
INSERT INTO `city` VALUES ('96', '镇江市', '11', '11', '8', null);
INSERT INTO `city` VALUES ('97', '泰州市', '11', '12', '8', null);
INSERT INTO `city` VALUES ('98', '宿迁市', '11', '13', '8', null);
INSERT INTO `city` VALUES ('99', '杭州市', '12', '1', '8', null);
INSERT INTO `city` VALUES ('100', '宁波市', '12', '2', '8', null);
INSERT INTO `city` VALUES ('101', '温州市', '12', '3', '8', null);
INSERT INTO `city` VALUES ('102', '嘉兴市', '12', '4', '8', null);
INSERT INTO `city` VALUES ('103', '湖州市', '12', '5', '8', null);
INSERT INTO `city` VALUES ('104', '绍兴市', '12', '6', '8', null);
INSERT INTO `city` VALUES ('105', '金华市', '12', '7', '8', null);
INSERT INTO `city` VALUES ('106', '衢州市', '12', '8', '8', null);
INSERT INTO `city` VALUES ('107', '舟山市', '12', '9', '8', null);
INSERT INTO `city` VALUES ('108', '台州市', '12', '10', '8', null);
INSERT INTO `city` VALUES ('109', '丽水市', '12', '11', '8', null);
INSERT INTO `city` VALUES ('110', '合肥市', '13', '1', '8', null);
INSERT INTO `city` VALUES ('111', '芜湖市', '13', '2', '8', null);
INSERT INTO `city` VALUES ('112', '蚌埠市', '13', '3', '8', null);
INSERT INTO `city` VALUES ('113', '淮南市', '13', '4', '8', null);
INSERT INTO `city` VALUES ('114', '马鞍山市', '13', '5', '8', null);
INSERT INTO `city` VALUES ('115', '淮北市', '13', '6', '8', null);
INSERT INTO `city` VALUES ('116', '铜陵市', '13', '7', '8', null);
INSERT INTO `city` VALUES ('117', '安庆市', '13', '8', '8', null);
INSERT INTO `city` VALUES ('118', '黄山市', '13', '9', '8', null);
INSERT INTO `city` VALUES ('119', '滁州市', '13', '10', '8', null);
INSERT INTO `city` VALUES ('120', '阜阳市', '13', '11', '8', null);
INSERT INTO `city` VALUES ('121', '宿州市', '13', '12', '8', null);
INSERT INTO `city` VALUES ('122', '巢湖市', '13', '13', '8', null);
INSERT INTO `city` VALUES ('123', '六安市', '13', '14', '8', null);
INSERT INTO `city` VALUES ('124', '亳州市', '13', '15', '8', null);
INSERT INTO `city` VALUES ('125', '池州市', '13', '16', '8', null);
INSERT INTO `city` VALUES ('126', '宣城市', '13', '17', '8', null);
INSERT INTO `city` VALUES ('127', '福州市', '14', '1', '8', null);
INSERT INTO `city` VALUES ('128', '厦门市', '14', '2', '8', null);
INSERT INTO `city` VALUES ('129', '莆田市', '14', '3', '8', null);
INSERT INTO `city` VALUES ('130', '三明市', '14', '4', '8', null);
INSERT INTO `city` VALUES ('131', '泉州市', '14', '5', '8', null);
INSERT INTO `city` VALUES ('132', '漳州市', '14', '6', '8', null);
INSERT INTO `city` VALUES ('133', '南平市', '14', '7', '8', null);
INSERT INTO `city` VALUES ('134', '龙岩市', '14', '8', '8', null);
INSERT INTO `city` VALUES ('135', '宁德市', '14', '9', '8', null);
INSERT INTO `city` VALUES ('136', '南昌市', '15', '1', '8', null);
INSERT INTO `city` VALUES ('137', '景德镇市', '15', '2', '8', null);
INSERT INTO `city` VALUES ('138', '萍乡市', '15', '3', '8', null);
INSERT INTO `city` VALUES ('139', '九江市', '15', '4', '8', null);
INSERT INTO `city` VALUES ('140', '新余市', '15', '5', '8', null);
INSERT INTO `city` VALUES ('141', '鹰潭市', '15', '6', '8', null);
INSERT INTO `city` VALUES ('142', '赣州市', '15', '7', '8', null);
INSERT INTO `city` VALUES ('143', '吉安市', '15', '8', '8', null);
INSERT INTO `city` VALUES ('144', '宜春市', '15', '9', '8', null);
INSERT INTO `city` VALUES ('145', '抚州市', '15', '10', '8', null);
INSERT INTO `city` VALUES ('146', '上饶市', '15', '11', '8', null);
INSERT INTO `city` VALUES ('147', '济南市', '16', '1', '8', null);
INSERT INTO `city` VALUES ('148', '青岛市', '16', '2', '8', null);
INSERT INTO `city` VALUES ('149', '淄博市', '16', '3', '8', null);
INSERT INTO `city` VALUES ('150', '枣庄市', '16', '4', '8', null);
INSERT INTO `city` VALUES ('151', '东营市', '16', '5', '8', null);
INSERT INTO `city` VALUES ('152', '烟台市', '16', '6', '8', null);
INSERT INTO `city` VALUES ('153', '潍坊市', '16', '7', '8', null);
INSERT INTO `city` VALUES ('154', '济宁市', '16', '8', '8', null);
INSERT INTO `city` VALUES ('155', '泰安市', '16', '9', '8', null);
INSERT INTO `city` VALUES ('156', '威海市', '16', '10', '8', null);
INSERT INTO `city` VALUES ('157', '日照市', '16', '11', '8', null);
INSERT INTO `city` VALUES ('158', '莱芜市', '16', '12', '8', null);
INSERT INTO `city` VALUES ('159', '临沂市', '16', '13', '8', null);
INSERT INTO `city` VALUES ('160', '德州市', '16', '14', '8', null);
INSERT INTO `city` VALUES ('161', '聊城市', '16', '15', '8', null);
INSERT INTO `city` VALUES ('162', '滨州市', '16', '16', '8', null);
INSERT INTO `city` VALUES ('163', '菏泽市', '16', '17', '8', null);
INSERT INTO `city` VALUES ('164', '郑州市', '17', '1', '8', null);
INSERT INTO `city` VALUES ('165', '开封市', '17', '2', '8', null);
INSERT INTO `city` VALUES ('166', '洛阳市', '17', '3', '8', null);
INSERT INTO `city` VALUES ('167', '平顶山市', '17', '4', '8', null);
INSERT INTO `city` VALUES ('168', '安阳市', '17', '5', '8', null);
INSERT INTO `city` VALUES ('169', '鹤壁市', '17', '6', '8', null);
INSERT INTO `city` VALUES ('170', '新乡市', '17', '7', '8', null);
INSERT INTO `city` VALUES ('171', '焦作市', '17', '8', '8', null);
INSERT INTO `city` VALUES ('172', '濮阳市', '17', '9', '8', null);
INSERT INTO `city` VALUES ('173', '许昌市', '17', '10', '8', null);
INSERT INTO `city` VALUES ('174', '漯河市', '17', '11', '8', null);
INSERT INTO `city` VALUES ('175', '三门峡市', '17', '12', '8', null);
INSERT INTO `city` VALUES ('176', '南阳市', '17', '13', '8', null);
INSERT INTO `city` VALUES ('177', '商丘市', '17', '14', '8', null);
INSERT INTO `city` VALUES ('178', '信阳市', '17', '15', '8', null);
INSERT INTO `city` VALUES ('179', '周口市', '17', '16', '8', null);
INSERT INTO `city` VALUES ('180', '驻马店市', '17', '17', '8', null);
INSERT INTO `city` VALUES ('181', '济源市', '17', '18', '8', null);
INSERT INTO `city` VALUES ('182', '武汉市', '18', '1', '8', null);
INSERT INTO `city` VALUES ('183', '黄石市', '18', '2', '8', null);
INSERT INTO `city` VALUES ('184', '十堰市', '18', '3', '8', null);
INSERT INTO `city` VALUES ('185', '荆州市', '18', '4', '8', null);
INSERT INTO `city` VALUES ('186', '宜昌市', '18', '5', '8', null);
INSERT INTO `city` VALUES ('187', '襄樊市', '18', '6', '8', null);
INSERT INTO `city` VALUES ('188', '鄂州市', '18', '7', '8', null);
INSERT INTO `city` VALUES ('189', '荆门市', '18', '8', '8', null);
INSERT INTO `city` VALUES ('190', '孝感市', '18', '9', '8', null);
INSERT INTO `city` VALUES ('191', '黄冈市', '18', '10', '8', null);
INSERT INTO `city` VALUES ('192', '咸宁市', '18', '11', '8', null);
INSERT INTO `city` VALUES ('193', '随州市', '18', '12', '8', null);
INSERT INTO `city` VALUES ('194', '仙桃市', '18', '13', '8', null);
INSERT INTO `city` VALUES ('195', '天门市', '18', '14', '8', null);
INSERT INTO `city` VALUES ('196', '潜江市', '18', '15', '8', null);
INSERT INTO `city` VALUES ('197', '神农架林区', '18', '16', '8', null);
INSERT INTO `city` VALUES ('198', '恩施土家族苗族自治州', '18', '17', '8', null);
INSERT INTO `city` VALUES ('199', '长沙市', '19', '1', '8', null);
INSERT INTO `city` VALUES ('200', '株洲市', '19', '2', '8', null);
INSERT INTO `city` VALUES ('201', '湘潭市', '19', '3', '8', null);
INSERT INTO `city` VALUES ('202', '衡阳市', '19', '4', '8', null);
INSERT INTO `city` VALUES ('203', '邵阳市', '19', '5', '8', null);
INSERT INTO `city` VALUES ('204', '岳阳市', '19', '6', '8', null);
INSERT INTO `city` VALUES ('205', '常德市', '19', '7', '8', null);
INSERT INTO `city` VALUES ('206', '张家界市', '19', '8', '8', null);
INSERT INTO `city` VALUES ('207', '益阳市', '19', '9', '8', null);
INSERT INTO `city` VALUES ('208', '郴州市', '19', '10', '8', null);
INSERT INTO `city` VALUES ('209', '永州市', '19', '11', '8', null);
INSERT INTO `city` VALUES ('210', '怀化市', '19', '12', '8', null);
INSERT INTO `city` VALUES ('211', '娄底市', '19', '13', '8', null);
INSERT INTO `city` VALUES ('212', '湘西土家族苗族自治州', '19', '14', '8', null);
INSERT INTO `city` VALUES ('213', '广州市', '20', '1', '8', null);
INSERT INTO `city` VALUES ('214', '深圳市', '20', '2', '8', null);
INSERT INTO `city` VALUES ('215', '珠海市', '20', '3', '8', null);
INSERT INTO `city` VALUES ('216', '汕头市', '20', '4', '8', null);
INSERT INTO `city` VALUES ('217', '韶关市', '20', '5', '8', null);
INSERT INTO `city` VALUES ('218', '佛山市', '20', '6', '8', null);
INSERT INTO `city` VALUES ('219', '江门市', '20', '7', '8', null);
INSERT INTO `city` VALUES ('220', '湛江市', '20', '8', '8', null);
INSERT INTO `city` VALUES ('221', '茂名市', '20', '9', '8', null);
INSERT INTO `city` VALUES ('222', '肇庆市', '20', '10', '8', null);
INSERT INTO `city` VALUES ('223', '惠州市', '20', '11', '8', null);
INSERT INTO `city` VALUES ('224', '梅州市', '20', '12', '8', null);
INSERT INTO `city` VALUES ('225', '汕尾市', '20', '13', '8', null);
INSERT INTO `city` VALUES ('226', '河源市', '20', '14', '8', null);
INSERT INTO `city` VALUES ('227', '阳江市', '20', '15', '8', null);
INSERT INTO `city` VALUES ('228', '清远市', '20', '16', '8', null);
INSERT INTO `city` VALUES ('229', '东莞市', '20', '17', '8', null);
INSERT INTO `city` VALUES ('230', '中山市', '20', '18', '8', null);
INSERT INTO `city` VALUES ('231', '潮州市', '20', '19', '8', null);
INSERT INTO `city` VALUES ('232', '揭阳市', '20', '20', '8', null);
INSERT INTO `city` VALUES ('233', '云浮市', '20', '21', '8', null);
INSERT INTO `city` VALUES ('234', '兰州市', '21', '1', '8', null);
INSERT INTO `city` VALUES ('235', '金昌市', '21', '2', '8', null);
INSERT INTO `city` VALUES ('236', '白银市', '21', '3', '8', null);
INSERT INTO `city` VALUES ('237', '天水市', '21', '4', '8', null);
INSERT INTO `city` VALUES ('238', '嘉峪关市', '21', '5', '8', null);
INSERT INTO `city` VALUES ('239', '武威市', '21', '6', '8', null);
INSERT INTO `city` VALUES ('240', '张掖市', '21', '7', '8', null);
INSERT INTO `city` VALUES ('241', '平凉市', '21', '8', '8', null);
INSERT INTO `city` VALUES ('242', '酒泉市', '21', '9', '8', null);
INSERT INTO `city` VALUES ('243', '庆阳市', '21', '10', '8', null);
INSERT INTO `city` VALUES ('244', '定西市', '21', '11', '8', null);
INSERT INTO `city` VALUES ('245', '陇南市', '21', '12', '8', null);
INSERT INTO `city` VALUES ('246', '临夏回族自治州', '21', '13', '8', null);
INSERT INTO `city` VALUES ('247', '甘南藏族自治州', '21', '14', '8', null);
INSERT INTO `city` VALUES ('248', '成都市', '22', '1', '8', null);
INSERT INTO `city` VALUES ('249', '自贡市', '22', '2', '8', null);
INSERT INTO `city` VALUES ('250', '攀枝花市', '22', '3', '8', null);
INSERT INTO `city` VALUES ('251', '泸州市', '22', '4', '8', null);
INSERT INTO `city` VALUES ('252', '德阳市', '22', '5', '8', null);
INSERT INTO `city` VALUES ('253', '绵阳市', '22', '6', '8', null);
INSERT INTO `city` VALUES ('254', '广元市', '22', '7', '8', null);
INSERT INTO `city` VALUES ('255', '遂宁市', '22', '8', '8', null);
INSERT INTO `city` VALUES ('256', '内江市', '22', '9', '8', null);
INSERT INTO `city` VALUES ('257', '乐山市', '22', '10', '8', null);
INSERT INTO `city` VALUES ('258', '南充市', '22', '11', '8', null);
INSERT INTO `city` VALUES ('259', '眉山市', '22', '12', '8', null);
INSERT INTO `city` VALUES ('260', '宜宾市', '22', '13', '8', null);
INSERT INTO `city` VALUES ('261', '广安市', '22', '14', '8', null);
INSERT INTO `city` VALUES ('262', '达州市', '22', '15', '8', null);
INSERT INTO `city` VALUES ('263', '雅安市', '22', '16', '8', null);
INSERT INTO `city` VALUES ('264', '巴中市', '22', '17', '8', null);
INSERT INTO `city` VALUES ('265', '资阳市', '22', '18', '8', null);
INSERT INTO `city` VALUES ('266', '阿坝藏族羌族自治州', '22', '19', '8', null);
INSERT INTO `city` VALUES ('267', '甘孜藏族自治州', '22', '20', '8', null);
INSERT INTO `city` VALUES ('268', '凉山彝族自治州', '22', '21', '8', null);
INSERT INTO `city` VALUES ('269', '贵阳市', '23', '1', '8', null);
INSERT INTO `city` VALUES ('270', '六盘水市', '23', '2', '8', null);
INSERT INTO `city` VALUES ('271', '遵义市', '23', '3', '8', null);
INSERT INTO `city` VALUES ('272', '安顺市', '23', '4', '8', null);
INSERT INTO `city` VALUES ('273', '铜仁地区', '23', '5', '8', null);
INSERT INTO `city` VALUES ('274', '毕节地区', '23', '6', '8', null);
INSERT INTO `city` VALUES ('275', '黔西南布依族苗族自治州', '23', '7', '8', null);
INSERT INTO `city` VALUES ('276', '黔东南苗族侗族自治州', '23', '8', '8', null);
INSERT INTO `city` VALUES ('277', '黔南布依族苗族自治州', '23', '9', '8', null);
INSERT INTO `city` VALUES ('278', '海口市', '24', '1', '8', null);
INSERT INTO `city` VALUES ('279', '三亚市', '24', '2', '8', null);
INSERT INTO `city` VALUES ('280', '五指山市', '24', '3', '8', null);
INSERT INTO `city` VALUES ('281', '琼海市', '24', '4', '8', null);
INSERT INTO `city` VALUES ('282', '儋州市', '24', '5', '8', null);
INSERT INTO `city` VALUES ('283', '文昌市', '24', '6', '8', null);
INSERT INTO `city` VALUES ('284', '万宁市', '24', '7', '8', null);
INSERT INTO `city` VALUES ('285', '东方市', '24', '8', '8', null);
INSERT INTO `city` VALUES ('286', '澄迈县', '24', '9', '8', null);
INSERT INTO `city` VALUES ('287', '定安县', '24', '10', '8', null);
INSERT INTO `city` VALUES ('288', '屯昌县', '24', '11', '8', null);
INSERT INTO `city` VALUES ('289', '临高县', '24', '12', '8', null);
INSERT INTO `city` VALUES ('290', '白沙黎族自治县', '24', '13', '8', null);
INSERT INTO `city` VALUES ('291', '昌江黎族自治县', '24', '14', '8', null);
INSERT INTO `city` VALUES ('292', '乐东黎族自治县', '24', '15', '8', null);
INSERT INTO `city` VALUES ('293', '陵水黎族自治县', '24', '16', '8', null);
INSERT INTO `city` VALUES ('294', '保亭黎族苗族自治县', '24', '17', '8', null);
INSERT INTO `city` VALUES ('295', '琼中黎族苗族自治县', '24', '18', '8', null);
INSERT INTO `city` VALUES ('296', '昆明市', '25', '1', '8', null);
INSERT INTO `city` VALUES ('297', '曲靖市', '25', '2', '8', null);
INSERT INTO `city` VALUES ('298', '玉溪市', '25', '3', '8', null);
INSERT INTO `city` VALUES ('299', '保山市', '25', '4', '8', null);
INSERT INTO `city` VALUES ('300', '昭通市', '25', '5', '8', null);
INSERT INTO `city` VALUES ('301', '丽江市', '25', '6', '8', null);
INSERT INTO `city` VALUES ('302', '思茅市', '25', '7', '8', null);
INSERT INTO `city` VALUES ('303', '临沧市', '25', '8', '8', null);
INSERT INTO `city` VALUES ('304', '文山壮族苗族自治州', '25', '9', '8', null);
INSERT INTO `city` VALUES ('305', '红河哈尼族彝族自治州', '25', '10', '8', null);
INSERT INTO `city` VALUES ('306', '西双版纳傣族自治州', '25', '11', '8', null);
INSERT INTO `city` VALUES ('307', '楚雄彝族自治州', '25', '12', '8', null);
INSERT INTO `city` VALUES ('308', '大理白族自治州', '25', '13', '8', null);
INSERT INTO `city` VALUES ('309', '德宏傣族景颇族自治州', '25', '14', '8', null);
INSERT INTO `city` VALUES ('310', '怒江傈傈族自治州', '25', '15', '8', null);
INSERT INTO `city` VALUES ('311', '迪庆藏族自治州', '25', '16', '8', null);
INSERT INTO `city` VALUES ('312', '西宁市', '26', '1', '8', null);
INSERT INTO `city` VALUES ('313', '海东地区', '26', '2', '8', null);
INSERT INTO `city` VALUES ('314', '海北藏族自治州', '26', '3', '8', null);
INSERT INTO `city` VALUES ('315', '黄南藏族自治州', '26', '4', '8', null);
INSERT INTO `city` VALUES ('316', '海南藏族自治州', '26', '5', '8', null);
INSERT INTO `city` VALUES ('317', '果洛藏族自治州', '26', '6', '8', null);
INSERT INTO `city` VALUES ('318', '玉树藏族自治州', '26', '7', '8', null);
INSERT INTO `city` VALUES ('319', '海西蒙古族藏族自治州', '26', '8', '8', null);
INSERT INTO `city` VALUES ('320', '西安市', '27', '1', '8', null);
INSERT INTO `city` VALUES ('321', '铜川市', '27', '2', '8', null);
INSERT INTO `city` VALUES ('322', '宝鸡市', '27', '3', '8', null);
INSERT INTO `city` VALUES ('323', '咸阳市', '27', '4', '8', null);
INSERT INTO `city` VALUES ('324', '渭南市', '27', '5', '8', null);
INSERT INTO `city` VALUES ('325', '延安市', '27', '6', '8', null);
INSERT INTO `city` VALUES ('326', '汉中市', '27', '7', '8', null);
INSERT INTO `city` VALUES ('327', '榆林市', '27', '8', '8', null);
INSERT INTO `city` VALUES ('328', '安康市', '27', '9', '8', null);
INSERT INTO `city` VALUES ('329', '商洛市', '27', '10', '8', null);
INSERT INTO `city` VALUES ('330', '南宁市', '28', '1', '8', null);
INSERT INTO `city` VALUES ('331', '柳州市', '28', '2', '8', null);
INSERT INTO `city` VALUES ('332', '桂林市', '28', '3', '8', null);
INSERT INTO `city` VALUES ('333', '梧州市', '28', '4', '8', null);
INSERT INTO `city` VALUES ('334', '北海市', '28', '5', '8', null);
INSERT INTO `city` VALUES ('335', '防城港市', '28', '6', '8', null);
INSERT INTO `city` VALUES ('336', '钦州市', '28', '7', '8', null);
INSERT INTO `city` VALUES ('337', '贵港市', '28', '8', '8', null);
INSERT INTO `city` VALUES ('338', '玉林市', '28', '9', '8', null);
INSERT INTO `city` VALUES ('339', '百色市', '28', '10', '8', null);
INSERT INTO `city` VALUES ('340', '贺州市', '28', '11', '8', null);
INSERT INTO `city` VALUES ('341', '河池市', '28', '12', '8', null);
INSERT INTO `city` VALUES ('342', '来宾市', '28', '13', '8', null);
INSERT INTO `city` VALUES ('343', '崇左市', '28', '14', '8', null);
INSERT INTO `city` VALUES ('344', '拉萨市', '29', '1', '8', null);
INSERT INTO `city` VALUES ('345', '那曲地区', '29', '2', '8', null);
INSERT INTO `city` VALUES ('346', '昌都地区', '29', '3', '8', null);
INSERT INTO `city` VALUES ('347', '山南地区', '29', '4', '8', null);
INSERT INTO `city` VALUES ('348', '日喀则地区', '29', '5', '8', null);
INSERT INTO `city` VALUES ('349', '阿里地区', '29', '6', '8', null);
INSERT INTO `city` VALUES ('350', '林芝地区', '29', '7', '8', null);
INSERT INTO `city` VALUES ('351', '银川市', '30', '1', '8', null);
INSERT INTO `city` VALUES ('352', '石嘴山市', '30', '2', '8', null);
INSERT INTO `city` VALUES ('353', '吴忠市', '30', '3', '8', null);
INSERT INTO `city` VALUES ('354', '固原市', '30', '4', '8', null);
INSERT INTO `city` VALUES ('355', '中卫市', '30', '5', '8', null);
INSERT INTO `city` VALUES ('356', '乌鲁木齐市', '31', '1', '8', null);
INSERT INTO `city` VALUES ('357', '克拉玛依市', '31', '2', '8', null);
INSERT INTO `city` VALUES ('358', '石河子市　', '31', '3', '8', null);
INSERT INTO `city` VALUES ('359', '阿拉尔市', '31', '4', '8', null);
INSERT INTO `city` VALUES ('360', '图木舒克市', '31', '5', '8', null);
INSERT INTO `city` VALUES ('361', '五家渠市', '31', '6', '8', null);
INSERT INTO `city` VALUES ('362', '吐鲁番市', '31', '7', '8', null);
INSERT INTO `city` VALUES ('363', '阿克苏市', '31', '8', '8', null);
INSERT INTO `city` VALUES ('364', '喀什市', '31', '9', '8', null);
INSERT INTO `city` VALUES ('365', '哈密市', '31', '10', '8', null);
INSERT INTO `city` VALUES ('366', '和田市', '31', '11', '8', null);
INSERT INTO `city` VALUES ('367', '阿图什市', '31', '12', '8', null);
INSERT INTO `city` VALUES ('368', '库尔勒市', '31', '13', '8', null);
INSERT INTO `city` VALUES ('369', '昌吉市　', '31', '14', '8', null);
INSERT INTO `city` VALUES ('370', '阜康市', '31', '15', '8', null);
INSERT INTO `city` VALUES ('371', '米泉市', '31', '16', '8', null);
INSERT INTO `city` VALUES ('372', '博乐市', '31', '17', '8', null);
INSERT INTO `city` VALUES ('373', '伊宁市', '31', '18', '8', null);
INSERT INTO `city` VALUES ('374', '奎屯市', '31', '19', '8', null);
INSERT INTO `city` VALUES ('375', '塔城市', '31', '20', '8', null);
INSERT INTO `city` VALUES ('376', '乌苏市', '31', '21', '8', null);
INSERT INTO `city` VALUES ('377', '阿勒泰市', '31', '22', '8', null);
INSERT INTO `city` VALUES ('378', '呼和浩特市', '32', '1', '8', null);
INSERT INTO `city` VALUES ('379', '包头市', '32', '2', '8', null);
INSERT INTO `city` VALUES ('380', '乌海市', '32', '3', '8', null);
INSERT INTO `city` VALUES ('381', '赤峰市', '32', '4', '8', null);
INSERT INTO `city` VALUES ('382', '通辽市', '32', '5', '8', null);
INSERT INTO `city` VALUES ('383', '鄂尔多斯市', '32', '6', '8', null);
INSERT INTO `city` VALUES ('384', '呼伦贝尔市', '32', '7', '8', null);
INSERT INTO `city` VALUES ('385', '巴彦淖尔市', '32', '8', '8', null);
INSERT INTO `city` VALUES ('386', '乌兰察布市', '32', '9', '8', null);
INSERT INTO `city` VALUES ('387', '锡林郭勒盟', '32', '10', '8', null);
INSERT INTO `city` VALUES ('388', '兴安盟', '32', '11', '8', null);
INSERT INTO `city` VALUES ('389', '阿拉善盟', '32', '12', '8', null);
INSERT INTO `city` VALUES ('390', '澳门特别行政区', '33', '1', '8', null);
INSERT INTO `city` VALUES ('391', '香港特别行政区', '34', '1', '8', null);

-- ----------------------------
-- Table structure for `club`
-- ----------------------------
DROP TABLE IF EXISTS `club`;
CREATE TABLE `club` (
  `clubId` int(11) NOT NULL AUTO_INCREMENT COMMENT '俱乐部编号',
  `clubName` varchar(255) DEFAULT '俱乐部名称' COMMENT '俱乐部名称',
  `clubLogo` varchar(255) DEFAULT '../../img/part/timg.jpg' COMMENT '俱乐部LOGO',
  `organization` varchar(255) DEFAULT '官方组织' COMMENT '俱乐部所属机构',
  `address` varchar(255) DEFAULT '北京市丰台区' COMMENT '官方地址',
  `buildTime` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '成立时间',
  `countryId` int(11) DEFAULT '8' COMMENT '国籍编号',
  `cityId` int(11) DEFAULT '2' COMMENT '城市编号',
  `managerContent` varchar(255) DEFAULT '俱乐部通过多年实践和积累，制定了一套完善、系统的冰上教学体系，可以满足从初学者到专业方向发展的多元化需求。' COMMENT '经营内容',
  `email` varchar(255) DEFAULT 'lingdu@mail.com' COMMENT '电子邮件',
  `construction` varchar(255) DEFAULT '球队建设' COMMENT '球队建设',
  `provinceId` int(11) DEFAULT '-1' COMMENT '所在省编号',
  `remark` varchar(255) DEFAULT '俱乐部信息' COMMENT '俱乐部',
  `businessLicense` varchar(255) DEFAULT NULL,
  `idCardCopyFile` varchar(255) DEFAULT NULL,
  `checkId` int(11) DEFAULT '-1' COMMENT '审核编号，默认未-1 ，表示未审核',
  PRIMARY KEY (`clubId`)
) ENGINE=InnoDB AUTO_INCREMENT=6007 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of club
-- ----------------------------
INSERT INTO `club` VALUES ('6001', '烽火战舰俱乐部', '../../img/part4/i1.jpg', '官方', '北京市海淀区', '2000-01-01 00:00:00', '8', '1', 'eee', 'lingdu@mail.com', '中国·零度阳光冰球俱乐部系中国冰球协会资深成员，自2000年成立以来，深受广大冰球爱好者尤其是青少年的拥戴，目前俱乐部在北京、上海、郑州、深圳、成都等地共组建超过五十支的青少年冰球队, 在国内国际各类冰球比赛中屡获佳绩。零度阳光冰球俱乐部拥有众多的顶级教练员组成高水准的培训团队，同时每年举行的“冠军杯·国际冰球邀请赛”更是吸引了更多冰球队的参与，该赛事的组办不仅为广大冰球爱好者提供了一个良好的展示平台，更为冰球运动的普及发展起到了积极的推动作用。\r\n\r\n', '-1', '中国·零度阳光冰球俱乐部系中国冰球协会资深成员，自2000年成立以来，深受广大冰球爱好者尤其是青少年的拥戴，目前俱乐部在北京、上海、郑州、深圳、成都等地共组建超过五十支的青少年冰球队, 在国内国际各类冰球比赛中屡获佳绩。零度阳光冰球俱乐部拥有众多的顶级教练员组成高水准的培训团队，同时每年举行的“冠军杯·国际冰球邀请赛”更是吸引了更多冰球队的参与，该赛事的组办不仅为广大冰球爱好者提供了一个良好的展示平台，更为冰球运动的普及发展起到了积极的推动作用。\r\n\r\n', null, null, '-1');
INSERT INTO `club` VALUES ('6002', '霹雳小龙俱乐部', '../../img/part4/i1.jpg', '官方', 'ddd', '2000-01-01 00:00:00', '8', '2', 'eee', 'lingdu@mail.com', 'ggg', '-1', 'hhh', null, null, '-1');
INSERT INTO `club` VALUES ('6003', '零度阳光', '../../img/part/timg.jpg', '官方', '北京市丰台区', '2000-01-01 00:00:00', '8', '1', '俱乐部通过多年实践和积累，制定了一套完善、系统的冰上教学体系，可以满足从初学者到专业方向发展的多元化需求。', 'lingdu@mail.com', '中国·零度阳光冰球俱乐部系中国冰球协会资深成员，自2000年成立以来，深受广大冰球爱好者尤其是青少年的拥戴，目前俱乐部在北京、上海、郑州、深圳、成都等地共组建超过五十支的青少年冰球队, 在国内国际各类冰球比赛中屡获佳绩。零度阳光冰球俱乐部拥有众多的顶级教练员组成高水准的培训团队，同时每年举行的“冠军杯·国际冰球邀请赛”更是吸引了更多冰球队的参与，该赛事的组办不仅为广大冰球爱好者提供了一个良好的展示平台，更为冰球运动的普及发展起到了积极的推动作用。\r\n\r\n', '-1', 'hhh', null, null, '-1');
INSERT INTO `club` VALUES ('6004', '山东鲁能', '../../img/part/timg.jpg', '官方组织', '北京市丰台区', '2017-11-03 00:00:00', '8', '2', '俱乐部通过多年实践和积累，制定了一套完善、系统的冰上教学体系，可以满足从初学者到专业方向发展的多元化需求。', 'lingdu@mail.com', '               致力于从事冰球事业	 ', '-1', '俱乐部信息', null, null, '-1');
INSERT INTO `club` VALUES ('6005', '规格俱乐部', '../../img/part/timg.jpg', '官方组织', '北京市丰台区', '2017-11-02 00:00:00', '8', '2', '俱乐部通过多年实践和积累，制定了一套完善、系统的冰上教学体系，可以满足从初学者到专业方向发展的多元化需求。', 'lingdu@mail.com', '               		醇香燕麦片	 ', '-1', '俱乐部信息', null, null, '-1');
INSERT INTO `club` VALUES ('6006', '小狼狗', '../../img/part/timg.jpg', '官方组织', '北京市丰台区', '2012-12-06 00:00:00', '8', '2', '俱乐部通过多年实践和积累，制定了一套完善、系统的冰上教学体系，可以满足从初学者到专业方向发展的多元化需求。', 'lingdu@mail.com', '小狼狗是由青少年组成的', '-1', '俱乐部信息', null, null, '-1');

-- ----------------------------
-- Table structure for `coach`
-- ----------------------------
DROP TABLE IF EXISTS `coach`;
CREATE TABLE `coach` (
  `coachId` int(11) NOT NULL AUTO_INCREMENT COMMENT '教练员编号',
  `name` varchar(255) DEFAULT 'aaa' COMMENT '姓名',
  `sex` varchar(255) DEFAULT 'bbb' COMMENT '性别',
  `birthday` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '出生日期',
  `countryId` int(11) DEFAULT '-1' COMMENT '国籍编号',
  `cityId` int(11) DEFAULT '-1' COMMENT '城市编号',
  `height` double DEFAULT '0' COMMENT '身高',
  `weight` double DEFAULT '0' COMMENT '体重',
  `idType` varchar(255) DEFAULT 'ccc' COMMENT '证件类型',
  `idInfoId` int(11) DEFAULT '-1' COMMENT '证件类型编号',
  `teachBeginDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '执教开始时间',
  `categoryId` int(11) DEFAULT '-1' COMMENT '类别编号',
  `image` varchar(255) DEFAULT 'ddd' COMMENT '头像',
  `degreeId` int(11) DEFAULT '-1' COMMENT '等级资质编号',
  `remark` varchar(255) DEFAULT 'eee' COMMENT '备注',
  PRIMARY KEY (`coachId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coach
-- ----------------------------

-- ----------------------------
-- Table structure for `coachclub`
-- ----------------------------
DROP TABLE IF EXISTS `coachclub`;
CREATE TABLE `coachclub` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '履历编号',
  `coachId` int(11) DEFAULT '-1' COMMENT '教练员编号',
  `clubId` int(11) DEFAULT '-1' COMMENT '俱乐部编号',
  `inDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '执教开始时间',
  `outDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '离开时间',
  `remark` varchar(255) DEFAULT 'aaa' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coachclub
-- ----------------------------

-- ----------------------------
-- Table structure for `coachcompetition`
-- ----------------------------
DROP TABLE IF EXISTS `coachcompetition`;
CREATE TABLE `coachcompetition` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `competitionId` int(11) DEFAULT '-1' COMMENT '赛事编号',
  `coachId` int(11) DEFAULT '-1' COMMENT '教练员编号',
  `competitionTime` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '比赛时间',
  `score` double DEFAULT '0' COMMENT '成绩',
  `remark` varchar(255) DEFAULT 'aaa' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coachcompetition
-- ----------------------------

-- ----------------------------
-- Table structure for `coachplayer`
-- ----------------------------
DROP TABLE IF EXISTS `coachplayer`;
CREATE TABLE `coachplayer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关系编号',
  `coachId` int(11) DEFAULT '-1' COMMENT '教练员编号',
  `playerId` int(11) DEFAULT '-1' COMMENT '运动员编号',
  `inDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '开始时间',
  `outDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '结束日期',
  `bestScore` double DEFAULT '0' COMMENT '最好成绩',
  `remark` varchar(255) DEFAULT 'aaa' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coachplayer
-- ----------------------------

-- ----------------------------
-- Table structure for `coachresume`
-- ----------------------------
DROP TABLE IF EXISTS `coachresume`;
CREATE TABLE `coachresume` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '履历编号',
  `coachId` int(11) DEFAULT '-1' COMMENT '教练员编号',
  `teamId` int(11) DEFAULT '-1' COMMENT '球队编号',
  `inDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '执教开始时间',
  `outDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '离开时间',
  `bestScore` double DEFAULT '0' COMMENT '执教最佳成绩',
  `remark` varchar(255) DEFAULT 'aaa' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coachresume
-- ----------------------------

-- ----------------------------
-- Table structure for `coachteam`
-- ----------------------------
DROP TABLE IF EXISTS `coachteam`;
CREATE TABLE `coachteam` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `coachId` int(11) DEFAULT '-1' COMMENT '教练员编号',
  `flag` int(11) DEFAULT '-1' COMMENT '标志位',
  `clubId` int(11) DEFAULT '-1' COMMENT '俱乐部编号',
  `schoolTeamId` int(11) DEFAULT '-1' COMMENT '校队编号',
  `inDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '加入时间',
  `outDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '离开时间',
  `remark` varchar(255) DEFAULT 'aaa' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coachteam
-- ----------------------------

-- ----------------------------
-- Table structure for `competition`
-- ----------------------------
DROP TABLE IF EXISTS `competition`;
CREATE TABLE `competition` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '赛事编号',
  `competitionName` varchar(255) DEFAULT '比赛名称未填写' COMMENT '比赛名称',
  `teamAId` int(11) DEFAULT '6001' COMMENT '球队A编号',
  `teamBId` int(11) DEFAULT '6002' COMMENT '球队B编号',
  `rinkId` int(11) DEFAULT '50001' COMMENT '比赛场地编号',
  `competitionTime` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '比赛时间',
  `competitionDegreeId` int(11) DEFAULT '801' COMMENT '比赛等级',
  `round` int(11) DEFAULT '1' COMMENT '轮次',
  `competitionType` bit(1) DEFAULT b'1' COMMENT '0是临时赛，1是邀请赛',
  `remark` varchar(255) DEFAULT '比赛' COMMENT '备注',
  `businessLicense` varchar(255) DEFAULT NULL,
  `idCardCopyFile` varchar(255) DEFAULT NULL,
  `checkId` int(11) DEFAULT '-1' COMMENT '审核编号，默认未-1 ，表示未审核',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of competition
-- ----------------------------
INSERT INTO `competition` VALUES ('1', '全国锦标赛', '6001', '6002', '50001', '2000-01-01 00:00:00', '801', '3', '', 'bbb', null, null, '1');
INSERT INTO `competition` VALUES ('2', '中国公开赛1', '6001', '6002', '50001', '2017-11-03 00:00:00', '-1', '1', '', '				周一', null, null, '-1');
INSERT INTO `competition` VALUES ('3', '中国公开赛2', '6001', '6002', '50002', '2017-11-09 00:00:00', '-1', '1', '', '			训练', null, null, '-1');
INSERT INTO `competition` VALUES ('4', '中国公开赛3', '6001', '6002', '50001', '2000-01-01 00:00:00', '801', '1', '', '           中国成都    			 ', null, null, '-1');
INSERT INTO `competition` VALUES ('5', '中国公开赛4', '6001', '6002', '50003', '2017-11-03 00:00:00', '801', '1', '', '', null, null, '-1');
INSERT INTO `competition` VALUES ('6', '中国公开赛6', '6001', '6004', '50001', '2017-11-11 00:00:00', '801', '1', '', '', null, null, '-1');
INSERT INTO `competition` VALUES ('7', '中国公开赛7', '6002', '6003', '50002', '2017-11-03 00:00:00', '801', '1', '', '				大大大大三大', null, null, '-1');
INSERT INTO `competition` VALUES ('8', '中国公开赛8', '6005', '6004', '50005', '2017-11-09 00:00:00', '801', '1', '', '				ere', null, null, '-1');
INSERT INTO `competition` VALUES ('9', '中国公开赛9', '6002', '6004', '50004', '2017-11-02 00:00:00', '801', '1', '', '		dsds		', null, null, '-1');
INSERT INTO `competition` VALUES ('10', '中国公开赛10', '6003', '6004', '50001', '2017-01-01 00:00:00', '801', '1', '', '				', null, null, '-1');
INSERT INTO `competition` VALUES ('11', '中国公开赛11', '6001', '6002', '50002', '2010-01-01 00:00:00', '801', '1', '', '新添加	', null, null, '-1');
INSERT INTO `competition` VALUES ('12', '中国公开赛12', '6004', '6003', '50001', '2017-11-03 00:00:00', '801', '1', '', '第二次	', null, null, '-1');
INSERT INTO `competition` VALUES ('13', '中国公开赛13', '6001', '6003', '50002', '2017-11-03 00:00:00', '801', '1', '', '				成功', null, null, '-1');
INSERT INTO `competition` VALUES ('14', '中国公开赛14', '6003', '6002', '50001', '2017-12-05 00:00:00', '801', '1', '', '测试数据	', null, null, '-1');
INSERT INTO `competition` VALUES ('15', '中国公开赛15', '6001', '6003', '50001', '2017-12-06 00:00:00', '801', '1', '', '				', null, null, '-1');
INSERT INTO `competition` VALUES ('16', '比赛名称未填写', '6001', '6002', '50002', '2018-03-13 00:00:00', '801', '1', '', '		周末		', null, null, '-1');

-- ----------------------------
-- Table structure for `competitiondegree`
-- ----------------------------
DROP TABLE IF EXISTS `competitiondegree`;
CREATE TABLE `competitiondegree` (
  `competitionDegreeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '等级编号',
  `competitionDegreeName` varchar(255) DEFAULT 'aaa' COMMENT '等级编号',
  `remark` varchar(255) DEFAULT 'bbb' COMMENT '备注',
  PRIMARY KEY (`competitionDegreeId`)
) ENGINE=InnoDB AUTO_INCREMENT=802 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of competitiondegree
-- ----------------------------
INSERT INTO `competitiondegree` VALUES ('-1', '赛事等级未定义', 'bbb');
INSERT INTO `competitiondegree` VALUES ('801', '国家级赛事', 'bbb');

-- ----------------------------
-- Table structure for `country`
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `countryId` tinyint(3) NOT NULL AUTO_INCREMENT,
  `code` varchar(16) NOT NULL,
  `nameChinese` varchar(128) NOT NULL,
  `nameEnglish` varchar(128) NOT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`countryId`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES ('1', '00', '未知的國家', 'Unknown Country', null);
INSERT INTO `country` VALUES ('2', 'TT', '千里達與托貝哥共和國 (Trinidad and Tobago)', 'Trinidad and Tobago', null);
INSERT INTO `country` VALUES ('3', 'TV', '土瓦魯 (Tuvalu)', 'Tuvalu', null);
INSERT INTO `country` VALUES ('4', 'TR', '土耳其 (Türkiye)', 'Turkey (Türkiye)', null);
INSERT INTO `country` VALUES ('5', 'TM', '土庫曼 (Türkmenistan)', 'Turkmenistan (Türkmenistan)', null);
INSERT INTO `country` VALUES ('6', 'BT', '不丹 (འབྲུག་ཡུལ)', 'Bhutan (འབྲུག་ཡུལ)', null);
INSERT INTO `country` VALUES ('7', 'CF', '中非共和國 (République Centrafricaine)', 'Central African Republic (République Centrafricaine)', null);
INSERT INTO `country` VALUES ('8', 'CN', '中國 (中国)', 'China (中国)', null);
INSERT INTO `country` VALUES ('9', 'DK', '丹麥 (Danmark)', 'Denmark (Danmark)', null);
INSERT INTO `country` VALUES ('10', 'EC', '厄瓜多 (Ecuador)', 'Ecuador', null);
INSERT INTO `country` VALUES ('11', 'ER', '厄利垂亞 (Ertra)', 'Eritrea (Ertra)', null);
INSERT INTO `country` VALUES ('12', 'PG', '巴布亞紐幾內亞 (Papua New Guinea)', 'Papua New Guinea', null);
INSERT INTO `country` VALUES ('13', 'BR', '巴西 (Brasil)', 'Brazil (Brasil)', null);
INSERT INTO `country` VALUES ('14', 'BB', '巴貝多 (Barbados)', 'Barbados', null);
INSERT INTO `country` VALUES ('15', 'PY', '巴拉圭 (Paraguay)', 'Paraguay', null);
INSERT INTO `country` VALUES ('16', 'BH', '巴林 (البحرين)', 'Bahrain (البحرين)', null);
INSERT INTO `country` VALUES ('17', 'BS', '巴哈馬 (Bahamas)', 'Bahamas', null);
INSERT INTO `country` VALUES ('18', 'PA', '巴拿馬 (Panamá)', 'Panama (Panamá)', null);
INSERT INTO `country` VALUES ('19', 'PS', '巴勒斯坦領土 (Palestinian Territory)', 'Palestinian Territory', null);
INSERT INTO `country` VALUES ('20', 'PK', '巴基斯坦 (پاکستان)', 'Pakistan (پاکستان)', null);
INSERT INTO `country` VALUES ('21', 'JP', '日本', 'Japan (日本)', null);
INSERT INTO `country` VALUES ('22', 'BE', '比利時 (België)', 'Belgium (België)', null);
INSERT INTO `country` VALUES ('23', 'JM', '牙買加 (Jamaica)', 'Jamaica', null);
INSERT INTO `country` VALUES ('24', 'IL', '以色列 (ישראל)', 'Israel (ישראל)', null);
INSERT INTO `country` VALUES ('25', 'CA', '加拿大 (Canada)', 'Canada', null);
INSERT INTO `country` VALUES ('26', 'GA', '加彭 (Gabon)', 'Gabon', null);
INSERT INTO `country` VALUES ('27', 'MP', '北馬里亞納群島 (Northern Mariana Islands)', 'Northern Mariana Islands', null);
INSERT INTO `country` VALUES ('28', 'KP', '北韓 (조선)', 'North Korea (조선)', null);
INSERT INTO `country` VALUES ('29', 'QA', '卡達 (قطر)', 'Qatar (قطر)', null);
INSERT INTO `country` VALUES ('30', 'CU', '古巴 (Cuba)', 'Cuba', null);
INSERT INTO `country` VALUES ('31', 'SZ', '史瓦濟蘭 (Swaziland)', 'Swaziland', null);
INSERT INTO `country` VALUES ('32', 'TW', '台灣', 'Taiwan (台灣)', null);
INSERT INTO `country` VALUES ('33', 'NE', '尼日 (Niger)', 'Niger', null);
INSERT INTO `country` VALUES ('34', 'NI', '尼加拉瓜 (Nicaragua)', 'Nicaragua', null);
INSERT INTO `country` VALUES ('35', 'NP', '尼泊爾 (नेपाल)', 'Nepal (नेपाल)', null);
INSERT INTO `country` VALUES ('36', 'BV', '布干維島 (Bouvet Island)', 'Bouvet Island', null);
INSERT INTO `country` VALUES ('37', 'BF', '布吉納法索 (Burkina Faso)', 'Burkina Faso', null);
INSERT INTO `country` VALUES ('38', 'GT', '瓜地馬拉 (Guatemala)', 'Guatemala', null);
INSERT INTO `country` VALUES ('39', 'GP', '瓜達羅普 (Guadeloupe)', 'Guadeloupe', null);
INSERT INTO `country` VALUES ('40', 'WF', '瓦利斯群島和富圖納群島 (Wallis and Futuna)', 'Wallis and Futuna', null);
INSERT INTO `country` VALUES ('41', 'GM', '甘比亞 (Gambia)', 'Gambia', null);
INSERT INTO `country` VALUES ('42', 'BY', '白俄羅斯 (Белару́сь)', 'Belarus (Белару́сь)', null);
INSERT INTO `country` VALUES ('43', 'PN', '皮特康 (Pitcairn)', 'Pitcairn', null);
INSERT INTO `country` VALUES ('44', 'LT', '立陶宛 (Lietuva)', 'Lithuania (Lietuva)', null);
INSERT INTO `country` VALUES ('45', 'IQ', '伊拉克 (العراق)', 'Iraq (العراق)', null);
INSERT INTO `country` VALUES ('46', 'IR', '伊朗 (ایران)', 'Iran (ایران)', null);
INSERT INTO `country` VALUES ('47', 'IS', '冰島 (Ísland)', 'Iceland (Ísland)', null);
INSERT INTO `country` VALUES ('48', 'LI', '列支敦士登 (Liechtenstein)', 'Liechtenstein', null);
INSERT INTO `country` VALUES ('49', 'HU', '匈牙利 (Magyarország)', 'Hungary (Magyarország)', null);
INSERT INTO `country` VALUES ('50', 'ID', '印尼 (Indonesia)', 'Indonesia', null);
INSERT INTO `country` VALUES ('51', 'IN', '印度 (India)', 'India', null);
INSERT INTO `country` VALUES ('52', 'DJ', '吉布地 (Djibouti)', 'Djibouti', null);
INSERT INTO `country` VALUES ('53', 'KI', '吉里巴斯 (Kiribati)', 'Kiribati', null);
INSERT INTO `country` VALUES ('54', 'KG', '吉爾吉斯 (Кыргызстан)', 'Kyrgyzstan (Кыргызстан)', null);
INSERT INTO `country` VALUES ('55', 'DO', '多明尼加共和國 (Dominican Republic)', 'Dominican Republic', null);
INSERT INTO `country` VALUES ('56', 'DM', '多明尼克 (Dominica)', 'Dominica', null);
INSERT INTO `country` VALUES ('57', 'TG', '多哥 (Togo)', 'Togo', null);
INSERT INTO `country` VALUES ('58', 'AG', '安地卡及巴布達 (Antigua and Barbuda)', 'Antigua and Barbuda', null);
INSERT INTO `country` VALUES ('59', 'AO', '安哥拉 (Angola)', 'Angola', null);
INSERT INTO `country` VALUES ('60', 'AD', '安道爾共和國 (Andorra)', 'Andorra', null);
INSERT INTO `country` VALUES ('61', 'AI', '安歸拉島 (Anguilla)', 'Anguilla', null);
INSERT INTO `country` VALUES ('62', 'TK', '托克勞群島 (Tokelau)', 'Tokelau', null);
INSERT INTO `country` VALUES ('63', 'BM', '百慕達 (Bermuda)', 'Bermuda', null);
INSERT INTO `country` VALUES ('64', 'ET', '衣索比亞 (Ityop&#39;iya)', 'Ethiopia (Ityop&#39;iya)', null);
INSERT INTO `country` VALUES ('65', 'ES', '西班牙 (España)', 'Spain (España)', null);
INSERT INTO `country` VALUES ('66', 'EH', '西撒哈拉 (الصحراء الغربية)', 'Western Sahara (الصحراء الغربية)', null);
INSERT INTO `country` VALUES ('67', 'HR', '克羅埃西亞 (Hrvatska)', 'Croatia (Hrvatska)', null);
INSERT INTO `country` VALUES ('68', 'SJ', '冷岸及央棉群島 (Svalbard and Jan Mayen)', 'Svalbard and Jan Mayen', null);
INSERT INTO `country` VALUES ('69', 'LY', '利比亞 (ليبيا)', 'Libya (ليبيا)', null);
INSERT INTO `country` VALUES ('70', 'HN', '宏都拉斯 (Honduras)', 'Honduras', null);
INSERT INTO `country` VALUES ('71', 'GR', '希臘 (&#39;Eλλας)', 'Greece (&#39;Eλλας)', null);
INSERT INTO `country` VALUES ('72', 'SA', '沙烏地阿拉伯 (المملكة العربية السعودية)', 'Saudi Arabia (المملكة العربية السعودية)', null);
INSERT INTO `country` VALUES ('73', 'BN', '汶萊 (Brunei Darussalam)', 'Brunei (Brunei Darussalam)', null);
INSERT INTO `country` VALUES ('74', 'BZ', '貝里斯 (Belize)', 'Belize', null);
INSERT INTO `country` VALUES ('75', 'BJ', '貝南 (Bénin)', 'Benin (Bénin)', null);
INSERT INTO `country` VALUES ('76', 'GQ', '赤道幾內亞 (Guinea Ecuatorial)', 'Equatorial Guinea (Guinea Ecuatorial)', null);
INSERT INTO `country` VALUES ('77', 'ZW', '辛巴威 (Zimbabwe)', 'Zimbabwe', null);
INSERT INTO `country` VALUES ('78', 'AM', '亞美尼亞 (Հայաստան)', 'Armenia (Հայաստան)', null);
INSERT INTO `country` VALUES ('79', 'AZ', '亞賽拜然 (Azərbaycan)', 'Azerbaijan (Azərbaycan)', null);
INSERT INTO `country` VALUES ('80', 'TZ', '坦尚尼亞 (Tanzania)', 'Tanzania', null);
INSERT INTO `country` VALUES ('81', 'NG', '奈及利亞 (Nigeria)', 'Nigeria', null);
INSERT INTO `country` VALUES ('82', 'VE', '委內瑞拉 (Venezuela)', 'Venezuela', null);
INSERT INTO `country` VALUES ('83', 'BD', '孟加拉 (বাংলাদেশ)', 'Bangladesh (বাংলাদেশ)', null);
INSERT INTO `country` VALUES ('84', 'ZM', '尚比亞 (Zambia)', 'Zambia', null);
INSERT INTO `country` VALUES ('85', 'PW', '帛琉 (Belau)', 'Palau (Belau)', null);
INSERT INTO `country` VALUES ('86', 'SB', '所羅門群島 (Solomon Islands)', 'Solomon Islands', null);
INSERT INTO `country` VALUES ('87', 'LV', '拉脫維亞 (Latvija)', 'Latvia (Latvija)', null);
INSERT INTO `country` VALUES ('88', 'TO', '東加 (Tonga)', 'Tonga', null);
INSERT INTO `country` VALUES ('89', 'TL', '東帝汶 (Timor-Leste)', 'East Timor (Timor-Leste)', null);
INSERT INTO `country` VALUES ('90', 'BA', '波士尼亞-赫塞哥維納 (Bosna i Hercegovina)', 'Bosnia and Herzegovina (Bosna i Hercegovina)', null);
INSERT INTO `country` VALUES ('91', 'BW', '波札那 (Botswana)', 'Botswana', null);
INSERT INTO `country` VALUES ('92', 'PR', '波多黎克 (Puerto Rico)', 'Puerto Rico', null);
INSERT INTO `country` VALUES ('93', 'PL', '波蘭 (Polska)', 'Poland (Polska)', null);
INSERT INTO `country` VALUES ('94', 'FR', '法國 (France)', 'France', null);
INSERT INTO `country` VALUES ('95', 'FO', '法羅群島 (Faroe Islands)', 'Faroe Islands', null);
INSERT INTO `country` VALUES ('96', 'GF', '法屬圭亞那 (French Guiana)', 'French Guiana', null);
INSERT INTO `country` VALUES ('97', 'PF', '法屬波里尼西亞 (French Polynesia)', 'French Polynesia', null);
INSERT INTO `country` VALUES ('98', 'TF', '法屬南部屬地 (French Southern Territories)', 'French Southern Territories', null);
INSERT INTO `country` VALUES ('99', 'GI', '直布羅陀 (Gibraltar)', 'Gibraltar', null);
INSERT INTO `country` VALUES ('100', 'KE', '肯亞 (Kenya)', 'Kenya', null);
INSERT INTO `country` VALUES ('101', 'FI', '芬蘭 (Suomi)', 'Finland (Suomi)', null);
INSERT INTO `country` VALUES ('102', 'AE', '阿拉伯聯合大公國 (الإمارات العربيّة المتّحدة)', 'United Arab Emirates (الإمارات العربيّة المتّحدة)', null);
INSERT INTO `country` VALUES ('103', 'AR', '阿根廷 (Argentina)', 'Argentina', null);
INSERT INTO `country` VALUES ('104', 'OM', '阿曼 (عمان)', 'Oman (عمان)', null);
INSERT INTO `country` VALUES ('105', 'AF', '阿富汗 (افغانستان)', 'Afghanistan (افغانستان)', null);
INSERT INTO `country` VALUES ('106', 'DZ', '阿爾及利亞 (الجزائر)', 'Algeria (الجزائر)', null);
INSERT INTO `country` VALUES ('107', 'AL', '阿爾巴尼亞 (Shqipëria)', 'Albania (Shqipëria)', null);
INSERT INTO `country` VALUES ('108', 'AW', '阿魯巴島 (Aruba)', 'Aruba', null);
INSERT INTO `country` VALUES ('109', 'BG', '保加利亞 (България)', 'Bulgaria (България)', null);
INSERT INTO `country` VALUES ('110', 'RU', '俄羅斯 (Россия)', 'Russia (Россия)', null);
INSERT INTO `country` VALUES ('111', 'ZA', '南非 (South Africa)', 'South Africa', null);
INSERT INTO `country` VALUES ('112', 'GS', '南喬治亞與南桑威奇群島 (South Georgia and the South Sandwich Islands)', 'South Georgia and the South Sandwich Islands', null);
INSERT INTO `country` VALUES ('113', 'AQ', '南極洲 (Antarctica)', 'Antarctica', null);
INSERT INTO `country` VALUES ('114', 'KR', '南韓 (한국)', 'South Korea (한국)', null);
INSERT INTO `country` VALUES ('115', 'KZ', '哈薩克 (Қазақстан)', 'Kazakhstan (Қазақстан)', null);
INSERT INTO `country` VALUES ('116', 'KH', '柬埔寨 (Kampuchea)', 'Cambodia (Kampuchea)', null);
INSERT INTO `country` VALUES ('117', 'TD', '查德 (Tchad)', 'Chad (Tchad)', null);
INSERT INTO `country` VALUES ('118', 'BO', '玻利維亞 (Bolivia)', 'Bolivia', null);
INSERT INTO `country` VALUES ('119', 'CC', '科克群島 (Cocos Islands)', 'Cocos Islands', null);
INSERT INTO `country` VALUES ('120', 'CK', '科克群島 (Cook Islands)', 'Cook Islands', null);
INSERT INTO `country` VALUES ('121', 'KW', '科威特 (الكويت)', 'Kuwait (الكويت)', null);
INSERT INTO `country` VALUES ('122', 'KM', '科摩洛 (Comores)', 'Comoros (Comores)', null);
INSERT INTO `country` VALUES ('123', 'TN', '突尼西亞 (تونس)', 'Tunisia (تونس)', null);
INSERT INTO `country` VALUES ('124', 'JO', '約旦 (الاردن)', 'Jordan (الاردن)', null);
INSERT INTO `country` VALUES ('125', 'US', '美國 (United States)', 'United States', null);
INSERT INTO `country` VALUES ('126', 'UM', '美屬外部小群島 (United States minor outlying islands)', 'United States minor outlying islands', null);
INSERT INTO `country` VALUES ('127', 'VI', '美屬維京群島 (Virgin Islands, U.S.)', 'Virgin Islands, U.S.', null);

-- ----------------------------
-- Table structure for `degree`
-- ----------------------------
DROP TABLE IF EXISTS `degree`;
CREATE TABLE `degree` (
  `degreeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '等级资质编号',
  `degreeName` varchar(255) DEFAULT 'aaa' COMMENT '等级资质名称',
  `organization` varchar(255) DEFAULT 'bbb' COMMENT '颁发单位',
  `remark` varchar(255) DEFAULT 'ccc' COMMENT '备注',
  PRIMARY KEY (`degreeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of degree
-- ----------------------------

-- ----------------------------
-- Table structure for `degreelog`
-- ----------------------------
DROP TABLE IF EXISTS `degreelog`;
CREATE TABLE `degreelog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `degreeId` int(11) DEFAULT '-1' COMMENT '等级编号',
  `flag` int(11) DEFAULT '-1' COMMENT '标志位',
  `roleId` int(11) DEFAULT '-1' COMMENT '标志位',
  `coachId` int(11) DEFAULT '-1' COMMENT '教练员编号',
  `judgerId` int(11) DEFAULT '-1' COMMENT '裁判员编号',
  `awardDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '颁发时间',
  `remark` varchar(255) DEFAULT 'aaa' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of degreelog
-- ----------------------------

-- ----------------------------
-- Table structure for `error`
-- ----------------------------
DROP TABLE IF EXISTS `error`;
CREATE TABLE `error` (
  `errorId` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `errorType` varchar(255) DEFAULT 'aaa' COMMENT '错误类型',
  `errorDesc` varchar(255) DEFAULT 'bbb' COMMENT '错误描述',
  `telephone` varchar(255) DEFAULT '000' COMMENT '联系方式',
  `remark` varchar(255) DEFAULT 'ccc' COMMENT '备注',
  PRIMARY KEY (`errorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of error
-- ----------------------------

-- ----------------------------
-- Table structure for `handling`
-- ----------------------------
DROP TABLE IF EXISTS `handling`;
CREATE TABLE `handling` (
  `handlingId` int(11) NOT NULL AUTO_INCREMENT COMMENT '持杆方式编号',
  `handlingName` varchar(255) DEFAULT 'aaa' COMMENT '持杆方式名称',
  `handlingValue` varchar(255) DEFAULT 'bbb' COMMENT '简称',
  `remark` varchar(255) DEFAULT 'ccc' COMMENT '备注',
  PRIMARY KEY (`handlingId`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of handling
-- ----------------------------
INSERT INTO `handling` VALUES ('-1', '没有此类型', 'noHand', 'ccc');
INSERT INTO `handling` VALUES ('101', '左手杆', 'leftHand', 'ccc');
INSERT INTO `handling` VALUES ('102', '右手杆', 'rightHand', 'ccc');

-- ----------------------------
-- Table structure for `honor`
-- ----------------------------
DROP TABLE IF EXISTS `honor`;
CREATE TABLE `honor` (
  `honorId` int(11) NOT NULL AUTO_INCREMENT COMMENT '荣誉编号',
  `honorName` int(11) DEFAULT '-1' COMMENT '荣誉名称',
  `honorDegree` int(11) DEFAULT '-1' COMMENT '荣誉等级',
  `remark` varchar(255) DEFAULT 'aaa' COMMENT '备注',
  PRIMARY KEY (`honorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of honor
-- ----------------------------

-- ----------------------------
-- Table structure for `honorrecord`
-- ----------------------------
DROP TABLE IF EXISTS `honorrecord`;
CREATE TABLE `honorrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `honorId` int(11) DEFAULT '-1' COMMENT '荣誉编号',
  `roleId` int(11) DEFAULT '-1' COMMENT '角色编号',
  `playerId` int(11) DEFAULT '-1' COMMENT '运动员编号',
  `coachId` int(11) DEFAULT '-1' COMMENT '教练员编号',
  `judgerId` int(11) DEFAULT '-1' COMMENT '裁判员编号',
  `awardDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '颁发时间',
  `remark` varchar(255) DEFAULT 'aaa' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of honorrecord
-- ----------------------------

-- ----------------------------
-- Table structure for `idinfo`
-- ----------------------------
DROP TABLE IF EXISTS `idinfo`;
CREATE TABLE `idinfo` (
  `idInfoId` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `flag` int(11) DEFAULT '-1' COMMENT '标志位',
  `playerId` int(11) DEFAULT '-1' COMMENT '运动员编号',
  `coachId` int(11) DEFAULT '-1' COMMENT '教练员编号',
  `judgerId` int(11) DEFAULT '-1' COMMENT '裁判员编号',
  `idNo` varchar(255) DEFAULT '000000000000000000' COMMENT '证件号码',
  `frontPhoto` varbinary(255) DEFAULT NULL COMMENT '正面照片',
  `reversePhoto` varbinary(255) DEFAULT NULL COMMENT '反面照片',
  `remark` varchar(255) DEFAULT 'aaa' COMMENT '备注',
  PRIMARY KEY (`idInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of idinfo
-- ----------------------------
INSERT INTO `idinfo` VALUES ('-1', '-1', '200001', '-1', '-1', '341282111122220001', null, null, '未实名');
INSERT INTO `idinfo` VALUES ('1', '0', '200002', '-1', '-1', '341282111122220002', null, null, 'aaa');
INSERT INTO `idinfo` VALUES ('2', '0', '200008', '-1', '-1', '341282111122220008', null, null, 'aaa');
INSERT INTO `idinfo` VALUES ('3', '0', '200009', '-1', '-1', '341282111122220009', null, null, 'aaa');
INSERT INTO `idinfo` VALUES ('4', '0', '200010', '-1', '-1', '341282111122220010', null, null, 'aaa');
INSERT INTO `idinfo` VALUES ('5', '0', '200011', '-1', '-1', '341282111122220011', null, null, 'aaa');
INSERT INTO `idinfo` VALUES ('6', '0', '200012', '-1', '-1', '341282111122220012', null, null, 'aaa');
INSERT INTO `idinfo` VALUES ('7', '0', '200013', '-1', '-1', '341282111122220013', null, null, 'aaa');
INSERT INTO `idinfo` VALUES ('8', '0', '200014', '-1', '-1', '341282111122220014', null, null, 'aaa');
INSERT INTO `idinfo` VALUES ('9', '0', '200015', '-1', '-1', '341282111122220015', null, null, 'aaa');
INSERT INTO `idinfo` VALUES ('10', '0', '200016', '-1', '-1', '341282111122220016', null, null, 'aaa');
INSERT INTO `idinfo` VALUES ('11', '0', '200017', '-1', '-1', '341282111122220017', null, null, 'aaa');
INSERT INTO `idinfo` VALUES ('12', '0', '200018', '-1', '-1', '341282111122220018', null, null, 'aaa');
INSERT INTO `idinfo` VALUES ('13', '0', '200019', '-1', '-1', '341282111122220019', null, null, 'aaa');

-- ----------------------------
-- Table structure for `judgecompetition`
-- ----------------------------
DROP TABLE IF EXISTS `judgecompetition`;
CREATE TABLE `judgecompetition` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `judgerId` int(11) DEFAULT '-1' COMMENT '裁判员编号',
  `competitionId` int(11) DEFAULT '-1' COMMENT '赛事编号',
  `judgeDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '时间',
  `judgeRole` varchar(255) DEFAULT 'aaa' COMMENT '执法角色',
  `remark` varchar(255) DEFAULT 'bbb' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of judgecompetition
-- ----------------------------

-- ----------------------------
-- Table structure for `judger`
-- ----------------------------
DROP TABLE IF EXISTS `judger`;
CREATE TABLE `judger` (
  `judgerId` int(11) NOT NULL AUTO_INCREMENT COMMENT '裁判员编号',
  `name` varchar(255) DEFAULT 'aaa' COMMENT '姓名',
  `sex` varchar(255) DEFAULT 'bbb' COMMENT '性别',
  `birthday` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '出生日期',
  `height` double DEFAULT '0' COMMENT '身高',
  `weight` double DEFAULT '0' COMMENT '体重',
  `countryId` int(11) DEFAULT '-1' COMMENT '国籍编号',
  `cityId` int(11) DEFAULT '-1' COMMENT '城市编号',
  `judgeBeginDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '执法开始时间',
  `idType` varchar(255) DEFAULT 'ccc' COMMENT '证件类型',
  `idInfoId` int(11) DEFAULT '-1' COMMENT '证件信息编号',
  `categoryId` int(11) DEFAULT '-1' COMMENT '类别编号',
  `degreeId` int(11) DEFAULT '-1' COMMENT '当前资质编号',
  `image` varchar(255) DEFAULT 'ddd' COMMENT '头像',
  `modificateDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '修改日期',
  `remark` varchar(255) DEFAULT 'ddd' COMMENT '备注',
  PRIMARY KEY (`judgerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of judger
-- ----------------------------

-- ----------------------------
-- Table structure for `linkmanrecord`
-- ----------------------------
DROP TABLE IF EXISTS `linkmanrecord`;
CREATE TABLE `linkmanrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `name` varchar(255) DEFAULT 'aaa' COMMENT '联系人姓名',
  `telephone` varchar(255) DEFAULT '000' COMMENT '联系电话',
  `flag` int(11) DEFAULT '-1' COMMENT '标志位',
  `clubId` int(11) DEFAULT '-1' COMMENT '俱乐部编号',
  `rinkId` int(11) DEFAULT '-1' COMMENT '场地编号',
  `schoolTeamId` int(11) DEFAULT '-1' COMMENT '校队编号',
  `photo` varchar(255) DEFAULT 'bbb' COMMENT '照片',
  `isUsing` bit(1) DEFAULT NULL COMMENT '是否有效',
  `remark` varchar(255) DEFAULT 'ccc' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of linkmanrecord
-- ----------------------------

-- ----------------------------
-- Table structure for `loginlog`
-- ----------------------------
DROP TABLE IF EXISTS `loginlog`;
CREATE TABLE `loginlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `userId` int(11) DEFAULT '-1' COMMENT '用户编号',
  `signed` bit(1) DEFAULT b'0' COMMENT '签到',
  `ipAddress` varchar(255) DEFAULT '江苏省南京市' COMMENT '登录IP地址',
  `loginTime` datetime DEFAULT '1900-01-01 00:00:00' COMMENT '登录时间',
  `loginOffTime` datetime DEFAULT '1900-01-01 00:00:00' COMMENT '登出时间',
  `remark` varchar(255) DEFAULT '登录' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loginlog
-- ----------------------------
INSERT INTO `loginlog` VALUES ('1', '-1', '', '江苏省南京市', '1900-01-01 00:00:00', '1900-01-01 00:00:00', '登录');
INSERT INTO `loginlog` VALUES ('2', '100001', '', '江苏省南京市', '2017-12-04 11:21:23', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('3', '100001', '', '江苏省南京市', '2017-12-04 13:45:32', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('4', '100001', '', '江苏省南京市', '2017-12-04 13:48:15', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('5', '100001', '', '江苏省南京市', '2017-12-04 13:51:50', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('6', '100001', '', '江苏省南京市', '2017-12-04 13:59:51', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('7', '100001', '', '江苏省南京市', '2017-12-04 14:11:28', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('8', '100001', '', '江苏省南京市', '2017-12-04 14:17:09', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('9', '100001', '', '江苏省南京市', '2017-12-04 14:33:08', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('10', '100001', '', '江苏省南京市', '2017-12-04 14:35:49', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('11', '100001', '', '江苏省南京市', '2017-12-04 14:39:05', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('12', '100001', '', '江苏省南京市', '2017-12-04 15:06:54', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('13', '-1', '', '江苏省南京市', '2017-12-04 15:10:02', '1900-01-01 00:00:00', '100001密码错误');
INSERT INTO `loginlog` VALUES ('14', '100001', '', '江苏省南京市', '2017-12-05 19:11:07', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('15', '100007', '', '江苏省南京市', '2017-12-05 19:43:35', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('16', '100007', '', '江苏省南京市', '2017-12-05 20:04:46', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('17', '-2', '', '江苏省南京市', '2017-12-06 09:13:05', '1900-01-01 00:00:00', '138139用户不存在');
INSERT INTO `loginlog` VALUES ('18', '-1', '', '江苏省南京市', '2017-12-06 09:13:30', '1900-01-01 00:00:00', '138139密码错误');
INSERT INTO `loginlog` VALUES ('19', '-1', '', '江苏省南京市', '2017-12-06 09:13:54', '1900-01-01 00:00:00', '138139密码错误');
INSERT INTO `loginlog` VALUES ('20', '-1', '', '江苏省南京市', '2017-12-06 09:14:26', '1900-01-01 00:00:00', '138139密码错误');
INSERT INTO `loginlog` VALUES ('21', '-2', '', '江苏省南京市', '2017-12-06 09:14:40', '1900-01-01 00:00:00', '111用户不存在');
INSERT INTO `loginlog` VALUES ('22', '-1', '', '江苏省南京市', '2017-12-06 09:15:34', '1900-01-01 00:00:00', '138139密码错误');
INSERT INTO `loginlog` VALUES ('23', '100007', '', '江苏省南京市', '2017-12-06 09:16:18', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('24', '100007', '', '江苏省南京市', '2017-12-06 09:16:45', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('25', '100007', '', '江苏省南京市', '2017-12-06 09:18:52', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('26', '100001', '', '江苏省南京市', '2017-12-06 09:39:17', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('27', '100007', '', '江苏省南京市', '2017-12-06 09:39:24', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('28', '100007', '', '江苏省南京市', '2017-12-06 09:42:39', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('29', '-1', '', '江苏省南京市', '2017-12-06 10:06:51', '1900-01-01 00:00:00', '100001密码错误');
INSERT INTO `loginlog` VALUES ('30', '100001', '', '江苏省南京市', '2017-12-06 10:07:07', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('31', '100007', '', '江苏省南京市', '2017-12-06 10:57:25', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('32', '100001', '', '江苏省南京市', '2017-12-06 15:54:45', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('33', '100007', '', '江苏省南京市', '2017-12-06 17:25:23', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('34', '100007', '', '江苏省南京市', '2017-12-06 17:47:33', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('35', '100007', '', '江苏省南京市', '2017-12-06 18:01:03', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('36', '100007', '', '江苏省南京市', '2017-12-06 20:26:11', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('37', '100007', '', '江苏省南京市', '2017-12-06 20:40:17', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('38', '100007', '', '江苏省南京市', '2017-12-06 20:40:42', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('39', '100007', '', '江苏省南京市', '2017-12-06 21:01:04', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('40', '100007', '', '江苏省南京市', '2017-12-06 22:23:06', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('41', '-2', '', '江苏省南京市', '2017-12-16 09:19:50', '1900-01-01 00:00:00', '100001用户不存在');
INSERT INTO `loginlog` VALUES ('42', '100003', '', '江苏省南京市', '2017-12-16 11:42:37', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('43', '100003', '', '江苏省南京市', '2017-12-16 12:12:45', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('44', '100003', '', '江苏省南京市', '2017-12-16 12:24:12', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('45', '100003', '', '江苏省南京市', '2017-12-16 19:44:27', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('46', '100003', '', '江苏省南京市', '2017-12-16 19:46:35', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('47', '100003', '', '江苏省南京市', '2017-12-18 10:15:36', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('48', '100003', '', '江苏省南京市', '2017-12-18 10:18:05', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('49', '100003', '', '江苏省南京市', '2017-12-23 14:15:03', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('50', '100003', '', '江苏省南京市', '2017-12-29 10:14:31', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('51', '100003', '', '江苏省南京市', '2018-01-16 11:05:30', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('52', '100003', '', '江苏省南京市', '2018-03-05 09:21:56', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('53', '-2', '', '江苏省南京市', '2018-03-11 11:16:14', '1900-01-01 00:00:00', '123用户不存在');
INSERT INTO `loginlog` VALUES ('54', '-2', '', '江苏省南京市', '2018-03-11 11:20:51', '1900-01-01 00:00:00', '11用户不存在');
INSERT INTO `loginlog` VALUES ('55', '100003', '', '江苏省南京市', '2018-03-11 11:25:58', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('56', '100003', '', '江苏省南京市', '2018-03-11 11:40:45', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('57', '100001', '', '江苏省南京市', '2018-03-11 11:41:58', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('58', '100001', '', '江苏省南京市', '2018-03-11 11:44:10', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('59', '-1', '', '江苏省南京市', '2018-03-11 11:45:05', '1900-01-01 00:00:00', '100001密码错误');
INSERT INTO `loginlog` VALUES ('60', '100001', '', '江苏省南京市', '2018-03-11 11:45:13', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('61', '100001', '', '江苏省南京市', '2018-03-11 11:47:29', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('62', '100001', '', '江苏省南京市', '2018-03-11 11:52:15', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('63', '100001', '', '江苏省南京市', '2018-03-11 11:53:39', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('64', '100001', '', '江苏省南京市', '2018-03-11 12:02:41', '1900-01-01 00:00:00', '登录成功');
INSERT INTO `loginlog` VALUES ('65', '100001', '', '江苏省南京市', '2018-03-11 12:13:56', '1900-01-01 00:00:00', '登录成功');

-- ----------------------------
-- Table structure for `photorecord`
-- ----------------------------
DROP TABLE IF EXISTS `photorecord`;
CREATE TABLE `photorecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `flag` int(11) DEFAULT '-1' COMMENT '标志位',
  `clubId` int(11) DEFAULT '-1' COMMENT '俱乐部编号',
  `rinkId` int(11) DEFAULT '-1' COMMENT '场地编号',
  `schoolTeamId` int(11) DEFAULT '-1' COMMENT '校队编号',
  `photo` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `isUsing` bit(1) DEFAULT NULL COMMENT '是否有效',
  `remark` varchar(255) DEFAULT 'aaa' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of photorecord
-- ----------------------------

-- ----------------------------
-- Table structure for `player`
-- ----------------------------
DROP TABLE IF EXISTS `player`;
CREATE TABLE `player` (
  `playerId` int(11) NOT NULL AUTO_INCREMENT COMMENT '运动员编号',
  `name` varchar(255) DEFAULT 'aaa' COMMENT '姓名',
  `sex` bit(1) DEFAULT b'0' COMMENT '性别，1表示男生，0是女生',
  `birthday` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '出生日期',
  `height` double DEFAULT '0' COMMENT '身高',
  `weight` double DEFAULT '0' COMMENT '体重',
  `countryId` int(11) DEFAULT '8' COMMENT '国籍编号',
  `cityId` int(11) DEFAULT '1' COMMENT '籍贯编号',
  `firstLearnAge` double DEFAULT '0' COMMENT '初学年龄',
  `roleId` int(11) DEFAULT '101' COMMENT '角色编号',
  `handlingId` int(11) DEFAULT '-1' COMMENT '持杆方式编号',
  `idType` varchar(255) DEFAULT '身份证' COMMENT '证件类型',
  `idInfoId` varchar(255) DEFAULT '-1' COMMENT '证件信息编号',
  `categoryId` int(11) DEFAULT '-1' COMMENT '类别编号',
  `position` varchar(255) DEFAULT '前锋' COMMENT '位置',
  `creatMeld` int(11) DEFAULT '-1' COMMENT '谁创建我',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '../../img/part4/i1.jpg' COMMENT '头像',
  `modificateDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '修改时间',
  `remark` varchar(255) DEFAULT 'eee' COMMENT '备注',
  PRIMARY KEY (`playerId`)
) ENGINE=InnoDB AUTO_INCREMENT=200020 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of player
-- ----------------------------
INSERT INTO `player` VALUES ('200001', 'xiaoming', '', '2000-01-01 00:00:00', '43', '34', '8', '1', '3', '101', '-1', '身份证', '341282111122220001', '-1', '前锋', '100001', '../../img/part4/i1.jpg', '2017-11-18 14:12:53', 'eee');
INSERT INTO `player` VALUES ('200002', '宋阳', '', '2000-01-01 00:00:00', '137', '20', '8', '2', '4', '101', '-1', '身份证', '341282111122220002', '-1', '前锋', '-1', '../../img/part4/i1.jpg', '2017-12-06 17:54:12', 'eee');
INSERT INTO `player` VALUES ('200008', '张明', '', '2000-01-01 00:00:00', '160', '65', '8', '3', '5', '101', '102', '身份证', '341282111122220008', '902', '前锋', '100001', '../../img/part4/i1.jpg', '2017-11-15 00:41:20', 'eee');
INSERT INTO `player` VALUES ('200009', '小吴', '', '2017-11-30 00:00:00', '186', '45', '8', '4', '6', '101', '102', '身份证', '341282111122220009', '901', '前锋', '100001', '../../img/part4/i1.jpg', '2017-11-18 19:32:45', 'eee');
INSERT INTO `player` VALUES ('200010', '今天', '', '2000-01-01 00:00:00', '160', '78', '8', '1', '0', '101', '101', '身份证', '341282111122220010', '902', '前锋', '100003', 'C:upload20171117193956', '2017-11-17 19:39:57', 'eee');
INSERT INTO `player` VALUES ('200011', '问问', '', '2000-01-01 00:00:00', '160', '65', '8', '1', '0', '101', '102', '身份证', '341282111122220011', '902', '前锋', '100001', 'C:upload20171118155942', '2017-11-18 15:59:42', 'eee');
INSERT INTO `player` VALUES ('200012', 'rere', '', '2000-01-01 00:00:00', '174', '65', '8', '1', '0', '101', '102', '身份证', '341282111122220012', '902', '前锋', '100003', 'C:upload20171118162452', '2017-11-18 16:24:52', 'eee');
INSERT INTO `player` VALUES ('200013', '', '', '2000-01-01 00:00:00', '177', '65', '8', '1', '0', '101', '102', '身份证', '341282111122220013', '902', '前锋', '100003', 'C:upload20171118163501', '2017-11-18 16:35:17', 'eee');
INSERT INTO `player` VALUES ('200014', '121', '', '2000-01-01 00:00:00', '160', '65', '8', '1', '0', '101', '102', '身份证', '341282111122220014', '902', '前锋', '100003', 'C:upload20171118165431', '2017-11-18 16:54:31', 'eee');
INSERT INTO `player` VALUES ('200015', '2121', '', '2000-01-01 00:00:00', '172', '78', '8', '1', '0', '101', '102', '身份证', '341282111122220015', '902', '前锋', '100003', 'C:upload20171118165501', '2017-11-18 16:55:01', 'eee');
INSERT INTO `player` VALUES ('200016', '32', '', '2000-01-01 00:00:00', '160', '65', '8', '1', '0', '101', '102', '身份证', '341282111122220016', '902', '前锋', '100003', 'C:upload20171118193311', '2017-11-18 19:33:11', 'eee');
INSERT INTO `player` VALUES ('200017', '张4', '', '2000-01-01 00:00:00', '160', '65', '8', '1', '0', '101', '102', '身份证', '341282111122220017', '902', '前锋', '100001', 'C:upload201712060939484JA{R@`AL[UF6S9Q$1Y]L@B.png', '2017-12-06 09:39:48', 'eee');
INSERT INTO `player` VALUES ('200018', '李四', '', '2000-01-01 00:00:00', '160', '65', '8', '1', '0', '101', '101', '身份证', '341282111122220018', '901', '前锋', '100007', 'C:upload20171206094333', '2017-12-06 09:43:33', 'eee');
INSERT INTO `player` VALUES ('200019', '小吴', '', '2000-01-01 00:00:00', '182', '71', '8', '1', '0', '101', '102', '身份证', '341282111122220019', '901', '前锋', '100007', 'C:upload20171206173456', '2017-12-06 17:34:56', 'eee');

-- ----------------------------
-- Table structure for `playerclub`
-- ----------------------------
DROP TABLE IF EXISTS `playerclub`;
CREATE TABLE `playerclub` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `playerId` int(11) DEFAULT '-1' COMMENT '运动员编号',
  `clubId` int(11) DEFAULT '-1' COMMENT '俱乐部编号',
  `inDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '加入时间',
  `outDate` datetime DEFAULT '1900-01-01 00:00:00' COMMENT '离开时间',
  `remark` varchar(255) DEFAULT '球员所在俱乐部' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of playerclub
-- ----------------------------
INSERT INTO `playerclub` VALUES ('1', '200008', '6001', '2000-01-01 00:00:00', '1900-01-01 00:00:00', '球员所在俱乐部');
INSERT INTO `playerclub` VALUES ('2', '200002', '6002', '2000-01-01 00:00:00', '1900-01-01 00:00:00', '球员所在俱乐部');

-- ----------------------------
-- Table structure for `province`
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `provinceId` int(11) NOT NULL,
  `provinceName` varchar(50) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '注释',
  PRIMARY KEY (`provinceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES ('1', '北京市', null);
INSERT INTO `province` VALUES ('2', '天津市', null);
INSERT INTO `province` VALUES ('3', '上海市', null);
INSERT INTO `province` VALUES ('4', '重庆市', null);
INSERT INTO `province` VALUES ('5', '河北省', null);
INSERT INTO `province` VALUES ('6', '山西省', null);
INSERT INTO `province` VALUES ('7', '台湾省', null);
INSERT INTO `province` VALUES ('8', '辽宁省', null);
INSERT INTO `province` VALUES ('9', '吉林省', null);
INSERT INTO `province` VALUES ('10', '黑龙江省', null);
INSERT INTO `province` VALUES ('11', '江苏省', null);
INSERT INTO `province` VALUES ('12', '浙江省', null);
INSERT INTO `province` VALUES ('13', '安徽省', null);
INSERT INTO `province` VALUES ('14', '福建省', null);
INSERT INTO `province` VALUES ('15', '江西省', null);
INSERT INTO `province` VALUES ('16', '山东省', null);
INSERT INTO `province` VALUES ('17', '河南省', null);
INSERT INTO `province` VALUES ('18', '湖北省', null);
INSERT INTO `province` VALUES ('19', '湖南省', null);
INSERT INTO `province` VALUES ('20', '广东省', null);
INSERT INTO `province` VALUES ('21', '甘肃省', null);
INSERT INTO `province` VALUES ('22', '四川省', null);
INSERT INTO `province` VALUES ('23', '贵州省', null);
INSERT INTO `province` VALUES ('24', '海南省', null);
INSERT INTO `province` VALUES ('25', '云南省', null);
INSERT INTO `province` VALUES ('26', '青海省', null);
INSERT INTO `province` VALUES ('27', '陕西省', null);
INSERT INTO `province` VALUES ('28', '广西壮族自治区', null);
INSERT INTO `province` VALUES ('29', '西藏自治区', null);
INSERT INTO `province` VALUES ('30', '宁夏回族自治区', null);
INSERT INTO `province` VALUES ('31', '新疆维吾尔自治区', null);
INSERT INTO `province` VALUES ('32', '内蒙古自治区', null);
INSERT INTO `province` VALUES ('33', '澳门特别行政区', null);
INSERT INTO `province` VALUES ('34', '香港特别行政区', null);

-- ----------------------------
-- Table structure for `rink`
-- ----------------------------
DROP TABLE IF EXISTS `rink`;
CREATE TABLE `rink` (
  `rinkId` int(11) NOT NULL AUTO_INCREMENT COMMENT '场地编号',
  `rinkName` varchar(255) DEFAULT 'aaa' COMMENT '场地名称',
  `rinkLogo` varchar(255) DEFAULT '../../img/part/timg.jpg' COMMENT '场地LOGO',
  `countryId` int(11) DEFAULT '-1' COMMENT '国籍编号',
  `cityId` int(11) DEFAULT '-1' COMMENT '籍贯编号',
  `telephone` varchar(255) DEFAULT '100' COMMENT '场地电话',
  `indoor` bit(1) DEFAULT NULL COMMENT '室内or室外',
  `hasLocker` bit(1) DEFAULT NULL COMMENT '有无更衣室',
  `hasCarpark` bit(1) DEFAULT NULL COMMENT '有无停车场',
  `trainingDegree` varchar(255) DEFAULT 'ccc' COMMENT '冰场训练等级',
  `scale` int(11) DEFAULT '-1' COMMENT '规模',
  `hasLandTrainingRoom` bit(1) DEFAULT NULL COMMENT '有无陆地训练室',
  `area` double DEFAULT '0' COMMENT '占地面积',
  `iceArea` double NOT NULL DEFAULT '0' COMMENT '冰面面积',
  `completionDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '建成时间',
  `beginUseDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '投入使用时间',
  `openTime` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '开放时间',
  `allowedSlip` bit(1) DEFAULT NULL COMMENT '是否接受散滑',
  `email` varchar(255) DEFAULT 'ddd' COMMENT '电子邮件',
  `iceType` varchar(255) DEFAULT 'eee' COMMENT '冰面类型',
  `address` varchar(255) DEFAULT 'fff' COMMENT '地址',
  `environmentalIndex` int(11) DEFAULT '2' COMMENT '环境指数',
  `changeDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '最后修改时间',
  `remark` varchar(255) DEFAULT 'ggg' COMMENT '备注',
  `businessLicense` varchar(255) DEFAULT NULL COMMENT '营业执照',
  `idCardCopyFile` varchar(255) DEFAULT NULL COMMENT '身份证复印件',
  `checkId` int(11) DEFAULT '-1' COMMENT '审核编号，默认未-1 ，表示未审核',
  PRIMARY KEY (`rinkId`,`iceArea`)
) ENGINE=InnoDB AUTO_INCREMENT=50013 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rink
-- ----------------------------
INSERT INTO `rink` VALUES ('50001', '北海道冰场', '../../img/part/timg.jpg', '1', '1', '010-55295529', '', '', '', '省级示范区', '500', '', '50', '60', '2000-01-01 00:00:00', '2000-01-01 00:00:00', '2000-01-01 00:00:00', null, '55295529@mail.com', '真冰', '北京市海淀区临河里963号', '3', '2000-01-01 00:00:00', 'ggg', null, null, '-1');
INSERT INTO `rink` VALUES ('50002', '东京北海道冰场', '../../img/part/timg.jpg', '1', '2', '100', '', '', '', '训练', '-1', '', '0', '0', '2000-01-01 00:00:00', '2000-01-01 00:00:00', '2000-01-01 00:00:00', null, 'ddd', 'eee', 'fff', '2', '2000-01-01 00:00:00', 'ggg', null, null, '-1');
INSERT INTO `rink` VALUES ('50003', '恒大冰球场', '../../img/part/timg.jpg', '-1', '-1', '010-22223333', '', '', '', '训练', '500', '', '54', '34', '2010-10-10 00:00:00', '2010-12-12 00:00:00', '2010-10-10 00:00:00', '', 'ddd', '真冰', '南京市江宁区', '2', '2000-01-01 00:00:00', 'ggg', null, null, '-1');
INSERT INTO `rink` VALUES ('50004', '绿地冰球场', '../../img/part/timg.jpg', '-1', '-1', '11112222', '', '', '', '初级', '100', '', '32', '23', '2017-11-25 00:00:00', '2017-11-17 00:00:00', '2017-11-02 00:00:00', '', 'ddd', '真冰', '安徽', '2', '2000-01-01 00:00:00', 'ggg', null, null, '-1');
INSERT INTO `rink` VALUES ('50005', '万达冰球场1', '../../img/part/timg.jpg', '-1', '-1', '212121', '', '', '', '初级', '100', '', '23', '43', '2017-11-29 00:00:00', '2017-01-31 00:00:00', '2017-11-05 00:00:00', '', 'ddd', '真冰', '上海', '2', '2000-01-01 00:00:00', 'ggg', null, null, '-1');
INSERT INTO `rink` VALUES ('50006', '万达冰球场2', '../../img/part/timg.jpg', '-1', '-1', '11112222', '', '', '', '训练', '100', '', '12', '12', '2017-11-30 00:00:00', '2017-12-02 00:00:00', '2017-11-30 00:00:00', '', 'ddd', '', '', '2', '2000-01-01 00:00:00', 'ggg', null, null, '-1');
INSERT INTO `rink` VALUES ('50007', '万达冰球场3', '../../img/part/timg.jpg', '-1', '-1', '11112222', '', '', '', '训练', '100', '', '12', '12', '2017-11-30 00:00:00', '2017-12-02 00:00:00', '2017-11-30 00:00:00', '', 'ddd', '', '', '2', '2000-01-01 00:00:00', 'ggg', null, null, '-1');
INSERT INTO `rink` VALUES ('50008', '万达冰球场4', '../../img/part/timg.jpg', '-1', '-1', '3232', '', '', '', '初级', '100', '', '23', '32', '2017-11-16 00:00:00', '2017-12-02 00:00:00', '2017-11-15 00:00:00', '', 'ddd', '真冰', '南京', '2', '2000-01-01 00:00:00', 'ggg', null, null, '-1');
INSERT INTO `rink` VALUES ('50009', '计算机学院', '../../img/part/timg.jpg', '-1', '-1', '000011122', '', '', '', '初级', '100', '', '65', '45', '2017-11-04 00:00:00', '2017-11-09 00:00:00', '2017-11-14 00:00:00', '', 'ddd', '真冰', '南航计算机学院', '2', '2000-01-01 00:00:00', 'ggg', null, null, '-1');
INSERT INTO `rink` VALUES ('50010', '万达冰球场5', '../../img/part/timg.jpg', '-1', '-1', '13542431316', '', '', '', '初级', '100', '', '60000', '30000', '2016-11-05 00:00:00', '2016-12-05 00:00:00', '2017-02-05 00:00:00', '', 'ddd', '真冰', '上海万达中心', '2', '2000-01-01 00:00:00', 'ggg', null, null, '-1');
INSERT INTO `rink` VALUES ('50011', '深证冰粉万象', '../../img/part/timg.jpg', '-1', '-1', '13054646434', '', '', '', '初级', '100', '', '50000', '30000', '2014-12-06 00:00:00', '2015-03-06 00:00:00', '2015-12-06 00:00:00', '', 'ddd', '真冰', '深圳市', '2', '2000-01-01 00:00:00', 'ggg', null, null, '-1');
INSERT INTO `rink` VALUES ('50012', '305冰场', '../../img/part/timg.jpg', '-1', '-1', '21212121', '', '', '', '初级', '100', '', '21', '0', '2018-03-23 00:00:00', '2018-03-21 00:00:00', '2018-03-17 00:00:00', '', 'ddd', '真冰', '南航计算机楼', '2', '2000-01-01 00:00:00', 'ggg', null, null, '-1');

-- ----------------------------
-- Table structure for `rinkbelong`
-- ----------------------------
DROP TABLE IF EXISTS `rinkbelong`;
CREATE TABLE `rinkbelong` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `rinkId` int(11) DEFAULT '-1' COMMENT '场地编号',
  `clubId` int(11) DEFAULT '-1' COMMENT '俱乐部编号',
  `type` int(11) DEFAULT '-1' COMMENT '归属类型',
  `registerDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '登记时间',
  `remark` varchar(255) DEFAULT 'aaa' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rinkbelong
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `roleName` varchar(255) DEFAULT 'aaa' COMMENT '角色名称',
  `roleValue` varchar(255) DEFAULT 'bbb' COMMENT '简称',
  `remark` varchar(255) DEFAULT 'ccc' COMMENT '备注',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('-1', '用户', 'user', 'ccc');
INSERT INTO `role` VALUES ('101', '远动员', 'player', 'ccc');
INSERT INTO `role` VALUES ('102', '裁判员', 'judger', 'ccc');
INSERT INTO `role` VALUES ('103', '教练员', 'coach', 'ccc');

-- ----------------------------
-- Table structure for `statistic`
-- ----------------------------
DROP TABLE IF EXISTS `statistic`;
CREATE TABLE `statistic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `competitionId` int(11) DEFAULT NULL COMMENT '赛事编号',
  `playerId` int(11) DEFAULT NULL COMMENT '球员编号',
  `attackingPosi` varchar(255) DEFAULT '-1' COMMENT '冰球入射方位',
  `guardType` varchar(255) DEFAULT '-1' COMMENT '门将防守方式',
  `skatingType` varchar(255) DEFAULT '-1' COMMENT '门将移动方式',
  `attackingType` varchar(255) DEFAULT '-1' COMMENT '球员进攻方式',
  `ballArmFace` varchar(255) DEFAULT '-1' COMMENT '正杆反杆',
  `matchInTime` varchar(255) DEFAULT '-1' COMMENT '比赛阶段',
  `isGoal` varchar(255) DEFAULT '-1' COMMENT '是否进球',
  `isPlayer` bit(1) DEFAULT NULL COMMENT '球员还是守门员',
  `zhugong` varchar(255) DEFAULT '-1' COMMENT '助攻',
  `fangui` varchar(255) DEFAULT '-1' COMMENT '犯规',
  `onDate` datetime DEFAULT '1900-01-01 00:00:00' COMMENT '录入时间',
  `remark1` varchar(255) DEFAULT '备注' COMMENT '备注',
  `remark2` varchar(255) DEFAULT '备注' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of statistic
-- ----------------------------
INSERT INTO `statistic` VALUES ('1', '7', '200009', '-1', '-1', '-1', '-1', '-1', '-1', '-1', null, '-1', '1', '2017-12-16 19:44:46', '备注', '备注');
INSERT INTO `statistic` VALUES ('2', '7', '200009', '-1', '-1', '-1', '-1', '-1', '-1', '-1', null, '-1', '1', '2017-12-16 19:44:56', '备注', '备注');
INSERT INTO `statistic` VALUES ('3', '7', '200009', '-1', '-1', '-1', '-1', '-1', '-1', '-1', null, '-1', '1', '2017-12-16 19:45:15', '备注', '备注');
INSERT INTO `statistic` VALUES ('4', '7', '200009', '-1', '-1', '-1', '-1', '-1', '-1', '-1', null, '-1', '1', '2017-12-16 19:45:23', '备注', '备注');
INSERT INTO `statistic` VALUES ('5', '7', '200009', '1', '1', '1', '1', '1', '1', '1', null, '-1', '-1', '2017-12-16 19:48:08', '备注', '备注');
INSERT INTO `statistic` VALUES ('6', '7', '200009', '1', '1', '1', '1', '1', '1', '1', null, '-1', '-1', '2017-12-16 19:48:17', '备注', '备注');
INSERT INTO `statistic` VALUES ('7', '7', '200009', '2', '1', '2', '1', '2', '1', '1', null, '-1', '-1', '2017-12-16 19:48:43', '备注', '备注');
INSERT INTO `statistic` VALUES ('8', '7', '200009', '-1', '-1', '-1', '-1', '-1', '-1', '-1', null, '-1', '1', '2017-12-18 10:16:27', '备注', '备注');
INSERT INTO `statistic` VALUES ('9', '7', '200009', '-1', '-1', '-1', '-1', '-1', '-1', '-1', null, '1', '-1', '2017-12-18 10:17:49', '备注', '备注');
INSERT INTO `statistic` VALUES ('10', '7', '200009', '-1', '-1', '-1', '-1', '-1', '-1', '-1', null, '1', '-1', '2017-12-18 10:18:20', '备注', '备注');

-- ----------------------------
-- Table structure for `team`
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `teamId` int(11) NOT NULL AUTO_INCREMENT COMMENT '校队编号',
  `teamName` varchar(255) DEFAULT '南航冰球队' COMMENT '校队名称',
  `teamLogo` varchar(255) DEFAULT 'teamLogo' COMMENT '校队LOGO',
  `teamAddress` varchar(255) DEFAULT '江苏省南京市' COMMENT '校队地址',
  `buildTime` datetime DEFAULT '1900-01-01 00:00:00' COMMENT '组建时间',
  `telephone` varchar(255) DEFAULT '10011112222' COMMENT '联系方式',
  `leaderName` varchar(255) DEFAULT '小明' COMMENT '领队',
  `leaderTelephone` varchar(255) DEFAULT '1001111222' COMMENT '领队联系方式',
  `construction` varchar(255) DEFAULT '球队建设' COMMENT '球队建设',
  `email` varchar(255) DEFAULT 'ggg' COMMENT '电子邮件',
  `remark` varchar(255) DEFAULT 'hhh' COMMENT '备注',
  `businessLicense` varchar(255) DEFAULT NULL,
  `idCardCopyFile` varchar(255) DEFAULT NULL,
  `checkId` int(11) DEFAULT '-1' COMMENT '审核编号，默认未-1 ，表示未审核',
  `clubId` int(11) DEFAULT '6001' COMMENT '俱乐部编号',
  PRIMARY KEY (`teamId`)
) ENGINE=InnoDB AUTO_INCREMENT=6005 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES ('6001', '南航冰球队', 'teamLogo', '江苏省南京市', '1900-01-01 00:00:00', '10011112222', '小明', '1001111222', '球队建设', 'ggg', 'hhh', null, null, '-1', '6001');
INSERT INTO `team` VALUES ('6002', '南航冰球队1', 'teamLogo', '江苏省南京市', '1900-01-01 00:00:00', '10011112222', '小明', '1001111222', '球队建设', 'ggg', 'hhh', null, null, '-1', '6001');
INSERT INTO `team` VALUES ('6003', '南航冰球队2', 'teamLogo', '江苏省南京市', '1900-01-01 00:00:00', '10011112222', '小明', '1001111222', '球队建设', 'ggg', 'hhh', null, null, '-1', '6001');
INSERT INTO `team` VALUES ('6004', '南航冰球队3', 'teamLogo', '江苏省南京市', '1900-01-01 00:00:00', '10011112222', '小明', '1001111222', '球队建设', 'ggg', 'hhh', null, null, '-1', '6001');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `userName` varchar(255) DEFAULT 'aaa' COMMENT '用户姓名',
  `weChatId` varchar(255) DEFAULT 'bbb' COMMENT '微信账号',
  `telephone` varchar(11) DEFAULT '00000000000' COMMENT '电话号码',
  `password` varchar(255) DEFAULT 'ccc' COMMENT '登录密码',
  `roleId` int(11) DEFAULT '-1' COMMENT '角色编号',
  `sex` bit(1) DEFAULT b'0' COMMENT '性别',
  `birthday` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '出生日期',
  `idType` varchar(255) DEFAULT 'eee' COMMENT '证件类型',
  `idInfoId` varchar(255) DEFAULT '-1' COMMENT '证件类型编号',
  `countryId` int(11) DEFAULT '-1' COMMENT '国籍编号',
  `cityId` int(11) DEFAULT '-1' COMMENT '籍贯编号',
  `address` varchar(255) DEFAULT 'fff' COMMENT '住址',
  `joinDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '注册时间',
  `remark` varchar(255) DEFAULT 'ggg' COMMENT '备注',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=100008 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('100001', '小孙', 'bbb', '100001', '100001', '-1', '', '2017-03-02 00:00:00', '身份证', '-1', '8', '1', '               		南京市江宁区			 ', '2000-01-01 00:00:00', 'ggg');
INSERT INTO `user` VALUES ('100002', '用户2', 'bbb', '100002', '100002', '-1', '', '2000-01-01 00:00:00', '身份证', '-1', '8', '2', '北京市朝阳区', '2000-01-01 00:00:00', 'ggg');
INSERT INTO `user` VALUES ('100003', '张三', 'bbb', '1', '1', '-1', '', '2017-07-05 00:00:00', '身份证', '-1', '8', '3', '         北京通州      					 ', '2000-01-01 00:00:00', 'ggg');
INSERT INTO `user` VALUES ('100004', '用户4', 'bbb', '2', '2', '-1', '', '2000-01-01 00:00:00', '身份证', '-1', '8', '4', '北京市朝阳区', '2000-01-01 00:00:00', 'ggg');
INSERT INTO `user` VALUES ('100005', '用户5', 'bbb', '3', '3', '-1', '', '2000-01-01 00:00:00', '身份证', '-1', '8', '5', '北京市朝阳区', '2000-01-01 00:00:00', 'ggg');
INSERT INTO `user` VALUES ('100006', '张明', 'bbb', '5', '5', '-1', '', '2000-01-01 00:00:00', '身份证', '-1', '-1', '-1', '北京市朝阳区', '2000-01-01 00:00:00', 'ggg');
INSERT INTO `user` VALUES ('100007', '我在', 'bbb', '138139', '139138', '-1', '', '2016-12-06 00:00:00', 'eee', '-1', '-1', '-1', '               					 ', '2000-01-01 00:00:00', 'ggg');

-- ----------------------------
-- Table structure for `usercompetition`
-- ----------------------------
DROP TABLE IF EXISTS `usercompetition`;
CREATE TABLE `usercompetition` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关注编号',
  `competitionId` int(11) DEFAULT NULL COMMENT '赛事编号',
  `userId` int(11) DEFAULT NULL COMMENT '用户编号',
  `onDate` datetime DEFAULT '1900-01-01 00:00:00' COMMENT '关注时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usercompetition
-- ----------------------------
INSERT INTO `usercompetition` VALUES ('1', '1', '100001', '2017-12-06 14:58:09', null);
INSERT INTO `usercompetition` VALUES ('3', '4', '100001', '2017-12-06 15:15:35', null);
INSERT INTO `usercompetition` VALUES ('4', '7', '100001', '2017-12-06 15:23:28', null);
INSERT INTO `usercompetition` VALUES ('10', '12', '100007', '2017-12-06 22:10:09', null);

-- ----------------------------
-- Table structure for `userfollowplayer`
-- ----------------------------
DROP TABLE IF EXISTS `userfollowplayer`;
CREATE TABLE `userfollowplayer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `userId` int(11) DEFAULT '-1' COMMENT '用户编号',
  `playerId` int(11) DEFAULT '-1' COMMENT '运动员编号',
  `followDate` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '关注时间',
  `cancelDate` datetime DEFAULT '1900-01-01 00:00:00' COMMENT '取消关注时间',
  `remark` varchar(255) DEFAULT 'aaa' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userfollowplayer
-- ----------------------------
INSERT INTO `userfollowplayer` VALUES ('2', '100001', '200002', '2018-01-14 00:00:00', '2017-11-14 23:44:01', 'aaa');
INSERT INTO `userfollowplayer` VALUES ('3', '100001', '200008', '2017-12-04 14:36:00', '2017-12-04 14:39:31', 'aaa');
INSERT INTO `userfollowplayer` VALUES ('4', '100001', '200009', '2017-11-15 12:41:23', '1900-01-01 00:00:00', 'aaa');
INSERT INTO `userfollowplayer` VALUES ('5', '100003', '200001', '2017-11-15 21:26:44', '2017-11-18 14:14:21', 'aaa');
INSERT INTO `userfollowplayer` VALUES ('6', '100003', '200009', '2017-11-15 21:28:14', '1900-01-01 00:00:00', 'aaa');
INSERT INTO `userfollowplayer` VALUES ('7', '100003', '200002', '2017-11-15 21:29:44', '1900-01-01 00:00:00', 'aaa');
INSERT INTO `userfollowplayer` VALUES ('8', '100006', '200002', '2017-11-17 00:11:49', '1900-01-01 00:00:00', 'aaa');
INSERT INTO `userfollowplayer` VALUES ('9', '100006', '200008', '2017-11-17 00:16:08', '1900-01-01 00:00:00', 'aaa');
INSERT INTO `userfollowplayer` VALUES ('10', '100003', '200010', '2017-11-17 19:39:57', '1900-01-01 00:00:00', 'aaa');
INSERT INTO `userfollowplayer` VALUES ('11', '100001', '200011', '2017-12-04 14:39:22', '1900-01-01 00:00:00', 'aaa');
INSERT INTO `userfollowplayer` VALUES ('12', '100003', '200012', '2017-11-18 16:24:52', '1900-01-01 00:00:00', 'aaa');
INSERT INTO `userfollowplayer` VALUES ('13', '100003', '200013', '2017-11-18 16:35:17', '1900-01-01 00:00:00', 'aaa');
INSERT INTO `userfollowplayer` VALUES ('14', '100003', '200014', '2017-11-18 16:54:31', '1900-01-01 00:00:00', 'aaa');
INSERT INTO `userfollowplayer` VALUES ('15', '100003', '200015', '2017-11-18 16:55:01', '1900-01-01 00:00:00', 'aaa');
INSERT INTO `userfollowplayer` VALUES ('16', '100003', '200016', '2017-11-18 19:33:11', '1900-01-01 00:00:00', 'aaa');
INSERT INTO `userfollowplayer` VALUES ('17', '100007', '200002', '2017-12-05 20:08:37', '1900-01-01 00:00:00', 'aaa');
INSERT INTO `userfollowplayer` VALUES ('18', '100001', '200017', '2017-12-06 09:39:48', '1900-01-01 00:00:00', 'aaa');
INSERT INTO `userfollowplayer` VALUES ('19', '100007', '200018', '2017-12-06 09:43:33', '1900-01-01 00:00:00', 'aaa');
INSERT INTO `userfollowplayer` VALUES ('20', '100007', '200019', '2017-12-06 17:34:56', '2017-12-06 17:35:07', 'aaa');
INSERT INTO `userfollowplayer` VALUES ('21', '100007', '200009', '2017-12-06 17:52:59', '2017-12-06 17:53:31', 'aaa');

-- ----------------------------
-- View structure for `matchview`
-- ----------------------------
DROP VIEW IF EXISTS `matchview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `matchview` AS (select `competition`.`id` AS `competitionId`,`competition`.`competitionName` AS `competitionName`,`competition`.`teamAId` AS `teamAId`,`competition`.`teamBId` AS `teamBId`,`competition`.`rinkId` AS `rinkId`,`competition`.`competitionTime` AS `competitionTime`,`competition`.`competitionDegreeId` AS `competitionDegreeId`,`competition`.`round` AS `round`,`competition`.`competitionType` AS `competitionType`,`competition`.`remark` AS `remark`,`competition`.`businessLicense` AS `businessLicense`,`competition`.`idCardCopyFile` AS `idCardCopyFile`,`competition`.`checkId` AS `checkId`,`teama`.`teamName` AS `teamAName`,`teamb`.`teamName` AS `teamBName`,`cluba`.`clubId` AS `clubAId`,`cluba`.`clubName` AS `clubAName`,`cluba`.`clubLogo` AS `clubALogo`,`clubb`.`clubId` AS `clubBId`,`clubb`.`clubName` AS `clubBName`,`clubb`.`clubLogo` AS `clubBLogo`,`competition`.`competitionTime` AS `pkDate`,`competition`.`competitionTime` AS `pkTime`,`competitiondegree`.`competitionDegreeName` AS `competitionDegreeName`,`rink`.`rinkName` AS `rinkName`,`rink`.`environmentalIndex` AS `environmentalIndex` from ((((((`competition` join `team` `teama`) join `team` `teamb`) join `club` `cluba`) join `club` `clubb`) join `competitiondegree`) join `rink`) where ((`competition`.`teamAId` = `teama`.`teamId`) and (`competition`.`teamBId` = `teamb`.`teamId`) and (`teama`.`clubId` = `cluba`.`clubId`) and (`teamb`.`clubId` = `clubb`.`clubId`) and (`competition`.`competitionDegreeId` = `competitiondegree`.`competitionDegreeId`) and (`competition`.`rinkId` = `rink`.`rinkId`))) ;
