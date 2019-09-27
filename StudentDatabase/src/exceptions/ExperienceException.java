package exceptions;

public class ExperienceException extends Exception {

	public ExperienceException(String message) {
		super(message);
		System.err.println(message);	}

}
