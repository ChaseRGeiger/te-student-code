BEGIN TRANSACTION;

DROP TABLE IF EXISTS product_wish_list;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS product_type;
DROP TABLE IF EXISTS wish_list;


CREATE TABLE product_type (
	id serial primary key,
	type char(1) not null UNIQUE,
	name varchar(32) not null
);

CREATE TABLE product (
	sku varchar(10) primary key,
	product_type bigint not null,
	name varchar(64) not null,
	description text,
	perishable char(1) DEFAULT 'N',
	price numeric(6,2) not null,
	weight_in_lbs int,
	taxable boolean DEFAULT true,

	CONSTRAINT chk_perishable CHECK (perishable IN ('Y', 'N')),
	CONSTRAINT fk_product_product_type FOREIGN KEY (product_type) REFERENCES product_type(id)
);

CREATE TABLE wish_list (
	id serial primary key,
	name varchar(64) not null,
	date_created TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE product_wish_list (
	product_sku varchar(10),
	wish_list_id bigint,
	date_added TIMESTAMP DEFAULT current_timestamp,

	CONSTRAINT pk_product_wish_list PRIMARY KEY (product_sku, wish_list_id),
	CONSTRAINT fk_product_wish_list_sku FOREIGN KEY (product_sku) REFERENCES product(sku),
	CONSTRAINT fk_product_wish_list_id FOREIGN KEY (wish_list_id) REFERENCES wish_list(id)
);

-- We can trust the ids created by the sequence, only because the schema script DROPS everything and rebuilds it,
-- which restarts the sequence at 1 for all tables.
INSERT INTO product_type(id, type, name) VALUES (DEFAULT, 'C', 'Clothing');     -- id 1
INSERT INTO product_type(id, type, name) VALUES (DEFAULT, 'G', 'Grocery');      -- id 2
INSERT INTO product_type(id, type, name) VALUES (DEFAULT, 'H', 'Home Goods');   -- id 3
INSERT INTO product_type(id, type, name) VALUES (DEFAULT, 'B', 'Book');         -- id 4

-- Insert Products
INSERT INTO product(
	sku, product_type, name, description, perishable, price, weight_in_lbs, taxable)
	VALUES ('C01', 1, 'Test Clothing 1', 'Test Clothing 1 Description', 'N', 24.98, 6, true);
INSERT INTO product(
	sku, product_type, name, description, perishable, price, weight_in_lbs, taxable)
	VALUES ('G01', 2, 'Test Grocery 1', 'Test Grocery 1 Description', 'Y', 8.99, 1, false);
INSERT INTO product(
	sku, product_type, name, description, perishable, price, weight_in_lbs, taxable)
	VALUES ('H01', 3, 'Test Home Goods 1', 'Test Home Goods 1 Description', 'N', 5.55, 1, true);
INSERT INTO product(
	sku, product_type, name, description, perishable, price, weight_in_lbs, taxable)
	VALUES ('B01', 4, 'Test Book 1', 'Test Book 1 Description - taxable', 'N', 19.95, 11, true);
INSERT INTO product(
	sku, product_type, name, description, perishable, price, weight_in_lbs, taxable)
	VALUES ('B02', 4, 'Test Book 2', 'Test Book 2 Description - nontaxable', 'N', 39.95, 5, false);

-- Insert wishlists
INSERT INTO wish_list (name, date_created) VALUES ('Test Wishlist 1', '2022-06-15');    -- id 1
INSERT INTO wish_list (name, date_created) VALUES ('Test Wishlist 2', '2022-07-01');    -- id 2
INSERT INTO wish_list (name, date_created) VALUES ('Test Wishlist 3', '2022-07-04');    -- id 3

-- Add 2 Items to WishList with id 1
INSERT INTO product_wish_list (product_sku, wish_list_id, date_added)
VALUES ('C01', 1, '2022-06-15');

INSERT INTO product_wish_list (product_sku, wish_list_id, date_added)
VALUES ('H01', 1, '2022-06-20');  -- Added to both wishlists

-- Add 3 Items to WishList with id 2
INSERT INTO product_wish_list (product_sku, wish_list_id, date_added)
VALUES ('B01', 2, '2022-07-01');

INSERT INTO product_wish_list (product_sku, wish_list_id, date_added)
VALUES ('H01', 2, '2022-07-03');

INSERT INTO product_wish_list (product_sku, wish_list_id, date_added)
VALUES ('B02', 2, '2022-07-05');

-- Wishlist 3 has no items
-- Product G01 is not added to any wishlists

COMMIT;