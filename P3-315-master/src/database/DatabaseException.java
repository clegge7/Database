package database;

/**
 * An exception thrown by various methods of the Database
 * and its respective data structures.
 */
public class DatabaseException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	
	public DatabaseException(String message){
		
		super(message);
	}
	
	
	public DatabaseException(String message, Throwable cause){
		
		super(message, cause);
	}
}
