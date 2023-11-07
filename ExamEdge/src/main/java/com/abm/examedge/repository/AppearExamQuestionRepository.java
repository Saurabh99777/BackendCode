package com.abm.examedge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abm.examedge.entity.ExamQuestion;

public interface AppearExamQuestionRepository extends JpaRepository<ExamQuestion, Integer> {

}
