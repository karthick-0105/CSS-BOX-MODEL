CREATE DATABASE hospital_db;
USE hospital_db;
show tables;

CREATE TABLE users (
  user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(100) NOT NULL,
  role VARCHAR(20) NOT NULL,   -- ADMIN / DOCTOR / PATIENT
  reference_id BIGINT          -- doctor_id or patient_id
);
desc users;

CREATE TABLE doctors (
    doctor_id BIGINT NOT NULL AUTO_INCREMENT,
    available BIT(1) NOT NULL,
    name VARCHAR(255),
    specialization VARCHAR(255),
    PRIMARY KEY (doctor_id)
);
desc doctors;

CREATE TABLE patient (
    patient_id BIGINT NOT NULL AUTO_INCREMENT,
    age INT NOT NULL,
    gender VARCHAR(255),
    name VARCHAR(255),
    phone VARCHAR(255),
    PRIMARY KEY (patient_id)
);
desc patients;

CREATE TABLE appointment (
    appointment_id BIGINT NOT NULL AUTO_INCREMENT,
    appointment_date DATE,
    priority VARCHAR(255),
    status VARCHAR(255),
    doctor_id BIGINT,
    patient_id BIGINT,
    rejection_reason VARCHAR(255),
    slot VARCHAR(255),
    PRIMARY KEY (appointment_id),
    CONSTRAINT fk_appointment_doctor
        FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
    CONSTRAINT fk_appointment_patient
        FOREIGN KEY (patient_id) REFERENCES patient(patient_id)
);
desc appointments;

show tables;

INSERT INTO users (username, password, role)
VALUES ('admin', '123', 'ADMIN'),('raghav','123','DOCTOR'),('mehta','123','DOCTOR');
INSERT INTO users (username, password, role)
VALUES ('anup', '123', 'doctor');
INSERT INTO users (username, password, role)
VALUES ('A', '123', 'DOCTOR');

select * from users;
SELECT appointment_id, status, rejection_reason FROM appointments;
select * from appointments;
select * from doctors;
select * from patients;

