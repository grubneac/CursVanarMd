package entities;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name ="groups")
public class Groups {
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
	
	@OneToMany(mappedBy="groups")
	private List<Student> students;

	public Groups() {
		super();
	}

	public Groups(Long id, @NotNull @Length(min = 2, max = 10) String name, Faculty faculty, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.faculty = faculty;
		this.students = students;
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
		return "Groups [id=" + id + ", name=" + name + ", faculty=" + faculty + ", students=" + students + "]";
	}
	
	
}
