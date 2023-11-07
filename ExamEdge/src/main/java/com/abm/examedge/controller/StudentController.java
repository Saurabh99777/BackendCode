package com.abm.examedge.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

		// http://localhost:8080/studentdetails?id=3   url for fetching student details
		@GetMapping("/studentdetails")
		public Optional<Student> findStudent(@RequestParam int id){
			return studentService.editDetails(id);
			 
		}
		
		@PostMapping("/updaterecord/{id}")
		public String update(@RequestBody Student stu) {
			studentService.updaterecord(stu);
			return "Record updated";
		}
		
		
		//localhost:9900/addstudent   url for adding student details
		@PostMapping("/addstudent")
		public String add(@RequestBody Student stu) {
			studentService.addstudent(stu);
			return "added successfully";
		}
		
		
}
