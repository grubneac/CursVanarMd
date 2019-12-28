package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import java.sql.Date;

import entities.Groups;
import entities.MasterStudent;
import entities.Performance;
import entities.PhDStudent;
import entities.Student;

public class Application {

	public static void main(String[] args) {
//		check();
		testStudent();
//		ArrayList<Student> students = new ArrayList<Student>();
//		uninstall();
//		install();// create table
		
//		Student student = new Student(11L, "John Doe");
//		Student returnStudent = findOneStudent(student.getId());
//		if (returnStudent ==null) addOneStudent(student);
//		else updateStudent(student);
//		
//		System.out.println(returnStudent);
//		
//		student = new Student(12L, "Vasea Pecus");
//		returnStudent = findOneStudent(student.getId());
//		
//		if (returnStudent == null) addOneStudent(student);
//		else updateStudent(student);
//		System.out.println(returnStudent);
	}
	
	public static void check(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hb-database");
		var em =entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void testStudent() {
		
		Performance performance = new Performance(5.6F, 1200, 300, Performance.Behaviour.AVERAGE);
		Student student = new Student("First Student", new Date(1980,11,1),9.5f,performance);//transient
		MasterStudent masterStudent = new MasterStudent("Master Student", new Date(80,9,16),9.9f,performance, MasterStudent.DegreeLevel.NOOB);
		PhDStudent dStudent = new PhDStudent("PhD Student",  new Date(1982,10,12), 3.3F, performance, MasterStudent.DegreeLevel.ADVANCED, "Institution GOOD");
		Groups groups = new Groups();
		groups.setName("Test Groups");
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hb-database");
		var em =entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		//C

		groups.getStudents().add(student);
		groups.getStudents().add(masterStudent);
		groups.getStudents().add(dStudent);
		em.persist(groups);
//		
//		student.setGroups(groups);
//		em.persist(student);//save -> persistent
////		em.persist(masterStudent);//save -> persistent
//		em.persist(dStudent);//save -> persistent
		
		//R
//		Student readStudent=em.find(Student.class, 2L);//Hydration
//		System.out.println("New Student="+readStudent.getFullName());
//		Groups readGroups=em.find(Groups.class, 1L);//Hydration
//		System.out.println("New Groups="+readGroups.getName());
//		System.out.println("Students:"+ readGroups.getStudents().get(0).getFullName());
//		
//		//U + transient/dirty
//		readStudent.setDob(new Date(80,10,1));
//		readStudent.getPerformance().setBehaviour(Performance.Behaviour.EXCELLENT);
//		readStudent.getPerformance().setAverageMark(10F);
//		em.persist(readStudent);
//		Student updateStudent = em.find(Student.class, 1L);
//		System.out.println("UPDATED student="+updateStudent);
//		
//		
//		//D
//		em.remove(readStudent);
//		Student deletedStudent = em.find(Student.class,1L);
//		System.out.println("Deleted student="+deletedStudent);
		
		
		
		em.getTransaction().commit();
		em.close();		
	} 
	
	
	public static void install() {
	       EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database");
	       EntityManager em = factory.createEntityManager();
	       
	       em.getTransaction().begin();

	       em
	         .createNativeQuery("CREATE TABLE public.students (\r\n" + 
	         		"	id serial NOT NULL,\r\n" + 
	         		"	fullname varchar(30) NULL,\r\n" + 
	         		"	dob date NULL,\r\n" + 
	         		"	mark numeric NULL,\r\n" + 
	         		"	CONSTRAINT students_pkey PRIMARY KEY (id)\r\n" + 
	         		");\r\n" + 
	         		";")
	         .executeUpdate();

	       em.getTransaction().commit();
	   }
	 
	 public static void uninstall() {
	       EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database");
	       EntityManager em = factory.createEntityManager();
	       
	       em.getTransaction().begin();

	       em
	         .createNativeQuery("DROP TABLE if exists public.students ;")
	         .executeUpdate();

	       em.getTransaction().commit();
	   }
	 
	 
	 
	 public static Student findOneStudent(Long id) {
	       EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database");
	       EntityManager em = factory.createEntityManager();
	       
	       em.getTransaction().begin();
	       
	       Student s = em.find(Student.class,id);

	       em.getTransaction().commit();
	       return s;
	   }
	 public static void addOneStudent(Student student) {
	       EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database");
	       EntityManager em = factory.createEntityManager();
	       
	       em.getTransaction().begin();
	       	em.persist(student);
	       em.getTransaction().commit();
	      
	   }
	 public static void updateStudent(Student student) {
	       EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database");
	       EntityManager em = factory.createEntityManager();
	       
	       em.getTransaction().begin();
	       	em.merge(student);
	       em.getTransaction().commit();
	      
	   }	 
	 
}
