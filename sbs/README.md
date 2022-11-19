# SpringBoot System

## Konfiguráció

```
spring.jpa.hibernate.ddl-auto

create – Hibernate first drops existing tables and then creates new tables.
update – The object model created based on the mappings (annotations or XML) is compared with the existing schema, and then Hibernate updates the schema according to the diff. It never deletes the existing tables or columns even if they are no longer required by the application.
create-drop – similar to create, with the addition that Hibernate will drop the database after all operations are completed; typically used for unit testing
validate – Hibernate only validates whether the tables and columns exist; otherwise, it throws an exception.
none – This value effectively turns off the DDL generation.
```

## SQL példák

```
SELECT datum AS Dátum,napszak FROM Homerseklet;
SELECT * FROM Homerseklet;
SELECT * FROM Homerseklet WHERE napszak='este' OR varos ilike '%pest%';
SELECT * FROM homerseklet ORDER BY varos desc;
SELECT varos,AVG(fok) FROM homerseklet group by varos;
SELECT COUNT(*), napszak FROM Homerseklet GROUP BY napszak;

update fizetes set beosztas = 'csavar lazító' where fizetes_id = 3;
select * from fizetes;
select d.nev,d.beosztas a,f.ber from fizetes f join dolgozok d on d.beosztas = f.beosztas;

/// Azon telephelyek ahol nem dolgozik senki
SELECT * FROM Dolgozok d JOIN Fizetes f ON d.beosztas = f.beosztas 
	full JOIN Telephelyek t ON d.telephely = t.telephelyek_id 
	where d.dolgozok_id is null;

/// Azon dolgozók akik nincsen a fizetés táblában
SELECT * FROM Dolgozok d full JOIN Fizetes f ON d.beosztas = f.beosztas 
	JOIN Telephelyek t ON d.telephely = t.telephelyek_id 
	where f.fizetes_id is null;

```