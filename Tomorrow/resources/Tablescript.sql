CREATE TABLE Patient(patient_id NUMBER PRIMARY KEY,patient_name VARCHAR2(20),phone VARCHAR2(10), age NUMBER,productInterested VARCHAR2(20),regDate DATE);
CREATE SEQUENCE patient_Id_sequence
START WITH 1000;