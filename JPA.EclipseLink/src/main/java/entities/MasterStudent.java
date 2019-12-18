package entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity(name ="MasterStudent")
@PrimaryKeyJoinColumn(name="Student")
public class MasterStudent extends Student {
	  public static enum DegreeLevel {
	      NOOB,		//0
	      ADVANCED	//1
	   }
	  
	private DegreeLevel level;

	public MasterStudent() {
		super();
	}

	public MasterStudent(@NotNull @Length(min = 5, max = 30) String fullName, Date dob, @NotNull @Min(0) @Max(10) Float mark,
			Performance performance,DegreeLevel level) {
		super(fullName,  dob, mark, performance);
		this.level = level;
	}

	public DegreeLevel getLevel() {
		return level;
	}

	public void setLevel(DegreeLevel level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "MasterStudent [level=" + level + "]";
	}
	

}
