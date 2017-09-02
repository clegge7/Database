package database;

/**
 * A functional interface used by the {@link AttributeType} enum for comparing
 * two literals of the same type.
 */
@FunctionalInterface
public interface LiteralComparator {
	/**
	 * Compares the raw value of two literals.
	 * @param val1 The raw value of the first literal to be compared
	 * @param val2 The raw value of the second literal to be compared
	 * @return 0 if the values are equal, 1 if val1 > val2, -1 if val1 < val2.
	 */
	public int compare(Object val1, Object val2);
}
