package database.io;

import java.io.IOException;

/**
 * Functional interface used by {@link database.AttributeType} to read the
 * value of a literal from a {@link DatabaseInputStream}.
 */
@FunctionalInterface
public interface LiteralReader {
	/**
	 * Reads the value of a literal from the specified stream.
	 * @param in The {@link #DatabaseInputStream} to be read.
	 * @return The value of the literal.
	 * @throws IOException If there is an error reading from the
	 * specified stream.
	 */
	public Object read(DatabaseInputStream in) throws IOException;
}
