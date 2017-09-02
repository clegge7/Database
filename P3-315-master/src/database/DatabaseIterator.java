package database;

import java.util.Iterator;

/**
 * Extension of the Iterator interface used by data structures in this Database.
 */
public class DatabaseIterator<T> implements Iterator<T>{

	private final DatabaseIterable<T> collection;
	private int index = 0;
	
	/**
	 * Constructs a new DatabaseIterator from an Iterable collection in this Database.
	 * @param collection The DatabaseIterable to traverse.
	 */
	public DatabaseIterator(DatabaseIterable<T> collection){
		
		this.collection = collection;
	}

	@Override
	public boolean hasNext(){

		return index < collection.size();
	}

	@Override
	public T next(){

		return collection.get(index++);
	}
	
	@Override
	public void remove(){
		
		if(index == 0)
			throw new RuntimeException("Tried to remove object that has not been traversed");
		
		collection.delete(index-1);
	}
	
	/**
	 * Convenience function for performing a function on each element in this iterator.
	 * This differs from {@link #forEachRemaining(java.util.function.Consumer)} in that
	 * this function is fail fast if a DatabaseException is thrown, and doesn't force the
	 * Consumers to handle the exceptions.
	 * @param consumer
	 * @throws DatabaseException
	 */
	public void forRemaining(DatabaseConsumer<T> consumer) throws DatabaseException{
		while (hasNext())
            consumer.accept(next());
	}
}
