
package org.pallas.alapozo.repository;

import java.util.List;
import org.pallas.alapozo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IQuestionRepository extends JpaRepository<Question, Integer>{
    
    @Query(value= "select * from question q join answare a on a.fk_question_id=q.question_id",nativeQuery = true)
    public List<Question> getQuestions();
}
