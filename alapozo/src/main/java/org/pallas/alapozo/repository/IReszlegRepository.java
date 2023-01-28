package org.pallas.alapozo.repository;

import org.pallas.alapozo.model.Reszleg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IReszlegRepository extends JpaRepository<Reszleg, Integer>{

}
