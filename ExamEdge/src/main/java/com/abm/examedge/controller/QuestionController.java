package com.abm.examedge.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abm.examedge.dto.QuestionDto;
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
	
//	@GetMapping("/fetchquestions")
//	public List<Question> fetchques(@RequestParam int id,String level) {
//		List<Question>list= questionser.questionfetch(id, level);
//		return list;
//	}
	

	
//	@GetMapping("/fetchquesbyid/{id}")
//	public ResponseEntity<Question> fetchbyid(@PathVariable int questionId) {
//		
//		return questionser.fetchquestionbyid(questionId);
//		
//		
//	}
	
	@GetMapping("/fetchallquestion")
	public List<Question> fetchquestion(){
		List<Question>list =questionser.fetchAllQuestion();
		return list;
		
	}

	
	@GetMapping("/fetchquestionsbysubid")
	public List<QuestionDto> fetchQuestionSubId(@RequestParam int id){
		List<Question>list =questionser.fetchquestionbyid(id);
		List<QuestionDto> qdto = new ArrayList<QuestionDto>();
		for(Question question:list) {
			QuestionDto qadto = new QuestionDto();
			qadto.setQuestionId(question.getQuestionId());
			qadto.setQuestion(question.getQuestion());
			qadto.setOption1(question.getOption1());
			qadto.setOption2(question.getOption2());
			qadto.setOption3(question.getOption3());
			qadto.setOption4(question.getOption4());
			qadto.setLevel(question.getLevel());
			qadto.setSubject(question.getSubject());
			
			qdto.add(qadto);
		}
		return qdto;
		
	}
	
	@PostMapping("/score/calculator")
	public int scorecalculate(@RequestBody List<QuestionDto> qadtoList) {
	    int id = qadtoList.get(0).getSubject().getId(); // Assuming all questions have the same subject ID
	    int score = questionser.scorecheck(id, qadtoList);
	    return score;
	}
	
	
	@PostMapping("/deletequestion/{id}")
	public String deletequestid(@PathVariable int id) {
		
	 questionser.deleteQuestion(id);
	 return "Deleted successfully";
		
	}
	
}
