package unsafe;

public class VolatileApp {

	public static void main(String[] args) {
		String name ="John";
		Integer age =30;
		Boolean empl = true;
		
		System.out.println("Before");
		System.out.println(name.hashCode());
		System.out.println(age.hashCode());
		System.out.println(empl.hashCode());
		
		name +=" D.";
		age++;
		empl=false;
		System.out.println("----After");
		System.out.println(name.hashCode());
		System.out.println(age.hashCode());
		System.out.println(empl.hashCode());
		
	}

}
