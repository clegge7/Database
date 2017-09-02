package database;

/**
 * Extension of the Iterable interface used by the data structures in this Database.
 * @param <T> The type of elements to be iterated by the resulting Iterator.
 */
public interface DatabaseIterable<T> extends Iterable<T>{
	
	/**
	 * Gets the number of elements in this collection.
	 * @return The size of this collection.
	 */
	public int size();
	
	/**
	 * Gets the element in this collection at the specified index.
	 * @param i The index to retrieve the element.
	 * @return The element at index i.
	 */
	public T get(int i);
	
	/**
	 * Removes the element in this collection at the specified index.
	 * @param i The index at which to delete the element.
	 */
	public void delete(int i);
	
	@Override
	public DatabaseIterator<T> iterator();

	/**
	 * Does the specified action on each Tuple in this Relation.
	 * @param consumer The action to be performed.
	 * @throws DatabaseException If there is an error performing the action on any Tuple.
	 */
	public void forAll(DatabaseConsumer<T> consumer) throws DatabaseException;
}
