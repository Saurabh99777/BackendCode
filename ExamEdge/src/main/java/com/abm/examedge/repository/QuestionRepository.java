package com.abm.examedge.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.abm.examedge.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
		


	@Query(value = "SELECT q FROM Question q WHERE q.subject.id= ?1 AND q.level = ?2")
	 public List<Question> questionfecth(int id, String level);
	

	//fetch question by subId
	@Query(value = "SELECT q FROM Question q WHERE q.subject.id= ?1 and q.status is NULL ")
	 public List<Question> questionfecthsubId(int id);
	
	//@Query("SELECT q FROM Question q WHERE q.subject.id = :id AND q.level = :level")
	
	
//	@Query("SELECT q FROM Question q WHERE q.subject.id = ?1 and q.level='?2'")
//	public List<Question> questionFetch(@Param("subjectId") int subjectId);

	@Query("SELECT s FROM Question s WHERE s.id = ?1 ")
	public List<Question> fetchQuestionByQuid(int id);
	
	@Query("select q from Question q")
    List<Question> fetchanswer();
	
	

}
