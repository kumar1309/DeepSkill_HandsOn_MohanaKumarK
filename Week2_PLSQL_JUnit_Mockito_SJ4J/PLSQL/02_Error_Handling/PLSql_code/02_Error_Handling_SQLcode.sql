
SET SERVEROUTPUT ON;



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
INSERT INTO Accounts VALUES (2, 2, 'Checking', 3000, SYSDATE);

INSERT INTO Employees VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));


-- Scenario 1: SafeTransferFunds


CREATE OR REPLACE PROCEDURE SafeTransferFunds(
  p_from_account NUMBER,
  p_to_account NUMBER,
  p_amount NUMBER
) IS
  insufficient_funds EXCEPTION;
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account;

  IF v_balance < p_amount THEN
    RAISE insufficient_funds;
  END IF;

  UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;
  UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');

EXCEPTION
  WHEN insufficient_funds THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds.');
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/


-- Scenario 2: UpdateSalary


CREATE OR REPLACE PROCEDURE UpdateSalary(
  p_employee_id NUMBER,
  p_percentage NUMBER
) IS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_percentage / 100)
  WHERE EmployeeID = p_employee_id;

  IF SQL%ROWCOUNT = 0 THEN
    DBMS_OUTPUT.PUT_LINE('Error: Employee ID not found.');
  ELSE
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');
  END IF;

EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/


-- Scenario 3: AddNewCustomer


CREATE OR REPLACE PROCEDURE AddNewCustomer(
  p_customer_id NUMBER,
  p_name VARCHAR2,
  p_dob DATE,
  p_balance NUMBER
) IS
BEGIN
  INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
  VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Customer added successfully.');

EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('Error: Customer ID already exists.');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

-- Display Tables


PROMPT ===== Accounts Table =====
SELECT * FROM Accounts;

PROMPT ===== Employees Table =====
SELECT * FROM Employees;

PROMPT ===== Customers Table =====
SELECT * FROM Customers;


EXEC AddNewCustomer(3, 'New User', SYSDATE, 5000);


EXEC AddNewCustomer(1, 'Duplicate User', SYSDATE, 2000);


EXEC SafeTransferFunds(1, 2, 500);

EXEC SafeTransferFunds(1, 2, 10000);

EXEC UpdateSalary(1, 5);

EXEC UpdateSalary(100, 10);

