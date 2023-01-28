package org.pallas.alapozo.repository;

import java.util.Date;
import java.util.List;

import org.pallas.alapozo.model.Alkalmazott;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlkalmazottRepository extends JpaRepository<Alkalmazott, Integer> {
	List<Alkalmazott> findByAlkNev(String name);
	List<Alkalmazott> findByAlkNevContaining(String name);
	List<Alkalmazott> findByAlkNevIgnoreCaseContaining(String name);
	List<Alkalmazott> findByBelepesBetween(Date start,Date end);
	List<Alkalmazott> findByBelepesBetweenAndFizetesGreaterThan(Date start,Date end,int fizetes);
}
