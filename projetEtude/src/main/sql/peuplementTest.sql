-- Purge
DELETE FROM `calendrier`;
DELETE FROM `evenement`;
DELETE FROM `pole`;
DELETE FROM `commission`;
DELETE FROM `etudiant`;
DELETE FROM `choix`;
DELETE FROM `doubletcalevent`;

-- Calendrier
INSERT INTO `calendrier`(`idCalendrier`,`idEtudiant`,`dateEmission`) VALUES (1,1,'24 février 2014');
INSERT INTO `calendrier`(`idCalendrier`,`idEtudiant`,`dateEmission`) VALUES (2,2,'24 février 2014');
INSERT INTO `calendrier`(`idCalendrier`,`idEtudiant`,`dateEmission`) VALUES (3,3,'24 février 2014');

-- Evenement
INSERT INTO `evenement`(`idEvenement`,`idCommission`,`nomCommission`,`nomPole`,`titreEvent`,`descriptionEvent`,`lieuEvent`,`dateDebut`,`dateFin`,`image`) VALUES (1,1,'La Sauce','BDA','Salon gastronomique','Viens gouter les saveur d Espagne ca va etre trop bon','RR034','2014-02-24 12:00:00','2014-02-24 13:00:00','img/bda.jpg');
INSERT INTO `evenement`(`idEvenement`,`idCommission`,`nomCommission`,`nomPole`,`titreEvent`,`descriptionEvent`,`lieuEvent`,`dateDebut`,`dateFin`,`image`) VALUES (2,2,'Club Rock HEI','BDS','Soiree Rock','Viens danser un rock endiable des 80s','Salle de sport','2014-08-15 19:45:00','2014-08-15 22:00:00','img/rock.jpg');
INSERT INTO `evenement`(`idEvenement`,`idCommission`,`nomCommission`,`nomPole`,`titreEvent`,`descriptionEvent`,`lieuEvent`,`dateDebut`,`dateFin`,`image`) VALUES (3,3,'SolidBear','CapSo','Sauvons la planete','Viens, nous devons sauver la planete','S102','2014-06-26 13-45-00','2014-06-26 15:00:00','img/HEI Logo CapSolidaire.jpg');

-- Commission
INSERT INTO `commission`(`idCommission`,`idEtudiant`,`idPole`,`nomCommission`,`descriptionCom`,`adresseLogo`) VALUES (1,2,1,'La Sauce','Le plaisir de manger entre etudiants','img/bda.jpg');
INSERT INTO `commission`(`idCommission`,`idEtudiant`,`idPole`,`nomCommission`,`descriptionCom`,`adresseLogo`) VALUES (2,3,2,'Club Rock HEI','Cours de danse tous les mercredi soir','img/rock.jpg');
INSERT INTO `commission`(`idCommission`,`idEtudiant`,`idPole`,`nomCommission`,`descriptionCom`,`adresseLogo`) VALUES (3,3,3,'SolidBear','Super association humanitaire','img/CapSolidaire.jpg');
INSERT INTO `commission`(`idCommission`,`idEtudiant`,`idPole`,`nomCommission`,`descriptionCom`,`adresseLogo`) VALUES (4,3,5,'HEIvolution','Association en faveur du developpement durable','img/heivolution.jpg');
INSERT INTO `commission`(`idCommission`,`idEtudiant`,`idPole`,`nomCommission`,`descriptionCom`,`adresseLogo`) VALUES (5,3,4,'Cosmo','Vous aimez voyager? Cette asso est pour vous','img/cosmo.jpg');


-- pole
INSERT INTO `pole`(`idPole`,`nomPole`,`idEtudiant`) VALUES (1,'BDA',1);
INSERT INTO `pole`(`idPole`,`nomPole`,`idEtudiant`) VALUES (2,'BDS',3);
INSERT INTO `pole`(`idPole`,`nomPole`,`idEtudiant`) VALUES (3,'CapSo',1);
INSERT INTO `pole`(`idPole`,`nomPole`,`idEtudiant`) VALUES (4,'PES',3);
INSERT INTO `pole`(`idPole`,`nomPole`,`idEtudiant`) VALUES (5,'PET',1);


-- Etudiant
INSERT INTO `etudiant`(`idEtudiant`,`nomEtudiant`,`prenomEtudiant`,`password`,`email`,`admin`) VALUES (1,'Gladieux','Jean','admin','jean.gladieux@hei.fr',1);
INSERT INTO `etudiant`(`idEtudiant`,`nomEtudiant`,`prenomEtudiant`,`password`,`email`,`admin`) VALUES (2,'Denis','Martin','etudiant','martin.denis@hei.fr',0);
INSERT INTO `etudiant`(`idEtudiant`,`nomEtudiant`,`prenomEtudiant`,`password`,`email`,`admin`) VALUES (3,'Descamps','Stanislas','admin','stanislas.descamps@hei.fr',1);

-- Choix
INSERT INTO `choix`(`idEtudiant`,`idCommission`) VALUES (2,1);
INSERT INTO `choix`(`idEtudiant`,`idCommission`) VALUES (3,2);

-- doubletcalevent
INSERT INTO `doubletcalevent`(`idCalendrier`,`idEvenement`) VALUES (1,1);
INSERT INTO `doubletcalevent`(`idCalendrier`,`idEvenement`) VALUES (1,2);
INSERT INTO `doubletcalevent`(`idCalendrier`,`idEvenement`) VALUES (2,1);
INSERT INTO `doubletcalevent`(`idCalendrier`,`idEvenement`) VALUES (3,2);

