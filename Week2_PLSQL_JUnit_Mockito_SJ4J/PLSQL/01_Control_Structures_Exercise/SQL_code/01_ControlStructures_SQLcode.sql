


CREATE TABLE Customers (
  CustomerID NUMBER PRIMARY KEY,
  Name VARCHAR2(100),
  DOB DATE,
  Balance NUMBER,
  IsVIP CHAR(1) DEFAULT 'N'
);

CREATE TABLE Loans (
  LoanID NUMBER PRIMARY KEY,
  CustomerID NUMBER,
  LoanAmount NUMBER,
  InterestRate NUMBER,
  DueDate DATE,
  FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);


INSERT INTO Customers VALUES (1, 'John Doe', TO_DATE('1950-05-10', 'YYYY-MM-DD'), 12000, 'N');
INSERT INTO Customers VALUES (2, 'Jane Smith', TO_DATE('1988-07-20', 'YYYY-MM-DD'), 8000, 'N');
INSERT INTO Customers VALUES (3, 'Robert Brown', TO_DATE('1945-03-15', 'YYYY-MM-DD'), 15000, 'N');

INSERT INTO Loans VALUES (1, 1, 5000, 5.5, SYSDATE + 15);
INSERT INTO Loans VALUES (2, 2, 10000, 6.0, SYSDATE + 45);
INSERT INTO Loans VALUES (3, 3, 7000, 5.0, SYSDATE + 20);

COMMIT;


-- Scenario 1: Apply discount


BEGIN
  FOR rec IN (SELECT L.LoanID, L.InterestRate, C.DOB 
                FROM Loans L JOIN Customers C ON L.CustomerID = C.CustomerID)
  LOOP
    IF MONTHS_BETWEEN(SYSDATE, rec.DOB)/12 > 60 THEN
      UPDATE Loans SET InterestRate = InterestRate - 1 WHERE LoanID = rec.LoanID;
      DBMS_OUTPUT.PUT_LINE('Discount applied for Loan ' || rec.LoanID);
    END IF;
  END LOOP;
END;
/


-- Scenario 2: Promote VIP


BEGIN
  FOR rec IN (SELECT CustomerID, Balance FROM Customers)
  LOOP
    IF rec.Balance > 10000 THEN
      UPDATE Customers SET IsVIP = 'Y' WHERE CustomerID = rec.CustomerID;
      DBMS_OUTPUT.PUT_LINE('Customer ' || rec.CustomerID || ' promoted to VIP.');
    END IF;
  END LOOP;
END;
/


-- Scenario 3: Send reminders


BEGIN
  FOR rec IN (SELECT LoanID, CustomerID, DueDate FROM Loans WHERE DueDate <= SYSDATE + 30)
  LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || rec.LoanID || ' for Customer ' || rec.CustomerID || ' due on ' || rec.DueDate);
  END LOOP;
END;
/


-- Final Table Views


SELECT * FROM Customers;
SELECT * FROM Loans;
