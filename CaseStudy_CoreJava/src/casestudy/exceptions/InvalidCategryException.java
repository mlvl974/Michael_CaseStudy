package casestudy.exceptions;

public class InvalidCategryException extends Exception {

	public InvalidCategryException ()
	{
		super ("Invalid Category.");
	}
	
	public InvalidCategryException (String message)
	{
		super(message);
	}
	
}
