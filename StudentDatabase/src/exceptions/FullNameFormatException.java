package exceptions;

public class FullNameFormatException extends Exception {

	public FullNameFormatException(String arg0) {
		super(arg0);
		System.err.println(arg0);
	}
}
