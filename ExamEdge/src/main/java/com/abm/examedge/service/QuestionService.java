package com.abm.examedge.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.abm.examedge.entity.Question;

import com.abm.examedge.repository.QuestionRepository;


@Service
public class QuestionService {

	@Autowired 
	private QuestionRepository questionRepo;
	
	public void deleteQuestion(int id ) {
		
		questionRepo.deleteById(id);
		
	}
	 public void addQuestion(Question question) {
	        questionRepo.save(question);
	    }
	 
	 
	 //fetching questions by id and level 
	public List<Question> questionfetch( int id){
		List<Question>list= questionRepo.questionfecth(id);
		return list;
	}
	
	
	public ResponseEntity<Question> fetchquestionbyid( int questionId) {
		Optional<Question>list=questionRepo.findById(questionId);
		
		return ResponseEntity.of(list);
	}
	
	//fetch all questions 
	public List<Question>fetchAllQuestion(){
		List<Question> list= questionRepo.findAll();
		return list;
	}
	
	
	public List<Question> fetchQuestionSubId(int id){
		List<Question>list=questionRepo.fetchQuestionBySubid(id);
		return list;
		
	
		
	}
	
}
