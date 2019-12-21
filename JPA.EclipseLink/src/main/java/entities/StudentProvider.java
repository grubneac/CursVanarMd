package entities;

import java.util.ArrayList;
import java.util.Locale;

import com.github.javafaker.Faker;

import entities.Student;

public class StudentProvider {
	public Student provideOneStudent() {
		Student student = new Student();
		Faker  faker = new Faker(new Locale("ru"));
		student.setFullName(faker.name().name());
		student.setDob(faker.date().birthday());
		student.setMark(Float.valueOf(faker.number().numberBetween(0, 10)));
		return student;
	}

	public Student2 provideOneStudent2() {
		Student2 student = new Student2();
		Faker  faker = new Faker(new Locale("ru"));
		student.setFullName(faker.name().name());
		student.setDob(faker.date().birthday());
		student.setMark(Float.valueOf(faker.number().numberBetween(0, 10)));
		return student;
	}

	public ArrayList<Student> provideManyStudents(int quantity){
		ArrayList<Student> students = new ArrayList<>();
		for(int i=0;i< quantity; i++)students.add(provideOneStudent());
		return students;
	}
}
