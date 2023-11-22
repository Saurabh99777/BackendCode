package com.abm.examedge.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abm.examedge.dto.QuestionDto;
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
	
	
	public List<Question> fetchquestionbyid( int id) {
		List<Question> list=questionRepo.fetchQuestionBySubid(id);
		
		return list;
	}
	
	//fetch all questions 
	public List<Question>fetchAllQuestion(){
		List<Question> list= questionRepo.findAll();
		return list;
	}
	
	public int scorecheck(int sid, List<QuestionDto> qadtoList) {
	    int marks = 0;
	    List<Question> list = questionRepo.fetchanswer();

	    for (QuestionDto qadto : qadtoList) {
	        for (Question question : list) {
	            int qid = question.getQuestionId();
	            int id = qadto.getQuestionId();
	            String uanswer = qadto.getUanswer();
	            String answer = question.getAnswer();

	            if (qid == id && answer.equals(uanswer)) {
	                marks++;
	                // Break inner loop if a match is found for the current question
	                break;
	            }
	        }
	    }
	    return marks;
	}
	
	
	
	
}
