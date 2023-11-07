package com.abm.examedge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abm.examedge.entity.Question;
import com.abm.examedge.service.QuestionService;

@RestController
public class QuestionController {

	@Autowired
	private QuestionService questionser;
	
	@PostMapping("/addquestion")
	public String add(@RequestBody Question que) {
		questionser.addquestion(que);
		return "added question successfully";
		
	}
	@GetMapping("/fetchquestions")
	public List<Question> fetchques(@RequestParam int id,String level) {
		List<Question>list= questionser.questionfetch(id, level);
		return list;
	}
	
	@GetMapping("/fetchquesbyid/{id}")
	public ResponseEntity<Question> fetchbyid(@PathVariable int questionId) {
		
		return questionser.fetchquestionbyid(questionId);
		
		
	}
	
}
