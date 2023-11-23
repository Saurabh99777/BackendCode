package com.abm.examedge.dto;

public class ReportDto {
	private Long attempts;
	private String level;
	private Long subjectId;
	private String subjectName;
	
	
	public Long getAttempts() {
		return attempts;
	}
	public void setAttempts(Long attempts) {
		this.attempts = attempts;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	

}
