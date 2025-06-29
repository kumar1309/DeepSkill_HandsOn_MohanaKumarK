

SET SERVEROUTPUT ON;



BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Accounts CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Customers CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Employees CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/


-- Drop old procedures


BEGIN
  EXECUTE IMMEDIATE 'DROP PROCEDURE ProcessMonthlyInterest';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
  EXECUTE IMMEDIATE 'DROP PROCEDURE UpdateEmployeeBonus';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
  EXECUTE IMMEDIATE 'DROP PROCEDURE TransferFunds';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/


-- Create Tables


CREATE TABLE Customers (
  CustomerID NUMBER PRIMARY KEY,
  Name VARCHAR2(100),
  DOB DATE,
  Balance NUMBER,
  LastModified DATE
);

CREATE TABLE Accounts (
  AccountID NUMBER PRIMARY KEY,
  CustomerID NUMBER,
  AccountType VARCHAR2(20),
  Balance NUMBER,
  LastModified DATE,
  FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
  EmployeeID NUMBER PRIMARY KEY,
  Name VARCHAR2(100),
  Position VARCHAR2(50),
  Salary NUMBER,
  Department VARCHAR2(50),
  HireDate DATE
);


-- Insert Sample Data


INSERT INTO Customers VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 2000, SYSDATE);
INSERT INTO Customers VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 3000, SYSDATE);

INSERT INTO Accounts VALUES (1, 1, 'Savings', 2000, SYSDATE);
INSERT INTO Accounts VALUES (2, 2, 'Savings', 3000, SYSDATE);

INSERT INTO Employees VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

-- Scenario 1: ProcessMonthlyInterest


CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  UPDATE Accounts
  SET Balance = Balance + (Balance * 0.01);

  COMMIT;

  DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all savings accounts.');
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/


-- Scenario 2: UpdateEmployeeBonus


CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  p_department VARCHAR2,
  p_bonus_pct NUMBER
) IS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_bonus_pct / 100)
  WHERE Department = p_department;

  IF SQL%ROWCOUNT = 0 THEN
    DBMS_OUTPUT.PUT_LINE('No employees found in this department.');
  ELSE
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus applied to employees in department: ' || p_department);
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/


-- Scenario 3: TransferFunds


CREATE OR REPLACE PROCEDURE TransferFunds(
  p_from_account NUMBER,
  p_to_account NUMBER,
  p_amount NUMBER
) IS
  insufficient_balance EXCEPTION;
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account;

  IF v_balance < p_amount THEN
    RAISE insufficient_balance;
  END IF;

  UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;
  UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;

  COMMIT;

  DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');
EXCEPTION
  WHEN insufficient_balance THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error: Insufficient balance.');
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

-- Display Tables After Execution


PROMPT ===== Accounts Table =====
SELECT * FROM Accounts;

PROMPT ===== Employees Table =====
SELECT * FROM Employees;

PROMPT ===== Customers Table =====
SELECT * FROM Customers;

EXEC ProcessMonthlyInterest;

EXEC UpdateEmployeeBonus('HR', 10);

EXEC TransferFunds(1, 2, 500);

