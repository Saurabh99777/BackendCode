package com.abm.examedge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.abm.examedge.dto.StudentResultDto;
import com.abm.examedge.entity.Result;
import com.abm.examedge.exception.UserException;
import com.abm.examedge.service.ResultService;

@RestController
public class ResultController {

	
	@Autowired
	private ResultService reservice;
	
	@GetMapping("/result-bysubid/{subid}")
	public List<Result> fetchresult(@PathVariable ("subid")int subid){
		try {
		List<Result>list=reservice.showresult(subid);
		return list;
		}catch (UserException e){
			
			return null;
		}
}
	
	
	@GetMapping("/studentresult")
	public List<Result> fetchResultbyIdandLevel(int StudentId,int subid,String level,String mark){
		List<Result> list= reservice.resultFetchByIdandLevel(StudentId,subid,level, mark);
		return list;
		
	}
}
