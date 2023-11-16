package com.abm.examedge.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
	 
	 
	 
	public List<Question> questionfetch( int id,String level){
		List<Question>list= questionRepo.questionfecth(id, level);
		if(list.size()>10) {
			return list.subList(0, 9);
		}
		return list;
		}
	
	public ResponseEntity<Question> fetchquestionbyid( int questionId) {
		Optional<Question>list=questionRepo.findById(questionId);
		
		return ResponseEntity.of(list);
	}
	
	
	
}
