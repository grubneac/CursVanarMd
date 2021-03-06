package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name ="faculty")
public class Faculty  implements AwardObject {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Length(min=2, max=10)
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="faculty")
	private List<Groups> groups = new ArrayList<>();

	public Faculty() {
		super();
	}

	public Faculty(@NotNull @Length(min = 2, max = 10) String name) {
		super();
		this.name = name;
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
