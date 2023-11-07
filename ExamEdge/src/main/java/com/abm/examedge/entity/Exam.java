package com.abm.examedge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Exam_Details")
public class Exam {

	@Id
	@Column(name="ex_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;

	@Column(name="ex_date")
	private int date;

	@Column(name="ex_level")	
	private int level;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	


}