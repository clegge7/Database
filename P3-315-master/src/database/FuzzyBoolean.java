package database;

/**
 * Utility class for handling boolean operations based on
 * fuzzy logic principles.
 */
public class FuzzyBoolean {
	
	private final float value;
	
	/**
	 * Creates an immutable FuzzyBoolean object with the specified value.
	 * @param value The value of this FuzzyBoolean object.
	 */
	private FuzzyBoolean(float value){
		
		this.value = value;
	}
	
	/**
	 * Gets the value of this FuzzyBoolean object as a regular boolean.
	 * @return True if this FuzzyBoolean object's value is greater than Undefined (0.5).
	 */
	public boolean getValue(){
		
		return value > .6;
	}
	
	/**
	 * Logical AND implemented using MIN.
	 * @param b The value to and with.
	 * @return A new value representing this && b.
	 */
	public FuzzyBoolean and(FuzzyBoolean b){
		
		if(value < b.value)
			return new FuzzyBoolean(value);
		
		return new FuzzyBoolean(b.value);
	}
	
	/**
	 * Logical OR implemented using MAX.
	 * @param b The value to or with.
	 * @return A new value representing this || b.
	 */
	public FuzzyBoolean or(FuzzyBoolean b){
		
		if(value < b.value)
			return new FuzzyBoolean(b.value);
		
		return new FuzzyBoolean(value);
	}
	
	/**
	 * Logical NOT implemented using 1-value.
	 * @return A new value representing !this.
	 */
	public FuzzyBoolean not(){
		
		return new FuzzyBoolean(1-value);
	}
	
	/**
	 * Creates a FuzzyBoolean representing whether the lhs literal is greater than the
	 * rhs literal.
	 * @param lhs The left hand side of this comparison.
	 * @param rhs The right hand side of this comparison.
	 * @return True if lhs is greater than rhs, false if it is not, undefined if
	 * this operation cannot be done.
	 */
	public static FuzzyBoolean greaterThan(Literal lhs, Literal rhs){
		
		if(lhs.type != rhs.type || lhs.isNull() != rhs.isNull())
			return new FuzzyBoolean(0.5f);

		if(lhs.compareTo(rhs) > 0)
			return new FuzzyBoolean(1);
		
		return new FuzzyBoolean(0);
	}
	
	/**
	 * Creates a FuzzyBoolean representing whether the lhs literal is greater than or equal to the
	 * rhs literal.
	 * @param lhs The left hand side of this comparison.
	 * @param rhs The right hand side of this comparison.
	 * @return True if lhs is greater than or equal to rhs, false if it is not, undefined if
	 * this operation cannot be done.
	 */
	public static FuzzyBoolean greaterThanOrEqualTo(Literal lhs, Literal rhs){
		
		if(lhs.type != rhs.type || lhs.isNull() != rhs.isNull())
			return new FuzzyBoolean(0.5f);

		if(lhs.compareTo(rhs) >= 0)
			return new FuzzyBoolean(1);

		return new FuzzyBoolean(0);
	}
	
	/**
	 * Creates a FuzzyBoolean representing whether the lhs literal is less than the
	 * rhs literal.
	 * @param lhs The left hand side of this comparison.
	 * @param rhs The right hand side of this comparison.
	 * @return True if lhs is less than rhs, false if it is not, undefined if
	 * this operation cannot be done.
	 */
	public static FuzzyBoolean lessThan(Literal lhs, Literal rhs){
		
		if(lhs.type != rhs.type || lhs.isNull() != rhs.isNull())
			return new FuzzyBoolean(0.5f);

		if(lhs.compareTo(rhs) < 0)
			return new FuzzyBoolean(1);
		
		return new FuzzyBoolean(0);
	}
	
	/**
	 * Creates a FuzzyBoolean representing whether the lhs literal is less than or equal to the
	 * rhs literal.
	 * @param lhs The left hand side of this comparison.
	 * @param rhs The right hand side of this comparison.
	 * @return True if lhs is less than or equal to rhs, false if it is not, undefined if
	 * this operation cannot be done.
	 */
	public static FuzzyBoolean lessThanOrEqualTo(Literal lhs, Literal rhs){
		
		if(lhs.type != rhs.type || lhs.isNull() != rhs.isNull())
			return new FuzzyBoolean(0.5f);

		if(lhs.compareTo(rhs) <= 0)
			return new FuzzyBoolean(1);
		
		return new FuzzyBoolean(0);
	}
	
	/**
	 * Creates a FuzzyBoolean representing whether the lhs literal is equal to the
	 * rhs literal.
	 * @param lhs The left hand side of this comparison.
	 * @param rhs The right hand side of this comparison.
	 * @return True if lhs is equal to rhs, false if it is not, undefined if
	 * this operation cannot be done.
	 */
	public static FuzzyBoolean equalTo(Literal lhs, Literal rhs){
		
		if(lhs.isNull() && rhs.isNull())
			return new FuzzyBoolean(1);
		
		if(lhs.type != rhs.type || lhs.isNull() != rhs.isNull())
			return new FuzzyBoolean(0.5f);
		
		if(lhs.compareTo(rhs) == 0)
			return new FuzzyBoolean(1);
		
		return new FuzzyBoolean(0);
	}
	
	/**
	 * Creates a FuzzyBoolean representing whether the lhs literal is not equal to the
	 * rhs literal.
	 * @param lhs The left hand side of this comparison.
	 * @param rhs The right hand side of this comparison.
	 * @return True if lhs is not equal to rhs, false if it is, undefined if
	 * this operation cannot be done.
	 */
	public static FuzzyBoolean notEqualTo(Literal lhs, Literal rhs){
		
		if(lhs.type != rhs.type || lhs.isNull() != rhs.isNull())
			return new FuzzyBoolean(0.5f);
		
		if(lhs.compareTo(rhs) != 0)
			return new FuzzyBoolean(1);

		return new FuzzyBoolean(0);
	}
}
