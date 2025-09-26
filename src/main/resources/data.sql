INSERT INTO lector (id, name, salary, degree) VALUES (1, 'Ivan Petrenko', 1200, 'ASSISTANT');
INSERT INTO lector (id, name, salary, degree) VALUES (2, 'Petro Ivanov', 2500, 'ASSOCIATE_PROFESSOR');
INSERT INTO lector (id, name, salary, degree) VALUES (3, 'Olena Shevchenko', 4000, 'PROFESSOR');
INSERT INTO lector (id, name, salary, degree) VALUES (4, 'Andrii Kovalenko', 1800, 'ASSISTANT');

-- Departments
INSERT INTO department (id, name, head_id) VALUES (1, 'Computer Science', 3);
INSERT INTO department (id, name, head_id) VALUES (2, 'Mathematics', 2);

-- Relations (department_lectors)
INSERT INTO department_lectors (department_id, lector_id) VALUES (1, 1);
INSERT INTO department_lectors (department_id, lector_id) VALUES (1, 2);
INSERT INTO department_lectors (department_id, lector_id) VALUES (1, 3);

INSERT INTO department_lectors (department_id, lector_id) VALUES (2, 2);
INSERT INTO department_lectors (department_id, lector_id) VALUES (2, 4);
