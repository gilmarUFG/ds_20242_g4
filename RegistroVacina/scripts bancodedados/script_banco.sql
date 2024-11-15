DROP DATABASE IF EXISTS calendario_vacinacao;
CREATE DATABASE IF NOT EXISTS  calendario_vacinacao;
USE calendario_vacinacao;

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
);


LOCK TABLES `categoria` WRITE;
INSERT INTO `categoria` VALUES (2,'Criança'),(3,'Adolescente'),(4,'Adulto'),(5,'Idoso'),(6,'Gestante'),(7,'Criança'),(8,'Adolescente'),(9,'Adulto'),(10,'Idoso'),(11,'Gestante'),(12,'Criança'),(13,'Adolescente'),(14,'Adulto'),(15,'Idoso'),(16,'Gestante');
UNLOCK TABLES;

DROP TABLE IF EXISTS `doses`;
CREATE TABLE `doses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantidade_dose` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

LOCK TABLES `doses` WRITE;
INSERT INTO `doses` VALUES (1,'1'),(2,'2'),(3,'3'),(4,'Unica'),(10,'1'),(11,'2'),(12,'3'),(13,'Reforco'),(14,'Unica');
UNLOCK TABLES;

DROP TABLE IF EXISTS `faixa_etaria`;
CREATE TABLE `faixa_etaria` (
  `id` int NOT NULL AUTO_INCREMENT,
  `meses_inicial` int NOT NULL,
  `meses_final` int NOT NULL,
  PRIMARY KEY (`id`)
);

LOCK TABLES `faixa_etaria` WRITE;
INSERT INTO `faixa_etaria` VALUES (1,0,120),(2,120,168),(3,0,120),(4,120,168),(5,216,720),(6,0,120),(7,120,168),(8,216,720);
UNLOCK TABLES;

DROP TABLE IF EXISTS `vacinas`;
CREATE TABLE `vacinas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome_vacina` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
);

LOCK TABLES `vacinas` WRITE;
INSERT INTO `vacinas` VALUES (1,'BCG'),(2,'Hepatite B'),(3,'Difteria '),(4,'Tétano '),(5,'Febre Amarela'),(28,'Hepatite B (recombinante)'),(29,'Haemophilus influenzae B (conjugada)'),(30,'Vacina poliomielite (inativada)'),(31,'Vacina pneumocócica 10-valente (Conjugada)'),(32,'Vacina rotavírus humano G1P1 [8] (atenuada)'),(33,'Vacina meningocócica C'),(34,'Difteria'),(35,' Tétano'),(36,'Pertussis'),(37,'Vacina poliomielite'),(38,'Pneumocócica 10-valente'),(39,'Caxumba'),(40,'Rubéola'),(41,'Tetra viral'),(42,'Hepatite A'),(43,'Febre Amarela (atenuada)'),(44,'Poliomielite 1 e 3 (atenuada)'),(45,'Varicela (monovalente)'),(46,'Febre Amarela (atenuada)'),(47,'Pneumocócica 23-valente - (Pneumo 23)'),(48,'Difteria e Tétano (dT)');
UNLOCK TABLES;

DROP TABLE IF EXISTS `calendario`;

CREATE TABLE `calendario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `categoria_id` int NOT NULL,
  `dose_id` int NOT NULL,
  `faixaetaria_id` int NOT NULL,
  `vacina_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_calendario_categoria` (`categoria_id`),
  KEY `fk_calendario_dose` (`dose_id`),
  KEY `fk_calendario_faixaetaria` (`faixaetaria_id`),
  CONSTRAINT `fk_calendario_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`),
  CONSTRAINT `fk_calendario_dose` FOREIGN KEY (`dose_id`) REFERENCES `doses` (`id`),
  CONSTRAINT `fk_calendario_faixaetaria` FOREIGN KEY (`faixaetaria_id`) REFERENCES `faixa_etaria` (`id`)
);

LOCK TABLES `calendario` WRITE;
INSERT INTO `calendario` VALUES (3,2,4,1,1),(4,2,4,1,2),(5,3,1,2,3),(6,3,2,2,4),(7,3,1,2,4),(23,2,1,2,1),(24,2,2,2,2),(25,2,3,2,3),(26,2,4,2,4);
UNLOCK TABLES;


DROP TABLE IF EXISTS `paciente`;
CREATE TABLE `paciente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  `cpf` char(11) DEFAULT NULL,
  `cartaoSUS` char(15) DEFAULT NULL,
  `tipoComunicacao` enum('email','telefone','sms') DEFAULT NULL,
  `numTelefone` char(11) DEFAULT NULL,
  `eMail` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
);

LOCK TABLES `paciente` WRITE;
INSERT INTO `paciente` VALUES (1,'Bruna','2012-12-20','12345678900','123456789012345','telefone','9090909090','bruna@gmail.com'),(52,'Carlos','1995-05-12','12345678901','123456789012345','telefone','31987654321','carlos@gmail.com'),(53,'Amanda','1988-09-23','98765432109','543210987654321','email','31976543210','amanda@hotmail.com'),(54,'Bruno','1992-02-15','11122233344','111122223333444','telefone','31987451234','bruno@outlook.com'),(55,'Patrícia','1985-07-04','22233344455','555566667777888','email','31998712345','patricia@yahoo.com'),(56,'Mariana','1998-11-10','33344455566','999900001111222','telefone','31999876543','mariana@gmail.com'),(57,'Fernando','1979-08-30','44455566677','222333444555666','telefone','31976549876','fernando@hotmail.com'),(58,'Lucas','2001-04-22','55566677788','777888999000111','email','31987612354','lucas@gmail.com'),(59,'Gabriela','1990-06-18','66677788899','444555666777888','telefone','31999874321','gabriela@outlook.com'),(60,'Ricardo','1994-12-01','77788899900','333444555666777','email','31976541234','ricardo@yahoo.com'),(61,'Juliana','1983-03-09','88899900011','666777888999000','sms','31987654322','juliana@gmail.com');
UNLOCK TABLES;

DROP TABLE IF EXISTS `historico_vacina`;
CREATE TABLE `historico_vacina` (
  `id` int NOT NULL AUTO_INCREMENT,
  `paciente_id` int NOT NULL,
  `vacina_id` int NOT NULL,
  `dose_id` int NOT NULL,
  `data_vacinacao` date DEFAULT NULL,
  `lote_vacinacao` char(5) DEFAULT NULL,
  `ano_vencimento` year DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_historico_vacina_paciente` (`paciente_id`),
  KEY `fk_historico_vacina_doses` (`dose_id`),
  KEY `fk_historico_vacina` (`vacina_id`),
  CONSTRAINT `fk_historico_vacina` FOREIGN KEY (`vacina_id`) REFERENCES `vacinas` (`id`),
  CONSTRAINT `fk_historico_vacina_doses` FOREIGN KEY (`dose_id`) REFERENCES `doses` (`id`),
  CONSTRAINT `fk_historico_vacina_paciente` FOREIGN KEY (`paciente_id`) REFERENCES `paciente` (`id`)
);

LOCK TABLES `historico_vacina` WRITE;
INSERT INTO `historico_vacina` VALUES (1,1,1,1,'2000-06-01','AABB5',2013),(2,1,2,2,'2008-10-13','BBUU6',2014),(3,1,2,1,'2000-06-01','AAYY5',2013),(4,1,1,1,'2000-12-01','7890Y',2023),(13,1,1,1,'2000-12-01','7890Y',2025),(14,1,2,2,'2000-05-04','UUII4',2026),(15,52,3,3,'2000-06-05','KHJL5',2020),(16,52,5,4,'2000-07-06','7890B',2019);
UNLOCK TABLES;

DROP TABLE IF EXISTS `cargo`;

CREATE TABLE `cargo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nomeCargo` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

LOCK TABLES `cargo` WRITE;
INSERT INTO `cargo` VALUES (1,'Infermeira'),(2,'Agente de Saúde');
UNLOCK TABLES;

DROP TABLE IF EXISTS `profissional`;
CREATE TABLE `profissional` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  `cpf` char(11) DEFAULT NULL,
  `cargo_id` int NOT NULL,
  `senha` char(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_profissional_cargo` (`cargo_id`),
  CONSTRAINT `fk_profissional_cargo` FOREIGN KEY (`cargo_id`) REFERENCES `cargo` (`id`)
);

LOCK TABLES `profissional` WRITE;
INSERT INTO `profissional` VALUES (1,'Thayliny','2000-02-23','12345678977',2,'1234567G');
UNLOCK TABLES;
