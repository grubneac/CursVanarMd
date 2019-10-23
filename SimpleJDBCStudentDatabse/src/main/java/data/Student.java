package data;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Student {
	
	private String fullName;
	private Date dob;
	private Float mark;
	private Integer id;
	

	public Student() {
		super();
	}

	public Student(String fullName) {
		super();
		this.fullName = fullName;
	}
	

	public Student(String fullName, Date dob, Float mark) {
		super();
		this.fullName = fullName;
		this.dob = dob;
		this.mark = mark;
	}
	

	public Student(Integer id, String fullName, Date dob, Float mark) {
		super();
		this.fullName = fullName;
		this.dob = dob;
		this.mark = mark;
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		LocalDate now = LocalDate.now();
		LocalDate dobL = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Period period  = Period.between(dobL, now);
		return period.getYears();
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("%-3s",this.getId()) +"| "+
				String.format("%-30s",this.getFullName())+" |"+ 
				this.getAge()+" | "+ 
				this.getMark();
	}


	

}
