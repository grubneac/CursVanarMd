package entities;

import java.sql.Date;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name ="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long Id;
	
	@Column(name = "full_name")
	@NotNull
	@Length(min=5, max=30)
	private String fullName;
	
	private Date dob;
	
	@NotNull
	@Min(0)
	@Max(10)
	private Float mark;
	
	@ManyToOne
	@JoinColumn(name="groups_id")
	Groups groups;
	
	public Student() {
		super();
	}





	public Student(Long id, @NotNull @Length(min = 5, max = 30) String fullName, Date dob,
			@NotNull @Min(0) @Max(10) Float mark, Groups groups) {
		super();
		Id = id;
		this.fullName = fullName;
		this.dob = dob;
		this.mark = mark;
		this.groups = groups;
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
	

	public Groups getGroup() {
		return groups;
	}


	public void setGroup(Groups groups) {
		this.groups = groups;
	}


	@Override
	public String toString() {
		return "Student [Id=" + Id + ", fullName=" + fullName + ", dob=" + dob + ", mark=" + mark + ", group=" + groups
				+ "]";
	}


	

}
