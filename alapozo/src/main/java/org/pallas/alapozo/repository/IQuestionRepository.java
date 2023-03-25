
package org.pallas.alapozo.repository;

import org.pallas.alapozo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IQuestionRepository extends JpaRepository<Question, Integer>{
    
}
