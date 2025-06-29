
SET SERVEROUTPUT ON;




-- Create needed tables


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


-- Insert sample data


INSERT INTO Customers VALUES (1, 'John Doe', TO_DATE('1980-06-15', 'YYYY-MM-DD'), 2000, SYSDATE);
INSERT INTO Customers VALUES (2, 'Jane Smith', TO_DATE('2000-12-01', 'YYYY-MM-DD'), 3000, SYSDATE);

INSERT INTO Accounts VALUES (1, 1, 'Savings', 2000, SYSDATE);
INSERT INTO Accounts VALUES (2, 2, 'Savings', 3000, SYSDATE);

-- Scenario 1: Function CalculateAge


CREATE OR REPLACE FUNCTION CalculateAge(p_dob DATE)
RETURN NUMBER
IS
  v_age NUMBER;
BEGIN
  v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob)/12);
  RETURN v_age;
END;
/


-- Scenario 2: Function CalculateMonthlyInstallment
-- Formula: EMI = [P * R * (1+R)^N] / [(1+R)^N – 1]


CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
  p_loan_amount NUMBER,
  p_interest_rate NUMBER,
  p_duration_years NUMBER
)
RETURN NUMBER
IS
  v_monthly_rate NUMBER;
  v_months NUMBER;
  v_emi NUMBER;
BEGIN
  v_monthly_rate := p_interest_rate / 12 / 100;
  v_months := p_duration_years * 12;

  IF v_monthly_rate = 0 THEN
    v_emi := p_loan_amount / v_months;
  ELSE
    v_emi := (p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_months))
             / (POWER(1 + v_monthly_rate, v_months) - 1);
  END IF;

  RETURN ROUND(v_emi, 2);
END;
/

-- Scenario 3: Function HasSufficientBalance


CREATE OR REPLACE FUNCTION HasSufficientBalance(
  p_account_id NUMBER,
  p_amount NUMBER
)
RETURN VARCHAR2
IS
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_account_id;

  IF v_balance >= p_amount THEN
    RETURN 'TRUE';
  ELSE
    RETURN 'FALSE';
  END IF;

EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RETURN 'Account Not Found';
END;
/

-- Test Calls and Display

PROMPT ====== CalculateAge Tests ======
SELECT Name, DOB, CalculateAge(DOB) AS Age FROM Customers;

PROMPT ====== CalculateMonthlyInstallment Example ======
SELECT CalculateMonthlyInstallment(10000, 5, 2) AS Monthly_EMI FROM dual;

PROMPT ====== HasSufficientBalance Checks ======
SELECT AccountID, Balance, HasSufficientBalance(AccountID, 1500) AS EnoughBalance
FROM Accounts;

PROMPT ====== Current Accounts Table ======
SELECT * FROM Accounts;

PROMPT ====== Current Customers Table ======
SELECT * FROM Customers;

EXEC DBMS_OUTPUT.PUT_LINE('Age: ' || CalculateAge(TO_DATE('1980-06-15', 'YYYY-MM-DD')));
EXEC DBMS_OUTPUT.PUT_LINE('EMI: ' || CalculateMonthlyInstallment(10000, 5, 2));
EXEC DBMS_OUTPUT.PUT_LINE('Has balance: ' || HasSufficientBalance(1, 1500));
