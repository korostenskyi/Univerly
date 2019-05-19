CREATE DATABASE IF NOT EXISTS university;

USE university;

CREATE TABLE IF NOT EXISTS department(
	id_department INT NOT NULL AUTO_INCREMENT,

	department_name VARCHAR(45) NOT NULL,
	head_of_department VARCHAR(45) NOT NULL,

    PRIMARY KEY (id_department)
);

CREATE TABLE IF NOT EXISTS lector(
	id_lector INT NOT NULL AUTO_INCREMENT,

    lector_name VARCHAR(45) NOT NULL,
    degree ENUM('assistant', 'assosiate professor', 'professor') NOT NULL,

    PRIMARY KEY (id_lector)
);

CREATE TABLE IF NOT EXISTS contract(
	id INT NOT NULL AUTO_INCREMENT,

    id_department INT NOT NULL,
    id_lector INT NOT NULL,

    lector_salary INT NOT NULL,

    FOREIGN KEY (id_department) REFERENCES department(id_department),
    FOREIGN KEY (id_lector) REFERENCES lector(id_lector),
    PRIMARY KEY (id)
);