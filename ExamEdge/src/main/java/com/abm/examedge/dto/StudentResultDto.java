package com.abm.examedge.dto;

public class StudentResultDto {

	private int StudentId;
	private int SubjectId;
	private String marks;
	private String level;
	
	public StudentResultDto(int studentId, int subjectId, String marks, String level) {
		super();
		StudentId = studentId;
		SubjectId = subjectId;
		this.marks = marks;
		this.level = level;
	}
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public int getSubjectId() {
		return SubjectId;
	}
	public void setSubjectId(int subjectId) {
		SubjectId = subjectId;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	
}
