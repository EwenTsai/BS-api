/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : bookshop

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 19/02/2020 22:52:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(100) NOT NULL,
  `author` varchar(50) NOT NULL,
  `releaseTime` datetime NOT NULL,
  `intro` varchar(255) NOT NULL,
  `price` decimal(6,2) NOT NULL,
  `rate` float(5,1) unsigned zerofill NOT NULL,
  `aboutAuthor` varchar(1000) NOT NULL,
  `stock` int(10) unsigned NOT NULL DEFAULT '0',
  `sales` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `bookname` (`bookname`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
BEGIN;
INSERT INTO `books` VALUES (1, '风雨人生', '瓦西里.格罗斯曼', '1991-09-29 11:00:00', '1960年，瓦西里•格罗斯曼（Васи́лий Гро́ссман，1905—1964）完成长篇历史小说《生活与命运》。苏联当局负责意识形态的执鞭苏斯洛夫称此书“比帕斯捷尔纳克的《日瓦戈医生》更加危险”，要“过二三百年才可能出版”。1980年，该书在被封锁二十年后历经坎坷首度出版，引起巨大轰动。', 49.90, 009.0, '瓦西里•格罗斯曼（Васи́лий Гро́ссман），苏俄记者、作家。1905年生于俄属乌克兰别尔基切夫，早年毕业于莫斯科大学数学物理系，当过化学工程师，1930年代投身写作行列，得到高尔基、巴别尔等文坛大家赏识，入选苏联国家作协。第二次世界大战期间作为《红星报》战地记者随军四年，大量报道莫斯科、库斯克、斯大林格勒和柏林等地前线战况，是揭露纳粹德国死亡集中营真相的第一人。战后发表小说《人民是不朽的》《为了正义的事业》等。1960年完成长篇小说《生活与命运》，手稿被苏联当局抄没并禁止出版。1964年格罗斯曼因癌症病逝。1974 年，在安德烈• 萨哈罗夫、弗拉基米尔• 沃伊诺维奇等人帮助下，手稿被拍摄在缩微胶卷上偷运出苏联。1980 年代初，《生活与命运》在欧美各国相继问世，1988年在苏联出版。', 3, 0);
INSERT INTO `books` VALUES (2, '了不起的盖茨比', '菲茨杰拉德', '2004-06-01 00:00:00', '盖茨比为了久久地抱着的一个梦而付出了很高的代价。他死后，尼克发觉是汤姆暗中挑拨威尔逊去杀死盖茨比。他感到东部鬼影幢幢，世态炎凉，便决定回中西部老家去。这是一个简单的故事，却有着极悲凉的人生况味。', 49.90, 009.9, '《了不起的盖茨比》(名著名译插图本)弗·司各特·菲茨杰拉德（1896-1940），美国二十世纪最杰出的作家之一。《了不起的盖茨比》是他最著名的代表作。二十世纪二十年代的美国，空气里弥漫着欢歌与纵饮的气息。一个偶然的机会，穷职员尼克闯入了挥金如土的大富翁盖茨比隐秘的世界，惊讶地发现，他内心惟一的牵绊竟是对河岸那盏小小的绿灯——灯影婆娑中，住着心爱的黛西。然而，冰冷的现实容不下缥缈的梦，到头来，盖茨比心中的女神只不过是凡尘俗世的物质女郎。当一切真相大白，盖茨比的悲剧人生亦如烟花般，璀璨只是一瞬，幻灭才是永恒。一阕华丽的“爵士时代”的挽歌，在菲茨杰拉德笔下，如诗如梦，在美国当代文学史上留下了墨色浓重的印痕。', 1, 10);
INSERT INTO `books` VALUES (3, '红楼梦', '曹雪芹', '1996-12-01 00:00:00', '《红楼梦》是一部百科全书式的长篇小说。以宝黛爱情悲剧为主线，以四大家族的荣辱兴衰为背景，描绘出18世纪中国封建社会的方方面面，以及封建专制下新兴资本主义民主思想的萌动。结构宏大、情节委婉、细节精致，人物形象栩栩如生，声口毕现，堪称中国古代小说中的经 典。', 59.70, 009.6, '曹雪芹,（？-1763，一作1764）清小说家。名霑，字梦阮，号雪芹、芹圃、芹溪。为满洲正白旗“包衣”人。自曾祖起，三代任江宁织造，其祖曹寅尤为康熙帝所信用。', 1, 0);
INSERT INTO `books` VALUES (4, '骆驼祥子', '老舍', '2000-03-01 00:00:00', '《骆驼祥子》是老舍用同情的笔触描绘的一幕悲剧：二十年代的北京，一个勤劳、壮实的底层社会小人物怀着发家、奋斗的美好梦想，却最终为黑暗的暴风雨所吞噬。它揭示了当时“小人物”的奴隶心理和希望的最终破灭。随着祥子心爱的女人小福子的自杀，祥子熄灭了个人奋斗的最后一朵火花。这是旧中国老北京贫苦市民的典型命运。', 12.00, 008.3, '老舍（1899―1966），现代著名作家。出身北京贫民家庭，1924年赴英国教书，1930年回国后长期在青岛大学等校任教授。擅长表现北京下层人民的贫苦生活及其悲惨命运。主要作品有《骆驼祥子》、《四世同堂》、《月牙儿》等小说。', 1, 0);
INSERT INTO `books` VALUES (5, '鲁滨逊漂流记', '达尼尔·笛福', '2002-01-01 00:00:00', '鲁滨逊飘流记》是18世纪英国作家达尼尔·笛福的代表作品，也是一部具有广泛的世界性影响的作品。', 9.20, 008.0, '达尼尔·笛福1660年出生在人伦郭一个商人家庭，父亲经营屠宰业。笛福受过中等教育，信奉不属于英国国教的长老会教派。由于家庭的影响，新教学校的教育，他二十岁时已经成为一个体面的小商人了。', 1, 0);
INSERT INTO `books` VALUES (6, '百年孤独', '加西亚•马尔克斯', '2011-06-01 00:00:00', '《百年孤独》是魔幻现实主义文学的代表作，描写了布恩迪亚家族七代人的传奇故事，以及加勒比海沿岸小镇马孔多的百年兴衰，反映了拉丁美洲一个世纪以来风云变幻的历史。', 39.50, 009.2, '加西亚•马尔克斯（Gabriel García Márquez）1927年出生于哥伦比亚马格达莱纳海滨小镇阿拉卡塔卡。童年与外祖父母一起生活。1936年随父母迁居苏克雷。1947年考入波哥大国立大学。1948年因内战辍学，进入报界。五十年代开始发表文学作品。六十年代初移居墨西哥。1967年出版《百年孤独》。1982年获诺贝尔文学奖。', 1, 0);
INSERT INTO `books` VALUES (7, '围城', '钱钟书', '1991-02-01 00:00:00', '围城》是钱钟书所著的长篇小说。第一版于1947年由上海晨光出版公司出版。1949年之后，由于政治等方面的原因，本书长期无法在中国大陆和台湾重印，仅在香港出现过盗印本。1980年由作者重新修订之后，在中国大陆地区由人民文学出版社刊印。此后作者又曾小幅修改过几次。《围城》 自从出版以来，就受到许多人的推崇。由于1949年后长期无法重印，这本书逐渐淡出人们的视野。', 19.00, 008.9, '钱钟书(1910－1998)，字哲良，默存，号槐聚，中国江苏无锡人，中国近代著名作家、 文学研究家。毕业于清华大学外文系，获文学学士，赴上海，到光华大学任教。后考取第三届(1935年)庚子赔款公费留学资格，名列榜首，留学英国牛津大学 埃克塞特学院。', 1, 0);
INSERT INTO `books` VALUES (8, '傲慢与偏见', '简·奥斯汀', '1993-07-01 00:00:00', '《傲慢与偏见》是简·奥斯汀的代表作，是一部描写爱情与婚姻的经典小说。作品以男女主人公达西和伊丽莎白由于傲慢和偏见而产生的爱情纠葛为线索，共写了四起姻缘：伊丽莎白与达西、简与宾利、莉迪亚与威克姆、夏洛蒂与柯林斯。伊丽莎白、简和莉迪亚是贝内特家五个女儿中的三个姐妹，而夏洛蒂则是她们的邻居，也是伊丽莎白的朋友。男主人公达西与宾利是好友，且与威克姆一起长大，而柯林斯则是贝内特家的远房亲戚。', 13.00, 008.8, '简·奥斯汀（Jane Austen，1775年12月16日－1817年7月18日）是英国著名女性小说家，她的作品主要关注乡绅家庭女性的婚姻和生活，以女性特有的细致入微的观察力和活泼风趣的文字真实地描绘了她周围世界的小天地。', 1, 0);
INSERT INTO `books` VALUES (9, '巴黎圣母院', '维克多·马里·雨果', '1982-06-01 00:00:00', '巴黎圣母院》是法国文豪维克多·雨果第一部引起轰动效应的浪漫派小说。小说以十五世纪路易十一统治下的法国为背景，通过一个纯洁无辜的波希米亚女郎惨遭迫害的故事，揭露了教士的阴险卑鄙，宗教法庭的野蛮残忍，贵族的荒淫无耻和国王的专横残暴。作品鲜明地体现了反封建、反教会的意识和对人民群众的赞颂。', 22.50, 008.4, '维克多·马里·雨果是一名法国浪漫主义作家。他是法国浪漫主义文学的的代表人物和19世纪前期积极浪漫主义文学运动的领袖，法国文学史上卓越的作家。雨果几乎经历了19世纪法国的所有重大事变。一生创作了众多诗歌、小说、剧本、各种散文和文艺评论及政论文章。代表作有《巴黎圣母院》、《九三年》、和《悲惨世界》等。', 1, 0);
INSERT INTO `books` VALUES (10, '霍乱时期的爱情', '加西亚•马尔克斯', '2012-09-01 00:00:00', '★马尔克斯唯一正式授权，首次完整翻译\n★《霍乱时期的爱情》是我最好的作品，是我发自内心的创作。——加西亚•马尔克斯\n★这部光芒闪耀、令人心碎的作品是人类有史以来最伟大的爱情小说。——《纽约时报》', 39.50, 009.0, '加西亚•马尔克斯（Gabriel García Márquez）\n1927年出生于哥伦比亚马格达莱纳海滨小镇阿拉卡塔卡。童年与外祖父母一起生活。1936年随父母迁居苏克雷。1947年考入波哥大国立大学。1948年因内战辍学，进入报界。五十年代开始出版文学作品。六十年代初移居墨西哥。1967年《百年孤独》问世。1982年获诺贝尔文学奖。1985年出版《霍乱时期的爱情》。', 1, 0);
INSERT INTO `books` VALUES (11, '羊脂球', '莫泊桑', '2007-06-01 00:00:00', '莫泊桑短篇小说的代表作。写普法战争时，法国的一群贵族、政客、商人、修女等高贵者，和一个叫作羊脂球的妓女，同乘一辆马车逃离普军占区，在一关卡受阻。普鲁士军官要求同羊脂球过夜，遭到羊脂球拒绝，高贵者们也深表气愤。', 13.50, 008.1, '莫泊桑（1850～1893）法国作家。1850年8月5日生于法国西北部诺曼底省的一个没落贵族家庭。名为贵族后裔，实际上其祖父只是复辟时期的一个税务官，父亲则是一个游手好闲。没有固定职业的浪荡子。莫泊桑在诺曼底的乡间与城镇度过了他的童年，1859年至1860年随父亲到巴黎小住，就读于拿破仑中学，后因父亲无行、双亲离异，随母又回到诺曼底。', 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `bookId` int(11) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `uid` (`uid`),
  KEY `bookId` (`bookId`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`),
  CONSTRAINT `cart_ibfk_3` FOREIGN KEY (`bookId`) REFERENCES `books` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
BEGIN;
INSERT INTO `cart` VALUES (1, 1, 8, 1);
INSERT INTO `cart` VALUES (2, 2, 7, 2);
COMMIT;

-- ----------------------------
-- Table structure for eBooks
-- ----------------------------
DROP TABLE IF EXISTS `eBooks`;
CREATE TABLE `eBooks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(100) NOT NULL,
  `downloadlink` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eBooks
-- ----------------------------
BEGIN;
INSERT INTO `eBooks` VALUES (1, '编程珠玑', '编程珠玑.pdf');
COMMIT;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `number` int(11) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
BEGIN;
INSERT INTO `orders` VALUES (5, 1, 1, 22.50, '2019-11-24 10:58:29');
INSERT INTO `orders` VALUES (7, 1, 2, 52.50, '2020-01-15 11:10:12');
COMMIT;

-- ----------------------------
-- Table structure for singalOrder
-- ----------------------------
DROP TABLE IF EXISTS `singalOrder`;
CREATE TABLE `singalOrder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) NOT NULL,
  `bookId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bookId` (`bookId`),
  KEY `order_ibfk_1` (`orderId`),
  CONSTRAINT `singalorder_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`),
  CONSTRAINT `singalorder_ibfk_2` FOREIGN KEY (`bookId`) REFERENCES `books` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of singalOrder
-- ----------------------------
BEGIN;
INSERT INTO `singalOrder` VALUES (7, 5, 9);
INSERT INTO `singalOrder` VALUES (10, 7, 8);
INSERT INTO `singalOrder` VALUES (11, 7, 6);
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `uid` int(10) NOT NULL AUTO_INCREMENT,
  `uname` varchar(100) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `sex` char(2) DEFAULT NULL,
  `age` int(3) NOT NULL,
  `birthday` date DEFAULT NULL,
  `imageAdress` varchar(100) DEFAULT NULL,
  `role` varchar(50) NOT NULL,
  `state` int(2) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES (1, 'root', 'root', '女', 0, '2019-03-21', 'images/0.jpg', 'admin', 1);
INSERT INTO `users` VALUES (2, '123', '123', '男', 0, '2019-07-29', 'images/0.jpg', 'user', 1);
INSERT INTO `users` VALUES (3, 'a123456', '12345', '男', 0, '2019-11-22', 'images/0.jpg', 'user', 1);
COMMIT;

-- ----------------------------
-- Triggers structure for table orders
-- ----------------------------
DROP TRIGGER IF EXISTS `tri_orderInsert`;
delimiter ;;
CREATE TRIGGER `tri_orderInsert` AFTER INSERT ON `orders` FOR EACH ROW begin
declare oi int;
set oi = (select id from orders where id = new.id);
insert into singalOrder (id,orderId) values (default,oi);
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
