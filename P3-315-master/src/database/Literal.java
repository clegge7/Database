package database;

import java.io.IOException;

import database.io.DatabaseInputStream;
import database.io.DatabaseOutputStream;
import database.io.Writable;

/**
 * A wrapper for the individual elements stored by this database.
 * A literal has a value and type and uses type checking within its
 * set methods to ensure stability.
 */
public class Literal implements Writable, Comparable<Literal>{

	private Object value;
	public final AttributeType type;
	
	/**
	 * Construct a null Literal with the specified type.
	 * @param type The type of the null Literal.
	 */
	public Literal(AttributeType type){
		
		value = null;
		this.type = type;
	}
	
	/**
	 * Constructs a VARCHAR literal with the specified value.
	 * @param value The value of the VARCHAR literal.
	 */
	public Literal(String value){
		
		this.value = value;
		this.type = AttributeType.VARCHAR;
	}
	
	/**
	 * Constructs an INTEGER literal with the specified value
	 * @param value The value of the INTEGER literal.
	 */
	public Literal(int value){
		
		this.value = value;
		this.type = AttributeType.INTEGER;
	}
	
	/**
	 * Private constructor used to create a copy of this literal.
	 * @param l The Literal to be copied.
	 */
	private Literal(Literal l){
		
		this.value = l.value;
		this.type = l.type;
	}
	
	/**
	 * Constructs a Literal of the specified type by parsing the specified String.
	 * @param toParse The String to parse for the Literal value.
	 * @param type The type of the Literal
	 * @throws DatabaseException If there is an error parsing the specified String
	 * as a specified type.
	 */
	public Literal(String toParse, AttributeType type) throws DatabaseException{
		
		this.type = type;
		this.value = toParse.equals("NULL") ? null : type.parseLiteral(toParse);
	}
	
	/**
	 * Reads the value of the literal of the specified type from the specified
	 * stream.
	 * @param in The stream to read the value from.
	 * @param type The type of the literal.
	 * @throws IOException If there is an error reading from the stream.
	 */
	public Literal(DatabaseInputStream in, AttributeType type) throws IOException{
		
		this.value = type.readLiteral(in);
		this.type = type;
	}
	
	/**
	 * Returns the raw value of this literal.
	 * @return The value of this literal.
	 */
	protected Object getValue(){
		
		return value;
	}
	
	/**
	 * Casts the raw value of this literal to a string and returns the result.
	 * @return The string representation of this literal's value.
	 * @throws DatabaseException If this literal is not of type VARCHAR.
	 */
	public String asVarChar() throws DatabaseException{
		
		if(type != AttributeType.VARCHAR)
			throw new DatabaseException("Tried to get value of " + type + " as VARCHAR");
		
		return (String) value;
	}
	
	/**
	 * Casts the raw value of this literal to an integer and returns the result.
	 * @return The string representation of this literal's value.
	 * @throws DatabaseException If this literal is not of type INTEGER.
	 */
	public Integer asInteger() throws DatabaseException{
		
		if(type != AttributeType.INTEGER)
			throw new DatabaseException("Tried to get value of " + type + " as INTEGER");
		
		return (Integer) value;
	}
	
	/**
	 * Sets the raw value of this literal to the specified string.
	 * @param value The new value of this literal.
	 * @throws DatabaseException If this literal is not of type VARCHAR.
	 */
	protected void setValue(String value) throws DatabaseException{
		
		if(type != AttributeType.VARCHAR)
			throw new DatabaseException("Tried to set value of " + type + " as VARCHAR");
		
		this.value = value;
	}
	
	/**
	 * Sets the raw value of this literal to the specified integer.
	 * @param value The new value of this literal.
	 * @throws DatabaseException If this literal is not of type INTEGER.
	 */
	protected void setValue(Integer value) throws DatabaseException{
		
		if(type != AttributeType.INTEGER)
			throw new DatabaseException("Tried to set value of " + type + " as INTEGER");
		
		this.value = value;
	}
	
	/**
	 * Checks if the raw value of this Literal is null.
	 */
	public boolean isNull(){
		
		return value == null;
	}
	
	/**
	 * Sets the raw value of this literal to null.
	 */
	protected void setNull(){
		
		value = null;
	}
	
	/**
	 * Creates a copy of this Literal
	 * @return A new Literal with the same value and type as this Literal.
	 */
	protected Literal copy(){
		return new Literal(this);
		
	}

	@Override
	public void write(DatabaseOutputStream out) throws IOException{
		
		type.writeLiteral(out, value);
	}
	
	@Override
	public String toString(){
		
		if(value == null)
			return "NULL";
		
		return value.toString();
	}

	@Override
	public int compareTo(Literal o){

		if(value == null && o.value == null)
			return 0;
		
		if(value == null)
			return 1;
		
		if(o.value == null)
			return -1;
		
		if(o.type != type)
			return type.ordinal()-o.type.ordinal();
		
		return type.compareLiterals(value, o.value);
	}

	@Override
	public boolean equals(Object o){
		
		if(o instanceof Literal)
			return compareTo((Literal) o) == 0;
		
		return false;
	}
}
