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
import com.abm.examedge.dto.ResultDto;
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

	@PostMapping("/result")
	public String result(@RequestBody QuestionAnswerDto qadto) {
		Result result = new Result();
		result.setMark(qadto.getMark());
		result.setLevel(qadto.getLevel());
		result.setStudent(qadto.getStudent());
		result.setSubject(qadto.getSubject());
	    reservice.saveresult(result);
	    return "Result added Successfully";
	}

	
	
//	@GetMapping("/studentresult")
//	public List<Result> fetchResultbyIdandLevel(int StudentId,int subid,String level,String mark){
//		List<Result> list= reservice.resultFetchByIdandLevel(StudentId,subid,level, mark);
//		return list;
//
//	}
	
	@GetMapping("/leaderboard")
	public List<ResultDto> leaderboard(){
		List<Object[]> results = reservice.fetchMarks();
		List<ResultDto> rdto = new ArrayList<>();
		ResultDto redto = new ResultDto();
//		for(Object[] lb : results) {
//			redto.setName(lb.getStudent().getName());
//			redto.setMark(lb.getMark());
//			rdto.add(redto);
//		}
		return rdto;
	}
	

	}

