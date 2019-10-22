package data;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Student {
	
	private String fullName;
	private Date dob;
	private Float mark;
	

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


	

}
