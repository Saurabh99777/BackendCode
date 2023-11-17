package com.abm.examedge.repository;


import java.util.List;
import java.util.Optional;

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

	@Query("SELECT s FROM Question s WHERE s.subject.id=?1")
	public List<Question> fetchQuestionBySubid(int id);
}
