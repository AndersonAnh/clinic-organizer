CREATE SCHEMA project;

CREATE TABLE project.doctors
(
    id                SERIAL PRIMARY KEY,
    first_name        VARCHAR(128) NOT NULL,
    last_name         VARCHAR(128) NOT NULL,
    specialization_id INT,
    FOREIGN KEY (specialization_id) REFERENCES project.specializations (id)
);
CREATE TABLE project.specializations
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);
CREATE TABLE project.patients
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(128) NOT NULL,
    last_name  VARCHAR(128) NOT NULL
);
CREATE TABLE project.doctor_patient
(
    doctor_id  INT,
    patient_id INT,
    PRIMARY KEY (doctor_id, patient_id),
    FOREIGN KEY (doctor_id) REFERENCES project.doctors (id),
    FOREIGN KEY (patient_id) REFERENCES project.patients (id)
);
SELECT setval('project.doctors_id_seq', (SELECT MAX(id) FROM project.doctors));
DROP TABLE project.doctors;
DROP TABLE project.specializations;
DROP TABLE project.patients;
DROP TABLE project.doctor_patient;

SELECT setval('project.specializations_id_seq', (SELECT MAX(id) FROM project.specializations));

SELECT setval('project.patients_id_seq', (SELECT MAX(id) FROM project.specializations));