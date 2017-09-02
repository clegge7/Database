package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import database.io.DatabaseInputStream;
import database.io.DatabaseOutputStream;

/**
 * A collection of {@link Relation} objects saved as files in a common directory.
 * Contains methods for opening, closing, reading, and writing to specific
 * Relations in this Database.
 */
public class Database{

	private final HashMap<String, Relation> openRelations = new HashMap<>();
	private final String root;
	
	/**
	 * Constructs a database from the specified rootDirectory. The root directory
	 * contains all of the {@link Relation} objects for this database.
	 * @param rootDirectory The root directory of this Database. If this is not a
	 * valid directory one will be created.
	 * @throws DatabaseException If the specified directory doesn't exist and
	 * cannot be created.
	 */
	public Database(String rootDirectory) throws DatabaseException{
		
		root = rootDirectory;
		File file = new File(rootDirectory);
		if(file.exists() && file.isFile())
			throw new DatabaseException("Error creating database, root directory cannot be a file");
		else if(!file.exists())
			if(!file.mkdir())
				throw new DatabaseException("Error creating database, failed to make directory");				
	}
	
	/**
	 * Creates a new session for managing this database.
	 * @return A new session that can be used to read from and edit this database.
	 */
	public Session createSession(){
		
		Session session = new Session(this);
		return session;
	}
	
	/**
	 * Opens the specified {@link Relation}.
	 * @param name The name of the {@link Relation} to be opened.
	 * @return The newly opened {@link Relation}.
	 * @throws DatabaseException If the {@link Relation} does not exist, cannot be opened, or has already been opened.
	 */
	protected Relation open(String name) throws DatabaseException{
		
		for(String relationName: openRelations.keySet())
			if(relationName.equalsIgnoreCase(name))
				throw new DatabaseException("Relation is already opened");
		
		File file = new File(root, name + ".db");
		if(!file.exists() || file.isDirectory())
			throw new DatabaseException("Error opening database relation '" + name + "', relation does not exist.");
		
		try(DatabaseInputStream in = new DatabaseInputStream(new FileInputStream(file))){
			
			Relation relation = new Relation(in);
			openRelations.put(name, relation);
			return relation;
		}catch(Throwable t){
			t.printStackTrace();
			throw new DatabaseException("Error opening database relation '" + name + "'", t);
		}
	}
	
	/**
	 * Closes the specified {@link Relation}.
	 * @param name The name of the {@link Relation} to be closed.
	 * @throws DatabaseException If there is an error saving the {@link Relation} or
	 * it has not been opened.
	 */
	protected void close(String name) throws DatabaseException{
		
		Relation relation = openRelations.get(name);
		if(relation == null)
			throw new DatabaseException("Error closing database relation '" + name + "', relation is not open");
		
		write(name, relation);
		openRelations.remove(name);
	}
	
	/**
	 * Deletes the specified {@link Relation}.
	 * @param name The name of the {@link Relation} to be deleted.
	 * @throws DatabaseException If the {@link Relation} does not exist or is currently opened.
	 */
	protected void delete(String name) throws DatabaseException{

		if(openRelations.containsKey(name))
			throw new DatabaseException("Opened Relation '" + name + "' cannot be deleted");
		
		File file = new File(root, name + ".db");
		if(!file.exists() || file.isDirectory())
			throw new DatabaseException("Relation '" + name + "' does not exist");
		
		if(!file.delete())
			throw new DatabaseException("Error deleting Relation '" + name + "'");
	}
	
	/**
	 * Saves the specified Relation as the specified name.
	 * @param name The name to save the Relation as.
	 * @param relation The Relation to save.
	 * @throws DatabaseException If the Relation cannot be saved.
	 */
	protected void write(String name, Relation relation) throws DatabaseException{
		
		File file = new File(root, name + ".db");
		if(file.isDirectory())
			throw new DatabaseException("Error writing database relation '" + name + "', directory already exists with this name.");
		
		if(file.exists() && openRelations.get(name) != relation)
			throw new DatabaseException("Error writing database relation '" + name + "', another database with this name already exists.");
		
		try(DatabaseOutputStream out = new DatabaseOutputStream(new FileOutputStream(file))){
			
			relation.write(out);
		}catch(Throwable t){
			
			throw new DatabaseException("Error writing database relation '" + name + "'", t);
		}
	}
	
	/**
	 * Closes and saves all open databases, used during EXIT command to ensure
	 * no data is lost on a clean exit.
	 */
	protected void closeAll(){
		
		for(String name: openRelations.keySet()){
			
			try{				
				write(name, openRelations.get(name));
			}catch(DatabaseException e){				
				System.out.println("Error saving relation '" + name + "': " + e.getMessage());
			}
		}
		
		openRelations.clear();
	}
	
	/**
	 * Retrieves the opened {@link Relation} of the specified name.
	 * @param name The name of the {@link Relation}.
	 * @return The {@link Relation} with the specified name or null if not {@link Relation} exists.
	 */
	protected Relation getRelation(String name) throws DatabaseException{
		
		Relation relation = openRelations.get(name);
		if(relation == null)
			throw new DatabaseException("Relation '" + name + "' does not exist or is not open");
		
		return relation;
	}
	
	/**
	 * Adds a new {@link Relation} to this database with the specified name.
	 * @param name The name of the new {@link Relation}.
	 * @param relation The {@link Relation} to be added.
	 * @throws DatabaseException If the Relation cannot be created.
	 */
	protected void create(String name, Relation relation) throws DatabaseException{

		if(relation == null)
			throw new NullPointerException();
		
		if(openRelations.containsKey(name))
			throw new DatabaseException("Relation '" + name + "' already exists.");
		
		File file = new File(root, name + ".db");
		if(file.isDirectory())
			throw new DatabaseException("Directory already exists with this name.");
		else if(file.exists())
			throw new DatabaseException("File already exists with this name.");
		
		openRelations.put(name, relation);
	}
}
