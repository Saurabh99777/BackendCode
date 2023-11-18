package com.abm.examedge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abm.examedge.dto.QuestionAnswerDto;
import com.abm.examedge.entity.Result;
import com.abm.examedge.exception.UserException;
import com.abm.examedge.service.ResultService;

@RestController
@CrossOrigin
public class ResultController {


	@Autowired
	private ResultService reservice;

	@GetMapping("/student/result")
	public List<Result> fetchresult(@RequestParam int id){
		try {
			List<Result>list=reservice.showresult(id);
			return list;
		}catch (UserException e){

			return null;
		}



	}

//	@PostMapping("/result")
//	public QuestionAnswerDto result(@RequestBody Result result) {
//		reservice.saveresult(result);
//		QuestionAnswerDto qadto = new QuestionAnswerDto();
//		qadto.getLevel(result.setLevel("Basic"));
//		return qadto; 
//	}
}
