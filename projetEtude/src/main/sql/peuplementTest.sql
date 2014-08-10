-- Purge
DELETE FROM `doubletcalevent`;
DELETE FROM `choix`;
DELETE FROM `participation`;
DELETE FROM `evenement`;
DELETE FROM `commission`;
DELETE FROM `pole`;
DELETE FROM `droits`;
DELETE FROM `calendrier`;
DELETE FROM `etudiant`;


-- Etudiant
INSERT INTO `etudiant`(`idEtudiant`,`nomEtudiant`,`prenomEtudiant`,`password`,`email`,`idDroit`,`firstConnexion`) VALUES (1,'Gladieux','Jean','pres','jean.gladieux@hei.fr',2,0);
INSERT INTO `etudiant`(`idEtudiant`,`nomEtudiant`,`prenomEtudiant`,`password`,`email`,`idDroit`,`firstConnexion`) VALUES (2,'Denis','Martin','etudiant','martin.denis@hei.fr',0,0);
INSERT INTO `etudiant`(`idEtudiant`,`nomEtudiant`,`prenomEtudiant`,`password`,`email`,`idDroit`,`firstConnexion`) VALUES (3,'Descamps','Stanislas','admin','stanislas.descamps@hei.fr',3,0);
INSERT INTO `etudiant`(`idEtudiant`,`nomEtudiant`,`prenomEtudiant`,`password`,`email`,`idDroit`,`firstConnexion`) VALUES (4,'Merchez','Nicolas','admin','nicolas.merchez@hei.fr',3,0);
INSERT INTO `etudiant`(`idEtudiant`,`nomEtudiant`,`prenomEtudiant`,`password`,`email`,`idDroit`,`firstConnexion`) VALUES (5,'Bizouri','Billel','pres','billel.bizouri@hei.fr',1,1);

-- Calendrier
INSERT INTO `calendrier`(`idCalendrier`,`idEtudiant`,`dateEmission`) VALUES (1,1,'2014-02-24');
INSERT INTO `calendrier`(`idCalendrier`,`idEtudiant`,`dateEmission`) VALUES (2,2,'2014-04-12');
INSERT INTO `calendrier`(`idCalendrier`,`idEtudiant`,`dateEmission`) VALUES (3,3,'2014-04-26');
INSERT INTO `calendrier`(`idCalendrier`,`idEtudiant`,`dateEmission`) VALUES (4,4,'2014-05-10');
INSERT INTO `calendrier`(`idCalendrier`,`idEtudiant`,`dateEmission`) VALUES (5,5,'2014-07-19');

-- Pole
INSERT INTO `pole`(`idPole`,`nomPole`,`idEtudiant`) VALUES (1,'BDA',1);
INSERT INTO `pole`(`idPole`,`nomPole`,`idEtudiant`) VALUES (2,'BDS',1);
INSERT INTO `pole`(`idPole`,`nomPole`,`idEtudiant`) VALUES (3,'CapSo',1);
INSERT INTO `pole`(`idPole`,`nomPole`,`idEtudiant`) VALUES (4,'PES',1);
INSERT INTO `pole`(`idPole`,`nomPole`,`idEtudiant`) VALUES (5,'PET',1);

-- Commission
INSERT INTO `commission`(`idCommission`,`idEtudiant`,`idPole`,`nomCommission`,`descriptionCom`,`adresseLogo`) VALUES (1,5,1,'La Sauce','Le plaisir de manger entre etudiants','img/logo/bda.jpg');
INSERT INTO `commission`(`idCommission`,`idEtudiant`,`idPole`,`nomCommission`,`descriptionCom`,`adresseLogo`) VALUES (2,5,2,'Club Rock HEI','Cours de danse tous les mercredi soir','img/logo/rock.jpg');
INSERT INTO `commission`(`idCommission`,`idEtudiant`,`idPole`,`nomCommission`,`descriptionCom`,`adresseLogo`) VALUES (3,5,3,'SolidBear','Super association humanitaire','img/logo/CapSolidaire.jpg');
INSERT INTO `commission`(`idCommission`,`idEtudiant`,`idPole`,`nomCommission`,`descriptionCom`,`adresseLogo`) VALUES (5,5,4,'Cosmo','Vous aimez voyager? Cette asso est pour vous','img/logo/cosmo.jpg');
INSERT INTO `commission`(`idCommission`,`idEtudiant`,`idPole`,`nomCommission`,`descriptionCom`,`adresseLogo`) VALUES (4,5,5,'HEIvolution','Association en faveur du developpement durable','img/logo/heivolution.jpg');

-- Evenement
INSERT INTO `evenement`(`idEvenement`,`idCommission`,`nomCommission`,`nomPole`,`titreEvent`,`descriptionEvent`,`lieuEvent`,`dateDebut`,`dateFin`,`heureDebut`,`heureFin`,`image`) VALUES (1,1,'La Sauce','BDA','Salon gastronomique','Viens gouter les saveur d Espagne ca va etre trop bon','RR034','2014-10-24','2014-10-24',' 12:00:00','13:00:00','img/logo/bda.jpg');
INSERT INTO `evenement`(`idEvenement`,`idCommission`,`nomCommission`,`nomPole`,`titreEvent`,`descriptionEvent`,`lieuEvent`,`dateDebut`,`dateFin`,`heureDebut`,`heureFin`,`image`) VALUES (2,3,'SolidBear','CapSo','Sauvons la planete','Viens, nous devons sauver la planete','S102','2014-11-12','2014-11-12',' 12:00:00','13:00:00','img/logo/CapSolidaire.jpg');
INSERT INTO `evenement`(`idEvenement`,`idCommission`,`nomCommission`,`nomPole`,`titreEvent`,`descriptionEvent`,`lieuEvent`,`dateDebut`,`dateFin`,`heureDebut`,`heureFin`,`image`) VALUES (3,2,'Club Rock HEI','BDS','Soiree Rock','Viens danser un rock endiable des 80s','Salle de sport','2015-02-30','2015-02-30',' 19:45:00','22:00:00','img/logo/rock.jpg');
INSERT INTO `evenement`(`idEvenement`,`idCommission`,`nomCommission`,`nomPole`,`titreEvent`,`descriptionEvent`,`lieuEvent`,`dateDebut`,`dateFin`,`heureDebut`,`heureFin`,`image`) VALUES (4,5,'Cosmo','PES','Visitons le monde','Nous allons te faire tourner autour du monde','RR120','2015-07-03','2015-07-03',' 12:00:00','13:00:00','img/cosmo.jpg');
INSERT INTO `evenement`(`idEvenement`,`idCommission`,`nomCommission`,`nomPole`,`titreEvent`,`descriptionEvent`,`lieuEvent`,`dateDebut`,`dateFin`,`heureDebut`,`heureFin`,`image`) VALUES (5,4,'HEIvolution','PET','Une eolienne a HEI','Participe au nouveau challenge de HEI, creons une eolienne dans nos batiment','J001','2015-08-15','2015-08-15',' 08:30:00','17:30:00','img/logo/heivolution.jpg');

-- Choix
INSERT INTO `choix`(`idEtudiant`,`idCommission`) VALUES (2,1);
INSERT INTO `choix`(`idEtudiant`,`idCommission`) VALUES (3,2);

-- doubletcalevent
INSERT INTO `doubletcalevent`(`idCalendrier`,`idEvenement`) VALUES (1,1);
INSERT INTO `doubletcalevent`(`idCalendrier`,`idEvenement`) VALUES (1,2);
INSERT INTO `doubletcalevent`(`idCalendrier`,`idEvenement`) VALUES (2,1);
INSERT INTO `doubletcalevent`(`idCalendrier`,`idEvenement`) VALUES (3,2);

-- Droits
INSERT INTO `droits`(`idDroit`,`libelle`) VALUES (0,'Etudiant');
INSERT INTO `droits`(`idDroit`,`libelle`) VALUES (1,'President');
INSERT INTO `droits`(`idDroit`,`libelle`) VALUES (2,'ResponsablePole');
INSERT INTO `droits`(`idDroit`,`libelle`) VALUES (3,'Administrateur');


