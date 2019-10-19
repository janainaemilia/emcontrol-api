CREATE DATABASE  IF NOT EXISTS `db_emcontrol` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_emcontrol`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_emcontrol
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.35-MariaDB

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
-- Table structure for table `tb_avaliacao`
--

DROP TABLE IF EXISTS `tb_avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_avaliacao` (
  `ID_AVALIACAO` int(11) NOT NULL AUTO_INCREMENT,
  `AVALIACAO` varchar(500) DEFAULT NULL,
  `NOTA` smallint(6) NOT NULL,
  `ID_EQUIPAMENTO` int(11) NOT NULL,
  `ID_USUARIO` int(11) NOT NULL,
  PRIMARY KEY (`ID_AVALIACAO`,`ID_EQUIPAMENTO`,`ID_USUARIO`),
  KEY `fk_TB_AVALIACAO_TB_EQUIPAMENTO1_idx` (`ID_EQUIPAMENTO`),
  KEY `fk_TB_AVALIACAO_TB_USUARIO1_idx` (`ID_USUARIO`),
  CONSTRAINT `FK1usoqi3kkg0dwxnm05ex1ao4x` FOREIGN KEY (`ID_USUARIO`) REFERENCES `tb_usuario` (`ID_USUARIO`),
  CONSTRAINT `FKr895y2guorpduqqb5evb942bp` FOREIGN KEY (`ID_EQUIPAMENTO`) REFERENCES `tb_equipamento` (`ID_EQUIPAMENTO`),
  CONSTRAINT `fk_TB_AVALIACAO_TB_EQUIPAMENTO1` FOREIGN KEY (`ID_EQUIPAMENTO`) REFERENCES `tb_equipamento` (`ID_EQUIPAMENTO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TB_AVALIACAO_TB_USUARIO1` FOREIGN KEY (`ID_USUARIO`) REFERENCES `tb_usuario` (`ID_USUARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_avaliacao`
--

LOCK TABLES `tb_avaliacao` WRITE;
/*!40000 ALTER TABLE `tb_avaliacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_categoria`
--

DROP TABLE IF EXISTS `tb_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_categoria` (
  `ID_CATEGORIA` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(45) NOT NULL,
  `ID_CATEGORIA_PAI` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_CATEGORIA`),
  KEY `fk_TB_CATEGORIA_EQUIP_TB_CATEGORIA_EQUIP1_idx` (`ID_CATEGORIA_PAI`),
  CONSTRAINT `FK6q5fwm2ug0uxvqjpjrq2ugdes` FOREIGN KEY (`ID_CATEGORIA_PAI`) REFERENCES `tb_categoria` (`ID_CATEGORIA`),
  CONSTRAINT `fk_TB_CATEGORIA_EQUIP_TB_CATEGORIA_EQUIP1` FOREIGN KEY (`ID_CATEGORIA_PAI`) REFERENCES `tb_categoria` (`ID_CATEGORIA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_categoria`
--

LOCK TABLES `tb_categoria` WRITE;
/*!40000 ALTER TABLE `tb_categoria` DISABLE KEYS */;
INSERT INTO `tb_categoria` VALUES (1,'Automóveis',NULL),(2,'Móveis',NULL),(3,'Eletrodomésticos',NULL),(4,'Eletrônicos e Celulares',NULL),(5,'Instrumentos Musicais',NULL),(6,'Esporte',NULL),(7,'Máquinas',NULL),(10,'Carro',1),(11,'Moto',1),(12,'Geladeira',3),(13,'Liquidificador',3),(14,'Forno',3);
/*!40000 ALTER TABLE `tb_categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_cliente` (
  `ID_CLIENTE` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(45) NOT NULL,
  `BAIRRO` varchar(45) DEFAULT NULL,
  `ESTADO` varchar(45) NOT NULL,
  `CIDADE` varchar(45) NOT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `TIPO` varchar(2) NOT NULL,
  `ID_USUARIO` int(11) NOT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_CLIENTE`,`ID_USUARIO`),
  KEY `fk_TB_CLIENTE_TB_USUARIO1_idx` (`ID_USUARIO`),
  CONSTRAINT `FKl9x5a3k58uh7f6ofdt3ih2ngr` FOREIGN KEY (`ID_USUARIO`) REFERENCES `tb_usuario` (`ID_USUARIO`),
  CONSTRAINT `fk_TB_CLIENTE_TB_USUARIO1` FOREIGN KEY (`ID_USUARIO`) REFERENCES `tb_usuario` (`ID_USUARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cliente`
--

LOCK TABLES `tb_cliente` WRITE;
/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
INSERT INTO `tb_cliente` VALUES (1,'Teste','Teste','TS','Teste','teste@teste.com','PF',1,NULL),(3,'Teste2','Teste2','TS2','Teste2','teste2@teste.com','PJ',2,NULL);
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_equip_usua`
--

DROP TABLE IF EXISTS `tb_equip_usua`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_equip_usua` (
  `ID_EQUIP_USUA` int(11) NOT NULL AUTO_INCREMENT,
  `ID_EQUIPAMENTO` int(11) NOT NULL,
  `ID_USUARIO` int(11) NOT NULL,
  `NUM_PATRIMONIO` varchar(30) NOT NULL,
  `DT_AQUISICAO` date DEFAULT NULL,
  PRIMARY KEY (`ID_EQUIP_USUA`,`ID_EQUIPAMENTO`,`ID_USUARIO`),
  UNIQUE KEY `NUM_PATRIMONIO_UNIQUE` (`NUM_PATRIMONIO`),
  KEY `fk_TB_EQUIP_has_TB_USUARIO_TB_USUARIO1_idx` (`ID_USUARIO`),
  KEY `fk_TB_EQUIP_USUA_TB_EQUIPAMENTO1_idx` (`ID_EQUIPAMENTO`),
  CONSTRAINT `FKcsauifla602x6dnnchmo3cs81` FOREIGN KEY (`ID_USUARIO`) REFERENCES `tb_usuario` (`ID_USUARIO`),
  CONSTRAINT `FKhyklx4yrgh471iv7mv1da1tam` FOREIGN KEY (`ID_EQUIPAMENTO`) REFERENCES `tb_equipamento` (`ID_EQUIPAMENTO`),
  CONSTRAINT `fk_TB_EQUIP_USUA_TB_EQUIPAMENTO1` FOREIGN KEY (`ID_EQUIPAMENTO`) REFERENCES `tb_equipamento` (`ID_EQUIPAMENTO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TB_EQUIP_has_TB_USUARIO_TB_USUARIO1` FOREIGN KEY (`ID_USUARIO`) REFERENCES `tb_usuario` (`ID_USUARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_equip_usua`
--

LOCK TABLES `tb_equip_usua` WRITE;
/*!40000 ALTER TABLE `tb_equip_usua` DISABLE KEYS */;
INSERT INTO `tb_equip_usua` VALUES (4,8,1,'123456','2019-05-17'),(6,10,1,'12345678','2019-05-17'),(7,11,1,'123456789','2019-05-17'),(8,13,1,'151616415156165','2019-12-14'),(9,14,1,'156151891979156','2019-05-17'),(10,15,1,'1236547852146','2017-02-19'),(11,16,1,'651515619749716','2019-05-17'),(12,17,1,'5161891891','2018-02-14'),(14,19,1,'5161891891189498189','2018-02-14'),(16,21,1,'12983828737828','2018-02-14'),(17,22,1,'192939495969798999','2019-05-17'),(18,23,1,'132333435363738393','2018-02-14'),(19,25,1,'1424344454','2019-05-19'),(20,26,1,'152535455556','2016-05-19'),(21,27,1,'182838485868','2018-05-19'),(22,28,1,'1828384858689','2018-05-19'),(23,29,1,'18283848586878','2018-02-19'),(24,30,1,'5165156179819','2018-05-19'),(25,31,1,'1894496513','2016-02-14'),(26,32,1,'56561566748948984','2018-05-19'),(27,34,1,'61626364656262646','2018-05-19'),(28,35,1,'14845461132154788','2016-05-19'),(29,36,1,'5189848943982418934','2016-06-02'),(30,37,1,'49841818138921191','2019-05-05'),(31,38,1,'1989818914184144','2019-02-01'),(32,39,1,'1918918913389198','2017-06-04'),(33,40,1,'161651548554894','2018-08-05'),(34,41,1,'2616156156335616','2018-06-04'),(35,42,1,'516515611131321','2018-03-01'),(36,43,1,'89189191891831219','2019-05-23'),(37,44,1,'91911494431429841','2019-05-23'),(38,45,1,'456456465465426152','2019-03-01'),(39,46,1,'16156121152116','2019-05-19'),(40,47,1,'15621151235643','2018-06-19'),(41,48,1,'165156112653116211','2018-06-25');
/*!40000 ALTER TABLE `tb_equip_usua` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_equipamento`
--

DROP TABLE IF EXISTS `tb_equipamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_equipamento` (
  `ID_EQUIPAMENTO` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(100) NOT NULL,
  `MODELO` varchar(45) NOT NULL,
  `MARCA` varchar(45) NOT NULL,
  `ANO_FABRICACAO` smallint(6) DEFAULT NULL,
  `ID_CATEGORIA` int(11) NOT NULL,
  PRIMARY KEY (`ID_EQUIPAMENTO`,`ID_CATEGORIA`),
  KEY `fk_TB_EQUIPAMENTO_TB_CATEGORIA_EQUIP1_idx` (`ID_CATEGORIA`),
  CONSTRAINT `FK87ddcbd8ro7ewtypumn2idd0c` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `tb_categoria` (`ID_CATEGORIA`),
  CONSTRAINT `fk_TB_EQUIPAMENTO_TB_CATEGORIA_EQUIP1` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `tb_categoria` (`ID_CATEGORIA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_equipamento`
--

LOCK TABLES `tb_equipamento` WRITE;
/*!40000 ALTER TABLE `tb_equipamento` DISABLE KEYS */;
INSERT INTO `tb_equipamento` VALUES (8,'Teste A','Teste A','Teste A',0,1),(10,'Teste B','Teste B','Teste B',0,1),(11,'Teste C','Teste C','Teste C',0,1),(12,'Teste D','Teste D','Teste D',0,1),(13,'A','A','A',0,1),(14,'B','B','B',0,1),(15,'Equipamento Teste','Modelo Teste','Marca Teste',0,1),(16,'TESTE','TESTE','TESTE',0,1),(17,'fioanfioa','niasidio','ninsdaoin',0,1),(18,'fioanfioa','niasidio','ninsdaoin',0,1),(19,'fioanfioa','niasidio','ninsdaoin',0,1),(20,'fioanfioa','niasidio','ninsdaoin',0,1),(21,'Teste','Teste','Teste',0,1),(22,'Teste','Teste','Teste',0,1),(23,'ETeste','ETeste','ETeste',0,3),(24,'Notebook Asus','Asus','Asus',0,4),(25,'Teste','Teste','Teste',0,4),(26,'Teste','Teste','Teste',0,1),(27,'Celular Zenfone 3 Max','Zenfone 3 Max 5.5\"','Asus',0,4),(28,'Celular Zenfone 3 Max','Zenfone 3 Max 5.5\"','Asus',0,4),(29,'Celular Zenfone 3 Max','Zenfone 3 Max 5.5','Asus',0,4),(30,'Teste','Teste','Teste',0,10),(31,'Geladeira Eletrolux Branca','Eletrolux','Eletrolux',0,3),(32,'Carro Fiat Uno 2018','Fiat Uno','Fiat',0,10),(33,'Carro Fiat Uno','Uno','Fiat',0,10),(34,'Carro Fiat Uno','Uno','Fiat',0,10),(35,'Liquidificador Eletrolux','Teste','Eletrolux',0,3),(36,'Teste','Teste','Teste',0,11),(37,'Celular Zenfone 4 Max','Zenfone 4 Max 5.5\"','Asus',0,4),(38,'Celular Zenfone 3 Max 5.5\"','Zenfone 3 Max 5.5\"','Asus',0,4),(39,'Celuar Zenfone 3','Zenfone 3','Asus',0,4),(40,'Celular Zenfone 4 Max 5.2\"','Zenfone 4 Max 5.2\"','Asus',0,4),(41,'Celular Zenfone 3 Max 5.2','Zenfone 3 Max 5.2\"','Asus',0,4),(42,'Celuar Zenfone 3 Max 5.2\"','Zenfone 3 Max 5.2\"','Asus',0,4),(43,'Geladeira Electrolux DFN41 Frost Free Duplex 371 Litros Painel Blue Touch','DFN41 Frost Free Duplex','Electrolux ',0,12),(44,'Geladeira Electrolux DFN41 Frost Free Duplex 371 Litros Painel Blue Touch',' DFN41 Frost Free Duplex','Electrolux ',0,12),(45,'Forno Elétrico Electrolux','Embutir 80L Inox','Electrolux',0,14),(46,'Liquidificador Philco PH900 Preto com FIltro','PH900 Preto com FIltro','Philco',0,13),(47,'Liquidificador Philco','Liquidificador','Philco',0,13),(48,'Liquidificador Philco ','Teste','Philco',0,13);
/*!40000 ALTER TABLE `tb_equipamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_imagem`
--

DROP TABLE IF EXISTS `tb_imagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_imagem` (
  `id_imagem` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `id_equipamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_imagem`),
  KEY `FKpin9y0by00ydrefj30emkpfn0` (`id_equipamento`),
  CONSTRAINT `FKpin9y0by00ydrefj30emkpfn0` FOREIGN KEY (`id_equipamento`) REFERENCES `tb_equipamento` (`ID_EQUIPAMENTO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_imagem`
--

LOCK TABLES `tb_imagem` WRITE;
/*!40000 ALTER TABLE `tb_imagem` DISABLE KEYS */;
INSERT INTO `tb_imagem` VALUES (1,'1558734940068.jpg',48);
/*!40000 ALTER TABLE `tb_imagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_manutencao`
--

DROP TABLE IF EXISTS `tb_manutencao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_manutencao` (
  `ID_MANUTENCAO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_EQUIP_USUA` int(11) NOT NULL,
  `ID_TIPO_SERVICO` int(11) NOT NULL,
  `DESCRICAO` varchar(300) NOT NULL,
  `DATA` date NOT NULL,
  `VALOR` decimal(10,0) NOT NULL,
  `PROVEDOR_SERVICO` varchar(45) NOT NULL,
  `GARANTIA` int(11) NOT NULL,
  `NOTA_FISCAL` blob,
  `PREVISAO` date DEFAULT NULL,
  PRIMARY KEY (`ID_MANUTENCAO`,`ID_EQUIP_USUA`,`ID_TIPO_SERVICO`),
  KEY `fk_TB_MANUTENCOES_TB_EQUIP_USUA1_idx` (`ID_EQUIP_USUA`),
  KEY `fk_TB_MANUTENCCAO_TB_TIPO_SERVICO1_idx` (`ID_TIPO_SERVICO`),
  CONSTRAINT `FK3lu3wvmgs2q9f6tfqpg58uqc5` FOREIGN KEY (`ID_TIPO_SERVICO`) REFERENCES `tb_tipo_servico` (`ID_TIPO_SERVICO`),
  CONSTRAINT `FKmb3ybxhhrf3027yly1hn4b605` FOREIGN KEY (`ID_EQUIP_USUA`) REFERENCES `tb_equip_usua` (`ID_EQUIP_USUA`),
  CONSTRAINT `fk_TB_MANUTENCCAO_TB_TIPO_SERVICO1` FOREIGN KEY (`ID_TIPO_SERVICO`) REFERENCES `tb_tipo_servico` (`ID_TIPO_SERVICO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TB_MANUTENCOES_TB_EQUIP_USUA1` FOREIGN KEY (`ID_EQUIP_USUA`) REFERENCES `tb_equip_usua` (`ID_EQUIP_USUA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_manutencao`
--

LOCK TABLES `tb_manutencao` WRITE;
/*!40000 ALTER TABLE `tb_manutencao` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_manutencao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pessoa_fisica`
--

DROP TABLE IF EXISTS `tb_pessoa_fisica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_pessoa_fisica` (
  `ID_PESSOA_FISICA` int(11) NOT NULL AUTO_INCREMENT,
  `SEXO` varchar(20) DEFAULT NULL,
  `DT_NASCIMENTO` date NOT NULL,
  `CARGO` varchar(45) DEFAULT NULL,
  `ID_PESSOA_JURIDICA` int(11) DEFAULT NULL,
  `CPF` varchar(20) NOT NULL,
  `ID_CLIENTE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_PESSOA_FISICA`),
  UNIQUE KEY `CPF_UNIQUE` (`CPF`),
  KEY `fk_TB_PESSOA_FISICA_TB_PESSOA_JURIDICA1_idx` (`ID_PESSOA_JURIDICA`),
  KEY `fk_TB_PESSOA_FISICA_TB_CLIENTE1_idx` (`ID_CLIENTE`),
  CONSTRAINT `FKfdm07n0fogcfxvbxrabgiiobv` FOREIGN KEY (`ID_PESSOA_JURIDICA`) REFERENCES `tb_pessoa_juridica` (`ID_PESSOA_JURIDICA`),
  CONSTRAINT `FKr3q2w4mftg7cd4d56a279v8xp` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `tb_cliente` (`ID_CLIENTE`),
  CONSTRAINT `fk_TB_PESSOA_FISICA_TB_CLIENTE1` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `tb_cliente` (`ID_CLIENTE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TB_PESSOA_FISICA_TB_PESSOA_JURIDICA1` FOREIGN KEY (`ID_PESSOA_JURIDICA`) REFERENCES `tb_pessoa_juridica` (`ID_PESSOA_JURIDICA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pessoa_fisica`
--

LOCK TABLES `tb_pessoa_fisica` WRITE;
/*!40000 ALTER TABLE `tb_pessoa_fisica` DISABLE KEYS */;
INSERT INTO `tb_pessoa_fisica` VALUES (1,'F','1997-03-04','Gestor de Equipamentos',NULL,'44478486867',1);
/*!40000 ALTER TABLE `tb_pessoa_fisica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pessoa_juridica`
--

DROP TABLE IF EXISTS `tb_pessoa_juridica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_pessoa_juridica` (
  `ID_PESSOA_JURIDICA` int(11) NOT NULL AUTO_INCREMENT,
  `RAZAO_SOCIAL` varchar(100) NOT NULL,
  `CNPJ_VALUE` varchar(25) DEFAULT NULL,
  `RAMO` varchar(45) DEFAULT NULL,
  `ID_CLIENTE` int(11) NOT NULL,
  PRIMARY KEY (`ID_PESSOA_JURIDICA`,`ID_CLIENTE`),
  UNIQUE KEY `CNJP_UNIQUE` (`CNPJ_VALUE`),
  KEY `fk_TB_PESSOA_JURIDICA_TB_CLIENTE1_idx` (`ID_CLIENTE`),
  CONSTRAINT `FKo731xrpi3n6w8hec7oteentwy` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `tb_cliente` (`ID_CLIENTE`),
  CONSTRAINT `fk_TB_PESSOA_JURIDICA_TB_CLIENTE1` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `tb_cliente` (`ID_CLIENTE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pessoa_juridica`
--

LOCK TABLES `tb_pessoa_juridica` WRITE;
/*!40000 ALTER TABLE `tb_pessoa_juridica` DISABLE KEYS */;
INSERT INTO `tb_pessoa_juridica` VALUES (1,'Teste','02071724000151','Teste',3);
/*!40000 ALTER TABLE `tb_pessoa_juridica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo_servico`
--

DROP TABLE IF EXISTS `tb_tipo_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tipo_servico` (
  `ID_TIPO_SERVICO` int(11) NOT NULL AUTO_INCREMENT,
  `DESC_SERVICO` varchar(60) NOT NULL,
  PRIMARY KEY (`ID_TIPO_SERVICO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo_servico`
--

LOCK TABLES `tb_tipo_servico` WRITE;
/*!40000 ALTER TABLE `tb_tipo_servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_tipo_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_usuario` (
  `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `LOGIN` varchar(45) NOT NULL,
  `SENHA` varchar(10) NOT NULL,
  PRIMARY KEY (`ID_USUARIO`),
  UNIQUE KEY `LOGIN_UNIQUE` (`LOGIN`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,'user1','123'),(2,'user2','123');
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-24 20:39:12
