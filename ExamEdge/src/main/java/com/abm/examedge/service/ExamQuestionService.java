package com.abm.examedge.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abm.examedge.entity.ExamQuestion;
import com.abm.examedge.repository.AppearExamQuestionRepository;

@Service
public class ExamQuestionService {

	@Autowired
	private AppearExamQuestionRepository examQuestionRepo;
	
	public ExamQuestion addExamPppearedQuestion(ExamQuestion aeq) {
		return examQuestionRepo.save(aeq);
		 
	}
}
