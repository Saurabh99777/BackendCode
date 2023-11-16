package com.abm.examedge.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abm.examedge.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
		
	
	@Query(value = "SELECT q FROM Question q WHERE q.subject.id= ?1 AND q.level = 'Basic'")
	 public List<Question> questionfecth(int id);
	
	//@Query("SELECT q FROM Question q WHERE q.subject.id = :id AND q.level = :level")
	
	
//	@Query("SELECT q FROM Question q WHERE q.subject.id = ?1 and q.level='?2'")
//	public List<Question> questionFetch(@Param("subjectId") int subjectId);

}
