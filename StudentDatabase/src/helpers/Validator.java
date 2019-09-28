package helpers;

public class Validator {
	// - возраст ( валидация: min 18 .. max 65 )
	public static boolean checkAge( int age,int min,int max ) {
		return age>=min&&age<=max;
	}
	
	public static boolean checkExperience( int experience,int min,int max ) {
		return experience>=min && experience<=max;

	}
	// - имя/фамилия ( валидация: min 5.. max 20 символов, обязательное присутствие 1 пробела не ближе чем 2 знака от каждого края)
	public static boolean checkPersonName( String personName,int min,int max ) {
		return (personName.length()>=min 
				&& personName.length()<=max
				&& personName.indexOf(' ')>1 // в начале первых два знака не должны быть пробелами
				&& personName.lastIndexOf(' ')<personName.length()-2 //последние два знака не должны быть пробелами
				);
	}

	public static boolean checkMin(Integer experience, int minExperience) {
		return experience>=minExperience;
	}
//средняя годовая оценка ( валидация: 1.0 .. 10.0 )
	public static boolean checkMark( float mark,float min,float max ) {
		return mark>=min && mark<=max;

	}
	
}
