INSERT INTO department(department_name, head_of_department) VALUES ('Computer Science', 'Bjarne Stroustrup');
INSERT INTO department(department_name, head_of_department) VALUES ('Physics', 'Albert Einstein');
INSERT INTO department(department_name, head_of_department) VALUES ('Chemistry', 'Dmitri Mendeleev');
INSERT INTO department(department_name, head_of_department) VALUES ('Biology', 'Charles Darwin');

INSERT INTO lector(lector_name, degree) VALUES ('Bjarne Stroustrup', 'PROFESSOR');
INSERT INTO lector(lector_name, degree) VALUES ('Albert Einstein', 'PROFESSOR');
INSERT INTO lector(lector_name, degree) VALUES ('Dmitri Mendeleev', 'PROFESSOR');
INSERT INTO lector(lector_name, degree) VALUES ('Charles Darwin', 'PROFESSOR');
INSERT INTO lector(lector_name, degree) VALUES ('Albus Dumbledore', 'PROFESSOR');

INSERT INTO lector(lector_name, degree) VALUES ('Linus Torvalds', 'ASSOSIATE_PROFESSOR');
INSERT INTO lector(lector_name, degree) VALUES ('Rubeus Hagrid', 'ASSOSIATE_PROFESSOR');
INSERT INTO lector(lector_name, degree) VALUES ('Bill Gates', 'ASSOSIATE_PROFESSOR');
INSERT INTO lector(lector_name, degree) VALUES ('Donald Knuth', 'ASSOSIATE_PROFESSOR');
INSERT INTO lector(lector_name, degree) VALUES ('Johannes Kepler', 'ASSOSIATE_PROFESSOR');
INSERT INTO lector(lector_name, degree) VALUES ('Thomas Graham', 'ASSOSIATE_PROFESSOR');

INSERT INTO lector(lector_name, degree) VALUES ('Brian Kernighan', 'ASSISTANT');
INSERT INTO lector(lector_name, degree) VALUES ('Ken Thompson', 'ASSISTANT');
INSERT INTO lector(lector_name, degree) VALUES ('James Gosling', 'ASSISTANT');
INSERT INTO lector(lector_name, degree) VALUES ('James Clerk Maxwell', 'ASSISTANT');
INSERT INTO lector(lector_name, degree) VALUES ('Niels Bohr', 'ASSISTANT');

INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (1, 1, 3000);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (1, 6, 2000);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (1, 12, 800);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (1, 13, 400);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (1, 16, 600);

INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (2, 1, 1000);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (2, 5, 900);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (2, 2, 950);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (2, 3, 1200);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (2, 4, 700);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (2, 9, 900);

INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (3, 1, 2000);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (3, 2, 4000);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (3, 3, 200);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (3, 9, 400);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (3, 10, 900);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (3, 11, 600);

INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (4, 15, 900);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (4, 3, 5000);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (4, 7, 1200);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (4, 5, 2380);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (4, 13, 810);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (4, 4, 3400);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (4, 8, 1800);
INSERT INTO contract(id_department, id_lector, lector_salary) VALUES (4, 14, 3400);
