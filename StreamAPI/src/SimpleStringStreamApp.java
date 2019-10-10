import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class SimpleStringStreamApp {

	public static void main(String[] args) {
		ArrayList<String> names= new ArrayList<>();
		names.add("Irina");
		names.add("Ivan");
		names.add("Andrey");
		names.add("Iliana");
		names.add("Ion");

		Predicate<String> sel =name->name.substring(0,1).equals("I");
		Function<String, String> fun = name->name.toUpperCase();
		
//		STREAM
		names
		.stream()		//создал поток
		.skip(1)		// пропускаем первый элемент
		.limit(4)		// дальше пускаем 3 элемента
//		.filter(name->name.substring(0,1).equals("I"))
//		.filter(name->name.contains("I"))
		.filter(sel)
		.map(fun)// преобразует каждый элемент
//		f(String name){
//			return name.toUpperCase()
//		}
//		.allMatch(s->)  
		.forEach(System.out::println); //вывод потока consumer
//		STREAM
	}

}

//@FunctionalInterface
//interface Initials{
//	public boolean HasI(String name);
//}

//изучить анонимный класс а так же динамичный класс