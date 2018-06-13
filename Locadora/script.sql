CREATE DATABASE  IF NOT EXISTS `locadora` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `locadora`;

DROP TABLE IF EXISTS `genero`;
CREATE TABLE `genero` (
  `genero_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `genero_NOME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`genero_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `dvd`;
CREATE TABLE `dvd` (
  `dvd_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `dvd_ANO` date NOT NULL,
  `dvd_FAIXA_ETARIA` int(11) NOT NULL,
  `dvd_PRECO` double NOT NULL,
  `dvd_TITULO` varchar(20) NOT NULL,
  `genero_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`dvd_ID`),
  KEY `FK109F2A18DB0F5` (`genero_ID`),
  CONSTRAINT `FK109F2A18DB0F5` FOREIGN KEY (`genero_ID`) REFERENCES `genero` (`genero_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

teste