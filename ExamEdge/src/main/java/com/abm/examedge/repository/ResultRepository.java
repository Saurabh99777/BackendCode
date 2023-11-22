package com.abm.examedge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abm.examedge.dto.StudentResultDto;
import com.abm.examedge.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Integer>{
	
	//fetching result by st_id and mark
	@Query("SELECT r FROM Result r WHERE r.student.id = ?1 AND r.mark = ?2")
   List<Result> findResultsBystIdandMark(int id,int mark);

	
	
	@Query(value = "SELECT r FROM Result r WHERE r.subject.id = ?1")
	
	public List<Result> resultfetch(@Param("id")int id);
	
	
	/*@Query("")
	public  List<Result> ftechresultbyidandlevel(int StudentId,int subid,String level,String mark);*/
		
	
}