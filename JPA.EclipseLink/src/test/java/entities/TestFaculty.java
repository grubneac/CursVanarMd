package entities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestFaculty {
	static Long facultyId;
	
	@Test
	public void Test1CreateFaculty() {  //CreateFaculty
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hb-database");
		var em =entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		Faculty faculty = new Faculty("Test Faculty");
		em.persist(faculty);
		 
		facultyId = faculty.getId();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!facultyId="+facultyId);
		
		em.getTransaction().commit();
		em.close();		

	}
	@Test
	public void Test2UpdateFaculty() {  //UpdateFaculty
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hb-database");
		var em =entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		Faculty faculty = em.find(Faculty.class, facultyId);
		faculty.setName("Updated faculty");
		em.persist(faculty);
		 
		em.getTransaction().commit();
		em.close();		

	}
	@Test
	public void Test3DeleteFaculty() { //DeleteFaculty
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hb-database");
		var em =entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		Faculty faculty = em.find(Faculty.class, facultyId);
		em.remove(faculty);
		 
		em.getTransaction().commit();
		em.close();		

	}

}
