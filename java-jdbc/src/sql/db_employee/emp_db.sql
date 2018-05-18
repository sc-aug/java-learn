CREATE DATABASE EmployeeDB;

USE EmployeeDB;

CREATE TABLE EmpInfo (
    EmpId INT NOT NULL AUTO_INCREMENT,
    EmpName VARCHAR(30) NOT NULL,
    EmpSalary NUMERIC(10,2) NOT NULL,
    `Address` VARCHAR(30),
    PRIMARY KEY (EmpId)
);

INSERT INTO EmpInfo VALUES (NULL, "tianyu", 30.1, 'Denton, TX 76203');
INSERT INTO EmpInfo VALUES (NULL, "wenbin", 20.1, 'Syracuse, NY 13244');
INSERT INTO EmpInfo VALUES (NULL, "shichuan", 10.1, 'Dallas, TX 75080');

## TEST
## SELECT * FROM EmployeeDB.EmpInfo;