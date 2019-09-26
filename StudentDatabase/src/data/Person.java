package data;

import exceptions.*;
import helpers.Validator;

public class Person {
	String fullname;// - имя/фамилия ( валидация: min 5.. max 20 символов, обязательное присутствие 1 пробела не ближе чем 2 знака от каждого края)
	Float age;// - возраст ( валидация: min 18 .. max 65 )
	final int maxAge=18;
	final int minAge=65;
	final int maxFullNameLen=20;
	final int minFullNameLen=5;
	public Float getAge() {
		return age;
	}

	public void setAge(Float age) throws AgeOutOfRangeException {
//		if (Validator.checkAge((int)age, minAge, maxAge)) //не хочет приводится???????
		if (Validator.checkAge(Float.floatToIntBits(age), minAge, maxAge))
			this.age = age;
		else throw new AgeOutOfRangeException("возраст "+age+"(не проходит валидацию: min "+minAge+" .. max "+maxAge+" )");
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) throws FullNameFormatException {
		if (Validator.checkPersonName(fullname, minFullNameLen, maxFullNameLen))
			this.fullname = fullname;
		else throw new FullNameFormatException("имя/фамилия не прошло валидацию: min "+minFullNameLen+".. max "+maxFullNameLen+" символов, обязательное присутствие 1 пробела не ближе чем 2 знака от каждого края)");
	}

	public Person(String fullname, Float age) throws AgeOutOfRangeException, FullNameFormatException {
		super();
		if (Validator.checkPersonName(fullname, minFullNameLen, maxFullNameLen))
			this.fullname = fullname;
		else throw new FullNameFormatException("имя/фамилия не прошло валидацию: min "+minFullNameLen+".. max "+maxFullNameLen+" символов, обязательное присутствие 1 пробела не ближе чем 2 знака от каждого края)");
		if (Validator.checkAge(Float.floatToIntBits(age), minAge, maxAge))
			this.age = age;
		else throw new AgeOutOfRangeException("возраст "+age+"(не проходит валидацию: min "+minAge+" .. max "+maxAge+" )");
	}

	@Override
	public String toString() {
		return "Person [fullname=" + fullname + ", age=" + age + "]";
	}
	
	
}
