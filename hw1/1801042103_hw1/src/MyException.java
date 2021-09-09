/**
 * @author 1801042103
 * This class to create my own exception 
 * This class extend Exception class
 */
//package CompanySystem;

public class MyException extends Exception {
	
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor of MyException class
	 * @param message String error message
	 */
	public MyException(String message) {
		super(message);
	}

}
