package com.abm.examedge.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.abm.examedge.entity.Student;
import com.abm.examedge.exception.StudentServiceException;
import com.abm.examedge.repository.StudentDetailsRepository;

@Service
public class StudentService {
		
	
	@Autowired
	private StudentDetailsRepository studentRepo;
	
//	@Value("${file.upload-dir}")
//    private String uploadDirectory;
//
//    @Value("${file.base-url}")
//    private String baseUrl;
	
	public int addStudent(Student student) {
	    Long count = studentRepo.findStudentExists(student.getEmailId());
	    if (count == 0) {
	        // Save the image to a file or a cloud storage service
//			String imageUrl = saveImageToFileOrStorage(file);

			// Set the image URL in the student object
//				

			// Save the student to the database
			Student savedStudent = studentRepo.save(student);

			return savedStudent.getSid();
	    } else {
	        throw new StudentServiceException("Student already exists");
	    }
	}
	
	

//	public String saveImageAndGetUrl(MultipartFile file) throws IOException {
//        // Save the image to the configured folder
//        String fileName = file.getOriginalFilename();
//        Path filePath = Paths.get(uploadDirectory, fileName);
//
//        // Save the file to the folder
//        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//        // Return the URL of the saved image
//        return baseUrl + fileName; // Adjust the URL format based on your requirements
//    }
	
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
	
	public Student findStudent(String emailId) {
		Student student =  studentRepo.findStudentByEmailId(emailId);
		if(student != null)
			return student;
		else
			throw new StudentServiceException("Email not found");
	}
	
	
	
	
	
	
}
