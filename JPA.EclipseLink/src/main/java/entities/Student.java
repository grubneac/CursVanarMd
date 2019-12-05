package entities;

import java.sql.Date;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Student")
public class Student {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String fullName;
	private Date dob;
	private Float mark;
	
	public Student() {
		super();
	}
	


	public Student(Long id, String fullName, Date dob, Float mark) {
		super();
		Id = id;
		this.fullName = fullName;
		this.dob = dob;
		this.mark = mark;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Float getMark() {
		return mark;
	}

	public void setMark(Float mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", fullName=" + fullName + ", dob=" + dob + ", mark=" + mark + "]";
	}

}
