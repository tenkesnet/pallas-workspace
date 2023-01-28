package org.pallas.alapozo.repository;

import java.util.List;

import org.pallas.alapozo.model.AutoCsop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAutoCsopRepository extends JpaRepository<AutoCsop, Integer> {
	List<AutoCsop> findByAutokRendszamIgnoreCase(String rendszam);
}
