package com.abm.examedge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abm.examedge.entity.Student;

public interface StudentDetailsRepository extends JpaRepository<Student, Integer> {
	
public Optional<Student> findByEmailIdAndPassword(String emailId, String password);
	
	@Query("select count(s) from Student s where s.emailId =?1 ")
	public Long findStudentExists(String emailId);
	
	@Query("select s from Student s where s.emailId = ?1")
	public Student findStudentByEmailId(String emailId);
}
