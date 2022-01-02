-- MySQL dump 10.13  Distrib 8.0.25, for Linux (x86_64)
--
-- Host: localhost    Database: writer1
-- ------------------------------------------------------
-- Server version	8.0.25-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sid` int DEFAULT NULL,
  `comment` text,
  `cdate` varchar(10) DEFAULT NULL,
  `commentator` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sid` (`sid`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `posts` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,1,'1','4 三月 2019','admin'),(2,1,'写的不错','5 三月 2019','hello'),(3,1,'继续努力','5 三月 2019','lerry'),(4,1,'咳咳','6 三月 2019','test1'),(5,1,'咋回事','6 三月 2019','admin'),(6,2,'Java语言程序设计','6 三月 2019','admin'),(7,3,'萁在釜下燃','6 三月 2019','admin'),(8,3,'豆在釜中泣','6 三月 2019','admin'),(9,4,'星际战甲是啥','6 三月 2019','admin'),(10,5,'设计模式大法好','6 三月 2019','admin'),(11,1,'就id1在更新','6 三月 2019','admin'),(12,2,'数据库系统概述','6 三月 2019','hello'),(13,2,'线性代数','6 三月 2019','hello'),(14,7,'为什么','6 三月 2019','hello'),(15,6,'阿里不错','6 三月 2019','hello'),(16,3,'本自同根生','6 三月 2019','hello'),(17,2,'离散数学（我是大佬1）','6 三月 2019','匿名用户'),(18,9,'大佬1 NB！','6 三月 2019','dalao1'),(19,7,'我用的URL传参','6 三月 2019','admin'),(20,4,'不好玩','6 三月 2019','匿名用户'),(21,3,'作者是曹植曹子建，谢灵运曾说：天下之才有十斗，曹子建占了八斗。','6 三月 2019','lerry'),(22,4,'测试','6 三月 2019','lerry'),(23,4,'测试1','6 三月 2019','aaaaaaaaaaaaaaaa'),(24,4,'测试2','6 三月 2019','hello'),(25,10,'当课外书就好','6 三月 2019','admin'),(26,11,'作者：曹操','6 三月 2019','dell'),(27,3,'曹丕是个政治家，曹植是个诗人','6 三月 2019','dell'),(28,11,'后面接着是啥','6 三月 2019','ipad'),(29,12,'肯定ipad pro','6 三月 2019','admin'),(30,8,'优秀学生干部','7 三月 2019','test1'),(31,8,'三好学生','7 三月 2019','lerry'),(32,14,'不要沉，顶~','7 三月 2019','admin'),(33,14,'继续顶~','13 三月 2019','admin'),(34,2,'汇编语言','14 三月 2019','abcd'),(35,2,'计算机组成原理','14 三月 2019','abcd'),(36,19,'don\'t dive','14 三月 2019','abcd'),(37,19,'don\'t dive~','14 三月 2019','abcd'),(39,19,'+1','14 三月 2019','abcd'),(40,19,'+1','14 三月 2019','abcd'),(41,19,'+1','14 三月 2019','abcd'),(42,19,'+1','14 三月 2019','abcd'),(43,4,'+1','14 三月 2019','abcd'),(44,4,'+1','14 三月 2019','匿名用户'),(45,19,'测试','14 三月 2019','匿名用户'),(46,2,'散落烟火里的尘埃','14 三月 2019','匿名用户'),(47,19,'balabala~','14 三月 2019','abcd'),(48,1,'test ','14 三月 2019','匿名用户'),(49,19,'hello abcd','14 三月 2019','admin'),(50,16,'干啥玩意','20 三月 2019','admin'),(51,13,'我帮你留意着点','20 三月 2019','honor'),(52,26,'点了一万杯啤酒','22 三月 2019','匿名用户'),(53,26,'又走出了酒吧，又走进了酒吧','22 三月 2019','admin'),(54,27,'自己给自己评论一下','22 三月 2019','dell'),(55,1,'111','24 三月 2019','admin'),(56,3,'曹操','29 三月 2019','匿名用户'),(57,3,'测试：自评','29 三月 2019','admin'),(58,3,'测试：评论 消息产生','29 三月 2019','admin'),(59,1,'pinglun','11 四月 2019','匿名用户'),(60,6,'阿里技术可以，但阿里味太浓了','2 一月 2022','lerry1'),(61,6,'哈哈哈','2 一月 2022','匿名用户'),(62,6,'有个bug','2 一月 2022','匿名用户'),(63,6,'...','2 一月 2022','匿名用户'),(64,31,'自己回复自己试试','2 一月 2022','lerry1'),(65,31,'匿名评论自己测试','2 一月 2022','匿名用户'),(66,32,'西安疫情非常严峻','2 一月 2022','匿名用户'),(67,32,'西安日增100+确诊病例','2 一月 2022','匿名用户'),(68,31,'+1','2 一月 2022','lerry1'),(69,32,'年关将至','2 一月 2022','匿名用户');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `comments` text,
  `username` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (1,'admin','admin@acawriter.com','测试','admin'),(2,'系统测试员','admin@acawriter.com','测试','admin'),(3,'test6','test6@acawriter.com','测试','test6'),(4,'戴尔','dell@acawriter.com','我是戴尔','dell'),(5,'冬泳怪鸽','li@mail.com','奥利给','lerry1');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `messages` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sid` int NOT NULL,
  `username` varchar(50) NOT NULL,
  `message` text NOT NULL,
  `comment` text NOT NULL,
  `isRead` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,31,'lerry1','lerry1评论了你的帖子《lerry1》','自己回复自己试试',1),(2,31,'lerry1','lerry1评论了你的帖子《lerry1》','匿名评论自己测试',1),(3,32,'lerry1','lerry1评论了你的帖子《%E7%96%AB%E6%83%85》','西安疫情非常严峻',1),(4,32,'lerry1','lerry1评论了你的帖子《疫情》','西安日增100+确诊病例',1),(5,31,'lerry1','lerry1评论了你的帖子《lerry1》','+1',1),(6,32,'lerry1','lerry1评论了你的帖子《疫情》','年关将至',1);
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `author` varchar(16) DEFAULT NULL,
  `sdate` varchar(10) DEFAULT NULL,
  `category` varchar(30) DEFAULT NULL,
  `dianzan` int DEFAULT '0',
  `content` text,
  `title` varchar(80) DEFAULT NULL,
  `totalComments` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,'admin','4 三月 2019','Analytical Accounting',0,'Many of us work in an endless stream of tasks, browser tasks, social media, emails, meetings,','Integrating WordPress with Your Website',9),(2,'lerry','4 三月 2019','Analytical Accounting',0,'Many of us work in an endless stream of tasks, browser tasks, social media, emails, meetings,','Using Javascript',7),(3,'admin','5 三月 2019','Civil Law Essay',0,'煮豆持作羹，漉菽以为汁','七步诗',7),(4,'admin','5 三月 2019','Pharmacy',0,'星际战甲\n真好玩\n真好玩\n真好玩真好玩\n真好玩\n真好玩\n真好玩真好玩\n真好玩\n真好玩\n真好玩\n真好玩真好玩\n真好玩','星际战甲',7),(5,'admin','5 三月 2019','Research Abstract/Intro',0,'对于面向对象软件系统的设计而言，在支持可维护性的同时，提高系统的可复用性是一个至关重要的问题，如何同时提高一个软件系统的可维护性和可复用性是面向对象设计需要解决的核心问题之一。在面向对象设计中，可维护性的复用是以设计原则为基础的。每一个原则都蕴含一些面向对象设计的思想，可以从不同的角度提升一个软件结构的设计水平。\n\n      面向对象设计原则为支持可维护性复用而诞生，这些原则蕴含在很多设计模式中，它们是从许多设计方案中总结出的指导性原则。面向对象设计原则也是我们用于评价一个设计模式的使用效果的重要指标之一，在设计模式的学习中，大家经常会看到诸如“XXX模式符合XXX原则”、“XXX模式违反了XXX原则”这样的语句。\n--------------------- \n作者：Liuwei-Sunny \n来源：CSDN \n原文：https://blog.csdn.net/lovelion/article/details/7536532 \n版权声明：本文为博主原创文章，转载请附上博文链接！','面向对象设计原则概述',1),(6,'admin','5 三月 2019','Research Abstract/Intro',0,'百度阿里腾讯','BAT',5),(7,'admin','6 三月 2019','Research Abstract/Intro',0,'父页面如何传值给子页面','Iframe传值问题',2),(8,'hello','6 三月 2019','Research Abstract/Intro',0,'三等奖学金','荣誉证书',2),(9,'dalao1','6 三月 2019','Civil Law Essay',0,'大佬1发话了','我是大佬1',1),(10,'admin','6 三月 2019','Analytical Accounting',0,'英文版教材   ','多媒体技术教程',1),(11,'dell','6 三月 2019','Research Abstract/Intro',0,'东临碣石，以观沧海。\n水何澹澹，山岛竦峙。','观沧海',2),(12,'ipad','6 三月 2019','Pharmacy',0,'ipad挺好用的，但是贵，我买的最便宜的2018款','推荐一款平板电脑',1),(13,'dalao2','7 三月 2019','Research Abstract/Intro',0,'Many of us work in an endless stream of tasks, browser tasks, social media, emails, meetings,','WordPress Site Maintenance',1),(14,'admin','7 三月 2019','Pharmacy',0,'锤子科技、字节跳动等都做社交了，和微信竞争的产品越来越多，那么到底能不能将微信打败？\n欢迎感兴趣的一起讨论。','微信难下神坛？',1),(15,'admin','7 三月 2019','Pharmacy',0,'其他文章','其他标题',0),(16,'admin','7 三月 2019','Others',0,'混了','干啥',1),(18,'lerry','13 三月 2019','Others',0,'测试mybatis','测试mybatis',0),(19,'abcd','14 三月 2019','Others',0,'it\'s me first use , help me do better\n','How to use this system',9),(20,'admin','14 三月 2019','Others',0,'C语言入门教材（英文版）','C Programming',0),(21,'lerry','14 三月 2019','Others',0,'1234','1234',0),(22,'admin','20 三月 2019','Others',0,'你好啊管理员用户\n春风十里不如你','对管理员要说的话',0),(23,'ipad','20 三月 2019','Others',0,'ipad','ipad编写此文',0),(24,'honor','20 三月 2019','Others',0,'honor','此文由honor 8x所写',0),(25,'admin','22 三月 2019','Civil Law Essay',0,'测试','Civil Law Essay 测试',0),(26,'test6','22 三月 2019','Others',0,'点了一杯蜥蜴','一个测试工程师走进一家酒吧',2),(27,'dell','22 三月 2019','Research Abstract/Intro',0,'哈哈哈哈','Reserach',1),(28,'admin','27 三月 2019','Civil Law Essay',0,'In a departure from tradition, more Chinese women are opting to purchase homes while they are single, undertaking the biggest purchase of their lives without the financial support that comes with marriage.\n区别于传统，越来越多的中国女性选择在单身时买房，在还没有得到随婚姻而来的经济支持的情况下就做出了她们一生中最大一笔投资。\nThe country’s largest property listing website Ke.com analysed 67,724 transactions on its platform in 2018 and found 47.9 per cent of the buyers were female. In 2014, women accounted for about 30 percent of transactions on the platform, the company said.\n中国最大的房地产网站贝壳找房网对2018年该平台上67724宗房产交易进行了分析，发现47.9%的买家是女性。该公司说，2014年，女性在该平台交易中的占比约为30%。\nLiu Ce, head of research at Kaisa Group, said the appearance of a home, including the inner decor and landscaping carry more weight for female buyers, while other factors such as the location and price matters less.\n佳兆业集团经济研究院院长刘策说，一套房子的外在因素——包括室内装修和景观绿化——对于女性买家来说意义更重，而地点和价格等其他因素则影响较小。\n“Women are always a decisive force in our industry,” said Liu.\n刘策说：“女性永远是我们这个行业的决定性力量。”\n','China\'s property developers change tack as single women',0),(29,'admin','29 三月 2019','Civil Law Essay',0,'alert(\'hello world\');','hello world',0),(30,'admin','29 三月 2019','Others',0,'测试','测试中文问题',0),(31,'lerry1','2 一月 2022','Others',NULL,'lerry1的第一个帖子，水一下测试','lerry1',3),(32,'lerry1','2 一月 2022','Others',NULL,'疫情情况如何了','疫情',3);
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reflective`
--

DROP TABLE IF EXISTS `reflective`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reflective` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `title` varchar(80) DEFAULT NULL,
  `content` text,
  `self` int DEFAULT NULL,
  `comparison` int DEFAULT NULL,
  `summary` int DEFAULT NULL,
  `automatic` int DEFAULT NULL,
  `sdate` char(19) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `reflective_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reflective`
--

LOCK TABLES `reflective` WRITE;
/*!40000 ALTER TABLE `reflective` DISABLE KEYS */;
INSERT INTO `reflective` VALUES (1,'lerry1','第一次打招呼','大家好，我是lerry1',10,9,5,3,'2022-01-02 11:21:58'),(2,'lerry1','测试','第二次测试',4,6,4,10,'2022-01-02 11:23:20'),(4,'lerry1','三次','第二次测试',3,2,2,2,'2022-01-02 11:25:08'),(5,'lerry1','四次','第二次测试',4,2,8,2,'2022-01-02 11:25:12'),(6,'lerry1','五次','第二次测试',4,2,8,9,'2022-01-02 11:25:20'),(7,'lerry1','6次','第二次测试',10,2,8,9,'2022-01-02 11:25:24'),(8,'lerry1','7次','第二次测试',10,7,8,9,'2022-01-02 11:25:27'),(9,'lerry1','8次','第二次测试',10,7,10,9,'2022-01-02 11:25:31'),(10,'lerry1','9次','第二次测试',10,9,10,9,'2022-01-02 11:25:33'),(11,'lerry1','10次','第二次测试',10,10,10,10,'2022-01-02 11:25:38'),(12,'lerry1','阿斯顿法国阿斯','第二次测试',10,10,10,10,'2022-01-02 11:25:44'),(13,'lerry1','在次序','第二次测试',10,10,10,10,'2022-01-02 11:25:45'),(14,'lerry1','俄文人','第二次测试',10,10,10,10,'2022-01-02 11:25:47'),(15,'lerry','7','<p>hello cute lerry</p>',7,7,7,7,'2022-01-02 11:52:35');
/*!40000 ALTER TABLE `reflective` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(16) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=554 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (2,'admin','Prior to starting my clinical placement, I honestly had no idea what sort of challenges I would have to face in a Community Pharmacy setting. It has essentially provided me with a perspective of the expectations of a pharmacist as a health care professional. I personally saw it as a journey which exposed my strengths and weaknesses. I saw my preceptor as someone who guided me to help address my weaknesses. However, I began to realise that this was only to a certain extent. The most important thing I learnt from these experiences is that I can only develop my skills if I actively contribute to the pharmacy by demonstrating initiative. This initiative was a product of my inner passion and motivation to practise as a pharmacist in future. Various encounters along my journey proved to me that every day presents with a new challenge. I initially could not comprehend just how diverse the members of the community were, particularly in regards to their health issues and understanding of their condition.'),(3,'lerry','<p>hello cute lerry</p>'),(452,'hello','<p>hello hello<img src=\"http://localhost/writer1/plugins/layui/images/faceimg/36.gif\" alt=\"[酷]\"></p><p>hello<br></p>'),(457,'test3','<p>hello test3</p><p>hello test3<br></p>'),(460,'dell','Technology is an enabler in providing greater access to justice through its ability to connect people with legal needs to legal assistance, information, and advice. With the increasing popularity of internet-enabled hand held devices and laptop computers, there is a tendency to assume that even the socio-economically vulnerable in our society have access to technology and the skills to use online services with confidence. This is not necessarily the case. \n\nExamples of the application of technology to provide legal information and assistance include case studies, guides and virtual legal advice clinics. The 2012 Review does not address the role of courts in serving the legal needs of the community. The court system is not regarded as a part of the wider legal assistance services. This omission questions the role of the court in facilitating access to its services, including dispute resolution and trials. It also identified uses of technology to expand the delivery of services, many of which are transferable to an online court. These services include e-access for remote communities, availability outside of business hours, interactive processes and virtual appearances. This essay will discuss uses of technology to expand the delivery of services, many of which are transferable to an online court.你好啊'),(461,'honor','Prior to starting my clinical placement, I honestly had no idea what sort of challenges I would have to face in a Community Pharmacy setting. It has essentially provided me with a perspective of the expectations of a pharmacist as a health care professional. I personally saw it as a journey which exposed my strengths and weaknesses. I saw my preceptor as someone who guided me to help address my weaknesses. However, I began to realise that this was only to a certain extent. The most important thing I learnt from these experiences is that I can only develop my skills if I actively contribute to the pharmacy by demonstrating initiative. This initiative was a product of my inner passion and motivation to practise as a pharmacist in future. Various encounters along my journey proved to me that every day presents with a new challenge. I initially could not comprehend just how diverse the members of the community were, particularly in regards to their health issues and understanding of their condition.'),(462,'chenmei','<p>Institute of new media, southwest universityrrgehw</p>'),(470,'test1','test 1 writes the article<br>'),(474,'ipad','Technology is an enabler in providing greater access to justice through its ability to connect people with legal needs to legal assistance, information, and advice. With the increasing popularity of internet-enabled hand held devices and laptop computers, there is a tendency to assume that even the socio-economically vulnerable in our society have access to technology and the skills to use online services with confidence. This is not necessarily the case. \n\nExamples of the application of technology to provide legal information and assistance include case studies, guides and virtual legal advice clinics. The 2012 Review does not address the role of courts in serving the legal needs of the community. The court system is not regarded as a part of the wider legal assistance services. This omission questions the role of the court in facilitating access to its services, including dispute resolution and trials. It also identified uses of technology to expand the delivery of services, many of which are transferable to an online court. These services include e-access for remote communities, availability outside of business hours, interactive processes and virtual appearances. This essay will discuss uses of technology to expand the delivery of services, many of which are transferable to an online court.'),(476,'dalao1','hello&nbsp; dalao1'),(486,'dalao2','i am dalao2<br>'),(487,'abcd','hello abcd<br>'),(488,'aminu8','hello, world,amazing.'),(497,'test4','What does ‘performance’ mean for Lululemon?\nEXECUTIVE SUMMARY\nLululemon Athletica (‘Lululemon’) is an athletic apparel brand that produces high-end products and has expanded globally since its establishment in 1998. Commercial performance is important for the company however Lululemon’s success relies on providing a “consistent, high quality product and guest experience” (Lululemon Athletica 2017 p.5). Therefore, performance for Lululemon can be defined by two factors: \n\n1. producing high quality merchandise \n\n2. continuous innovation \nI INTRODUCTION \nLululemon is a premium fitness brand that designs and retails ‘healthy lifestyle inspired’ athletic apparel for women, men and children (Lululemon Athletica 2017). Lululemon is a commercial success as attested to in its current operation of 406 stories in over 12 countries. This global expansion has resulted in the continuous increase of net revenue in recent years, with FY17 seeing a 15% rise to $2.3bn from FY16 (Lululemon Athletica 2017). However, academic theory holds that while financial measures are important, organisational performance can be defined through a range of methods as organisations will have different objectives (Rasula, Vuksic &amp; Stemberger 2012). Therefore, to effectively measure ‘performance’ for the Canadian Head Office of Lululemon it is essential to consider how the transformational self-improvement ethos of the company is achieved by analysing non-traditional metrics. The report will first examine Lululemon’s overall objectives and how the company achieves these through business strategies and activities. Drawing from the company’s objective, the report will then define performance for Lululemon using non-traditional metrics. Ultimately, the report will comment on why the aforementioned definition of performance is appropriate for Lululemon.\n\nII ORGANISATIONAL ANALYSIS \nLululemon’s organisational objective is to “produce products which create transformational experiences for people to live happy, healthy, fun lives” (Lululemon Athletica 2017 p.2). This aim is achieved by a threefold competitive strategy of differentiation through quality, innovation and supply chain sustainability. These strategies are achieved through the company’s corporate strategy of a single business with a vertical retail and distribution structure. Additionally, the decentralised leadership model allows store managers to connect with the brand and increase autonomy over individual stores to best implement the company’s objective (Lululemon Athletica 2017; Lululemon Athletica 2018a). Here, retail staff (‘educators’) are under control of store managers, who themselves report to the Retail Executive Vice President. Figure 1 details the organisational structure [Figure removed for AcaWriter].\nLululemon’s first strategy is the creation of high-quality products. To achieve this strategy it is essential that the fabric, performance and craftsmanship of each product meets a certain standard. Lululemon can meet its quality expectations by increasing internal controls to ensure each product is of a high standard. Further, Lululemon conducts routine quality control inspections to assess if the manufactured product adheres to its quality standards (WWD Staff 2014). The second strategy is Lululemon’s continuous product innovation through a ‘design-led’ vision. Lululemon’s design is a point of differentiation as all fashion-forward products contain ‘innovative functional features’ (Lululemon Athletica 2017). Lululemon’s design team continually conducts market research and seeks inspiration from customers to ensure the products address the needs of users (Lululemon Athletica 2017). This ensures product lines are improved and appealing to customers who value the ‘technical rigor and premium quality’ of the products (Lululemon Athletica 2017).\nLululemon’s final strategy focuses on improving its supply chain sustainability to retain its position as a market leader with a favourable reputation as this allows the company to create ‘transformational experiences’. Lululemon requires that manufacturers adhere to a code of ethics to ensure practices are environmentally and socially sustainable (Lululemon Athletica 2017). These requirements maintain product quality as unethically produced garments could be of lower quality, damage its reputation and ultimately contradict the company’s objective.'),(517,'aaaaaaaaaaaaaaaa','Prior to starting my clinical placement, I honestly had no idea what sort of challenges I would have to face in a Community Pharmacy setting. It has essentially provided me with a perspective of the expectations of a pharmacist as a health care professional. I personally saw it as a journey which exposed my strengths and weaknesses. I saw my preceptor as someone who guided me to help address my weaknesses. However, I began to realise that this was only to a certain extent. The most important thing I learnt from these experiences is that I can only develop my skills if I actively contribute to the pharmacy by demonstrating initiative. This initiative was a product of my inner passion and motivation to practise as a pharmacist in future. Various encounters along my journey proved to me that every day presents with a new challenge. I initially could not comprehend just how diverse the members of the community were, particularly in regards to their health issues and understanding of their condition.'),(543,'abyss','圣诞节三 数据的'),(547,'taishi','Prior to starting my clinical placement, I honestly had no idea what sort of challenges I would have to face in a Community Pharmacy setting. It has essentially provided me with a perspective of the expectations of a pharmacist as a health care professional. I personally saw it as a journey which exposed my strengths and weaknesses. I saw my preceptor as someone who guided me to help address my weaknesses. However, I began to realise that this was only to a certain extent. The most important thing I learnt from these experiences is that I can only develop my skills if I actively contribute to the pharmacy by demonstrating initiative. This initiative was a product of my inner passion and motivation to practise as a pharmacist in future. Various encounters along my journey proved to me that every day presents with a new challenge. I initially could not comprehend just how diverse the members of the community were, particularly in regards to their health issues and understanding of their condition.'),(549,'huaweihonor','It is now widely accepted that timely, actionable feedback is essential for effective learning. In response to this, data science is now impacting the education sector, with a growing number of commercial products and research prototypes providing “learning dashboards”, aiming to provide real time progress indicators. From a human-centred computing perspective, the end-user’s interpretation of these visualisations is a critical challenge to design for, with empirical evidence already showing that ‘usable’ visualisations are not necessarily effective from a learning perspective. Since an educator’s interpretation of visualised data is essentially the construction of a narrative about student progress, we draw on the growing body of work on Data Storytelling (DS) as the inspiration for a set of enhancements that could be applied to data visualisations to improve their communicative power. We present a pilot study that explores the effectiveness of these DS elements based on educators’ responses to paper prototypes.'),(551,'lerry1','第二次测试');
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (14,'admin','admin'),(45,'dell','dell'),(46,'ipad','ipad'),(47,'lerry','lerry'),(50,'lerry1','lerry');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visits`
--

DROP TABLE IF EXISTS `visits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visits` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sign` varchar(26) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`sign`)
) ENGINE=InnoDB AUTO_INCREMENT=1379 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visits`
--

LOCK TABLES `visits` WRITE;
/*!40000 ALTER TABLE `visits` DISABLE KEYS */;
INSERT INTO `visits` VALUES (785,'aaaaaaaaaaaaaaaa2019-02-28'),(886,'aaaaaaaaaaaaaaaa2019-03-04'),(952,'aaaaaaaaaaaaaaaa2019-03-06'),(983,'aaaaaaaaaaaaaaaa2019-03-07'),(1049,'aaaaaaaaaaaaaaaa2019-03-18'),(1082,'aaaaaaaaaaaaaaaa2019-03-20'),(1107,'aaaaaaaaaaaaaaaa2019-03-21'),(1164,'aaaaaaaaaaaaaaaa2019-03-24'),(1007,'abcd2019-03-14'),(1044,'abcd2019-03-16'),(1052,'abcd2019-03-18'),(1055,'abcd2019-03-20'),(1119,'abcd2019-03-21'),(1166,'abcd2019-03-24'),(1184,'abcd2019-03-25'),(1143,'abyss2019-03-22'),(3,'admin'),(557,'admin2019-02-27'),(626,'admin2019-02-28'),(872,'admin2019-03-01'),(879,'admin2019-03-03'),(881,'admin2019-03-04'),(890,'admin2019-03-05'),(907,'admin2019-03-06'),(968,'admin2019-03-07'),(1004,'admin2019-03-10'),(1018,'admin2019-03-14'),(1031,'admin2019-03-15'),(1032,'admin2019-03-16'),(1047,'admin2019-03-17'),(1048,'admin2019-03-18'),(1053,'admin2019-03-20'),(1096,'admin2019-03-21'),(1128,'admin2019-03-22'),(1144,'admin2019-03-23'),(1152,'admin2019-03-24'),(1182,'admin2019-03-25'),(1217,'admin2019-03-27'),(1299,'admin2019-03-29'),(1354,'admin2019-04-11'),(1355,'admin2022-01-01'),(1045,'aminu82019-03-17'),(1215,'aminu82019-03-26'),(604,'chenmei2019-02-27'),(627,'chenmei2019-02-28'),(1276,'chenmei2019-03-27'),(926,'dalao12019-03-06'),(1035,'dalao12019-03-16'),(1067,'dalao12019-03-20'),(1097,'dalao12019-03-21'),(1145,'dalao12019-03-23'),(1298,'dalao12019-03-27'),(1003,'dalao22019-03-07'),(1084,'dalao22019-03-20'),(11,'dell'),(601,'dell2019-02-27'),(864,'dell2019-02-28'),(963,'dell2019-03-06'),(1056,'dell2019-03-20'),(1125,'dell2019-03-21'),(1141,'dell2019-03-22'),(1177,'dell2019-03-24'),(1183,'dell2019-03-25'),(1231,'dell2019-03-27'),(7,'hello'),(567,'hello2019-02-27'),(717,'hello2019-02-28'),(902,'hello2019-03-05'),(920,'hello2019-03-06'),(991,'hello2019-03-07'),(1085,'hello2019-03-20'),(39,'honor'),(603,'honor2019-02-27'),(741,'honor2019-02-28'),(1095,'honor2019-03-20'),(1126,'honor2019-03-21'),(1187,'honor2019-03-25'),(1282,'honor2019-03-27'),(1201,'huaweihonor2019-03-25'),(13,'ipad'),(638,'ipad2019-02-28'),(964,'ipad2019-03-06'),(1046,'ipad2019-03-17'),(1057,'ipad2019-03-20'),(1124,'ipad2019-03-21'),(1150,'ipad2019-03-24'),(1186,'ipad2019-03-25'),(1229,'ipad2019-03-27'),(1353,'ipad2019-03-29'),(1260,'lca7873963922019-03-27'),(1313,'lca7873963922019-03-29'),(8,'lerry'),(1370,'lerry12022-01-02'),(563,'lerry2019-02-27'),(628,'lerry2019-02-28'),(874,'lerry2019-03-01'),(880,'lerry2019-03-03'),(889,'lerry2019-03-04'),(895,'lerry2019-03-05'),(949,'lerry2019-03-06'),(980,'lerry2019-03-07'),(1006,'lerry2019-03-13'),(1022,'lerry2019-03-14'),(1062,'lerry2019-03-20'),(1255,'lerry2019-03-27'),(1310,'lerry2019-03-29'),(1356,'lerry2022-01-01'),(1372,'lerry2022-01-02'),(1005,'lerry_li2019-03-12'),(1051,'lerry_li2019-03-18'),(1086,'lerry_li2019-03-20'),(625,'null2019-02-27'),(640,'null2019-02-28'),(878,'null2019-03-01'),(908,'null2019-03-06'),(1147,'null2019-03-23'),(1151,'null2019-03-24'),(1058,'sabernic2019-03-20'),(1176,'taishi2019-03-24'),(1,'test'),(180,'test1'),(598,'test12019-02-27'),(633,'test12019-02-28'),(993,'test12019-03-07'),(599,'test22019-02-27'),(294,'test3'),(600,'test32019-02-27'),(553,'test4'),(1059,'test42019-03-20'),(1101,'test42019-03-21'),(1130,'test52019-03-22'),(1131,'test62019-03-22'),(1317,'test72019-03-29');
/*!40000 ALTER TABLE `visits` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-02 21:46:55
