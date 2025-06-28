

-- Create Customers table
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Age NUMBER,
    Balance NUMBER(10, 2),
    IsVIP CHAR(1) DEFAULT 'N'
);

-- Create Loans table
CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER REFERENCES Customers(CustomerID),
    InterestRate NUMBER(5, 2),
    DueDate DATE
);

-- Insert sample customers
INSERT INTO Customers VALUES (1, 'Mohana Kumar', 65, 15000, 'N');
INSERT INTO Customers VALUES (2, 'Kumar', 45, 8000, 'N');
INSERT INTO Customers VALUES (3, 'Mohan ram', 70, 12000, 'N');
INSERT INTO Customers VALUES (4, 'Manoj', 30, 5000, 'N');

-- Insert sample loans
INSERT INTO Loans VALUES (101, 1, 7.5, SYSDATE + 15);
INSERT INTO Loans VALUES (102, 2, 8.0, SYSDATE + 40);
INSERT INTO Loans VALUES (103, 3, 6.5, SYSDATE + 25);
INSERT INTO Loans VALUES (104, 4, 9.0, SYSDATE - 5);

COMMIT;

-- Scenario 1: Interest discount for senior citizens
BEGIN
    FOR cust IN (SELECT CustomerID FROM Customers WHERE Age > 60) LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = cust.CustomerID;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Interest rate discount applied to senior citizens.');
END;
/

-- Scenario 2: Promote VIPs
BEGIN
    FOR cust IN (SELECT CustomerID FROM Customers WHERE Balance > 10000) LOOP
        UPDATE Customers
        SET IsVIP = 'Y'
        WHERE CustomerID = cust.CustomerID;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('VIP status updated for eligible customers.');
END;
/

-- Scenario 3: Print loan reminders
BEGIN
    FOR loan_rec IN (
        SELECT L.LoanID, C.Name, L.DueDate
        FROM Loans L JOIN Customers C ON L.CustomerID = C.CustomerID
        WHERE L.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: ' || loan_rec.Name ||
                             ', your loan (ID: ' || loan_rec.LoanID ||
                             ') is due on ' || TO_CHAR(loan_rec.DueDate, 'DD-Mon-YYYY'));
    END LOOP;
END;
/

-- View Results
SELECT * FROM Customers;
SELECT * FROM Loans;
