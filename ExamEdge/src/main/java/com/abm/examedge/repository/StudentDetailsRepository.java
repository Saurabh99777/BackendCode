package com.abm.examedge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abm.examedge.entity.Student;

public interface StudentDetailsRepository extends JpaRepository<Student, Integer> {

	public Optional<Student> findByEmailIdAndPassword(String emailId, String password);
	
		
}
