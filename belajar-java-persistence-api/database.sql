--CREATE DATABASE belajar_java_persistence_api;

USE belajar_java_persistence_api;

--CREATE  customers(
--id VARCHAR(255) NOT NULL PRIMARY KEY,
--name VARCHAR(100)
--) ENGINE InnoDB;



SELECT * FROM brands;
SELECT * FROM products;

SHOW TABLES;

ALTER TABLE customers
ADD COLUMN primary_email VARCHAR(100);
