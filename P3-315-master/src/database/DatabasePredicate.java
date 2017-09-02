package database;

/**
 * Functional interface for testing a Predicate on each Tuple in a Relation.
 */
@FunctionalInterface
public interface DatabasePredicate {
	/**
	 * Tests a specified tuple to see if it matches some predicate.
	 * @param t The tuple to test.
	 * @return A FuzzyBoolean specifying if the tuple matched the predicate or not.
	 * @throws DatabaseException If the test fails due to an error.
	 */
	public FuzzyBoolean test(Tuple t) throws DatabaseException;
}
