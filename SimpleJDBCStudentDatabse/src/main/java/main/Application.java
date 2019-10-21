package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.Student;

public class Application {
	public static void main(String[] args) throws ClassNotFoundException {
//		Connect to SQLite
		Connection con = null;
		try {
			 con = DriverManager.getConnection("jdbc:sqlite:university.db");
//		Create table Students
			Statement st = con.createStatement();
//			st.executeUpdate("CREATE TABLE IF NOT EXISTS students(fulName VARCHAR(30))");
//		create object Student
			Student student =new Student("Vasea Pecus3");	
//		Insert obj Student to to table Students
			st.executeUpdate("INSERT INTO students VALUES('"+student.getFullName()+"')");
//		get date
			ResultSet rs = st.executeQuery("SELECT * FROM students;");
			while(rs.next()) {
				System.out.println(rs.getString("fulName"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e2) {
			}
		}
	}
}
