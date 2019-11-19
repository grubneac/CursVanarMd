package entities;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String fullName;
	
	public Student() {
		super();
	}
	
	public Student(Long id, String fullName) {
		super();
		Id = id;
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", fullName=" + fullName + "]";
	}
	

}
