package com.abm.examedge.controller;



import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abm.examedge.dto.Login;
import com.abm.examedge.dto.Registrationdto;
import com.abm.examedge.entity.Student;
import com.abm.examedge.exception.StudentServiceException;
import com.abm.examedge.service.StudentService;

@RestController
@CrossOrigin 
public class StudentController {

	@Autowired
	private StudentService studentService;



	//localhost:9900/addstudent   url for adding student details
	@PostMapping("/addstudent")
	public Registrationdto add(@RequestBody Student stu) {
	    try {
	        int id = studentService.addStudent(stu);
	        Registrationdto rd = new Registrationdto();
	        rd.setStatus(true);
	        rd.setMessagIfAny("Student registered");
	        return rd;
	    } catch (StudentServiceException e) {
	        Registrationdto rd = new Registrationdto();
	        rd.setStatus(false);
	        rd.setMessagIfAny(e.getMessage());
	        return rd;
	    }
	}
	
	 


	@PostMapping("/student/login")
	public Login login (@RequestBody Student student) {
		try {
			Student studentDetails= studentService.login(student.getEmailId() , student.getPassword());
			Login status = new Login();
			status.setStatus(true);
			status.setId(student.getSid());
			status.setName(student.getName());
			status.setEmailId(student.getEmailId());
			return status;
		}
		catch (StudentServiceException e) {
			Login status = new Login();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			return status;
		}
	}


	@GetMapping("/student/detail")
	public ResponseEntity<?> getStudent(@RequestParam String emailId) {
		try {
			Student student = studentService.findStudent(emailId);
			return ResponseEntity.ok(student);
		} catch (StudentServiceException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}


//	@PostMapping("student/update/record")
//	public String update(@RequestBody Student stu, @RequestParam int sid) {
//		Student student = studentService.editDetails(sid);
//		studentService.updaterecord(stu);
//		return "Record updated";
//	}

	

	


}
