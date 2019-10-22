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
		ArrayList<Student> students = new StudentProvider().provideManyStudents(10);
			
		//		Insert obj Student to to table Students
		for (Student student : students) {
			studentRepository.addStudent(student);
		}
		//		get date
		students = studentRepository.all();
		for (Student student : students) {
			System.out.println(String.format("%-30s",student.getFullName())+" |"+ 
					student.getAge()+" | "+ 
					student.getMark() );
		}
		
		//close connection
		try {
			studentRepository.finalize();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
