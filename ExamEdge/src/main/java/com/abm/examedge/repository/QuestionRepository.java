package com.abm.examedge.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.abm.examedge.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
		
	
}
