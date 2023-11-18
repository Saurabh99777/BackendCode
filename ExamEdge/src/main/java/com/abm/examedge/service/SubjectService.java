package com.abm.examedge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abm.examedge.entity.Subject;
import com.abm.examedge.exception.SubjectNotFoundException;
import com.abm.examedge.repository.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository subrepo;
	
	
	public void addsubject(Subject sub) {
		subrepo.save(sub);
	}
	

	public void deletesubject(int id) {
		subrepo.deleteById(id);
	}
	
//	public ResponseEntity<Subject> SearchStudent(int id) {
//		Optional<Subject> subjectOptional = subrepo.findById(id);
//		if (subjectOptional.isPresent()) {
//            return ResponseEntity.ok(subjectOptional.get()); 
//        } else {
//            // Return a 404 Not Found response if the entity is not found
//            return ResponseEntity.notFound().build();
//        }
//	}
	
	public Optional<Subject> SearchSubject(int id){
		Optional<Subject> list = subrepo.findById(id);
		if(list.isPresent())
			return list;
		throw new SubjectNotFoundException("Subject Not Found");
	}
	
	
	public List<Subject> searchAll(){
		List<Subject> list = subrepo.findAll();
			return list;
	}
	
	
	
	
}
