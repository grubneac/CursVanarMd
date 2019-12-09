package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Student;

public class Application {

	public static void main(String[] args) {
		check();
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
