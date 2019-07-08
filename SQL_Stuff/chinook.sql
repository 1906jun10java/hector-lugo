--2. SQL Queries

--2.1 Select

-- Select all records from the Employee table.
SELECT *
FROM EMPLOYEE;
--Select all records from the Employee table where last name is King.
SELECT *
FROM EMPLOYEE
WHERE LASTNAME= 'King';
--Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM EMPLOYEE
WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;

--2.2 Order By

-- Select all albums in Album table and sort result set in descending order by title.
SELECT *
FROM ALBUM
ORDER BY title DESC;
--Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME
FROM CUSTOMER
ORDER BY CITY ASC;

--2.3 Insert Into

-- Insert two new records into Genre table 
INSERT INTO GENRE VALUES(26,'Sludge');
INSERT INTO GENRE VALUES(27,'Rancheras');
--Insert two new records into Employee table
INSERT INTO EMPLOYEE VALUES(9,'John','Smith',(null),(null),(null),(null),(null),(null),(null),(null),(null),(null),(null),(null));
INSERT INTO EMPLOYEE VALUES(10,'John','Smith2',(null),(null),(null),(null),(null),(null),(null),(null),(null),(null),(null),(null));
--Insert two new records into Customer table
INSERT INTO CUSTOMER VALUES(60,'John','Smith',(null),(null),(null),(null),(null),(null),(null),(null),'fake@email.com',(null));
INSERT INTO CUSTOMER VALUES(61,'John','Smith2',(null),(null),(null),(null),(null),(null),(null),(null),'fake2@email.com',(null));

--2.4 Update

--Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME='Robert',LASTNAME='Walter'
WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';
--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
SET NAME='CCR'
WHERE NAME='Creedence Clearwater Revival';

--2.5 Like

-- Select all invoices with a billing address like “T%”
SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 Between

--Select all invoices that have a total between 15 and 50
SELECT *
FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;
--Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM EMPLOYEE
WHERE HIREDATE BETWEEN TO_DATE('2003-06-01','YYYY-MM-DD') AND TO_DATE('2004-03-01','YYYY-MM-DD')  ;

--2.7 Delete

--Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM INVOICELINE 
WHERE INVOICEID IN(
SELECT INVOICEID FROM INVOICE
WHERE CUSTOMERID IN(
SELECT CUSTOMERID FROM CUSTOMER
WHERE FIRSTNAME='Robert' AND LASTNAME='Walter'));

DELETE FROM INVOICE
WHERE CUSTOMERID IN(
SELECT CUSTOMERID FROM CUSTOMER
WHERE FIRSTNAME='Robert' AND LASTNAME='Walter');

DELETE FROM CUSTOMER
WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';

--3 SQL Functions

--3.1System Defined Functions

--Create a function that returns the current time.
SELECT CURRENT_TIMESTAMP FROM dual ; 
-- create a function that returns the length of name in MEDIATYPE table
SELECT LENGTH(NAME)
FROM MEDIATYPE;

--3.2 System Defined Aggregate Functions

-- Create a function that returns the average total of all invoices
SELECT AVG(TOTAL)
FROM INVOICE;
--Create a function that returns the most expensive track
SELECT MAX(UNITPRICE)
FROM TRACK;
--3.3 User Defined Scalar Functions
 
--Create a function that returns the average price of invoice line items in the invoiceline table


--4.0 Stored Procedures

--4.1 Basic Stored Procedure

--Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE fandl(firstLastName OUT SYS_REFCURSOR)
AS 

BEGIN 
OPEN firstLastName FOR
   SELECT FIRSTNAME,LASTNAME FROM EMPLOYEE;
  
END fandl;

--4.2 Stored Procedure Input Parameters

--Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE updateEmployeeFIRSTSNAME(id IN NUMBER, new_value IN VARCHAR2)
AS 
BEGIN 
UPDATE EMPLOYEE
SET FIRSTNAME = new_value
WHERE EMPLOYEEID=id;
  
END updateEmployeeFIRSTSNAME;

--Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE employeeManager(employeeID IN NUMBER,STUFF OUT SYS_REFCURSOR)
AS 
BEGIN 
OPEN STUFF FOR
SELECT REPORTSTO
FROM EMPLOYEE
WHERE EMPLOYEEID=employeeID;
  
END employeeManager;

--4.3 Stored Procedure Output Parameters

-- Create a stored procedure that returns the name and company of a customer


--5.0


--6.Triggers
--Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER printoutAfterNewEmployee
AFTER INSERT ON EMPLOYEE

BEGIN 
   dbms_output.put_line('New Employee lol');
END; 
/ 

--Create an after update trigger on the album table that fires after a row is inserted in the table

CREATE OR REPLACE TRIGGER printoutAfterNEWalbum
AFTER UPDATE ON ALBUM

BEGIN 
   dbms_output.put_line('Update album lol');
END; 
/ 

--Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER printoutAfterDELETEcustomer
AFTER DELETE ON CUSTOMER

BEGIN 
   dbms_output.put_line('DELETED CUSTOMER lol');
END; 
/ 

--7.0 Joins

--7.1 Inner
--Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

SELECT CUSTOMER.FIRSTNAME,customer.lastname,invoice.invoiceid
FROM CUSTOMER 
INNER JOIN INVOICE
ON customer.customerid = invoice.customerid;

--7.2 OUTERJOIN
--Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.firstname,customer.lastname,invoice.invoiceid,invoice.total
FROM CUSTOMER
LEFT OUTER JOIN INVOICE
ON customer.customerid = invoice.customerid;

--7.3 RIGHT JOIN
--Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name,album.title
From ARTIST
RIGHT OUTER JOIN ALBUM
ON artist.artistid=album.artistid;

--7.4 Cross JOIN
--Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM ARTIST 
CROSS JOIN ALBUM
ORDER BY artist.name;
--7.5 SELF
--Perform a self-join on the employee table, joining on the reportsto column.

SELECT e1.LASTNAME AS BOSS,e2.LASTNAME AS EMPLOYEE
FROM EMPLOYEE e1, EMPLOYEE e2
WHERE e1.employeeid=e2.reportsto;


