package com.abm.examedge.dto;

import com.abm.examedge.entity.Student;
import com.abm.examedge.entity.Subject;

public class QuestionAnswerDto {
	private int score;
	private int answer;
	private String level;
	private Student studet;
	private Subject subject;
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Student getStudet() {
		return studet;
	}
	public void setStudet(Student studet) {
		this.studet = studet;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}





}
