package org.pallas.alapozo.repository;

import java.util.List;

import org.pallas.alapozo.model.Alkalmazott;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlkalmazottRepository extends JpaRepository<Alkalmazott, Integer> {
	List<Alkalmazott> findByAlkNev(String name);
	List<Alkalmazott> findByAlkNevContaining(String name);
}
