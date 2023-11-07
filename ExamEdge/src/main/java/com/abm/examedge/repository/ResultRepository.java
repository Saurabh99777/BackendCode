package com.abm.examedge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abm.examedge.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Integer>{
	
	
//	@Query("SELECT r FROM ResultEntity r WHERE r.subject.id = :subjectId AND r.subject.level = :subjectLevel")
//    List<ResultEntity> findResultsBySubjectIdAndLevel(@Param("subjectId") int subjectId, @Param("Level") String Level);

}
