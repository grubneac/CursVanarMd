package main;

import java.util.ArrayList;
import java.util.HashSet;

import data.Group;
import data.Student;
import exceptions.OutOfRangeException;
import exceptions.FullNameFormatException;
import exceptions.MarkException;
import exceptions.NullException;

public class Aplication {

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		
		try {
			
			Student st1 = new Student("Вася Пекус", 25f, null, 5.5f);
			Student st2 = new Student("Вася Пекус", 25f, null, 5.5f);
			HashSet<Student> hashStudents = new HashSet<>();
			
			if (hashStudents.add(st1))System.out.println("Студент:"+st1+" добавлен в группу");
			else System.out.println("Студент:"+st1+" НЕ добавлен в группу");
			if (hashStudents.add(st2))System.out.println("Студент:"+st2+" добавлен в группу");
			else System.out.println("Студент:"+st2+" НЕ добавлен в группу");
			
//			Group gr = new 
			
			if(st1.equals(st2))System.out.println("Оба объекта равны");
			else System.out.println("Оба объекта НЕ равны");
			
			students.add(st1);
			students.add(st2);
			
			
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
