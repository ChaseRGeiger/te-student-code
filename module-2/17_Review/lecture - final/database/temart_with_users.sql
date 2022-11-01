DROP TABLE IF EXISTS product_wish_list;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS product_type;
DROP TABLE IF EXISTS wish_list;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id serial primary key,
	username varchar(50) UNIQUE NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(20)
);

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
	user_id bigint not null,
	name varchar(64) not null,
	date_created TIMESTAMP DEFAULT current_timestamp,
	
	CONSTRAINT fk_wish_list_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
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
INSERT INTO product_type(id, type, name) VALUES (DEFAULT, 'C', 'Clothing');  -- id 1
INSERT INTO product_type(id, type, name) VALUES (DEFAULT, 'G', 'Grocery');   -- id 2
INSERT INTO product_type(id, type, name) VALUES (DEFAULT, 'H', 'Home Goods');   -- id 3
INSERT INTO product_type(id, type, name) VALUES (DEFAULT, 'B', 'Book');   -- id 4

INSERT INTO product(
	sku, product_type, name, description, perishable, price, weight_in_lbs, taxable)
	VALUES ('A01', 1, 'TE Blue Snuggie', 'A blanket, coat mix that does neither well.', 'N', 24.98, 6, true);
INSERT INTO product(
	sku, product_type, name, description, perishable, price, weight_in_lbs, taxable)
	VALUES ('C02', 2, 'TE Coffee', 'A delicious blend of blue java', 'Y', 8.99, 1, false);
INSERT INTO product(
	sku, product_type, name, description, perishable, price, weight_in_lbs, taxable)
	VALUES ('D4', 3, 'TE Coffee Mug', 'Perfect for containing java.', 'N', 5.55, 1, true);
INSERT INTO product(
	sku, product_type, name, description, perishable, price, weight_in_lbs, taxable)
	VALUES ('B003', 4, 'Surviving TE: The Book', 'A giant book detailing how to survive a bootcamp', 'N', 19.95, 11, true);
INSERT INTO product(
	sku, product_type, name, description, perishable, price, weight_in_lbs, taxable)
	VALUES ('BKSTD01', 4, 'TE Student Book', 'Student Text Book', 'N', 39.95, 5, false);
	
	
	