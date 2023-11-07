package com.abm.examedge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Apper_Exam_Questions")
public class ExamQuestion {

	@Column(name="sr_no")
	@Id
	@GeneratedValue
	private int srno;
	
	
	@ManyToOne
	@JoinColumn(name = "ex_id") 
	private Exam exam;
	
	@ManyToOne
	@JoinColumn(name = "q_id")
	private Question question;
	
	@Column(name="level")
	private String level;
	
	@Column(name="stu_ans")
	private String studentAnswer;
	
	@Column(name="correct_ans")
	private String correctAnswer;

	public int getSrno() {
		return srno;
	}

	public void setSrno(int srno) {
		this.srno = srno;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getStudentAnswer() {
		return studentAnswer;
	}

	public void setStudentAnswer(String studentAnswer) {
		this.studentAnswer = studentAnswer;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	
	
}
