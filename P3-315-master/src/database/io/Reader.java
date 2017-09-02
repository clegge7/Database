package database.io;

import java.io.IOException;

/**
 * Functional interface used for reading a particular element from
 * a list of elements in the {@link DatabaseInputStream#readList(Reader)}
 * method
 * @param <T> The type of Object to be read.
 */
@FunctionalInterface
public interface Reader<T>{
	/**
	 * Reads an object of type T from the specified input stream.
	 * @param in The {@link DatabaseInputStream} to be read from.
	 * @return An object of type T read from the stream.
	 * @throws IOException If there is an error reading from the
	 * specified stream.
	 */
	public T read(DatabaseInputStream in) throws IOException;
}
