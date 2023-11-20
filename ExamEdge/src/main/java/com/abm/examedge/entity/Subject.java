package com.abm.examedge.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "subject_table") 
public class Subject {
	@Id
	@Column(name = "subject_id") 
	@GeneratedValue
	private int id;

	@Column(name = "subject_name") 
	private String name;

	//    @JsonIgnore
	//    @OneToMany(mappedBy = "subject")
	//    private List<Question> question;
	//    
	//	public List<Question> getQuestions() {
	//		return question;
	//	}	
	//
	//	public void setQuestions(List<Question> question) {
	//		this.question = question;
	//	}


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
}
