package main;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		System.out.println("APP RUNNING!");
		List<Method> methods = Arrays.asList( main.Application.class.getMethods());
		for (Method method : methods) {
			System.out.println(method.getName()+"\t\t"+ method.getReturnType());
			Parameter[] parameters = method.getParameters();
			for (int i=0;i<parameters.length;i++) {
				System.out.println("--------------parameter="+parameters[i].getParameterizedType().getTypeName());
			}
		}
	}
	public void requiredMethod() {
		
	}
	
	public boolean anotherMethod(String name, Integer age) {
		boolean result = false;
		return result;
	}

}
