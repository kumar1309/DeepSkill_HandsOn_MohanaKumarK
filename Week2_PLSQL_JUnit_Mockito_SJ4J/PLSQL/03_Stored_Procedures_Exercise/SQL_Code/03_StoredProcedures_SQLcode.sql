


-- Step 1: Create Tables and Insert Sample Data


-- Table for savings accounts (for interest calculation)
CREATE TABLE SavingsAccounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(100),
    Balance NUMBER(10, 2)
);

-- Table for employees (for bonus calculation)
CREATE TABLE Employees (
    EmpID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Department VARCHAR2(50),
    Salary NUMBER(10, 2)
);

-- Table for bank accounts (for fund transfer)
CREATE TABLE BankAccounts (
    AccountNumber NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(100),
    Balance NUMBER(10, 2)
);

-- Inserting sample savings accounts
INSERT INTO SavingsAccounts VALUES (1, 'Mohan', 5000);
INSERT INTO SavingsAccounts VALUES (2, 'Kumar', 8000);
INSERT INTO SavingsAccounts VALUES (3, 'Ram', 10000);

-- Inserting sample employees
INSERT INTO Employees VALUES (101, 'Raj', 'Sales', 30000);
INSERT INTO Employees VALUES (102, 'Manoj', 'Sales', 32000);
INSERT INTO Employees VALUES (103, 'Kumar', 'HR', 28000);

-- Inserting sample bank accounts
INSERT INTO BankAccounts VALUES (1001, 'Mohan', 7000);
INSERT INTO BankAccounts VALUES (1002, 'Kumar', 3000);
INSERT INTO BankAccounts VALUES (1003, 'Siv', 4000);

COMMIT;


-- Scenario 1: Stored Procedure to Process Monthly Interest


CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    FOR acc IN (SELECT AccountID, Balance FROM SavingsAccounts) LOOP
        UPDATE SavingsAccounts
        SET Balance = Balance + (acc.Balance * 0.01)
        WHERE AccountID = acc.AccountID;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Scenario 1: Monthly interest applied to all savings accounts.');
END;
/

-- Execute Scenario 1 procedure to apply interest
BEGIN
    ProcessMonthlyInterest;
END;
/


-- Scenario 2: Stored Procedure to Update Employee Bonus



CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    dept_name IN VARCHAR2,
    bonus_percent IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * bonus_percent / 100)
    WHERE Department = dept_name;

    DBMS_OUTPUT.PUT_LINE('Scenario 2: Bonus of ' || bonus_percent || '% applied to ' || dept_name || ' department.');
END;
/

-- Execute Scenario 2 procedure for Sales department with 10% bonus
BEGIN
    UpdateEmployeeBonus('Sales', 10);
END;
/

-- Scenario 3: Stored Procedure to Transfer Funds



CREATE OR REPLACE PROCEDURE TransferFunds(
    from_acct IN NUMBER,
    to_acct IN NUMBER,
    amt IN NUMBER
) AS
    from_balance NUMBER;
BEGIN
    -- Get balance of source account
    SELECT Balance INTO from_balance FROM BankAccounts WHERE AccountNumber = from_acct;

    IF from_balance < amt THEN
        DBMS_OUTPUT.PUT_LINE('Scenario 3: Transfer failed - insufficient balance.');
    ELSE
        -- Deduct from source
        UPDATE BankAccounts
        SET Balance = Balance - amt
        WHERE AccountNumber = from_acct;

        -- Add to destination
        UPDATE BankAccounts
        SET Balance = Balance + amt
        WHERE AccountNumber = to_acct;

        DBMS_OUTPUT.PUT_LINE('Scenario 3: ₹' || amt || ' transferred from Account ' || from_acct || ' to Account ' || to_acct);
    END IF;
END;
/

-- Execute Scenario 3 procedure: transfer ₹2000 from 1001 to 1002
BEGIN
    TransferFunds(1001, 1002, 2000);
END;
/



-- View updated balances of savings accounts (Scenario 1)
SELECT * FROM SavingsAccounts;

-- View updated salaries of employees (Scenario 2)
SELECT * FROM Employees;

-- View updated bank account balances (Scenario 3)
SELECT * FROM BankAccounts;
