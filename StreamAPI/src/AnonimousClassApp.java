import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.Comparator;

public class AnonimousClassApp {

	public static void main(String[] args) {

		// Consumer lambda
		Consumer<Student> showPretty = s -> System.out.println( "------------------------------\n" + s + "\n------------------------------\n" );
		
		// Predicate lambda
		Predicate<Student> moreEight = s-> s.getMark()>=8.0f;
		
		//Comparator lambda
		Comparator<Student> comparator =(s1,s2)->s1.getMark().compareTo(s2.getMark());
		
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("First student", 5f));
		students.add(new Student("Second student", 8.5f));
		students.add(new Student("Third student", 9f));
		students.add(new Student("Fourth student", 3f));
		students.add(new Student("Fifth student", 10f));
		students.add(new Student("Sixth student", 9.3f));
		students.add(new Student("Seventh student", 9f));
		
		students
			.stream()
			.filter(moreEight)
//			.sorted(new Comparator<Student>(){
//				public int compare(Student st1, Student st2) {
//					if (st1.getMark()<st2.getMark()) return  1;
//					else return -1;
//				};
//			})
//			.forEach( showPretty );
			.sorted(comparator.reversed())
		.forEach( System.out::println );

	}

}


class Student {
	
	private String name;
	private Float mark;
	
	public Student(String name, Float mark) {
		super();
		this.name = name;
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getMark() {
		return mark;
	}

	public void setMark(Float mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", mark=" + mark + "]";
	}
	
	
}
