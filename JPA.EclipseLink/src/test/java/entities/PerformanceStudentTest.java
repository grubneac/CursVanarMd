package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;

public class PerformanceStudentTest {
    @Rule
    public TestRule benchmarkRule = new BenchmarkRule();
    private static final int TOTAL_ENTITY=10_000;
    
    //TESTS
    @BenchmarkOptions(benchmarkRounds = 1, warmupRounds = 0)
    @Test
    public void testSngTblSngTran() {//INSERT Single Table Student / Single Transaction
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hb-database");
    	StudentProvider studentProvider = new StudentProvider();
    	EntityManager em = entityManagerFactory.createEntityManager();
    	try {
    			em.getTransaction().begin();
    			for (int i = 0; i < TOTAL_ENTITY; i++) {
    				em.persist(studentProvider.provideOneStudent());
    			}
    			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
    	
    }
    @BenchmarkOptions(benchmarkRounds = 1, warmupRounds = 0)
    @Test
    public void testSngTblMltTran() {//INSERT Single Table Student / Single Transaction
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hb-database");
    	StudentProvider studentProvider = new StudentProvider();
    	EntityManager em =  entityManagerFactory.createEntityManager();
       	try {
       		for (int i = 0; i < TOTAL_ENTITY; i++) {
       			em.getTransaction().begin();
       				em.persist(studentProvider.provideOneStudent());
       			em.getTransaction().commit();
       		}
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		} 
	    	
    }
    @BenchmarkOptions(benchmarkRounds = 1, warmupRounds = 0)
    @Test
    public void testJoinTblSngTran() {//INSERT Single Table Student / Single Transaction
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hb-database");
    	StudentProvider studentProvider = new StudentProvider();
    	EntityManager em = entityManagerFactory.createEntityManager();
    	try {
    			em.getTransaction().begin();
    			for (int i = 0; i < TOTAL_ENTITY; i++) {
    				em.persist(studentProvider.provideOneStudent2());
    			}
    			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
    	
    }
    @BenchmarkOptions(benchmarkRounds = 1, warmupRounds = 0)
    @Test
    public void testJoinTblMltTran() {//INSERT Single Table Student / Single Transaction
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hb-database");
    	StudentProvider studentProvider = new StudentProvider();
    	EntityManager em =  entityManagerFactory.createEntityManager();
       	try {
       		for (int i = 0; i < TOTAL_ENTITY; i++) {
       			em.getTransaction().begin();
       				em.persist(studentProvider.provideOneStudent2());
       			em.getTransaction().commit();
       		}
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw e;
			 
		} finally {
			em.close();
		} 
	    	
    }
}
