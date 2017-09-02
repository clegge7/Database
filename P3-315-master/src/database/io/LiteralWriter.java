package database.io;

import java.io.IOException;

/**
 * Functional interface used by {@link database.AttributeType} to write the
 * value of a literal to a {@link DatabaseOutputStream}
 */
@FunctionalInterface
public interface LiteralWriter {
	/**
	 * Writes the specified value of a literal to the specified stream.
	 * @param out The {@link #DatabaseOutputStream} to be written to.
	 * @param value The value of the literal to be written.
	 * @throws IOException If there is an error writing to the 
	 * specified stream.
	 */
	public void write(DatabaseOutputStream out, Object value) throws IOException;
}
