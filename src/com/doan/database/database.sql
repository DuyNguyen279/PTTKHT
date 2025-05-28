-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: pttkht
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `acc_id` varchar(10) COLLATE utf8mb3_bin NOT NULL,
  `acc_name` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `username` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `password` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `status` bit(1) NOT NULL,
  `role` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`acc_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `acc_name_UNIQUE` (`acc_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('acc1','Nguyễn Văn A','admin','admin',_binary '','Manager'),('acc2','Trần Thị B','ttb','654321',_binary '','staff'),('acc3','Lê Văn C','lvc','abcdef',_binary '','staff'),('acc4','Phạm Thị D','ptd','123abc',_binary '','staff'),('acc5','Hoàng Văn E','hve','abc123',_binary '','staff'),('acc6','bvaesv111','nhanvien1','123',_binary '','staff');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `bill_id` varchar(10) COLLATE utf8mb3_bin NOT NULL,
  `created_at` datetime NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `tab_id` varchar(10) COLLATE utf8mb3_bin NOT NULL,
  `emp_id` varchar(10) COLLATE utf8mb3_bin NOT NULL,
  `cus_id` varchar(10) COLLATE utf8mb3_bin NOT NULL,
  `is_done` bit(1) NOT NULL,
  PRIMARY KEY (`bill_id`),
  KEY `fk_bill_tab` (`tab_id`),
  KEY `fk_bill_emp` (`emp_id`),
  KEY `fk_bill_cus` (`cus_id`),
  CONSTRAINT `fk_bill_cus` FOREIGN KEY (`cus_id`) REFERENCES `customer` (`cus_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_bill_emp` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_bill_tab` FOREIGN KEY (`tab_id`) REFERENCES `billiard_table` (`tab_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES ('bill1','2025-05-24 16:32:18',231000.00,'tab3','emp1','cus0',_binary ''),('bill10','2025-05-24 18:36:15',907500.00,'tab2','emp1','cus0',_binary ''),('bill11','2025-05-26 13:51:34',2333.33,'tab4','emp1','cus0',_binary ''),('bill2','2025-05-24 16:32:35',144166.67,'tab2','emp1','cus0',_binary ''),('bill3','2025-05-24 14:38:29',151666.67,'tab3','emp1','cus1',_binary ''),('bill4','2025-05-24 14:13:22',200000.00,'tab3','emp1','cus1',_binary ''),('bill5','2025-05-24 10:20:33',511166.67,'tab5','emp1','cus1',_binary ''),('bill6','2025-05-24 18:26:59',33833.33,'tab5','emp1','cus0',_binary ''),('bill7','2025-05-24 18:27:13',7066.67,'tab2','emp1','cus0',_binary ''),('bill8','2025-05-24 18:35:57',1815000.00,'tab4','emp1','cus0',_binary ''),('bill9','2025-05-24 18:36:07',4573800.00,'tab8','emp1','cus0',_binary '');
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_cue`
--

DROP TABLE IF EXISTS `bill_cue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_cue` (
  `cue_id` varchar(10) COLLATE utf8mb3_bin NOT NULL,
  `bill_id` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `cue_quantity` int NOT NULL,
  `total` decimal(10,2) NOT NULL,
  PRIMARY KEY (`cue_id`,`bill_id`),
  KEY `fk_bill_cue` (`bill_id`),
  CONSTRAINT `fk_bill_cue` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`bill_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cue_bill` FOREIGN KEY (`cue_id`) REFERENCES `cue` (`cue_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_cue`
--

LOCK TABLES `bill_cue` WRITE;
/*!40000 ALTER TABLE `bill_cue` DISABLE KEYS */;
INSERT INTO `bill_cue` VALUES ('cue1','bill1',1,50000.00),('cue1','bill6',3,150000.00),('cue2','bill1',2,120000.00),('cue2','bill9',4,6000000.00),('cue3','bill6',1,70000.00),('cue6','bill8',3,1000000.00);
/*!40000 ALTER TABLE `bill_cue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_item`
--

DROP TABLE IF EXISTS `bill_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_item` (
  `bill_id` varchar(10) COLLATE utf8mb3_bin NOT NULL,
  `item_id` varchar(10) COLLATE utf8mb3_bin NOT NULL,
  `item_quantity` int NOT NULL,
  `total` decimal(10,2) NOT NULL,
  PRIMARY KEY (`bill_id`,`item_id`),
  KEY `fk_item_bill` (`item_id`),
  CONSTRAINT `fk_bill_item` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`bill_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_item_bill` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_item`
--

LOCK TABLES `bill_item` WRITE;
/*!40000 ALTER TABLE `bill_item` DISABLE KEYS */;
INSERT INTO `bill_item` VALUES ('bill2','ite1',3,30000.00),('bill2','ite5',2,60000.00),('bill7','ite6',4,400.00);
/*!40000 ALTER TABLE `bill_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billiard_table`
--

DROP TABLE IF EXISTS `billiard_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billiard_table` (
  `tab_id` varchar(10) COLLATE utf8mb3_bin NOT NULL,
  `tab_name` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `start` datetime DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  `tab_price` decimal(10,2) NOT NULL,
  `tab_type` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `tab_status` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `is_delete` bit(1) NOT NULL,
  PRIMARY KEY (`tab_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billiard_table`
--

LOCK TABLES `billiard_table` WRITE;
/*!40000 ALTER TABLE `billiard_table` DISABLE KEYS */;
INSERT INTO `billiard_table` VALUES ('tab1','Bàn 1',NULL,NULL,50000.00,'Thường','Trống',_binary '\0'),('tab2','Bàn 2',NULL,NULL,50000.00,'Thường','Trống',_binary '\0'),('tab3','Bàn 3',NULL,NULL,50000.00,'Thường','Trống',_binary '\0'),('tab4','Bàn 4',NULL,NULL,70000.00,'VIP','Trống',_binary '\0'),('tab5','Bàn 5',NULL,NULL,70000.00,'VIP','Trống',_binary '\0'),('tab6','Bàn 6',NULL,NULL,70000.00,'VIP','Trống',_binary '\0'),('tab7','Bàn 7',NULL,NULL,70000.00,'Thường','Trống',_binary '\0'),('tab8','abc',NULL,NULL,12000.00,'Thường','Trống',_binary '\0');
/*!40000 ALTER TABLE `billiard_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cue`
--

DROP TABLE IF EXISTS `cue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cue` (
  `cue_id` varchar(10) COLLATE utf8mb3_bin NOT NULL,
  `cue_name` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `cue_price` decimal(10,2) NOT NULL,
  `cue_quantity` int NOT NULL,
  `is_delete` bit(1) NOT NULL,
  PRIMARY KEY (`cue_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cue`
--

LOCK TABLES `cue` WRITE;
/*!40000 ALTER TABLE `cue` DISABLE KEYS */;
INSERT INTO `cue` VALUES ('cue1','Gậy 1',50000.00,100,_binary '\0'),('cue2','Gậy 2',60000.00,100,_binary '\0'),('cue3','Gậy 3',70000.00,100,_binary '\0'),('cue4','Gậy 4',80000.00,100,_binary '\0'),('cue5','Gậy 5',90000.00,100,_binary '\0'),('cue6','abnc',10000.00,100,_binary '\0'),('cue7','Gậy 7',10000.00,100,_binary '\0'),('cue8','flkafjas',1000.00,100,_binary '');
/*!40000 ALTER TABLE `cue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `cus_id` varchar(10) COLLATE utf8mb3_bin NOT NULL,
  `cus_name` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `cus_phone` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `point` int NOT NULL,
  `is_delete` bit(1) NOT NULL,
  PRIMARY KEY (`cus_id`),
  UNIQUE KEY `cus_phone_UNIQUE` (`cus_phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('cus0','Khách Lẻ','0000000000',270,_binary '\0'),('cus1','Nguyễn An','0985426278',140,_binary '\0'),('cus2','Trần Bình','0981326578',20,_binary '\0'),('cus3','Lê Cường','0987683096',15,_binary '\0'),('cus4','Phạm Dũng','0982658900',5,_binary '\0'),('cus5','Hoàng Hương','0982341209',12,_binary '\0'),('cus6','didiii','0989089645',0,_binary '\0');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `emp_id` varchar(10) COLLATE utf8mb3_bin NOT NULL,
  `emp_name` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `emp_phone` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `email` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `is_delete` bit(1) NOT NULL,
  `acc_id` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `emp_phone_UNIQUE` (`emp_phone`),
  KEY `fk_emp_acc_idx` (`acc_id`),
  CONSTRAINT `fk_emp_acc` FOREIGN KEY (`acc_id`) REFERENCES `account` (`acc_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES ('emp1','Nguyễn Văn A','0987654321','nva@email.com',_binary '\0','acc1'),('emp2','Trần Thị B','0976543210','ttb@email.com',_binary '\0','acc2'),('emp3','Lê Văn C','0965432109','lvc@email.com',_binary '\0','acc3'),('emp4','Phạm Thị D','0954321098','ptd@email.com',_binary '\0','acc4'),('emp5','bkav','0987665624','abwsdf@gmail.com',_binary '\0',NULL),('emp6','dfa','0972563156','adsfe@gmial.com',_binary '\0',NULL);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `item_id` varchar(10) COLLATE utf8mb3_bin NOT NULL,
  `item_name` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `item_quantity` int NOT NULL,
  `item_price` decimal(10,2) NOT NULL,
  `is_delete` bit(1) NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES ('ite1','Nước ngọt',85,10000.00,_binary '\0'),('ite2','Bia',40,20000.00,_binary '\0'),('ite3','Snack',30,15000.00,_binary '\0'),('ite4','Thuốc lá',35,25000.00,_binary '\0'),('ite5','Cà phê',15,30000.00,_binary '\0'),('ite6','banhs mif',96,100.00,_binary '\0'),('ite7','ahbe',100,100.00,_binary '');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `res_id` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `cus_id` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `tab_id` varchar(45) COLLATE utf8mb3_bin DEFAULT NULL,
  `emp_id` varchar(45) COLLATE utf8mb3_bin DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `status` varchar(45) COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`res_id`),
  KEY `fk_cus_idx` (`cus_id`),
  KEY `fk_tab` (`tab_id`),
  KEY `fk_emp` (`emp_id`),
  CONSTRAINT `fk_cus` FOREIGN KEY (`cus_id`) REFERENCES `customer` (`cus_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_emp` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tab` FOREIGN KEY (`tab_id`) REFERENCES `billiard_table` (`tab_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES ('res1','cus1','tab1','emp1','2025-05-25 20:23:00','Hủy'),('res2','cus2','tab3','emp1','2025-05-25 21:28:00','Hủy'),('res3','cus2','tab2','emp1','2025-05-25 19:00:00','Hủy'),('res4','cus2','tab4','emp1','2025-05-26 15:30:00','Hoàn Thành');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-28 16:03:17
