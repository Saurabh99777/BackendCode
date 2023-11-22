package com.abm.examedge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.abm.examedge.dto.StudentResultDto;

import com.abm.examedge.entity.Result;
import com.abm.examedge.exception.UserException;
import com.abm.examedge.repository.ResultRepository;


@Service
public class ResultService {
	
	@Autowired 
	private ResultRepository resultRepo;
	
	//fetching result by st_id and mark
	public List<Result> results(int id, int mark){
		List<Result> list =resultRepo.findResultsBystIdandMark(id, mark);
	return list;
		} 
	
	public List<Result>showresult(int subid){
		List<Result> list = resultRepo.resultfetch(subid);
		if(list!=null) {
			return list;
		}
		 throw new UserException("Data not available for specific id");
		
	}
	

	/*public List<Result> resultFetchByIdandLevel(int StudentId,int subid,String level,String mark){
		List<Result> list =resultRepo.ftechresultbyidandlevel(StudentId, subid, level, mark);
		return list;
		
	}*/
	

	public Result saveresult(Result result) {
		return resultRepo.save(result);
	}

	
	
}
