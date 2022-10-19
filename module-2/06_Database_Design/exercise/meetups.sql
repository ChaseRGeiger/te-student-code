DROP TABLE IF EXISTS group_member;
DROP TABLE IF EXISTS event_group;
DROP TABLE IF EXISTS event_attendees;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS interest_group;
DROP TABLE IF EXISTS event;

CREATE TABLE member(
	member_number serial primary key,
	last_name varchar(20) NOT NULL,
	first_name varchar(20) NOT NULL,
	email_address varchar(64) NOT NULL UNIQUE,
	phone_number varchar(20),
	date_of_birth date NOT NULL,
	reminder_emails boolean NOT NULL
);

CREATE TABLE interest_group(
	group_number serial primary key,
	group_name varchar(64) NOT NULL UNIQUE
);

CREATE TABLE event(
	event_number serial primary key,
	event_name varchar(64) NOT NULL,
	event_description varchar(255),
	start_date_and_time timestamp NOT NULL,
	duration_in_mins bigint NOT NULL,
		
	CONSTRAINT chk_duration_in_mins CHECK (duration_in_mins >= 30)
);

CREATE TABLE group_member(
	member_number bigint,
	group_number bigint,
	
	CONSTRAINT pk_group_member PRIMARY KEY (member_number, group_number),
	CONSTRAINT fk_group_member_member_number FOREIGN KEY(member_number) REFERENCES member(member_number),
	CONSTRAINT fk_group_member_group_number FOREIGN KEY(group_number) REFERENCES interest_group(group_number)
);

CREATE TABLE event_group(
	event_number bigint,
	group_number bigint,
	
	CONSTRAINT pk_event_group PRIMARY KEY (event_number, group_number),
	CONSTRAINT fk_group_member_event_number FOREIGN KEY(event_number) REFERENCES event(event_number),
	CONSTRAINT fk_group_member_group_number FOREIGN KEY(group_number) REFERENCES interest_group(group_number)
);

CREATE TABLE event_attendees(
	event_number bigint,
	member_number bigint,
	
	CONSTRAINT pk_event_attendees PRIMARY KEY (event_number, member_number),
	CONSTRAINT fk_event_attendees_event_number FOREIGN KEY(event_number) REFERENCES event(event_number),
	CONSTRAINT fk_event_attendees_member_number FOREIGN KEY(member_number) REFERENCES member(member_number)
);

INSERT INTO member(last_name, first_name, email_address, date_of_birth, reminder_emails)
VALUES('test1', '1test', 'test1@gmail.com', '10/16/2001', false);

INSERT INTO member(last_name, first_name, email_address, date_of_birth, reminder_emails)
VALUES('test2', '2test', 'test2@gmail.com', '10/16/2002', true);

INSERT INTO member(last_name, first_name, email_address, phone_number, date_of_birth, reminder_emails)
VALUES('test3', '3test', 'test3@gmail.com', '123-456-7890', '10/16/2003', false);

INSERT INTO member(last_name, first_name, email_address, date_of_birth, reminder_emails)
VALUES('test4', '4test', 'test4@gmail.com', '10/16/2004', true);

INSERT INTO member(last_name, first_name, email_address, date_of_birth, reminder_emails)
VALUES('test5', '5test', 'test5@gmail.com', '10/16/2005', true);

INSERT INTO member(last_name, first_name, email_address, date_of_birth, reminder_emails)
VALUES('test6', '6test', 'test6@gmail.com', '10/16/2006', false);

INSERT INTO member(last_name, first_name, email_address, date_of_birth, reminder_emails)
VALUES('test7', '7test', 'test7@gmail.com', '10/16/2007', false);

INSERT INTO member(last_name, first_name, email_address, phone_number, date_of_birth, reminder_emails)
VALUES('test8', '8test', 'test8@gmail.com', '098-765-4321', '10/16/2008', true);

INSERT INTO event(event_name, event_description, start_date_and_time, duration_in_mins)
VALUES('event1', 'fun event', '10/16/2025 10:00:00', 30);

INSERT INTO event(event_name, event_description, start_date_and_time, duration_in_mins)
VALUES('event2', 'kinda fun event', '10/16/2024 12:00:00', 180);

INSERT INTO event(event_name, event_description, start_date_and_time, duration_in_mins)
VALUES('event3', 'no fun event', '10/16/2023 05:00:00', 90);

INSERT INTO event(event_name, event_description, start_date_and_time, duration_in_mins)
VALUES('event4', 'funny event', '10/16/2026 10:00:00', 60);

INSERT INTO interest_group(group_name)
VALUES('group1');

INSERT INTO interest_group(group_name)
VALUES('group2');

INSERT INTO interest_group(group_name)
VALUES('group3');

INSERT INTO event_attendees(event_number, member_number)
VALUES(1, 1);

INSERT INTO event_attendees(event_number, member_number)
VALUES(2, 2);

INSERT INTO event_attendees(event_number, member_number)
VALUES(3, 4);

INSERT INTO event_attendees(event_number, member_number)
VALUES(4, 8);

INSERT INTO group_member(member_number, group_number)
VALUES(1, 1);
INSERT INTO group_member(member_number, group_number)
VALUES(2, 1);

INSERT INTO group_member(member_number, group_number)
VALUES(3, 2);
INSERT INTO group_member(member_number, group_number)
VALUES(4, 2);

INSERT INTO group_member(member_number, group_number)
VALUES(5, 3);
INSERT INTO group_member(member_number, group_number)
VALUES(6, 3);



SELECT * FROM group_member;

SELECT * FROM event_attendees;

SELECT * FROM interest_group;

SELECT * FROM event;

SELECT * FROM member;