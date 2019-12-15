package entities;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGroups {
	static Long groupsId;
	
	@Test
	public void Test1CreateGroupss() {  //CreateGroups
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hb-database");
		var em =entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		Groups groups = new Groups("Test Group", null);
		em.persist(groups);
		 
		groupsId = groups.getId();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!groupsId="+groupsId);
		
		em.getTransaction().commit();
		em.close();		

	}
	@Test
	public void Test2UpdateGroupss() {  //UpdateGroups
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hb-database");
		var em =entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		Groups groups = em.find(Groups.class, groupsId);
		groups.setName("Updated group");
		em.persist(groups);
		 
		em.getTransaction().commit();
		em.close();		

	}
	@Test
	public void Test3DeleteGroups() { //DeleteGroups
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hb-database");
		var em =entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		Groups groups = em.find(Groups.class, groupsId);
		em.remove(groups);
		 
		em.getTransaction().commit();
		em.close();		

	}

}
