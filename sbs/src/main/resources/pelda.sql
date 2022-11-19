CREATE TABLE address (
	address_id SERIAL PRIMARY KEY,
	city TEXT NOT NULL,
	postal_code TEXT NOT NULL,
	street TEXT NOT NULL
)

CREATE TABLE book (
	book_id SERIAL PRIMARY KEY,
	isbn TEXT NOT NULL,
    title TEXT NOT NULL,
    author TEXT,
    genres TEXT,
    issue_date DATE,
    rental_date DATE,
    state INT
)

drop table if exists person cascade;
CREATE TABLE person (
	person_id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    mother_name TEXT NOT NULL,
    birth_day DATE NOT NULL,
    phone_number TEXT CHECK(length(phone_number)>5),
    address_id INT NOT NULL,
    membership_date DATE,
    debit DOUBLE PRECISION NOT NULL CONSTRAINT positive_debit CHECK(debit>0),
	price DOUBLE PRECISION NOT NULL CONSTRAINT positive_price CHECK(price>0),
	 CONSTRAINT fk_address
      FOREIGN KEY(address_id) 
	  REFERENCES address(address_id)
	  ON DELETE CASCADE,
	CHECK(price>debit),
	CONSTRAINT must_be_different UNIQUE(name,mother_name)
)
DROP TABLE person_book;

CREATE TABLE person_book (
	person_id INT NOT NULL REFERENCES person(person_id),
	book_id INT NOT NULL REFERENCES book(book_id),
	PRIMARY KEY(person_id,book_id)
)

INSERT INTO address (city, postal_code,street) VALUES ('Pécs','7623','Pacsirta u. 3');
INSERT INTO address (city, postal_code,street) VALUES ('Budapest','1146','Siklósi u. 10');
INSERT INTO address (city, postal_code,street) VALUES ('Szeged','8076','Uttörő u. 3');

INSERT INTO person (name , mother_name,phone_number,birth_day, address_id, debit, price) 
VALUES ('Jozsibá','Jolinéni','123456','1980-02-12',3,25,30);

TRUNCATE person;

drop table address cascade;

delete from address where address_id=3;

select * from person;
select * from address;
