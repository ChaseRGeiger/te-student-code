DROP TABLE person;
DROP TABLE address;
DROP TABLE phone;

CREATE TABLE person (
        person_id serial,
        first_name varchar(128),
        last_name varchar(128),
        active boolean
);

CREATE TABLE address (
        address_id serial,
        person_id int,
        street varchar(128),
        city varchar(128),
        state char(2)
);

CREATE TABLE phone (
        phone_id serial,
        person_id int,
        phone_number varchar(20),
        type varchar(20)
);

INSERT INTO person VALUES (1, 'Sasha', 'Red', true);
INSERT INTO person VALUES (2, 'Jenny', 'Smith', false);
INSERT INTO person VALUES (3, 'Dave', 'Warthog', true);
INSERT INTO person VALUES (4, 'Ratboy', 'Jones', true);

INSERT INTO address VALUES (DEFAULT, 1, '123 Street', 'Columbus', 'OH');
INSERT INTO address VALUES (DEFAULT, 2, 'ABC Corner Blvd', 'Cleveland', 'OH');
INSERT INTO address VALUES (DEFAULT, 3, 'Yay Lane', 'Columbus', 'OH');
INSERT INTO address VALUES (DEFAULT, 4, 'Bill Road', 'New Town', 'OH');

INSERT INTO phone VALUES (DEFAULT, 1, '614-555-1212', 'WORK');
INSERT INTO phone VALUES (DEFAULT, 1, '740-888-4545', 'HOME');
INSERT INTO phone VALUES (DEFAULT, 2, '614-867-5309', 'MOBILE');
INSERT INTO phone VALUES (DEFAULT, 3, '888-882-4509', 'WORK');
INSERT INTO phone VALUES (DEFAULT, 4, '555-555-5812', 'HOME');
