SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

create table user (
		`ID` INT NOT NULL AUTO_INCREMENT,
		`name` VARCHAR(20),
		`role` VARCHAR(20),
		`password` VARCHAR(20),
		PRIMARY KEY (ID)
);

create table stock (
		`ID` INT NOT NULL AUTO_INCREMENT,
		`name` VARCHAR(20),
		`description` VARCHAR(255),
		`purchaseprice` DOUBLE PRECISION,
		`sellingprice` DOUBLE PRECISION,
		`onstockquantity` INT,
		`type` VARCHAR(20),
		PRIMARY KEY (ID)
);

create table customer(
		`ID` INT NOT NULL AUTO_INCREMENT,
		`name` VARCHAR(100),
		`address` VARCHAR(200),
		`email` VARCHAR(100),
		`phone` VARCHAR(20),
		`loyaltycard` BIT(1),
		`discount` INT,
		PRIMARY KEY (ID)
);

create table invoice(
		`invoicenumber` int NOT NULL AUTO_INCREMENT,
		`date` DATETIME,
		`discount` INT,
		`customer_id` INT,
		`name` VARCHAR(100),
		`address` VARCHAR(200),
		`email` VARCHAR(100),
		`phone` VARCHAR(20),
		`loyaltycard` BIT(1),
		FOREIGN KEY (`customer_id`) REFERENCES `customer`(`ID`),
		PRIMARY KEY (`invoicenumber`)
);

create table invoicedproducts (
	`invoicenumber` INT,
	`stockid` INT,
	`name` VARCHAR(20),
	`type` VARCHAR(20),
	`purchaseprice` DOUBLE PRECISION,
	`soldprice` DOUBLE PRECISION,
	`soldquantity` INT,
	`soldsubtotal` DOUBLE PRECISION,
	FOREIGN KEY (`stockid`) REFERENCES `stock`(`ID`),
	FOREIGN KEY (`invoicenumber`) REFERENCES `invoice`(`invoicenumber`)
);

SET FOREIGN_KEY_CHECKS=1;
COMMIT;
