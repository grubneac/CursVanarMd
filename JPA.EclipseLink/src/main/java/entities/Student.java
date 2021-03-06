package entities;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name ="student_single")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@EntityListeners({AgeUpdateListener.class, UpdateTimeListener.class})
public class Student implements AwardObject {
	static final Logger log = LoggerFactory.getLogger(Student.class.getName());
	 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long Id;
	
	@Column(name = "full_name")
	@NotNull
	@Length(min=5, max=30)
	private String fullName;
	
	private Date dob;
	@Transient
	private int age;
	
	public void setAge(int age) {
		this.age = age;
	}

	@NotNull
	@Min(0)
	@Max(10)
	private Float mark;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="groups_id")
	Groups groups;
	
	@Embedded
	private Performance performance;
	
	public Student() {
		super();
	}
	
	// timestamps
	private Date created;
	private Date updated;
//	private Date deleted;

	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
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
				+ ", performance=" + performance + ", age:"+age+ "]";
	}

//life cycle events
	@PrePersist
	public void setCreateddTime(){
		this.setCreated(new Date());
	}

	

}
 class AgeUpdateListener{
	@PostLoad
	public void updateAge(Student student) {
		Student.log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!Customer PostLoad method called");
		student.setAge((int)ChronoUnit.YEARS.between( LocalDateTime.ofInstant(
				Instant.ofEpochMilli( student.getDob().getTime()), ZoneOffset.UTC),
				LocalDateTime.now()
				));
	}
//	@PostLoad
//	public void updateAge() {
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Student before without args :");
//	
//	}
}
 class UpdateTimeListener{
		@PreUpdate
		public void setUpdetedTime(Student student){
			student.setUpdated(new Date());
		}
 }

