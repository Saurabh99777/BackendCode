package com.abm.examedge.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abm.examedge.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
		
	
	@Query(value = "SELECT q FROM Question q WHERE q.subject.id <> ?1 AND q.level = ?2 ORDER BY RAND() ")
	 public List<Question> questionfecth(@Param("subId")int id,@Param("level") String level);
}
