/*Ecraser la base de données si elle existe déjà*/
DROP DATABASE IF EXISTS `ParcVoiture`;
/*Création de la base de données si elle n'existe pas*/
CREATE DATABASE IF NOT EXISTS `ParcVoiture`;

/* Utilisation de la base de données*/
USE  `ParcVoiture`;

/*Création des tables*/

CREATE TABLE IF NOT EXISTS `Proprietaire`
(
    `ProprietaireNumero` INT AUTO_INCREMENT,
    `ProprietaireAdresse` VARCHAR(200),
    `ProprietaireMail` VARCHAR(200),
    PRIMARY KEY(`ProprietaireNumero`)
);

CREATE TABLE IF NOT EXISTS `Personne`
(
    `PersonneNumero` INT NOT NULL,
    `PersonneNom` VARCHAR(50),
    `PersonnePrenom` VARCHAR(30),
    `PersonneSexe` ENUM("M", "F"),
    `PersonneFonction` VARCHAR(100),
    PRIMARY KEY(`PersonneNumero`),
    FOREIGN KEY(`PersonneNumero`) REFERENCES `Proprietaire`(`ProprietaireNumero`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `Institution`
(
    `InstitutionNumero` INT NOT NULL,
    `InstitutionLibelle` VARCHAR(250) NOT NULL,
    PRIMARY KEY(`InstitutionNumero`),
    FOREIGN KEY(`InstitutionNumero`) REFERENCES `Proprietaire`(`ProprietaireNumero`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `Voiture`
(
    `VoitureNumeroImmatriculation` VARCHAR(200) NOT NULL,
    `VoitureNumero` INT NOT NULL,
    `VoitureNumeroReception` VARCHAR(150),
    `VoitureNumeroSerie` VARCHAR(150),
    `VoitureCNIT` VARCHAR(100),
    `VoitureModele` VARCHAR(20),
    `VoitureMarque` VARCHAR(100),
    `VoiturePoids` REAL,
    PRIMARY KEY(`VoitureNumeroImmatriculation`),
    FOREIGN KEY(`VoitureNumero`) REFERENCES `Proprietaire`(`ProprietaireNumero`) ON DELETE CASCADE
);
