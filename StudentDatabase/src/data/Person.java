package data;

import exceptions.*;
import helpers.Validator;

public class Person {
	String fullname;// - имя/фамилия ( валидация: min 5.. max 20 символов, обязательное присутствие 1 пробела не ближе чем 2 знака от каждого края)
	Float age;// - возраст ( валидация: min 18 .. max 65 )
	final private int maxAge=65;
	final private int minAge=18;
	final private int maxFullNameLen=20;
	final private int minFullNameLen=5;
	public Float getAge() {
		return age;
	}

	public void setAge(Float age) throws OutOfRangeException {
		if (Validator.checkRange(age.intValue(), minAge, maxAge))
			this.age = age;
		else throw new OutOfRangeException("возраст "+age+"(не проходит валидацию: min "+minAge+" .. max "+maxAge+" )");
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) throws FullNameFormatException {
		if (Validator.checkPersonName(fullname, minFullNameLen, maxFullNameLen))
			this.fullname = fullname;
		else throw new FullNameFormatException("имя/фамилия не прошло валидацию: min "+minFullNameLen+".. max "+maxFullNameLen+" символов, обязательное присутствие 1 пробела не ближе чем 2 знака от каждого края)");
	}

	public Person(String fullname, Float age) throws OutOfRangeException, FullNameFormatException {
		super();
		if (Validator.checkPersonName(fullname, minFullNameLen, maxFullNameLen))
			this.fullname = fullname;
		else throw new FullNameFormatException("имя/фамилия не прошло валидацию: min "+minFullNameLen+".. max "+maxFullNameLen+" символов, обязательное присутствие 1 пробела не ближе чем 2 знака от каждого края)");
		if (Validator.checkRange(age.intValue(), minAge, maxAge))
			this.age = age;
		else throw new OutOfRangeException("возраст "+age+"(не проходит валидацию: min "+minAge+" .. max "+maxAge+" )");
	}

	@Override
	public String toString() {
		return "Person [fullname=" + fullname + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((fullname == null) ? 0 : fullname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (fullname == null) {
			if (other.fullname != null)
				return false;
		} else if (!fullname.equals(other.fullname))
			return false;
		return true;
	}
	
}
