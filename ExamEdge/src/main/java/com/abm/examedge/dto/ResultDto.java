package com.abm.examedge.dto;

import com.abm.examedge.entity.Student;
import com.abm.examedge.entity.Subject;

public class ResultDto {
	private String name;
	private int mark;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	
	
}
