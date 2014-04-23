DROP TABLE `choix`;
DROP TABLE `doubletcalevent`;
DROP TABLE `evenement`;
DROP TABLE `commission`;
DROP TABLE `pole`;
DROP TABLE `calendrier`;
DROP TABLE `etudiant`;


CREATE TABLE `calendrier` (
  `idCalendrier` int(11) NOT NULL AUTO_INCREMENT,
  `idEtudiant` int(11) NOT NULL,
  `dateEmission` varchar(20) NOT NULL,
  PRIMARY KEY (`idCalendrier`),
  KEY `idEtudiant`(`idEtudiant`)
) CHARSET=utf8;

CREATE TABLE `evenement` (
  `idEvenement` int(11) NOT NULL AUTO_INCREMENT,
  `idCommission` int(11) NOT NULL,
  `nomCommission` varchar(30) NOT NULL,
  `nomPole` varchar(30) NOT NULL,
  `titreEvent` varchar(30) NOT NULL,
  `descriptionEvent` varchar(100) NOT NULL,
  `lieuEvent` varchar(30) NOT NULL,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `image` varchar(50) NOT NULL,
  PRIMARY KEY (`idEvenement`),
  KEY `idCommission`(`idCommission`)
) CHARSET=utf8;

CREATE TABLE `pole` (
  `idPole` int(11) NOT NULL AUTO_INCREMENT,
  `nomPole` varchar(30) NOT NULL,
  `idEtudiant` int(11) NOT NULL,
  PRIMARY KEY (`idPole`),
  KEY `idEtudiant`(`idEtudiant`)
) CHARSET=utf8;

CREATE TABLE `commission` (
  `idCommission` int(11) NOT NULL AUTO_INCREMENT,
  `idEtudiant` int(11) NOT NULL,
  `idPole` int(11) NOT NULL,
  `nomCommission` varchar(30) NOT NULL,
  `descriptionCom` varchar(300) NOT NULL,
  `adresseLogo` varchar(50) NOT NULL,
  PRIMARY KEY (`idCommission`),
  KEY `idEtudiant` (`idEtudiant`),
  KEY `idPole` (`idPole`)
) CHARSET=utf8;

CREATE TABLE `etudiant` (
  `idEtudiant` int(11) NOT NULL AUTO_INCREMENT,
  `nomEtudiant` varchar(30) NOT NULL,
  `prenomEtudiant` varchar(30) NOT NULL,
  `password` varchar(8) NOT NULL,
  `email` varchar(45) NOT NULL,
  `admin` tinyint(1) NOT NULL,
  PRIMARY KEY (`idEtudiant`)
) CHARSET=utf8;

CREATE TABLE `choix` (
  `idEtudiant` int(11) NOT NULL,
  `idCommission` int(11) NOT NULL,
  PRIMARY KEY (`idEtudiant`,`idCommission`),
  KEY `idEtudiant_fk` (`idEtudiant`),
  KEY `idCommission_fk` (`idCommission`)
) CHARSET=utf8;

CREATE TABLE `doubletcalevent` (
  `idCalendrier` int(11) NOT NULL,
  `idEvenement` int(11) NOT NULL,
  PRIMARY KEY (`idCalendrier`,`idEvenement`),
  KEY `idCalendrier_fk` (`idCalendrier`),
  KEY `idEvenement_fk` (`idEvenement`)
) CHARSET=utf8;