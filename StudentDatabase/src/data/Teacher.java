package data;

import java.util.ArrayList;

import exceptions.AgeOutOfRangeException;
import exceptions.FullNameFormatException;

public class Teacher extends Person {
	Integer experience;// - опыт в годах ( валидация: min 1 .. max 40 )
	ArrayList<Domains> domains;// - список направлений в которых он обучает ( валидация: min 1 .. )

	public Teacher(String fullname, Float age, Integer experience, ArrayList<Domains> domains) throws AgeOutOfRangeException, FullNameFormatException {
		super(fullname, age);
		this.experience = experience;
		this.domains = domains;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
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
