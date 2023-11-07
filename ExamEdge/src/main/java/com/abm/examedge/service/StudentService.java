package com.abm.examedge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abm.examedge.entity.Student;
import com.abm.examedge.exception.StudentServiceException;
import com.abm.examedge.repository.StudentDetailsRepository;

@Service
public class StudentService {
		
	
	@Autowired
	private StudentDetailsRepository studentRepo;
	
	public Student login(String emailId, String password) {
		Optional<Student> c = studentRepo.findByEmailIdAndPassword(emailId, password);
		if(c.isPresent())
			return c.get();
		else
			throw new StudentServiceException("Invalid Email/Password!");
	}
	
	public Optional<Student> editDetails(int id) {
		return studentRepo.findById(id);	
	}
	
	public void updaterecord(Student stu) {
		studentRepo.save(stu);
		
	}
	
	public String addstudent(Student studentDetails) {
		studentRepo.save(studentDetails);
		return "added successfully";
		
	}
	
}
