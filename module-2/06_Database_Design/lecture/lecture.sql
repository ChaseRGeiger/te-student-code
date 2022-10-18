-- ***************************************
--   DDL (Data Definition Language)
-- ***************************************

DROP DATABASE DDLExamples;
CREATE DATABASE DDLExamples;

-- Create a Table called ourtable with an id (primary key) and name varchar(32)
CREATE TABLE ourtable (
        id bigint primary key,
        name varchar(32)
);

-- Alter the table to add column called description
ALTER TABLE ourtable ADD COLUMN description varchar(255);

-- Alter the table to make id the primary key
ALTER TABLE ourtable ADD CONSTRAINT pk_ourtable_id PRIMARY KEY (id);

-- DROP ourtable
DROP TABLE ourtable;

-- Create a Table with a sequence as the primary key
CREATE TABLE ourtable (
        id serial primary key,
        name varchar(32)
);



-- ***************************************
--   Sequences
-- ***************************************

-- Get the next value from the sequence
SELECT nextval('ourtable_id_seq');

-- Create a sequence that starts at 101 instead of 1
CREATE SEQUENCE our_custom_sequence START 101;

-- Get the next value from the new sequence
SELECT nextval('our_custom_sequence');

-- Alter the Sequence to restart at 1000 and increment by 2
ALTER SEQUENCE our_custom_sequence RESTART 1000 INCREMENT BY 2;

-- Select the next value from the altered sequence a few times
SELECT nextval('our_custom_sequence');

-- Drop the custom Sequence
DROP SEQUENCE our_custom_sequence;

SELECT * FROM ourtable;

-- Insert into the table with a sequence using nextval() in a subquery
INSERT INTO ourtable (id, name) VALUES ((SELECT nextval('ourtable_id_seq')), 'Steve');

-- Insert into the table with a sequence using DEFAULT to populate the sequence
INSERT INTO ourtable (id, name) VALUES (DEFAULT, 'Matt');

-- Insert into the table with a sequence by omitting the column in the Insert
INSERT INTO ourtable (name) VALUES ('John');

-- Insert into the table with a sequence with a manual value  (CHANGE XX to the next correct value)
INSERT INTO ourtable (id, name) VALUES ( 8 , 'Dan');

-- Try to insert another value using DEFAULT or a SubQuery or by Omitting the column in the insert
INSERT INTO ourtable (id, name) VALUES (DEFAULT, 'Vinny');

 SELECT * FROM ourtable;
 
-- inserting into a table in a Transaction with a ROLLBACK
START TRANSACTION;
INSERT INTO ourtable (id, name) VALUES (DEFAULT, 'Rachelle');
ROLLBACK;

-- Insert another value into the table and check the sequence
INSERT INTO ourtable (id, name) VALUES (DEFAULT, 'Rachelle');

-- Drop the table, what happens to the sequence that was automatically created for it?
DROP TABLE ourtable;




-- Recreate ourtable and add some rows
CREATE TABLE ourtable (
        id serial primary key,
        name varchar(32)
);
INSERT INTO ourtable (name) VALUES ('John'), ('Matt'), ('Steve'), ('Dan');

SELECT * FROM ourtable;


-- ***************************************
--   DCL (Data Control Language)
-- ***************************************

-- Create a new user
CREATE USER rachelle WITH PASSWORD '123';

-- GRANT access to the user to SELECT from ourtable
GRANT SELECT ON ourtable TO rachelle;

-- GRANT access to the user to INSERT into ourtable
GRANT INSERT ON ourtable TO rachelle ;

-- GRANT the user access to use the sequence used by ourtable
GRANT USAGE, SELECT ON SEQUENCE ourtable_id_seq TO rachelle;

-- REVOKE the user's access to SELECT from ourtable
REVOKE SELECT ON ourtable FROM rachelle;


SELECT * FROM ourtable;
