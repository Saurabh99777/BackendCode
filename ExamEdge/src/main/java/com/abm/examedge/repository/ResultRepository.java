package com.abm.examedge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abm.examedge.dto.StudentResultDto;
import com.abm.examedge.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Integer>{
	
	
//	@Query("SELECT r FROM ResultEntity r WHERE r.subject.id = :subjectId AND r.subject.level = :subjectLevel")
//    List<ResultEntity> findResultsBySubjectIdAndLevel(@Param("subjectId") int subjectId, @Param("Level") String Level);

	@Query(value = "SELECT r FROM Result r WHERE r.subject.id = ?1")
	public List<Result> resultfetch(@Param("id")int id);
	
	
//	@Query("")
//	public  List<Result> ftechresultbyidandlevel(int StudentId,int subid,String level,String mark);
//		
	
	@Query("SELECT s.name, sum(r.mark) AS total_marks FROM Result r JOIN r.student s GROUP BY r.student.id ORDER BY total_marks DESC")
	public List<Object[]> fetchResulyByMark();
}