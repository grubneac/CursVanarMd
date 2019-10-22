package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import data.Student;

public class StudentRepository {
	private Connection connection;
	private String database_url ="jdbc:sqlite:university.db";
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
	
	public StudentRepository()  {
			try {
				connection = DriverManager.getConnection(database_url);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	protected void finalize() throws SQLException {
		connection.close();
	}
	
	public boolean install(){
		try {
			Statement st = connection.createStatement();
			st.executeUpdate("DROP TABLE IF EXISTS students");
			st.executeUpdate("CREATE TABLE students(\r\n" + 
					"    id INTEGER PRIMARY KEY AUTOINCREMENT, \r\n" + 
					"     fullname VARCHAR(30),\r\n" + 
					"     dob DATE,\r\n" + 
					"     mark DECIMAL(6,2)\r\n" + 
					" );");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addStudent(Student student) {
		try {
			Statement st = connection.createStatement();
			String execSQL = "INSERT INTO students VALUES(null, '"+student.getFullName()
														+"','"+simpleDateFormat.format(student.getDob())
														+"', "+student.getMark()+");";
			System.out.println(execSQL);
			st.executeUpdate("execSQL");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Student> all() {
		ArrayList<Student> students = new ArrayList<>();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM students;");
			while(rs.next()) {
/*				System.out.println(String.format("%-30s",rs.getString("fulName"))+" |"+ 
									rs.getString("dob")+" | "+ 
									rs.getString("mark") );

*/				
				try {
					students.add(new Student(rs.getString("fulName"), 
											simpleDateFormat.parse(rs.getString("dob")) , 
											Float.valueOf(rs.getString("mark"))));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			return students;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
}
