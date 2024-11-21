CREATE DATABASE ecommerce_db;

USE ecommerce_db;

CREATE TABLE Categories (
                            catalog_id INT PRIMARY KEY AUTO_INCREMENT,
                            category_name VARCHAR(255) NOT NULL UNIQUE,
                            catalog_description VARCHAR(255),
                            catalog_status BIT DEFAULT 1
);

DELIMITER &&

CREATE PROCEDURE find_all_categories()
BEGIN
    SELECT * FROM Categories;
END &&

DELIMITER ;

select  * from Categories

