package com.abm.examedge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.abm.examedge.dto.SubjectDto;
import com.abm.examedge.entity.Question;
import com.abm.examedge.entity.Subject;
import com.abm.examedge.service.QuestionService;

@RestController
@CrossOrigin
public class QuestionController {

	@Autowired
	private QuestionService questionser;
	
	@PostMapping("/addquestion")
    public String add(@RequestBody Question question) {
		SubjectDto subject = new SubjectDto();
		Subject sub = new Subject();
//		question.setSubject(subject.getId(question));
//		int s = subject.setId(sub.getId());
		questionser.addQuestion(question);
        return "Added question successfully";
    }
	
	//fetching questions by id and level 
	@GetMapping("/fetchquestions")
	public List<Question> fetchques(@RequestParam int id) {
		List<Question>list= questionser.questionfetch(id);
		return list;
	}
	
	
	@GetMapping("/fetchquesbyid/{id}")
	public ResponseEntity<Question> fetchbyid(@PathVariable int questionId) {
		
		return questionser.fetchquestionbyid(questionId);
		
		
	}
	
	@GetMapping("/fetchallquestion")
	public List<Question> fetchquestion(){
		List<Question>list =questionser.fetchAllQuestion();
		return list;
		
	}
	
	@GetMapping("/fetchquestionsbysubid/{id}")
	public List<Question> fetchQuestionSubId(@PathVariable int id){
		List<Question>list =questionser.fetchQuestionSubId(id);
		return list;
		
	}
	
}
