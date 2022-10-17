DROP TABLE IF EXISTS person_address;
DROP TABLE IF EXISTS person_phone;
DROP TABLE IF EXISTS person_email;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS phone;
DROP TABLE IF EXISTS email;

CREATE TABLE person (
	person_id serial primary key,
	first_name varchar(36) not null, 
	last_name varchar(36) not null,
	last_updated timestamp DEFAULT current_timestamp,
	date_added date DEFAULT current_date
);


CREATE TABLE address (
	address_id serial primary key,
	line_one varchar(30) not null,
	line_two varchar(30),
	city varchar(36) not null,
	region varchar(36) not null,
	postal_code varchar(20),
	country_code char(3),
	address_type varchar(10),
	address_description varchar(255),
	
	CONSTRAINT chk_address_type CHECK (address_type IN ('HOME', 'WORK', 'BILLING', 'SHIPPING', 'OTHER')),
	CONSTRAINT chck_address_description CHECK ( 
		(address_type = 'OTHER' AND address_description IS NOT NULL) OR (address_type != 'OTHER' AND address_description IS NULL) )
);

CREATE TABLE person_address(
	person_id bigint,
	address_id bigint,
	
	CONSTRAINT pk_peson_address PRIMARY KEY (person_id, address_id),
	CONSTRAINT fk_person_address_person_id FOREIGN KEY (person_id) REFERENCES person(person_id),
	CONSTRAINT fk_person_address_address_id FOREIGN KEY (address_id) REFERENCES address(address_id)
);


CREATE TABLE phone (
	phone_id serial primary key,
	access_code varchar(10),
	phone_number varchar(20) not null unique,
	phone_type varchar(10),
	phone_description varchar(255)
);

CREATE TABLE person_phone (
	person_id bigint,
	phone_id bigint, 
	
	CONSTRAINT pk_person_phone PRIMARY KEY (person_id, phone_id),
	CONSTRAINT fk_person_phone_person_id FOREIGN KEY (person_id) REFERENCES person(person_id),
	CONSTRAINT fk_person_phone_phone_id FOREIGN KEY (phone_id) REFERENCES phone(phone_id)
);

CREATE TABLE email (
	email_id serial primary key,
	email_address varchar(255) not null unique,
	email_type varchar(10),
	email_description varchar(255)
);

CREATE TABLE person_email (
	person_id bigint,
	email_id bigint,
	
	CONSTRAINT pk_person_email PRIMARY KEY (person_id, email_id),
	CONSTRAINT fk_person_email_person_id FOREIGN KEY (person_id) REFERENCES person(person_id),
	CONSTRAINT fk_person_email_email_id FOREIGN KEY (email_id) REFERENCES email(email_id)
);

INSERT INTO person (first_name, last_name) VALUES ('John', 'Fulton'), ('Steve', 'Carmichael'); -- John:1, Steve:2
INSERT INTO address (line_one, city, region, address_type) VALUES ('123 Fulton Blvd', 'Columbus', 'OH', 'HOME'), ('82 Steve St', 'Powell', 'OH', 'SHIPPING');
INSERT INTO person_address VALUES (1,1), (2,2);
INSERT INTO phone (access_code, phone_number, phone_type) VALUES ('+01', '614-555-8276', 'HOME'), ('', '740-555-19050', 'MOBILE');
INSERT INTO person_phone VALUES (1,1), (1,2);
INSERT INTO email (email_address, email_type) VALUES ('john@techelevator.com', 'WORK'), ('Steve@techelevator.com', 'WORK');


