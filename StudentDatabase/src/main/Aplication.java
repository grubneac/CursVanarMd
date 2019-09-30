package main;

import java.util.ArrayList;

import data.Student;
import exceptions.OutOfRangeException;
import exceptions.FullNameFormatException;
import exceptions.MarkException;
import exceptions.NullException;

public class Aplication {

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		
		try {
			students.add(new Student("dsjdsfsdf dfsdfga", 25f, null, 5.5f));
		} catch (OutOfRangeException e) {
			e.printStackTrace();e.getMessage();
		} catch (FullNameFormatException e) {
			e.printStackTrace();
		} catch (MarkException e) {
			e.printStackTrace();
		} catch (NullException e) {
			e.printStackTrace();
		}
		
//		students.add(new Student("Вася Пекус", 21, 9.5f));
//		students.add(new Student("Nana Pecus", 12, 5.5f));
//		students.add(new Student("Tanea Pecus", 29, 11.5f));
//
//		for (Student student : students) {
//			System.out.println(student.getFulName());
//		}
		
		students.forEach(s->System.out.println(s.getAge()));
		students.forEach(System.out::println);
		students.forEach(Aplication::printStudent);
	}
	
	public static void printStudent(Student s) {
		System.out.println(s.getMark());
	}
	

}
