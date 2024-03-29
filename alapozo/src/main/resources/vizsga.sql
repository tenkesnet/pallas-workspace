drop table if exists public.question cascade;
CREATE TABLE public.question (
	question_id serial NOT null primary key,
	question text NOT NULL,
	solution text NOT null,
	question_number integer unique
);
GRANT UPDATE, TRIGGER, REFERENCES, DELETE, TRUNCATE, INSERT, SELECT ON TABLE public.question TO pallas;

drop table if exists answare;
create table answare (
	answare_id serial not null primary key,
	answare_number varchar(1),
	answare text,
	fk_question_id integer,
	CONSTRAINT fk_question
      FOREIGN KEY(fk_question_id) 
	  REFERENCES question(question_id)
);

select count(*) from question q ;
select count(*) from answare;

select distinct(answare_number) from answare;
