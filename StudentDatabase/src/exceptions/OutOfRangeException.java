package exceptions;

public class OutOfRangeException extends Exception {

	public OutOfRangeException(String arg0) {
		super(arg0);
		System.err.println(arg0);
	}


}
