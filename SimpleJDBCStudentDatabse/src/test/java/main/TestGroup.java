package main;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import data.Group;

public class TestGroup {

	  @Test
	  public void testEqualProperties() {
		  Group group1 = new Group("SomeGroup", "056");
		  Group group2 = new Group("SomeGroup", "056");
		  
		  assertTrue("Class Group is bad: two ident group is not equal", group1.equals(group2));
	  }
	  @Test
	  public void testIdenticObjects() {
		  Group group1 = new Group("SomeGroup", "056");
		  assertTrue("Class Group is bad: one group is not equal isself", group1.equals(group1));
	  }
	  @Test
	  public void testClonedObjects() {
		  Group group1 = new Group("SomeGroup", "056");
		  try {
			Group group2= group1.clone();
			 assertTrue("Class Group is bad: group is not equal group clone", group1.equals(group2));
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }        
	  @Test
	  public void testDiffentProperties() {
		  Group group1 = new Group("SomeGroup", "056");
		  Group group2 = new Group("SomeGroup", "057");
		  assertFalse("Class Group is bad: two not ident group is equal", group1.equals(group2));
	  }        

}
