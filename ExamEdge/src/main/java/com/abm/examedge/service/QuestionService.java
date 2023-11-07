package com.abm.examedge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abm.examedge.repository.QuestionRepository;


@Service
public class QuestionService {

	@Autowired 
	private QuestionRepository questionRepo;
	
	public void deleteQuestion(int id ) {
		
		questionRepo.deleteById(id);
		
	}
	
}
