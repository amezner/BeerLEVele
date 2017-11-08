SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

create table stock (
		`ID` INT NOT NULL AUTO_INCREMENT,
		`name` VARCHAR(20),
		`description` VARCHAR(255),
		`purchaseprice` INT,
		`sellingprice` INT,
		`onstockquantity` INT,
		`type` VARCHAR(20),
		PRIMARY KEY (ID)
);

create table customer(
		`ID` INT NOT NULL AUTO_INCREMENT,
		`name` VARCHAR(255),
		`address` VARCHAR(255),
		`email` VARCHAR(255),
		`phone` INT,
		`loyaltycard` BIT(1),
		`discount` INT,
		PRIMARY KEY (ID)
);

create table invoice(
		`invoicenumber` int NOT NULL AUTO_INCREMENT,
		`date` DATETIME,
		`discount` INT,
		`customer_id` int,
		FOREIGN KEY (`customer_id`) REFERENCES `customer`(`ID`),
		PRIMARY KEY (`invoicenumber`)
);


create table invoicedproducts (
	`invoicenumber` INT,
	`stockid` INT,
	`soldprice` INT,
	`soldquantity` INT,
	FOREIGN KEY (`stockid`) REFERENCES `stock`(`ID`),
	FOREIGN KEY (`invoicenumber`) REFERENCES `invoice`(`invoicenumber`)
);

SET FOREIGN_KEY_CHECKS=1;
COMMIT;
