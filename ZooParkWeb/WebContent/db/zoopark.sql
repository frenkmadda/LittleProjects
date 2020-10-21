DROP DATABASE IF EXISTS zoopark;

CREATE DATABASE zoopark;
USE zoopark;

CREATE TABLE role (
	id_role varchar(50),
    description varchar(200),
    primary key (id_role)
);

CREATE TABLE user (
	email varchar(50) primary key,
    password varchar(50),
    role_id varchar(50),
    name varchar(50),
    surname varchar(50),
    ticket boolean,
    foreign key(role_id) references role(id_role)
);

CREATE TABLE park (
luogo varchar(50),
nome varchar(50),
orario_apertura varchar(20),
orario_chiusura varchar(20),
codUnivoco int primary key
);


INSERT INTO role VALUES("admin", "Amministratore del Sito");
INSERT INTO role VALUES("registered_user", "Utente Registrato");
INSERT INTO user VALUES("f.maddaloni2@studenti.unisa.it", "FMCM6263", "admin", "Francesco", "Maddaloni",false);
INSERT INTO user VALUES("chiarapuglia99@gmail.com", "28022017ligabue", "admin", "Chiara", "Puglia",false);
INSERT INTO park VALUES("Roma - Via delle Botteghe Oscure","Semption", "9:00", "20:30", 37829);
INSERT INTO park VALUES("Midgar - Via Settore 7","Settore-Phyro", "8:30", "21:30", 78345);
INSERT INTO park VALUES("Valhalla - Via Giardino di Thor","OdhinLand", "8:00","22:00",24344);
INSERT INTO park VALUES("BanjoLand","Jinjo Forest", "9:30","22:00",24345);