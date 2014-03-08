-- Purge
DELETE FROM `calendrier`;
DELETE FROM `evenement`;
DELETE FROM `pole`;
DELETE FROM `commission`;
DELETE FROM `etudiant`;
DELETE FROM `choix`;
DELETE FROM `doubletcalevent`;

-- Calendrier
INSERT INTO `calendrier`(`idCalendrier`,`idEtudiant`,`dateEmission`) VALUES (1,1,'2014-02-24');
INSERT INTO `calendrier`(`idCalendrier`,`idEtudiant`,`dateEmission`) VALUES (2,2,'2014-02-24');
INSERT INTO `calendrier`(`idCalendrier`,`idEtudiant`,`dateEmission`) VALUES (3,3,'2014-02-24');

-- Evenement
INSERT INTO `evenement`(`idEvenement`,`idCommission`,`titreEvent`,`dateEvent`,`descriptionEvent`,`lieuEvent`,`heureDebut`,`heureFin`) VALUES (1,1,'Salon gastronomique','2014-02-24','Viens gouter les saveur d Espagne ça va être trop bon','RR034','12:00','13:00');
INSERT INTO `evenement`(`idEvenement`,`idCommission`,`titreEvent`,`dateEvent`,`descriptionEvent`,`lieuEvent`,`heureDebut`,`heureFin`) VALUES (2,2,'Soirée Rock','2014-02-26','Viens danser un rock endiablé des 80s','Salle de sport','19:45','22:00');

-- Commission
INSERT INTO `commission`(`idCommission`,`idEtudiant`,`idPole`,`nomCommission`,`descriptionCom`,`adresseLogo`) VALUES (1,2,1,'La Sauce','Le plaisir de manger entre étudiants','img/bda.jpg');
INSERT INTO `commission`(`idCommission`,`idEtudiant`,`idPole`,`nomCommission`,`descriptionCom`,`adresseLogo`) VALUES (2,3,2,'Club Rock HEI','Cours de danse tous les mercredi soir','img/rock.jpg');

-- pole
INSERT INTO `pole`(`idPole`,`nomPole`,`idEtudiant`) VALUES (1,'BDA',1);
INSERT INTO `pole`(`idPole`,`nomPole`,`idEtudiant`) VALUES (2,'BDS',3);

-- Etudiant
INSERT INTO `etudiant`(`idEtudiant`,`nomEtudiant`,`prenomEtudiant`,`password`,`email`,`admin`) VALUES (1,'Gladieux','Jean','hflz9klv5','jean.gladieux@hei.fr',1);
INSERT INTO `etudiant`(`idEtudiant`,`nomEtudiant`,`prenomEtudiant`,`password`,`email`,`admin`) VALUES (2,'Denis','Martin','se4grt3c','martin.denis@hei.fr',0);
INSERT INTO `etudiant`(`idEtudiant`,`nomEtudiant`,`prenomEtudiant`,`password`,`email`,`admin`) VALUES (3,'Descamps','Stanislas','scd74jf','stanislas.descamps@hei.fr',1);

-- Choix
INSERT INTO `choix`(`idEtudiant`,`idCommission`) VALUES (2,1);
INSERT INTO `choix`(`idEtudiant`,`idCommission`) VALUES (3,2);

-- doubletcalevent
INSERT INTO `doubletcalevent`(`idCalendrier`,`idEvenement`) VALUES (1,1);
INSERT INTO `doubletcalevent`(`idCalendrier`,`idEvenement`) VALUES (1,2);
INSERT INTO `doubletcalevent`(`idCalendrier`,`idEvenement`) VALUES (2,1);
INSERT INTO `doubletcalevent`(`idCalendrier`,`idEvenement`) VALUES (3,2);

