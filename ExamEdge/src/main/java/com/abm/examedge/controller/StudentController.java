package com.abm.examedge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abm.examedge.dto.Login;
import com.abm.examedge.entity.Student;
import com.abm.examedge.exception.StudentServiceException;
import com.abm.examedge.service.StudentService;

@RestController
@CrossOrigin 
public class StudentController {
		@Autowired
		private StudentService studentService;
		
		
		@PostMapping("/student/login")
	public Login login (@RequestBody Student student) {
		try {
			Student studentDetails= studentService.login(student.getEmailId() , student.getPassword());
			Login status = new Login();
			status.setStatus(true);
			status.setId(studentDetails.getId());
			status.setName(studentDetails.getName());
			
			return status;
		}
		catch (StudentServiceException e) {
			Login status = new Login();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			return status;
		}
		
		
		
		
	}
}
