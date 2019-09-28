package data;

import exceptions.OutOfRangeException;
import exceptions.ExperienceException;
import exceptions.FullNameFormatException;
import helpers.Validator;

public class Administrator extends Person {
	Integer experience;// - опыт в годах ( валидация: min 5 .. max 40 )
	final int maxExperience=40;
	final int minExperience=5;

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) throws ExperienceException {
		if (Validator.checkAge(experience, minExperience, maxExperience))
			this.experience = experience;
		else throw new ExperienceException("опыт в "+experience+" (не прошел валидацию: min "+minExperience+" .. max "+maxExperience+" )");
	}

	public Administrator(String fullname, Float age, Integer experience) throws OutOfRangeException, FullNameFormatException, ExperienceException {
		super(fullname, age);
		if (Validator.checkAge(experience, minExperience, maxExperience))
			this.experience = experience;
		else throw new ExperienceException("опыт в "+experience+" (не прошел валидацию: min "+minExperience+" .. max "+maxExperience+" )");
	}

	@Override
	public String toString() {
		return "Administrator [experience=" + experience + "]";
	}
	
}
