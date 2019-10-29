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

public class StudentRepository extends Repository{
	
	public StudentRepository() {
		super();
	}
	
	public boolean install(){
		try {
			Statement st = connection.createStatement();
			st.executeUpdate("DROP TABLE IF EXISTS students");
			st.executeUpdate("CREATE TABLE students(\r\n" + 
					"    id INTEGER PRIMARY KEY AUTOINCREMENT, \r\n" + 
					"     fullname VARCHAR(30),\r\n" + 
					"     dob DATE,\r\n" + 
					"     mark DECIMAL(6,2),\r\n" + 
					"	  group_id INT"+
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
//			System.out.println(execSQL);
			st.executeUpdate(execSQL);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateStudent(Student student) {
		try {
			Statement st = connection.createStatement();
			String execSQL = "UPDATE students SET fullname ='"+student.getFullName()
														+"',dob='"+simpleDateFormat.format(student.getDob())
														+"', mark="+student.getMark()
														+"  WHERE id="+student.getId()+";";
//			System.out.println(execSQL);
			st.executeUpdate(execSQL);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteStudent(Student student) {
		try {
			Statement st = connection.createStatement();
			String execSQL = "DELETE from students WHERE id="+student.getId()+";";
//			System.out.println(execSQL);
			st.executeUpdate(execSQL);
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
					students.add(new Student(rs.getInt("id"),
											rs.getString("fullname"), 
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
