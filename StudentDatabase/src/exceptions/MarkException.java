package exceptions;

public class MarkException extends Exception {
	public MarkException(String arg0) {
		super(arg0);
		System.err.println(arg0);
	}
}
