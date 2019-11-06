package main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {

	public static void main(String[] args) {
		check();
	}
	
	public static void check(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sqlite-database");
		var em =entityManagerFactory.createEntityManager();
		em.close();
	}

}
