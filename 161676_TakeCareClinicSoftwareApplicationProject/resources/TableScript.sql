CREATE TABLE Patient(
patient_id NUMBER PRIMARY KEY,
patient_name VARCHAR2(20),
age number,
phone VARCHAR2(10),
description VARCHAR2(8),
consultation_date DATE);

CREATE SEQUENCE Patient_Id_Seq
2  start with 1000;

