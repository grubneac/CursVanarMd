package data;

import java.util.ArrayList;

import exceptions.OutOfRangeException;
import helpers.Validator;

public class Group {
	String name;// - имя группы ( валидация: min 5 .. max 30 )
	Integer year;// - год / курс ( валидация: min 1 .. max 7 )
	ArrayList<Student> students;// - ссылка на список студентов группы
	private final int minNameLength = 5;
	private final int maxNameLength = 30;
	private final int minYear = 1;
	private final int maxYear = 7;
	
	public Group(String name, Integer year, ArrayList<Student> students) throws OutOfRangeException {
		super();
		if(Validator.checkRange(name.length(), minNameLength, maxNameLength))
			this.name = name;
		else throw new OutOfRangeException(" длинна имени группы:"+name.length()+" ( валидация: min "+minNameLength+" .. max "+maxNameLength+" )");
		if(Validator.checkRange(year,minYear, maxYear))
			this.year = year;
		else throw new OutOfRangeException("год / курс:"+year+" ( валидация: min "+minYear+" .. max "+maxYear+" )");
		this.students = students;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) throws OutOfRangeException {
		if(Validator.checkRange(name.length(), minNameLength, maxNameLength))
			this.name = name;
		else throw new OutOfRangeException(" длинна имени группы:"+name.length()+" ( валидация: min "+minNameLength+" .. max "+maxNameLength+" )");
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) throws OutOfRangeException {
		if(Validator.checkRange(year,minYear, maxYear))
			this.year = year;
		else throw new OutOfRangeException("год / курс:"+year+" ( валидация: min "+minYear+" .. max "+maxYear+" )");
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
