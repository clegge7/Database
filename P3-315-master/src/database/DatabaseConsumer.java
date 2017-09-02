package database;

/**
 * Functional Interface used in place of a Consumer<T> for the
 * {@link DatabaseIterator#forRemaining(DatabaseConsumer)} method.
 * @param <T> The type of Object to consume.
 */
@FunctionalInterface
public interface DatabaseConsumer<T>{

	/**
	 * Accepts an Object and performs a function on it.
	 * @param value The Object to accept.
	 * @throws DatabaseException If there is an error performing the function.
	 */
	public void accept(T value) throws DatabaseException;
}
