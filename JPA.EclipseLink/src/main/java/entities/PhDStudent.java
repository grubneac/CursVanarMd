package entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity(name ="PhDStudent")
@PrimaryKeyJoinColumn(name="MasterStudent")
public class PhDStudent extends MasterStudent {
		private String institution;

		public PhDStudent() {
			super();
		}

		public PhDStudent(@NotNull @Length(min = 5, max = 30) String fullName, Date dob,
				@NotNull @Min(0) @Max(10) Float mark, Performance performance, DegreeLevel level, String institution) {
			super(fullName, dob, mark, performance, level);
			this.institution = institution;
		}

		public String getInstitution() {
			return institution;
		}

		public void setInstitution(String institution) {
			this.institution = institution;
		}

		@Override
		public String toString() {
			return "PhDStudent [institution=" + institution + "]";
		}


		
		
		
		
}
