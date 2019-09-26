package data;

import java.util.ArrayList;

public class University {
	String name;// - название университета ( валидация: min 3 .. max 30 )
	Administrator director;// - ссылка на объект класс директора
	ArrayList<Group> groups;// - ссылка на список групп университета
	ArrayList<Domains> domains;// - ссылка на список направлений обучения университета
	ArrayList<Teacher> teachers;// - ссылка на список учителей университета
	ArrayList<Student> students;// - ссылка на список студентов университета
	
	public University(String name, Administrator director, ArrayList<Group> groups, ArrayList<Domains> domains,
			ArrayList<Teacher> teachers, ArrayList<Student> students) {
		super();
		this.name = name;
		this.director = director;
		this.groups = groups;
		this.domains = domains;
		this.teachers = teachers;
		this.students = students;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Administrator getDirector() {
		return director;
	}
	public void setDirector(Administrator director) {
		this.director = director;
	}
	public ArrayList<Group> getGroups() {
		return groups;
	}
	public void setGroups(ArrayList<Group> groups) {
		this.groups = groups;
	}
	public ArrayList<Domains> getDomains() {
		return domains;
	}
	public void setDomains(ArrayList<Domains> domains) {
		this.domains = domains;
	}
	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(ArrayList<Teacher> teachers) {
		this.teachers = teachers;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "University [name=" + name + ", director=" + director + ", groups=" + groups + ", domains=" + domains
				+ ", teachers=" + teachers + ", students=" + students + "]";
	}
	
}
