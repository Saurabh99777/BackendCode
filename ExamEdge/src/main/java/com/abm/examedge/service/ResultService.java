package com.abm.examedge.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public List<Object[]>showresult(int sid){
		List<Object[]> list = resultRepo.resultfetch(sid);
		if(list!=null) {
			return list;
		}
		 throw new UserException("Data not available for specific id");
		
	}
	

//	public List<Result> resultFetchByIdandLevel(int StudentId,int subid,String level,String mark){
//		List<Result> list =resultRepo.ftechresultbyidandlevel(StudentId, subid, level, mark);
//		return list;
//		
//	}
	

	public Result saveresult(Result result) {
		return resultRepo.save(result);
	}

	
	
	
	public Map<String, Long> getPassFailCount() {
        return resultRepo.getPassFailCount();
    }


	public List<Object[]> fetchMarks(){
		List<Object[]> result = resultRepo.fetchResulyByMark();
		
//		for(Object[] lb : result)
//			System.out.println(lb[0] + " " + lb[1]);
		
		return result;
	}

	

	
}
