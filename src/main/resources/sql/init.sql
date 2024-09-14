CREATE SCHEMA project;

CREATE TABLE project.doctors(
    id INT PRIMARY KEY,
    first_name VARCHAR(128) NOT NULL,
    last_name VARCHAR(128) NOT NULL,
    specialization_id INT,
    FOREIGN KEY (specialization_id) REFERENCES project.specializations(id)
);

CREATE TABLE project.specializations(
    id INT PRIMARY KEY ,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE project.patients(
    id INT PRIMARY KEY ,
    first_name VARCHAR(128) NOT NULL,
    last_name VARCHAR(128) NOT NULL,
    doctor_id INT,
    FOREIGN KEY (doctor_id) REFERENCES project.doctors(id)
);

DROP TABLE project.doctors;
DROP TABLE project.specializations;
DROP TABLE project.patients;