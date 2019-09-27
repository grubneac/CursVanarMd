package data;

import java.util.ArrayList;

public class Group {
	String name;// - имя группы ( валидация: min 5 .. max 30 )
	Integer year;// - год / курс ( валидация: min 1 .. max 7 )
	ArrayList<Student> students;// - ссылка на список студентов группы

	public Group(String name, Integer year, ArrayList<Student> students) {
		super();
		this.name = name;
		this.year = year;
		this.students = students;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Group [name=" + name + ", year=" + year + ", students=" + students + "]";
	}
	
	public boolean addStudent(Student student) {
		//TODO	нельзя добавлять null	
		//TODO не допускать дублирования. Меняем на HashSet/ Переопределить equal and hashcode  в Student(имя и возраст)
		//TODO при добавлении студента в группу, у студента прописываем группу
		students.add(student);
		return true;
	}
	public boolean removeStudent(Student student) {
		//TODO при удаление студента из группы, у студента удаляем группу		
		return students.remove(student);
	}
	
	
}
