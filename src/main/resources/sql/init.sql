CREATE SCHEMA project;

CREATE TABLE project.doctors(
                                id SERIAL PRIMARY KEY,
                                first_name VARCHAR(128) NOT NULL,
                                last_name VARCHAR(128) NOT NULL,
                                specialization_id INT,
                                FOREIGN KEY (specialization_id) REFERENCES project.specializations(id)
);

CREATE TABLE project.specializations(
                                        id SERIAL PRIMARY KEY ,
                                        name VARCHAR(50) NOT NULL
);

CREATE TABLE project.patients(
                                 id SERIAL PRIMARY KEY ,
                                 first_name VARCHAR(128) NOT NULL,
                                 last_name VARCHAR(128) NOT NULL,
                                 doctor_id INT,
                                 FOREIGN KEY (doctor_id) REFERENCES project.doctors(id)
);

SELECT setval('project.doctors_id_seq', (SELECT MAX(id) FROM project.doctors));

DROP TABLE project.doctors;

DROP TABLE project.specializations;

DROP TABLE project.patients;