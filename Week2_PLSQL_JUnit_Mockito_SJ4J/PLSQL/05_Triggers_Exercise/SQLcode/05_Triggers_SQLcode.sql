
SET SERVEROUTPUT ON;


BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE AuditLog CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE Transactions CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE Accounts CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE Loans CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE Employees CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE Customers CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN
    NULL;
END;
/


-- Customers Table
CREATE TABLE Customers (
  CustomerID NUMBER PRIMARY KEY,
  Name VARCHAR2(100),
  DOB DATE,
  Balance NUMBER,
  LastModified DATE
);

-- Accounts Table
CREATE TABLE Accounts (
  AccountID NUMBER PRIMARY KEY,
  CustomerID NUMBER,
  AccountType VARCHAR2(20),
  Balance NUMBER,
  LastModified DATE,
  FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Transactions Table
CREATE TABLE Transactions (
  TransactionID NUMBER PRIMARY KEY,
  AccountID NUMBER,
  TransactionDate DATE,
  Amount NUMBER,
  TransactionType VARCHAR2(10),
  FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

-- Loans Table
CREATE TABLE Loans (
  LoanID NUMBER PRIMARY KEY,
  CustomerID NUMBER,
  LoanAmount NUMBER,
  InterestRate NUMBER,
  StartDate DATE,
  EndDate DATE,
  FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Employees Table
CREATE TABLE Employees (
  EmployeeID NUMBER PRIMARY KEY,
  Name VARCHAR2(100),
  Position VARCHAR2(50),
  Salary NUMBER,
  Department VARCHAR2(50),
  HireDate DATE
);

-- AuditLog Table for Scenario 2
CREATE TABLE AuditLog (
  LogID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  TransactionID NUMBER,
  LogDate DATE,
  Details VARCHAR2(200)
);



-- Customers
INSERT INTO Customers VALUES (1, 'John Doe', TO_DATE('1985-05-15','YYYY-MM-DD'), 1000, SYSDATE);
INSERT INTO Customers VALUES (2, 'Jane Smith', TO_DATE('1990-07-20','YYYY-MM-DD'), 1500, SYSDATE);

-- Accounts
INSERT INTO Accounts VALUES (1, 1, 'Savings', 1000, SYSDATE);
INSERT INTO Accounts VALUES (2, 2, 'Checking', 1500, SYSDATE);

-- Transactions
INSERT INTO Transactions VALUES (1, 1, SYSDATE, 200, 'Deposit');
INSERT INTO Transactions VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

-- Loans
INSERT INTO Loans VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

-- Employees
INSERT INTO Employees VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15','YYYY-MM-DD'));
INSERT INTO Employees VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20','YYYY-MM-DD'));


-- SCENARIO 1: Trigger to auto-update LastModified when customer updated


CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
  :NEW.LastModified := SYSDATE;
END;
/


-- SCENARIO 2: Trigger to maintain AuditLog for new transactions


CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog (TransactionID, LogDate, Details)
  VALUES (:NEW.TransactionID, SYSDATE,
          'Transaction: ' || :NEW.TransactionType || ' of amount ' || :NEW.Amount);
END;
/


-- SCENARIO 3: Trigger to enforce rules on deposits and withdrawals


CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = :NEW.AccountID;

  IF :NEW.TransactionType = 'Withdrawal' THEN
    IF :NEW.Amount > v_balance THEN
      RAISE_APPLICATION_ERROR(-20001, 'Withdrawal exceeds balance!');
    END IF;
  ELSIF :NEW.TransactionType = 'Deposit' THEN
    IF :NEW.Amount <= 0 THEN
      RAISE_APPLICATION_ERROR(-20002, 'Deposit must be positive!');
    END IF;
  END IF;
END;
/



BEGIN
  -- SCENARIO 1 Test: Update customer to check LastModified
  UPDATE Customers SET Balance = Balance + 100 WHERE CustomerID = 1;

  -- SCENARIO 2 + 3 Test: Valid deposit -> should log
  INSERT INTO Transactions VALUES (3, 1, SYSDATE, 500, 'Deposit');

  -- SCENARIO 3 Test: Invalid withdrawal -> should fail
  BEGIN
    INSERT INTO Transactions VALUES (4, 1, SYSDATE, 99999, 'Withdrawal');
  EXCEPTION
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE(' Expected Error: ' || SQLERRM);
  END;

  -- Show Customers with LastModified
  FOR c IN (SELECT * FROM Customers) LOOP
    DBMS_OUTPUT.PUT_LINE('Customer: ' || c.CustomerID || ', ' || c.Name || ', Balance: ' || c.Balance || ', LastModified: ' || TO_CHAR(c.LastModified, 'YYYY-MM-DD HH24:MI:SS'));
  END LOOP;

  -- Show AuditLog
  FOR a IN (SELECT * FROM AuditLog) LOOP
    DBMS_OUTPUT.PUT_LINE('AuditLog: ID=' || a.LogID || ', TXID=' || a.TransactionID || ', ' || a.Details);
  END LOOP;
END;
/



-- Table: Customers
SELECT * FROM Customers;

-- Table: Accounts
SELECT * FROM Accounts;

-- Table: Transactions
SELECT * FROM Transactions;

-- Table: AuditLog
SELECT * FROM AuditLog;

