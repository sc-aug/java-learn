USE EmployeeDB;

## 1 Get all employees
DELIMITER $$
DROP PROCEDURE IF EXISTS sp_GetAllEmp; $$
CREATE PROCEDURE sp_GetAllEmp()
BEGIN
    SELECT *  FROM EmployeeDB.EmpInfo;
END $$
DELIMITER ;


## 2 Get employee by id
DELIMITER $$
DROP PROCEDURE IF EXISTS sp_GetEmpById; $$
CREATE PROCEDURE sp_GetEmpById(
    IN EId INT
)
BEGIN
    SELECT *  FROM EmployeeDB.EmpInfo
    WHERE EmpId = EId;
END $$
DELIMITER ;

## 3 Get employee by salary
DELIMITER $$
DROP PROCEDURE IF EXISTS sp_GetEmpSalaryNoMoreThan; $$
CREATE PROCEDURE sp_GetEmpSalaryNoMoreThan(
    IN salary DECIMAL(10,2)
)
BEGIN
    SELECT *  FROM EmployeeDB.EmpInfo
    WHERE EmpSalary <= salary;
END $$
DELIMITER ;

## 4 Count employees
DELIMITER $$
DROP PROCEDURE IF EXISTS sp_CountEmp; $$
CREATE PROCEDURE sp_CountEmp(
    OUT EmpCnt INT)
BEGIN
    SELECT COUNT(EmpId) INTO EmpCnt
    FROM EmployeeDB.EmpInfo;
END $$
DELIMITER ;

## CALL sp_CountEmp(@testoutput)
## SELECT @testoutput

-- 5 