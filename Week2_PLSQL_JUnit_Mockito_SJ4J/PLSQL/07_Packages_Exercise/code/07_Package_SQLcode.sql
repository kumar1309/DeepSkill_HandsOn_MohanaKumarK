

SET SERVEROUTPUT ON;


BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Accounts CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE Customers CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE Employees CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN
    NULL;
END;
/

-- Create Customers table
CREATE TABLE Customers (
  CustomerID NUMBER PRIMARY KEY,
  Name VARCHAR2(100),
  DOB DATE,
  Balance NUMBER
);

-- Create Accounts table
CREATE TABLE Accounts (
  AccountID NUMBER PRIMARY KEY,
  CustomerID NUMBER,
  AccountType VARCHAR2(20),
  Balance NUMBER,
  FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Create Employees table
CREATE TABLE Employees (
  EmployeeID NUMBER PRIMARY KEY,
  Name VARCHAR2(100),
  Position VARCHAR2(50),
  Salary NUMBER,
  Department VARCHAR2(50),
  HireDate DATE
);

-- Sample data
INSERT INTO Customers VALUES (1, 'John Doe', TO_DATE('1985-05-15','YYYY-MM-DD'), 1000);
INSERT INTO Customers VALUES (2, 'Jane Smith', TO_DATE('1990-07-20','YYYY-MM-DD'), 1500);

INSERT INTO Accounts VALUES (1, 1, 'Savings', 1000);
INSERT INTO Accounts VALUES (2, 1, 'Checking', 500);
INSERT INTO Accounts VALUES (3, 2, 'Savings', 1500);

INSERT INTO Employees VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15','YYYY-MM-DD'));
INSERT INTO Employees VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20','YYYY-MM-DD'));


-- SCENARIO 1: Package for Customer Management


CREATE OR REPLACE PACKAGE CustomerManagement AS
  PROCEDURE AddCustomer(p_ID NUMBER, p_Name VARCHAR2, p_DOB DATE, p_Balance NUMBER);
  PROCEDURE UpdateCustomer(p_ID NUMBER, p_Name VARCHAR2, p_Balance NUMBER);
  FUNCTION GetCustomerBalance(p_ID NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
  PROCEDURE AddCustomer(p_ID NUMBER, p_Name VARCHAR2, p_DOB DATE, p_Balance NUMBER) IS
  BEGIN
    INSERT INTO Customers VALUES (p_ID, p_Name, p_DOB, p_Balance);
  END;

  PROCEDURE UpdateCustomer(p_ID NUMBER, p_Name VARCHAR2, p_Balance NUMBER) IS
  BEGIN
    UPDATE Customers SET Name = p_Name, Balance = p_Balance WHERE CustomerID = p_ID;
  END;

  FUNCTION GetCustomerBalance(p_ID NUMBER) RETURN NUMBER IS
    v_balance NUMBER;
  BEGIN
    SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_ID;
    RETURN v_balance;
  END;
END CustomerManagement;
/


-- SCENARIO 2: Package for Employee Management

CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireEmployee(p_ID NUMBER, p_Name VARCHAR2, p_Position VARCHAR2, p_Salary NUMBER, p_Department VARCHAR2, p_HireDate DATE);
  PROCEDURE UpdateEmployee(p_ID NUMBER, p_Salary NUMBER, p_Department VARCHAR2);
  FUNCTION GetAnnualSalary(p_ID NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
  PROCEDURE HireEmployee(p_ID NUMBER, p_Name VARCHAR2, p_Position VARCHAR2, p_Salary NUMBER, p_Department VARCHAR2, p_HireDate DATE) IS
  BEGIN
    INSERT INTO Employees VALUES (p_ID, p_Name, p_Position, p_Salary, p_Department, p_HireDate);
  END;

  PROCEDURE UpdateEmployee(p_ID NUMBER, p_Salary NUMBER, p_Department VARCHAR2) IS
  BEGIN
    UPDATE Employees SET Salary = p_Salary, Department = p_Department WHERE EmployeeID = p_ID;
  END;

  FUNCTION GetAnnualSalary(p_ID NUMBER) RETURN NUMBER IS
    v_salary NUMBER;
  BEGIN
    SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_ID;
    RETURN v_salary * 12;
  END;
END EmployeeManagement;
/


-- SCENARIO 3: Package for Account Operations


CREATE OR REPLACE PACKAGE AccountOperations AS
  PROCEDURE OpenAccount(p_ID NUMBER, p_CustomerID NUMBER, p_Type VARCHAR2, p_Balance NUMBER);
  PROCEDURE CloseAccount(p_ID NUMBER);
  FUNCTION GetTotalBalance(p_CustomerID NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
  PROCEDURE OpenAccount(p_ID NUMBER, p_CustomerID NUMBER, p_Type VARCHAR2, p_Balance NUMBER) IS
  BEGIN
    INSERT INTO Accounts VALUES (p_ID, p_CustomerID, p_Type, p_Balance);
  END;

  PROCEDURE CloseAccount(p_ID NUMBER) IS
  BEGIN
    DELETE FROM Accounts WHERE AccountID = p_ID;
  END;

  FUNCTION GetTotalBalance(p_CustomerID NUMBER) RETURN NUMBER IS
    v_total NUMBER;
  BEGIN
    SELECT SUM(Balance) INTO v_total FROM Accounts WHERE CustomerID = p_CustomerID;
    RETURN NVL(v_total, 0);
  END;
END AccountOperations;
/



BEGIN
  DBMS_OUTPUT.PUT_LINE('--- CustomerManagement ---');
  CustomerManagement.AddCustomer(3, 'Bob White', TO_DATE('1995-01-01','YYYY-MM-DD'), 2000);
  CustomerManagement.UpdateCustomer(3, 'Bob White Jr.', 2500);
  DBMS_OUTPUT.PUT_LINE('Balance of Customer 3: ' || CustomerManagement.GetCustomerBalance(3));

  DBMS_OUTPUT.PUT_LINE('--- EmployeeManagement ---');
  EmployeeManagement.HireEmployee(3, 'Charlie Green', 'Analyst', 50000, 'Finance', SYSDATE);
  EmployeeManagement.UpdateEmployee(3, 55000, 'Finance');
  DBMS_OUTPUT.PUT_LINE('Annual Salary of Employee 3: ' || EmployeeManagement.GetAnnualSalary(3));

  DBMS_OUTPUT.PUT_LINE('--- AccountOperations ---');
  AccountOperations.OpenAccount(4, 3, 'Savings', 3000);
  DBMS_OUTPUT.PUT_LINE('Total Balance for Customer 3: ' || AccountOperations.GetTotalBalance(3));
  AccountOperations.CloseAccount(4);
END;
/



SELECT * FROM Customers;
SELECT * FROM Employees;
SELECT * FROM Accounts;

