show databases;

create database croma;
use croma;

CREATE TABLE category (
	category_id INT PRIMARY KEY UNIQUE NOT NULL,
    category_name VARCHAR(100)
);

CREATE TABLE products_table (
    product_id INT PRIMARY KEY NOT NULL,
    product_name VARCHAR(100),
    category_id INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(category_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE prices_table (
    pid INT PRIMARY KEY NOT NULL,
    price INT,
    FOREIGN KEY (pid) REFERENCES products_table(product_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

INSERT INTO category VALUES
(104, 'Mobiles'),
(125, 'Laptops'),
(126, 'Televisions');

select * from category;

INSERT INTO products_table VALUES
(1020, 'iPhone 15 Pro Max', 104),
(1040, 'HP Pavilion Laptop', 125),
(1050, 'LG 55-inch 4K Smart TV', 126),
(1070, 'OnePlus Nord CE 4', 104);

select * from products_table;

INSERT INTO prices_table VALUES
(1020, 139900),
(1040, 59990),
(1050, 51990),
(1070, 24999);

select * from prices_table;

UPDATE category SET category_id = 999 WHERE category_id = 126;

DELETE FROM category WHERE category_id = 104;

SELECT * FROM (
    SELECT * FROM category NATURAL JOIN products_table
) AS T
NATURAL JOIN prices_table
WHERE product_name LIKE "%t%";

SELECT * FROM (
    SELECT * FROM category NATURAL JOIN products_table
) AS T
NATURAL JOIN prices_table
WHERE category_id = 104;

CREATE VIEW cheap_products AS
SELECT pid, price
FROM prices_table
WHERE price < 60000;

SELECT * FROM cheap_products;

SELECT * FROM products_table
WHERE product_name LIKE "%i%";