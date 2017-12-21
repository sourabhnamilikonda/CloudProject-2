-- MySQL dump 10.13  Distrib 5.6.19, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: cloud_database
-- ------------------------------------------------------
-- Server version	5.6.23-enterprise-commercial-advanced-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `file_info`
--

DROP TABLE IF EXISTS `file_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file_info` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_id` int(11) DEFAULT NULL,
  `f_name` varchar(255) DEFAULT NULL,
  `f_upload_time` varchar(255) DEFAULT NULL,
  `f_update_time` varchar(255) DEFAULT NULL,
  `file_desc` varchar(255) DEFAULT NULL,
  `f_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  KEY `fk_id` (`fk_id`),
  CONSTRAINT `file_info_ibfk_1` FOREIGN KEY (`fk_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_info`
--

LOCK TABLES `file_info` WRITE;
/*!40000 ALTER TABLE `file_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `file_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine_reminder`
--

DROP TABLE IF EXISTS `medicine_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicine_reminder` (
  `primary_key` int(11) NOT NULL AUTO_INCREMENT,
  `medicine_name` varchar(45) DEFAULT NULL,
  `frequency` varchar(100) DEFAULT NULL,
  `week` varchar(100) DEFAULT NULL,
  `time` varchar(100) DEFAULT NULL,
  `creation_date` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`primary_key`),
  UNIQUE KEY `primary_key_UNIQUE` (`primary_key`),
  UNIQUE KEY `medicine_name_UNIQUE` (`medicine_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine_reminder`
--

LOCK TABLES `medicine_reminder` WRITE;
/*!40000 ALTER TABLE `medicine_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicine_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (9,'Avleen Singh','Khanuja','avleen.khanuja@gmail.com','avleen','avleen51',NULL,NULL),(10,'Rashmeet Kaur','Khanuja','rashmeet@gmail.com','rashmeet','rashmeetkaur',NULL,NULL),(11,'Rashmeet Kaur','Khanuja','rashmeet@gmail.com','rashmeet','rash22',NULL,NULL),(12,'Pratik','Dhumal','pratik@gmail.com','patrik','patrik',NULL,'6692209136'),(13,'Barkha','Choithani','barkha@gmail.com','barkha','barkhac','2017-11-29',NULL),(14,'aadesh_firstname','aadesh_lastname','aadesh@gmail.com','aadesh123','aadesh','2002-12-03','6692209136'),(15,'ad_firstname','ad_lastname','ad@gmail.com','ad','ad','2017-12-07','6692209136'),(16,'ss','dsfsdf','sdfdsf','abc','abc','2017-12-20','6692209136'),(17,'dsf','dfdsfd','dsfsdf','123','pratik','2017-12-06','6692209136'),(18,'samnfshkfj','djfshkjf','pratikshivaji.dhumal@sjsu.edu','pat','pat','2017-12-13','6692209136'),(19,'skadh','d,sfjnsmf','sdfdsbjn','sdfjsdb','sdfjndsf','2017-12-20','6692209136');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-20 21:00:41
