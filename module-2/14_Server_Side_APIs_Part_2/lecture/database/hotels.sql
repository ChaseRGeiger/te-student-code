DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS hotel;

CREATE TABLE hotel (
	id serial primary key,
	name varchar(64) not null,
	stars int DEFAULT 0,
	rooms_available int not null,
	cost_per_night numeric not null,
	cover_image varchar(255) DEFAULT ''
);

CREATE TABLE address (
	id serial primary key,
	hotel_id bigint not null,
	address varchar(64) not null,
	address2 varchar(64),
	city varchar(32) not null,
	state varchar(32) not null,
	zip varchar(32) not null,
	
	CONSTRAINT fk_address_hotel_id FOREIGN KEY (hotel_id) REFERENCES hotel(id)
);

CREATE TABLE reservation (
	id serial primary key,
	hotel_id bigint not null,
	fullname varchar(64) not null,
	checkin_date varchar(32) not null,
	checkout_date varchar(32) not null,
	guests int not null,
	
	CONSTRAINT fk_reservation_hotel_id FOREIGN KEY (hotel_id) REFERENCES hotel(id)
);


INSERT INTO hotel (name, stars, rooms_available, cost_per_night)
VALUES ('Aloft Cleveland', 4, 48, 274), ('Hilton Cleveland Downtown', 4, 12, 287),
('Metropolitan at the 9', 5, 22, 319), ('The Westin Pittsburgh', 4, 60, 131),
('Hilton Columbus Downtown',4, 34, 190), ('The Summit A Dolce Hotel', 4, 43, 218),
('Greektown Detroit', 4, 75, 185);

INSERT INTO address (hotel_id, address, address2, city, state, zip) 
VALUES (1, '1111 W 10th St','','Cleveland','Ohio','44115'),
(2,'100 Lakeside Ave','','Cleveland','Ohio','44114'),
(3, '2017 E 9th St','','Cleveland','Ohio','48226'),
(4, '1000 Penn Ave','','Pittsburgh','Pennsylvania','15222'),
(5, '401 N High St','','Columbus','Ohio','43215'),
(6, '5345 Medpace Way','','Cincinnati','Ohio','43215'),
(7, '1200 St Antoine St','','Detroit','Michigan','48226');

INSERT INTO reservation (hotel_id, fullname, checkin_date, checkout_date, guests)
VALUES (1, 'John Smith', '10/27/2022', '10/31/2022', 2), 
(1, 'Sam Turner', '11/01/2022', '11/02/2022', 4), (1, 'Mark Johnson', '11/18/2022', '11/19/2022', 4),
(3, 'Rahelle Rauh', '12/20/2022', '12/21/2022', 3), (3, 'John Fulton', '10/31/2022', '11/04/2022', 2);
