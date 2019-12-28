package entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

@Entity
//@Table(name="awards")
public class Award {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long Id;
	
	private String title;
	private Date date;
	@Enumerated(EnumType.STRING)
	private Type type;
	
    @Any(
            metaDef = "AwardObjectMetaDef",
            metaColumn = @Column( name = "award_Object_type" )
        )
	@AnyMetaDef( name= "AwardObjectMetaDef", metaType = "string", idType = "long",
    metaValues = {
            @MetaValue(value = "student", targetEntity = Student.class),
            @MetaValue(value = "groups", targetEntity = Groups.class),
            @MetaValue(value = "faculty", targetEntity = Faculty.class)
        }
    )   
    @JoinColumn( name = "award_Object_id" )
    private AwardObject awardObject;	

	public Award() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public AwardObject getAwardObject() {
		return awardObject;
	}

	public void setAwardObject(AwardObject awardObject) {
		this.awardObject = awardObject;
	}

	@Override
	public String toString() {
		return "Award [title=" + title + ", date=" + date + ", type=" + type + "]";
	}
	
}
