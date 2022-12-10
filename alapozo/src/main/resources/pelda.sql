--select * from reszleg
--select * from alkalmazott
--select * from beosztas
--select * from rendeles
--select * from autok
--select * from auto_csop

--select * from reszleg where lower(reszleg_nev) not like '%auto%';

--select * from alkalmazott a join reszleg r on a.reszleg_id = r.id   where (r.reszleg_kod=20 and a.beosztas like 'ELADO') or premium is  null;

--select * from alkalmazott where (fizetes between 10000 and 60000) and beosztas  not in ( 'TELEPHELYVEZETO', 'ELADO')

--select * from alkalmazott where fizetes < premium*2 

select * from rendeles where km_veg>=km_kezdet+1000 or napok>10;

select lower(alk_nev),length(beosztas) from alkalmazott;

select beosztas, lower( substr(beosztas,4,3) ) from alkalmazott;

select * from tipusok;
select '"' || rpad(t.tipus_nev,20) || '"' from autok a join tipusok t on a.tipusok_id = t.id;


SELECT ABS(1000),ABS(-100),ABS(-27.11);
SELECT SQRT(25),SQRT(abs(-36));
SELECT POWER(2,5);
SELECT ROUND(-123.456,2),ROUND(123.456,0),ROUND(153.456,-2),ROUND(-123.4567,2);
SELECT TRUNC(123.45,1),TRUNC(123.45,0),ROUND(127.45,-1),TRUNC(123.45,-2);
SELECT SIGN(10),SIGN(0),SIGN(-5);
SELECT CEIL(6.1),CEIL(-6.1);
SELECT FLOOR(6.1),FLOOR(-6.1);
SELECT MOD(11,3);

SELECT rendszam,tipus_nev,TO_CHAR(vasarlas_datuma,'the DD day of Mon, YYYY') 
FROM autok a 
join tipusok t on a.tipusok_id = t.id 
join auto_csop acs on a.auto_csop_id = acs.id
WHERE auto_csop_nev='NORMAL';

SELECT * FROM rendeles WHERE kolcson_kezdete-rendeles_datum < 7;

SELECT kolcson_kezdete-rendeles_datum,* FROM rendeles;


select extract( year from age(now(),'2018-04-01') )*12 + extract( month from age(now(),'2018-04-01')) ;


select extract( decade from age(now(),'2018-04-01'));

select extract( millennium from TIMESTAMP '2022-01-01');

SELECT 
rendszam,vasarlas_datuma,
extract(year from age(now(), vasarlas_datuma)) * 12 + extract(month from age(now(), vasarlas_datuma)) ho,
(ar/100)*3 amort_ert,
ar vasarlasi_ar,
ar - (ar/100)*3*(extract(year from age(now(), vasarlas_datuma)) * 12 + extract(month from age(now(), vasarlas_datuma)))
FROM autok WHERE vasarlas_datuma < '1994-01-01';


