package data;

import exceptions.OutOfRangeException;
import exceptions.FullNameFormatException;
import exceptions.MarkException;
import exceptions.NullException;
import helpers.Validator;

public class Student extends Person{
	Group group;// - группа в которой студент учится ( валидация: не может быть null )
	Float mark;// - средняя годовая оценка ( валидация: 1.0 .. 10.0 )
	static float minMark=1.0f;
	static float maxMark=10.0f;
	public Student(String fullname, Float age, Group group, Float mark) throws OutOfRangeException, FullNameFormatException, MarkException, NullException {
		super(fullname, age);
		if(Validator.isNotNull(group))
			this.group = group;
		else throw new NullException("группа в которой студент учится ( валидация: не может быть null )");
		if (Validator.checkMark(mark, minMark, maxMark))
			this.mark = mark;
		else throw new MarkException("средняя годовая оценка ="+mark+" ( валидация: "+minMark+" .. "+maxMark+" )");
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) throws NullException {
		if(Validator.isNotNull(group))
			this.group = group;
		else throw new NullException("группа в которой студент учится ( валидация: не может быть null )");
	}
	public Float getMark() {
		return mark;
	}
	public void setMark(Float mark) throws MarkException {
		if (Validator.checkMark(mark, minMark, maxMark))
			this.mark = mark;
		else throw new MarkException("средняя годовая оценка ="+mark+" ( валидация: "+minMark+" .. "+maxMark+" )");
	}
	@Override
	public String toString() {
		return "Student [group=" + group + ", mark=" + mark + "]";
	}
	
}
