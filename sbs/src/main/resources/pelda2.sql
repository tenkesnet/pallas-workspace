select * from autok;
select * from auto_csop;
select * from tipusok;
select * from alkalmazott;
select * from reszleg;

select tip.tipus_nev , a.rendszam  from autok a join auto_csop ac on ac.id = a.auto_csop_id join tipusok tip on a.tipusok_id = tip.id  where ac.auto_csop_nev <> 'EXTRA';
select * from autok where futott_km > 9000 and ar < 1000000;

select alk_nev, beosztas, fizetes from alkalmazott a order by fizetes;

select alk_nev ,fizetes , premium ,coalesce(premium,0) from alkalmazott where fizetes> 50000 or beosztas = 'SZERELO' order by belepes ;

select * from alkalmazott a join reszleg re on a.reszleg_id  = re.id where re.reszleg_kod in ( select reszleg_kod from reszleg r where r.reszleg_nev like '%AUTO%');

insert into reszleg  (reszleg_kod,reszleg_nev,reszleg_cim) values (80,'KOZPONT','PECS')