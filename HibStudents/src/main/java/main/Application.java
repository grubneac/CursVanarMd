package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			String url="jdbc:postgresql://localhost:5432/university_app";
			 connection = DriverManager.getConnection(url, "postgres", "qwerty");
			 Statement st = connection.createStatement();
			 st.execute("drop table if exists Students;");
			 st.executeUpdate("create table if not exists Students(\r\n" + 
			 		"	ID Serial primary key,\r\n" + 
			 		"	fullname varchar(30),\r\n" + 
			 		"	dob date,\r\n" + 
			 		"	mark numeric\r\n" + 
			 		"); ");	
			 System.out.println("Installed table Students");
			 st.executeUpdate("insert into students(fullname,dob,mark) values('Александр Сергеевич Пушкин','2015-01-01', 5.5 );");
			 st.executeUpdate("insert into students(fullname,dob,mark) values('Антоний 1','2004-12-29', 8.45 );");
			 System.out.println("inserted rows");
			 st.executeUpdate("update students set dob = '1799-06-06' where id =1;");
			 System.out.println("update row with id =1");
			 
			 ResultSet resultSet= st.executeQuery("select * from Students;");
			 
			 while(resultSet.next()) {
				 System.out.println(resultSet.getInt("id")+" | "+
						 			resultSet.getString("fullname")+" | "+
						 			resultSet.getDate("dob")+" | "+
						 			resultSet.getFloat("mark")
						 			);
			 }
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
