package data;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Student implements Cloneable {
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (obj == null || id == null) {
			if(this.getFullName().equals(other.getFullName())
					&& this.getDob().equals(other.getDob())
					&& this.getMark().equals(other.getMark())
					)return true;
			else return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public Student clone() throws CloneNotSupportedException {
		return (Student)super.clone();
	}
	
}
