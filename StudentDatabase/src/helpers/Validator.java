package helpers;

public class Validator {
	// - возраст ( валидация: min 18 .. max 65 )
	public static boolean checkAge( int age,int min,int max ) {
		boolean result = false;
		if(age>=min&&age<=max)result=true;
		return result;
	}
	
	public static boolean checkExperience( int experience,int min,int max ) {
		boolean result = false;
		if(experience>=min && experience<=max)result=true;
		return result;

	}
	// - имя/фамилия ( валидация: min 5.. max 20 символов, обязательное присутствие 1 пробела не ближе чем 2 знака от каждого края)
	public static boolean checkPersonName( String personName,int min,int max ) {
		boolean result = false;
		if (personName.length()>=min 
				&& personName.length()<=max
				&& personName.indexOf(' ')>1 // в начале первых два знака не должны быть пробелами
				&& personName.lastIndexOf(' ')<personName.length()-2 //последние два знака не должны быть пробелами
				
				)result = true;
		return result;
	}
}
