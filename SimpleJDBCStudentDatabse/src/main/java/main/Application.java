package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import data.Group;
import data.Student;

public class Application {
	private static StudentRepository studentRepository;
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		//SWing - GUI
		//JAVAFX
/*		JFrame window = new JFrame("Student JDBC Example");
			window.setBounds(100, 100, 200, 150);
			window.getContentPane().setLayout(new GridLayout(5,1));
		
		JTextField txt_fullname = new JTextField("");
		
		JTextField txt_dob = new JTextField("");
		JTextField txt_mark = new JTextField("");
		JButton btn_save = new JButton("SAVE");
		JButton btn_install = new JButton("INSTALL");
		
			window.getContentPane().add(txt_fullname);
			window.getContentPane().add(txt_dob);
			window.getContentPane().add(txt_mark);
			window.getContentPane().add(btn_install);
			window.getContentPane().add(btn_save);
			
			btn_save.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("btn_save clik");
					try {
						Student student = new Student(txt_fullname.getText(),
								studentRepository.simpleDateFormat.parse(txt_dob.getText()),
								Float.valueOf(txt_mark.getText()));
						studentRepository.addStudent(student);
						System.out.println(student);
					} catch (NumberFormatException | ParseException e1) {
						e1.printStackTrace();
					}
				}
			});	
			
			btn_install.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("btn_install clik");
					studentRepository.install();
				}
			});	
			
		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				super.windowOpened(e);
				studentRepository = new StudentRepository();
			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("closed windows");
				try {
					studentRepository.finalize();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
				super.windowClosing(e);
			}
		});	
			
			
		window.show();
*/		
		//		Connect to SQLite
/*		StudentRepository studentRepository = new StudentRepository();
		
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
		*/
		GroupRepository groupRepository = new GroupRepository();
		
		//		Create table Groups
		groupRepository.install();
		
		//		create object Group
		System.out.println("-------add 10 groups");
		ArrayList<Group> groups = new GroupProvider().provideManyGroups(10);
			
		//		Insert obj Group to to table Groups
		for (Group group : groups) {
			groupRepository.addGroup(group);
		}
		groups = groupRepository.all();
		for (Group group : groups) System.out.println(group);

		
		System.out.println("-------DELETE first group");
		Group groupForDelete = new Group(1,null,null);
		groupRepository.deleteGroup(groupForDelete);
		groups = groupRepository.all();
		for (Group group : groups) System.out.println(group);
			
		System.out.println("-------UPDATE all groups. Put code+'_' ");
		for (Group group : groups) {
			
				group.setCode(group.getCode()+"_");
				groupRepository.updateGroup(group);
		}
		groups = groupRepository.all();
		for (Group group : groups) System.out.println(group);
			
		//close connection
		try {
			groupRepository.finalize();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
