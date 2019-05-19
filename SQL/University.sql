CREATE DATABASE IF NOT EXISTS university;

USE university;

CREATE TABLE IF NOT EXISTS department(
	id INT NOT NULL AUTO_INCREMENT,

	department_name VARCHAR(45) NOT NULL,
	head_of_department INT NOT NULL,

	FOREIGN KEY (head_of_department) REFERENCES lector(id),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS lector(
	id INT NOT NULL AUTO_INCREMENT,

    lector_name VARCHAR(45) NOT NULL,
    degree ENUM('assistant', 'assosiate professor', 'professor') NOT NULL,
    salary INT NOT NULL,
    department_id INT,

    FOREIGN KEY (id) REFERENCES department(id),
    PRIMARY KEY (id)
);
