package database;

import java.util.HashMap;

/**
 * A single user of a database. A Session keeps track of the current views of the user and allows
 * the user to read from and edit the database.
 */
public class Session {
	
	private final HashMap<String, Relation> views = new HashMap<>();
	private final Database database;
	
	/**
	 * Creates a new session object used to manipulate a database.
	 * @param database The database to be manipulated.
	 */
	protected Session(Database database){
		
		this.database = database;
	}
	
	/**
	 * Writes the specified view to the database, and removes it
	 * from the currently stored views upon success.
	 * @param name The name of the view to write.
	 * @throws DatabaseException If the specified view cannot be written.
	 */
	public void write(String name) throws DatabaseException{
		
		Relation relation = getRelation(name);
		if(relation == null)
			throw new DatabaseException("View '" + name + "' does not exist");
		
		database.write(name, relation);
		views.remove(name);
	}
	
	/**
	 * See {@link Database#create(String, Relation)}.
	 * @param name The name of the new Relation.
	 * @param relation The Relation to be created.
	 * @throws DatabaseException
	 */
	public void create(String name, Relation relation) throws DatabaseException{
		
		database.create(name, relation);
	}
	
	/**
	 * See {@link Database#close(String)}.
	 * @param name The name of the Relation to be closed.
	 * @throws DatabaseException 
	 */
	public void close(String name) throws DatabaseException{
		
		database.close(name);
	}
	
	/**
	 * See {@link Database#open(String)}.
	 * @param name The name of the Relation to be opened.
	 * @throws DatabaseException 
	 */
	public Relation open(String name) throws DatabaseException{
		
		return database.open(name);
	}
	
	/**
	 * See {@link Database#delete(String)}.
	 * @param name The name of the Relation to be deleted.
	 * @throws DatabaseException 
	 */
	public void delete(String name) throws DatabaseException{
		
		database.delete(name);
	}
	
	/**
	 * Creates or overwrites a view with the specified name.
	 * @param name The name to save the view as.
	 * @param view The view to be saved.
	 */
	public void setView(String name, Relation view){
		
		if(view == null)
			throw new NullPointerException();
		
		views.put(name, view);
	}
	
	/**
	 * Gets the value of a stored view.
	 * @param name The name of the view to load.
	 * @return The view with the specified name.
	 * @throws DatabaseException If the view does not exist.
	 */
	public Relation getView(String name) throws DatabaseException{
		
		Relation relation = views.get(name);
		if(relation == null)
			throw new DatabaseException("Tried to read non-existant view");
		
		return relation;
	}
	
	/**
	 * Gets the relation with the specified name. If a view exists with that name, it is returned.
	 * If not the open relations in the database are searched.
	 * @param name The name of the Relation to search for.
	 * @return The Relation with the specified name.
	 * @throws DatabaseException If the Relation cannot be found.
	 */
	public Relation getRelation(String name) throws DatabaseException{
		
		Relation relation = views.get(name);
		if(relation == null)
			return database.getRelation(name);
		
		return relation;
	}
	
	/**
	 * Exits from the current session. Since the Database only ever has one session,
	 * this also closes all open Relations and exits from the Database.
	 */
	public void exit(){
		
		database.closeAll();
	}
}
