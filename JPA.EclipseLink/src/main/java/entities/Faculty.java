package entities;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name ="faculty")
public class Faculty {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Length(min=2, max=10)
	private String name;
	
	@OneToMany(mappedBy="faculty")
	private List<Groups> groups;

	public Faculty() {
		super();
	}

	public Faculty(Long id, @NotNull @Length(min = 2, max = 10) String name, List<Groups> groups) {
		super();
		this.id = id;
		this.name = name;
		this.groups = groups;
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

	public List<Groups> getGroups() {
		return groups;
	}

	public void setGroups(List<Groups> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", groups=" + groups + "]";
	}
	
	

}
