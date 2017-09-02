package database.io;

import java.io.IOException;

/**
 * Any object implementing the Writable interface is able to be written
 * to a {@link DatabaseOutputStream} by calling its
 * {@link #write(DatabaseOutputStream)} method, and thus can be used in
 * the as an element in the
 * {@link DatabaseOutputStream#writeList(java.util.ArrayList)} method.
 */
public interface Writable{
	
	/**
	 * Writes this object to a file using the specified OutputStream.
	 * @param out The {@link DatabaseOutputStream} to be written to.
	 * @throws IOException If an error is encountered while writing this object.
	 */
	public void write(DatabaseOutputStream out) throws IOException;
}