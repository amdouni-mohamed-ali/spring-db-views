-- this script will be executed only on dev
-- schema creation
CREATE TABLE customer (
  id         INTEGER PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  email  VARCHAR(50),
  phone_number VARCHAR(50),
  birthDate VARCHAR(30),
  birthPlace VARCHAR(30)
);

CREATE TABLE address (
  id         INTEGER PRIMARY KEY,
  building VARCHAR(30),
  street VARCHAR(30),
  city  VARCHAR(30),
  zip_code VARCHAR(10),
  country VARCHAR(30),
  country_code VARCHAR(30),
  customer_id INTEGER,
  FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE account (
  id         INTEGER PRIMARY KEY,
  balance DOUBLE,
  opening_balance DOUBLE,
  account_name  VARCHAR(30),
  date_opened VARCHAR(10),
  interest DOUBLE,
  customer_id INTEGER,
  FOREIGN KEY (customer_id) REFERENCES customer(id)
);

-- views creation
CREATE VIEW view_customer
AS
SELECT id, first_name, last_name, email, phone_number FROM customer;

CREATE VIEW view_address
AS
SELECT c.id as identifier, first_name, building, street, country FROM customer c INNER JOIN address a WHERE c.id = a.customer_id;

CREATE VIEW view_account
AS
SELECT c.id as identifier, first_name, balance, account_name, date_opened FROM customer c INNER JOIN account a WHERE c.id = a.customer_id;

-- there is some problems in this views if we are dealing with jpa (jpa needs an id for any entity)
-- in the view_customer view we have a primary key . it's the id.
-- in the view_address the id is not an unique identifier. the customer may have many addresses so
-- the customer id is not a primary key for this entity
-- we can use a composite key like (id, first_name, building, street, country all fields :)) but it's not a solution
-- if one of the fields is null we gonna have problems with hibernate
-- as first solution (and if you can modify the views) you can add the row number as primary key. if you are dealing
-- with oracle you can check this post https://tuhrig.de/using-spring-data-for-database-views-without-an-id/
-- as second solution :
-- check the example :)
-- we suppose that a customer can have only one address and many accounts