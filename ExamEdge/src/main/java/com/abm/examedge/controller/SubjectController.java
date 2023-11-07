package com.abm.examedge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abm.examedge.entity.Subject;
import com.abm.examedge.service.SubjectService;

@RestController
public class SubjectController {
	
	@Autowired
	private SubjectService subservice;
	
	@PostMapping("/addsubject")
	public String addsubject(@RequestBody Subject sub) {
		subservice.addsubject(sub);
		return "Subject added successfully";
	}
	
	@PostMapping("/deletesubject")
	public String deletesubject(@RequestParam int id) {
		subservice.deletesubject(id);
		return "Subject deleted successfully";
	}
}
