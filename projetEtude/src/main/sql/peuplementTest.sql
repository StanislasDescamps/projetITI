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
INSERT INTO `calendrier`(`idCalendrier`,`idEtudiant`,`dateEmission`) VALUES (2,2,'2014-04-12');
INSERT INTO `calendrier`(`idCalendrier`,`idEtudiant`,`dateEmission`) VALUES (3,3,'2014-04-26');
INSERT INTO `calendrier`(`idCalendrier`,`idEtudiant`,`dateEmission`) VALUES (4,4,'2014-05-10');


-- Evenement
INSERT INTO `evenement`(`idEvenement`,`idCommission`,`nomCommission`,`nomPole`,`titreEvent`,`descriptionEvent`,`lieuEvent`,`dateDebut`,`dateFin`,`heureDebut`,`heureFin`,`image`) VALUES (1,1,'La Sauce','BDA','Salon gastronomique','Viens gouter les saveur d Espagne ca va etre trop bon','RR034','2014-05-24','2014-05-24',' 12:00:00','13:00:00','img/bda.jpg');
INSERT INTO `evenement`(`idEvenement`,`idCommission`,`nomCommission`,`nomPole`,`titreEvent`,`descriptionEvent`,`lieuEvent`,`dateDebut`,`dateFin`,`heureDebut`,`heureFin`,`image`) VALUES (2,3,'SolidBear','CapSo','Sauvons la planete','Viens, nous devons sauver la planete','S102','2014-06-12','2014-06-12',' 12:00:00','13:00:00','img/CapSolidaire.jpg');
INSERT INTO `evenement`(`idEvenement`,`idCommission`,`nomCommission`,`nomPole`,`titreEvent`,`descriptionEvent`,`lieuEvent`,`dateDebut`,`dateFin`,`heureDebut`,`heureFin`,`image`) VALUES (3,2,'Club Rock HEI','BDS','Soiree Rock','Viens danser un rock endiable des 80s','Salle de sport','2014-06-30','2014-06-30',' 19:45:00','22:00:00','img/rock.jpg');
INSERT INTO `evenement`(`idEvenement`,`idCommission`,`nomCommission`,`nomPole`,`titreEvent`,`descriptionEvent`,`lieuEvent`,`dateDebut`,`dateFin`,`heureDebut`,`heureFin`,`image`) VALUES (4,5,'Cosmo','PES','Visitons le monde','Nous allons te faire tourner autour du monde','RR120','2014-07-03','2014-07-03',' 12:00:00','13:00:00','img/cosmo.jpg');
INSERT INTO `evenement`(`idEvenement`,`idCommission`,`nomCommission`,`nomPole`,`titreEvent`,`descriptionEvent`,`lieuEvent`,`dateDebut`,`dateFin`,`heureDebut`,`heureFin`,`image`) VALUES (5,4,'HEIvolution','PET','Une eolienne a HEI','Participe au nouveau challenge de HEI, creons une eolienne dans nos batiment','J001','2014-08-15','2014-08-15',' 08:30:00','17:30:00','img/heivolution.jpg');


-- Commission
INSERT INTO `commission`(`idCommission`,`idEtudiant`,`idPole`,`nomCommission`,`descriptionCom`,`adresseLogo`) VALUES (1,2,1,'La Sauce','Le plaisir de manger entre etudiants','img/bda.jpg');
INSERT INTO `commission`(`idCommission`,`idEtudiant`,`idPole`,`nomCommission`,`descriptionCom`,`adresseLogo`) VALUES (2,3,2,'Club Rock HEI','Cours de danse tous les mercredi soir','img/rock.jpg');
INSERT INTO `commission`(`idCommission`,`idEtudiant`,`idPole`,`nomCommission`,`descriptionCom`,`adresseLogo`) VALUES (3,1,3,'SolidBear','Super association humanitaire','img/CapSolidaire.jpg');
INSERT INTO `commission`(`idCommission`,`idEtudiant`,`idPole`,`nomCommission`,`descriptionCom`,`adresseLogo`) VALUES (5,4,4,'Cosmo','Vous aimez voyager? Cette asso est pour vous','img/cosmo.jpg');
INSERT INTO `commission`(`idCommission`,`idEtudiant`,`idPole`,`nomCommission`,`descriptionCom`,`adresseLogo`) VALUES (4,3,5,'HEIvolution','Association en faveur du developpement durable','img/heivolution.jpg');



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
INSERT INTO `etudiant`(`idEtudiant`,`nomEtudiant`,`prenomEtudiant`,`password`,`email`,`admin`) VALUES (4,'Merchez','Nicolas','admin','nicolas.merchez@hei.fr',1);

-- Choix
INSERT INTO `choix`(`idEtudiant`,`idCommission`) VALUES (2,1);
INSERT INTO `choix`(`idEtudiant`,`idCommission`) VALUES (3,2);

-- doubletcalevent
INSERT INTO `doubletcalevent`(`idCalendrier`,`idEvenement`) VALUES (1,1);
INSERT INTO `doubletcalevent`(`idCalendrier`,`idEvenement`) VALUES (1,2);
INSERT INTO `doubletcalevent`(`idCalendrier`,`idEvenement`) VALUES (2,1);
INSERT INTO `doubletcalevent`(`idCalendrier`,`idEvenement`) VALUES (3,2);

