package main;

import static org.junit.Assert.*;

import java.util.List;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

import org.junit.Test;

public class ApplicationTest {

	@Test
	public void testMain() {
        List<Method> methods = Arrays.asList( main.Application.class.getMethods());
        Boolean method_exists =  methods
                                 .stream()
                                 .anyMatch(method -> { 
                                     return method.getName().equals("requiredMethod"); 
                                 }  );
        assertTrue("Class \"Application\" method requiredMethod is not complete!", method_exists);	
        }
	@Test
	public void testAnotherMethod() {
		List<Method> methods = Arrays.asList( main.Application.class.getMethods());
		Boolean method_exists =  methods
                .stream()
                .anyMatch(method -> {
                    return method.getName().equals("anotherMethod")
                		&& method.getReturnType().toString().equals("boolean") 
                    	&& method.getParameters()[0].getParameterizedType().getTypeName().equals("java.lang.String");
                });
		
		assertTrue("Class \"Application\" is method anotherMethod not complete!", method_exists);
		
	}
	

}
