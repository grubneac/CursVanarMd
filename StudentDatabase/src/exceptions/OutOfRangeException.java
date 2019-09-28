package exceptions;

public class OutOfRangeException extends Exception {

	public OutOfRangeException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		System.err.println(arg0);
	}


}
