package com.abm.examedge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abm.examedge.entity.Subject;
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
}
