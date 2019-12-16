package entities;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Performance {

   public static enum Behaviour {
      EXCELLENT,
      GOODS,
      AVERAGE,
      BAD,
      WORST
   }

   private float averageMark;
   private int hoursOfTheory;
   private int hoursOfPractice;
   @Enumerated()
   private Behaviour behaviour;
	public Performance() {
		super();
	}
	public Performance(float averageMark, int hoursOfTheory, int hoursOfPractice, Behaviour behaviour) {
		super();
		this.averageMark = averageMark;
		this.hoursOfTheory = hoursOfTheory;
		this.hoursOfPractice = hoursOfPractice;
		this.behaviour = behaviour;
	}
	public float getAverageMark() {
		return averageMark;
	}
	public void setAverageMark(float averageMark) {
		this.averageMark = averageMark;
	}
	public int getHoursOfTheory() {
		return hoursOfTheory;
	}
	public void setHoursOfTheory(int hoursOfTheory) {
		this.hoursOfTheory = hoursOfTheory;
	}
	public int getHoursOfPractice() {
		return hoursOfPractice;
	}
	public void setHoursOfPractice(int hoursOfPractice) {
		this.hoursOfPractice = hoursOfPractice;
	}
	public Behaviour getBehaviour() {
		return behaviour;
	}
	public void setBehaviour(Behaviour behaviour) {
		this.behaviour = behaviour;
	}
	@Override
	public String toString() {
		return "Performance [averageMark=" + averageMark + ", hoursOfTheory=" + hoursOfTheory + ", hoursOfPractice="
				+ hoursOfPractice + ", behaviour=" + behaviour + "]";
	}
   
}