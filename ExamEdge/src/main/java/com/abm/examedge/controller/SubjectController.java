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
	
	//http://localhost:8080/searrch?id=4
	
		@GetMapping("/searrch/{id}")
		public ResponseEntity<Subject> search(@PathVariable int id){
			return subservice.SearchStudent(id);

			}
		
		//http://localhost:8080/allsubjects
		@GetMapping("/allsubjects")
		public List<Subject> findall(){
			return subservice.searchAll();
		}
}
