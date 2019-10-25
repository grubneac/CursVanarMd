package main;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import data.Student;

public class TestStudent {

	  @Test
	  public void testEqualProperties() {
		  Student student1 = new Student("Vasea", new Date(2011, 02, 12), 5.5f);
		  Student student2 = new Student("Vasea", new Date(2011, 02, 12), 5.5f);
		  
		  assertTrue("Class Student is bad: two ident student is not equal", student1.equals(student2));
	  }
	  @Test
	  public void testIdenticObjects() {
		  Student student1 = new Student("Vasea", new Date(2011, 02, 12), 5.5f);
		  assertTrue("Class Student is bad: one student is not equal isself", student1.equals(student1));
	  }
	  @Test
	  public void testClonedObjects() {
		  Student student1 = new Student("Vasea", new Date(2011, 02, 12), 5.5f);
		  try {
			Student student2 = student1.clone();
			 assertTrue("Class Student is bad: student is not equal student clone", student1.equals(student2));
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		  
	  }        
	  @Test
	  public void testDiffentProperties() {
		  Student student1 = new Student("Vasea", new Date(2011, 02, 12), 5.5f);
		  Student student2 = new Student("Vasea2", new Date(2011, 03, 12), 5.6f);
		  
		  assertFalse("Class Student is bad: two not ident student is equal", student1.equals(student2));
		  
	  }
	  
	      

}

