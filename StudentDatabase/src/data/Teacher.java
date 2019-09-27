package data;

import java.util.ArrayList;

import exceptions.AgeOutOfRangeException;
import exceptions.ExperienceException;
import exceptions.FullNameFormatException;
import helpers.Validator;

public class Teacher extends Person {
	Integer experience;// - опыт в годах ( валидация: min 1 .. max 40 )
	ArrayList<Domains> domains;// - список направлений в которых он обучает ( валидация: min 1 .. )
	final int maxExperience=40;
	final int minExperience=1;

	public Teacher(String fullname, Float age, Integer experience, ArrayList<Domains> domains) throws AgeOutOfRangeException, FullNameFormatException, ExperienceException {
		super(fullname, age);
		if (Validator.checkAge(experience, minExperience, maxExperience))
			this.experience = experience;
		else throw new ExperienceException("опыт в "+experience+" (не прошел валидацию: min "+minExperience+" .. max "+maxExperience+" )");
		this.domains = domains;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) throws ExperienceException {
		if (Validator.checkAge(experience, minExperience, maxExperience))
			this.experience = experience;
		else throw new ExperienceException("опыт в "+experience+" (не прошел валидацию: min "+minExperience+" .. max "+maxExperience+" )");
	}
	public ArrayList<Domains> getDomains() {
		return domains;
	}
	public void setDomains(ArrayList<Domains> domains) {
		this.domains = domains;
	}
	@Override
	public String toString() {
		return "Teacher [experience=" + experience + ", domains=" + domains + "]";
	}
	
}
