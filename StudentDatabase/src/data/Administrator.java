package data;

import exceptions.AgeOutOfRangeException;
import exceptions.FullNameFormatException;

public class Administrator extends Person {
	Integer experience;// - опыт в годах ( валидация: min 5 .. max 40 )

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Administrator(String fullname, Float age, Integer experience) throws AgeOutOfRangeException, FullNameFormatException {
		super(fullname, age);
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Administrator [experience=" + experience + "]";
	}
	
}
