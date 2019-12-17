package entities;

import java.sql.Date;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name ="student")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
	
	@Embedded
	private Performance performance;
	
	public Student() {
		super();
	}





	public Student(@NotNull @Length(min = 5, max = 30) String fullName, Date dob, @NotNull @Min(0) @Max(10) Float mark,
			Performance performance) {
		super();
		this.fullName = fullName;
		this.dob = dob;
		this.mark = mark;
		this.performance = performance;
	}





	public Student( @NotNull @Length(min = 5, max = 30) String fullName, Date dob,
			@NotNull @Min(0) @Max(10) Float mark) {
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





	public Groups getGroups() {
		return groups;
	}





	public void setGroups(Groups groups) {
		this.groups = groups;
	}





	public Performance getPerformance() {
		return performance;
	}





	public void setPerformance(Performance performance) {
		this.performance = performance;
	}





	@Override
	public String toString() {
		return "Student [Id=" + Id + ", fullName=" + fullName + ", dob=" + dob + ", mark=" + mark + ", groups=" + groups
				+ ", performance=" + performance + "]";
	}



	

}
