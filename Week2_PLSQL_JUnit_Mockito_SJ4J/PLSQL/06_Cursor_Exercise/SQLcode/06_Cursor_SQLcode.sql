

SET SERVEROUTPUT ON;


BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Transactions CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE Accounts CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE Loans CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE Customers CASCADE CONSTRAINTS';
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

-- Create Transactions table
CREATE TABLE Transactions (
  TransactionID NUMBER PRIMARY KEY,
  AccountID NUMBER,
  TransactionDate DATE,
  Amount NUMBER,
  TransactionType VARCHAR2(10),
  FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

-- Create Loans table
CREATE TABLE Loans (
  LoanID NUMBER PRIMARY KEY,
  CustomerID NUMBER,
  LoanAmount NUMBER,
  InterestRate NUMBER,
  StartDate DATE,
  EndDate DATE,
  FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Insert sample data
INSERT INTO Customers VALUES (1, 'John Doe', TO_DATE('1985-05-15','YYYY-MM-DD'), 1000);
INSERT INTO Customers VALUES (2, 'Jane Smith', TO_DATE('1990-07-20','YYYY-MM-DD'), 1500);

INSERT INTO Accounts VALUES (1, 1, 'Savings', 1000);
INSERT INTO Accounts VALUES (2, 2, 'Checking', 1500);

INSERT INTO Transactions VALUES (1, 1, ADD_MONTHS(SYSDATE, -1), 200, 'Deposit'); -- Last month
INSERT INTO Transactions VALUES (2, 1, SYSDATE, 300, 'Withdrawal'); -- This month
INSERT INTO Transactions VALUES (3, 2, SYSDATE, 400, 'Deposit'); -- This month

INSERT INTO Loans VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));
INSERT INTO Loans VALUES (2, 2, 10000, 6, SYSDATE, ADD_MONTHS(SYSDATE, 120));


--  SCENARIO 1: Generate Monthly Statements for all customers


BEGIN
  DBMS_OUTPUT.PUT_LINE('--- Scenario 1: Monthly Statements ---');

  FOR cust IN (SELECT CustomerID, Name FROM Customers) LOOP
    DBMS_OUTPUT.PUT_LINE('Customer: ' || cust.Name);

    FOR tx IN (
      SELECT t.* FROM Transactions t
      JOIN Accounts a ON t.AccountID = a.AccountID
      WHERE a.CustomerID = cust.CustomerID
        AND EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
        AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE)
    ) LOOP
      DBMS_OUTPUT.PUT_LINE('  TX#' || tx.TransactionID || ' ' || tx.TransactionType || ' Amount: ' || tx.Amount || ' Date: ' || TO_CHAR(tx.TransactionDate, 'YYYY-MM-DD'));
    END LOOP;

  END LOOP;
END;
/


--  SCENARIO 2: Apply Annual Fee to all accounts
-- Assume annual fee: 100


BEGIN
  DBMS_OUTPUT.PUT_LINE('--- Scenario 2: Apply Annual Fee ---');

  FOR acc IN (SELECT * FROM Accounts) LOOP
    UPDATE Accounts SET Balance = Balance - 100 WHERE AccountID = acc.AccountID;
    DBMS_OUTPUT.PUT_LINE('AccountID: ' || acc.AccountID || ' New Balance: ' ||
      (acc.Balance - 100));
  END LOOP;
END;
/


-- SCENARIO 3: Update Loan Interest Rates based on new policy
-- Example: Increase all interest rates by 1%


BEGIN
  DBMS_OUTPUT.PUT_LINE('--- Scenario 3: Update Loan Interest Rates ---');

  FOR l IN (SELECT * FROM Loans) LOOP
    UPDATE Loans SET InterestRate = InterestRate + 1 WHERE LoanID = l.LoanID;
    DBMS_OUTPUT.PUT_LINE('LoanID: ' || l.LoanID || ' New InterestRate: ' || (l.InterestRate + 1));
  END LOOP;
END;
/



-- Customers
SELECT * FROM Customers;

-- Accounts
SELECT * FROM Accounts;

-- Transactions
SELECT * FROM Transactions;

-- Loans
SELECT * FROM Loans;

