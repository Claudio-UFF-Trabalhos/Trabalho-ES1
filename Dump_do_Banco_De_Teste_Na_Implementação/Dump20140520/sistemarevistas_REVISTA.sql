CREATE DATABASE  IF NOT EXISTS `sistemarevistas` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sistemarevistas`;
-- MySQL dump 10.13  Distrib 5.5.37, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: sistemarevistas
-- ------------------------------------------------------
-- Server version	5.5.37-0ubuntu0.12.10.1

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
-- Table structure for table `REVISTA`
--

DROP TABLE IF EXISTS `REVISTA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `REVISTA` (
  `CD_REVISTA` bigint(20) NOT NULL AUTO_INCREMENT,
  `NM_NOME` varchar(255) NOT NULL,
  `BO_TEM_DIGITAL` tinyint(1) NOT NULL,
  `NR_PRECO_DE` decimal(11,2) NOT NULL,
  `NR_PRECO_POR` decimal(11,2) NOT NULL,
  `BO_ESTA_DELETADO` tinyint(1) NOT NULL,
  `NM_DESCRICAO` varchar(255) DEFAULT NULL,
  `NM_TEMA` varchar(255) NOT NULL,
  PRIMARY KEY (`CD_REVISTA`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REVISTA`
--

LOCK TABLES `REVISTA` WRITE;
/*!40000 ALTER TABLE `REVISTA` DISABLE KEYS */;
INSERT INTO `REVISTA` VALUES (7,'Revista 1',1,12.00,11.00,0,'Revista sobre informática','Informática'),(8,'Revista 2',0,99.00,85.00,0,'Revista sobre biologia','Biologia'),(9,'Revista 3',1,86.00,83.00,0,'Revista sobre informática','Informática'),(10,'Revista 3',0,78.00,76.00,0,'Revista sobre química','Química'),(11,'Revista 4',1,15.00,10.00,1,'Revista sobre química','Química'),(12,'Revista 4',1,89.99,85.00,1,'Revista sobre informática.','Informática'),(13,'Revista 5',0,60.00,55.00,1,'Revista sobre astronomia.','Astronomia'),(14,'Revista 6',1,50.00,45.00,1,'Revista sobre física.','Física'),(17,'Revista 7',0,80.00,78.00,0,'Revista sobre jogos.','Jogos'),(18,'Revista 7',0,50.00,45.00,0,'Revista sobre informática.','Informática');
/*!40000 ALTER TABLE `REVISTA` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-20 23:26:24
