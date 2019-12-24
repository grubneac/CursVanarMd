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
		Performance performance = new Performance();
		performance.setAverageMark(Float.valueOf(faker.number().numberBetween(0, 10)));
		performance.setHoursOfPractice(faker.number().numberBetween(0, 1000));
		performance.setHoursOfTheory(faker.number().numberBetween(0, 1000));
		int behavilorInt = faker.number().numberBetween(0, 4);
		Performance.Behaviour behavilor;
		switch (behavilorInt) {
		case 0: behavilor= Performance.Behaviour.EXCELLENT;	break;
		case 1: behavilor= Performance.Behaviour.GOODS;	break;
		case 2: behavilor= Performance.Behaviour.AVERAGE;	break;
		case 3: behavilor= Performance.Behaviour.BAD;	break;

		default:behavilor= Performance.Behaviour.WORST;
			break;
		}
		performance.setBehaviour(behavilor);
		student.setPerformance(performance);

		return student;
	}

	public Student2 provideOneStudent2() {
		Student2 student = new Student2();
		Faker  faker = new Faker(new Locale("ru"));
		student.setFullName(faker.name().name());
		student.setDob(faker.date().birthday());
		student.setMark(Float.valueOf(faker.number().numberBetween(0, 10)));
		Performance performance = new Performance();
		performance.setAverageMark(Float.valueOf(faker.number().numberBetween(0, 10)));
		performance.setHoursOfPractice(faker.number().numberBetween(0, 1000));
		performance.setHoursOfTheory(faker.number().numberBetween(0, 1000));
		int behavilorInt = faker.number().numberBetween(0, 4);
		Performance.Behaviour behavilor;
		switch (behavilorInt) {
		case 0: behavilor= Performance.Behaviour.EXCELLENT;	break;
		case 1: behavilor= Performance.Behaviour.GOODS;	break;
		case 2: behavilor= Performance.Behaviour.AVERAGE;	break;
		case 3: behavilor= Performance.Behaviour.BAD;	break;

		default:behavilor= Performance.Behaviour.WORST;
			break;
		}
		performance.setBehaviour(behavilor);
		student.setPerformance(performance);
		return student;
	}

	public ArrayList<Student> provideManyStudents(int quantity){
		ArrayList<Student> students = new ArrayList<>();
		for(int i=0;i< quantity; i++)students.add(provideOneStudent());
		return students;
	}
}
