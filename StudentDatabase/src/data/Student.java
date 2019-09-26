package data;

import exceptions.AgeOutOfRangeException;
import exceptions.FullNameFormatException;

public class Student extends Person{
	Group group;// - группа в которой студент учится ( валидация: не может быть null )
	Float mark;// - средняя годовая оценка ( валидация: 1.0 .. 10.0 )

	public Student(String fullname, Float age, Group group, Float mark) throws AgeOutOfRangeException, FullNameFormatException {
		super(fullname, age);
		this.group = group;
		this.mark = mark;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Float getMark() {
		return mark;
	}
	public void setMark(Float mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "Student [group=" + group + ", mark=" + mark + "]";
	}
	
}
