package entities;


import java.sql.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestStudent {
	static Long studenId;
	
	@Test
	public void Test1CreateStudent() {  //CreateStudent
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hb-database");
		var em =entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		Student student = new Student("Test Student", new Date(80,10,1),9.5f);
		em.persist(student);
		 
		studenId = student.getId();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!studenId="+studenId);
		
		em.getTransaction().commit();
		em.close();		

	}
	@Test
	public void Test2UpdateStudent() {  //UpdateStudent
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hb-database");
		var em =entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		Student student = em.find(Student.class, studenId);
		student.setMark(10f);
		student.setFullName("Updated Student");
		em.persist(student);
		 
		em.getTransaction().commit();
		em.close();		

	}
	@Test
	public void Test3DeleteStudent() { //DeleteStudent
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hb-database");
		var em =entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		Student student = em.find(Student.class, studenId);
		em.remove(student);
		 
		em.getTransaction().commit();
		em.close();		

	}

}
