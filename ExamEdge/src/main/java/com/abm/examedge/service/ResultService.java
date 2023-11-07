package com.abm.examedge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.abm.examedge.entity.Result;
import com.abm.examedge.exception.UserException;
import com.abm.examedge.repository.ResultRepository;


@Service
public class ResultService {
	
	@Autowired 
	private ResultRepository resultRepo;
	
//	public List<ResultEntity> results(@RequestParam int id, String level){
//		List<ResultEntity> list =resultRepo.findResultsBySubjectIdAndLevel(id , level );
//		return list;
//		
//		
//	} 
	
	public List<Result>showresult(int subid){
		List<Result> list = resultRepo.resultfetch(subid);
		if(list!=null) {
			return list;
		}
		 throw new UserException("Data not available for specific id");
		
	}
	
}
