package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.sessions.Session;

import entities.Student;

public class Application {

	public static void main(String[] args) {
//		ArrayList<Student> students = new ArrayList<Student>();
		install();// create table
		
		Student student = new Student(11L, "John Doe");
		Student returnStudent = findOneStudent(student.getId());
		if (returnStudent ==null) createStudent(student);
		else updateStudent(student);
		
		System.out.println(returnStudent);
		
		student = new Student(12L, "Vasea Pecus");
		returnStudent = findOneStudent(student.getId());
		if (returnStudent == null) createStudent(student);
		else updateStudent(student);
		System.out.println(returnStudent);
	}
	
	public static void check(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sqlite-database");
		var em =entityManagerFactory.createEntityManager();
		em.close();
	}
	 public static void install() {
	       EntityManagerFactory factory = Persistence.createEntityManagerFactory("sqlite-database");
	       EntityManager em = factory.createEntityManager();
	       
	       em.getTransaction().begin();

	       em
	         .createNativeQuery("Create table if not exists Student(id INTEGER PRIMARY KEY, fullName VARCHAR(30));")
	         .executeUpdate();

	       em.getTransaction().commit();
	       
	   }
	 public static Student findOneStudent(Long id) {
	       EntityManagerFactory factory = Persistence.createEntityManagerFactory("sqlite-database");
	       EntityManager em = factory.createEntityManager();
	       
	       em.getTransaction().begin();
	       
	       Student s = em.find(Student.class,id);

	       em.getTransaction().commit();
	       return s;
	   }
	 public static void createStudent(Student student) {
	       EntityManagerFactory factory = Persistence.createEntityManagerFactory("sqlite-database");
	       EntityManager em = factory.createEntityManager();
	       
	       em.getTransaction().begin();
	       	em.persist(student);
	       em.getTransaction().commit();
	      
	   }
	 public static void updateStudent(Student student) {
	       EntityManagerFactory factory = Persistence.createEntityManagerFactory("sqlite-database");
	       EntityManager em = factory.createEntityManager();
	       
	       em.getTransaction().begin();
	       	em.merge(student);
	       em.getTransaction().commit();
	      
	   }	 
	 
}
