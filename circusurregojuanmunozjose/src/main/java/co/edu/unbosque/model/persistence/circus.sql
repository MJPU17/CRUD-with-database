CREATE DATABASE circusjujm;

USE circusjujm;
CREATE TABLE person(
id INT PRIMARY KEY,
numbercard BIGINT UNIQUE,
pname VARCHAR(100),
studylevel VARCHAR(100)
);

CREATE TABLE clown(
idclown INT PRIMARY KEY,
numbercard BIGINT UNIQUE,
numberfriends INT
);

CREATE TABLE comedian(
idcomedian INT PRIMARY KEY,
numbercard BIGINT UNIQUE,
openmic BOOLEAN
);


