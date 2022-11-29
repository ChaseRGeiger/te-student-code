DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS products;

CREATE TABLE products (
    id serial primary key,
    name varchar(255) NOT NULL,
    description text DEFAULT ''
);

CREATE TABLE reviews (
    id serial primary key,
    product_id bigint not null,
    reviewer varchar(255) NOT NULL,
    title varchar(255) NOT NULL,
    review text NOT NULL,
    rating int NOT NULL,
    favorited boolean DEFAULT false,

    CONSTRAINT fk_reviews_product_id FOREIGN KEY (product_id) REFERENCES products(id)
);

-- 1
INSERT INTO products (name, description) 
VALUES ('Cigar Parties for Dummies', 'Host and plan the perfect cigar party for all of your squirrelly friends.');
-- 2
INSERT INTO products (name) VALUES ('Personal Finance for Dummies');
-- 3
INSERT INTO products (name) VALUES ('Project Management for Dummies');
-- 4
INSERT INTO products (name) VALUES ('Critical Thinking Skills for Dummies');
-- 5
INSERT INTO products (name) VALUES ('Home Maintenance for Dummies');

INSERT INTO reviews(
	product_id, reviewer, title, review, rating, favorited)
	VALUES (1, 'Malcolm Gladwell', 'What a book!', 'It certainly is a book. I mean, I can see that. Pages kept together with glue and there is writing on it, in some language.', 3, false);

INSERT INTO reviews(
	product_id, reviewer, title, review, rating, favorited)
	VALUES (1, 'Tim Ferriss', 'Had a cigar party started in less than 4 hours.', 'It should have been called the four hour cigar party. That is amazing. I have a new idea for muse because of this.', 4, false);

INSERT INTO reviews(
	product_id, reviewer, title, review, rating, favorited)
	VALUES (1, 'Ramit Sethi', 'What every new entrepreneurs needs. A door stop.', 'When I sell my courses, I am always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.', 1, false);

INSERT INTO reviews(
	product_id, reviewer, title, review, rating, favorited)
	VALUES (1, 'Gary Vaynerchuk', 'And I thought I could write', 'There are a lot of good, solid tips in this book. I do not want to ruin it, but prelighting all the cigars is worth the price of admission alone.', 3, false);
