package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name ="groups")
public class Groups  implements AwardObject {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Length(min=2, max=10)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="faculty_id")
	private Faculty faculty; 
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="groups" )
//	@Fetch(FetchMode.SELECT)
	private List<Student> students = new ArrayList<>();

	public Groups() {
		super();
	}

	public Groups(@NotNull @Length(min = 2, max = 10) String name, Faculty faculty) {
		super();
		this.name = name;
		this.faculty = faculty;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Groups [id=" + id + ", name=" + name + ", faculty=" + faculty +  "]"; //", students=" + students +
	}
	
	public void addStudent(Student student) {
		this.getStudents().add(student);
	}
	
}
