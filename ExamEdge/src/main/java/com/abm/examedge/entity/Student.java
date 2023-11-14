package com.abm.examedge.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "student_details") 
public class Student {
	
	@Id
	@Column(name = "student_id") 
	@GeneratedValue
	private int id;

	@Column(name = "student_name") 
	private String name;

	@Column(name = "email_id") 
	private String emailId;

	@Column(name = "password") 
	private String password;

	@Column(name = "phone_no") 
	private Long phoneNo;
	
	@Lob
    @Column(name = "imagedata", length = 1000)
    private String imageUrl;
	
	
	

	

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	// Getters and setters
	
	
	
}
