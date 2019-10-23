package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import data.Student;

public class Application {
	public static void main(String[] args) throws ClassNotFoundException {
		
		//		Connect to SQLite
		StudentRepository studentRepository = new StudentRepository();
		
		//		Create table Students
		studentRepository.install();
		
		//		create object Student
		System.out.println("-------add 10 students");
		ArrayList<Student> students = new StudentProvider().provideManyStudents(10);
			
		//		Insert obj Student to to table Students
		for (Student student : students) {
			studentRepository.addStudent(student);
		}
		students = studentRepository.all();
		for (Student student : students) System.out.println(student);

		
		System.out.println("-------DELETE first student");
		Student studentForDelete = new Student(1,null,null,null);
		studentRepository.deleteStudent(studentForDelete);
		students = studentRepository.all();
		for (Student student : students) System.out.println(student);
			
		System.out.println("-------UPDATE all students. Put mark=10 for age more 50 ");
		for (Student student : students) {
			if (student.getAge()>50) {
				student.setMark(10f);
				studentRepository.updateStudent(student);
			}
		}
		students = studentRepository.all();
		for (Student student : students) System.out.println(student);
			
		//close connection
		try {
			studentRepository.finalize();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
