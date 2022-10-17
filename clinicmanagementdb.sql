-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: clinicmanagementdb2
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `diagnostic`
--

DROP TABLE IF EXISTS `diagnostic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diagnostic` (
  `disease_id` int NOT NULL,
  `medical_certificate_id` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_disease_has_medical_certificate_medical_certificate1_idx` (`medical_certificate_id`),
  KEY `fk_disease_has_medical_certificate_disease1_idx` (`disease_id`),
  CONSTRAINT `fk_disease_has_medical_certificate_disease1` FOREIGN KEY (`disease_id`) REFERENCES `disease` (`id`),
  CONSTRAINT `fk_disease_has_medical_certificate_medical_certificate1` FOREIGN KEY (`medical_certificate_id`) REFERENCES `medical_certificate` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnostic`
--

LOCK TABLES `diagnostic` WRITE;
/*!40000 ALTER TABLE `diagnostic` DISABLE KEYS */;
/*!40000 ALTER TABLE `diagnostic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disease`
--

DROP TABLE IF EXISTS `disease`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disease` (
  `id` int NOT NULL AUTO_INCREMENT,
  `disease_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disease`
--

LOCK TABLES `disease` WRITE;
/*!40000 ALTER TABLE `disease` DISABLE KEYS */;
INSERT INTO `disease` VALUES (1,'Sốt'),(2,'Ho'),(3,'Äau'),(4,'Cảm lạnh');
/*!40000 ALTER TABLE `disease` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_certificate`
--

DROP TABLE IF EXISTS `medical_certificate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_certificate` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_of_examination` datetime NOT NULL,
  `symptom` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `conclusion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `medical_register_id` int NOT NULL,
  `regulation_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_medicalcertificate_regulation1_idx` (`regulation_id`),
  KEY `fk_medicalcertificate_medicalregister1_idx` (`medical_register_id`),
  CONSTRAINT `fk_medicalcertificate_medicalregister1` FOREIGN KEY (`medical_register_id`) REFERENCES `medical_register` (`id`),
  CONSTRAINT `fk_medicalcertificate_regulation1` FOREIGN KEY (`regulation_id`) REFERENCES `regulations` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=273 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_certificate`
--

LOCK TABLES `medical_certificate` WRITE;
/*!40000 ALTER TABLE `medical_certificate` DISABLE KEYS */;
INSERT INTO `medical_certificate` VALUES (268,'2022-09-07 21:27:10','Đâu bụng','Táo bón nặng',58,1),(269,'2022-08-17 00:00:00','dau','cc',58,1),(270,'2022-08-17 00:00:00','hiv','giai đoạn 1',58,1),(271,'2022-09-07 20:21:58','h','h',58,2),(272,'2022-09-07 20:31:12','v','v',58,1);
/*!40000 ALTER TABLE `medical_certificate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_register`
--

DROP TABLE IF EXISTS `medical_register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_register` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_of_examination` datetime DEFAULT NULL,
  `patient_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone_number` int NOT NULL,
  `health_issues` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_verified` tinyint(1) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_register_user_idx` (`user_id`),
  CONSTRAINT `fk_register_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_register`
--

LOCK TABLES `medical_register` WRITE;
/*!40000 ALTER TABLE `medical_register` DISABLE KEYS */;
INSERT INTO `medical_register` VALUES (58,'2022-08-17 00:00:00','nhiet ba','1951052176tam@ou.edu.vn',1,'Cáº£m cÃºm nháº¹',1,29),(59,'2022-08-26 00:00:00','Nhiet ba 2','1951052176tam@ou.edu.vn',2,'yÃªu xa',1,29),(60,'2022-08-26 00:00:00','diec phi','1951052176tam@ou.edu.vn',3,'love tam so much',1,30);
/*!40000 ALTER TABLE `medical_register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicine` (
  `id` int NOT NULL AUTO_INCREMENT,
  `medicine_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `how_to_use` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `medicine_price` float NOT NULL,
  `medicine_quantity` int NOT NULL,
  `unit_id` int NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_medicine_unit1_idx` (`unit_id`),
  CONSTRAINT `fk_medicine_unit1` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES (9,'Bon','Nhai',5000,5,2,1),(12,'Háº¡ sá»t','UÃ´ng cÃ¡ch nhau 4 tiáº¿ng',15000,36,1,0),(13,'Cáº£m','uong',5000,36,66,0);
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription`
--

DROP TABLE IF EXISTS `prescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescription` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_date` timestamp NULL DEFAULT NULL,
  `medical_certificate_id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_prescription_user1_idx` (`user_id`),
  KEY `fk_prescription_medicalcertificate1_idx` (`medical_certificate_id`),
  CONSTRAINT `fk_prescription_medicalcertificate1` FOREIGN KEY (`medical_certificate_id`) REFERENCES `medical_certificate` (`id`),
  CONSTRAINT `fk_prescription_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=188 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription`
--

LOCK TABLES `prescription` WRITE;
/*!40000 ALTER TABLE `prescription` DISABLE KEYS */;
INSERT INTO `prescription` VALUES (182,'2022-08-15 17:00:00',268,27),(183,'2022-08-16 17:00:00',269,27),(185,'2022-09-03 14:12:32',270,27),(186,'2022-09-03 16:21:17',269,27),(187,'2022-09-03 16:22:33',268,27);
/*!40000 ALTER TABLE `prescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription_detail`
--

DROP TABLE IF EXISTS `prescription_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescription_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `prescription_id` int NOT NULL,
  `medicine_id` int NOT NULL,
  `medicine_quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_prescriptiondetall_prescription1_idx` (`prescription_id`),
  KEY `fk_prescriptiondetall_medicine1_idx` (`medicine_id`),
  CONSTRAINT `fk_prescriptiondetall_medicine1` FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`id`),
  CONSTRAINT `fk_prescriptiondetall_prescription1` FOREIGN KEY (`prescription_id`) REFERENCES `prescription` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=233 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription_detail`
--

LOCK TABLES `prescription_detail` WRITE;
/*!40000 ALTER TABLE `prescription_detail` DISABLE KEYS */;
INSERT INTO `prescription_detail` VALUES (1,182,9,5),(231,182,12,12);
/*!40000 ALTER TABLE `prescription_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regulations`
--

DROP TABLE IF EXISTS `regulations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `regulations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_quantity` int NOT NULL,
  `examination_price` float NOT NULL,
  `active` tinyint(1) NOT NULL,
  `created_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regulations`
--

LOCK TABLES `regulations` WRITE;
/*!40000 ALTER TABLE `regulations` DISABLE KEYS */;
INSERT INTO `regulations` VALUES (1,40,23000,1,'2022-09-03 23:22:33'),(2,40,160000,0,'2022-09-03 23:22:33'),(4,60,360000,0,'2022-09-07 21:39:52');
/*!40000 ALTER TABLE `regulations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit`
--

DROP TABLE IF EXISTS `unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `unit_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit`
--

LOCK TABLES `unit` WRITE;
/*!40000 ALTER TABLE `unit` DISABLE KEYS */;
INSERT INTO `unit` VALUES (1,'Vien'),(2,'Chai'),(4,'Vi'),(14,'Hop'),(61,'Hu'),(63,'Thung'),(64,'Tep'),(66,'Keo'),(68,'Mieng');
/*!40000 ALTER TABLE `unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone_number` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `date_of_birth` timestamp NULL DEFAULT NULL,
  `sex` enum('Nam','Nữ') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `identifier` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `active` tinyint(1) DEFAULT '1',
  `created_date` timestamp NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_role_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_user_user_role1_idx` (`user_role_id`),
  CONSTRAINT `fk_user_user_role1` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (27,'Tam nguyen',NULL,'432184321',NULL,'Nam',NULL,'doctor','$2a$10$.Sn/thHTgrtQ3bewufYNVewILXTe8BVpRs6MLGNfDHI0Mcga310w.',NULL,'2022-08-15 17:00:00','https://res.cloudinary.com/tamdev/image/upload/v1660645909/hna23f5ezzyfw3xyllpw.png','1951052176tam@ou.edu.vn',2),(28,'nancy',NULL,'10824',NULL,'Nữ',NULL,'nurse','$2a$10$N30GAiUWEfQoCXFqiOCnuei2xytTgzanI6GR7HETeuq01WuktQyxS',NULL,'2022-08-15 17:00:00','https://res.cloudinary.com/tamdev/image/upload/v1660645943/xpopqq9wbxoxnqcmeuam.jpg','1951052176tam@ou.edu.vn',3),(29,'nhiet ba',NULL,'2508319',NULL,'Nữ',NULL,'patient1','$2a$10$rchQzosVA8hW1I9Av67sEeqAJWWxpciR28HBebAAvTPoL7NPsZudC',NULL,'2022-08-15 17:00:00','https://res.cloudinary.com/tamdev/image/upload/v1660645982/qsiun0iyhmdp1okf0fs0.jpg','1951052176tam@ou.edu.vn',4),(30,'diec phi',NULL,'148908',NULL,'Nữ',NULL,'admin','$2a$10$B.QxN5auh2f6lZfbC/.Cfuam3RXwCaxf75ytMhLFpv4qxGFUjwyfq',NULL,'2022-08-15 17:00:00','https://res.cloudinary.com/tamdev/image/upload/v1660646011/tppru0lgo1xwjgntl7du.jpg','1951052176tam@ou.edu.vn',1),(36,'','','','2022-09-05 17:00:00','Nam','','adminPhu','$2a$10$XoRy84iXETTmmVh/evE/uOQLI99Un1Tg4ljgT6Au.xiNRDVzJBNxW',1,'2022-09-08 10:11:30','https://res.cloudinary.com/tamdev/image/upload/v1662631892/of0migljyokbauti5fnc.jpg','',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_DOCTOR'),(3,'ROLE_NURSE'),(4,'ROLE_PATIENT'),(5,'ROLE_SUPERADMIN');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-09  8:12:26
