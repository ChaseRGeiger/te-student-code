BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS product_categories;

CREATE TABLE product_categories (
	id serial NOT NULL PRIMARY KEY,
	category VARCHAR(32) NOT NULL UNIQUE
);

INSERT INTO product_categories (category) VALUES ('Home');     -- 1
INSERT INTO product_categories (category) VALUES ('Apparel');  -- 2
INSERT INTO product_categories (category) VALUES ('Jewelry');  -- 3
INSERT INTO product_categories (category) VALUES ('Garden');   -- 4
INSERT INTO product_categories (category) VALUES ('Books');    -- 5

CREATE TABLE products (
   	id            serial  NOT NULL PRIMARY KEY,
  	category      int NOT NULL,
  	name          VARCHAR(64) NOT NULL,
  	image_name    VARCHAR(255) NOT NULL,
  	rating        INTEGER DEFAULT 0,
  	is_top_seller BOOLEAN DEFAULT false,
  	quantity      INTEGER  DEFAULT 0,
  	price         NUMERIC(10,2) NOT NULL,
	
	CONSTRAINT fk_product_category FOREIGN KEY (category) REFERENCES product_categories(id)
);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,1,'Cream Sofa','cream-sofa.jpg',2.7,'false',3,750);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,1,'Grey Sofa','grey-sofa.jpg',4.7,'false',0,939);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,1,'Yellow Sofa','yellow-sofa.jpg',0,'false',0,559);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,1,'Black Bean Bag Chair','black-bean-bag-chair.jpg',4.2,'true',20,39.95);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,1,'Copper Light','copper-light.jpg',3.6,'false',200,59.99);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,1,'Vanilla candle','vanilla-candle.jpg',1.9,'true',12,589.99);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,1,'Pink Armchair','pink-armchair.jpg',5,'false',500,499.99);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,1,'Antique Drawers','antique-drawers.jpg',2,'false',1225,99.99);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,1,'Brown Throw Pillows','brown-throw-pillows.jpg',4,'false',994,29.99);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,1,'Knitted Throw Pillows','knitted-throw-pillows.jpg',1,'false',3245,29.99);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,2,'Ocean Blue Shirt','ocean-blue-shirt.jpg',0,'false',500,22.95);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,2,'Classic Varsity Top','classic-varsity-top.jpg',4.5,'false',500,89.95);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,2,'Blue Silk Tuxedo','blue-silk-tuxedo.jpg',4,'true',8,399.95);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,2,'LED High Tops','led-high-tops.jpg',5,'true',1,129.95);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,2,'Dark Denim Top','dark-denim-top.jpg',5,'true',0,299.95);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,2,'Yellow Wool Jumper','yellow-wool-jumper.jpg',0.6,'false',10000,19.95);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,2,'Classic Leather Jacket','classic-leather-jacket.jpg',0,'true',3,52.75);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,2,'Olive Green Jacket','olive-green-jacket.jpg',3.9,'false',2,35.01);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,3,'Seven Chakra Bracelet','seven-chakra-bracelet.jpg',4.5,'true',2,10.5);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,3,'Boho Earrings','boho-earrings.jpg',2.7,'false',4,12.5);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,3,'Choker with Bead','choker-with-bead.jpg',0.9,'false',5,20);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,3,'Dreamcatcher Pendant Necklace','dreamcatcher-pendant-necklace.jpg',4.9,'true',1,24.99);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,3,'Galaxy Earrings','galaxy-earrings.jpg',1.9,'false',300,19.66);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,3,'Moon Charm Bracelet','moon-charm-bracelet.jpg',3.1,'false',14,10);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,3,'Origami Crane Necklace','origami-crane-necklace.jpg',5,'true',1,100);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,3,'Gold Elephant Earrings','gold-elephant-earrings.jpg',0,'false',2,35.01);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,4,'Clay Plant Pot','clay-plant-pot.jpg',3,'true',99,9.99);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,4,'Wooden Outdoor Table','wooden-outdoor-table.jpg',1,'true',4,99.99);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,4,'Biodegradable Cardboard Pots','biodegradable-cardboard-pots.jpg',4.3,'false',1000,15.25);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,4,'Gardening Hand Trowel','gardening-hand-trowel.jpg',2,'false',500,49.95);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,4,'White Ceramic Pot','white-ceramic-pot.jpg',4,'false',300,9.99);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,4,'Yellow watering can','yellow-watering-can.jpg',5,'true',25,79.99);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,4,'Wooden outdoor slats','wooden-outdoor-slats.jpg',1,'false',2765,5.99);
INSERT INTO products(id,category,name,image_name,rating,is_top_seller,quantity,price) VALUES (DEFAULT,4,'Wooden Fence','wooden-fence.jpg',4,'false',7725,7.99);




COMMIT TRANSACTION;
