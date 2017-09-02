package database;

/**
 * A functional interface used by the {@link AttributeType} enum for parsing
 * a literal's value from a String.
 */
@FunctionalInterface
public interface LiteralParser {
	/**
	 * Parses a literal's value from a String.
	 * @param literal The String representation of the literal.
	 * @return The value of the literal.
	 */
	public Object parse(String literal);
}
