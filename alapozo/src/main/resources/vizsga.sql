drop table if exists public.question cascade;
CREATE TABLE public.question (
	id serial NOT null primary key,
	question text NOT NULL,
	answare text NOT null,
	question_number integer unique
);
GRANT UPDATE, TRIGGER, REFERENCES, DELETE, TRUNCATE, INSERT, SELECT ON TABLE public.question TO pallas;

drop table if exists answare;
create table answare (
	id serial not null primary key,
	answare_number varchar(1),
	answare text,
	question_id integer,
	CONSTRAINT fk_question
      FOREIGN KEY(question_id) 
	  REFERENCES question(id)
);

select * from question q ;
select count(*) from answare;