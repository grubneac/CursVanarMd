package main;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ApplicationTest {

	@Test
	public void testMain() {
        List<Method> methods = Arrays.asList( main.Application.class.getMethods() );
        Boolean method_exists =  methods
                                 .stream()
                                 .anyMatch(method -> { 
                                     return method.getName().equals("requiredMethod"); 
                                 }  );
        assertTrue("Class \"Application\" is not complete!", method_exists);	}

}
